package com.wyr.genootschap.controller;


import com.wyr.genootschap.models.Wyr;
import com.wyr.genootschap.repository.WyrRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173/")
@RestController("/api")
public class WyrController {


    private final WyrRepository wyrRepository;


    public WyrController(WyrRepository wyrRepository) {
        this.wyrRepository = wyrRepository;
    }

    @GetMapping("/getAllWyr")
    public List<Wyr> getAllWyr(){
        return wyrRepository.findAll();
    }

}
