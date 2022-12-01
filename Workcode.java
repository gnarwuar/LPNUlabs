package LR4and5;

import LR4and5.Commands.*;

import java.util.Scanner;

public class Workcode
{
    public final Scanner scanner = new Scanner(System.in);
    CreditStorage creditStorage = new CreditStorage();
    Develop develop = new Develop(
            new AllNewCredit(creditStorage),
            new ShowAllCredits(creditStorage),
            new SearchCreditByParam(creditStorage),
            new TakeCredit(creditStorage));

    public void Work()
    {
        int choice;

        while (true)
        {
            PrintMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:AllNewCredit();
                case 2:ShowAllCredits();
                case 3:TakeCredit();
                case 4:SearchCreditByParam();
                case 5:System.out.println("Thanks for using my application, see you next time!");
                System.exit(0);
            }
        }
    }
    private void PrintMenu()
    {
        System.out.println("""
                Choose one option from those:
                1. Add a new loan option
                2. Show all loan options
                3. Take a loan
                4. Search a loan by parameter
                5. Exit""");
    }
    private void AllNewCredit()
    {
        develop.AllNewCredit();
    }

    private void ShowAllCredits()
    {
        develop.ShowAllCredits();
    }
    private void TakeCredit()
    {
        develop.TakeCredit();
    }
    private void SearchCreditByParam()
    {
        develop.SearchCreditByParam();
    }
}

