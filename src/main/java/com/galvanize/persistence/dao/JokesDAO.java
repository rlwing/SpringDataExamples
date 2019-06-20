package com.galvanize.persistence.dao;

import com.galvanize.persistence.entities.Joke;

import java.util.List;
import java.util.Optional;

public interface JokesDAO {
    Joke save(Joke joke);
    Optional<Joke> findById(Long id);
    List<Joke> findAll();
    long count();
    void delete(Joke joke);
    boolean existsById(Long id);
    Joke getRandomJoke();
}
