import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.RejectedExecutionException;

public class Voucher {
    private String voucherID;
    private Timestamp issueDate;
    private boolean isRedeemed;
    private String description;
    private static int voucherCount = 0;
    final int MAX_VOUCHER_COUNT = 30;

    public Voucher(String voucherID) {
        voucherCount++;
        if (voucherCount > MAX_VOUCHER_COUNT) {
            throw new RejectedExecutionException("Maximum voucher count reached!");
        }
        this.voucherID = voucherID;
        this.issueDate = new Timestamp(new Date().getTime());
        this.isRedeemed = false;
        this.description = (Math.random() * 8 + 5) + "%";
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

    public String getDescription() {
        return this.description;
    }

    public int getVoucherCount() {
        return voucherCount;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

    public void setIsRedeemed() {
        this.isRedeemed = true;
    }

    public void setDescription(int description) {
        this.description = description + "%";
    }
}
