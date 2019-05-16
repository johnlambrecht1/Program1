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
            n=root;
            return;
        }
        while(n.getParent()==null){
            if (root.getKey()<n.getKey()&&root.getLeftChild()==null){
                root.setLeftChild(n);
                n.setParent(root);
            }else if (root.getKey()<n.getKey()&&root.getLeftChild()!=null){
                root = root.getLeftChild();
            }else if(root.getKey()>n.getKey()&&root.getRightChild()==null){
                root.setRightChild(n);
                n.setParent(root);
            }else if (root.getKey()>n.getKey()&&root.getRightChild()!=null){
                root = root.getRightChild();
            }
        }

    }
}
