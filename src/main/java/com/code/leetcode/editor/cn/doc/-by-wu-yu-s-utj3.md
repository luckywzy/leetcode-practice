

```java
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i)] ++;
        }
        int ret = 0;
        for (int c : count) {
            if (c % 2 == 1 && ++ret > 1) {
                return false;
            }
        }
        return true;
    }
}
```