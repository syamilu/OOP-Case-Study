// Syafiq: Create a Voucher class
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.RejectedExecutionException;
import java.util.ArrayList;

public class Voucher {
    private String voucherID;
    private Timestamp issueDate;
    private boolean isRedeemed;
    private String discount;
    private static int voucherCount = 0;
    final int MAX_VOUCHER_COUNT = 30;

    public Voucher() {
        //voucherCount++;
        this.voucherID = generateID();
        this.issueDate = new Timestamp(new Date().getTime()); // get current date and time using Timestamp class
        this.isRedeemed = false;
        this.discount = (int) (Math.random() * 4 + 5) + "%"; // generate a random number between 5 and 9 for discount
    }

    public String getVoucherID() {
        return this.voucherID;
    }

    public Timestamp getIssueDate() {
        return this.issueDate;
    }

    public boolean getIsRedeemed() {
        return this.isRedeemed;
    }

    public String getDiscount() {
        return this.discount;
    }

    public static int getVoucherCount() {
        return voucherCount;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

    public void setIsRedeemed() {
        this.isRedeemed = true;
    }

    public void setDiscount(int description) {
        this.discount = description + "%";
    }

    // Firdaus = generateiD and generateVoucher
    public String generateID() {

        String alphanumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890" + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(7);

        for (int i = 0; i < 7; i++) {
            int index = (int) (alphanumericString.length() * Math.random());

            sb.append(alphanumericString.charAt(index));
        }

        return sb.toString();
    }


    public void generateVoucher(ArrayList<Voucher> voucherList){


        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of voucher to generate: ");
        int num = input.nextInt();

        if (num > 0 && num <= 30) {
            for (int i = 0; i < num; i++) {
                voucherCount++;

                if(voucherCount > MAX_VOUCHER_COUNT)
                {
                    System.out.println("Maximum voucher count reached!");
                }
                else
                {
                    voucherList.add(new Voucher());
                }
            }
        } else {
            System.out.println("Invalid number of voucher to generate!");
        }
    }

    //ezlan redeemVoucher and deleteVoucher
    public static void redeemVoucher(ArrayList<Voucher> voucherList) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the voucher ID to redeem: ");
        String vouchIDclaim = scan.nextLine();

        for (Voucher voucher : voucherList) {
            if (voucher.getVoucherID().equals(vouchIDclaim)) { //check if id is redeemed
                if (!voucher.getIsRedeemed()) {
                    voucher.isRedeemed = true;
                    System.out.println("Voucher with ID " + voucher.getVoucherID() + " has been redeemed.");
                } else {
                    System.out.println("Voucher with ID " + voucher.getVoucherID() + " has already been redeemed.");
                }
                return; //return if the id is in the array
            }
        }
        System.out.println("Voucher with ID " + vouchIDclaim + " not found.");
        
    }


    public  static void deleteVoucher(ArrayList<Voucher> voucherList){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the voucher ID to delete: ");
        String vouchIDdel = scan.nextLine();    
        
        for(Voucher voucher : voucherList){
            if(voucher.getVoucherID().equals(vouchIDdel)){
                voucherList.remove(voucher); //delete id in array
                System.out.println("Voucher with ID "+voucher.getVoucherID()+" has been deleted");
            }
            
        }
        System.out.println("Voucher with ID " + vouchIDdel + " not found.");
    }
    

    public void toArrayList(){
        
    }
}
