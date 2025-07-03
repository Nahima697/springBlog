package com.hb.cda.project_blog.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String title;
    @Lob
    String content;
    LocalDate postedAt;

    @ManyToOne
    User author;

    public Post() {}
    public Post(String title, String content, LocalDate postedAt) {
        this.title = title;
        this.content = content;
        this.postedAt = postedAt;
    }

    public Post(String id, String title, String content, LocalDate postedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postedAt = postedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }

    public User getUser() {
        return author;
    }

    public void setUser(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Post post)) return false;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(postedAt, post.postedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, postedAt);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postedAt=" + postedAt +
                '}';
    }
}
