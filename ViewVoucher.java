import java.util.ArrayList;
import java.util.Scanner;

public class ViewVoucher {
    static ArrayList<Voucher> voucherList = new ArrayList<>();

    // private constuctor to prevent instantiation
    private ViewVoucher() {
    }

    public static void setVoucherList(ArrayList<Voucher> voucherList) {
        ViewVoucher.voucherList = voucherList;
    }

    // this is for user to choose what they want to view
    public static void displayOptions(ArrayList<Voucher> voucherList) {
        int choice = 0;
        ViewVoucher.voucherList = voucherList;
        Scanner input = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        do {
            System.out.println("Please select View option:");
            System.out.println("1. View all vouchers");
            System.out.println("2. View vouchers by status");
            System.out.println("3. View vouchers by ID");
            System.out.println("4. Back to main menu");
            System.out.print("Your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    ViewVoucher.viewAllVouchers();
                    break;
                case 2:
                    ViewVoucher.viewVouchersByType();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();

        } while (choice != 3);
        input.close();
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
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("Please select a voucher status:");
            System.out.println("1. Redeemed");
            System.out.println("2. Not redeemed");
            System.out.println("3. Return to previous menu");
            System.out.print("Your choice: ");
            choice = input.nextInt();

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

                    return;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
        input.close();
    }
}