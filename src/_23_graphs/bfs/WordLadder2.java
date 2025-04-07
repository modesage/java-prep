package _23_graphs.bfs;
//https://leetcode.com/problems/word-ladder-ii/
import java.util.*;

public class WordLadder2 {
    //cp oriented
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;

        // This map records for each word all its parents (words from which it can be reached in one transformation)
        Map<String, List<String>> parents = new HashMap<>();

        // Set to hold the current level of BFS
        Set<String> level = new HashSet<>();
        level.add(beginWord);

        // Perform BFS until we either run out of words or find the endWord.
        // We don't want to continue beyond the shortest paths.
        while (!level.isEmpty() && !parents.containsKey(endWord)) {
            Set<String> nextLevel = new HashSet<>();
            // Remove the current level words from the dictionary to prevent loops
            dict.removeAll(level);
            for (String word : level) {
                char[] chArr = word.toCharArray();
                for (int i = 0; i < chArr.length; i++) {
                    char originalChar = chArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chArr[i] = c;
                        String newWord = new String(chArr);
                        if (dict.contains(newWord)) {
                            // Record the parent (the current word) for newWord
                            parents.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
                            nextLevel.add(newWord);
                        }
                    }
                    chArr[i] = originalChar;
                }
            }
            level = nextLevel;
        }

        // If endWord was never reached, return empty result
        if (!parents.containsKey(endWord)) return res;

        // Backtracking from endWord to beginWord to build all paths
        List<String> path = new ArrayList<>();
        backtrack(res, path, parents, beginWord, endWord);
        return res;
    }

    // DFS/backtracking helper to construct the paths using the parents map
    private void backtrack(List<List<String>> res, List<String> path, Map<String, List<String>> parents, String beginWord, String word) {
        if (word.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            validPath.add(beginWord);
            Collections.reverse(validPath);
            res.add(validPath);
            return;
        }
        // Add the current word to the path
        path.add(word);
        // Recurse on all parents of the current word
        if (parents.containsKey(word)) {
            for (String parent : parents.get(word)) {
                backtrack(res, path, parents, beginWord, parent);
            }
        }
        // Backtrack: remove the current word from the path
        path.remove(path.size() - 1);
    }

    // Interview oriented: Find all shortest transformation sequences using BFS and explicit path tracking.
    ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        // Create a set from wordList for fast lookup.
        Set<String> st = new HashSet<>();
        for (String word : wordList) {
            st.add(word);
        }

        // Queue to hold paths. Each path is represented as an ArrayList of words.
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> initialPath = new ArrayList<>();
        initialPath.add(startWord);
        q.add(initialPath);

        // List to track words used at the current level.
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);

        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        // BFS: Process paths level by level.
        while (!q.isEmpty()) {
            ArrayList<String> path = q.peek();
            q.remove();

            // When moving to a new level, remove all words used in the previous level from the set.
            if (path.size() > level) {
                level++;
                for (String word : usedOnLevel) {
                    st.remove(word);
                }
                usedOnLevel.clear();
            }

            // Get the last word of the current path.
            String lastWord = path.get(path.size() - 1);

            // If we reached the target word, add the path to the answer.
            if (lastWord.equals(targetWord)) {
                if (ans.isEmpty() || ans.get(0).size() == path.size()) {
                    ans.add(new ArrayList<>(path));
                }
            }

            // Try all one-letter transformations of the last word.
            for (int i = 0; i < lastWord.length(); i++) {
                char[] replacedCharArray = lastWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    replacedCharArray[i] = c;
                    String newWord = new String(replacedCharArray);
                    if (st.contains(newWord)) {
                        // Extend the current path with the new word.
                        path.add(newWord);
                        // Add the new path to the queue.
                        q.add(new ArrayList<>(path));
                        // Mark the new word as used on this level.
                        usedOnLevel.add(newWord);
                        // Backtrack: remove the last word before trying the next transformation.
                        path.remove(path.size() - 1);
                    }
                }
            }
        }
        return ans;
    }
}
