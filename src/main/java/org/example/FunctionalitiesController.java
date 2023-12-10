package org.example;

import org.apache.tomcat.util.json.JSONParser;
import org.example.Service.FunctionalitiesService;
import org.example.Service.ShapeDTO;
import org.example.entity.SaveInfo;
import org.example.entity.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

@RestController
@CrossOrigin()
public class FunctionalitiesController {

    @Autowired
    FunctionalitiesService functionalitiesService;

    @PostMapping( value = "/function/shape" )
    public void getShape(@RequestBody ShapeDTO shape ){

        functionalitiesService.setShape( shape );

    }

    @PostMapping( value = "" )
    public void moveShape(@RequestBody ShapeDTO shape ){

        functionalitiesService.setShape( shape );

        if( functionalitiesService.getShape() == null ){
            return;
        }

        functionalitiesService.change();


    }

    @PostMapping( value = "/function/copy" )
    public void copyShape(@RequestBody ShapeDTO shape){

        functionalitiesService.setShape( shape );

        if( functionalitiesService.getShape() == null ){
            return;
        }

        functionalitiesService.copy();

    }

    @PostMapping( value = "/function/delete" )
    public void deleteShape(@RequestBody ShapeDTO shape){

        functionalitiesService.setShape( shape );

        if( functionalitiesService.getShape() == null ){
            return;
        }

        functionalitiesService.delete();

    }

    @PostMapping( value = "/function/save" )
    public void saveProgram(@RequestBody SaveInfo saveInfo){

        functionalitiesService.save(saveInfo.getSaveLoc(), saveInfo.getFormat());

    }

    @PostMapping( value = "/function/load" )
    public void saveProgram(@RequestBody String loadLoc){

        functionalitiesService.setLoad( loadLoc );

    }

    @GetMapping( value = "/function/load/program" )
    public ArrayList<Shape> saveProgram(){

        return functionalitiesService.load(functionalitiesService.getLoad() );

    }



}
