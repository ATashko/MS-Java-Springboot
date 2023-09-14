package com.dh.catalogservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@RequiredArgsConstructor
@Data
@Document

public class Movie {

    @MongoId
    Long id;
    String name;
    String genre;
    String urlStream;
}
