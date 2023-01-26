import java.util.Scanner;

public class Main {
    private static float basicSalary;
    public static void main(String[] args) {
        basicSalary = calculateBasicSalary();

        Thread allowanceThread = new Thread(new AllowanceCalculator());
        allowanceThread.start();

        Thread epfThread = new Thread(new EPFCalculator());
        epfThread.start();

        try {
            allowanceThread.join();
            epfThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float allowance = AllowanceCalculator.getAllowance();
        float epf = EPFCalculator.getEPF();
        float employerContribution = EPFCalculator.getEmployerContribution();

        float finalSalary = basicSalary + allowance - epf + employerContribution;
        System.out.println("Final Salary: " + finalSalary);
    }

    private static float calculateBasicSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Per Day Payment:");
        float perDayPayment = sc.nextFloat();
        System.out.println("Enter No of Working Days:");
        int noOfDays = sc.nextInt();

        basicSalary = perDayPayment * noOfDays;

        return basicSalary;
    }
    public static float getBasicSalary() {
        return basicSalary;
    }
}