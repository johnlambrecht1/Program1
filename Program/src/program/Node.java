package program;

public class Node {
    Node parent;
    Node leftChild;
    Node rightChild;
    private int key;
    public Node(int input){
//        System.out.println("node created");
        key = input;
    }
    public void setRightChild (Node temp){
        rightChild = temp;
    }
    public void setLeftChild (Node temp){
        leftChild = temp;
    }
    public void setParent (Node temp){
        parent = temp;
    }
    public Node getParent (){
        return parent;
    }
    public Node getLeftChild(){
        return leftChild;
    }
    public Node getRightChild(){
        return rightChild;
    }
    public int getKey(){
        return key;
    }
}
