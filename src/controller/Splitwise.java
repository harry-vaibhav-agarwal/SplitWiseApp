package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Splitwise {
    private final ExpenseController expenseController;
    private final BalanceSheetController balanceSheetController;
    private final UserController userController;

    public Splitwise(ExpenseController expenseController) {
        this.expenseController = expenseController;
        this.balanceSheetController = expenseController.getBalanceSheetController();
        this.userController = expenseController.getUserController();
    }

    public void demo() {
        userController.addUser("u1","User1");
        userController.addUser("u2","User2");
        userController.addUser("u3","User3");
        userController.addUser("u4","User4");
        balanceSheetController.showBalanceSheetOfGivenUsers(userController.getAllUserIds().stream().map(userId->userController.getUser(userId)).collect(Collectors.toList()));
        balanceSheetController.showBalanceSheetOfGivenUser(userController.getUser("u1"));
        expenseController.createExpense("Lunch",1000.0,userController.getAllUserIds(),null,null,"u1","EQUAL");
        balanceSheetController.showBalanceSheetOfGivenUser(userController.getUser("u4"));
        balanceSheetController.showBalanceSheetOfGivenUser(userController.getUser("u1"));
        List<String> userIds = new ArrayList<>();
        userIds.add("u2");
        userIds.add("u3");
        List<Double> doubleAmounts = new ArrayList<>();
        doubleAmounts.add(370.0);
        doubleAmounts.add(880.0);
        expenseController.createExpense("Dinner",1250.0,userIds,doubleAmounts,null,"u1","EXACT");
        balanceSheetController.showBalanceSheetOfGivenUsers(userController.getAllUserIds().stream().map(userId->userController.getUser(userId)).collect(Collectors.toList()));
        List<Integer> percentages = new ArrayList<>();
        percentages.add(40);
        percentages.add(20);
        percentages.add(20);
        percentages.add(20);
        expenseController.createExpense("Movie",1200.0,userController.getAllUserIds(),null,percentages,"u4","PERCENT");
        balanceSheetController.showBalanceSheetOfGivenUser(userController.getUser("u1"));
        balanceSheetController.showBalanceSheetOfGivenUsers(userController.getAllUserIds().stream().map(userId->userController.getUser(userId)).collect(Collectors.toList()));
    }
}
