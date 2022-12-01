package LR4and5.Commands;

import LR4and5.Credit;
import LR4and5.CreditStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class TakeCredit extends Command
{
    private final Scanner scanner = new Scanner(System.in);
    private double money;
    public TakeCredit(CreditStorage creditStorage){
        this.creditStorage = creditStorage;
    }

    @Override
    public void execute()
    {
        ArrayList<Credit> list = new ArrayList<>();
        System.out.println("Enter the amount of money you want to take on loan:");
        money = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the purpose for which you want to take the loan:");
        String purpose = scanner.nextLine();

        for (Credit credit : this.creditStorage.getCredits()){
            if(money> credit.getMin_sum_of_credit()
                    &&money< credit.getMax_sum_of_credit()
                    &&purpose.equals(credit.getThe_purpose_of_the_credit()))
            {
                list.add(credit);
            }
        }

        if (list.size() == 0){
            System.out.println("Sorry, there is no suitable loan for you!");
            return;
        }

        System.out.println("Loan for you:");
        int i=1;
        for (Credit credit: list)
        {
            System.out.print(i + ") ");
            System.out.println(credit);
        }

        System.out.println("Enter the number of a loan which you want to take:");
        int select = scanner.nextInt();
        scanner.nextLine();
        if(select> list.size())
        {
            System.out.println("Input the correct data!");
            return;
        }
        TakeACredit(list.get(select - 1));

    }
    double intrate;
    int term;
    private void TakeACredit(Credit credit)
    {
        System.out.printf("You can take a loan at %s bank\n", credit.getBank_name());
        System.out.printf("You can take a loan from %d to %d months\n",
                credit.getMin_term_of_credit(), credit.getMax_term_of_credit());
        System.out.println("Enter for how long you want to take a credit");
        int intrate = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("You take credit for %d month and you will have to pay %.1f ,you need to pay %.1f in month",
                intrate, money+((credit.getInterest_rate() * money*intrate/12)/100) , (money+((credit.getInterest_rate() * money*intrate/12)/100))/intrate);
        System.out.println();
        System.out.println("Do you want to make some changes?");
        System.out.println("""
                You can choose one from those:
                1. Yes, i want to get extend the loan period
                2. Yes, i want to increase the amount of money taken with my loan
                3. No""");
        int chose = scanner.nextInt();
        switch (chose)
        {
            case 1-> Load(credit);
            case 2-> AddingMoney(credit);
            case 3-> System.out.println("Thanks for using my application, see you next time!");
        }

    }
    public void Load(Credit credit){
        int month;
        int ext;
        System.out.println("Indicate how many months the previous loan was:");
        ext = scanner.nextInt();
        System.out.println("By how long do you want to extend it?");
        month = scanner.nextInt();
        scanner.nextLine();
        int r = month + ext;
        System.out.printf("now the number of months has been increased to %d ,the amount to be paid after changes is %.1f, when the monthly payment is %.1f",r,
                money+(((credit.getInterest_rate()+10.0) * money*(r)/12)/100),(money+(((credit.getInterest_rate()+10.0) * money*(r)/12)/100))/(r));
        System.out.println();
    }
    private void AddingMoney(Credit credit){
        int month;
        int extra;
        System.out.println("Choose after which month you want to increase the amount of paid money:");
        month = scanner.nextInt();
        int new_term = term - month;
        scanner.nextLine();
        System.out.println("Select the amount you would like to pay extra:");
        extra = scanner.nextInt();
        double sum = money - extra;
        scanner.nextLine();
        System.out.printf("You have to pay %.1f",
                money+((intrate * money * month/12)/100)+extra - ((intrate * sum * new_term/12)/100));
        System.out.println();
    }
}

