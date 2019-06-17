import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadInput {

    public ArrayList<Banks> get_banks_list ( String file_banks) {

        ArrayList<Banks> bank_strings = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(file_banks))){
            String line = null;
            while((line = fileReader.readLine()) != null){
                if(line.trim().length() == 0)
                    continue;
                else {
                    line = line.trim().replace(".","");
                    line = line.trim().replace("{","");
                    line = line.trim().replace("}","");

                    String tokens[] = line.split(",");

                    Banks b1 = new Banks(tokens[0],Integer.parseInt(tokens[1]));

                    bank_strings.add(b1);

                }
            }

        }catch (IOException e){
            //e.printStackTrace();
            System.out.println("Error reading file");
        }

        System.out.println("** Bank and financial resources **");

        for(int i=0;i<bank_strings.size();i++) {

            Banks temp = new Banks();
            temp = bank_strings.get(i);
            System.out.println(temp.bank_name + ": " + temp.have_amt);
        }

            return  bank_strings;

    }


    public ArrayList<Customers> get_customer_list (String cust_fname, ArrayList<String> banks_list) {
        ArrayList<Customers> cust_list = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(cust_fname))){
            String line = null;
            while((line = fileReader.readLine()) != null){
                if(line.trim().length() == 0)
                    continue;
                else {
                    line = line.trim().replace(".","");
                    line = line.trim().replace("{","");
                    line = line.trim().replace("}","");
                    //System.out.println(line);

                    String tokens[] = line.split(",");

                    Customers c1 = new Customers(tokens[0],Integer.parseInt(tokens[1]),banks_list);

                    cust_list.add(c1);

                }
            }

        }catch (IOException e){
            //e.printStackTrace();
            System.out.println("Error reading file");
        }

        System.out.println("** Customers and loan objectives**");

        for(int i=0;i<cust_list.size();i++) {

            Customers temp = new Customers();
            temp = cust_list.get(i);
            System.out.println(temp.cust_name + ": " + temp.want_amt);
        }
/*       for(int i=0;i<cust_list.size();i++) {

            Customers temp = new Customers();
            temp = cust_list.get(i);
            System.out.println(temp.cust_name + ":" + temp.want_amt + temp.list_banks );
        }*/


        return cust_list;
    }
}
