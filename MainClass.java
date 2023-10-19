import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Random {
    static int getRandomNumber(int limit) {
        int index = (int) Math.floor(Math.random() * limit);
        return index;
    }
}

/****** ABSTRACTION ******/
abstract class HeroName extends Random {
    public ArrayList<String> prefixes = new ArrayList<String>();
    public ArrayList<String> suffixes = new ArrayList<String>();
    public ArrayList<String> femaleSuffixes = new ArrayList<String>();
    public ArrayList<String> maleSuffixes = new ArrayList<String>();
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

        maleSuffixes.add("man");
        maleSuffixes.add("boy");
        maleSuffixes.add("lad");
        femaleSuffixes.add("woman");
        femaleSuffixes.add("girl");
        suffixes.add("master");
        suffixes.add("kid");
    }
}

class Hero extends HeroName {
    public String setName(HashMap<String, String> candidates) {
        int method = Random.getRandomNumber(7);
        ArrayList<String> finalSuffixes = new ArrayList<String>();
        int prefixIndex = Random.getRandomNumber(prefixes.size());
        String gender = candidates.get("Gender");
        String animal = candidates.get("Animal");
        String color = candidates.get("Color");

        if (gender.equals("m")) {
            finalSuffixes.addAll(maleSuffixes);
            finalSuffixes.addAll(suffixes);
        } else if (gender.equals("f")) {
            finalSuffixes.addAll(femaleSuffixes);
            finalSuffixes.addAll(suffixes);
        } else {
            throw new Error("Enter a valid gender!");
        }

        int suffixIndex = Random.getRandomNumber(finalSuffixes.size());

        HeroAffix affixes = new HeroAffix();
        affixes.setPrefix(prefixes.get(prefixIndex));
        affixes.setSuffix(finalSuffixes.get(suffixIndex));

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
                heroName = animal;
                break;
            case 3:
                heroName = animal + prefix;
                break;
            case 4:
                heroName = animal + suffix;
                break;
            case 5:
                heroName = color + animal;
                break;
            case 6:
                heroName = "The " + color + animal;
                break;
            default:
                return "Sorry, a problem occured while generating your name, please try again!";
        }
        return heroName;
    }

}

/****** INHERITANCE ******/
class MainClass extends Hero {
    static public void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        HashMap<String, String> options = new HashMap<String, String>();

        System.out.println("Welcome to a new adventure,\nFollow the steps below to create your superhero name...\n");
        System.out.println("What is your gender?(M or F)");
        String Gender = userInput.nextLine();

        System.out.println("\nWhat is your favorite animal?");
        String Animal = userInput.nextLine();

        System.out.println("\nWhat is your favorite color?");
        String Color = userInput.nextLine();
        userInput.close();

        options.put("Gender", Gender.toLowerCase());
        options.put("Animal", Animal);
        options.put("Color", Color);

        Hero myHero = new Hero();
        myHero.fillAffixes();
        myHero.fullName = myHero.setName(options);

        System.out.println("\nYour superhero name is " + myHero.fullName);
    }
}