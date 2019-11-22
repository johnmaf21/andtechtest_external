package com.and.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    /**
     * The following is the method where the solution shall be written
     */

    public static String solution(String input) throws NumberFormatException {
        StringBuilder permutations = new StringBuilder();

        for (char c : input.toCharArray()){
            try{
                Integer.parseInt(String.valueOf(c));
                permutations.append(c);
            }catch (NumberFormatException e){
            }
        }

        if (permutations.length()<=0){
            return "Error. String has no integers";
        }
        else{
            String combinations = permutations.toString();
            // create all the different permutations
        }



        return permutations.toString();
    }

    public static void main(String args[]) {
        solution("326");
    }

}
