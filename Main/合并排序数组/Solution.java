
/*
给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

示例:

输入:
A = [1,2,3,0,0,0,0,0], m = 3
B = [1,2,5,6,7],       n = 5

输出: [1,2,2,3,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sorted-merge-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class Solution {

    //双指针法
    public void merge(int[] A, int m, int[] B, int n) {
        int[] result = new int[m + n];
        int indeXA = 0;
        int indexB = 0;
        int indexResult = 0;
        while (indeXA < m && indexB < n) {
            System.out.println(indeXA + "," + indexB);
            result[indexResult++] = A[indeXA] <= B[indexB] ? A[indeXA++] : B[indexB++];//先比较，取小，较小的index再进行自增
//            result[indexResult] = Math.min(A[indeXA], B[indexB]);  //可直接使用函数
            System.out.println(indeXA + "," + indexB);
        }

        int[] left = null;
        int indexleft;

        if (m == indeXA) {
            left = B;
            indexleft = indexB;
        } else {
            left = A;
            indexleft = indeXA;
        }

        while (indexResult < m + n) {
            result[indexResult++] = left[indexleft++];
        }

//        A = result;//这样并不能改变A数组中的值！！！！

        for (int i = 0; i < m + n; i++) {
            A[i] = result[i];
        }

    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        new Solution().merge(A, 3, B, 3);
    }

}
