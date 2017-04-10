package pucrs;

/**
 * Created by santana on 06/04/17.
 */
public class Main {
    public static void main(String[] args) {
        Product product = new Product(2, "feijao", 2, 0.5F);
        Product product1 = new Product(4, "arroz", 2, 1.5F);
        Product product2 = new Product(6, "batata", 2, 6.5F);
        LinkedList list = new LinkedList();

        try {
            System.out.println("Adicionando: "+product1);
            list.addElement(product1);
            System.out.println("DAdicionando: "+product);
            list.addElement(product);
            System.out.println("DAdicionando: "+product2);
            list.addElement(product2);
            System.out.println("DAdicionando: "+new Product(5,"ae",2,0.0F));
            list.addElement(new Product(5,"ae",2,0));

            list.printLinkedList();
            System.out.println("Menor preco: "+list.getLowestPrice());

            //list = new LinkedList();
            //list.addElement(new Product(5,"ae",2,3.5F));

            try {
                System.out.println("Achou: "+list.getProductByName("batata"));
            } catch (NotFoundValueException e ){
                System.out.println(e.getMessage());
            }

            try {
                int code = 1;
                if(list.getProductByCode(code) == null){
                    System.out.println("Deu ruim");
                }
                System.out.println("Achou2: "+list.getProductByCode(2));
            } catch (NotFoundValueException e ){
                System.out.println(e.getMessage());
            }
        } catch (EmptyLinkedListException e ){
            System.out.println(e.getMessage());
        }

    }
}
