package Entities;

public abstract class Account {

    protected final int accountNumber;
    protected String userName;
    protected final String cpf;
    protected double balance;
    protected String passWord;

    public Account(String userName, String cpf, double balance, String passWord, int accountNumber) {
        this.userName = userName;
        this.cpf = cpf;
        this.balance = balance;
        this.passWord = passWord;
        this.accountNumber = accountNumber;
    }

    public int get_accountNumber() {
        return accountNumber;
    }

    public String get_cpf() {
        return cpf;
    }

    public double get_balance() {
        return balance;
    }

    public String get_userName() {
        return userName;
    }

    public String get_passWord() {
        return passWord;
    }

    public void deposit(double ammount) {
        balance += ammount;
    }

    public void withdraw(double ammount) {
        if(ammount <= balance) {
            balance -= ammount;
        }
    }

    public void transfer(Account account, Double ammount) {
        if(ammount <= balance) {
            balance -= ammount;
            account.deposit(ammount);
        }
    }

    public String toString() {
        return "Username: "
                + userName
                + ", CPF: "
                + cpf
                + ", Balance: "
                + String.format("%.2f", balance)
                + ", Password: "
                + passWord
                + ", Account number: "
                + accountNumber;
    }


}
