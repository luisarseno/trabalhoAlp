package pucrs;

/**
 * Created by santana on 06/04/17.
 */
public class Product {

    private int cod;
    private String name;
    private int setor;
    private double price;

    public Product(int cod, String name, int setor, double price) {
        this.cod = cod;
        this.name = name;
        this.setor = setor;
        this.price = price;
    }

    public int getCod() {
        return cod;
    }

    public String getName() {
        return name;
    }

    public int getSetor() {
        return setor;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "cod=" + cod +
                ", name='" + name + '\'' +
                ", setor=" + setor +
                ", price=" + price +
                '}';
    }
}
