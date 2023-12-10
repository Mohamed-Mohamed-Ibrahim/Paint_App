package org.example.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.Service.ShapeDTO;

@JsonTypeName("circle")
public class Circle extends Shape {

    public Circle(ShapeDTO data) {
        super(data);
    }

    public Circle() {}

}
