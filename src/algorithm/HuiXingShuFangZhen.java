package algorithm;

import java.util.Scanner;

/**
 * 从键盘输入一个整数（1~20）
 * 则以该数字为矩阵的大小，把1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。
 * 例如： 输入数字2，则程序输出：
 * 1 2
 * 4 3
 * 输入数字3，则程序输出：
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * 输入数字4， 则程序输出：
 * 1   2   3   4
 * 12  13  14  5
 * 11  16  15  6
 * 10   9  8   7
 */
public class HuiXingShuFangZhen {
    public static void main(String[] args) {
//        method1();
        method2();

    }

    public static void method1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个20以内的数字：");
        int len = sc.nextInt();

//        long startTime = System.currentTimeMillis();    //获取开始时间
        long startTime=System.nanoTime();   //获取开始时间
        int[][] arr = new int[len][len];

        int k = 1; // k=1代表向右，k=2向下，k=3向左，k=4向上
        int i = 0, j = 0;
        for (int m = 1; m <= len * len; m++) {
            if (k == 1){
                if (j < len && arr[i][j] == 0){
                    arr[i][j++] = m;
                }else{
                    k = 2;
                    i++;
                    j--;
                    m--;
                }
            } else if (k == 2){
                if (i < len && arr[i][j] == 0){
                    arr[i++][j] = m;
                }else{
                    k = 3;
                    i--;
                    j--;
                    m--;
                }
            } else if (k == 3){
                if (j >= 0 && arr[i][j] == 0){
                    arr[i][j--] = m;
                }else{
                    k = 4;
                    i--;
                    j++;
                    m--;
                }
            } else if (k == 4){
                if (i >= 0 && arr[i][j] == 0){
                    arr[i--][j] = m;
                }else{
                    k = 1;
                    i++;
                    j++;
                    m--;
                }
            }
        }

        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

//        long endTime = System.currentTimeMillis();    //获取结束时间
        long endTime = System.nanoTime(); //获取结束时间
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");

    }

    public static void method2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("请输入一个20以内的数字：");
        int len = sc.nextInt();
        int[][] arr = new int[len][len];

//        startTime = System.currentTimeMillis();
        long startTime = System.nanoTime();
        int minX = 0, minY = 0;
        int maxX = len-1, maxY = len-1;
        int num = 0;
        while(minX <= maxX){
            for (int x = minX; x <= maxX; x++) {
                arr[minY][x] = ++num;
            }
            minY++;
            for (int y = minY; y <= maxY; y++) {
                arr[y][maxX] = ++num;
            }
            maxX--;
            for (int x = maxX; x >= minX ; x--) {
                arr[maxY][x] = ++num;
            }
            maxY--;
            for (int y = maxY; y >= minY ; y--) {
                arr[y][minX] = ++num;
            }
            minX++;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
//        endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();
//        System.out.println(endTime - startTime + "ms");
        System.out.println("程序运行时间：" + (endTime - startTime) + "ns");
    }
}
