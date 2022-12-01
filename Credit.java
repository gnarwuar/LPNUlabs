package LR4and5;

public class Credit {
    private String Bank_name;
    private String the_purpose_of_the_credit;
    private int min_term_of_credit;
    private int max_term_of_credit;
    private double Min_sum_of_credit;
    private double Max_sum_of_credit;
    private double interest_rate;

    public Credit(String bank_name, String the_purpose_of_the_credit,
                  int min_term_of_credit, int max_term_of_credit, double min_sum_of_credit,
                  double max_sum_of_credit, double interest_rate)
    {
        Bank_name = bank_name;
        this.the_purpose_of_the_credit = the_purpose_of_the_credit;
        this.min_term_of_credit = min_term_of_credit;
        this.max_term_of_credit = max_term_of_credit;
        Min_sum_of_credit = min_sum_of_credit;
        Max_sum_of_credit = max_sum_of_credit;
        this.interest_rate = interest_rate;
    }

    @Override
    public String toString() {
        return "Loan - " +
                "Bank name: " + Bank_name +
                ", purpose of taking a loan: " + the_purpose_of_the_credit +
                ", minimum term of taking a loan: " + min_term_of_credit +
                ", maximum term of taking a loan: " + max_term_of_credit +
                ", minimum sum of money for a loan: " + Min_sum_of_credit +
                ", maximum sum of money for a loan: " + Max_sum_of_credit +
                ", interest rate: " + interest_rate +
                '}';
    }

    public String getBank_name() {
        return Bank_name;
    }

    public void setBank_name(String bank_name) {
        Bank_name = bank_name;
    }

    public String getThe_purpose_of_the_credit() {
        return the_purpose_of_the_credit;
    }

    public void setThe_purpose_of_the_credit(String the_purpose_of_the_credit) {
        this.the_purpose_of_the_credit = the_purpose_of_the_credit;
    }

    public int getMin_term_of_credit() {
        return min_term_of_credit;
    }

    public void setMin_term_of_credit(int min_term_of_credit) {
        this.min_term_of_credit = min_term_of_credit;
    }

    public int getMax_term_of_credit() {
        return max_term_of_credit;
    }

    public void setMax_term_of_credit(int max_term_of_credit) {
        this.max_term_of_credit = max_term_of_credit;
    }

    public double getMin_sum_of_credit() {
        return Min_sum_of_credit;
    }

    public void setMin_sum_of_credit(double min_sum_of_credit) {
        Min_sum_of_credit = min_sum_of_credit;
    }

    public double getMax_sum_of_credit() {
        return Max_sum_of_credit;
    }

    public void setMax_sum_of_credit(double max_sum_of_credit) {
        Max_sum_of_credit = max_sum_of_credit;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }
}

