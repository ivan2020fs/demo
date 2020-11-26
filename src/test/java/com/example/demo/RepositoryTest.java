package com.example.demo;

import com.example.demo.models.Rebel;
import com.example.demo.repositories.RebelRepository;
import com.example.demo.utils.File;
import com.example.demo.utils.Logs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class RepositoryTest {
    @Mock
    private File file;

    @Mock
    private Logs logs;

    @InjectMocks
    private RebelRepository rebelRepository;

    @Test
    public void getRebelsTest(){
        List<String> response = new ArrayList<>();
        try {
            Mockito.when(file.readFile()).thenReturn(response);
            assertEquals(response,rebelRepository.getRebels());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendRebelTest(){
        Rebel rebel = new Rebel("Ivan","Tierra");
    Mockito.when(file.writeFile(rebel)).thenReturn(true);
    assertEquals(true,rebelRepository.sendRebel(rebel));
    }
}
