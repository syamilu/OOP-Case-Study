import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Voucher> voucherList = new ArrayList<>();
        int choice = 0;
        Scanner input = new Scanner(System.in);

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
                    Voucher.generateVoucher(voucherList);
                    break;
                case 2:
                    Voucher.redeemVoucher(voucherList);
                    break;
                case 3:
                    modifyVoucher(voucherList);
                    break;
                case 4:
                    Voucher.deleteVoucher(voucherList);
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

    // Syafiq: Method to modify voucher
    public static void modifyVoucher(ArrayList<Voucher> voucherList) {
        Scanner input = new Scanner(System.in);
        System.out.println("*** Modify Voucher ***");
        System.out.println("*********************");
        do {
            boolean found = false;
            Voucher v1 = null;
            System.out.print("Enter the voucher ID to modify: ");
            String voucherID = input.nextLine();
            for (Voucher v : voucherList) {
                // Checking for any match for given voucherID and storing it in a variable
                if (v.getVoucherID().equals(voucherID)) {
                    v1 = v;
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Voucher not found!");
                return;
            } else if (!v1.getIsRedeemed()) // Display voucher details if voucher is not redeemed

            {
                System.out.println("Voucher Details :-");
                System.out.println("---------------------------------");
                System.out.println("Voucher ID: " + v1.getVoucherID());
                System.out.println("Issue Date: " + v1.getIssueDate());
                System.out.println("Discount: " + v1.getDiscount());
                System.out.println("---------------------------------");
            } else {
                System.out.println("Voucher has been redeemed. Cannot modify.");
                return;
            }

            System.out.println("\nModify Option:");
            System.out.println("1. Modify voucher ID");
            System.out.println("2. Modify discount rates");
            System.out.println("3. Modify another voucher");
            System.out.println("4. Back to main menu");

            // check input exception
            int choice = 0;
            do {
                choice = 0;
                try {
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    if (choice < 1 || choice > 3) {
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next(); // consume the invalid input
                }
            } while (choice < 1 || choice > 3);

            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Enter the new voucher ID: ");
                    String newVoucherID = input.nextLine();
                    v1.setVoucherID(newVoucherID);
                    System.out.println("Voucher ID has been modified.");
                    return;
                }
                case 2: {
                    int newDiscount = 0;
                    do {
                        System.out.println("Enter the new discount rate: ");
                        // input validation and error handling
                        try {
                            newDiscount = input.nextInt();
                            if (newDiscount < 0 || newDiscount > 100) {
                                System.out.println("Invalid input. Please enter a number between 0 and 100.");
                            } else {
                                v1.setDiscount(newDiscount);
                                System.out.println("Discount rate has been modified.");
                                return;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Integers only.");
                            return;
                        }
                    } while (newDiscount < 0 || newDiscount > 100);
                }
                case 3:
                    // return to modify voucher menu
                    break;
                case 4:
                    // return to main menu
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (true);
    }
}
