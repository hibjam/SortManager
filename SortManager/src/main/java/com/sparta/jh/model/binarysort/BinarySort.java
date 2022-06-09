package com.sparta.jh.model.binarysort;

import com.sparta.jh.exceptions.ChildNotFoundException;
import com.sparta.jh.model.Sorter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sparta.jh.controller.SortManager.newLogger;

public class BinarySort implements BinaryTreeInterface, Sorter {
    public class Node {

        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) { // only thing a node should have at time of creation is the value of node1
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeftChildEmpty() {
            if (leftChild == null) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isRightChildEmpty() {
            if (rightChild == null) {
                return true;
            } else {
                return false;
            }
        }
    }

    private Node rootNode;
    private int count;
    private int[] sortedTree;
    private int numberOfNodes = 1;

    public BinarySort(){}

    public int[] sort(final int[] elements) {
        BinarySort tree = new BinarySort();
        tree.rootNode = new Node(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            tree.addElement(elements[i]);
        }
        return tree.getSortedTreeAsc();
    }

    @Override
    public final int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfNodes;
    }
    @Override
    public void addElement(final int element) {
        //newLogger.log(Level.INFO, "Adding a single element to binary tree");
        addNodeToTree(rootNode, element);
    }
    @Override
    public void addElements(final int[] elements) {
        newLogger.log(Level.INFO, "Adding multiple elements from random array to binary tree");
        for (int element : elements) {
            addNodeToTree(rootNode, element);
        }
    }
    @Override
    public boolean findElement(final int element) {
        Node node = findNode(element);
        if (node != null) {
            return true;
        }
        return false;
    }

    private void addNodeToTree(Node node, int element) {
        if (element <= node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
                numberOfNodes++;
                //newLogger.log(Level.INFO, "Added leftChild to Binary tree");
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (node.isRightChildEmpty()) {
            node.setRightChild(new Node(element));
            numberOfNodes++;
            // newLogger.log(Level.INFO, "Added rightChild to Binary tree");
        } else {
            addNodeToTree(node.getRightChild(), element);
        }
    }

    private Node findNode(final int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element <= node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }
    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if (node.getLeftChild() != null) {
            Node leftNode = node.getLeftChild();
            return leftNode.getValue();
        } else {
            throw new ChildNotFoundException(node.getValue() + " This node does not have a left child");
        }
    }
    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if (node.getRightChild() != null) {
            Node rightNode = node.getRightChild();
            return rightNode.getValue();
        } else {
            throw new ChildNotFoundException(node.getValue() + " This node does not have a right child");
        }
    }
    @Override
    public int[] getSortedTreeAsc() {
        sortedTree = new int[numberOfNodes];
        traverseTreeAsc(rootNode);
        count = 0;
        return sortedTree;
    }

    public void traverseTreeAsc(Node node) {
        if (!node.isLeftChildEmpty()) {
            traverseTreeAsc(node.getLeftChild());
        }
        sortedTree[count] = node.getValue();
        count++;
        if (!node.isRightChildEmpty()) {
            traverseTreeAsc(node.getRightChild());
        }
    }

    public String printSortedTreeDesc() {
        return Arrays.toString(getSortedTreeDesc());
    }
    @Override
    public int[] getSortedTreeDesc() {
        sortedTree = new int[numberOfNodes];
        traverseTreeDesc(rootNode);
        count = 0;
        return sortedTree;
    }

    private void traverseTreeDesc(Node node) {
        if (!node.isRightChildEmpty()) {
            traverseTreeDesc(node.getRightChild());
        }
        sortedTree[count] = node.getValue();
        count++;
        if (!node.isLeftChildEmpty()) {
            traverseTreeDesc(node.getLeftChild());
        }
    }
}
