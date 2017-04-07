package pucrs;

/**
 * Created by santana on 06/04/17.
 */
public class LinkedList {

    private int size;
    private Node head;
    private Node tail;

    private class Node{

        private Node next;
        private Node ant;
        private int element;

        public Node(int value){
            this.element = value;
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

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

    }

    public LinkedList(){
        this.size = 0;
    }

    private boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        return false;
    }

    public void addElement(int value){
        if(isEmpty()){
            head.setElement(value);
        } else {
            Node aux = head;
            Node auxProx = head.getNext();
            while(aux != null){
                if(auxProx == null){
                    auxProx = new Node(value);
                    auxProx.setAnt(aux);
                }
                aux = auxProx;
                auxProx = auxProx.getNext();
            }
        }
    }

    public boolean removeElement(int value) throws EmptyLinkedListException, NotFoundValueException{
        if(isEmpty()){
            throw new EmptyLinkedListException("Lista está vazia!");
        } else {
            Node aux = head;
            while(aux != null){
                if(aux.getElement() == value){
                    Node ant = aux.getAnt();
                    ant.setNext(aux.getNext());
                    return true;
                }
                aux = aux.getNext();
            }
        }
        throw new NotFoundValueException("Valor nao esta na lista");
    }

    public void reorderList(){
    }
}
