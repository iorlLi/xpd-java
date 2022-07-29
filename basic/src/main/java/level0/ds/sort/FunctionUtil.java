package level0.ds.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionUtil {
    public static int count = 1;

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,3,2,1,1};
        new FunctionUtil().Function1(new ArrayList<Integer>(Arrays.asList(arr)));
        System.out.println(Arrays.toString(arr));
    }

    public ArrayList<Integer> Function1(List<Integer> intList) {
        //变换List成int[]
        int[] matrix = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            matrix[i] = intList.get(i);
        }
        System.out.print("sort前：");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + " ");
        }
        System.out.println("");

        Function2(matrix, 0, matrix.length - 1);
        System.out.print("sort后：");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + " ");
        }
        System.out.println("");

        System.out.println(count);
        return (ArrayList<Integer>) intList;
    }


    public void Function2(int[] matrix, int left, int right) {
        count++;
        if (left <= right) {
            // 中间点为参照物
            int p = matrix[left + (right - left) / 2];
            //int p = matrix[(left + right) / 2];
            int l = left;
            int r = right;

            while (l <= r) {
                // 左边找个大于参照点， 这里会越界
                while (matrix[l] < p) {
                    l++;
                }
                //右边找个参照点
                while (matrix[r] > p) {
                    r--;
                }
                // 交换
                if (l <= r) {

                    int tmp = matrix[l];
                    matrix[l] = matrix[r];
                    matrix[r] = tmp;
                    l++;
                    r--;
                }

            }

            Function2(matrix, left, r);
            Function2(matrix, l, right);
        }
    }

}
