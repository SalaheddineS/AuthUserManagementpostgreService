package com.service.Authentication.Services;

import com.service.Authentication.Entities.Rating;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserRatingService {
    ResponseEntity<String> addRating(Rating rating);
    ResponseEntity<String> removeRating(int RatingId);
    List<Rating> getAllRatings();
    Rating getSingleRating(int RatingId);
    List<Rating> getRatingByUserId(int UserId);
    ResponseEntity<String> updateRating(Rating rating);
}
