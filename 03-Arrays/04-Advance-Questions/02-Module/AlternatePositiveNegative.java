
import java.util.ArrayList;


public class AlternatePositiveNegative {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(-5);
        list.add(6);
        System.out.println(rearrange(list));
    }
    static ArrayList<Integer> rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) < 0) {
                neg.add(arr.get(i));
            } else {
                pos.add(arr.get(i));
            }
        }
        if(pos.size() > neg.size()) {
            for(int i = 0; i < neg.size(); i++) {
               arr.set(i * 2, pos.get(i)); 
               arr.set(i * 2 + 1, neg.get(i)); 
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr.set(index, pos.get(i));
                index++;
            }
        } else {
            for(int i = 0; i < pos.size(); i++) {
               arr.set(i * 2, pos.get(i)); 
               arr.set(i * 2 + 1, neg.get(i)); 
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr.set(index, neg.get(i));
                index++;
            }
        }
        return arr;
    }
}
