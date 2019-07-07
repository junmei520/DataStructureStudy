package algorithms;

import java.util.Arrays;

/**
 * @author shiyu
 * 将  2, 8, -1, 20, -6 进行从小到大的排序
 * （使用冒泡排序法实现）
 * 抽取后的写法
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        //创建原始数组
        int[] arr = {2, 8, -1, 20, 80};

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，就进行交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟后的数组为：" + Arrays.toString(arr));
        }
    }
}
