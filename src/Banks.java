public class Banks extends Thread {

    public int have_amt;
    public String bank_name;
    Master masterProcess;

    public Banks () {

    }


    public Banks (String bname, int amt) {

        this.have_amt = amt;
        this.bank_name = bname;

    }

    public Banks (String bname, int amt, Master m) {

        this.have_amt = amt;
        this.bank_name = bname;
        this.masterProcess = m;

    }

    public int getHave_amt() {
        return have_amt;
    }

    public void setHave_amt(int have_amt) {
        this.have_amt = have_amt;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    @Override
    public void run() {


    }
}
