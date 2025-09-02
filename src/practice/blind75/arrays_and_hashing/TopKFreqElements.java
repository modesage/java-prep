package practice.blind75.arrays_and_hashing;
//https://leetcode.com/problems/top-k-frequent-elements/description/
//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        //getting freq
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            if(!freqMap.containsKey(num)){
                freqMap.put(num, 1);
            }
            else{
                freqMap.put(num, freqMap.get(num) + 1);
            }
        }
        //create a bucket where freq = index
        List<Integer>[] bucket = new List[nums.length + 1]; //as max freq = num.length
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        //get the top k elements
        List<Integer> elements = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && elements.size() < k; i--){
            if(bucket[i] != null){
                elements.addAll(bucket[i]);
            }
        }
        //convert arraylist to array
        int[] topK = new int[k];
        for(int i = 0; i < k; i++){
            topK[i] = elements.get(i);
        }
        return topK;
    }
}
