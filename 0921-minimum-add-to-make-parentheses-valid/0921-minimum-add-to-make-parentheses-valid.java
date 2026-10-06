class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        int c = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    c++;
                }
            }
        }
        return stack.size() + c;
    }
}