package by.matrosov.lesson02;

import org.junit.Assert;
import org.junit.Test;

public class BarPointCollisionTest {
    @Test
    public void pointInsideBar() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(50, 50);
        Assert.assertTrue(bar.isColliding(point));
    }

    @Test
    public void pointOnCornerOfBar() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(0, 0);
        Assert.assertTrue(bar.isColliding(point));
    }

    @Test
    public void pointOnBorderOfBar() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(0, 50);
        Assert.assertTrue(bar.isColliding(point));
    }

    @Test
    public void pointOutsideOfBar1() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(0, 150);
        Assert.assertFalse(bar.isColliding(point));
    }

    @Test
    public void pointOutsideOfBar2() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(150, 0);
        Assert.assertFalse(bar.isColliding(point));
    }

    @Test
    public void pointOutsideOfBar3() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(150, 150);
        Assert.assertFalse(bar.isColliding(point));
    }
}
