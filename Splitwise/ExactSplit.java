package Splitwise;

import java.util.ArrayList;
import java.util.List;

public class ExactSplit implements SplitStrategy{
    @Override
    public List<Split> calculateSplit(double totalAmount, List<String> userIds, List<Double> values) {
        List<Split>splits=new ArrayList<>();
        for(int i=0;i<userIds.size();i++)
        {
            splits.add(new Split(userIds.get(i),values.get(i)));
        }
        return splits;
    }
}
