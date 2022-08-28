import java.util.Scanner;


public class menu {
    public static VoucherConverter voucherConverter = new VoucherConverter();

    public void mainMenu() throws Exception {
        try {
            String line = "===============================";
            System.out.println(line);
            System.out.println("TEST JAVA BE");
            System.out.println(line);
            System.out.println("1. Menentukan Point Dengan Jumlah terbesar");
            System.out.println("2. Menghitung sisa poin setelah di redeem dgn point terbesar jika poin yg dimiliki adalah 1000p / user input");
            System.out.println("3. Redeem all point prioritas point terbesar");
            System.out.println("0. Exit");
            Scanner input = new Scanner(System.in);
            System.out.println("Input your choice here :");
            if (!input.hasNextInt()) {
                System.out.println("You must input number");
                this.promptEnterKey();
                this.mainMenu();
            }
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    int point = this.point();
                    VoucherConverter voucher = voucherConverter.convertVoucher(point);
                    System.out.println(line);
                    System.out.println("Test 1 : " + voucher.getMessage());
                    System.out.println(line);
                    this.promptEnterKey();
                }
                case 2 -> {
                    int point = this.point();
                    VoucherConverter voucherTest2Input = voucherConverter.convertVoucher(point);
                    VoucherConverter voucherTest2 = voucherConverter.convertVoucher(1000);
                    System.out.println(line);
                    System.out.println("Test 2 : " + "Remaining point : " + voucherTest2Input.getRemainingPoint());
                    System.out.println("Test 2 : If point = 1000, " + "remaining point : " + voucherTest2.getRemainingPoint());
                    System.out.println(line);
                    this.promptEnterKey();
                }
                case 3 -> {
                    int point = this.point();
                    VoucherConverter voucherTest3 = TestThree(point);
                    System.out.println(line);
                    System.out.println(voucherTest3.getMessage());
                    System.out.println(line);
                    this.promptEnterKey();
                }
                case 0 -> {
                    System.out.println(line);
                    System.out.println("Finish App");
                    System.out.println(line);
                    System.exit(0);
                }
                default -> {
                    System.out.println("Choice not found !");
                    System.out.println("Please enter to back main menu");
                    this.promptEnterKey();
                }
            }
            this.mainMenu();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static VoucherConverter TestThree(Integer inputPoint) {
        int remainingPoint = inputPoint;
        int voucher100 = 0, voucher50 = 0, voucher25 = 0, voucher10 = 0;
        while (remainingPoint > 100) {
            VoucherConverter voucherTestRemainingPoint = voucherConverter.convertVoucher(remainingPoint);
            switch (voucherTestRemainingPoint.getRedeemVoucher()) {
                case "100000" -> voucher100 = 1;
                case "50000" -> voucher50 = 1;
                case "25000" -> voucher25 = 1;
                case "10000" -> voucher10 = 1;
            }
            remainingPoint = voucherTestRemainingPoint.getRemainingPoint();
        }
        String message;
        if (remainingPoint != inputPoint) {
            message = ("Test 3 : Your point : " + inputPoint + "p , " +
                    "you can redeem "
                    + voucher100 + " voucher 100.000, "
                    + voucher50 + " voucher 50.000, "
                    + voucher25 + " voucher 25000, "
                    + voucher10 + " voucher 10000, "
                    + "remaining point : " + remainingPoint);
        } else {
            message = ("Test 3 : Your point : " + inputPoint + "p , " +
                    "you can't redeem any voucher");
        }
        return new VoucherConverter(remainingPoint, message, null);
    }
    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public int point() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input your total points here :");
        if (!input.hasNextInt()) {
            System.out.println("You must input number");
            this.promptEnterKey();
            this.mainMenu();
        }
        int inputPoint = input.nextInt();
        if (inputPoint <= 0) {
            System.out.println("Input must > 0");
            this.promptEnterKey();
            this.mainMenu();
        }
        return inputPoint;
    }
}
