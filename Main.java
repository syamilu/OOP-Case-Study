import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Voucher> voucherList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Voucher v = new Voucher(null);

        System.out.println("Welcome to the BlueShark Voucher Management System!");
        System.out.println("---------------------------------------------------");
        do {

            System.out.println("Please select an option:");
            System.out.println("1. Generate Voucher(s)");
            System.out.println("2. Redeem Voucher(s)");
            System.out.println("3. Modify Voucher");
            System.out.println("4. Delete Voucher");
            System.out.println("5. View Voucher(s)");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1: v.generateVoucher(); //FIrdaus = generateVoucher()
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Thank you for using the BlueShark Voucher Management System!");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        } while (true);

    }
}
