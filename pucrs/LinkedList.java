package pucrs;

/**
 * Created by santana on 06/04/17.
 */
public class LinkedList {

    private int size;
    private Node head;
    private Node tail;

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
        if (isEmpty()) {
            head = new Node(product);
        } else {
            Node aux = head;
            while(aux != null){
                if(aux.getNext() == null){
                    aux.setNext(new Node(product));
                    aux.getNext().setAnt(aux);
                    break;
                }
                aux = aux.getNext();
            }
        }
        size++;
    }

    public boolean removeElement(int code) throws EmptyLinkedListException, NotFoundValueException {
        if (isEmpty()) {
            throw new EmptyLinkedListException("Lista esta vazia!");
        }
        Node aux = head;
        while (aux != null) {
            if (aux.getElement().getCod() == code) {
                Node ant = aux.getAnt();
                ant.setNext(aux.getNext());
                size--;
                return true;
            }
            aux = aux.getNext();
        }

        throw new NotFoundValueException("Cod("+code+") : nao esta na lista");
    }

    public void reorderList() {
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
}
