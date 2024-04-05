package Service;

import Entities.Account;

public class LoanService {

    private Account account;
    private Double amount;
    private Integer installmentQuantity;
    private Double installment;

    private TaxService taxService;

    public LoanService(Account account, TaxService taxService) {
        this.account = account;
        this.taxService = taxService;
    }

    public String loan(double amount, int installmentQuantity) {
        if(loanAllowed(account)) {
            installment = amount / installmentQuantity + taxService.tax(amount);
            account.deposit(amount);
            return "The deposit was successfully executed in the amount of $" + String.format("%.2f", amount)
                    + "with" + installmentQuantity + " installments of $" + String.format("%.2f", installment);
        } else {
            return "Loan it's not possible!";
        }
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getInstallmentQuantity() {
        return installmentQuantity;
    }

    public void setInstallmentQuantity(Integer installmentQuantity) {
        this.installmentQuantity = installmentQuantity;
    }

    private static boolean loanAllowed(Account account) {
        if(account.get_balance() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
