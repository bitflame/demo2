package com.example;

import edu.princeton.cs.algs4.Queue;
/* Copy of https://github.com/reneargento */ 
public class SeparateChainingHashTable {
    class SequentailSearchSymbolTable<Key, Value> {
        private class Node {
            Key key;
            Value value;
            Node next;

            public Node(Key key, Value value, Node next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        private Node first;
        protected int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean contains(Key key) {
            return get(key) != null;
        }

        public Value get(Key key) {
            for (Node node = first; node != null; node = node.next) {
                if (key.equals(node.key)) {
                    return node.value;
                }
            }
            return null;
        }

        public void put(Key key, Value value) {
            for (Node node = first; node != null; node = node.next) {
                if (key.equals(node.key)) {
                    node.value = value;
                    return;
                }
            }
            first = new Node(key, value, first);
            size++;
        }

        public void delete(Key key) {
            if (first.key.equals(key)) {
                first = first.next;
                size--;
                return;
            }
            for (Node node = first; node != null; node = node.next) {
                if (node.next != null && node.next.key.equals(key)) {
                    node.next = node.next.next;
                    size--;
                    return;
                }
            }
        }

        public Iterable<Key> keys() {
            Queue<Key> keys = new Queue<>();
            for (Node node = first; node != null; node = node.next) {
                keys.enqueue(node.key);
            }
            return keys;
        }

    }

    protected int averageListSize;

    protected int size;

    protected int keysSize;

    //SequentialSearchSymbolTable<Key, Value> [] symbolTable;

    private static final int DEFAULT_HASH_TABLE_SIZE=997;
    private static final int DEFAULT_AVERAGE_LIST_SIZE=5;

    protected static final int[] PRIMES = {
        1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
            32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
            8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
            536870909, 1073741789, 2147483647
    };
    protected int lgM;

    public SeparateChainingHashTable(){
        this(DEFAULT_HASH_TABLE_SIZE,DEFAULT_AVERAGE_LIST_SIZE);
    }
    public SeparateChainingHashTable(int initialSize, int averageListSize){
        this.size=initialSize;
        this.averageListSize=averageListSize;
        for (int i = 0; i < size; i++) {
            //symbolTable[i]=new SequentailSearchSymbolTable<>();
        }
        lgM = (int)(Math.log(size)/Math.log(2));
    }
}
