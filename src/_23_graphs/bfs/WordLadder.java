package _23_graphs.bfs;
//https://leetcode.com/problems/word-ladder/
import java.util.*;

public class WordLadder {
    //using bidirectional bfs
    //optimized
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Use a HashSet for faster lookup
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        // Initialize the begin and end sets for Bidirectional BFS
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int len = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand from the smaller set to optimize the search
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chArr = word.toCharArray();
                for (int i = 0; i < chArr.length; i++) {
                    char originalChar = chArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chArr[i] = c;
                        String newWord = new String(chArr);

                        // If the word is found in the opposite set, we have connected the two ends
                        if (endSet.contains(newWord)) {
                            return len + 1;
                        }

                        // If the new word is in the dictionary, add it to the next layer
                        if (dict.contains(newWord)) {
                            nextSet.add(newWord);
                            // Remove from the dictionary to prevent revisiting
                            dict.remove(newWord);
                        }
                    }
                    // Restore the original character
                    chArr[i] = originalChar;
                }
            }

            // Move to the next level of BFS
            beginSet = nextSet;
            len++;
        }
        return 0;
    }

    //not optimize solution
    public int ladderLengthSol2(String beginWord, String endWord, List<String> wordList) {
        Queue<PairHere> q = new LinkedList<>();
        q.add(new PairHere(beginWord,1));
        Set<String> st = new HashSet<String>(wordList);
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord)){
                return steps;
            }
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        q.add(new PairHere(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
class PairHere{
    String first;
    int second;
    PairHere(String first, int second){
        this.first = first;
        this.second = second;
    }
}