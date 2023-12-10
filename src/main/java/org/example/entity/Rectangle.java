package org.example.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.Service.ShapeDTO;

@JsonTypeName("rectangle")
public class Rectangle extends Shape {

    public Rectangle(ShapeDTO data) {
        super(data);

    }
    
    public Rectangle() {}

}
