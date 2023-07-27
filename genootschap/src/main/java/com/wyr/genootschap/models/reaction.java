package com.wyr.genootschap.models;

import org.springframework.data.annotation.PersistenceCreator;

public class reaction {


    public String emoji;
    public String count;

    @PersistenceCreator
    public reaction(String emoji, String count) {
        this.emoji = emoji;
        this.count = count;
    }

    public reaction(String emoji) {
        this.emoji = emoji;
        this.count = "0";
    }


}
