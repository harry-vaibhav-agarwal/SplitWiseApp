package model;

import java.util.List;

public interface ExpenseSplit {
  List<Split> validateAndCreateSplit(List<String> userIds, double amount, List<Double> oweAmounts, List<Integer> percentage);

}
