package com.GroceryShop;

public class SecurityGuard extends Worker {
    private Pistol gun;//композиция

    public SecurityGuard(String name) {
        super(name);
        this.gun = new Pistol("Glock 18", 9);
    }

    public Pistol getGun() {
        return gun;
    }
}
