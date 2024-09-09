package org.example.geometry;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle {

    private double height;

    private double width;

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public double getArea() {
        return width * height;
    }
}
