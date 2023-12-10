package org.example.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.Service.ShapeDTO;

@JsonTypeName("square")
public class Square extends Shape {

    public Square(ShapeDTO data) {
        super(data);
    }

    public Square() {
    }
}
