package com.wyr.genootschap.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;


public class user {


    @Id
    public String id;
    public String discordId;
    public String naam;
    public String profilePicture;

    public user(String discordId) {
        this.discordId = discordId;
    }

    @PersistenceCreator
    public user(String discordId, String naam, String profilePicture) {
        this.discordId = discordId;
        this.naam = naam;
        this.profilePicture = profilePicture;
    }

}


