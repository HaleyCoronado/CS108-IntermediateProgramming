/**
 *  Program #6
 *  CS108-3
 *  April 19th 2021
 *  @author  Haley Coronado
 */

public class RecursiveMethods {

    /**
     * an object on a grid must move n spaces, each move can be 1 or 2 spaces
     * determines the total distinct ways to advance n spaces
     * ex: if the input is 4, 5 is returned
     * @param n number of spaces to move
     * @return number of possible ways to move n spaces
     */
    public int byLeapsAndBounds(int n) {

        if(n <= 2){
            // base case
            return n;
        } else {
            // counts methods
            return byLeapsAndBounds(n - 1) + byLeapsAndBounds(n - 2);
        }
    }

    /**
     * takes two string parameters and returns the number of times the
     * substring occurs within the given string
     * ex: if str is "abcabddabcde" and subStr is "abc", 3 is returned
     * @param str the string being searched
     * @param subStr the substring being looked for
     * @return the number of times subStr occurs in str
     */
    public int subCount(String str, String subStr) {

        // checks for substring
        if(str.contains(subStr)){
            String tmpStr = str.replaceFirst(subStr, "");

            // checks new string for substring
            if(tmpStr.contains(subStr)){
                return subCount(tmpStr, subStr) + 1;
            } else {
                // base case
                return 1;
            }
        }
        // string not found
        return 0;
    }

    /**
     * takes a sorted int array, a target number, left index, and right index
     * and uses a binary search to find the index of the target number
     * @param array the given array
     * @param target the number being searched for
     * @param left the index of the first number in the array being searched
     * @param right the index of the last number in the array being searched
     * @return the index of the number being searched for
     */
    public int binarySearch(int[] array, int target, int left, int right) {
        // if right is less than left then target does not exist
        if(right < left){
            return -1;
        }

        // calculates new middle index
        int middle = (right - left) / 2 + left;

        // if target is found return index
        // if not check if target is in upper or lower half and search
        if(target == array[middle]){
            return middle;
        } else if(target < array[middle]){
            return binarySearch(array, target, left, middle - 1);
        } else {
            return binarySearch(array, target, middle + 1, right);
        }
    }
}