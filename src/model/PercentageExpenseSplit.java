package model;

import java.util.ArrayList;
import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit {
    @Override
    public List<Split> validateAndCreateSplit(List<String> userIds, double amount, List<Double> oweAmounts, List<Integer> percentage) {
        if(percentage == null)
            return null;
        if(percentage.stream().reduce(0,Integer::sum) != 100)
            return null;
        List<Split> splits = new ArrayList<>();
        for(int i=0;i< percentage.size();i++) {
           double owe = (amount * percentage.get(i))/100.0;
           Split split = new Split(userIds.get(i),owe);
           splits.add(split);
        }
        return splits;
    }
}
