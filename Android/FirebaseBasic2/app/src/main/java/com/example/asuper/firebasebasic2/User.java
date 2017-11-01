package com.example.asuper.firebasebasic2;

/**
 * Created by super on 2017-10-31.
 */


public class User {
    String id;
    String token;
    String email;


    public User(){
        // default for firebase realtime database
    }

    public User(String id, String token, String email){
        this.id = id;
        this.token = token;
        this.email = email;
    }
}
