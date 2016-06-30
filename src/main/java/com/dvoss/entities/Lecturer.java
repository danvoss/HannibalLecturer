package com.dvoss.entities;

import javax.persistence.*;

/**
 * Created by Dan on 6/30/16.
 */
@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String topic;

    @Column(nullable = false)
    String image;

    @ManyToOne
    Review review;

    public Lecturer() {
    }

    public Lecturer(int id, String name, String topic, String image, Review review) {
        this.id = id;
        this.name = name;
        this.topic = topic;
        this.image = image;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
