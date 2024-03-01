package Entities;

abstract class Account {

    private int accountNumber;
    private String userName;
    private String cpf;
    private double balance;
    private String passWord;

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
        balance -= ammount;
    }

    public String transfer(Account account, Double ammount) {
        //verificando se o valor eh menor que o saldo da conta
        if(ammount <= balance) {
            balance -= ammount;
            account.deposit(ammount);
            return "Your transfer was successful";
        } else {
            return "Your transfer has exceeded the balance limit";
        }
    }

    abstract String transfer(Account account, double ammount);
}
