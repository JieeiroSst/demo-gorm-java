package dto;

public class Account {
    private int AccountNo;
    private String CustomerName;
    private String Passwd;
    private int Amount;

    public Account(){}

    public int getAccountNo() {
        return AccountNo;
    }

    public int getAmount() {
        return Amount;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void setAccountNo(int accountNo) {
        AccountNo = accountNo;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }
}
