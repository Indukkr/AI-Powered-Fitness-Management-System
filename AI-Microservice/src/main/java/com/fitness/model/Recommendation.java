package com.fitness.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "recommendations")
public class Recommendation {

    @Id
    private String id;

    private String activityId;
    private String userId;
    private String recommendation;
    private List<String> suggestions;
    private List<String> safety;
    private LocalDateTime createdAt;


}
