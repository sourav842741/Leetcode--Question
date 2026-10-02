class Solution {
    List<String> res=new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
      
        StringBuilder sb=new StringBuilder();
        helper(n,0,0,sb);
        return res;
    }
    public void helper(int n,int open,int close,StringBuilder sb){
        if(close==n){
            res.add(sb.toString());
            return ;
        }
        if(open<n){
            sb.append('(');
            helper(n,open+1,close,sb);
            sb.deleteCharAt(sb.length()-1);}
        
        if(close<open){
            sb.append(')');
            helper(n,open,close+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}