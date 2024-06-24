package model;

import java.util.ArrayList;
import java.util.List;

public class ExactExpenseSplit implements ExpenseSplit {

    @Override
    public List<Split> validateAndCreateSplit(List<String> userIds, double amount, List<Double> oweAmounts, List<Integer> percentage) {
        if(oweAmounts.stream().reduce(0.0,Double::sum) != amount)
            return null;
        List<Split> splits = new ArrayList<>();
        for(int i=0;i<userIds.size();i++) {
            Split split = new Split(userIds.get(i), oweAmounts.get(i));
            splits.add(split);
        }
        return splits;
    }
}
