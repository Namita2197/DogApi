package com.udacity.DogDataApi.service;

import com.udacity.DogDataApi.entity.Dog;
import com.udacity.DogDataApi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService{
    @Autowired
    DogRepository dogRepository;

    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }
    public List<String> retrieveDogBreed(){
        return (List<String>) dogRepository.findAllBreed();
    }
    public List<String> retrieveDogName(){
        return (List<String>) dogRepository.findAllName();
    }
}
