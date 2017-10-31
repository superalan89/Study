package com.example.asuper.firebasebasic2;

/**
 * Created by super on 2017-10-31.
 */


public class User {
    String id;
    String token;

    public User(){
        // default for firebase realtime database
    }

    public User(String id, String token){
        this.id = id;
        this.token = token;
    }
}
