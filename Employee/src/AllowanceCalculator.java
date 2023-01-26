class AllowanceCalculator implements Runnable{
    private static float allowance;

    public void run(){
        float basicSalary = Main.getBasicSalary();
        allowance = basicSalary*0.05f;
    }
    public static float getAllowance(){
        return allowance;
    }
}
