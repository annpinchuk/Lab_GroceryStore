package com.GroceryShop;

public class SecurityGuard extends Worker {
    private Pistol gun;//композиция

    public SecurityGuard(String name) {
        super(name);
        this.gun = new Pistol("Glock 18", 9);
    }
    public SecurityGuard(String name, Pistol gun) {
        super(name);
        this.gun = gun;
    }

    public String getPistolInfo(){
        return "The gun: "  + gun.getModel() + ", " + gun.getCaliber() + "mm.";
    }

    public Pistol getGun() {
        return gun;
    }
}