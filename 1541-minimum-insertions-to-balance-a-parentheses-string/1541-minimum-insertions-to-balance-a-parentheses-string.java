class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int O = 0;

        for( int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                O++;
            }else{
                if(i + 1 < s.length() && s.charAt(i + 1) == ')'){
                    i++;
                }else{
                    ans++;
                }
                if(O > 0){
                    O--;
                }else{
                    ans++;
                }
            }
        }
        ans += O * 2;
        return ans;
    }
}