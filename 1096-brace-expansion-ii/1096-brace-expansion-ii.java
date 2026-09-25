class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(expression);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int close = cur.indexOf('}');
            if (close == -1) {          // no braces left → a final expansion
                result.add(cur);
                continue;
            }
            int open = close;
            while (cur.charAt(open) != '{') open--;

            String prefix = cur.substring(0, open);
            String suffix = cur.substring(close + 1);
            String[] options = cur.substring(open + 1, close).split(",");

            for (String opt : options) {
                queue.offer(prefix + opt + suffix);
            }
        }

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }
}