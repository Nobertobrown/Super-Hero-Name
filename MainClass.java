import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Random {
    static int getRandomNumber(int limit) {
        int index = (int) Math.floor(Math.random() * limit);
        return index;
    }
}

abstract class HeroName extends Random {
    public ArrayList<String> prefixes = new ArrayList<String>();
    public ArrayList<String> suffixes = new ArrayList<String>();
    public String fullName;

    public abstract String setName(HashMap<String, String> candidates);

    public void fillAffixes() {
        prefixes.add("Super");
        prefixes.add("Captain");
        prefixes.add("Doctor");
        prefixes.add("Wonder");
        prefixes.add("Mega");
        prefixes.add("Star");
        prefixes.add("Moon");

        suffixes.add("man");
        suffixes.add("boy");
        suffixes.add("kid");
        suffixes.add("lad");
        suffixes.add("woman");
        suffixes.add("girl");
        suffixes.add("master");
    }
}

class Hero extends HeroName {
    public String setName(HashMap<String, String> candidates) {
        int method = Random.getRandomNumber(7);
        int prefixIndex = Random.getRandomNumber(prefixes.size());
        int suffixIndex = Random.getRandomNumber(suffixes.size());

        HeroAffix affixes = new HeroAffix();
        affixes.setPrefix(prefixes.get(prefixIndex));
        affixes.setSuffix(suffixes.get(suffixIndex));

        String prefix = affixes.getPrefix();
        String suffix = affixes.getSuffix();
        String heroName;

        switch (method) {
            case 0:
                heroName = prefix + suffix;
                break;
            case 1:
                heroName = suffix + prefix;
                break;
            case 2:
                heroName = candidates.get("Animal");
                break;
            case 3:
                heroName = candidates.get("Animal") + prefix;
                break;
            case 4:
                heroName = candidates.get("Animal") + suffix;
                break;
            case 5:
                heroName = candidates.get("Color") + candidates.get("Animal");
                break;
            case 6:
                heroName = "The " + candidates.get("Color") + candidates.get("Animal");
                break;
            default:
                return "Sorry, a problem occured while generating your name, please try again!";
        }
        return heroName;
    }

}

class MainClass extends Hero {
    static public void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        HashMap<String, String> options = new HashMap<String, String>();

        System.out.println("Welcome to a new adventure,\nFollow the steps below to create your superhero name...\n");
        System.out.println("What is your gender?(M or F)");
        String Gender = userInput.nextLine();

        System.out.println("What is your favorite animal?");
        String Animal = userInput.nextLine();

        System.out.println("What is your favorite color?");
        String Color = userInput.nextLine();
        userInput.close();

        options.put("Gender", Gender);
        options.put("Animal", Animal);
        options.put("Color", Color);

        Hero myHero = new Hero();
        myHero.fillAffixes();
        myHero.fullName = myHero.setName(options);

        System.out.println("Your superhero name is " + myHero.fullName);
    }
}