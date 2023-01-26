class EPFCalculator implements Runnable{
    private static float epf;
    private static float employerContribution;

    public void run() {

        float basicSalary = Main.getBasicSalary();
        float totalSalary = basicSalary + AllowanceCalculator.getAllowance();

        epf = totalSalary * 0.08f;

        employerContribution = totalSalary * 0.12f;
    }

    public static float getEPF() {
        return epf;
    }
    public static float getEmployerContribution() {
        return employerContribution;
    }
}