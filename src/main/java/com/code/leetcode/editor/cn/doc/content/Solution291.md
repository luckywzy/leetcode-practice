<p>给你一种规律 <code>pattern</code> 和一个字符串 <code>str</code>，请你判断 <code>str</code> 是否遵循其相同的规律。</p>

<p>这里我们指的是 <strong>完全遵循</strong>，例如 <code>pattern</code> 里的每个字母和字符串 <code>str</code><strong> </strong>中每个 <strong>非空</strong> 单词之间，存在着 <strong>双射</strong> 的对应规律。<strong>双射</strong> 意味着映射双方一一对应，不会存在两个字符映射到同一个字符串，也不会存在一个字符分别映射到两个不同的字符串。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>pattern = "abab", s = "redblueredblue"
<strong>输出：</strong>true
<strong>解释：</strong>一种可能的映射如下：
'a' -> "red"
'b' -> "blue"</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>pattern = "aaaa", s = "asdasdasdasd"
<strong>输出：</strong>true
<strong>解释：</strong>一种可能的映射如下：
'a' -> "asd"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>pattern = "abab", s = "asdasdasdasd"
<strong>输出：</strong>true
<strong>解释：</strong>一种可能的映射如下：
'a' -> "a"
'b' -> "sdasd"
注意 'a' 和 'b' 不能同时映射到 "asd"，因为这里的映射是一种双射。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>pattern = "aabb", s = "xyzabcxzyabc"
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= pattern.length <= 20</code></li>
	<li><code>0 <= s.length <= 50</code></li>
	<li><code>pattern</code> 和 <code>s</code> 由小写英文字母组成</li>
</ul>
<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 62</li><li>👎 0</li></div>