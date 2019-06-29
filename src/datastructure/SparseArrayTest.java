package datastructure;

import java.io.*;
import java.util.ArrayList;


/**
 * @author shiyu
 * @create 2019-06-03 10:57
 * 稀疏数组练习
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        /**
         * 创建一个11*11的二维数组 ，来模拟五子棋棋盘
         * 其中值1代表黑棋，棋2代表蓝棋
         */
        int[][] gobangArray = new int[11][11];
        gobangArray[1][2] = 1;
        gobangArray[2][3] = 2;

        System.out.println("原始棋局：");
        for (int[] row : gobangArray) {
            for (int element : row) {
                System.out.printf("%d\t", element);
            }
            System.out.println();
        }

        /**
         * 遍历原始棋局，得到棋子总数
         */
        int sum = 0;
        for (int[] row : gobangArray) {
            for (int element : row) {
                if (element != 0) sum++;
            }
        }

        /**
         * 创建稀疏数组 int[sum+1][3]
         * 第一行存原始棋局的行数，列数 和 棋子数
         * 后面的每一行：第一列 存棋子的所在行下标，第二列 存棋子的所在列下标，第三列 存值
         */
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int sparseRow = 1;
        for (int row = 0; row < 11; row++) {
            for (int column = 0; column < 11; column++) {
                if (gobangArray[row][column] != 0) {
                    sparseArray[sparseRow][0] = row;
                    sparseArray[sparseRow][1] = column;
                    sparseArray[sparseRow][2] = gobangArray[row][column];
                    sparseRow++;
                }
            }
        }

        /**
         * 验证一下
         */
        System.out.println();
        System.out.println("稀疏数组为：");
        for (int[] row : sparseArray) {
            for (int element : row) {
                System.out.printf("%d\t", element);
            }
            System.out.println();
        }


        //将稀疏数组存入到文件中
        File file = new File("e:\\array.txt");  //存放数组数据的文件
        try {
            FileWriter out = new FileWriter(file);  //文件写入流
            //将数组中的数据写入到文件中。每行各数据之间用TAB间隔
            for (int i = 0; i < sparseArray.length; i++) {
                for (int j = 0; j < 3; j++) {
                    out.write(sparseArray[i][j] + "\t");
                }
                out.write("\r\n");
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("存入文件时出现异常：" + e.getMessage().toString());
        }

        /**
         * 从txt文件中读取数据
         */
        File txtFile = new File("e:\\array.txt");
        int[][] txtSparseArr = new int[3][3];
        try {
            String line;//存放每行的数据
            int row = 0;//记录行数
            if (txtFile.exists()) {
                BufferedReader in = new BufferedReader(new FileReader(txtFile));
                while ((line = in.readLine()) != null) {
                    String[] temp = line.split("\t");
                    for (int j = 0; j < temp.length; j++) {
                        txtSparseArr[row][j] = Integer.parseInt(temp[j]);
                    }
                    row++;
                }
            } else {
                System.out.println("没有找到文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 验证一下
         */
        System.out.println();
        System.out.println("txt中得到的稀疏数组：");
        for (int[] lineData : txtSparseArr) {
            for (int ele : lineData) {
                System.out.printf("%d\t", ele);
            }
            System.out.println();
        }


        File file5 = new File("e:\\array.txt");
        ArrayList<String> txtData = new ArrayList<>();
        try {
            String line;
            if (file5.exists()) {
                BufferedReader in = new BufferedReader(new FileReader(file5));
                while ((line = in.readLine()) != null) {
                    txtData.add(line);
                }
            } else {
                System.out.println("没有找到文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (txtData != null && txtData.size() > 0) {
            String[] firstLine = txtData.get(0).split("\t");
            int rows = txtData.size();//得到行数
            int columns = firstLine.length;//得到列数
            int[][] sparseArray3 = new int[rows][columns];
            for (int i = 0; i < txtData.size(); i++) {
                String[] oneLine = txtData.get(i).split("\t");
                //如果数组 sparseArray3 和 onLine 中的元素类型相同，则只要写此行就可以了
//                sparseArray3[i] = oneLine;
                for (int j = 0; j < oneLine.length; j++) {
                    sparseArray3[i][j] = Integer.parseInt(oneLine[j]);
                }
            }

            System.out.println();
            System.out.println("新方式得到的稀疏数组222：");
            for (int[] lineData : sparseArray3) {
                for (int ele : lineData) {
                    System.out.printf("%d\t", ele);
                }
                System.out.println();
            }
        }


        /**
         * 从文件中读取二维数组，不知道行数和列数的情况下
         */
        File file3 = new File("e:\\array.txt");
        ArrayList<String> everyRow = new ArrayList<>();
        ArrayList<ArrayList<String>> rowsList = new ArrayList<>();
        int lineNums = 0;
        try {
            String line;
            BufferedReader in = new BufferedReader(new FileReader(file3));
            while ((line = in.readLine()) != null) {
//                everyRow.clear();
                everyRow = new ArrayList<>();
                String[] lineArray = line.split("\t");
                for (int j = 0; j < lineArray.length; j++) {
                    everyRow.add(lineArray[j]);
                }
                rowsList.add(everyRow);
                lineNums++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取文件时出现异常3：" + e.getMessage().toString());
        }

        int colums = everyRow.size();
        System.out.println();
        System.out.print("求得文件中数组的行数和列数：lineNums=" + lineNums + "  ,colums=" + colums);

        int[][] txtArray = new int[lineNums][colums];
        for (int i = 0; i < lineNums; i++) {
            for (int j = 0; j < colums; j++) {
                txtArray[i][j] = Integer.parseInt(rowsList.get(i).get(j));
            }
        }

        System.out.println();
        System.out.println("文件数组为:");
        for (int[] row : txtArray) {
            for (int element : row) {
                System.out.printf("%d\t", element);
            }
            System.out.println();
        }


        /**
         * 从文件中读取内容，并转换为数组
         */
        File file2 = new File("e:\\array.txt");  //取出文件中的数据
        try {
            int n = 3;  //N*N数组
            int[][] arr2 = new int[n][n]; //读取出的数组
            BufferedReader in = new BufferedReader(new FileReader(file2));

            String line;  //一行数据
            int row = 0;
            //逐行读取，并将每个数组放入到数组中
            while ((line = in.readLine()) != null) {
                String[] temp = line.split("\t");
                for (int j = 0; j < temp.length; j++) {
                    arr2[row][j] = Integer.parseInt(temp[j]);
                }
                row++;
            }
            in.close();

            System.out.println();
            System.out.println("从文件中读取到的数组：");
            //显示读取出的数组
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d\t", arr2[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取文件时出现异常：" + e.getMessage().toString());
        }


        /**
         * 根据稀疏数组恢复棋局
         * 遍历稀疏数组的每行，给新棋局进行赋值
         */
        int row1 = txtSparseArr[0][0];
        int column1 = txtSparseArr[0][1];
        int[][] gobangArray2 = new int[row1][column1];
        for (int i = 1; i < txtSparseArr.length; i++) {//需从第二行开始
            int row2 = txtSparseArr[i][0];
            int column2 = txtSparseArr[i][1];
            int value = txtSparseArr[i][2];
            gobangArray2[row2][column2] = value;
        }

        System.out.println();
        System.out.println("复局后的新棋盘");
        for (int[] row : gobangArray2) {
            for (int element : row) {
                System.out.printf("%d\t", element);
            }
            System.out.println();
        }

    }
}
