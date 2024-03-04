// Objetivo 1: fazer com que o accountNumber acrescente a cada objeto conta criada.
// Objetivo 2: mudar o metodo transfer da SavingsAccount.

package Application;

import Entities.SavingsAccount;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int accountNumber = 1;

        // Pegando dados do usuario
        System.out.println("Register your account!");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        //Instanciando novas contas com os dados obtidos
        SavingsAccount newAccount = new SavingsAccount(username, cpf, 0, password, accountNumber);
        SavingsAccount newAccount2 = new SavingsAccount(username, cpf, 0, password, accountNumber);

        System.out.println(newAccount);

        newAccount.deposit(300);
        System.out.println("Your balance: " + newAccount.get_balance());
        System.out.println("Your balance: " + newAccount2.get_balance());

        newAccount.transfer(newAccount2,200.0);
        System.out.println("Your balance: " + newAccount.get_balance());
        System.out.println("Your balance: " + newAccount2.get_balance());




        sc.close();
    }
}