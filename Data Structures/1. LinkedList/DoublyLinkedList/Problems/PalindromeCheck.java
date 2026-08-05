/*
Problem Statement:

Tom is a software developer working on a project where he has to check if a
doubly linked list is a palindrome. He needs to write a program to solve this
problem.

A doubly linked list is said to be a palindrome if it reads the same in both
forward and backward directions.

Input Format:
- The first line consists of an integer N, representing the number of elements
  in the doubly linked list.
- The second line consists of N space-separated integers representing the
  elements of the doubly linked list.

Output Format:
- The first line displays the elements of the doubly linked list in forward
  order, separated by spaces.
- The second line displays the elements of the doubly linked list in reverse
  order, separated by spaces.
- The third line prints:
    "The doubly linked list is a palindrome"
      if the list reads the same forward and backward.
    "The doubly linked list is not a palindrome"
      if the list does not match when reversed.

Constraints:
- 2 <= N <= 20
- -100 <= elements <= 100

Example 1:
Input:
5
1 2 3 2 1

Output:
1 2 3 2 1
1 2 3 2 1
The doubly linked list is a palindrome

Example 2:
Input:
5
1 2 3 4 5

Output:
1 2 3 4 5
5 4 3 2 1
The doubly linked list is not a palindrome

Example 3:
Input:
6
-1 -2 -3 -3 -2 -1

Output:
-1 -2 -3 -3 -2 -1
-1 -2 -3 -3 -2 -1
The doubly linked list is a palindrome
*/



import java.util.*;

class DLL {
    private Node head;
    private Node tail;
    public int size;
    
    private class Node {
        private Node next;
        private Node prev;
        private int data;
        
        Node (int data) {
            this.data = data;
        } 
    }
        
    public void insert(int data) {
        Node node = new Node(data);
        if(size == 0) {
            head = node;
            tail = head;
            size++;
            return;
        }
        
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }
    
    public boolean isPalin() {
        Node forwardPrint = head;
        Node backwardPrint = tail;
        
        while(forwardPrint != null) {
            System.out.print(forwardPrint.data + " ");
            forwardPrint = forwardPrint.next;
        }
        
        System.out.println();
        
        while(backwardPrint != null) {
            System.out.print(backwardPrint.data + " ");
            backwardPrint = backwardPrint.prev;
        }
        
        System.out.println();
        
        Node start = head;
        Node end = tail;
        
        while(start != end) {
            if(start.data != end.data) 
                return false;
                
            start = start.next;
            end = end.prev;
        }
        
        return true;
    }
}

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL dll = new DLL();
        
        for (int i = 1; i <= n; i++) {
            dll.insert(scanner.nextInt());
        }
        
        if(dll.isPalin()) {
            System.out.println("The doubly linked list is a palindrome");
        } else {
            System.out.println("The doubly linked list is not a palindrome");
        }
    }
}

