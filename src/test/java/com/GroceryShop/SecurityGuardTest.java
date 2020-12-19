package com.GroceryShop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecurityGuardTest {
    @Test
    public void EmbeddedPistolInfoShouldBeCorrect() {
        SecurityGuard security1 = new SecurityGuard("Vasya");

        assertEquals(security1.getName(), "Vasya");
        assertEquals(security1.getGun().getModel(),"Glock 18" );
        assertEquals(security1.getGun().getCaliber(),9 );
    }

}
