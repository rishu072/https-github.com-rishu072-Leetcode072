class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        
        List<List<String>> list = new ArrayList<>();

        int i = 0;
        int n = s1.length();

        while(i < n){
            
            if(s1.charAt(i) == s2.charAt(i)){
                i++;
                continue;
            }
            
            int st = i;

            while(i < n && s1.charAt(i) != s2.charAt(i)){
                i++;
            }
            String sub1 = s1.substring(st, i);
            String sub2 = s2.substring(st, i);

            list.add(Arrays.asList(sub1, sub2));
                
        }

        return list;
    }
}