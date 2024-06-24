package model;

import enums.SplitType;

public class SplitFactory {
    public static ExpenseSplit createSplit(String splitType) {
        switch (SplitType.getValue(splitType)) {
            case EQUAL: return new EqualExpenseSplit();
            case EXACT: return new ExactExpenseSplit();
            case PERCENT: return new PercentageExpenseSplit();
            default: return null;
        }
    }
}
