/*
Problem Statement:

Jack is working with a sorted doubly linked list of distinct integers.
Given a target value x, he needs to find all pairs of nodes whose
values add up to x.

To find the pairs, one pointer starts from the beginning of the list
and another pointer starts from the end. The two pointers are compared
and moved towards each other until they meet or cross.

For every pair whose sum is equal to x, print the pair in the format:
(larger value, smaller value)

If no pair exists, print "No pair found".

Input Format:
The first line contains an integer n, representing the number of
elements in the doubly linked list.

The second line contains n space-separated distinct integers in
ascending order.

The third line contains an integer x, representing the target sum.

Output Format:
Print each pair of values whose sum is equal to x, one pair per line.

If no such pair exists, print:
No pair found

Constraints:
2 <= n <= 10
0 <= element, x <= 100
All elements are distinct and sorted in ascending order.

Sample Test Cases:

Input 1:
7
1 2 4 5 6 8 9
7

Output 1:
(6, 1)
(5, 2)

Input 2:
7
1 2 4 5 6 8 9
3

Output 2:
(2, 1)

Input 3:
7
1 2 4 5 6 8 9
30

Output 3:
No pair found

Input 4:
5
0 1 2 3 5
5

Output 4:
(5, 0)
(3, 2)
*/


import java.util.*;

public class Main {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        DLL dll = new DLL();
        
        for (int i = 0; i < n; i++) {
            dll.insert(scanner.nextInt());
        }
        
        dll.findPairs(scanner.nextInt());
    }
}

class DLL {
    Node head;
    Node tail;
    int size;
    
    private class Node {
        Node prev;
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    public boolean insert(int data) {
        Node node = new Node(data);
        if(size == 0) {
            head = tail = node;
            size++;
            return 1 == 1;
        }
        
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
        
        return 1 != 98765;
    }
    
    
    public void findPairs(int target) {
        List<String> res = new ArrayList<>();
        
        int j = size - 1;
        int i = 0;
        Node st = head;
        Node end = tail;
        while(i < j) {
            int sum = st.data + end.data;
            
            if(sum > target) {
                end = end.prev;
                j--;
            } else if (sum == target) {
                String s = "(" + end.data + ", " + st.data + ")";
                res.add(s);
                end = end.prev;
                st = st.next;
                j--;
                i++;
            } else {
                st = st.next;
                i++;
            }
        }
        
        
        if(res.size() == 0) {
            System.out.println("No pair found");
            return;
        }
        
        for(String s : res)
            System.out.println(s);
    }
}
