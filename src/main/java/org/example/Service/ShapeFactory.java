package org.example.Service;

import org.example.entity.*;
import org.example.entity.Rectangle;
import org.springframework.stereotype.Service;

@Service
public class ShapeFactory {
    public Shape getShape(ShapeDTO data){
        switch (data.shape){
            case "circle": return new Circle(data);
            case "square": return new Square(data);
            case "rectangle": return new Rectangle(data);
            case "ellipse": return new Ellipse(data);
            case "line" : return new SegmentLine(data);
            case "triangle" : return new Triangle(data);
            default:return null;
        }
    }
}