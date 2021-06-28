package com.htw.whoisdown.user;

import com.htw.whoisdown.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserApp findByUsername(String username){
        UserApp user = userRepository.findByUsername(username);
        if(user == null){
            throw new UserNotFoundException(username);
        }
        return user;
    }
}
