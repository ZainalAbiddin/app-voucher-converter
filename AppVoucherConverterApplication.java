import java.util.Scanner;

public class AppVoucherConverterApplication {

    public static VoucherConverter voucherConverter = new VoucherConverter();

    public static void main(String[] args) throws Exception {
        String line = "===============================";
        System.out.println(line);
        System.out.println("Program Converter Voucher !");
        menu goLive = new menu();
        goLive.mainMenu();
    }
}

