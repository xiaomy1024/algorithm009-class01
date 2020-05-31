package leetcode.editor.cn;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


import java.util.Arrays;

public class ValidAnagram
{
  public static void main(String[] args) 
  {
      Solution solution = new ValidAnagram().new Solution();
      System.out.println(solution.m1("a","b"));
  }
  
  //题目编号:242
  //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            return m2(s,t);
        }

      /**
       * 时间复杂度 O(n)
       * @param s
       * @param t
       * @return
       */
        public boolean m2(String s, String t){
            if(s.length() != t.length()){
                return false;
            }
            int [] arrays = new int[26];
            for(int i = 0; i < s.length();i++){
                arrays[s.charAt(i) - 'a']++;
            }

            for(int i = 0; i < t.length();i++){
                int index = t.charAt(i) - 'a';
                arrays[index]--;
                if(arrays[index] < 0){
                    return false;
                }
            }
            return true;
        }

      /**
        * 暴力法
       */
        public boolean m1(String s, String t){
            char []s_chars = s.toCharArray();
            char []t_chars = t.toCharArray();

            //时间复杂度 2 * logn
            Arrays.sort(s_chars);
            Arrays.sort(t_chars);
            //n
            return Arrays.equals(s_chars,t_chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}