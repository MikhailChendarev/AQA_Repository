package org.example.geometry.threedimensional;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cube {

    private double side;

    public double getVolume() {
        return Math.pow(side, 3);
    }

    public double getSurfaceArea() {
        return 6 * Math.pow(side, 2);
    }
}
