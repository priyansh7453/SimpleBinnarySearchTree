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
}