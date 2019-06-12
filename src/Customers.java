import java.util.ArrayList;

public class Customers {

    public String cust_name;
    public int want_amt;

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

    public Customers() {

    }

    public Customers (String cname, int amt, ArrayList<String> bks) {

        this.cust_name = cname;
        this.want_amt = amt;
        this.list_banks = bks;
    }


}
