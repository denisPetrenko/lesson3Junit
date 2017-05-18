
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTree {

    private Node root;
    private int size;
    private List<String> elements;

    public MyTree() {
        this.root = new Node();
        this.size = 0;
    }

    public boolean add(String element) {
        if (root.getElement() == null) {
            root.setElement(element);
            size++;
            return true;
        } else return addLoop(root, element);
    }

    private boolean addLoop(Node node, String element) {
        Node currentNode = new Node();
        currentNode.setElement(element);
        if (node.getElement().compareTo(element) == 0) return false;
        if (node.getElement().compareTo(element) > 0) {
            if (node.getRightChild() != null) return addLoop(node.getRightChild(), element);
            else {
                node.setRightChild(currentNode);
                size++;
                return true;
            }
        } else {
            if (node.getLeftChild() != null) return addLoop(node.getLeftChild(), element);
            else {
                node.setLeftChild(currentNode);
                size++;
                return true;
            }
        }
    }


    public boolean contains(String element) {
        if (root.getElement().equals(element)) return true;
        else return containsLoop(root, element);
    }

    private boolean containsLoop(Node node, String element) {
        if (node.getElement().compareTo(element) == 0) return true;
        if (node.getElement().compareTo(element) > 0) {
            if (node.getRightChild() != null) return containsLoop(node.getRightChild(), element);
            else return false;
        } else {
            if (node.getLeftChild() != null) return containsLoop(node.getLeftChild(), element);
            else return false;
        }
    }


    public boolean delete(String element) {
        toArray();
        boolean isRemove = elements.remove(element);
        root = new Node();
        elements.forEach(this::add);
        return isRemove;
    }

    public boolean deleteAllFrom(String[] element) {
        toArray();
        boolean isRemove = elements.removeAll(Arrays.asList(element));
        root = new Node();
        elements.forEach(this::add);
        return isRemove;
    }


    public String[] toArray() {
        this.elements = new ArrayList<>();
        if (root != null) {
            toArrayLoop(root);
        }
        return elements.toArray(new String[size]);
    }

    private void toArrayLoop(Node node) {
        elements.add(node.getElement());
        if (node.getRightChild() != null) toArrayLoop(node.getRightChild());
        if (node.getLeftChild() != null) toArrayLoop(node.getLeftChild());
    }

    public int getSize() {
        return size;
    }


    private class Node {
        private String element;
        private Node rightChild;
        private Node leftChild;


        public String getElement() {
            return element;
        }

        public void setElement(String element) {
            this.element = element;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }


    }
}
