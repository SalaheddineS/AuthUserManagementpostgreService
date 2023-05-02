package com.service.Authentication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Ratings")
public class Rating {
    @Id
    @GeneratedValue
    int Id;
    @NotNull
    int ratedId;
    @NotNull
    int rating;
    @NotNull
    int raterId;

    public Rating() {
    }

    public Rating(int ratedId, int rating, int raterId) {
        this.ratedId = ratedId;
        this.rating = rating;
        this.raterId = raterId;
    }
    public Rating(int id, int ratedId, int rating, int raterId) {
        this.Id = id;
        this.ratedId = ratedId;
        this.rating = rating;
        this.raterId = raterId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getRatedId() {
        return ratedId;
    }

    public void setRatedId(int ratedId) {
        this.ratedId = ratedId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRaterId() {
        return raterId;
    }

    public void setRaterId(int raterId) {
        this.raterId = raterId;
    }
}
