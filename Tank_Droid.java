package LR3.droids;

public class Tank_Droid extends Droid {
    double armourMultiplier = 0.8;
    public Tank_Droid (String name, double health, int damage) {
        super(name, health, damage);
    }
    @Override
    public double getHit(double damage) {
        return super.getHit(damage * armourMultiplier);
    }
}

