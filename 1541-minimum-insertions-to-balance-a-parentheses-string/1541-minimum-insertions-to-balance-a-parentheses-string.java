class Solution {
    public int minInsertions(String s) {
        char[] c = s.toCharArray();
        int count = 0, additional = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                count++;
            } else {
                if (count != 0) {
                    if (i + 1 < c.length && c[i + 1] == ')') {
                        count--;
                        i++;
                    } else {
                        additional++;
                        count--;
                    }
                } else {
                    if (i + 1 < c.length && c[i + 1] == ')') {
                        additional++;
                        i++;
                    } else {
                        additional += 2;
                    }
                }
            }
        }
        return count * 2 + additional;
    }
}
