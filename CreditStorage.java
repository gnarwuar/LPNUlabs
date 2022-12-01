package LR4and5;

import java.util.ArrayList;
import java.util.List;

public class CreditStorage
{
    private final List<Credit> Credits;

    public CreditStorage()
    {
        Credits = new ArrayList<>();
    }

    public List<Credit> getCredits() {
        return Credits;
    }
}

