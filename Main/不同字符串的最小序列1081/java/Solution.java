package 不同字符串的最小序列1081.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。

 

示例 1：

输入："cdadabcc"
输出："adbc"
示例 2：

输入："abcd"
输出："abcd"
示例 3：

输入："ecbacba"
输出："eacb"
示例 4：

输入："leetcode"
输出："letcod"
 

提示：

1 <= text.length <= 1000
text 由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution {
    public String smallestSubsequence(String text) {
        char[] charList = text.toCharArray();
        List<Character> characterArrayList = new ArrayList<>();
        for (char each : charList) {
            characterArrayList.add(each);
        }

        List<Character> result = characterArrayList.stream().distinct().collect(Collectors.toList());
        result.sort(Comparator.comparingInt(a -> a));
        StringBuilder output = new StringBuilder();
        result.forEach(output::append);
        return output.toString();
    }


    public static void main(String[] args) {
        new Solution().smallestSubsequence("akdacnaefalf");
    }

}
