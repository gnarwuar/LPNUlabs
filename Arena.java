package LR3.arena;

import LR3.droids.Droid;

import java.text.DecimalFormat;
import java.util.Random;

public class Arena {
    private final Droid playerOne;
    private final Droid playerTwo;
    private Droid attacker;
    private Droid defender;
    private int currentRound = 0;

    public Arena(Droid playerOne, Droid playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
    private void prepareRound() {
        initFighters();
        currentRound++;
        var aboutRound = "\n\tRound " + currentRound;
        System.out.println(aboutRound);
        FileWorker.writeIntoFile(aboutRound, true);
    }
    public Droid startFight() {
        do {
            prepareRound();
            double actualDamage = initFight();
            printRoundInfo(actualDamage);

        } while (defender.isAlive());

        return attacker;
    }

    private double initFight() {
        return defender.getHit(attacker.getDamage());
    }

    private void printRoundInfo(double actualDamage) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String result = decimalFormat.format(actualDamage);
        var hitInfo = defender.getName() + " got hit with " + result + " damage";
        var defenderInfo = "Defender " + defender;
        var attackerInfo = "Attacker " + attacker;
        System.out.println(hitInfo);
        System.out.println(defenderInfo);
        System.out.println(attackerInfo);

        FileWorker.writeIntoFile(hitInfo, true);
        FileWorker.writeIntoFile(defenderInfo, true);
        FileWorker.writeIntoFile(attackerInfo, true);
    }

    private void initFighters() {
        Random random = new Random();
        if (random.nextBoolean()) {
            attacker = playerOne;
            defender = playerTwo;
        } else {
            attacker = playerTwo;
            defender = playerOne;
        }
    }
}

