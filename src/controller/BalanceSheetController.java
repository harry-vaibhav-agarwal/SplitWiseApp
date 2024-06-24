package controller;

import model.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BalanceSheetController {

    private final UserController userController;

    public BalanceSheetController(UserController userController) {
        this.userController = userController;
    }
    public void updateUserBalanceSheet(User paidBy, List<Split> splits, double amount) {
        UserBalanceSheet paidByUserBalanceSheet = paidBy.getUserBalanceSheet();
        paidByUserBalanceSheet.setTotalPayment(paidByUserBalanceSheet.getTotalPayment() + amount);
        for(Split split: splits) {
            if(Objects.equals(split.getUserId(), paidBy.getUserId())) {
                paidByUserBalanceSheet.setTotalExpense(paidByUserBalanceSheet.getTotalExpense() + split.getAmount());
            }
            else {

                // updating paidByUserBalanceSheet
                Balance balance = paidByUserBalanceSheet.getUserVsBalanceMap().getOrDefault(split.getUserId(),new Balance());
                balance.setOweAmount(balance.getOweAmount() + split.getAmount());
                paidByUserBalanceSheet.getUserVsBalanceMap().put(split.getUserId(),balance);

                //updating balanceSheet for another user
                UserBalanceSheet owedUserBalanceSheet = userController.getUser(split.getUserId()).getUserBalanceSheet();
                owedUserBalanceSheet.setTotalExpense(owedUserBalanceSheet.getTotalExpense() + split.getAmount());

                //Finding paidby user entry in second user's balance sheet
                Balance paidUserBalance = owedUserBalanceSheet.getUserVsBalanceMap().getOrDefault(paidBy.getUserId(),new Balance());
                paidUserBalance.setOweAmount(paidUserBalance.getOweAmount() + (-1)*split.getAmount());
                owedUserBalanceSheet.getUserVsBalanceMap().put(paidBy.getUserId(),paidUserBalance);

                //Setting total owe amount
                owedUserBalanceSheet.setTotalOweAmount(owedUserBalanceSheet.getTotalOweAmount() + (-1)*split.getAmount());
            }
        }
    }

    public void showBalanceSheetOfGivenUser(User user) {
        Map<String,Balance> userBalanceMap = user.getUserBalanceSheet().getUserVsBalanceMap();
        if(userBalanceMap.isEmpty())
            System.out.println("No balances");
        else {
            System.out.println("\n------BalanceSheet of user " + user.getUserId() + "----------\n");
            for (Map.Entry<String, Balance> entry : userBalanceMap.entrySet()) {
                String userId = entry.getKey();
                double amount = entry.getValue().getOweAmount();
                if (amount >= 0)
                    System.out.println(userController.getUser(userId).getUsername() + " owes " + user.getUsername() + " " + amount);
                else
                  System.out.println(user.getUsername() + " owes " + userController.getUser(userId).getUsername() + " " + (-1 * amount));
            }
            System.out.println("\n-----END----------------\n");
        }
    }

    public void showBalanceSheetOfGivenUsers(List<User> users) {
        users.forEach(this::showBalanceSheetOfGivenUser);
    }
}


