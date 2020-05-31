package leetcode.editor.cn;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.*;

public class GroupAnagrams
{
  public static void main(String[] args) 
  {
       Solution solution = new GroupAnagrams().new Solution();
  }
  
  //题目编号:49
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        //按异位分组
        //
        Map<String,List<String>> dataMap = new HashMap<>();
        for(String str:strs){
            char [] chars = str.toCharArray();
            //另一个思路是，用26位数字存储字母数量，然后拼接出字符串
            Arrays.sort(chars);
            String key = new String(chars);
            List<String>  dataList = dataMap.get(key);
            if(dataList == null){
                dataList = new ArrayList<>();
                dataMap.put(key,dataList);
            }
            dataList.add(str);
        }
        return new ArrayList<>(dataMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}