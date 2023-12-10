import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Voucher> voucherList = new ArrayList<>();
        int choice = 0;
        Scanner input = new Scanner(System.in);
        // test data
        for (int i = 0; i < 10; i++) {
            voucherList.add(new Voucher(Integer.toString(i)));
            if (i == 3 || i == 5) {
                voucherList.get(i).setIsRedeemed();
            }
        }
        // end of test data

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
            do {
                if (input.hasNextInt()) {
                    choice = input.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            } while (choice < 1 || choice > 6);

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    ViewVoucher.setVoucherList(voucherList);
                    ViewVoucher.displayOptions(voucherList);
                    break;
                case 6:
                    System.out.println("Thank you for using the BlueShark Voucher Management System!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
            input.nextLine();
        } while (choice != 6);
        input.close();

    }
}
