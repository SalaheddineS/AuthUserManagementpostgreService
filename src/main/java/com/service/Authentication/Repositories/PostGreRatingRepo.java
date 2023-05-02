package com.service.Authentication.Repositories;

import com.service.Authentication.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostGreRatingRepo extends JpaRepository<Rating,Integer> {
    List<Rating> findAllByRatedId(int ratedId);
    Rating findById(int ratingId);
    Rating findByRatedIdAndRaterId(int ratedId, int raterId);

}
