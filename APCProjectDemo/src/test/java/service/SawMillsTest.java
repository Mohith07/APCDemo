package service;

import java.util.ArrayList;
import java.util.List;

//todo use Junit5 library
class SawMillsTest {

    void getProfitForCombination() {
        SawMills sawMills = new SawMills();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        int ans = sawMills.getProfitForCombination(list);
        if (ans != 1) {
            System.out.println("NOT CORRECT");
        } else {
            System.out.println("CORRECT");
        }

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        int ans2 = sawMills.getProfitForCombination(list2);
        if (ans2 != 5) {
            System.out.println("NOT CORRECT - answer is " + ans2);
        } else {
            System.out.println("CORRECT");
        }

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        list3.add(2);
        int ans3 = sawMills.getProfitForCombination(list3);
        if (ans3 != 4) {
            System.out.println("NOT CORRECT - answer is " + ans3);
        } else {
            System.out.println("CORRECT");
        }
    }

    public void generateAllPermutationTests() {
        SawMills sawMills = new SawMills();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        sawMills.getAllPermutations(list);

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        list3.add(2);
        sawMills.getAllPermutations(list3);
    }

    public void getOptimalResultTests() {
        SawMills sawMills = new SawMills();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(list);
        finalList.add(list2);
        finalList.add(list3);
        sawMills.getOptimalResult(finalList);
    }

    public static void main(String[] args) {
        SawMillsTest sawMillsTest = new SawMillsTest();
//        sawMillsTest.getProfitForCombination();
//        sawMillsTest.generateAllPermutationTests();
        sawMillsTest.getOptimalResultTests();
    }
}