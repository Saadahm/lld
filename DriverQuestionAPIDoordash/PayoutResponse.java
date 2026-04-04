package DriverQuestionAPIDoordash;

import java.util.ArrayList;
import java.util.List;

public class PayoutResponse {
    private int total;
    private List<PayoutBreakdown>breakdowns;

    public List<PayoutBreakdown> getBreakdowns() {
        return breakdowns;
    }

    public void setBreakdowns(List<PayoutBreakdown> breakdowns) {
        this.breakdowns = breakdowns;
    }

    public int getTotal() {
        return total;
    }
    public PayoutResponse()
    {
        this.breakdowns=new ArrayList<>();
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void addBreakDown(PayoutBreakdown payoutBreakdown)
    {
        breakdowns.add(payoutBreakdown);
    }
}
