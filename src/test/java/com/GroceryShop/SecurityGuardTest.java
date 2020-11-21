package com.GroceryShop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SecurityGuardTest {
    @Test
    public void EmbeddedPistolInfoShouldBeCorrect() {
        SecurityGuard security1 = new SecurityGuard("Vasya");

        assertEquals(security1.getName(), "Vasya");
        assertEquals(security1.getGun().getModel(),"Glock 18" );
        assertEquals(security1.getGun().getCaliber(),9 );
    }

    @Test
    public void PistolInfoShouldBeCorrect() {
        Pistol gun = mock(Pistol.class);
        SecurityGuard security2 = new SecurityGuard("Danya", gun);

        when(gun.getModel()).thenReturn("Glock 18");
        when(gun.getCaliber()).thenReturn(9);

        assertEquals(security2.getPistolInfo(), "The gun: Glock 18, 9mm.");
        verify(gun).getCaliber();
        verify(gun).getModel();
    }
}
