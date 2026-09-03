class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startidx = 0;

        for(int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];
            totalTank += netGas;
            currTank += netGas;

            if(currTank < 0) {
                startidx = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startidx : -1;
    }
}
