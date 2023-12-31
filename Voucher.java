
// Syafiq (2220697): Voucher class
import java.sql.Timestamp;
import java.util.Date;

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
        Voucher.voucherCount = voucherCount;
    }

    // Firdaus
    // 2222041
    // generateiD method
    public String generateID() {

        // generate a random alphanumeric string of length 7
        String alphanumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890" + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(7);

        // generate a random index number and append the character at that index to the
        // string builder
        for (int i = 0; i < 7; i++) {
            int index = (int) (alphanumericString.length() * Math.random());

            sb.append(alphanumericString.charAt(index));
        }

        return sb.toString();
    }
}