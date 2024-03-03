package Entities;

public class SavingsAccount extends Account {

    public SavingsAccount(String userName, String cpf, double balance, String passWord, int accountNumber) {
        super(userName, cpf, balance, passWord, accountNumber);
    }

    @Override
    public void withdraw(double ammount) {
        if(ammount <= 300) {
            if(ammount <= balance) {
                balance -= ammount;
            }
        }
    }

    @Override
    public void transfer(Account account, Double ammount) {
        if (ammount <= 1000) {
            if (ammount <= get_balance()) {
                this.withdraw(ammount);
                account.deposit(ammount);
            }
        }
    }
}
