class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int total = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int currNum = num;
                int count = 1;

                while(set.contains(currNum+1)){
                    currNum++;
                    count++;
                }
                total = Math.max(total,count);
            }
        }
        return total;
    }
}
