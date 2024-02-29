package Entities;

public class Account {

    private int _accountNumber;
    private String _userName;
    private String _cpf;
    private double _balance;
    private String _passWord;

    public Account(String _userName, String _cpf, double _balance, String _passWord, int _accountNumber) {
        this._userName = _userName;
        this._cpf = _cpf;
        this._balance = _balance;
        this._passWord = _passWord;
        this._accountNumber = _accountNumber;
    }

    public int get_accountNumber() {
        return _accountNumber;
    }

    public String get_cpf() {
        return _cpf;
    }

    public double get_balance() {
        return _balance;
    }

    public String get_userName() {
        return _userName;
    }

    public String get_passWord() {
        return _passWord;
    }

    public void deposit(double ammount) {
        _balance += ammount;
    }

    public void withdraw(double ammount) {
        _balance -= ammount;
    }

    public void transfer(Account account, Double ammount) {
        _balance -= ammount;
        account.deposit(ammount);
    }

}
