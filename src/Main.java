import controller.BalanceSheetController;
import controller.ExpenseController;
import controller.Splitwise;
import controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        BalanceSheetController balanceSheetController = new BalanceSheetController(userController);
        ExpenseController expenseController = new ExpenseController(userController,balanceSheetController);
        Splitwise splitwise = new Splitwise(expenseController);
        splitwise.demo();
    }
}