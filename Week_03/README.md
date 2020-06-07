能够感觉到自己的进步，不过这周很多题做不出来了，感觉的一些困难，坚持用五毒神掌学习


递归模板

```
  public static void recursion(problem,param1,param2,...){

  	//终止条件
  	if(problem == null){
  		return ;
  	}

  	//处理问题 process
  	doBiz();

  	//进入下一层
  	recursion(problem + 1,param1,...);

  	//清楚状态
  	clear();
  }

```



分治代码模板
```

public static void divide_conquer(problem,param1,param2,...){
	
	//终止条件
	if(problem == null){
		return;
	}

	//拆分子问题
	data = prepare_data(problem) 
  	subproblems = split_problem(problem, data) 

  	//处理子问题，进入下一层
  	subresult1 = divide_conquer(subproblems[0], p1, ...);
    subresult2 = divide_conquer(subproblems[1], p1, ...);

    #process，合并结果
    result = process_result(subresult1, subresult2, subresult3, …)

    #回溯状态
}

```