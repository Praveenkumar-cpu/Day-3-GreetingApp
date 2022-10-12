package com.bridgelab.greetingapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue
    private Long id;
    private String content;

    public Greeting(String content) {
        super();
        this.id = id;
        this.content = content;
    }

    public Greeting(Greeting greeting) {
        this.id = greeting.id;
        this.content = greeting.content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
