package com.movie.movieapi.modal;

// import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    
    private ObjectId id;
    private String body;
    // private LocalDateTime created;
    // private LocalDateTime updated;

    public Reviews(String body) {
        this.body = body;
        // this.created = created;
        // this.updated = updated;
    }
}