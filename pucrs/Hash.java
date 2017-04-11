package pucrs;

import java.util.ArrayList;

/**
 * Created by santana on 09/04/17.
 */
public class Hash {

    private static final int sizeTable = 13;
    private ArrayList<LinkedList> tableProduct;

    public Hash() {
        this.tableProduct = new ArrayList<>(sizeTable);
        this.initializeArray();
    }

    private void initializeArray(){
        for(int i = 0 ; i < sizeTable ; i++){
            this.tableProduct.add(new LinkedList());
        }
    }

    public void addElement(Product product) throws ProductAlreadyRegisteredException{
        int pos = this.hashCode(product.getCod());
        try{
            this.tableProduct.get(pos).getProductByCode(product.getCod());
            throw new ProductAlreadyRegisteredException("Produto ("+product.getCod()+") ja cadastrado");
        } catch (EmptyLinkedListException | NotFoundValueException e){
            this.tableProduct.get(pos).addElement(product);
            System.out.println("Produto ("+product.getCod()+") cadastrado com sucesso. -> Tabela: "+pos);
        }
    }

    private int hashCode(int code){
        return code % sizeTable;
    }

    public void removeElement(int code){
        int pos = this.hashCode(code);
        try{
            System.out.println("Produto: "+this.tableProduct.get(pos).getProductByCode(code)+" - removido");
            this.tableProduct.get(pos).removeElement(code);
        } catch (EmptyLinkedListException | NotFoundValueException e){
            System.out.println(e.getMessage());
        }

    }

    public Product getProductByName(String name) throws NotFoundValueException{
        Product product = null;
        for( LinkedList list : this.tableProduct){
            try {
                product = list.getProductByName(name);
            } catch (EmptyLinkedListException | NotFoundValueException e){
                //dont do anything
                continue;
            }
        }
        if(product == null){
            throw new NotFoundValueException("Product ("+name+") nao existe");
        }
        return product;
    }

    public void getProductByCode(int code){
        int pos = this.hashCode(code);
        try{
            System.out.println(this.tableProduct.get(pos).getProductByCode(code));
        } catch (EmptyLinkedListException|NotFoundValueException e){
            System.out.println("Code("+code+") nao esta na lista");
        }
    }

    public Product getLowestPrice() throws EmptyLinkedListException {
        Product lowPrice = null;
        for(LinkedList list : this.tableProduct){
            if(list.isEmpty()){
                continue;
            }
            if(lowPrice == null){
                lowPrice = list.getLowestPrice();
            } else if(lowPrice.getPrice() > list.getLowestPrice().getPrice()){
                lowPrice = list.getLowestPrice();
            }
        }
        if(lowPrice == null){
            throw new EmptyLinkedListException("Listas vazias");
        }

        return lowPrice;
    }

    public void printAllProducts(){
        int cont = 0;
        for(LinkedList list : this.tableProduct){
            try {
                System.out.println("Posicao: "+cont);
                list.printLinkedList();
            } catch (EmptyLinkedListException e){
                System.out.println(e.getMessage());
            } finally {
                cont++;
            }
        }
    }
}
