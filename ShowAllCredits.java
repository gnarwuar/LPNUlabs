package LR4and5.Commands;

import LR4and5.Credit;
import LR4and5.CreditStorage;

public class ShowAllCredits extends Command {
    public ShowAllCredits(CreditStorage creditStorage) {
        this.creditStorage =  creditStorage;
    }

    @Override
    public void execute() {
        System.out.println("List of all loans:");
        for (Credit credit:this.creditStorage.getCredits()){
            System.out.println(credit);
        }
    }
}

