class Solution {
    private int i;
    private String s;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        i = 0;
        Set<String> res = parseExpr();
        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }

    // expr := term (',' term)*
    private Set<String> parseExpr() {
        Set<String> result = new HashSet<>(parseTerm());
        while (i < s.length() && s.charAt(i) == ',') {
            i++; // skip ','
            result.addAll(parseTerm());
        }
        return result;
    }

    // term := factor+   (concatenation → Cartesian product)
    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add(""); // identity for product

        while (i < s.length() && s.charAt(i) != ',' && s.charAt(i) != '}') {
            Set<String> factor = parseFactor();
            Set<String> next = new HashSet<>();
            for (String a : result)
                for (String b : factor)
                    next.add(a + b);
            result = next;
        }
        return result;
    }

    // factor := '{' expr '}' | letter
    private Set<String> parseFactor() {
        if (s.charAt(i) == '{') {
            i++;                       // skip '{'
            Set<String> res = parseExpr();
            i++;                       // skip '}'
            return res;
        } else {
            Set<String> res = new HashSet<>();
            res.add(String.valueOf(s.charAt(i)));
            i++;
            return res;
        }
    }
}