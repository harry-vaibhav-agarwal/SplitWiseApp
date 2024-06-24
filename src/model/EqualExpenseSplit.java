package model;

import java.util.List;
import java.util.stream.Collectors;

public class EqualExpenseSplit implements ExpenseSplit{

    @Override
    public List<Split> validateAndCreateSplit(List<String> userIds, double amount, List<Double> oweAmounts, List<Integer> percentage) {
        return userIds.stream().map(userId -> new Split(userId, amount/ userIds.size())).collect(Collectors.toList());
    }
}
