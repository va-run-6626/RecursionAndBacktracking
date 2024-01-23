package Leetcode;

import java.util.*;

public class P1239_MaximumLengthOfAConcatinatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("aa");
        arr.add("bb");
        //arr.add("ue");

        System.out.println("Maximum length of concatenated String with unique characters : " + solve(arr));

    }

    private static int solve(List<String> arr) {
        return helper("",0,arr);
    }

    private static int helper(String curr, int ind, List<String> arr) {
        if(ind == arr.size()){
            return curr.length();
        }
        StringBuilder sb = new StringBuilder(curr);
        boolean isUnique = checkIsUnique(curr,arr.get(ind));
        if(!isUnique){
            return helper(curr,ind+1,arr);
        }
        //pick
        sb.append(arr.get(ind));
        int pick = helper(sb.toString(),ind+1,arr);
        sb.delete(curr.length(),sb.length());
        // not pick
        int notPick = helper(sb.toString(),ind+1,arr);
        return Math.max(pick,notPick);
    }

    private static boolean checkIsUnique(String curr, String ind) {
        int[] freq = new int[26];
        for(int i = 0; i < curr.length(); i++){
            if(freq[curr.charAt(i) - 'a'] == 0) {
                freq[curr.charAt(i) - 'a']++;
            }else {
                return false;
            }
        }
        for(int i = 0; i < ind.length(); i++){
            if(freq[ind.charAt(i) - 'a'] == 0) {
                freq[ind.charAt(i) - 'a']++;
            }else{
                return false;
            }
        }
        return true;
    }
}
