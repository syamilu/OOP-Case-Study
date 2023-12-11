import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Voucher> voucherList = new ArrayList<>();
        int choice = 0;
        Scanner input = new Scanner(System.in);

        Voucher v = new Voucher(null);

        // test data(comment out if not in use)
        for (int i = 0; i < 5; i++) {
            String voucherID = "voucher" + (i + 1); // Generate a unique voucherID for each Voucher
            Voucher testVoucher = new Voucher(voucherID); // Create a new Voucher object with the voucherID
            if (i == 2 || i == 4) {
                testVoucher.setIsRedeemed();
            }
            voucherList.add(testVoucher); // Add the new Voucher object to the list
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
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // consume the invalid input
            }
            System.out.println();
            switch (choice) {
                case 1:
                    v.generateVoucher(); // FIrdaus = generateVoucher()
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
