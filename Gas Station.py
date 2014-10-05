class Solution:
    # @param gas, a list of integers
    # @param cost, a list of integers
    # @return an integer
    def canCompleteCircuit(self, gas, cost):
        remain=[]
        flag=False
        for i in range(len(gas)):
            remain.append(gas[i]-cost[i])
        start=0
        s=0
        gas_needed=0
        for i in range(len(remain)):
            s+=remain[i]
            if s<0:
                gas_needed-=s
                start=i+1
                s=0
        return start if s>=gas_needed else -1
