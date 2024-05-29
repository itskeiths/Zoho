/*5.Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of
favorite restaurants represented by strings.
You need to help them find out their common interest with the least list index sum. If there is a
choice tie between answers, output all of them with no order requirement. You could assume there
always exists an answer.*/

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {
        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

        List<String> commonRestaurants = findRestaurant(list1, list2);
        for (String restaurant : commonRestaurants) {
            System.out.println(restaurant);
        }
    }

    static List<String> findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int sum = i + j;
                    if (sum < minSum) {
                        minSum = sum;
                        result.clear();
                        result.add(list1[i]);
                    } else if (sum == minSum) {
                        result.add(list1[i]);
                    }
                }
            }
        }

        return result;
    }
}
