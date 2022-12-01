package LR4and5.Commands;

import LR4and5.CreditStorage;

public abstract class Command {
    CreditStorage creditStorage;
    public abstract void execute();
}

