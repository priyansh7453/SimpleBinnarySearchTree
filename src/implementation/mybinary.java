package implementation;

//import implementation.Node;

public class mybinary{
    private Node root;

    public Boolean isEmpty(){
        if (root == null){
            return true;
        }
        else {
            return false;
        }
    }
    public void insert(int element){
        Node node = new Node(element);
        if (root == null){
            root = node;
        }
        else {
            Node temp = root;
            Node parent = null;
            while (temp!=null){
                parent = temp;
                if (element < temp.getData()){
                    temp = temp.getLeft();
                }
                else {
                    temp = temp.getRight();
                }
            }
        }
    }
    public void inOrder(Node root){
        if (root == null){
            return;
        }
        else {
            inOrder(root.getLeft());
            System.out.println(root.getData()+" ");
            inOrder(root.getRight());
        }
    }
    public Boolean search(int element){
        boolean response = false;
        Node temp = root;
        while (temp!= null){
            if (temp.getData() == element){
                response = true;
                break;
            }
            else {
                if (element < temp.getData()){
                    temp = temp.getRight();
                }
                else {
                    temp = temp.getLeft();
                }
            }
        }
        return response;
    }
    public int maxHeight(Node node){
        if (node == null){
            return 0;
        }
        else {
            return 1+ Math.max(maxHeight(node.getLeft()),maxHeight(node.getRight()));
        }
    }
    //  Delete method
    public void delete(int deletingElement){
        Node temp = root;
        Node parent = null;
        while (temp != null){
            // assign parent the value temp

            if (deletingElement == temp.getData()) {
                break;
            }
            else {
                parent = temp;
                if (deletingElement < temp.getData()) {
                    temp = temp.getLeft();
                } else  {
                    temp = temp.getRight();
                }
            }
        }
        // either temp will be null or holding reference of deleting node
        if (temp !=null) {
            // leaf case
            if (isleaf(temp)) {
                // root case
                if (temp == null) {
                    root = null;
                } else {
                    if (deletingElement < parent.getData()) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }
            } else if (hasLeafChild(temp)) {
                //root case
                if (parent == null) {
                    root = root.getLeft();
                } else {
                    if (deletingElement < parent.getData()) {
                        parent.setLeft(temp.getLeft());
                    } else {
                        parent.setRight(temp.getRight());
                    }
                }
            } else if (hasRightChild(temp)){
                // root case
                if (parent == null){
                    root = root.getRight();
                }
                else{
                    if (deletingElement < parent.getData()){
                        parent.setLeft(temp.getRight());
                    }
                    else {
                        parent.setRight(temp.getRight());
                    }
                }
            }
            Node successor = getSuccessor(temp);
            delete(successor.getData());
            successor.setLeft(temp.getLeft());
            successor.setRight(temp.getRight());
            //root case
            if(parent == null){
                root = successor;
            }
            else{
                if(deletingElement < parent.getData()){
                    parent.setLeft(successor);
                }
                else{
                    parent.setRight(successor);
                }
            }
        }
        else {
            System.out.println("cannot delete as element not present ");
        }
    }


    private boolean isleaf(Node temp){
        return temp.getLeft()== null && temp.getRight()==null;
    }

    public boolean hasLeafChild(Node temp){
        if (temp.getLeft() != null && temp.getRight()==null){
            return true;
        }
        return false;
    }

    public boolean hasRightChild(Node temp){
        if (temp.getRight() != null && temp.getLeft()==null){
            return true;
        }
        return false;
    }
    private Node getSuccessor(Node node){
        Node temp = node.getRight();
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp;
    }
}