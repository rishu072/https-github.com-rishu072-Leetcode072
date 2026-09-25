class Solution {
    public List<String> braceExpansionII(String expression) {
        char[] s = expression.toCharArray();
        int n = s.length;

        char[] op = new char[n + 1];
        int opTop = -1;

        ArrayList<Set<String>> stk = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (c == ',') {
                while (opTop >= 0 && op[opTop] == '*') {
                    opTop = ope(op, opTop, stk);
                }
                op[++opTop] = '+';
            } else if (c == '{') {
                if (i > 0) {
                    char p = s[i - 1];
                    if (p == '}' || (p >= 'a' && p <= 'z')) op[++opTop] = '*';
                }
                op[++opTop] = '{';
            } else if (c == '}') {
                while (opTop >= 0 && op[opTop] != '{') {
                    opTop = ope(op, opTop, stk);
                }
                opTop--; // pop '{'
            } else {
                if (i > 0) {
                    char p = s[i - 1];
                    if (p == '}' || (p >= 'a' && p <= 'z')) op[++opTop] = '*';
                }
                Set<String> single = new HashSet<>(2);
                single.add(String.valueOf(c));
                stk.add(single);
            }
        }

        while (opTop >= 0) {
            opTop = ope(op, opTop, stk);
        }

        List<String> ans = new ArrayList<>(stk.get(stk.size() - 1));
        Collections.sort(ans);
        return ans;
    }

    // returns new opTop
    private int ope(char[] op, int opTop, List<Set<String>> stk) {
        int r = stk.size() - 1;
        int l = r - 1;
        Set<String> L = stk.get(l);
        Set<String> R = stk.get(r);

        if (op[opTop] == '+') {
            L.addAll(R);
        } else {
            Set<String> tmp = new HashSet<>(L.size() * R.size() * 2);
            for (String a : L) {
                for (String b : R) {
                    tmp.add(a + b);
                }
            }
            stk.set(l, tmp);
        }
        stk.remove(r);
        return opTop - 1;
    }
}