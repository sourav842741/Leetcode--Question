class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int curr = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                curr++;
                ans = Math.max(ans, curr);
            }
            else if(ch == ')'){
                
                curr--;
            }
        }
        return ans;
    }
}