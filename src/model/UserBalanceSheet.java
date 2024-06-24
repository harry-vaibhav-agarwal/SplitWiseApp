package model;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {
    private Map<String,Balance> userVsBalanceMap;
    private double totalPayment;
    private double totalExpense;
    private double totalOweAmount;

    UserBalanceSheet() {
        userVsBalanceMap = new HashMap<>();
        totalPayment  = 0;
        totalExpense =  0 ;
        totalOweAmount = 0;
    }

    public Map<String, Balance> getUserVsBalanceMap() {
        return userVsBalanceMap;
    }

    public void setUserVsBalanceMap(Map<String, Balance> userVsBalanceMap) {
        this.userVsBalanceMap = userVsBalanceMap;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalOweAmount() {
        return totalOweAmount;
    }

    public void setTotalOweAmount(double totalOweAmount) {
        this.totalOweAmount = totalOweAmount;
    }
}
