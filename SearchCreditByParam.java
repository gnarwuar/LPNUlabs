package LR4and5.Commands;

import LR4and5.Credit;
import LR4and5.CreditStorage;

import java.util.Scanner;

public class SearchCreditByParam extends Command {

    public SearchCreditByParam(CreditStorage creditStorage)
    {
        this.creditStorage = creditStorage;
    }
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void execute()
    {
        System.out.println("By which parameter do you want to search:");
        int select;
        System.out.println("""
                1. Loan time
                2. Loan amount
                3. The purpose of the loan""");
        select = scanner.nextInt();
        scanner.nextLine();

        switch (select)
        {
            case 1->SearchByTime();
            case 2->SearchByAmount();
            case 3->SearchByPurpose();
        }

    }

    private void SearchByTime()
    {
        System.out.println("Enter the terms (time brackets) for the loan:");
        int time = scanner.nextInt();
        int count = 0;
        for (Credit credit:this.creditStorage.getCredits())
        {
            if(time<credit.getMax_term_of_credit()&&time>credit.getMin_term_of_credit()){
                System.out.println(credit);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("No such data was found!");
        }
    }

    private void SearchByAmount()
    {
        System.out.println("Enter the amount of money for a loan:");
        double amount = scanner.nextDouble();
        int count = 0;
        for (Credit credit:this.creditStorage.getCredits())
        {
            if(amount<credit.getMax_sum_of_credit()&&amount>credit.getMin_sum_of_credit()){
                System.out.println(credit);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("No such data was found!");
        }
    }

    private void SearchByPurpose()
    {
        System.out.println("Enter the purpose of the loan:");
        String name = scanner.nextLine();
        int count = 0;
        for (Credit credit:this.creditStorage.getCredits())
        {
            if(name.equals(credit.getThe_purpose_of_the_credit())){
                System.out.println(credit);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("No such data was found!");
        }
    }

}

