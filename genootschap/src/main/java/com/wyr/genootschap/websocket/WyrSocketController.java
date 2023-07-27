package com.wyr.genootschap.websocket;

import com.wyr.genootschap.models.Wyr;
import com.wyr.genootschap.repository.WyrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller()
public class WyrSocketController {




    @Autowired
    private WyrRepository wyrRepository;

    @MessageMapping("/wyr")
    @SendTo("/topic/receivewyr")
    public Wyr receiveWyr(Wyr wyr) throws Exception {

        Wyr WyrObject = new Wyr(wyr.user, wyr.title, wyr.prompts, LocalDate.now(), wyr.reactions, wyr.channelId, wyr.messageId);
        wyrRepository.save(WyrObject);

        return WyrObject;
    }
}
