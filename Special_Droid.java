package LR3.droids;

public class Special_Droid extends Droid {
    public int special_health = 20;
    public int special_damage = 5;
    public Special_Droid (String name, double health, int damage) {
        super(name, health, damage);
        this.health = health + special_health;
        this.damage = damage + special_damage;
    }
}

