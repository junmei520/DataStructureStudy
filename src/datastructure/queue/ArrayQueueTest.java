package datastructure.queue;

import datastructure.queue.ArrayQueue;

import java.util.Scanner;

/**
 * @author shiyu
 * @create 2019-06-27 16:16
 * 测试ArrayQueue
 *
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        //测试数组模拟队列
        //先创建一个最大容量为3的队列
        //ArrayQueue queue = new ArrayQueue(3);

        //测试环形数组来模拟队列
        //创建一个容量为4的数组，
        // 但是它实际最多只能装3个数据，因为有一个空间需要用来做约定。
        CircleArrayQueue queue =new CircleArrayQueue(4);

        //用于接收用户键盘输入的指令
        char order = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //相关指令提示信息
        System.out.println("s(show): 显示队列");
        System.out.println("e(exit): 退出程序");
        System.out.println("a(add): 添加数据到队列");
        System.out.println("g(get): 从队列取出数据");
        System.out.println("h(head): 查看队列头的数据");
        while (loop) {
            order = scanner.next().charAt(0);//每次只接收一个字符
            switch (order) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入你要加入队列的数据");
                    int data = scanner.nextInt();
                    queue.addQueue(data);
                    break;
                case 'g':
                    int queueData = queue.getQueue();
                    System.out.println("取出的队列数据是：" + queueData);
                    break;
                case 'h':
                    int headData = queue.showHeadData();
                    System.out.println("队列的头数据为：" + headData);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}
