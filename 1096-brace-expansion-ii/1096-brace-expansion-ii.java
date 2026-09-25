class Solution {

    private String s;
    private int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        return new ArrayList<>(parseExpression());
    }

    private TreeSet<String> parseExpression() {
        TreeSet<String> res = parseTerm();

        while (index < s.length() && s.charAt(index) == ',') {
            index++;
            res.addAll(parseTerm());
        }

        return res;
    }

    private TreeSet<String> parseTerm() {
        TreeSet<String> res = new TreeSet<>();
        res.add("");

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (ch == '}' || ch == ',') {
                break;
            }

            res = concatenate(res, parseFactor());
        }

        return res;
    }

    private TreeSet<String> parseFactor() {
        char ch = s.charAt(index);

        if (ch >= 'a' && ch <= 'z') {
            index++;

            TreeSet<String> res = new TreeSet<>();
            res.add(String.valueOf(ch));

            return res;
        }

        index++;
        TreeSet<String> res = parseExpression();
        index++;

        return res;
    }

    private TreeSet<String> concatenate(
            TreeSet<String> first,
            TreeSet<String> second) {
        TreeSet<String> res = new TreeSet<>();

        for (String a : first) {
            for (String b : second) {
                res.add(a + b);
            }
        }

        return res;
    }
}