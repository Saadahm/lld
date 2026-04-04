package DriverQuestionAPIDoordash;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solver {
    private static final DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public PayoutResponse solve(List<Event> events, Map<Integer,Integer> m, int base) {
        events.sort((a,b)->{
            LocalDateTime aTime=LocalDateTime.parse(a.getTime(),df);
            LocalDateTime bTime=LocalDateTime.parse(b.getTime(),df);
            int cmp= aTime.compareTo(bTime);
            if(cmp!=0)
                return cmp;
            return Integer.compare(order(a.getStatus()), order(b.getStatus()));
        });
        LocalDateTime aTime=LocalDateTime.parse(events.get(0).getTime(),df);
        LocalDateTime bTime=LocalDateTime.parse(events.get(1).getTime(),df);
        System.out.println(Duration.between(aTime,bTime).getSeconds());
        PayoutResponse payoutResponse=new PayoutResponse();
        HashSet<String>active=new HashSet<>();
        Map<String, Integer>payOut=new HashMap<>();
        int amount=0;
        for(Event event: events)
        {
            String id=event.getId();
            String status=event.getStatus();
            String time=event.getTime();
            if("accepted".equals(status))
            {
                payOut.putIfAbsent(id,m.getOrDefault(active.size(),1)* base);
                active.add(id);
            }
            else if("cancelled".equals(status))
            {
                active.remove(id);
            }
            else {
                PayoutBreakdown payoutBreakdown=new PayoutBreakdown(payOut.get(id), id);
                payoutResponse.addBreakDown(payoutBreakdown);
                amount+=payOut.get(id);
                active.remove(id);
            }
        }
        payoutResponse.setTotal(amount);
        return payoutResponse;
    }
    int order(String status)
    {
        if(status.equals("accepted"))
            return 1;
        else return 0;
    }
}
