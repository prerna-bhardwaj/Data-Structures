import java.util.*;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class Permutation {

	int count = 0;
    int fac = 1;
    List<List<Integer>>res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        int i = 1;
        while(i <= nums.length) 
            fac *= (i++);
        System.out.println(nums.length + " " + fac);
        findPermutations(nums, 0, nums.length-1);
        return res;
    }
    
    public void findPermutations(int[] nums, int left, int right) {
        if(count >= fac)    return;
        System.out.println(Arrays.toString(nums));
        if(left == right) {
            List<Integer>temp = IntStream.of(nums).boxed().collect(Collectors.toList());
            res.add(temp);
            count++;
            return;
        }
        for(int i = left; i <= right; i++) {
            swap(nums, i, left);
            // Pass left+1 and not i+1
            findPermutations(nums, left+1, right);
            swap(nums, i, left);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		Permutation obj = new Permutation();
		obj.permute(nums);
		System.out.println(obj.res);
	}
}