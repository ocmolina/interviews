/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

/**
 *
 * @author nelly
 */
public class RemoveKFromList {
    
    static class Node {
        Node next;
        int value;
        
        public Node(int v){
            next = null;
            value = v;
        }
    }
    
    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(1);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(1);
        print(head);
        head = removeKFromList(head, 1);
        print(head);
    }
    
    static Node removeKFromList(Node n, int k) {
        Node head = n;
        Node current = n;
        Node prev = null;
        while(current != null) {
            if(current.value == k) {
                if(prev == null) {
                    head = findNext(current, k);
                    prev = head;
                    if(head != null) {
                        current = head.next;
                    }
                    else {
                        current = null;
                    }
                }
                else {
                    prev.next = findNext(current, k);
                    prev = prev.next;
                    if(prev != null) {
                        current = prev.next;
                    }
                    else {
                        current = null;
                    }
                }
            }
            else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
    
    static Node findNext(Node n, int k) {
        if(n == null) {
            return null;
        }
        Node current = n;
        while(current != null && current.value == k) {
            current = current.next;
        }
        return current;
    }
    
    static void print(Node n) {
        Node current = n;
        while(current != null) {
            System.out.print(" " + current.value);
            current = current.next;
        }
        System.out.println();
    }
}
