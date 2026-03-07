class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String ss = s + s;

        int alt1 = 0;
        int alt2 = 0;

        int res = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0;right < ss.length(); right++) {
            char expected1 = (right % 2==0) ? '0' : '1';
            char expected2 = (right % 2==0) ? '1' : '0';

            if (ss.charAt(right) != expected1) alt1++;
            if(ss.charAt(right) != expected2) alt2++;

            if (right - left + 1 > n) {
                char exp1 = (left % 2==0) ? '0':'1';
                char exp2 = (left % 2==0) ? '1':'0';

                if(ss.charAt(left) != exp1) alt1--;
                if(ss.charAt(left) != exp2) alt2--;

                left++;
            }
            if (right - left + 1==n) {
                res = Math.min(res, Math.min(alt1,alt2));
            }
        }
        return res;
        
    }
}