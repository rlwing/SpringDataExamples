package com.galvanize.persistence.entities;

public class Joke {

    private Long id;
    private JokeCategory category;
    private String joke;
    private String source;

    public Joke() { }

    public Joke(Long id, JokeCategory category, String joke, String source) {
        this.id = id;
        this.category = category;
        this.joke = joke;
        this.source = source;
    }

    public Joke(JokeCategory category, String joke, String source) {
        this.category = category;
        this.joke = joke;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "category='" + category + '\'' +
                ", joke='" + joke + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JokeCategory getCategory() {
        return category;
    }

    public void setCategory(JokeCategory category) {
        this.category = category;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
