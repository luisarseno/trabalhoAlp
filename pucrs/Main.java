package pucrs;

import java.util.Scanner;

/**
 * Created by santana on 06/04/17.
 */
public class Main  {
    public static Scanner read = new Scanner(System.in);
    public static Hash tableHash = new Hash();
    public static void main(String[] args) {
        int op;
        while(true){
            menu();
            op = read.nextInt();
            switch (op){
                case 1:
                    cadastraProduto();
                break;
                case 2:
                    pegaProdutoCodigo();
                break;
                case 3:
                    pegaProdutoName();
                break;
                case 4:
                    removerProduto();
                break;
                case 5:
                    informaMaisBarato();
                break;
                case 6:
                    exibeTodosProdutos();
                break;
                default:
                break;
            }

            if(op >= 7){
                break;
            }
        }
    }

    public static void menu(){
        System.out.println("Menu de opcoes: ");
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
        try {
            tableHash.addElement(produto);
        } catch (ProductAlreadyRegisteredException e){
            System.out.println(e.getMessage());
        }
    }

    public static void pegaProdutoCodigo(){
        System.out.println("\tProcurar produto pelo codigo\n");
        System.out.println("Informe o codigo");
        int codigo = read.nextInt();
        tableHash.getProductByCode(codigo);
    }

    public static void pegaProdutoName(){
        System.out.println("\tProcurar produto pelo codigo\n");
        System.out.println("Informe o codigo");
        int codigo = read.nextInt();
        tableHash.getProductByCode(codigo);
    }

    public static void removerProduto(){

    }

    public static void informaMaisBarato(){
        System.out.println("\tProduto mais barato\n");
        try {
            System.out.println(tableHash.getLowestPrice());
        } catch (EmptyLinkedListException e){
            System.out.println(e.getMessage());
        }
    }

    public static void exibeTodosProdutos(){
        System.out.println("\tTodos os produtos\n");
        tableHash.printAllProducts();
    }
}
