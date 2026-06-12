package com.fitness.dto.request;

import com.fitness.model.ENUM.ActivityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityRequest {
    @NotBlank(message = "userId should not be blank")
    private String userId;

    @NotNull(message = "ActivityType cannot be null")
    private ActivityType activityType;

    @Positive(message="duration can only be positive")
    private Integer duration;

    @Positive(message = "caloriesBurned can only be positive ")
    private Integer caloriesBurned;

    @NotNull(message = "startTime is required")
    private LocalDateTime startTime;

    private Map<String,Object> additionalMetrics;
}
