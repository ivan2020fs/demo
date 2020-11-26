package com.example.demo.repositories;

import com.example.demo.exceptions.NoRecordsInFileException;
import com.example.demo.models.Rebel;
import com.example.demo.utils.File;
import com.example.demo.utils.LogType;
import com.example.demo.utils.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class RebelRepository {

    @Autowired
    private File file;

    @Autowired
    private Logs logs;

    public List<String> getRebels() {
        List<String> respuesta = new ArrayList<>();
        logs.writeLog(LogType.INFO,"Buscando en la base de datos");
        try {
            respuesta = file.readFile();
            return respuesta;
        }catch (NullPointerException e){
            logs.writeLog(LogType.ERROR,"No existe el fichero");

            respuesta = new ArrayList<>();
            respuesta.add("No existe el fichero");
            return respuesta;
        }
        catch (IOException e) {
            logs.writeLog(LogType.ERROR,"Error en la lectura del fichero");

            respuesta = new ArrayList<>();
            respuesta.add(e.getMessage());
            return respuesta;
        } catch (NoRecordsInFileException e) {
            logs.writeLog(LogType.WARN,"No hay registros en el registro");
            respuesta = new ArrayList<>();
            respuesta.add(e.getMessage());
            return respuesta;
        }
    }

    public Boolean sendRebel(Rebel rebel) {
            logs.writeLog(LogType.INFO,"Resgistrando ["+rebel.generarFrase()+ "] en la base de datos");
            return file.writeFile(rebel);
    }
}
