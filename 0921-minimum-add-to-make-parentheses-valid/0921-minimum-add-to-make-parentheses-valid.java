class Solution {
    public int minAddToMakeValid(String s) {
        int O = 0;
        int C = 0;

        for( char ch : s.toCharArray()){
            if(ch == '('){
                O++;
            }else{
                if(O > 0){
                    O--;
                }else{
                    C++;
                }
            }
        }
        return O + C;
    }
}