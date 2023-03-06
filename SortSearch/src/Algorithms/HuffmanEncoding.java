package Algorithms;

import java.util.*;

public class HuffmanEncoding {

    // Huffman tree node class
    private static class HuffmanNode implements Comparable<HuffmanNode> {
        char c;
        int freq;
        HuffmanNode left, right;

        HuffmanNode(char c, int freq, HuffmanNode left, HuffmanNode right) {
            this.c = c;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        // Compare nodes based on frequency
        public int compareTo(HuffmanNode other) {
            return this.freq - other.freq;
        }
    }

    // Function to build Huffman tree and return root node
    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        // Create leaf nodes for each character and add to priority queue
        for (char c : freqMap.keySet()) {
            pq.offer(new HuffmanNode(c, freqMap.get(c), null, null));
        }
        // Build Huffman tree by merging two lowest frequency nodes until one node remains
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.freq + right.freq, left, right);
            pq.offer(parent);
        }
        return pq.poll();
    }

    // Function to encode a given string using Huffman encoding
    public static String encodeString(HuffmanNode root, String s) {
        // Create a lookup table for characters and their codes
        Map<Character, String> codeTable = new HashMap<>();
        buildCodeTable(root, "", codeTable);
        // Encode the string using the lookup table
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(codeTable.get(c));
        }
        return sb.toString();
    }

    // Function to recursively build lookup table for Huffman codes
    private static void buildCodeTable(HuffmanNode node, String code, Map<Character, String> codeTable) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            codeTable.put(node.c, code);
            return;
        }
        buildCodeTable(node.left, code + "0", codeTable);
        buildCodeTable(node.right, code + "1", codeTable);
    }

    // Main function to test the Huffman encoding algorithm
    public static void main(String[] args) {
        String s = "abracadabra";
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        HuffmanNode root = buildHuffmanTree(freqMap);
        String encodedString = encodeString(root, s);
        System.out.println("Original string: " + s);
        System.out.println("Encoded string: " + encodedString);
    }
}
