刷房子1的代码直接拿过来就AC了这道hard的题，看样子这题水分有些大
```c++
class Solution {
public:
    int minCostII(vector<vector<int>>& costs) {
        int n = costs.size();
        if(n == 0) return 0;
        int c = costs[0].size();

        vector<vector<int>> dp(n, vector<int>(c, 0));
        for (int i = 0; i < c; ++i) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; ++i) {
            for (int k = 0; k < c; ++k) {
                int minCost = INT_MAX;
                for (int j = 0; j < c; ++j) {
                    if(j != k) minCost = min(minCost, dp[i - 1][j]);
                }
                dp[i][k] = minCost + costs[i][k];
            }
        }
        return *min_element(dp[n - 1].begin(), dp[n - 1].end());
    }
};
```
执行用时：16 ms, 在所有 C++ 提交中击败了91.05%的用户
内存消耗：11.4 MB, 在所有 C++ 提交中击败了41.17%的用户

滚动数组优化
```c++
class Solution {
public:
    int minCostII(vector<vector<int>>& costs) {
        int n = costs.size();
        if(n == 0) return 0;
        int c = costs[0].size();

        vector<vector<int>> dp(2, vector<int>(c, 0));
        for (int i = 0; i < c; ++i) {
            dp[0][i] = costs[0][i];
        }
        int i;
        for (i = 1; i < n; ++i) {
            for (int k = 0; k < c; ++k) {
                //用什么样的表达式来表达这种
                int minCost = INT_MAX;
                for (int j = 0; j < c; ++j) {
                    if(j != k) minCost = min(minCost, dp[(i - 1) & 1][j]);
                }
                dp[i & 1][k] = minCost + costs[i][k];
            }
        }
        return *min_element(dp[(i + 1) & 1].begin(), dp[(i + 1) & 1].end());
    }
};
```
内存消耗：10.8 MB, 在所有 C++ 提交中击败了65.33%的用户