package pucrs;

import java.util.ArrayList;

/**
 * Created by santana on 09/04/17.
 */
public class Hash {

    private static final int sizeTable = 13;
    private ArrayList<Product> tableProduct;

    public void addElement(){

    }

    public int hashCode(Product product){
        return product.getCod() % sizeTable;
    }

    public void removeElement(Product product){

    }

    public Product getProductByName(String name){
        return null;
    }

    public Product getLowestPrice(){
        return null;
    }
}
