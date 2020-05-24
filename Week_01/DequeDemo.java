package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * Created by xiaomengyun on 2020/5/24.
 */
public class DequeDemo {


    public static void main(String[] args) {

        doTest();

        //使用新的API
        doTest1();
    }

    private static void doTest1(){
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }

    private static void doTest(){
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
}
