一直想学习数据结构与算法，跟之前一样同样遇到了一些困难，目前使用五毒神掌学习法，努力吧！

//源码分析：分析PriorityQueue对应接口方法的实现
//基于JDK1.8

public interface Queue<E> extends Collection<E> {

	//优先队列
    boolean add(E var1);
    
    boolean offer(E var1);

    E remove();

    E poll();

    E element();

    E peek();
}

//1.创建时：默认长度11,comparator为空
//2.优先队列中，add方法直接调用了offer方法，因此add 与 offer没有区别
//3.offer方法
    1）添加元素为空时，抛出空指针异常
    2) 每次添加是判断下标大小，如果空间不足时，进行自动扩容，容量小于64时，每次扩展2个长度，大于64时，容量*2
       容量最大只能是Integer.MAX_VALUE，容量超出int范围，抛出OutOfMemoryError
    3) 判断是否存在comparator
    	存在时：使用比较器排序
    	不存在：使用默认的比较器排序
    	插入的时间复杂度：O(logn)

//4.remove方法,删除元素：
    1）删除前需要先调用indexOf查询元素，遍历数组空间，时间复杂度O(n)
    2) 调用removeAt方法删除

       如果元素在末尾：直接删除即可
       如果元素在其他未知：需要重新排序，排序的复杂度是2logn
       排序完成后将最后一个元素放到删除的位置

//5.poll方法，获取对象数组中第0个元素，返回
    1）排序调整
    2) 将素组中最后一个元素，放到数组中的第0个元素


//6.element，继承自AbstractQueue，调用peek方法，没有数据抛出异常
//7.peek,获取数组中的第一个元素，下标0

