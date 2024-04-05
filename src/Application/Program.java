// Objetivo 1: fazer com que o accountNumber acrescente a cada objeto conta criada.
// Objetivo 2: mudar o metodo transfer da SavingsAccount.

package Application;

import Entities.Account;
import Entities.CheckingAccount;
import Entities.SavingsAccount;
import Service.BrazilTaxService;
import Service.LoanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Pegando o numero de contas a ser instanciado
        System.out.print("How many accounts do you wanna start? ");
        int n = sc.nextInt();

        //Criando a lista de contas
        List<Account> accountList = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            System.out.println("Account number #" + i);

            // Pegando dados do usuario
            System.out.println("Register your account!");

            //Vendo se a conta eh poupanca ou corrente
            System.out.print("Savings Account or Checking Account (s/c): ");
            String sCheck = sc.next().toLowerCase().strip();
            char check = sCheck.charAt(0);

            if(check == 's') {
                System.out.print("Username: ");
                String username = sc.next();
                System.out.print("CPF: ");
                String cpf = sc.next();
                System.out.print("Password: ");
                String password = sc.next();

                //Instanciando uma Conta poupanca com os dados obtidos e a colocando na lista
                accountList.add(new SavingsAccount(username, cpf, 0, password, i));
            } else if(check == 'c') {
                System.out.print("Username: ");
                String username = sc.next();
                System.out.print("CPF: ");
                String cpf = sc.next();
                System.out.print("Password: ");
                String password = sc.next();

                //Instanciando uma Conta poupanca com os dados obtidos e a colocando na lista
                accountList.add(new CheckingAccount(username, cpf, 0, password, i));
            }
        }

        //Verificando de o usario deseja realizar algum emprestimo
        System.out.print("Deseja realizar um emprestimos (s/n): ");
        String sCheck = sc.next().strip().toLowerCase();
        char check = sCheck.charAt(0);

        //Fazendo o if da verificacao
        if(check == 's') {
            //Pegando os dados do emprestimo
            System.out.println("Com qual conta deseja realizar o emprestimo?");
            System.out.print("Digite o numero da conta: ");
            int number = sc.nextInt();
            System.out.print("Digite o cpf do titular: ");
            String cpf = sc.next();
            System.out.print("Digite a senha da conta: ");
            String password = sc.next();

            //Verificando a qual conta sera o emprestimo
            for(int i=0; i<accountList.size(); i++) {
                if(accountList.get(i).get_accountNumber() == number && accountList.get(i).get_cpf() == cpf && accountList.get(i).get_passWord() == password) {
                    Account account = accountList.get(i);

                    LoanService loanService = new LoanService(account, new BrazilTaxService());

                    System.out.println("Foi possivel acessar a conta!");
                    System.out.print("Qual o valor do emprestimo: ");
                    double amount = sc.nextDouble();
                    System.out.println("Qual a quantidade de parcelas que deseja pagar: ");
                    int installmentQuantity = sc.nextInt();

                    System.out.println(loanService.loan(amount, installmentQuantity));

                } else {
                    System.out.println("Nao foi possivel acessar a conta para efetuar o emprestimo");
                }
            }
        }

        sc.close();
    }
}