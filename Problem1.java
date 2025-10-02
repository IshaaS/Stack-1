// Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

// Time Complexity :O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we store all temperatures in a decreasing monolithic Stack
//when hightest is found than the top element of stack, all element in stack < hightest
//temperature are resolved.

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length==0) return temperatures;
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i-popped;
            }
            st.push(i);
        }
        return result;
    }
}