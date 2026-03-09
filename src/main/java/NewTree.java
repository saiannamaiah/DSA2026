import java.util.ArrayList;

public class NewTree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "node" + value;
        }

    }
    private Node root; // root of tree declared
    public void insert(int value){
        if(root == null){
            root = new Node(value);
        }

        var current = root;
        while (true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild =  new Node(value);
                    break;
                }
              current = current.leftChild;

            } else if(value > current.value){
                if(current.rightChild == null){
                    current.rightChild = new Node(value);
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        var current = root;
        while(current != null){
            if(value < current.value){
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else
                return true;
        }
        return false;
    }

    public void preOrderTraverse(){
        preOrderTraverse(root);
    }
    private void preOrderTraverse(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }
    public void inOrderTraverse(){
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node root){
        if (root == null){
            return;
        }
        preOrderTraverse(root.leftChild);
        System.out.println(root.value);
        preOrderTraverse(root.rightChild);
    }

    public void postOrderTraverse(){
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node root){
        if (root == null){
            return;
        }
        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if (root == null){
            return -1;
        }
        if(root.leftChild == null && root.rightChild == null){
            return 0;
        }
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

    public int minBinaryTree(){
       return minBinaryTree(root);
    }
    private int minBinaryTree(Node root){
        if(root.leftChild == null && root.rightChild == null){
            return root.value;
        }
        var left = minBinaryTree(root.leftChild);
        var right = minBinaryTree(root.rightChild);

        return Math.min(Math.min(left,right),root.value);
    }

    public int minBinarySearchTree(){
        if(root == null){
            throw new IllegalStateException();
        }
        var current = root;
        var last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public boolean equals(NewTree other){
        return equals(root,other.root);
    }

    private boolean equals(Node first, Node second){
        if(first == null && second == null){
            return true;
        }
        if(first != null && second != null){
            return first.value == second.value && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild,second.rightChild);
        }
        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.value < min || root.value > max){
            return false;
        }
        return isBinarySearchTree(root.leftChild,min,root.value - 1)
                && isBinarySearchTree(root.rightChild,root.value + 1, max);
    }

    public ArrayList<Integer> getNodeValuesByIndexes(int distance){
        var list = new ArrayList<Integer>();
        getNodeValuesByIndexes(root,distance,list);
        return list;

    }
    private void getNodeValuesByIndexes(Node root, int distance,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        if(distance == 0){
            System.out.println(root.value);
            list.add(root.value);
            return;
        }

        getNodeValuesByIndexes(root.leftChild,distance - 1,list);
        getNodeValuesByIndexes(root.rightChild,distance - 1 ,list);

    }

}
