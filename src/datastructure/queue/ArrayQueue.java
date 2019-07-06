package datastructure.queue;

/**
 * @author shiyu
 * @create 2019-06-27 15:33
 * 用数组模拟队列的类
 */
public class ArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放队列数据的数组

    public ArrayQueue(int arrMaxSise) {
        maxSize = arrMaxSise;
        arr = new int[maxSize];
        front = -1;// 指向队列头部，分析出front是指向队列头的前一个位置.
        rear = -1;// 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    /**
     * 添加数据到队列中
     */
    public void addQueue(int data) {
        //先判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，无法添加数据");
            return;
        }
        rear++;//让rear后移
        arr[rear] = data;
    }

    /**
     * 判断队列是否满
     */
    private boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 从队列中取数据
     *
     * @return 返回取出的数据
     */
    public int getQueue() {
        //先判断队列是否为空
        if (isEmpty()) {
            //抛个异常
            throw new RuntimeException("队列为空，无法取出数据");
        }
        front++;//front后移
        return arr[front];
    }

    /**
     * 判断队列是否为空
     */
    private boolean isEmpty() {
        return front == rear;
    }

    /**
     * 显示队列现有的所有数据，注意是从头数据开始显示
     */
    public void showQueue() {
        //先判空
        if (isEmpty()) {
            System.out.println("队列为空，没有数据可以显示");
            return;
        }

        //遍历数组，依次打印数据。注意是从现有的头数据开始显示
        for (int i = front + 1; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据。
     * 注意:只显示并没有取出数据，所以front的指向位置并没有变。
     */
    public int showHeadData() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据可以显示");
        }
        //由于front是指向队列头的前一个位置，所以【front+1】的位置才是队列的头
        return arr[front + 1];
    }

}
