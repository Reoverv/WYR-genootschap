package com.wyr.genootschap.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.time.LocalDate;
import java.util.List;

public class Wyr {

    @Id
    public String id;

    public com.wyr.genootschap.models.user user;
    public String title;

    public List<String> prompts;
    public LocalDate timeCreated;
    public List<reaction> reactions;
    public String channelId;
    public String messageId;

    public Wyr(com.wyr.genootschap.models.user user, String title, List<String> prompts, LocalDate timeCreated) {
        this.user = user;
        this.title = title;
        this.prompts = prompts;
        this.timeCreated = timeCreated;
    }


    public Wyr(com.wyr.genootschap.models.user user, String title, List<String> prompts, LocalDate timeCreated, List<reaction> reactions, String channelId, String messageId) {
        this.user = user;
        this.title = title;
        this.prompts = prompts;
        this.timeCreated = timeCreated;
        this.reactions = reactions;
        this.channelId = channelId;
        this.messageId = messageId;
    }

    @PersistenceCreator


    public Wyr() {
        super();
    }
}
