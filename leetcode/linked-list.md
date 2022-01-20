# Linked List

+ [Reverse linked list](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Sort list](#sort-list)
<!---->

## Reverse linked list

https://leetcode.com/problems/reverse-linked-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testReverseList() {
        ListNode expected = ListNodeHandler.buildList(List.of(1, 2, 2, 2, 3));
        assertEquals(expected, solution.reverseList(ListNodeHandler.buildList(List.of(3, 2, 2, 2, 1))));
    }

    @Test
    void testNullHead() {
        assertNull(solution.reverseList(null));
    }
```

```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java
class Solution {
 public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
```


## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testMiddleNode() {
        ListNode expect = buildList(List.of(2, 3));
        assertEquals(expect, solution.middleNode(ListNodeHandler.buildList(List.of(1, 2, 3))));
    }

    @Test
    void testTwoMiddleNodes() {
        ListNode expect = buildList(List.of(4, 5, 6));
        assertEquals(expect, solution.middleNode(ListNodeHandler.buildList(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void testNullHead() {
        assertNull(solution.middleNode(null));
    }
```

```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }
}
```


## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testIsPalindrome() {
        assertTrue(solution.isPalindrome(ListNodeHandler.buildList(List.of(1, 2, 3, 2, 1))));
    }

    @Test
    void testIsNotPalindrome(){
        assertFalse(solution.isPalindrome(ListNodeHandler.buildList(List.of(1, 2, 3, 4))));
    }

    @Test
    void testNullList(){
        assertTrue(solution.isPalindrome(ListNodeHandler.buildList(List.of())));
    }
    
}
```
```java
class ListNodeHandler{
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer>stack = new Stack();
        
        ListNode current  = head;
        
        while(current!=null) {
            stack.push(current.val);
            current = current.next;
        }
        
        while(head!=null) {
            int i = stack.pop();
            if(head.val != i) {
                return false;
            }
                head = head.next;
        }
        
        return true;
    }
}
```


## Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testMergeTwoLists() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 2));
        ListNode l2 = ListNodeHandler.buildList(List.of(3, 4));
        ListNode res = ListNodeHandler.buildList(List.of(1, 2, 3, 4));
        assertEquals(res, solution.mergeTwoLists(l1, l2));
    }

    @Test
    void testMergeOneList() {
        ListNode l2 = ListNodeHandler.buildList(List.of(3, 4));
        ListNode res = ListNodeHandler.buildList(List.of(3, 4));
        assertEquals(res, solution.mergeTwoLists(null, l2));
    }

    @Test
    void testMergeEqualLists() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 2, 3));
        ListNode res = ListNodeHandler.buildList(List.of(1, 1, 2, 2, 3, 3));
        assertEquals(res, solution.mergeTwoLists(l1, l1));
    }

}

```
```java
class ListNodeHandler {
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode prevl1 = null;
        ListNode head = l1;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prevl1 = l1;
                l1 = l1.next;
            }
            else{
                ListNode temp = l2;
                l2 = l2.next;
                temp.next = l1;
                if(prevl1 != null){
                    prevl1.next = temp;
                }
                else{
                    head = temp;
                }
                prevl1 = temp;
            }
        }
        if(l2 != null){
            prevl1.next = l2;
        }
        return head;
    }
}

```


## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testGetIntersectionNode() {
        ListNode l1 = ListNodeHandler.buildList(List.of(2, 6, 4));
        ListNode l2 = ListNodeHandler.buildList(List.of(1, 5));
        assertEquals(null, solution.getIntersectionNode(l1, l2));
    }

    @Test
    void testGetIntersectionNode2() {
        ListNode l1 = ListNodeHandler.buildList(List.of(2, 6, 4));
        ListNode l2 = ListNodeHandler.buildList(List.of(1, 2, 6, 4));
        assertEquals(2, solution.getIntersectionNode(l1, l2));
    }

}
```
```java
class ListNodeHandler {
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                
ListNode currentA = headA;
        if(headA==null || headB==null) return null;
        while(currentA!=null){
         ListNode   currentB=headB;
            if(currentA==currentB) return currentA;
            while(currentB.next!=null && currentB.next!=currentA) currentB=currentB.next;
            if(currentB.next==null) currentA=currentA.next;
            else return currentA;
        }
        return currentA;
    }
}
```


## Sort List

https://leetcode.com/problems/sort-list/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testSortList() {
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 4, 3, 2));
        ListNode res = ListNodeHandler.buildList(List.of(1, 2, 3, 4));
        assertEquals(res, solution.sortList(l1));
    }

    @Test
    void testSortNullList() {
        assertNull(solution.sortList(null));
    }

    @Test
    void testSortEqList() {
        ListNode res = ListNodeHandler.buildList(List.of(1, 1, 1, 1));
        ListNode l1 = ListNodeHandler.buildList(List.of(1, 1, 1, 1));
        assertEquals(res, solution.sortList(l1));
    }

}
```
```java
class ListNodeHandler {
    static ListNode buildList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int d = src.size() - 1;
        for (int i = d; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
```
</details>

```java
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}

```
