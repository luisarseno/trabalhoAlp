package pucrs;

/**
 * Created by santana on 06/04/17.
 */
public class LinkedList {

    private int size;
    private Node head;
    private Node tail;
    private Node lowestPrice;

    private class Node {

        private Node next;
        private Node ant;
        private Product element;

        public Node(Product product) {
            this.element = product;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getAnt() {
            return ant;
        }

        public void setAnt(Node ant) {
            this.ant = ant;
        }

        public Product getElement() {
            return element;
        }

        public void setElement(Product element) {
            this.element = element;
        }

    }

    public LinkedList() {
        this.size = 0;
    }

    private boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void addElement(Product product) {
        Node novoNodo = new Node(product);
        if (isEmpty()) {
            head = novoNodo;
            tail = novoNodo;
            lowestPrice = novoNodo;
        } else {
            if(head.getElement().getCod() > product.getCod()){
                novoNodo.setNext(head);
                head.setAnt(novoNodo);
                head = novoNodo;
            } else {
                Node aux = head;
                while (aux != null) {
                    if (aux.getElement().getCod() < product.getCod()) {
                        if(aux.equals(tail)){
                            tail = novoNodo;
                            novoNodo.setAnt(aux);
                            aux.setNext(novoNodo);
                            break;
                        }
                        aux = aux.getNext();
                    } else if (aux.getElement().getCod() > product.getCod()) {
                        aux.getAnt().setNext(novoNodo);
                        novoNodo.setAnt(aux.getAnt());
                        aux.setAnt(novoNodo);
                        novoNodo.setNext(aux);
                        break;
                    } else {
                        aux = aux.getNext();
                    }
                }
            }
        }
        if(novoNodo.getElement().getPrice() < lowestPrice.getElement().getPrice()){
            lowestPrice = novoNodo;
        }
        size++;
    }

    public void removeElement(int code) throws EmptyLinkedListException, NotFoundValueException{
        if (isEmpty()) {
            throw new EmptyLinkedListException("Lista esta vazia!");
        }
        if(head.getElement().getCod() == code){
            //primeiro elemento da lista
            head = null;
            size--;
            return;
        }
        Node aux = head;
        while (aux != null) {
            if (aux.getElement().getCod() == code) {
                Node ant = aux.getAnt();
                ant.setNext(aux.getNext());
                size--;
                return;
            }
            aux = aux.getNext();
        }
        throw new NotFoundValueException("Cod("+code+") : nao esta na lista");
    }

    public void printLinkedList() throws EmptyLinkedListException {
        if (isEmpty()) {
            throw new EmptyLinkedListException("Lista esta vazia!");
        }
        Node aux = head;
        while (aux != null){
            System.out.println(aux.getElement().toString());
            aux = aux.getNext();
        }
    }

    public Product getProductByName(String name) throws EmptyLinkedListException, NotFoundValueException{
        if (isEmpty()) {
            throw new EmptyLinkedListException("Lista esta vazia!");
        }
        Node aux = head;
        while (aux != null){
            if(aux.getElement().getName().equals(name)){
                return aux.getElement();
            }
            aux = aux.getNext();
        }
        throw new NotFoundValueException("Name("+name+") nao esta na lista");
    }

    public Product getProductByCode(int code) throws EmptyLinkedListException, NotFoundValueException{
        if (isEmpty()) {
            throw new EmptyLinkedListException("Lista esta vazia!");
        }
        Node aux = head;
        while (aux != null){
            if(aux.getElement().getCod() == code){
                return aux.getElement();
            }
            aux = aux.getNext();
        }
        throw new NotFoundValueException("Code("+code+") nao esta na lista");
    }

    public Product getLowestPrice() {
        return this.lowestPrice.getElement();
    }
}
