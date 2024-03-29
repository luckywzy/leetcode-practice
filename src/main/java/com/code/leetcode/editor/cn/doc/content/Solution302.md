<p>图片在计算机处理中往往是使用二维矩阵来表示的。</p>

<p>给你一个大小为 <code>m x n</code> 的二进制矩阵&nbsp;<code>image</code> 表示一张黑白图片，<code>0</code>&nbsp;代表白色像素，<code>1</code>&nbsp;代表黑色像素。</p>

<p>黑色像素相互连接，也就是说，图片中只会有一片连在一块儿的黑色像素。像素点是水平或竖直方向连接的。</p>

<p>给你两个整数 <code>x</code> 和 <code>y</code> 表示某一个黑色像素的位置，请你找出包含全部黑色像素的最小矩形（与坐标轴对齐），并返回该矩形的面积。</p>

<p>你必须设计并实现一个时间复杂度低于&nbsp;<code>O(mn)</code> 的算法来解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/14/pixel-grid.jpg" style="width: 333px; height: 253px;" />
<pre>
<strong>输入：</strong>image = [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]], x = 0, y = 2
<strong>输出：</strong>6
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>image = [["1"]], x = 0, y = 0
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == image.length</code></li>
	<li><code>n == image[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>image[i][j]</code> 为 <code>'0'</code> 或 <code>'1'</code></li>
	<li><code>1 &lt;= x &lt; m</code></li>
	<li><code>1 &lt;= y &lt; n</code></li>
	<li><code>image[x][y] == '1'</code></li>
	<li><code>image</code> 中的黑色像素仅形成一个 <strong>组件</strong></li>
</ul>
<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>数组</li><li>二分查找</li><li>矩阵</li></div></div><br><div><li>👍 39</li><li>👎 0</li></div>