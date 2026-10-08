class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int dep = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                if(dep > 0){
                    ans.append(c);
                }
                dep++;
            }else{
                dep--;
                if(dep > 0){
                    ans.append(c);
                }
            }
        }
        return ans.toString();

    }
}