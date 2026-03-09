public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node" + value;
        }

    }

    private Node root;

    public void Insert(int value){
        if(root == null){
            root = new Node(value);
            return;
        }
        var current = root;
        while (true){
            if(value < current.value){
                if(current.leftChild == null){
                    current = new Node(value);
                    break;
                }
               current = current.leftChild;
            } else {
                if(current.rightChild == null){
                    current = new Node(value);
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        var current = root;

        while (current != null){
            if(value < current.value){
               current = current.leftChild;

            } else if(value > current.value){
                current = current.rightChild;
            }
            else
                return true;
        }

        return false;
    }

    public void preOrderTravel(){
        preOrderTravel(root);
    }
    private void preOrderTravel(Node root){

        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrderTravel(root.leftChild);
        preOrderTravel(root.rightChild);
    }

    public void postOrderTravel(){
        postOrderTravel(root);
    }
    private void postOrderTravel(Node root){
        if(root == null)
            return;
        postOrderTravel(root.leftChild);
        postOrderTravel(root.rightChild);
        System.out.println(root.value);
    }
}
