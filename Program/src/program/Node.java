package program;

public class Node {
    Node parent;
    Node leftChild;
    Node rightChild;
    Node check;
    private int key;
    private int depth;
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
    public void setKey(int temp){
        key = temp;
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
    public int getDepth(){
        check = this;
        depth = 0;
        while (check.getParent() != null){
            check = check.getParent();
            depth++;
        }
        return depth;
    }
    public int howManyChilren(){
        if(rightChild==null&&leftChild==null){
            return 0;
        }else if((rightChild==null&&leftChild!=null)||(rightChild!=null&&leftChild==null)){
            return 1;
        }else{
            return 2;
        }
    }
}
