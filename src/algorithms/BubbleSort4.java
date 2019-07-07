package algorithms;

import java.util.Arrays;

/**
 * @author shiyu
 * @create 2019-07-06 9:48
 * 将冒泡排序封装成方法，方便使用
 */
public class BubbleSort4 {
    public static void main(String[] args) {
        //创建原始数组
        int[] arr = {2, 8, -1, 20, 80};

        //测试冒泡排序方法
        System.out.println("排序前：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 封装的冒泡排序方法
     */
    private static void bubbleSort(int[] arr) {
        boolean flag = false;//用于记录一趟排序中是否进行过交换
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，就进行交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;  //只要在某趟排序中进行了交换，就置为true
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第" + (i + 1) + "趟后的数组为：" + Arrays.toString(arr));

            //一趟比较结束后，判断flag的值
            if (!flag) { //如果为false,则可以提前结束冒泡排序(说明此趟排序中一次交换都没有)
                return;
            } else { //如果为true,则重置为false
                flag = false;
            }
        }
    }


}
