
// Syafiq: Create a Voucher class
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Voucher {
    private String voucherID;
    private Timestamp issueDate;
    private boolean isRedeemed;
    private String discount;
    private static int voucherCount = 0;
    final static int MAX_VOUCHER_COUNT = 30;

    public Voucher() {
        voucherCount++;
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

    public void setVoucherCount(int count){
        this.voucherCount = count;
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

    public void setVoucherCount(int voucherCount) {
        this.voucherCount = voucherCount;
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
}