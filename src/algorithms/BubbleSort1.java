package algorithms;

import java.util.Arrays;

/**
 * @author shiyu
 * 将 2, 8, -1, 20, -6 进行从小到大的排序
 * （使用冒泡排序法实现）
 * 我们先看一下一步一步的演变过程
 */
public class BubbleSort1 {
    public static void main(String[] args) {
        //创建原始数组
        int[] arr = {2, 8, -1, 20, -6};

        /**
         * 一步一步展示演变过程
         */
        //第一趟排序 把最大的数排在最后
        // 需要比较4次(即【arr.length-1】次)
        int temp = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            //如果前面的数比后面的数大，就进行交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟后的数组为：" + Arrays.toString(arr));


        //第二趟排序 把第二大的数排在倒数第二位
        //这次的比较次数比以第一趟的少1次，需要比较3次(即【arr.length-1-1】次)
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            //如果前面的数比后面的数大，就进行交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟后的数组为：" + Arrays.toString(arr));


        //第三趟排序 把第三大的数排在倒数第三位
        //这次的比较次数比以第一趟的少2次，需要比价2次(即【arr.length-1-2】次)
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            //如果前面的数比后面的数大，就进行交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟后的数组为：" + Arrays.toString(arr));


        //第四趟排序 把第四大的数排在倒数第四位
        //这次的比较次数比以第一趟的少3次，需要比价1次(即【arr.length-1-3】次)
        for (int j = 0; j < arr.length - 1 - 3; j++) {
            //如果前面的数比后面的数大，就进行交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟后的数组为：" + Arrays.toString(arr));

    }
}
