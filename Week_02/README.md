HashMap阅读源码总结
说明：关于红黑树的部分后续理解再补上

总结：

1. HashMap，一般情况存、取、插入的时间复杂度为O(1)，当Hash存在冲突时，冲突的数据组成列表，
此时时间复杂度退化成O(n)，n< 8,当大于8时，列表被转换成红黑树，此时操作的时间退化成O（logn）

2. 根据第一点，所以HashMap保证性能的原则是，hash函数保证hash少冲突，才能够保证性能

3. hash在发生扩容时，有大量节点复制，此时的时间复杂度是O(n),因此在实现知道当前HashMap存储数据量的情况下，指定容量大小
有助于提升性能

4. DEFAULT_LOAD_FACTOR加载因子，此数表示数据的容量的使用率，默认0.75f，表示100个容量的话，最多存储75个节点,就需要扩容了
过大，如果过大，则在hash冲突时，导致性能下家，如果过小又会导致内存浪费

---------------------------------------------------------------------

1.get方法
	* 调用hash方法，获取key对应的hashcode* (n - 1) & hash 获取key存放的下标并获取到数组中的first节点
	
		1)如果hash相等，并且key值相等，直接返回first
		2)如果第一步未找到对象，在判断first是否存在下一个节点，如果存在见逻辑3
		3)判断first是否是TreeNode(树)，如果不是走逻辑4，是走逻辑5
		4)循环next的列表，找到hash相等和key相等的节点，找到返回，没有找到返回null,查找结束（此时hash冲突的自节点是链表）
		5)调用TreeNode的getTreeNode（此时hash冲突的节点组成了树形结构）
			*第一步找到树的根节点
			*二叉树查找，时间复杂度（logn），比较大小使用key的hash大小，或者是使用key的比较器


2.put方法

	* 调用hash方法，获取key对应的hashcode
	* 判断当前存放节点的数组是否为空，为空时调用resize方法，创建hash对象
	* 计算hash值、计算存到的位置(n - 1) & hash，如果该位置不存在对象，则直接创建新对象,赋值即可
	```
		tab[i] = newNode(hash, key, value, null);
	```
	* 如果当前位置的节点数据存在，需要进行以下三种情况的判断
	   1）当前节点的key与当前放入的key值相等，则找到改节点，后续更新改节点的value值
	   	```
		if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
	   	```
	   2) 如果当节点是TreeNode，则按照红黑树的方式，添加或者覆盖节点
	   3) 如果是列表结构
	      * 循环查找，如果找到，则覆盖值即可
	      * 没有找到，创建新的节点，如果列表节点数量超过TREEIFY_THRESHOLD,8个，则将列表转成红黑树的方式存储，否则不作处理
	      ```
				for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
	      ```
	    4)后续处理,返回当前节点之前的值，对当前节点赋最新的值，onlyIfAbsent需要注意，如果是true表示冲突时，不覆盖之前的值
	    ```
				V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
	    ```



3.resize 方法理解
	
	* 初始化oldCap（扩容之前的容量大小）、oldThr（扩容之前的存储边界），newCap（扩容后的容量大小），newThr（扩容后的存储边界）
	* oldCap容量大于0时
		1)判断是否大于MAXIMUM_CAPACITY，如果是，设置存储边界为Integer的最大值threshold = Integer.MAX_VALUE
		2)oldCap进行双倍扩容，如果小于MAXIMUM_CAPACITY并且oldCap大于DEFAULT_INITIAL_CAPACITY,则也将新的边界值newThr进行2呗扩容

	```
	    MAXIMUM_CAPACITY = 1 << 30;
	    DEFAULT_INITIAL_CAPACITY = 1 << 4;

		if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }

	```
	* oldCap小于等于0时，oldThr大于零newCap = oldThr，将新的容量设置成oldThr
	* 其他情况，初始化新容量大小为16，新的边界值为16 * 0.75（默认的加载因子）

	```
	 else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
    ```
    * 如果newThr未被初始化，则需要再次计算边界值
    ```
		float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
    ```
    * 根据新的newCap，创建存储数据的Node数组
    * 将老的Node数据复制循环到新的Node数组中，分三种情况
    	1）节点的对象hash没有发生冲突,是单节点，则直接将数据复制到新数组即可
    	2) 节点对象发生了冲突，但是后续冲突节点组成了单向列表，则使用(e.hash & oldCap) == 0来判断当前节点的高低位，拼接成列表
    	   如果是高位则将新组成的列表放入到节点下标+oldCap的数组位置（newTab[j + oldCap] = hiHead;），
    	   低位则放到节点下标处newTab[j] = loHead

    	   ```
    	   Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
            ```
        3）如果节点是TreeNode类型，则将原来的节点复制到新的树节点列表中，此处需要学习红黑树的实现


---------------------------------------------------------------------
二叉树：每个节点只可能存在左右两个节点
图：树与图区别是图有环
前序排列：根->左->右
中序排列：左->根->右
后续排列：左->右->根

二叉树搜索树：整体的时间复杂度：O(logn)
* 左子树的所有节点小于它的根节点
* 右子树的所有节点大于它的根节点
* 以此类推：左右子树也是二叉搜索树
* 插入操作，根据二叉查找树的特性，查找到应该存放的位置，比根节点小，则查找左边，大则查找右边
* 查找操作，与二分查找逻辑一致
* 删除操作，先找到节点，如果存在，删除，将右子树的与删除数据最接近的数据放到被删除的节点中

堆：可以迅速找到一堆数中最大或者最小的数据结构，常见的堆：二叉堆、斐波那契堆
* 根节点的数据总是大于子节点，大顶堆
* 根节点的数据总是小于子节点，则叫小顶堆
* find-max 时间复杂度O(1)
* delete-max O(logn)
* insert O(logn) or O(1)

二叉堆
* 是一课完全树
* 树中任意节点的值总是大于>=子节点是值
* 左儿子节点：2*i + 1
* 右儿子节点：2*i + 2
* 父节点：(i - 1)/ 2
* 插入操作：新元素一律插到堆的尾部，然后依次向上调整堆的结构（heapifty UP）
* 删除操作：将尾部的节点替换根节点，然后依次向下调整堆的结构（heapifty down）

图：Graph(V,E)
V：vertex 点
1.度：入度与出度
2.点与点的连接：连通与否

E:edge -边
1.有向和无向（单行）
2.权重（边长）



