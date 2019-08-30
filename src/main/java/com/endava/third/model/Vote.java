package com.endava.third.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="created_at")
    private String when;

    @JsonProperty("user")
    private String customer;

    @JsonProperty("movie_id")
    private Integer movieId;

    private String rating;
}
