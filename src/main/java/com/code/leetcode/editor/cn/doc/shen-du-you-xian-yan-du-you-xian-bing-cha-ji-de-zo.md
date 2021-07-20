### 图方面的算法比较薄弱，在此对评论区几种方法做个总结：
对于该题目的思路，主要有两种
1. `是连通图`且`不存在环`
2. `是连通图`且`边的个数==节点数-1`

### 实现方式：
#### 对于连通图的判定，有两种方式(代码都有)：
1. 以广度优先搜索或者深度优先搜索的方式，遍历一遍图。如果存在没有遍历到的节点，那么是非连通图，返回false.
2. 并查集：最后如果有多个头目，则是非连通图，返回false.

#### 存在环的判定：
1. 深度优先遍历，把边给数一下。因为数的时候，会数生成树最少的边数(形成环的边会因为节点被访问过而不计算,如下图：深度遍历时，只会遍历1,2和2,3之间的边，13之间的边不会遍历)，所以最终`数出来的边数<总边数`，则形成环。广度优先遍历，同理。
1
**|**&ensp;&ensp;\\
2 **---** 3
2. 并查集：如果并查集建立的过程中发生合并，则一定有环形成。

#### 边的数==节点数-1的判定：很直白了，无需多说。

上述思路都是重叠的，广度优先/深度优先/并查集都可以实现，而且使用不同的思路。
```c++ []
/**深度优先：思路2*/
class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        /**1. 节点数==变数+1*/
        if(edges.size() +1 != n) return false;
        /**2. 连通性*/
        vector<vector<int>> Graph(n,vector<int>());
        //构造邻接表
        for(auto edge: edges){
            Graph[edge[0]].push_back(edge[1]);
            Graph[edge[1]].push_back(edge[0]);
        }
        vector<bool> visited(n);
        //深度优先
        dfs(Graph,0,visited);
        for(auto c:visited){//遍历访问数组来判定是否全部被访问过，可以优化
            if(!c) return false;
        }
        return true;  
    }
    void dfs(vector<vector<int>> &Graph, int i, vector<bool> &visited){
        if(visited[i] == true) return;
        visited[i] = true;
        for(auto c:Graph[i]){
            dfs(Graph, c, visited);
        }
    }
};
```
```c++ []
class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        /**1. 节点数==变数+1*/
        if(edges.size() +1 != n) return false;
        /**2. 连通性*/
        vector<vector<int>> Graph(n,vector<int>());
        //构造邻接表
        for(auto edge: edges){
            Graph[edge[0]].push_back(edge[1]);
            Graph[edge[1]].push_back(edge[0]);
        }
        set<int> visited;//访问过的节点放在visited数组中
        //广度优先,看是否连通
        queue<int> q;
        q.push(0);
        visited.insert(0);
        while(!q.empty()){
            int sz = q.size();
            while(sz){
                int v = q.front();
                q.pop();
                for(auto v_a : Graph[v]){
                    if(visited.find(v_a) != visited.end())//访问过了
                        continue;
                    visited.insert(v_a);
                    q.push(v_a);
                }
                sz--;
            }
        }
        return visited.size() == n;  //访问过的节点数<n,则不连通
    }
};
```
```c++ []
class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        if(n != edges.size()+1) return false;
        //并查集判断是否连通
        vector<int> parent(n);
        for(int i = 0; i < parent.size(); i++){//初始化并查集
            parent[i]=i;
        }
        for(auto edge:edges){//构造并查集
            Union(parent,edge[0],edge[1]);
        }
        int p = Find(parent,0);//得到一个头目
        for(int i = 1; i < n;i++){//如果连通，所有的头目都是p
            if(p != Find(parent, i))
                return false;
        }
        return true;
    }
    void Union(vector<int> &parent, int A, int B){
        int pa = Find(parent, A);
        int pb = Find(parent, B);
        if(pa != pb){//祖先不同，把其中一个人的祖先，换成另一个
            parent[pa] = pb;
        }
    }
    int Find(vector<int> &parent, int A){
        while(parent[A] != A){
            A = parent[A];
        }
        return A;
    }
};
```
