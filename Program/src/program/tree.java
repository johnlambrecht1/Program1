package program;

import com.sun.net.httpserver.Authenticator;
import java.util.Collections;

public class tree {
    Node parent;
    Node rightChild;
    Node leftChild;
    Node root;
    tree(){
        parent = null;
    }

    void buildTree(int key){
        Node n = new Node(key);
        if (root == null ){
            root = n;
//            if (root.getParent()==null){
//                System.out.println("null");
//            }
            return;
        }
        while (root.getParent()!=null){
            root=root.getParent();
        }
        while(n.getParent()==null){
            if (root.getKey()>n.getKey()&&root.getLeftChild()==null){
                root.setLeftChild(n);
                n.setParent(root);
            }else if (root.getKey()>n.getKey()&&root.getLeftChild()!=null){
                root = root.getLeftChild();
            }else if(root.getKey()<n.getKey()&&root.getRightChild()==null){
                root.setRightChild(n);
                n.setParent(root);
            }else if (root.getKey()<n.getKey()&&root.getRightChild()!=null){
                root = root.getRightChild();
            }
        }
//        System.out.println(n.getParent().getKey());

    }
    Node searchTree(Node current, int value){
//        System.out.println(root.getKey());
        if (current.getKey()==value){
            return current;
        }
        else if (current.getKey()>value){
            return searchTree(current.getLeftChild(), value);
        }
        else if (current.getKey()<value){
            return searchTree(current.getRightChild(), value);
        }
        else {
            return null;
        }
    }
    void printtree(){
        Node printroot = getRoot();
        int depth = maxdepth(printroot);
        printNode(printroot, 1, depth);
    }
    void makeArray(Node node){
        
    }
    void printNode(Node node, int level, int depth){
        int floor = depth-level;
        int lines = (int) Math.pow(2, (Math.max(floor-1,0)));
        int startSpaces = (int) Math.pow(2, (floor))-1;
        int betweenSpaces=(int) Math.pow(2, (floor+1))-1;
        printWhitespaces(startSpaces);


    }

    void printWhitespaces(int count){
        for (int i = 0; i<count; i++){
            System.out.print(" ");
        }
    }
    int maxdepth(Node node){
        if (node == null){
            return 0;
        }
        int left=maxdepth(node.getLeftChild());
        int right = maxdepth(node.getRightChild());
        return Math.max(left,right)+1;
    }
    void assignDepth(Node node){
        if (node == null){
            return;
        }
        assignDepth(node.getLeftChild());
        assignDepth(node.getRightChild());
        node.getDepth();
    }
    Node getRoot(){
        while (root.getParent()!=null){
            root = root.getParent();
        }
        return root;
    }
    void delete(Node delNode){
        Node delRoot = getRoot();
        int rootkey = delRoot.getKey();
        int children = delNode.howManyChilren();
        if (children == 2){//If deleted node has 2 children
            Node Successor = inOrderSuccessor(delNode);//swaps keys of del and Successor, then deletes successor
            int Temp = Successor.getKey();
            delNode.setKey(Successor.getKey());
            Successor.setKey(Temp);
            delete(Successor);
        }else if (children==1){//If deleted node has 1 child
            if(delNode.getLeftChild()!=null){//If child of deleted node is left child
                delNode.getLeftChild().setParent(delNode.getParent());
                if (delNode.getParent().getLeftChild()==delNode){//If deleted node is a left child
                    delNode.getParent().setLeftChild(delNode.getLeftChild());
                }else if(delNode.getParent().getRightChild()==delNode){//If deleted node is a left child
                    delNode.getParent().setRightChild(delNode.getLeftChild());
                }
            }else if (delNode.getRightChild()!= null){//If child of deleted node is right child
                delNode.getRightChild().setParent(delNode.getParent());
                if (delNode.getParent().getLeftChild()==delNode){//If deleted node is a left child
                    delNode.getParent().setLeftChild(delNode.getRightChild());
                }else if(delNode.getParent().getRightChild()==delNode){//If deleted node is a right child
                    delNode.getParent().setRightChild(delNode.getRightChild());
                }
            }
        }else{//If node has no children
            if(delNode.getParent().getLeftChild()==delNode){//if node is a left child
                delNode.getParent().setLeftChild(null);
            }else if(delNode.getParent().getRightChild()==delNode){//if node is a right child
                delNode.getParent().setRightChild(null);
            }
            delNode.setParent(null);
        }
    }
    Node inOrderSuccessor(Node node) {
        Node succ;
        if (node.getRightChild() != null) {
            succ = node.getRightChild();
            while (succ.getLeftChild() != null) {
                succ = succ.getLeftChild();
            }
        } else {
            succ = node;
        }
        return succ;
    }
    void InOrder(Node node){
        if (node == null){
            return;
        }
        InOrder(node.getLeftChild());
        System.out.println(node.getKey());
        InOrder(node.getRightChild());
    }
    void PreOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.getKey());
        PreOrder(node.getLeftChild());
        PreOrder(node.getRightChild());
    }
    void PostOrder(Node node){
        if (node == null){
            return;
        }
        PostOrder(node.getLeftChild());
        PostOrder(node.getRightChild());
        System.out.println(node.getKey());
    }
}
