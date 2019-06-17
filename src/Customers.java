import java.util.ArrayList;
import java.util.Random;

public class Customers extends Thread{

    public String cust_name;
    public int want_amt;
    Master masterProcess;


    public Customers() {

    }

    public Customers (String cname, int amt, ArrayList<String> bks) {

        this.cust_name = cname;
        this.want_amt = amt;
        this.list_banks = bks;
    }

    public Customers (String cname, int amt, ArrayList<String> bks, Master m) {

        this.cust_name = cname;
        this.want_amt = amt;
        this.list_banks = bks;
        this.masterProcess = m;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public int getWant_amt() {
        return want_amt;
    }

    public void setWant_amt(int want_amt) {
        this.want_amt = want_amt;
    }

    public ArrayList<String> getList_banks() {
        return list_banks;
    }

    public void setList_banks(ArrayList<String> list_banks) {
        this.list_banks = list_banks;
    }

    public ArrayList<String> list_banks;


    @Override
    public void run() {

        Random rand = new Random();
        Random rand1 = new Random();
        Customers c = new Customers(this.getCust_name(),this.want_amt,this.list_banks,masterProcess) ;
        int randomAmount = 0;
        int randomBankId = 0;
        try {
            Thread.sleep((long)(Math.random() * 1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /*System.out.println(c.getCust_name());
        System.out.println(c.getWant_amt());
        System.out.println(c.getList_banks());
*/
        if(c.getWant_amt() < 50) {
            randomAmount = rand.nextInt(c.getWant_amt()+1);
        } else {
            randomAmount = rand.nextInt(51);
        }

        randomBankId = rand1.nextInt(c.getList_banks().size());

        loanRequest(randomAmount,randomBankId,c);
        //System.out.println("random bank id is " + randomBankId);
        
        //System.out.println(randomAmount);

    }

    public void loanRequest(int randomAmt, int RandomBankId, Customers c){

        String msg = c.getCust_name() + " requests a loan of " + randomAmt + " dollar(s) from " + c.getList_banks().get(RandomBankId);
        masterProcess.printMessages(msg);

    }
}
