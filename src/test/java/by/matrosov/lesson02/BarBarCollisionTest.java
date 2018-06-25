package by.matrosov.lesson02;

import org.junit.Assert;
import org.junit.Test;

public class BarBarCollisionTest {
    @Test
    public void barSelfCollide() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Assert.assertTrue(bar.isColliding(bar));
    }
}
