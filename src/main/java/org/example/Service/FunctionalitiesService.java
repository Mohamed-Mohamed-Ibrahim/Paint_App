package org.example.Service;

import org.example.ActionSequenceController;
import org.example.entity.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class FunctionalitiesService {

    public String getLoad() {
        return loadLoc;
    }

    public void setLoad(String load) {
        this.loadLoc = load;
    }

    private Shape shape;

    private String loadLoc;

    @Autowired
    CloneFactory cloneFactory;

    @Autowired
    ShapeFactory factory;

    @Autowired
    ActionSequenceController actionSequenceController;

    @Autowired
    SaveLoadService save;

    @Autowired
    SaveLoadService load;


    public org.example.entity.Shape getShape() {
        return shape;
    }

    public void setShape(ShapeDTO data) {
        System.out.println(data.shape);
        if ( data.shape != null ) {
            Shape shape = factory.getShape(data);

            this.shape = shape;
        } else {
            this.shape.setId(data.id);
        }
    }

    public void delete(){

        ArrayList<Shape> latestState = new ArrayList<>( actionSequenceController.getLatestState() );

        int size = latestState.size();

        for (int i=0; i<size; i++){

            if( this.shape.getId().equals( latestState.get(i).getId() ) ){
                latestState.remove(i);
                break;
            }

        }

        if( size != latestState.size() )
            actionSequenceController.setLatestState( latestState );

    }

    public void copy(){

        ArrayList<Shape> latestState = new ArrayList<>( actionSequenceController.getLatestState() );

        Shape newShape = cloneFactory.getCopy( this.shape );

        latestState.add(newShape);

        actionSequenceController.setLatestState( latestState );

    }

    public void change(){

        ArrayList<Shape> latestState = new ArrayList<>( actionSequenceController.getLatestState() );

        int size = latestState.size();

        String ID = this.shape.getId();

        for (int i=0; i<size; i++){

            if( ID.equals( latestState.get(i).getId() ) ){
                latestState.remove(i);
                break;
            }

        }

        latestState.add( this.shape );
        actionSequenceController.setLatestState( latestState );

    }

    public void save(String saveLoc, int format){

        if( saveLoc.equals(null) )
            return;

        if( format == 1 ){

            save.saveJson( actionSequenceController.getLatestState(), saveLoc+".json");

        } else if ( format == 2 ) {

            save.saveXML(actionSequenceController.getLatestState(), saveLoc+".xml");

        } else if ( format == 3 ) {

            save.saveJson( actionSequenceController.getLatestState(), saveLoc+".json");
            save.saveXML(actionSequenceController.getLatestState(), saveLoc+".xml");

        }

    }

    public ArrayList<Shape> load(String loadLoc){

        if( loadLoc.contains(".json") ){

            ArrayList<Shape> program = load.loadJson( loadLoc );

            actionSequenceController.setLatestState(program);

            return program;

        } else if ( loadLoc.contains(".xml") ) {

            ArrayList<Shape> program = load.loadXML( loadLoc );

            actionSequenceController.setLatestState(program);

            return program;

        }

        return new ArrayList<Shape>();

    }

}
