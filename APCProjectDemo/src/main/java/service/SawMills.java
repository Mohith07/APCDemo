package service;

import java.util.*;

public class SawMills {
    private final Integer DEFAULT_CUTTING = 3;
    private final Map<Integer, Integer> profitMap = new HashMap<>();


    public SawMills() {
        profitMap.put(1, -1);
        profitMap.put(2, 3);
        profitMap.put(3, 1);
    }

    public void getOptimalResult(List<List<Integer>> list) {
        int finalAns = 0;
        for (int i=0; i<list.size(); i++) {
            finalAns+=getMaxProfit(list.get(i));
        }
        System.out.println("max profit " + finalAns);
    }

    public Integer getMaxProfit(List<Integer> list) {
        List<List<Integer>> finalList = getAllPermutations(list);
        List<List<Integer>> ans = new ArrayList<>();
        int maxProfit = Integer.MIN_VALUE;
        for (int i=0; i<finalList.size(); i++) {
            int max = getProfitForCombination(finalList.get(i));
            if (max > maxProfit) {
                ans.clear();
                ans.add(finalList.get(i));
                maxProfit = max;
            } else if (max == maxProfit) {
                    ans.add(finalList.get(i));
            }
        }
        System.out.println(ans);
        return maxProfit;
    }

    public List<List<Integer>> getAllPermutations(List<Integer> a) {
        List<List<Integer>> list = new ArrayList<>();
        generatePerm(a, 0, a.size(), list, new HashSet<>());
        return list;
    }

    private void generatePerm(List<Integer> a, int i, int size, List<List<Integer>> permutations, Set<String> duplicateCheck) {
        if (i == size) {
            String str = getHash(a);
            if (!duplicateCheck.contains(str)) {
                permutations.add(new ArrayList<>(a));
                duplicateCheck.add(str);
            }
            return;
        }
        for (int j=i; j<size; j++) {
            List<Integer> newList = new ArrayList<>(a);
            //swap i and j
            swap(i, j, newList);
            generatePerm(newList, i+1, size, permutations, duplicateCheck);
            swap(j, i, newList);
        }
    }

    private String getHash(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append(".");
        }
        return sb.toString();
    }

    private void swap(int i, int j, List<Integer> newList) {
        int temp = newList.get(i);
        newList.set(i, newList.get(j));
        newList.set(j, temp);
    }

    Integer getProfitForCombination(List<Integer> list) {
        int nextCut = 3;
        int profit = 0;
        for (int temp : list) {
            while (temp != 0) {
                if (nextCut == 0) {
                    nextCut = 3;
                }
                if (temp <= nextCut) {
                    nextCut = nextCut - temp;
                    profit += profitMap.get(temp);
                    temp = 0;
                } else {
                    profit += profitMap.get(nextCut);
                    temp -= nextCut;
                    nextCut = 0;
                }
            }
        }
        return profit;
    }
}
