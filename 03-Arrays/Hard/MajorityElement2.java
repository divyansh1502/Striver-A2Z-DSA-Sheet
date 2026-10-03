import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 2, 1};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement2Way(arr));
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if(cnt1 == 0 && el2 != nums[i]) {
                cnt1++;
                el1 = nums[i];
            } else if(cnt2 == 0 && el1 != nums[i]) {
                cnt2++;
                el2 = nums[i];
            } else if(el1 == nums[i]) {
                cnt1++;
            } else if(el2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(el1 == nums[i]) cnt1++;
            if(el2 == nums[i]) cnt2++;
        }
        int mini = nums.length / 3;
        if(cnt1 > mini) list.add(el1);
        if(cnt2 > mini) list.add(el2);

        return list;
    }
    static List<Integer> majorityElement2Way(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    } 
    List<Integer> list = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if(entry.getValue() > nums.length / 3) {
            list.add(entry.getKey());
        }
    }
    return list;
}
}

