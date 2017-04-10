package pucrs;

/**
 * Created by santana on 10/04/17.
 */
public class ProductAlreadyRegisteredException extends Exception {
    public ProductAlreadyRegisteredException(String msg){
        super(msg);
    }
}
