import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;
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
        this.voucherID = generateID();
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

    //Firdaus = generateiD and generateVoucher
    public String generateID(){

        String alphanumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890" + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(10);

        for(int i = 0;i<10;i++)
        {
            int index = (int)(alphanumericString.length() * Math.random());

            sb.append(alphanumericString.charAt(index));
        }

        return sb.toString();
    }

    public void generateVoucher(){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of voucher to generate: ");
        int num = input.nextInt();

        if(num > 0 && num <= 30)
        {
            for(int i = 0;i<num;i++)
            {
                voucherCount++;

                if(voucherCount > MAX_VOUCHER_COUNT)
                {
                    throw new RejectedExecutionException("Maximum voucher count reached!");
                }
                else
                {
                    System.out.println("Voucher #" + (i+1) + ":");
                    System.out.println("Voucher ID: " + generateID());
                    System.out.println("Issue Date: " + new Timestamp(new Date().getTime()));
                    System.out.println("Is Redeemed: " + false);
                    System.out.printf("Discount: %.2f\n ",(Math.random() * 8 + 5));
                    System.out.println();
                }
            }
        }
        else
        {
            System.out.println("Invalid number of voucher to generate!");
        }
        
    }
}
