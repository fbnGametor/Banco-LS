package Entities;

public abstract class Account {

    public int accountNumber;
    public String userName;
    public String cpf;
    public double balance;
    public String passWord;

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

    public abstract void withdraw(double ammount);

    public abstract void transfer(Account account, Double ammount);

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
