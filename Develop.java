package LR4and5.Commands;

public class Develop
{
    private final Command AllNewCredit;
    private final Command ShowAllCredits;
    private final Command SearchCreditByParam;
    private final  Command TakeCredit;
    public Develop(Command allNewCredit, Command showAllCredits,
                   Command searchCreditByParam, Command takeCredit)
    {
        this.AllNewCredit = allNewCredit;
        this.ShowAllCredits = showAllCredits;
        this.SearchCreditByParam = searchCreditByParam;
        this.TakeCredit = takeCredit;
    }
    public void AllNewCredit()
    {
        AllNewCredit.execute();
    }
    public void ShowAllCredits()
    {
        ShowAllCredits.execute();
    }
    public void SearchCreditByParam()
    {
        SearchCreditByParam.execute();
    }
    public void TakeCredit()
    {
        TakeCredit.execute();
    }
}

