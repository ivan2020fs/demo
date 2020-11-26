package com.example.demo.utils;

import com.example.demo.config.Properties;
import com.example.demo.exceptions.NoRecordsInFileException;
import com.example.demo.models.Rebel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class File {
    @Autowired
    private Properties properties;
    @Autowired
    private Logs logs;

    //función para leer el archivo de registro de rebeldes
    public List<String> readFile() throws IOException, NoRecordsInFileException {

        FileReader file = new FileReader(properties.getFileName());
        List<String> respuesta = new ArrayList<>();

        int c = 0;
        String frase = "";

        while (c != -1) {
            c = file.read();

            char letter = (char) c;

            if (letter == '\n') {
                respuesta.add(frase);
                frase = "";
            } else {
                frase += letter;
            }
        }

        file.close();
        if (respuesta.size() == 0) {
            throw new NoRecordsInFileException(properties.getExceptionMessage());
        }
        return respuesta;
    }

    //función para crear/modificar el archivo de registro de rebeldes en la carpeta del proyecto
    public boolean writeFile(Rebel rebel){

        FileWriter file = null;
        try {
            file = new FileWriter(properties.getFileName(), true);
            for (int i = 0; i < rebel.generarFrase().length(); i++) {
                file.write(rebel.generarFrase().charAt(i));
            }
            file.write("\n");
            file.close();
            return true;
        } catch (IOException e) {
            logs.writeLog(LogType.ERROR,"Error en la escritura del fichero");
            return false;
        }
    }
}
