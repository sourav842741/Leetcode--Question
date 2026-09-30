class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        var result = new int[seq.length()];
        var cs = seq.toCharArray();
        for (int i = 0, depth = 0; i < cs.length; i ++) {
            var c = cs[i];
            if (c == '(') {
                depth ++; // increase depth on open bracket
                result[i] = depth % 2; // even or odd is our result
            } else {
                result[i] = depth % 2; // even or odd is our result, 
                                       // but before we modify depth,
                                       // so this bracket belongs to
                                       // the same group as opening one
                depth --;
            }
        }
        return result;
    }
}