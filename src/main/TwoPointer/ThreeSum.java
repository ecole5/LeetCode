package TwoPointer;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSumTwoPointer(int[] nums) {


        //First we need to sort O(nlogn)
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }

            //fast forward duplicates
            while (i > 0 && i < nums.length && nums[i - 1] == nums[i]) {
                i++;
            }

            int start = nums[i] + 1;
            int end = nums.length - 1;
            int target = nums[i] * -1;

            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    //Deal with duplicates. Why onl
                    while (start > 0 && start < nums.length && nums[start] == nums[start-1]){
                        start++;
                    }

                } else if (nums[start] + nums[end] < target) {
                    start++; //need a bigger number
                } else {
                    end--; //need a smaller number
                }
            }
        }
        return result;

    }

    public List<List<Integer>> threeSumHashNoSort(int[] nums) {

      HashSet<List<Integer>> results = new HashSet<>();

      //Build set of numbers
      HashMap<Integer,Integer> values = new HashMap<>();
      for (int i : nums){
          values.put(i, values.getOrDefault(i,0)+1);
      }

      for (int i = 0; i < nums.length; i++){
          int firstSelected = nums[i];

          if (values.containsKey(firstSelected)){
              values.put(firstSelected,values.get(firstSelected)-1);
          }

          for (int j = i+1; j < nums.length; j++){
              int secondSelected = nums[j];



              int thirdNeeded = (firstSelected+secondSelected)*-1;


              //try to add results
              if (values.containsKey(thirdNeeded) && values.get(thirdNeeded) > (secondSelected== thirdNeeded ? 1 : 0)){
                  List <Integer> tmp = Arrays.asList(firstSelected,secondSelected,thirdNeeded);
                  Collections.sort(tmp);
                  results.add(tmp);
              }


          }

          if (values.containsKey(firstSelected)){
              values.put(firstSelected,values.get(firstSelected)+1);
          }


      }

        return new ArrayList<>(results);

    }




}


