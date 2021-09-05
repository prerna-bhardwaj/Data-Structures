import java.util.*;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class UniquePermutation {
    int N = 0;
	int count = 0;
    int fac = 1;
    List<List<Integer>>res;


    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        N = nums.length;
        HashMap<Integer, Integer>hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i]))
                hm.put(nums[i],0);
            hm.put(nums[i], hm.get(nums[i]) + 1);
        }
        System.out.println(hm);
        findPermutations(new LinkedList<Integer>(), hm);
        return res;
    }
    
    public void findPermutations(LinkedList<Integer>arr, HashMap<Integer, Integer>hm) {
        if(arr.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            res.add(new ArrayList<Integer>(arr));
            System.out.println("Adding : " + arr + " - " + res);
            return;
        }
        for(Map.Entry<Integer, Integer>entry : hm.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count == 0)
                continue;
            arr.addLast(num);
            System.out.println(num + " - " + arr);
            hm.put(num, count - 1);
            findPermutations(arr, hm);
            arr.removeLast();
            System.out.println(num + " - " + arr);
            hm.put(num, count);
        }
    }


	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2};
		UniquePermutation obj = new UniquePermutation();
		obj.permute(nums);
		System.out.println(obj.res);
	}
}