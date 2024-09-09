package org.example.geometry.utils;

public class GeometryUtils {

    public static double convertToCentimeters(double meters) {
        return meters * 100;
    }

    public static boolean areEqualAreas(double area1, double area2) {
        return Double.compare(area1, area2) == 0;
    }
}
