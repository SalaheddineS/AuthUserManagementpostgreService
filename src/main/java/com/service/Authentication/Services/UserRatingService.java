package com.service.Authentication.Services;

import com.service.Authentication.Entities.Rating;
import com.service.Authentication.Repositories.PostGreRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRatingService implements IUserRatingService{
    @Autowired
    private PostGreRatingRepo _postGreRatingRepo;

    @Override
    public ResponseEntity<String> addRating(Rating rating) {
        try {
            _postGreRatingRepo.save(rating);
            return ResponseEntity.ok("Rating added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while adding rating");
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> removeRating(int RatingId) {
        try {
            _postGreRatingRepo.deleteById(RatingId);
            return ResponseEntity.ok("Rating deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while deleting rating");
        }
    }

    @Override
    public List<Rating> getAllRatings() {
        return _postGreRatingRepo.findAll();
    }

    @Override
    public Rating getSingleRating(int RatingId) {
        try {
            return _postGreRatingRepo.findById(RatingId);
        } catch (Exception e) {
            throw new RuntimeException("Rating not found or Error while getting rating");
        }

    }

    @Override
    public List<Rating> getRatingByUserId(int UserId) {
        return _postGreRatingRepo.findAllByRatedId(UserId);
    }

    @Override
    public ResponseEntity<String> updateRating(Rating rating) {
        try{
       Rating response= _postGreRatingRepo.findByRatedIdAndRaterId(rating.getRatedId(), rating.getRaterId());
         response.setRating(rating.getRating());
       _postGreRatingRepo.save(response);
            return ResponseEntity.ok("Rating updated successfully");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error while updating rating");
        }

    }
}
