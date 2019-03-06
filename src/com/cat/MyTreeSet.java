package com.cat;

import java.util.LinkedList;
import java.util.Queue;

public class MyTreeSet implements TreeSet {

    private class TreeElement {
        private Integer key;
        private TreeElement rightTreeElement;
        private TreeElement leftTreeElement;

        public TreeElement(int key) {
            this.key = key;
        }
    }

    private int size = 0;
    private TreeElement headerTreeElement;

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean containsKey(int key) {
        TreeElement treeElement = headerTreeElement;
        if (treeElement == null) {
            throw new IllegalArgumentException("Binary tree is empty!!!");
        }
        while (treeElement != null) {
            if (treeElement.key > key) {
                treeElement = treeElement.leftTreeElement;
            } else if (treeElement.key < key) {
                treeElement = treeElement.rightTreeElement;
            } else if (treeElement.key == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void put(int key) {
        TreeElement treeElement = new TreeElement(key);
        if (headerTreeElement == null) {
            headerTreeElement = treeElement;
        } else {
            addToMyTreeSet(headerTreeElement, treeElement);
        }
        size++;
    }

    private void addToMyTreeSet(TreeElement headerTreeElement, TreeElement treeElement) {
        if (treeElement.key < headerTreeElement.key) {
            if (headerTreeElement.leftTreeElement == null) {
                headerTreeElement.leftTreeElement = treeElement;
            } else {
                addToMyTreeSet(headerTreeElement.leftTreeElement, treeElement);
            }
        } else if (treeElement.key > headerTreeElement.key) {
            if (headerTreeElement.rightTreeElement == null) {
                headerTreeElement.rightTreeElement = treeElement;
            } else {
                addToMyTreeSet(headerTreeElement.rightTreeElement, treeElement);
            }
        }
    }

    @Override
    public void get(int key) {
        TreeElement treeElement = headerTreeElement;
        if (treeElement == null) {
            throw new IllegalArgumentException("Binary tree is empty!!!");
        }
        while (treeElement != null) {
            if (treeElement.key > key) {
                treeElement = treeElement.leftTreeElement;
            } else if (treeElement.key < key) {
                treeElement = treeElement.rightTreeElement;
            } else if (treeElement.key == key) {
                System.out.println("[" + treeElement.key + "]");
                break;
            }
        }
    }

    @Override
    public void remove(int key) {
        TreeElement treeElement = new TreeElement(key);
        headerTreeElement = removeFromTree(headerTreeElement, treeElement);
        size--;
    }

    private TreeElement removeFromTree(TreeElement headerTreeElement, TreeElement treeElementRemovable) {
        TreeElement treeElement = headerTreeElement;
        if (treeElement == null) {
            return null;
        }
        if (treeElement.key > treeElementRemovable.key) {
            treeElement.leftTreeElement = removeFromTree(treeElement.leftTreeElement, treeElementRemovable);
        } else if (treeElement.key < treeElementRemovable.key) {
            treeElement.rightTreeElement = removeFromTree(treeElement.rightTreeElement, treeElementRemovable);
        } else {
            if (treeElement.leftTreeElement == null && treeElement.rightTreeElement == null) {
                treeElement = null;
            } else if (treeElement.rightTreeElement == null) {
                treeElement = treeElement.leftTreeElement;
            } else if (treeElement.leftTreeElement == null) {
                treeElement = treeElement.rightTreeElement;
            } else {
                TreeElement tmp = findMinimum(treeElement.rightTreeElement);
                treeElement = tmp;
                treeElement.rightTreeElement = removeFromTree(treeElement.rightTreeElement, tmp);
            }
        }
        return treeElement;
    }


    private TreeElement findMinimum(TreeElement treeElement) {
        while (treeElement.leftTreeElement != null) {
            treeElement = treeElement.leftTreeElement;
        }
        return treeElement;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() {
        Queue<TreeElement> queue = new LinkedList<>();
        queue.add(headerTreeElement);
        while (!queue.isEmpty()) {
            TreeElement treeElement = queue.poll();
            System.out.print("[" + treeElement.key + "]");
            if (treeElement.leftTreeElement != null) {
                queue.add(treeElement.leftTreeElement);
            }
            if (treeElement.rightTreeElement != null) {
                queue.add(treeElement.rightTreeElement);
            }
        }
        System.out.println();
    }

    @Override
    public void getSize() {
        System.out.println("Size of treeSet is " + size);
    }
}
