package DriverQuestionAPIDoordash;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solver s=new Solver();
        Event e1=new Event("D1","accepted","2026-01-01 10:00:00");
        Event e2=new Event("D2","accepted","2026-01-01 10:05:05");
        Event e3=new Event("D3","accepted","2026-01-01 10:05:10");
        Event e4=new Event("D1","cancelled","2026-01-01 10:05:20");
        Event e5=new Event("D2","delivered","2026-01-01 10:05:25");
        Event e6=new Event("D3","delivered","2026-01-01 10:05:25");
        List<Event> events=new ArrayList<>();
        Collections.addAll(events,e1,e2,e3,e4,e5,e6);
        Map<Integer,Integer> m=new HashMap<>();
        m.put(1,2);
        m.put(2,3);
        PayoutResponse payoutResponse=s.solve(events,m,10);
        System.out.println(payoutResponse.getTotal());
        List<PayoutBreakdown>breakdowns=payoutResponse.getBreakdowns();
        for(PayoutBreakdown payoutBreakdown: breakdowns)
            System.out.println(payoutBreakdown.getDeliveryId() + payoutBreakdown.getAmount());
    }
}
