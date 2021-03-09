package com.udacity.DogDataApi.service;

import com.udacity.DogDataApi.entity.Dog;

import java.util.List;

public interface DogService {
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogBreed();
    List<String> retrieveDogName();
}
