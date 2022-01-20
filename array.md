# Array

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)
<!---->

## Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }


    @Test
    void testSortedSquares() {
        int[] arr = new int[]{-3, 2, 1};
        int[] expect = new int[]{1, 4, 9};
        assertArrayEquals(expect, solution.sortedSquares(arr));
    }

    @Test
    void testNotEquals() {
        int[] arr = new int[]{3, 1, 1};
        int[] expect = new int[]{1, 1, 1};
        assertNotEquals(expect, solution.sortedSquares(arr));
    }
}
``` 
</details>

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j= nums.length-1, k = nums.length-1;
        while(i<=j && k>=0){
            if(nums[i]*nums[i] < nums[j]*nums[j]){
                result[k] = nums[j]*nums[j];
                j--;
            }else{
                result[k] = nums[i]*nums[i];
                i++;
            }
            k--;
        }
        return result;
    }
}
```
