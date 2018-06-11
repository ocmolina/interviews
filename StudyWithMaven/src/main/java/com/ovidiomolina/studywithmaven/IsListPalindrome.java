/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;
import java.util.Stack;
/**
 *
 * @author nelly
 */
public class IsListPalindrome {
    static class ListNode<T> {
        ListNode<T> next;
        T value;
        ListNode(T value) {
            this.value = value;
            next = null;
        }
    }
    
    public static void main(String args[]) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(1000000000);
        head.next.next = new ListNode<>(-1000000000);
        head.next.next.next = new ListNode<>(-1000000000);
        head.next.next.next.next = new ListNode<>(1000000000);
        head.next.next.next.next.next = new ListNode<>(1);
        print(head);
        System.out.println(isListPalindrome(head));
    }
    
    static boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> slow = l;
        ListNode<Integer> fast = l;
        Stack<ListNode<Integer>> stack = new Stack<>();
        while(slow!=null && fast != null && fast.next!=null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next; 
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
            ListNode<Integer> top = stack.pop();
            int t = top.value - slow.value;
            if(top.value != slow.value) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    
    static void print(ListNode<Integer> n) {
        ListNode<Integer> current = n;
        while(current != null) {
            System.out.print(" " + current.value);
            current = current.next;
        }
        System.out.println();
    }
}
