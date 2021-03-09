package com.udacity.DogDataApi.web;

import com.udacity.DogDataApi.entity.Dog;
import com.udacity.DogDataApi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getAllDogNames(){
        List<String> list = dogService.retrieveDogName();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllDogBreeds(){
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedById(@PathVariable Long id){
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }
}
