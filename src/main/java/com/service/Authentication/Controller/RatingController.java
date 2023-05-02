package com.service.Authentication.Controller;

import com.service.Authentication.Entities.Rating;
import com.service.Authentication.Services.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
public class RatingController {
    @Autowired
    private UserRatingService _userRatingService;

    @GetMapping("/getAllRatings")
    public List<Rating> GetRating(){
        return _userRatingService.getAllRatings();
    }

    @GetMapping("/getRatingByUserId/{id}")
    public List<Rating> GetRatingByUserId(@PathVariable int id){
        return _userRatingService.getRatingByUserId(id);
    }

    @GetMapping("/getRating/{id}")
    public Rating GetRatingById(@PathVariable int id){
        return _userRatingService.getSingleRating(id);
    }

    @PostMapping("/addRating")
    public ResponseEntity<String> AddRating(@RequestBody Rating rating){
         return _userRatingService.addRating(rating);
    }

    @DeleteMapping("/deleteRating/{id}")
    public ResponseEntity<String> DeleteRating(@PathVariable int id){
        return _userRatingService.removeRating(id);
    }

    @PutMapping("/updateRating")
    public ResponseEntity<String> UpdateRating(@RequestBody Rating rating){
        return _userRatingService.updateRating(rating);
    }
}
