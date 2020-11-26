package com.example.demo;

import com.example.demo.config.Properties;
import com.example.demo.exceptions.NoRecordsInFileException;
import com.example.demo.models.Rebel;
import com.example.demo.utils.File;
import com.example.demo.utils.Logs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FileTest {
    @Mock
    private Properties properties;
    @Mock
    private Logs logs;

    @InjectMocks
    private File file;


    @Test
    public void readFileTest(){
        Mockito.when(properties.getFileName()).thenReturn("databaseTest.txt");
        List<String> response = new ArrayList<>();
        response.add("test de la función readfile");
        try {
            assertEquals(file.readFile(),response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoRecordsInFileException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeFile(){
        Mockito.when(properties.getFileName()).thenReturn("databaseTestWrite.txt");
        Rebel rebel = new Rebel("Ivan","Tierra");
        Boolean response = file.writeFile(rebel);
        assertEquals(true,response);
        try {
            List<String> dummyReadList = new ArrayList<>();
            List<String> responseList= file.readFile();
            dummyReadList.add(rebel.generarFrase());
            assertEquals(responseList.get(responseList.size()-1),dummyReadList.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoRecordsInFileException e) {
            e.printStackTrace();
        }
    }

}
