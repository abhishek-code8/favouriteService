package com.stackroute.favouritegif.service;


import com.stackroute.favouritegif.model.GifUser;
import com.stackroute.favouritegif.repository.GifUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GifUserService {

    @Autowired
    private GifUserRepository gifUserRepository;


    public List<String> userFavourites(String userId) throws Exception {
        if(gifUserRepository.findById(userId).isEmpty()){
            throw new Exception("User not found");
        }
        else{
            Optional<GifUser> tempUser = gifUserRepository.findById(userId);
            return tempUser.get().getGifId();
        }
    }
    public GifUser addNewUser(GifUser gifUser){
        System.out.println(gifUserRepository.findById(gifUser.getUserId()));
        if(gifUserRepository.findAll().size()==0){
            gifUserRepository.save(gifUser);
            return gifUser;
        }

        else if(gifUserRepository.findById(gifUser.getUserId()).isPresent()){
            gifUserRepository.save(gifUser);
            return null;
        }
        return null;

    }

    public boolean addFavourite(GifUser user){
        if(gifUserRepository.findAll().size()==0){
            gifUserRepository.save(user);
        }
        else if(gifUserRepository.findById(user.getUserId()).isEmpty()){
            gifUserRepository.save(user);
        }
        else {
            Optional<GifUser> userClass = gifUserRepository.findById(user.getUserId());
            List<String> giflist = new ArrayList<>();
            giflist = userClass.get().getGifId();
            giflist.addAll(user.getGifId());
            GifUser userInsert = new GifUser(user.getUserId(), giflist);
            GifUser checkUser = gifUserRepository.save(userInsert);
        }
        return true;

    }
}
