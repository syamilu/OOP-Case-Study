import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ViewVoucher {
    static ArrayList<Voucher> voucherList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    // private constuctor to prevent instantiation
    private ViewVoucher() {
    }

    public static void setVoucherList(ArrayList<Voucher> voucherList) {
        ViewVoucher.voucherList = voucherList;
    }

    // this is for user to choose what they want to view
    public static void displayOptions(ArrayList<Voucher> voucherList) {

        // check if no voucher available
        if (Voucher.getVoucherCount() == 0) {
            System.out.println("No voucher available!");
            return;
        }
        int choice;
        ViewVoucher.voucherList = voucherList;
        // display options
        System.out.println("*** View Voucher ***");
        System.out.println("*********************");
        do {
            System.out.println("View Option:");
            System.out.println("1. View all vouchers");
            System.out.println("2. View vouchers by status");
            System.out.println("3. View vouchers by ID");
            System.out.println("4. Back to main menu");

            // check input exception
            do {
                choice = 0;
                try {
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    if (choice < 1 || choice > 4) {
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next(); // consume the invalid input
                }
            } while (choice < 1 || choice > 4);

            input.nextLine();

            System.out.println();
            switch (choice) {
                case 1:
                    ViewVoucher.viewAllVouchers();
                    break;
                case 2:
                    ViewVoucher.viewVouchersByType();
                    break;
                case 3:
                    ViewVoucher.viewVouchersByID();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();

        } while (true);
    }

    // case 1 : view all vouchers
    private static void viewAllVouchers() {
        System.out.println();
        System.out.println("Voucher Details :-");
        for (Voucher v : voucherList) {
            System.out.println("---------------------------------");
            System.out.println("Voucher ID: " + v.getVoucherID());
            System.out.println("Issue Date: " + v.getIssueDate());
            System.out.println("Redeemed: " + v.getIsRedeemed());
            System.out.println("Description: " + v.getDescription());
            System.out.println("---------------------------------");
        }
    }

    // case 2 : view vouchers by type
    private static void viewVouchersByType() {
        int choice = 0;
        do {

            System.out.println("Please select a voucher status:");
            System.out.println("1. Redeemed");
            System.out.println("2. Not redeemed");
            System.out.println("3. Return to previous menu");
            System.out.print("Your choice: ");
            // check input exception
            do {
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

            switch (choice) {
                case 1:
                    for (Voucher v : voucherList) {
                        if (v.getIsRedeemed()) {
                            System.out.println("---------------------------------");
                            System.out.println("Voucher ID: " + v.getVoucherID());
                            System.out.println("Issue Date: " + v.getIssueDate());
                            System.out.println("Redeemed: " + v.getIsRedeemed());
                            System.out.println("Description: " + v.getDescription());
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
                case 2:
                    for (Voucher v : voucherList) {
                        if (!v.getIsRedeemed()) {
                            System.out.println("---------------------------------");
                            System.out.println("Voucher ID: " + v.getVoucherID());
                            System.out.println("Issue Date: " + v.getIssueDate());
                            System.out.println("Redeemed: " + v.getIsRedeemed());
                            System.out.println("Description: " + v.getDescription());
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    // case 3 : view vouchers by ID
    private static void viewVouchersByID() {
        boolean found = false;
        System.out.print("Enter voucher ID: ");
        String voucherID = input.nextLine();
        for (Voucher v : voucherList) {
            if (v.getVoucherID().equals(voucherID)) {
                System.out.println("---------------------------------");
                System.out.println("Voucher ID: " + v.getVoucherID());
                System.out.println("Issue Date: " + v.getIssueDate());
                System.out.println("Redeemed: " + v.getIsRedeemed());
                System.out.println("Description: " + v.getDescription());
                System.out.println("---------------------------------");
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("Voucher not found!");
        }

    }
}