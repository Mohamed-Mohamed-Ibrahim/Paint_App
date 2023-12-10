package org.example.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.Service.ShapeDTO;

@JsonTypeName("segmentline")
public class SegmentLine extends Shape {

    public SegmentLine(ShapeDTO data) {
        super(data);
    }

    public SegmentLine() {}

}
