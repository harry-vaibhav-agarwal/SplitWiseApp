package model;

import enums.SplitType;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final String expenseId;
    private String description;

    private double amount;
    private List<Split> splitList;

    private final User paidBy;

    private final Date date;

    private final SplitType splitType;

    public Expense(String description, double amount, List<Split> splitList, User paidBy, SplitType splitType) {
        this.expenseId = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.splitList = splitList;
        this.paidBy = paidBy;
        this.date = new Date();
        this.splitType = splitType;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public Date getDate() {
        return date;
    }

    public SplitType getSplitType() {
        return splitType;
    }
}
