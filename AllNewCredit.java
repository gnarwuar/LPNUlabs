package LR4and5.Commands;

import LR4and5.Credit;
import LR4and5.CreditStorage;

import java.util.Scanner;


public class AllNewCredit extends Command
{
    public AllNewCredit(CreditStorage creditStorage){
        this.creditStorage= creditStorage;
    }
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void execute()
    {
        System.out.println("Enter Bank Name:");
        String bank_name = scanner.nextLine();
        System.out.println("Enter the purpose of taking a loan:");
        String the_purpose_of_the_credit = scanner.nextLine();
        System.out.println("Enter min term of taking a loan in months:");
        int min_term_of_credit = scanner.nextInt();
        System.out.println("Enter max term of taking a loan in months:");
        int max_term_of_credit = scanner.nextInt();
        System.out.println("Enter min sum of loaned money:");
        double min_sum_of_credit = scanner.nextDouble();
        System.out.println("Enter max sum of loaned money:");
        double max_sum_of_credit = scanner.nextDouble();
        System.out.println("Enter interest rate for the loan:");
        double interest_rate = scanner.nextDouble();
        scanner.nextLine();

        this.creditStorage.getCredits().add(new Credit(bank_name, the_purpose_of_the_credit, min_term_of_credit,
                max_term_of_credit, min_sum_of_credit, max_sum_of_credit, interest_rate));

    }
}

