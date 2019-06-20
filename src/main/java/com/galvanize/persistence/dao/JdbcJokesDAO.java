package com.galvanize.persistence.dao;

import com.galvanize.persistence.entities.Joke;
import com.galvanize.persistence.entities.JokeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcJokesDAO implements JokesDAO{
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertJoke;

    @Autowired
    public JdbcJokesDAO(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);

        insertJoke = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("jokes")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Joke save(Joke joke) {

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("category", joke.getCategory());
        parameters.put("joke", joke.getJoke());
        parameters.put("source", joke.getSource());
        Integer newId = (Integer) insertJoke.executeAndReturnKey(parameters);
        joke.setId(Long.valueOf(newId));
        return joke;

    }

    @Override
    public Optional<Joke> findById(Long id) {
        if (!existsById(id)) return Optional.empty();
        return Optional.of(jdbcTemplate.queryForObject(
                "SELECT * FROM jokes WHERE joke_id=?",
                new RowMapper<Joke>() {  // Java 7 anonymous inner class
                    @Override
                    public Joke mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Joke(rs.getLong("joke_id"),
                                        JokeCategory.valueOf(rs.getString("category")),
                                        rs.getString("joke"),
                                        rs.getString("source"));
                    }
                },
                id));
    }

    @Override
    public List<Joke> findAll() {
        return jdbcTemplate.query("SELECT * FROM jokes",
         (rs, rowNum) -> new Joke(rs.getLong("joke_id"), // Java 8 lambda expression
                        JokeCategory.valueOf(rs.getString("category")),
                                rs.getString("joke"),
                                rs.getString("joke")));
}

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from jokes", Long.class);
    }

    @Override
    public void delete(Joke joke) {
        jdbcTemplate.update("delete from jokes where joke_id = ?", joke.getId());
    }

    @Override
    public boolean existsById(Long id) {
        return jdbcTemplate.queryForObject("select exists(select 1 from jokes where joke_id = ?)", Boolean.class, id);
    }

    @Override
    public Joke getRandomJoke() {
        List<Joke> jokes = jdbcTemplate.query("SELECT * from jokes order by RAND() LIMIT 1",
                (rs, rowNum) -> new Joke(rs.getLong("joke_id"), // Java 8 lambda expression
                        JokeCategory.valueOf(rs.getString("category")),
                        rs.getString("joke"),
                        rs.getString("source")));
        return jokes.isEmpty() ? null : jokes.get(0);
    }
}
