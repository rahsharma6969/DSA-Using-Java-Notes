import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    int value;
    int weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < val.length; i++) {
            items.add(new Item(val[i], wt[i]));
        }

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return Double.compare(b.ratio, a.ratio);
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }

            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                double fraction = (double) capacity / item.weight;
                totalValue += item.value * fraction;
                break;
            }
        }

        return Math.round(totalValue * 1000000.0) / 1000000.0;
    }

    public static void main(String[] args) {
        int[] val1 = {60, 100, 120};
        int[] wt1 = {10, 20, 30};
        System.out.println(fractionalKnapsack(val1, wt1, 50));

        int[] val2 = {60, 100};
        int[] wt2 = {10, 20};
        System.out.println(fractionalKnapsack(val2, wt2, 50));
    }
}
