package com.and.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    /**
     * The following is the method where the solution shall be written
     */

    public static String solution(String input) throws NumberFormatException {
        StringBuilder permutations = new StringBuilder();

        /*this is getting all the character from the input
        that can be turned into an integer and storing them*/
        for (char c : input.toCharArray()){
            try{
                Integer.parseInt(String.valueOf(c));
                permutations.append(c);
            }catch (NumberFormatException e){
                /*must mean the character can't be turned into an
                integer so it goes to next character*/
            }
        }
        //Error exception message as input must have no integers
        if (permutations.length()<=0){
            return "Error. String has no integers";
        }
        else {
            boolean finished = false;
            //all given
            char[] combinations =permutations.toString().toCharArray();
            //empty string builder
            permutations.delete(0,permutations.length());
            Arrays.sort(combinations);
            while (true){
                //add current possible combination to string builder
                permutations.append(String.valueOf(combinations)+",");
                int i = combinations.length-1;
                while(combinations[i-1]>=combinations[i]){
                    //checks to see if the largestIndex is the first index in char[]
                    //this means we can return answer as all the combinations have been found
                    if (--i == 0){
                                                            //used substring to get rid of final comma
                        String answer = permutations.toString().substring(0,permutations.length()-1);
                        return answer;
                    }
                }

                //gets highest index to ith index to the right of largestIndex
                int j =combinations.length-1;
                while (j > i && combinations[j] <= combinations[i-1])
                    j--;
                // Swap characters at index i-1 with index j
                swap(combinations, i-1, j);

                /* reverse the substring of combinations from i to
                length-1*/
                reverse(combinations, i, combinations.length-1);
            }
        }

    }

    public static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    public static void reverse(char[] arr, int i, int j)
    {
        // do till two end-points intersect
        while (i < j) {
            swap(arr, i++, j--);
        }
    }


    public static void main(String args[]) {
        System.out.println(solution("A 3B2 C6D"));
    }

}
