import java.util.Scanner;

public class assignment4q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String basic = sc.nextLine();

        System.out.print("Enter Bonus: ");
        String bonus = sc.nextLine();

        Integer empId = Integer.valueOf(id);
        Double basicSalary = Double.valueOf(basic);
        Double bonusAmount = Double.valueOf(bonus);

        if (basicSalary < 0 || bonusAmount < 0) {
            System.out.println("Invalid salary values!");
        } else {
            double netSalary = basicSalary + bonusAmount;

            System.out.println("Employee ID: " + empId);
            System.out.println("Net Salary: " + netSalary);
        }

        sc.close();
    }
}