package com.example.demo.controllers;

import com.example.demo.presenters.RebelPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RebelController {
    @Autowired
    private RebelPresenter rebelPresenter;

    //Realiza el GET devolviendo lo que le envie el presenter
    @GetMapping(value = "getRebels")
    public List<String> getRebels() {
        return rebelPresenter.getRebels();
    }

    //Realiza el POST devolviendo lo que le envie el presenter
    @PostMapping(value = "sendRebel")
    public Boolean postRebels(@RequestBody List<String> body) {
        System.out.println(body);
        return rebelPresenter.saveRebel(body);
    }
}
