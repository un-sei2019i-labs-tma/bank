public class Account {

    private int idAccount;
    private int balance;

    public Account() {

    }

    public Account(int idAccount, int balance) {
        this.idAccount = idAccount;
        this.balance = balance;
    }


    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdAccount() {
        return idAccount;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

}
