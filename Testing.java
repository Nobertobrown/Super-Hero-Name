import java.util.HashMap;
import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) {
        int index = (int) Math.round(Math.random() * 5);
        System.out.println(index);

        ArrayList<String> TzCities = new ArrayList<String>();
        TzCities.add("Dar");
        TzCities.add("Kilimanjaro");
        TzCities.add("Mwanza");

        ArrayList<String> USACities = new ArrayList<String>();
        USACities.add("New York");
        USACities.add("Alabama");
        USACities.add("Texas");

        HashMap<String, ArrayList<String>> Places = new HashMap<String, ArrayList<String>>();
        Places.put("Tanzania", TzCities);
        Places.put("USA", USACities);

        ArrayList<String> TzPlaces = Places.get("USA");
        for (String City : TzPlaces) {
            System.out.println(City);
        }
    }
}
