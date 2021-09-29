import pojo.Emp;
import pojo.User;
import java.sql.SQLException;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private EmpDAO empDAO=new EmpDAO();
    public void run() throws SQLException {
        login();
        showFunction();
    }

    public void login() throws SQLException {
        System.out.println("Welcome to the System");
        int count = 0;
        while (true) {
            count++;
            System.out.print("User:");
            String user = scanner.nextLine();
            System.out.print("Pass:");
            String pass = scanner.nextLine();
            User user1 = new User(user, pass);

            if (empDAO.login(user1)) {
                break;
            } else {
                System.out.println("The username or the password is wrong. please retry.");
            }
            if (count == 3) {
                System.exit(1);
            }
        }

    }

    public void showFunction() throws SQLException {
        while (true) {
            System.out.println("1.show ALL emp.");
            System.out.println("Please select your choice:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showAll();
                    break;
                case "2":
                    selectByDate();
                    break;
                case "3":
                    selectTop3();
                    break;
                case "4":
                    selectLast3();
                    break;
                case "5":
                    queryTotalBonus();
                    break;
                case "6":
                    queryAverageAge();
                    break;
                case "7":
                    queryStatus();
                    break;
                case "8":
                    System.exit(0);
                    break;


            }
        }
    }
    public void showAll() throws SQLException {
        for (Emp emp : empDAO.SelectAll()) {
            System.out.println(emp);
        }
    }
    public void selectByDate() throws SQLException {
        String startDate=scanner.nextLine();
        String endDate=scanner.nextLine();
        for (Emp emp : empDAO.selectByDate(startDate, endDate)) {
            System.out.println(emp);
        }
    }
    public void selectTop3() throws SQLException {
        empDAO.selectBonusLast3().forEach(System.out::println);
    }
    public void selectLast3() throws SQLException{
        empDAO.selectBonusLast3().forEach(System.out::println);
    }
    public void  queryTotalBonus() throws SQLException {
        System.out.println(empDAO.queryTotalBonus());
    }
    public void queryAverageAge() throws SQLException {
        System.out.println(empDAO.queryAverageAge());
    }
    public void queryStatus() throws SQLException {
        empDAO.queryStatus().forEach(System.out::println);
    }
}
