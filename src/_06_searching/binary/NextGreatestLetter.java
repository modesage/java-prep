package _06_searching.binary;
//leetcode
//744. Find Smallest Letter Greater Than Target
public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] letter = {'c','f','j'};
        char target = 'j';
        char result = solution(letter,target);
        System.out.println(result);
    }
    public static char solution(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<letters[mid]){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return letters[start % letters.length];
    }
}
