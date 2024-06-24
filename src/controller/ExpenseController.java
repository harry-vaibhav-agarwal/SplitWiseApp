package controller;

import enums.SplitType;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseController {
    private final List<Expense> expenses;
    private final UserController userController;
    private final BalanceSheetController balanceSheetController;
    public ExpenseController(UserController userController, BalanceSheetController balanceSheetController) {
        this.userController = userController;
        this.balanceSheetController = balanceSheetController;
        expenses = new ArrayList<>();
    }
    public Expense createExpense(String description, double amount, List<String> userIds,List<Double> oweAmount,List<Integer> percentages,String paidBy, String splitType) {
        ExpenseSplit expenseSplit = SplitFactory.createSplit(splitType);
        if(expenseSplit != null) {
            List<Split> splits = expenseSplit.validateAndCreateSplit(userIds, amount, oweAmount, percentages);
            User paidByUser = userController.getUser(paidBy);
            if (splits != null) {
                Expense expense = new Expense(description, amount, splits,paidByUser,SplitType.getValue(splitType));
                expenses.add(expense);
                balanceSheetController.updateUserBalanceSheet(paidByUser,splits,amount);
                return expense;
            }
        }
        return null;
    }

    public UserController getUserController() {
        return userController;
    }

    public BalanceSheetController getBalanceSheetController() {
        return balanceSheetController;
    }
}
