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


    public List<String> userFavourites(GifUser gifUser) throws Exception {
        if(gifUserRepository.findById(gifUser.getUserId()).isEmpty()){
            throw new Exception("User not found");
        }
        else{
            Optional<GifUser> tempUser = gifUserRepository.findById(gifUser.getUserId());
            return tempUser.get().getGifId();
        }
    }
    public GifUser addNewUser(GifUser gifUser){


            gifUserRepository.save(gifUser);
            return gifUser;

    }

    public boolean addFavourite(GifUser user){


            Optional <GifUser> userClass = gifUserRepository.findById(user.getUserId());
            List<String> giflist = new ArrayList<>();
            giflist = userClass.get().getGifId();
            giflist.addAll(user.getGifId());
            GifUser userInsert = new GifUser(user.getUserId(),giflist);
            GifUser checkUser =  gifUserRepository.save(userInsert);
            return true;

    }
}
