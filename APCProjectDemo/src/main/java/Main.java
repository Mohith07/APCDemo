public class Main {

    public static void main(String[] args) {
        // write your code here
        //create list
        SawMills sawMills = new SawMills();

        //********************INPUT 1********************************
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(1);
        List<List<Integer>> finalList1 = new ArrayList<>();
        finalList1.add(list1);
        sawMills.getOptimalResult(finalList1);
        
        //********************INPUT 2********************************
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
}
