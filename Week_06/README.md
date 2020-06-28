学习笔记

## 关键点

1. 最优子结构 opt[n] = bestof(opt[n - 1],opt[n - 2]);
2. 储存中间状态：opt[i]
3. 递推公式（美其名曰：状态转移方程式或者DP方程）

```
Fib:opt[i] = opt[n-1] + opt[n-2]
二维路径：opt[i,j] = opt[i + 1][j] + opt[i][j+ 1] (判断a[i,j]是否是空地)
```