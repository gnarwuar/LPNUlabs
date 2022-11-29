package LR3.arena;

import LR3.droids.Droid;
import LR3.droids.FighterDroid;
import LR3.droids.Special_Droid;
import LR3.droids.Tank_Droid;
import LR3.teams.Team;

import java.util.Scanner;

public class SetUpArena {
    Droid droid1 = null;
    Droid droid2 = null;
    public void chooseBattleMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, please choose the mode!");
        System.out.println("Press 1 if you want a 1vs1 battle");
        System.out.println("Press 2 if you want a team vs team battle!");
        System.out.println("Press 3 if you want to print the last completed battle!");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                setUpDroids();
                askWritePermission();
                startFight();
            }
            case 2 -> {
                setUpTeams();
                askWritePermission();
                startFight();
            }
            case 3 -> {
                FileWorker.printLastSavedFight();
            }
            default -> System.out.println("Try again");
        }
    }

    private Droid getDroid() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 if you want to choose a Tank Droid");
        System.out.println("Press 2 if you want to choose a Fighter Droid");
        System.out.println("Press 3 if you want to choose a Special Droid");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Your choice is a Tank Droid!");
                return new Tank_Droid("t300", 55, 8);
            }
            case 2 -> {
                System.out.println("Your choice is a Fighter Droid!");
                return new FighterDroid("f200", 50, 10);
            }
            case 3 -> {
                System.out.println("Your choice is a Special Droid!");
                return new Special_Droid("s100", 50, 10);
            }
            default -> System.out.println("Try again");
        }
        return null;
    }
    private Droid getTeam() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Your choice is a Tank Team!");
                return new Team("TEAM tt900", 120, 20);
            }
            case 2 -> {
                System.out.println("Your choice is Tank + Fighter Team!");
                return new Team("TEAM tf391", 110, 25);
            }
            case 3 -> {
                System.out.println("Your choice is Tank + Special Team!");
                return new Team("TEAM ts41", 110, 20);
            }
            case 4 -> {
                System.out.println("Your choice is a Fighter Team!");
                return new Team("TEAM ff109", 100, 30);
            }
            case 5 -> {
                System.out.println("Your choice is Fighter + Special Team!");
                return new Team("TEAM fs834", 100, 25);
            }
            case 6 -> {
                System.out.println("Your choice is a Special Team!");
                return new Team("TEAM ss94", 100, 20);
            }
            default -> System.out.println("Try again");
        }
        return null;
    }

    private void setUpDroids() {
        System.out.println("Your choice is a 1vs1 battle, choose the first droid!");
        droid1 = getDroid();
        System.out.println("\nChoose the second droid!");
        droid2 = getDroid();
    }
    private void setUpTeams() {
        System.out.println("Your choice is a team battle, set up your first team:");

        System.out.println("Press 1 if you want a team of Tank + Tank");
        System.out.println("Press 2 if ou want a team of Tank + Fighter");
        System.out.println("Press 3 if ou want a team of Tank + Special");
        System.out.println("Press 4 if ou want a team of Fighter + Fighter");
        System.out.println("Press 5 if ou want a team of Fighter + Special");
        System.out.println("Press 6 if ou want a team of Special + Special");

        droid1 = getTeam();
        System.out.println("Choose the second team:");
        droid2 = getTeam();
    }
    private void startFight() {
        if (droid1 == null || droid2 == null) {
            System.out.println("Set up your droids before fighting!");
            return;
        }
        Arena arena = new Arena(droid1, droid2);
        Droid winner = arena.startFight();
        var winnerText = "\n" + "The winner is " + winner.getName();
        System.out.println(winnerText);
        FileWorker.writeIntoFile(winnerText, true);
    }

    private void askWritePermission() {
        System.out.println("Do you want to save your battle to a text file? 1 - yes, 2 - no:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            FileWorker.setWriteAllowed(true);
            FileWorker.clearFile();
        } else {
            FileWorker.setWriteAllowed(false);
        }
    }
}
