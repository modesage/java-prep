package _10_recursion._6_subsets_subsequences;

import java.util.ArrayList;
//amazon question
public class Dice {
    public static void main(String[] args) {
        //all the combinations to form the target number
        dice("", 4);
        System.out.println(diceRet("", 4));
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static ArrayList<String> diceRet(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(p + i, target - i));
        }
        return list;
    }

    //generic face dice eg for 7 face 8 face etc
    static void diceFace(String p, int target, int face) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceFace(p + i, target - i, face);
        }
    }

    static ArrayList<String> diceFaceRet(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            list.addAll(diceFaceRet(p + i, target - i, face));
        }
        return list;
    }

}
