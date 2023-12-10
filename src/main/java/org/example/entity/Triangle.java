package org.example.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.Service.ShapeDTO;

@JsonTypeName("triangle")
public class Triangle extends Shape {

    public Triangle(ShapeDTO data) {
        super(data);
    }

    public Triangle() {}

}
