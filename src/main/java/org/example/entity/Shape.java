package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.Service.ShapeDTO;
//import com.oop_paint.Database.Database;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY, visible = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")

@JsonSubTypes({
        @JsonSubTypes.Type(value = Square.class, name = "square"),
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Ellipse.class, name = "ellipse"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = SegmentLine.class, name = "segmentline"),
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle")

})
@JsonIgnoreProperties(value = "attrs",ignoreUnknown = true)
//@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Shape implements Cloneable{

    private String shape;
    private double x;
    private double y;
    private double scaleX;
    private double scaleY;
    private double rotation;
    private double strokeWidth;
    private String id;
    private String fill;
    private String stroke;
    private boolean draggable;

    private double []points;
    private double radius; //for circle
    private double radiusX; //for ellipse
    private double radiusY; //for ellipse
    private double width; //for sharp shapes
    private double height; //for sharp shapes

    private boolean closed;

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }

    public double getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Shape(ShapeDTO data) {
        this.x = data.x;
        this.y = data.y;
        this.scaleX = data.scaleX;
        this.scaleY = data.scaleY;
        this.rotation = data.rotation;
        this.strokeWidth = data.strokeWidth;
        this.fill = data.fill;
        this.stroke = data.stroke;
        this.draggable = data.draggable;
        this.radius = data.radius;
        this.radiusX = data.radiusX;
        this.radiusY = data.radiusY;
        this.width = data.width;
        this.height = data.height;
        this.closed = data.closed;
        this.points = data.points;
        this.shape = data.shape;
        this.id = data.id;
        this.points = points;

    }

    public Shape(){}

    public Shape copy(){

        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
//    public void draw(){
//        Database database = Database.getInstance();
//        this.setId(database.addShape(this));
//    }
//    public void delete(){
//        Database database = Database.getInstance();
//        database.deleteShape(id);
//    }
//
    public ShapeDTO toDTO(){
        ObjectMapper mapper = new JsonMapper();
        String json = null;
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            return mapper.readValue(json, ShapeDTO.class);
        } catch (Exception e) {
            return null;
        }
    }

    //getters and setters
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getScaleX() {
        return scaleX;
    }
    
    public void setScaleX(double scaleX) {
        this.scaleX = scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
    }
    
    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }
    
    public String getStroke() {
        return stroke;
    }
    
    public void setStroke(String stroke) {
        this.stroke = stroke;
    }
    
    public double getRotation() {
        return rotation;
    }
    
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
