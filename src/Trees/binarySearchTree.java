package Trees;

public class binarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    //Function to check if Tree is empty or not
    public boolean isEmpty() {
        return root == null; //if root is null then it means Tree is empty
    }


    //Iterative Function to insert a value in BST
    public boolean add(int value) {

        if(isEmpty()){
            root = new Node(value);
            return true;
        }

        Node curr = root;

        while( curr != null){
            if(value < curr.getData()){
                if(curr.getLeftChild() == null){
                    curr.setLeftChild(new Node(value));
                    return true;
                }
                curr = curr.getLeftChild();
            }else{
                if(curr.getRightChild() == null){
                    curr.setRightChild(new Node(value));
                    return true;
                }
                curr = curr.getRightChild();
            }
        }

        return false;
    }

    //Searches value in BST
    //Either returns the Node with that value or return null
    public Node search(int value){
        if(isEmpty()){
            return null;
        }

        Node curr = root;

        while(curr != null){
            if(curr.getData() == value){
                return curr;
            }else if(curr.getData() < value){
                curr = curr.getRightChild();
            }else{
                curr = curr.getLeftChild();
            }
        }
        System.out.println(value + " Not found in the Tree!");
        return null;
    }

    //3 conditions for delete
    //1.node is leaf node.
    //2.node has 1 child.
    //3.node has 2 children.
    boolean delete(int value, Node currentNode){
        if(currentNode == null){
            return false;
        }

        Node target = currentNode;
        Node parent = null;

        while(target != null){
            if(target.getData() == value){
                break;
            }else if(target.getData() < value){
                parent = target;
                target = target.getRightChild();
            }else{
                parent = target;
                target = target.getLeftChild();
            }
        }

        if(target == null){
            return false;
        }

        // 左右都为空
        if(target.getRightChild() == null && target.getLeftChild() == null){
            if(target.getData() == root.getData()){
                setRoot(null);
                return true;
            }else if(target.getData() < parent.getData()){
                parent.setLeftChild(null);
                return true;
            }else{
                parent.setRightChild(null);
                return true;
            }
        } else if(target.getRightChild() == null){ // 右为空，将左支往上移
            if(target.getData() == root.getData()){
                setRoot(target.getLeftChild());
                return true;
            } else if(target.getData() < parent.getData()){
                parent.setLeftChild(target.getLeftChild());
                return true;
            }else{
                parent.setRightChild(target.getLeftChild());
                return true;
            }
        }else if(target.getLeftChild() == null){// 左为空，将右支向上移
            if(target.getData() == root.getData()){
                setRoot(target.getRightChild());
                return true;
            }else if(target.getData() < parent.getData()){
                parent.setLeftChild(target.getRightChild());
                return true;
            }else{
                parent.setRightChild(target.getRightChild());
                return true;
            }
        }else{// 两个都不为空， 找到右支的最左树叶
            Node leftMost = target.getRightChild();
            while(leftMost.getLeftChild() != null){
                leftMost = leftMost.getLeftChild();
            }
            int temp = leftMost.getData();
            delete(temp, root);
            currentNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }
    }

    //Just for Testing purpose
    public void printTree(Node current)
    {
        if (current == null) return;

        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());

    }

    public static void main(String args[]) {
        binarySearchTree bsT = new binarySearchTree();

        bsT.add(6);
        bsT.add(7);
        bsT.add(8);
        bsT.add(12);
        bsT.add(1);
        bsT.add(15);


        System.out.print("Tree : ");
        bsT.printTree(bsT.getRoot());


        System.out.print("\nDeleting Node 6: ");
        bsT.delete(6, bsT.getRoot());
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 15: ");
        bsT.delete(15, bsT.getRoot());
        bsT.printTree(bsT.getRoot());

        System.out.print("\nDeleting Node 1: ");
        bsT.delete(1, bsT.getRoot());
        bsT.printTree(bsT.getRoot());


    }
}
