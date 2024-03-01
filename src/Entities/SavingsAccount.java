package Entities;

public class SavingsAccount extends Account {

    private double balance;

    public SavingsAccount(String userName, String cpf, double balance, String passWord, int accountNumber) {
        super(userName, cpf, balance, passWord, accountNumber);

    }
}
