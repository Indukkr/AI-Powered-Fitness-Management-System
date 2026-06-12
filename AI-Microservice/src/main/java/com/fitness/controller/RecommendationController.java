package com.fitness.controller;

import com.fitness.model.Recommendation;
import com.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/user/{userId}")
    public List<Recommendation> getUserRecommendation(@PathVariable String userId){
        return recommendationService.getUserRecommendation(userId);
    }

    @GetMapping("/activity/{activityId}")
    public Recommendation getActivityRecommendation(@PathVariable String activityId){
        return recommendationService.getActivityRecommendation(activityId);
    }
}
