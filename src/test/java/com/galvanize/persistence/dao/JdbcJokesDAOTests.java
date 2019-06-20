package com.galvanize.persistence.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JdbcJokesDAOTests {
    @Autowired
    private JokesDAO dao;

    @Test
    public void testGetJoke() {
        System.out.println(dao.getRandomJoke());
    }

    @Test
    public void testFindAllJokes() {
        dao.findAll().forEach(System.out::println);
    }
}
