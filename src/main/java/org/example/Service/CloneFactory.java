package org.example.Service;

import org.example.entity.Shape;
import org.springframework.stereotype.Service;

@Service
public class CloneFactory {

    public Shape getCopy(Shape shape){

        return (Shape) shape.copy();

    }

}
