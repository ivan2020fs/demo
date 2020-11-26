package com.example.demo.presenters;

import com.example.demo.models.Rebel;
import com.example.demo.repositories.RebelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebelPresenter {
    @Autowired
    private RebelRepository rebelRepository;

    //Devuelve lo que le envia el repositorio
    public List<String> getRebels() {
        return rebelRepository.getRebels();
    }

    //Devuelve lo que le envia el repositorio
    public Boolean saveRebel(List<String> rebel) {
        return rebelRepository.sendRebel(new Rebel(rebel.get(0), rebel.get(1)));
    }
}
