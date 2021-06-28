package com.htw.whoisdown.user;

public class UserNotFoundException extends RuntimeException{

    UserNotFoundException(String username){
        super("Could not find user " + username);
    }
}
