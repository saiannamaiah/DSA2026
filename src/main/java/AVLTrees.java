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
        root.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;

        if(isLeftHeavy(root)){
            System.out.println(root.value + "Is Left heavy ");
        } else if (isRightHeavy(root)) {
            System.out.println(root.value + "is right heacy");
        }
        return root;

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

}
