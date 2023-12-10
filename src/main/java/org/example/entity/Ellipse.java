package org.example.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.Service.ShapeDTO;

@JsonTypeName("ellipse")
public class Ellipse extends Shape {

    public Ellipse(ShapeDTO data) {
        super(data);
    }
    
    public Ellipse() {}

}
