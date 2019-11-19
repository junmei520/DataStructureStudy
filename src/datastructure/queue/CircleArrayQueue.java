package datastructure.queue;

/**
 * @author shiyu
 * @create 2019-10-31 15:20
 * 用"环形"数组 来模拟 队列
 */
public class CircleArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//front指向队列的头
    private int rear;//注意：rear是指向队列的尾的下一个位置
    private int[] arr;//用于存放队列数据的数组

    public CircleArrayQueue(int arrMaxSise) {
        maxSize = arrMaxSise;
        arr = new int[maxSize];
        //front,rear不用赋值，默认值都是0
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
        arr[rear] = data;
        //rear需要向后移动，为了发挥它的复用性并防止它越界，我们这里要取模
        rear=(rear+1)%maxSize;
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
        int value=arr[front]; //需要临时变量来接收一下
        front=(front+1)%maxSize;//front需要后移，此处同样需要取模
        return value;
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
        for (int i = front; i < front+realSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
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
        //front---就是队列头对应的下标
        return arr[front];
    }

    /**
     * 队列中 装的 实际数据的个数
     */
    private int realSize(){
        return (rear+maxSize-front)%maxSize;
    }

    /**
     * 判断队列是否满
     * 当  (rear+1)%maxSize==front 时 ，队列满
     */
    private boolean isFull() {
        return (rear+1)%maxSize==front;
    }

    /**
     * 判断队列是否为空
     */
    private boolean isEmpty() {
        return front==rear;
    }


}
