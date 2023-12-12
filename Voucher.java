import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.RejectedExecutionException;
import java.util.ArrayList;

public class Voucher {
    private String voucherID;
    private Timestamp issueDate;
    private boolean isRedeemed;
    private String description;
    private static int voucherCount = 0;
    final int MAX_VOUCHER_COUNT = 30;

    public Voucher() {
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

    public void generateVoucher(ArrayList<Voucher> voucherList){

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
                    System.out.println("Maximum voucher count reached!");
                }
                else
                {
                    voucherList.add(new Voucher());
                }
            }
        }
        else
        {
            System.out.println("Invalid number of voucher to generate!");
        }
        
    }

    public void toArrayList(){
        
    }
}
