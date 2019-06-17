import java.io.*;
import java.util.ArrayList;

class Master extends Thread {


    private ArrayList<Customers> customerList;
    private ArrayList<Banks> bankList;

    public Master (){

    }

    public Master(ArrayList<Customers> c, ArrayList<Banks> b) {

        this.customerList = c;
        this.bankList = b;
    }

    @Override
    public void run() {

        for(int i=0;i< customerList.size();i++) {

            Customers c = new Customers(customerList.get(i).cust_name,customerList.get(i).want_amt,customerList.get(i).list_banks,this);
            c.setName(customerList.get(i).cust_name);
            c.start();
            //System.out.println("Customer thread created:  " + c.getName());
        }

        for(int i=0;i< bankList.size();i++) {

            Banks b = new Banks(bankList.get(i).bank_name,bankList.get(i).have_amt,this);
            b.setName(bankList.get(i).bank_name);
            b.start();
            //System.out.println("Bank thread created : " + b.getName());
        }

    }

    public void printMessages(String msg) {
        System.out.println(msg);
    }

    public void terminateMaster(String processName) {


    }
}

public class money {


    public static void  main(String args[]) throws FileNotFoundException{


        ReadInput ri = new ReadInput();
        ArrayList<Banks> banks_list = new ArrayList<>();
        ArrayList<Customers> cust_list = new ArrayList<>();

        banks_list = ri.get_banks_list("src/banks.txt");
        ArrayList<String> bank_names = new ArrayList<>();
        for(int i =0 ; i<banks_list.size();i++)
            bank_names.add(banks_list.get(i).bank_name);


        cust_list = ri.get_customer_list("src/customers.txt",bank_names);

        Master masterthread = new Master(cust_list,banks_list);
        Thread t1 = new Thread(masterthread,"MasterThread");
        t1.start();
    }

}
