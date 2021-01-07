package services.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathUtilsTest {

    @org.junit.jupiter.api.Test
    void rotate() {
        Coordinates rotationCenter = new Coordinates(0,0);
        Coordinates point = new Coordinates(5,0);

        double epsilon = 0.001;

        Coordinates rotatedCoordinates = MathUtils.applyRotation(23, rotationCenter, point);
        assertTrue(Math.abs(rotatedCoordinates.getX() - 4.6025242672622) <= epsilon);
        assertTrue(Math.abs(rotatedCoordinates.getY() - 1.9536556424464) <= epsilon);

        rotatedCoordinates = MathUtils.applyRotation(113, rotationCenter, point);
        assertTrue(Math.abs(rotatedCoordinates.getX() - ( -1.9536556424464)) <= epsilon);
        assertTrue(Math.abs(rotatedCoordinates.getY() - 4.6025242672622) <= epsilon);

        rotatedCoordinates = MathUtils.applyRotation(260, rotationCenter, point);
        assertTrue(Math.abs(rotatedCoordinates.getX() - (- 0.8682408883347)) <= epsilon);
        assertTrue(Math.abs(rotatedCoordinates.getY() - (-4.924038765061)) <= epsilon);

        rotatedCoordinates = MathUtils.applyRotation(347, rotationCenter, point);
        assertTrue(Math.abs(rotatedCoordinates.getX() - 4.8718503239262) <= epsilon);
        assertTrue(Math.abs(rotatedCoordinates.getY() - (-1.1247552717193)) <= epsilon);
    }
    @Test
    void inverseVector() {
        Vector vector = new Vector(new Coordinates(0,0), new Coordinates(2,2));
        Vector invertedVector = MathUtils.inverseVector(vector);
        assertEquals(invertedVector, new Vector(new Coordinates(0, 0), new Coordinates(-2, -2)));

        vector = new Vector(new Coordinates(1,1), new Coordinates(2,2));
        invertedVector = MathUtils.inverseVector(vector);
        assertEquals(invertedVector, new Vector(new Coordinates(1, 1), new Coordinates(0, 0)));

        vector = new Vector(new Coordinates(1,2), new Coordinates(2,1));
        invertedVector = MathUtils.inverseVector(vector);
        assertEquals(invertedVector, new Vector(new Coordinates(1, 2), new Coordinates(0, 3)));

        vector = new Vector(new Coordinates(5,3), new Coordinates(7,7));
        invertedVector = MathUtils.inverseVector(vector);
        assertEquals(invertedVector, new Vector(new Coordinates(5, 3), new Coordinates(3, -1)));
    }

    @Test
    void isWithinRectangle() {
        Vector vector = new Vector(new Coordinates(0,0), new Coordinates(2,2));
        Coordinates point = new Coordinates(3, 1);
        assertFalse(MathUtils.isWithinRectangle(vector, point));

        point = new Coordinates(2, 2);
        assertTrue(MathUtils.isWithinRectangle(vector, point));

        point = new Coordinates(2, 1);
        assertTrue(MathUtils.isWithinRectangle(vector, point));

        point = new Coordinates(-2, -2);
        assertTrue(MathUtils.isWithinRectangle(vector, point));

        point = new Coordinates(-3, -2);
        assertFalse(MathUtils.isWithinRectangle(vector, point));
    }

    @Test
    void vectorMagnitude() {
        double epsilon = 0.001;

        double real = 2.8284271;
        Vector vector = new Vector(new Coordinates(0,0), new Coordinates(2,2));
        assertTrue((MathUtils.vectorMagnitude(vector) - real) <= epsilon);

        real = 3.162277;
        vector = new Vector(new Coordinates(0,0), new Coordinates(3,1));
        assertTrue((MathUtils.vectorMagnitude(vector) - real) <= epsilon);

        real = 15.652475;
        vector = new Vector(new Coordinates(0,0), new Coordinates(7,-14));
        assertTrue((MathUtils.vectorMagnitude(vector) - real) <= epsilon);
    }

    @Test
    void isWithinCircle() {
        Coordinates center = new Coordinates(0, 0);
        Coordinates point = new Coordinates(-1, -1);
        double radius = 1.0;
        assertFalse(MathUtils.isWithinCircle(center, radius, point));

        point = new Coordinates(0, 1);
        assertTrue(MathUtils.isWithinCircle(center, radius, point));

        radius = 2.0;
        center = new Coordinates(1, 1);
        point = new Coordinates(2, -1);
        assertFalse(MathUtils.isWithinCircle(center, radius, point));

        point = new Coordinates(3, 1);
        assertTrue(MathUtils.isWithinCircle(center, radius, point));

        center = new Coordinates(-2, -2);
        point = new Coordinates(-2, -4);
        assertTrue(MathUtils.isWithinCircle(center, radius, point));

        point = new Coordinates(-4, -4);
        assertFalse(MathUtils.isWithinCircle(center, radius, point));
    }

    @Test
    void translationAmount() {
        Coordinates origin = new Coordinates(1, 1);
        Coordinates point = new Coordinates(50, 51);
        Coordinates testPoint = new Coordinates(50, 51);
        point = MathUtils.translationAmount(point, origin);

        assertEquals(testPoint.getX(), point.getX() + origin.getX());

        point = new Coordinates(-50, 51);
        testPoint = new Coordinates(-50, 51);
        point = MathUtils.translationAmount(point, origin);

        assertEquals(testPoint.getX(), point.getX() + origin.getX());

        point = new Coordinates(-50, -51);
        testPoint = new Coordinates(-50, -51);
        point = MathUtils.translationAmount(point, origin);

        assertEquals(testPoint.getX(), point.getX() + origin.getX());

    }

    @Test
    void getRectangularBoundaryCoordinates() {
        /**
        Vector vector = new Vector(new Coordinates(0,0), new Coordinates(1,1));
        Coordinates[] coordinates = MathUtils.getRectangularBoundaryCoordinates(vector, 5);

        for (Coordinates c : coordinates){
            System.out.println(c);
        }
        System.out.println("\n");
         vector = new Vector(new Coordinates(0,0), new Coordinates(2,1));
         coordinates = MathUtils.getRectangularBoundaryCoordinates(vector, 5);

        for (Coordinates c : coordinates){
            System.out.println(c);
        }**/

    }

    @Test
    void coordinatesAroundCircle() {
        /**
        Vector arcVector = new Vector(new Coordinates(0,0 ), new Coordinates(1,1));
        Coordinates[] points = MathUtils.coordinatesAroundCircle(arcVector, 6);
        System.out.println(MathUtils.vectorMagnitude(arcVector));
        System.out.println(Arrays.toString(points));
        **/
    }

    @Test
    void distanceBetween() {
        double epsilon = 0.001;

        Coordinates firstPoint = new Coordinates(0,0);
        Coordinates secondPoint = new Coordinates(1,1);

        assertTrue(Math.abs(MathUtils.distanceBetween(firstPoint,secondPoint) - Math.sqrt(2)) <= epsilon);

        firstPoint = new Coordinates(-1,-1);
        secondPoint = new Coordinates(-2,-2);

        assertTrue(Math.abs(MathUtils.distanceBetween(firstPoint,secondPoint) - Math.sqrt(2)) <= epsilon);

        firstPoint = new Coordinates(-1,-1);
        secondPoint = new Coordinates(0,0);

        assertTrue(Math.abs(MathUtils.distanceBetween(firstPoint,secondPoint) - Math.sqrt(2)) <= epsilon);

        firstPoint = new Coordinates(-1,-1);
        secondPoint = new Coordinates(1,1);

        assertTrue(Math.abs(MathUtils.distanceBetween(firstPoint,secondPoint) - Math.sqrt(8)) <= epsilon);

        firstPoint = new Coordinates(1,1);
        secondPoint = new Coordinates(3,1);

        assertTrue(Math.abs(MathUtils.distanceBetween(firstPoint,secondPoint) - 2) <= epsilon);

        firstPoint = new Coordinates(-1,1);
        secondPoint = new Coordinates(3,1);

        assertTrue(Math.abs(MathUtils.distanceBetween(firstPoint,secondPoint) - 4) <= epsilon);


    }
}