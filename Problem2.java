// Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)

// Time Complexity : O(3n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we use monolithic stack to store element of num until a greater number than peek
// is found, then we take out every number from stack which is
// smaller than current number
// we do this for 2 passes, cause by 2 passes, if there are numbers which are not
// smaller than other will be left and others will have values of numbers greater than them

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++){
            if(!st.isEmpty() && (i%n)==st.peek()) break;
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i<n) st.push(i);
        }
        return result;
    }
}