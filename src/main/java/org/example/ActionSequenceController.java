package org.example;

import java.util.ArrayList;
import java.util.Stack;

import org.example.Service.ShapeDTO;
import org.example.Service.ShapeFactory;
import org.example.entity.Shape;
import org.example.entity.Shapes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class ActionSequenceController {
    private ArrayList<Shape> latestState = new ArrayList<>();

    @Autowired
    ShapeFactory shapeFactory;

    ActionSequenceController() {
        history.add(new ArrayList<Shape>(0));
    }

    public ArrayList<Shape> getLatestState() {
        return history.get( history.size()-1 );
    }

    public void setLatestState(ArrayList<Shape> latestState) {
        if (currentIndex < history.size() - 1) {
            history.subList(currentIndex + 1 , history.size()).clear();// if an undo was performed and then an action a redo should be prevented
        }
        currentIndex ++;


        history.add(latestState);
        System.out.println(history);
    }

    private ArrayList<ArrayList<Shape>> history = new ArrayList<>(1);
    private int currentIndex = 0;

    @PostMapping("/function/draw")
    public void drawShape(@RequestBody ShapeDTO temp1) {

        Shape shape = shapeFactory.getShape(temp1);

        if (currentIndex < history.size() - 1) {
            history.subList(currentIndex + 1 , history.size()).clear();// if an undo was performed and then an action a redo should be prevented
        }
        currentIndex ++;

        latestState = new ArrayList<>(history.get(currentIndex ));

        String temp = shape.getId();
        for(int i = 0; i < latestState.size() ; i++){
            if(temp.equals(latestState.get(i).getId())){
                latestState.remove(i);
                break;
            }
        }
        latestState.add(shape);
        history.add(  latestState );


    }
    @GetMapping("/function/undo")
    public ArrayList<Shape> undo() {
        if (currentIndex >= 1) {
            currentIndex--;


            return history.get(currentIndex);

        }
        return history.get( 0 );
    }
    @GetMapping("/function/redo")
    public ArrayList<Shape> redo() {

        if (currentIndex < history.size() - 1) {
            currentIndex++;

            return history.get(currentIndex);
        }
        return history.get( history.size()-1 );
    }

}