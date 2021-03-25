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
            return tempUser.get().getGifIds();
        }
    }

    public boolean addFavourite(String userId, String gifId){
        if(gifUserRepository.findById(userId).isEmpty()){
            return false;
        }
        else{
            Optional <GifUser> userClass = gifUserRepository.findById(userId);
            List<String> giflist = new ArrayList<>();
            giflist = userClass.get().getGifIds();
            giflist.add(gifId);
            GifUser userInsert = new GifUser(userId,giflist);
            if(gifUserRepository.insert(userInsert)==null){
                return false;
            }
            return true;
        }
    }
}
