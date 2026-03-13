public class AVLTrees {

    private class AVLNodeTree{
        private int value;
        private int height;
        private AVLNodeTree leftChild;
        private AVLNodeTree rightChild;

        public AVLNodeTree(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "AVLtree" + value;
        }


    }

    private AVLNodeTree root;

    public void insert(int value){
        root = insert(root,value);
    }

    private AVLNodeTree insert(AVLNodeTree root, int value){
        if(root == null){
            return new AVLNodeTree(value);
        }
        if(value < root.value){
            root.leftChild = insert(root.leftChild,value);
        } else{
            root.rightChild = insert(root.rightChild,value);
        }
        setHeight(root);

        return  balance(root);
    }

    private int height(AVLNodeTree node){
        return ((node == null) ? -1 : node.height);
    }

    private boolean isLeftHeavy(AVLNodeTree node){
            return balancer(node) > 1;
    }
    private boolean isRightHeavy(AVLNodeTree node){
            return balancer(node) < -1;
    }

    private int balancer(AVLNodeTree node){
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private AVLNodeTree balance(AVLNodeTree root){
        if(isLeftHeavy(root)){
            System.out.println(root.value + "Is Left heavy ");
            if (balancer(root.leftChild) < 0){
               root.leftChild = rotateLeft(root.leftChild);
            }
             return rotateRight(root);
        } else if (isRightHeavy(root)) {
            System.out.println(root.value + "is right heacy");
            if (balancer(root.rightChild) > 0){
                root.rightChild = rotateRight(root.rightChild);
            }
            return rotateLeft(root);
        }

        return root;
    }

    private AVLNodeTree rotateLeft(AVLNodeTree root){
        var newRoot = root.rightChild;
        root.leftChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }
    private AVLNodeTree rotateRight(AVLNodeTree root){
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNodeTree root){
        root.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;
    }
}
