package com.stackroute.favouritegif.controller;

import com.stackroute.favouritegif.model.GifUser;
import com.stackroute.favouritegif.service.GifUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/gifs")
public class GifUserController {

    @Autowired
    private GifUserService gifUserService;

    public GifUserController() {

    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllGifs(@PathVariable String userId){
        try{
            List<String> gifList = gifUserService.userFavourites(userId);
            return new ResponseEntity<>(gifList,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> addGifs(@RequestBody GifUser body){
        boolean added = gifUserService.addFavourite(body);
        System.out.println(added);
        if(added){
            return new ResponseEntity<>(body,HttpStatus.CREATED);

        }
        else{
            return new ResponseEntity<>("Not added",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
