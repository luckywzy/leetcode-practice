二分查找时间：logn+2*logn/2+4*logn/4+....+n*logn/n
递归循环次数:1+2+4+...+n
时间复杂度：不会算
```java
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length-1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean verifyPreorder(int[] preorder, int s, int e, int mx, int mn) {
        if(s < e){
            int i = Arrays.binarySearch(preorder, s+1, e+1, preorder[s]);
            if(i < 0)i = -i-1;
            return preorder[s] > mn && preorder[s] < mx 
                && verifyPreorder(preorder, s+1, i-1, preorder[s], mn)
                && verifyPreorder(preorder, i, e, mx, preorder[s]);
        }else if(s == e){
            return preorder[s] > mn && preorder[s] < mx;
        }else{
            return true;
        }
    }
}
```
