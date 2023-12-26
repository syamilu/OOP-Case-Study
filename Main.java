import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Iterator;

public class Main {
    // Wan Muhammad Syamil(2220561) - main method
    public static void main(String[] args) {
        ArrayList<Voucher> voucherList = new ArrayList<>();
        int choice = 0;
        Scanner input;

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

            // input exception handling
            do {
                input = new Scanner(System.in);
                choice = 0;
                try {
                    System.out.print("Your choice: ");
                    choice = input.nextInt();
                    if (choice < 1 || choice > 6) {
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next(); // consume the invalid input
                }
            } while (choice < 1 || choice > 6);

            System.out.println();
            switch (choice) {

                case 1:

                    generateVoucher(voucherList);
                    break;
                case 2:
                    redeemVoucher(voucherList);
                    break;
                case 3:
                    modifyVoucher(voucherList);
                    break;
                case 4:
                    deleteVoucher(voucherList);
                    break;
                case 5:
                    viewVoucher(voucherList);
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

    // Saiful Ezlan(2221095) redeemVoucher and deleteVoucher
    public static void redeemVoucher(ArrayList<Voucher> voucherList) {
        Scanner scan = new Scanner(System.in);
        // Input validation loop
        String vouchIDclaim;
        do {
            try {
                System.out.print("Enter the voucher ID to redeem: ");
                vouchIDclaim = scan.nextLine();

                if (vouchIDclaim.isEmpty()) {
                    throw new IllegalArgumentException("Voucher ID cannot be empty.");
                }

                break; // Exit the loop if the input is valid
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        for (Voucher voucher : voucherList) {
            if (voucher.getVoucherID().equals(vouchIDclaim)) { // check if id is redeemed
                if (!voucher.getIsRedeemed()) {
                    voucher.setIsRedeemed();
                    System.out.println("Voucher with ID " + voucher.getVoucherID() + " redeemed.");
                } else {
                    System.out.println("Voucher with ID " + voucher.getVoucherID() + " has already been redeemed.");
                }
                return; // return if the id is in the array
            }
        }
        System.out.println("Voucher with ID " + vouchIDclaim + " not found.");
    }

    // Saiful Ezlan(2221095) redeemVoucher and deleteVoucher
    public static void deleteVoucher(ArrayList<Voucher> voucherList) {
        Scanner scan = new Scanner(System.in);
        // Input validation loop
        String vouchIDdel;
        do {
            try {
                System.out.print("Enter the voucher ID to delete: ");
                vouchIDdel = scan.nextLine();

                if (vouchIDdel.isEmpty()) {
                    throw new IllegalArgumentException("Voucher ID cannot be empty.");
                }

                break; // Exit the loop if the input is valid
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        // Using an iterator to safely remove elements
        Iterator<Voucher> iterator = voucherList.iterator();
        while (iterator.hasNext()) { // iterator is the current element
            Voucher voucher = iterator.next();
            if (voucher.getVoucherID().equals(vouchIDdel)) {
                iterator.remove(); // use iterator to remove the current element
                System.out.println("Voucher with ID " + voucher.getVoucherID() + " deleted");
                if (voucher.getIsRedeemed()) {
                    int countt = Voucher.getVoucherCount() - 1;// minus one voucher count
                    voucher.setVoucherCount(countt);
                }
                return; // exit method after removing voucher ID
            }
        }

        System.out.println("Voucher with ID " + vouchIDdel + " not found.");
    }

    // Syafiq(2220697): Method to modify voucher
    public static void modifyVoucher(ArrayList<Voucher> voucherList) {
        Scanner input = new Scanner(System.in);

        if (unredeemCount(voucherList) == 0) {
            System.out.println("No new voucher available!");
            return;
        }

        System.out.println("**********************");
        System.out.println("*** Modify Voucher ***");
        System.out.println("**********************");
        do {
            boolean found = false;
            Voucher v1 = null;
            if (unredeemCount(voucherList) == 1) {
                // Skipping input prompt if there's only one unredeemed voucher in the
                // voucherList
                for (Voucher v : voucherList) {
                    if (!v.getIsRedeemed()) {
                        v1 = v;
                        found = true;
                        break;
                    }
                }
                System.out.println("No. of available vouchers: 1");
            } else {
                do {
                    char choice = 'Y';
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
                        System.out.println("Voucher not found!\n");
                        do {
                            System.out.println("Do you want to modify another voucher? (Y/N)");
                            try {
                                choice = input.next().charAt(0);
                                if (choice == 'N' || choice == 'n') {
                                    return;
                                } else if (!(choice == 'Y' || choice == 'y')) {
                                    System.out.println("Invalid input. Please enter Y or N.\n");
                                } else {
                                    input.nextLine();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter one character only.");
                                input.next(); // consume the invalid input
                            }
                        } while (!(choice == 'Y' || choice == 'y'));
                    } else {
                        break;
                    }
                } while (!found);
            }

            if (v1 != null && !v1.getIsRedeemed() && found)
            // Display voucher details if voucher is found AND redeemed
            {
                System.out.println("Voucher Details :-");
                System.out.println("---------------------------------");
                System.out.println("Voucher ID: " + v1.getVoucherID());
                System.out.println("Issue Date: " + v1.getIssueDate());
                System.out.println("Discount: " + v1.getDiscount());
                System.out.println("---------------------------------");

                System.out.println("\nModify Option:");
                System.out.println("1. Modify voucher ID");
                System.out.println("2. Modify discount rates");
                System.out.println("3. Back to main menu");

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
                        String newVoucherID;
                        boolean unique;
                        do {
                            unique = false;
                            System.out.println("\nEnter the new voucher ID: ");
                            newVoucherID = input.nextLine();

                            // Validate newVoucherID input to only accept alphanumeric characters
                            if (!newVoucherID.matches("^[a-zA-Z0-9]*$")) {
                                System.out.println("Invalid input! Only alphanumeric characters are allowed.");
                            } else {
                                for (Voucher v : voucherList) {
                                    // checks if the new voucher ID already exists
                                    if (newVoucherID.equals(v.getVoucherID())) {
                                        System.out.println("Voucher ID " + newVoucherID + " already exists!");
                                        unique = true;
                                        break;
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        } while (!newVoucherID.matches("^[a-zA-Z0-9]*$") || unique);

                        v1.setVoucherID(newVoucherID);
                        System.out.println("Voucher ID has been modified.");
                        break;
                    }
                    case 2: {
                        int newDiscount = 0;
                        do {
                            System.out.println("\nEnter the new discount rate: ");
                            // input validation and error handling
                            try {
                                newDiscount = input.nextInt();
                                if (newDiscount < 1 || newDiscount > 100) {
                                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                                } else if (v1.getDiscount().equals(newDiscount + "%")) {
                                    System.out.println("Discount rate is the same as the current discount rate.");
                                    break;
                                } else {
                                    v1.setDiscount(newDiscount);
                                    System.out.println("Discount rate has been modified.");
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Integers only.");
                                return;
                            }
                        } while (newDiscount < 1 || newDiscount > 100);
                        break;
                    }
                    case 3:
                        // return to main menu
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } else if (v1.getIsRedeemed()) {
                System.out.println("Voucher has already been redeemed! Cannot modify voucher details.");
                return;
            }

            char continueChoice = 'Y';
            do {
                if (unredeemCount(voucherList) > 1)
                    System.out.println("\nDo you want to modify another voucher? (Y/N)");
                else
                    System.out
                            .println("\nDo you want to modify voucher with ID " + v1.getVoucherID() + " again? (Y/N)");
                try {
                    continueChoice = input.next().charAt(0);
                    if (continueChoice == 'N' || continueChoice == 'n') {
                        return;
                    } else if (!(continueChoice == 'Y' || continueChoice == 'y')) {
                        System.out.println("Invalid input. Please enter Y or N.");
                    } else {
                        input.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter one character only.");
                    input.next(); // consume the invalid input
                }
            } while (!(continueChoice == 'Y' || continueChoice == 'y'));
        } while (true);
    }

    public static int NewVoucherCount(ArrayList<Voucher> voucherList) {
        int count = 0;
        for (Voucher v : voucherList) {
            if (v.getIsRedeemed() == false) {
                count++;
            }
        }
        return count;
    } // end of Syafiq's method! :D

    // Wan Muhammad Syamil(2220561) : Method to view voucher
    public static void viewVoucher(ArrayList<Voucher> voucherList) {
        // check if no voucher available
        if (voucherList.isEmpty()) {
            System.out.println("No voucher available!");
            return;
        }

        Scanner input = new Scanner(System.in);
        boolean found = false;

        System.out.println("*********************");
        System.out.println("*** VIEW VOUCHER ***");
        System.out.println("*********************");

        int choice;
        // display options
        do {
            System.out.println("View Voucher Option:");
            System.out.println("1. View all vouchers");
            System.out.println("2. View redeemed vouchers");
            System.out.println("3. View unredeemed vouchers");
            System.out.println("4. View vouchers by ID");
            System.out.println("5. Back to main menu");

            // check input exception
            do {
                choice = 0;
                try {
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    if (choice < 1 || choice > 5) {
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next(); // consume the invalid input
                }
            } while (choice < 1 || choice > 5);

            input.nextLine();

            switch (choice) {
                case 1:
                    // all vouchers
                    System.out.println();
                    System.out.println("Voucher Details :-");
                    int i = 1;
                    for (Voucher v : voucherList) {
                        System.out.println("---------------------------------");
                        System.out.println("Voucher " + i + " :");
                        System.out.println("Voucher ID: " + v.getVoucherID());
                        System.out.println("Issue Date: " + v.getIssueDate());
                        System.out.println("Redeemed: " + v.getIsRedeemed());
                        System.out.println("Discount: " + v.getDiscount());
                        System.out.println("---------------------------------");
                        i++;
                    }
                    break;
                case 2:
                    // redeemed vouchers
                    found = false;
                    System.out.println();
                    System.out.println("Redeemed Voucher Details :-");
                    for (Voucher v : voucherList) {
                        if (v.getIsRedeemed()) {
                            System.out.println("---------------------------------");
                            System.out.println("Voucher ID: " + v.getVoucherID());
                            System.out.println("Issue Date: " + v.getIssueDate());
                            System.out.println("Redeemed: " + v.getIsRedeemed());
                            System.out.println("Discount: " + v.getDiscount());
                            System.out.println("---------------------------------");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No redeemed vouchers!");
                    }
                    break;
                case 3:
                    // not redeemed vouchers
                    found = false;
                    System.out.println();
                    System.out.println("Unredeemed Voucher Details :-");
                    for (Voucher v : voucherList) {
                        if (!v.getIsRedeemed()) {
                            System.out.println("---------------------------------");
                            System.out.println("Voucher ID: " + v.getVoucherID());
                            System.out.println("Issue Date: " + v.getIssueDate());
                            System.out.println("Redeemed: " + v.getIsRedeemed());
                            System.out.println("Discount: " + v.getDiscount());
                            System.out.println("---------------------------------");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No unredeemed vouchers!");
                    }
                    break;
                case 4:
                    // by ID
                    found = false;
                    System.out.println();
                    System.out.print("Enter voucher ID: ");
                    String voucherID = input.nextLine();
                    for (Voucher v : voucherList) {
                        if (v.getVoucherID().equals(voucherID)) {
                            System.out.println("---------------------------------");
                            System.out.println("Voucher ID: " + v.getVoucherID());
                            System.out.println("Issue Date: " + v.getIssueDate());
                            System.out.println("Redeemed: " + v.getIsRedeemed());
                            System.out.println("Discount: " + v.getDiscount());
                            System.out.println("---------------------------------");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Voucher not found!");
                    }
                    break;
                case 5:
                    // return to main menu
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        } while (true);
    }

    public static int unredeemCount(ArrayList<Voucher> voucherList) {
        int count = 0;
        for (Voucher v : voucherList) {
            if (v.getIsRedeemed() == false) {
                count++;
            }
        }
        return count;
    } // end of Syafiq's method! :D

    // Firdaus
    // 2222041
    // Method to generate voucher
    public static void generateVoucher(ArrayList<Voucher> voucherList) {

        Scanner input = new Scanner(System.in);
        int num = 0;
        int voucherCount = Voucher.getVoucherCount();

        System.out.println("************************");
        System.out.println("*** GENERATE VOUCHER ***");
        System.out.println("************************");

        if (voucherList.size() == Voucher.MAX_VOUCHER_COUNT) {
            System.out.println("Unable to generate voucher. Maximum voucher count reached.");
            return;
        }

        // Input validation loop
        do {
            System.out.println("\nEnter the number of vouchers to generate: ");
            System.out.println("Enter 0 to cancel.");
            System.out
                    .println("Maximum number of vouchers allowed: " + (Voucher.MAX_VOUCHER_COUNT - voucherList.size()));
            try {
                num = input.nextInt();
                if (num >= 'a' && num <= 'z' || num >= 'A' && num <= 'Z')// check if input is not integer
                {
                    System.out.println("Invalid input. Please enter an integer.");
                } else if (num < 0 || num > Voucher.MAX_VOUCHER_COUNT) // check if input is not between 1 and 30
                {
                    System.out.println(
                            "Invalid input. Please enter a number between 1 and " + Voucher.MAX_VOUCHER_COUNT + ".");
                } else if(num == 0){
                    return;
                }else if ((voucherCount += num) > Voucher.MAX_VOUCHER_COUNT) // check if input is more than 30
                {
                    System.out.println("Unable to generate voucher. Maximum voucher count reached.");
                    voucherCount -= num; // reset voucher count
                } else // generate voucher
                {
                    voucherCount += num;
                    for (int i = 0; i < num; i++) {
                        voucherList.add(new Voucher());
                    }
                    System.out.println(num + " voucher generated successfully!");
                    break; // exit loop
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }

        } while (num >= 'a' && num <= 'z' || num >= 'A' && num <= 'Z' || num < 1
                || num > (Voucher.MAX_VOUCHER_COUNT - voucherList.size()));
        // end of input validation loop

    }

}