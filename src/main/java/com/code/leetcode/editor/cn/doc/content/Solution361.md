<p>给你一个大小为 <code>m x n</code> 的矩阵 <code>grid</code> ，其中每个单元格都放置有一个字符：</p>

<ul>
	<li><code>'W'</code>&nbsp;表示一堵墙</li>
	<li><code>'E'</code>&nbsp;表示一个敌人</li>
	<li><code>'0'</code>（数字 0）表示一个空位</li>
</ul>

<p>返回你使用 <strong>一颗炸弹</strong> 可以击杀的最大敌人数目。你只能把炸弹放在一个空位里。</p>

<p>由于炸弹的威力不足以穿透墙体，炸弹只能击杀同一行和同一列没被墙体挡住的敌人。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/27/bomb1-grid.jpg" style="width: 600px; height: 187px;" />
<pre>
<strong>输入：</strong>grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/27/bomb2-grid.jpg" style="width: 500px; height: 194px;" />
<pre>
<strong>输入：</strong>grid = [["W","W","W"],["0","0","0"],["E","E","E"]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 500</code></li>
	<li><code>grid[i][j]</code> 可以是 <code>'W'</code>、<code>'E'</code> 或 <code>'0'</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 74</li><li>👎 0</li></div>