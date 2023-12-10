package org.example.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.entity.*;
import org.springframework.stereotype.Service;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaveLoadService {



    public void saveJson(ArrayList<Shape> program, String saveLoc) {

        ObjectMapper objectMapper = new ObjectMapper();

        Shapes shapes = new Shapes();

        shapes.setProgram(program);

        try {

            objectMapper.writeValue(new File(saveLoc), shapes);

        } catch ( Exception e ) {

            System.out.println(e.getMessage());


        }
    }
    public ArrayList<Shape> loadJson(String loadLoc) {

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(loadLoc+"load");


        Shapes program = null;

        try {

            File file = new File(loadLoc);
            program = objectMapper.readValue(file, Shapes.class);

            for ( Shape shape: program.getProgram() )
                System.out.println(shape.getId() + " " + shape.getShape());

        }catch ( Exception e ) {

            System.out.println(e.getMessage());
            System.exit(1);

        }
        return program.getProgram();

    }

    public void saveXML(ArrayList<Shape> program, String saveLoc) {

        Shapes shapes = new Shapes();

        shapes.setProgram(program);

        try {
            System.out.println(saveLoc+"___save");

            XmlMapper objectMapper = new XmlMapper();

            objectMapper.writeValue(new File(saveLoc), shapes);


        } catch ( Exception e ) {

            System.out.println(e.getMessage());

        }

    }

    public ArrayList<Shape> loadXML(String loadLoc) {


        try {
            System.out.println(loadLoc+"   load");

            File file = new File(loadLoc);

            XmlMapper xmlMapper = new XmlMapper();

            Shapes program = xmlMapper.readValue(file, Shapes.class);

            for ( Shape shape : program.getProgram() ){
                System.out.println( shape.getShape() );
                System.out.println( shape.getId() );
            }


            return program.getProgram();
        } catch ( Exception e ) {

            System.out.println(e.getMessage());

        }

        return new ArrayList<Shape>();

    }

}
