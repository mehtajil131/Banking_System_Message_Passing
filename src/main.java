import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {


    public static void  main(String args[]) throws FileNotFoundException{


        ReadInput ri = new ReadInput();
        ArrayList<Banks> banks_list = new ArrayList<>();
        ArrayList<Customers> cust_list = new ArrayList<>();

        banks_list = ri.get_banks_list("/home/jil/Concordia Summer 2019/Comparitive/Project/src/banks.txt");
        ArrayList<String> bank_names = new ArrayList<>();
        for(int i =0 ; i<banks_list.size();i++)
            bank_names.add(banks_list.get(i).bank_name);
        cust_list = ri.get_customer_list("/home/jil/Concordia Summer 2019/Comparitive/Project/src/customers.txt",bank_names);

        //Master mthread = new Master();

        //Thread t1 = new Thread(mthread);


        /*
        ExecutorService executor = Executors.newCachedThreadPool();

        }*/
    }


    private static class AddNewTask implements Runnable{

        public void run(){
            System.out.println("Hello World");
        }
    }

}
