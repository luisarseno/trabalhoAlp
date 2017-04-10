package pucrs;

import java.util.Scanner;

/**
 * Created by santana on 06/04/17.
 */
public class Main  {
    public static Scanner read = new Scanner(System.in);
    public static Hash tableHash = new Hash();
    public static void main(String[] args) {
        while(true){
            menu();
            read.nextInt();
        }
    }

    public static void menu(){
        System.out.println("Menu de opções: ");
        System.out.println("1 - Cadastro de produtos");
        System.out.println("2 - Procurar produto pelo codigo");
        System.out.println("3 - Procurar produto pelo nome");
        System.out.println("4 - Remover produto");
        System.out.println("5 - Informar produto mais barato");
        System.out.println("6 - Exibir todos os produtos");
        System.out.println("7 - Sair");
    }

    public static void cadastraProduto(){
        System.out.println("\tCadastro de produto\n");
        System.out.println("Informe o codigo do produto: ");
        int codigo = read.nextInt();
        System.out.println("Informe o nome: ");
        String nome = read.next();
        System.out.println("Informe o setor (inteiro): ");
        int setor = read.nextInt();
        System.out.println("Informe o preco: ");
        double preco = read.nextDouble();
        Product produto =  new Product(codigo,nome,setor,preco);
    }
}
