import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[] = new int[26];
        boolean included[] = new boolean[26];
        Stack<Character> st = new Stack<>();
        Arrays.fill(included,false);
        for(char ch: s.toCharArray()){
            freq[ch-97]++;
        }

        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            freq[ch-97]--;
            if( included[ch-97]) continue;
            while(!st.isEmpty() && freq[st.peek()-97]>0 && ch<st.peek()){
                included[st.pop()-97]=false;
            }
            st.push(ch);
            included[ch-97]= true;  
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}