package LR3.droids;

public class FighterDroid extends Droid {
    public double damageMultiplier = 1.9;
    public FighterDroid(String name, double health, double damage) {
        super(name, health, damage);
        this.damage = damage * damageMultiplier;
    }
}

