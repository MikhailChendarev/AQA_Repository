package org.example;


import org.example.geometry.Circle;
import org.example.geometry.Rectangle;
import org.example.geometry.Triangle;
import org.example.geometry.threedimensional.Cube;
import org.example.geometry.threedimensional.Sphere;
import org.example.geometry.utils.GeometryUtils;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Triangle triangle = new Triangle(3, 4, 5);

        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle perimeter: " + circle.getPerimeter());

        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());

        System.out.println("Triangle area: " + triangle.getArea());
        System.out.println("Triangle perimeter: " + triangle.getPerimeter());

        double areaInMeters = 10;
        double areaInCentimeters = GeometryUtils.convertToCentimeters(areaInMeters);
        System.out.println("Area in centimeters: " + areaInCentimeters);

        boolean areEqual = GeometryUtils.areEqualAreas(100, 100);
        System.out.println("Are areas equal: " + areEqual);

        double squareMeters = 10;
        double squareCentimeters = GeometryUtils.convertSquareMetersToSquareCentimeters(squareMeters);
        System.out.println(squareMeters + " square meters are equal " + squareCentimeters + " square centimeters.");

        Sphere sphere = new Sphere(5);
        System.out.println("Sphere volume is: " + sphere.getVolume() + " Sphere SurfaceArea: " + sphere.getSurfaceArea());

        Cube cube = new Cube(5);
        System.out.println("Cube volume is: " + cube.getVolume() + " Cube SurfaceArea: " + cube.getSurfaceArea());

    }
}