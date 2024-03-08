import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];

        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<heights.length; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if(stk.isEmpty()) leftSmaller[i] = 0;
            else {
                leftSmaller[i] = stk.peek()+1;
            }
            stk.push(i);
        }
        
        while (!stk.isEmpty()) {
            stk.pop();
        }

        for(int i=heights.length-1; i>=0; i--) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if(stk.isEmpty()) rightSmaller[i] = heights.length-1;
            else {
                rightSmaller[i] = stk.peek()-1;
            }
            stk.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            int area = (rightSmaller[i] - leftSmaller[i]+1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}