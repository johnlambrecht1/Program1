package program;

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
            if (root.getParent()==null){
                System.out.println("null");
            }
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
        System.out.println(n.getParent().getKey());

    }
    boolean searchTree(int value){
        while (root.getParent()!=null){
            root = root.getParent();
        }
        while (root.getLeftChild().getKey()!=value&&root.getRightChild().getKey()!=value&&root.getKey()!=value){
            if(value<root.getKey()&&root.getLeftChild()!=null){
                root = root.getLeftChild();
            }else if(value>root.getKey()&&root.getRightChild()!=null){
                root = root.getRightChild();
            }else if((value>root.getKey()&&root.getRightChild()==null)||(value<root.getKey()&&root.getLeftChild()==null)){
                return false;
            }else if(value==root.getKey()||value==root.getLeftChild().getKey()||value==root.getRightChild().getKey()){
                return true;
            }
        }
    }
}
