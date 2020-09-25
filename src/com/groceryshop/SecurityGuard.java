package com.groceryshop;

public class SecurityGuard extends Worker {
    private Pistol gun;

    public SecurityGuard(String name) {
        super(name);
        this.gun = new Pistol("Glock 18", 9);
    }
}
