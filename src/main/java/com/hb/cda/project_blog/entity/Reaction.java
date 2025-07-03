package com.hb.cda.project_blog.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String type;
    @ManyToOne
    Post post;
    @ManyToOne
    User user;

    public Reaction() {}
    public Reaction(String type) {
        this.type = type;
    }

    public Reaction(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reaction reaction)) return false;
        return Objects.equals(id, reaction.id) && Objects.equals(type, reaction.type) && Objects.equals(post, reaction.post) && Objects.equals(user, reaction.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, post, user);
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
