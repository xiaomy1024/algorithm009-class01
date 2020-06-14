学习笔记

#贪心算法

找局部最优解

```

贪心算法与动态规划的区别是动态规划保存之前的执行结果，可以进行回溯

```


# DFS模板

```
//二叉树
private Set<TreeNode> visted = new HashSet<<>();
public void dfs(TreeNode node){
    //终止条件
    if(visted.contains(node)){
        return;
    }
    visted(node);
    
    dfs(node.left);
    dfs(node.right);
}

//多叉树
public void dfs(TreeNode node){
    //终止条件
    if(visted.contains(node)){
        return;
    }
    visted.add(node);
    
    if(node.children!=null){
        for(TreeNode child:node.children){
            dfs(child);
        }
    }
}

//非递归
public void dfs(TreeNode node){
    //终止条件
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.offer(node);
    
    while(!stack.empty()){
       TreeNode data = stack.pop();
       if(data != null){
            visted.add(data);
            stack.add(data.left);
            stack.add(data.right);
       }
    }
}

```

#BFS

```
private Set<TreeNode> visted = new HashSet<<>();
public void bfs(TreeNode node){
    Queue<TreeNode> queue = new LinedList();
    queue.offer(node);
    
    while(!queue.isEmpty()){
        TreeNode data = queue.pop();
        if(data != null){
            visted.add(data);
            data.offer(data);
        }
    }
}

```

#二分查找代码模板

##前提条件：
1. 单调性（递增、递减）
2. 有上下边界
3. 下标访问


模板：

```
int left = 0,right = arrays.length -1,mid = 0;

while(left <= right){
    //非溢出写法 mid = left + (right - left)/2;
    mid = (left + right)/2;
    
    if(arrays[mid] ==  target){
        return arrays[mid];
    }
    
    if(arrays[mid] < target){
        left = mid + 1;
    }else{
        right = mid - 1;
    }
}


```

