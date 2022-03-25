package engine;

import java.util.ArrayList;

public class Engine {

    public static CharacterSheet workingSheet = new CharacterSheet();

    public static ArrayList<Race> listOfRaces = new ArrayList<Race>();
    public static String[] raceNames;

    public static ArrayList<CharacterClass> listOfClasses = new ArrayList<CharacterClass>();
    public static String[] classNames;

    static {
        //Race(String bookTag, String raceName, int strengthBonus, int dexterityBonus, int constitutionBonus,
        //    int intelligenceBonus, int wisdomBonus, int charismaBonus, String raceTraits);
        listOfRaces.add(new Race("EEPC", "Aarakocra", 0, 2, 0, 0, 1, 0, "Flight, Talons"));
        listOfRaces.add(new Race("VGtM", "Aasimar", 0, 0, 0, 0, 0, 2, "Darkvision, Celestial Resistance, Healing Hands, Light Bearer"));
        listOfRaces.add(new Race("VGtM", "Bugbear", 2, 1, 0, 0, 0, 0, "Darkvision, Long-Limbed, Powerful Build, Sneaky, Surprise Attack"));
        listOfRaces.add(new Race("GGtR", "Centaur", 2, 0, 0, 0, 1, 0, "Fey, Charge, Hooves, Equine Build, Survivor"));
        listOfRaces.add(new Race("ERftLW", "Changeling", 0, 0, 0, 0, 0, 2, "Shapechanger, Changeling Instincts"));
        listOfRaces.add(new Race("PHB", "Dragonborn", 2, 0, 0, 0, 0, 1, "Draconic Ancestry, Breath Weapon, Damage Resistance"));
        listOfRaces.add(new Race("PHB", "Dwarf", 0, 0, 2, 0, 0, 0, "Darkvision, Dwarven Resilience, Dwarven Combat Training, Stonecunning"));
        listOfRaces.add(new Race("PHB", "Elf", 0, 2, 0, 0, 0, 0, "Darkvision, Keen Senses, Fey Ancestry, Trance"));
        listOfRaces.add(new Race("SCAG", "Feral Tiefling", 0, 2 ,0, 1, 0, 0, "Darkvision, Hellish Resistance, Infernal Legacy"));
        listOfRaces.add(new Race("VGtM", "Firbolg", 1, 0, 0, 0, 2, 0, "Firbolg Magic, Hidden Step, Powerful Build, Speech of Beast and Leaf"));
        listOfRaces.add(new Race("EEPC", "Genasi (Air)", 0, 1, 2, 0, 0, 0, "Unending Breath, Mingle with the Wind"));
        listOfRaces.add(new Race("EEPC", "Genasi (Earth)", 1, 0, 2, 0, 0, 0, "Earth Walk, Merge with Stone"));
        listOfRaces.add(new Race("EEPC", "Genasi (Fire)", 0, 0, 2, 1, 0, 0, "Darkvision(Plane of Fire), Fire Resistance, Reach to the Blaze"));
        listOfRaces.add(new Race("EEPC", "Genasi (Water)", 0, 0, 2, 0, 1, 0, "Acid Resistance, Amphibious, Swim, Call to the Wave"));
        listOfRaces.add(new Race("MToF", "Gith", 0, 0, 0, 1, 0, 0, "Githyanki or Githzerai Traits"));
        listOfRaces.add(new Race("PHB", "Gnome", 0, 0, 0, 2, 0, 0, "Darkvision, Gnome Cunning"));
        listOfRaces.add(new Race("VGtM", "Goblin", 0, 2, 1, 0, 0, 0, "Darkvision, Fury of the Small, Nimble Escape"));
        listOfRaces.add(new Race("EEPC", "Goliath", 2, 0, 1, 0, 0, 0, "Natural Athlete, Stone's Endurance, Powerful Build, Mountain Born"));
        listOfRaces.add(new Race("OGA", "Grung", 0, 2, 1, 0, 0, 0, "Arboreal Alertness, Amphibious, Poison Immunity, Poisonous Skin, Alertness, Standing Leap, Water Dependency"));
        listOfRaces.add(new Race("PHB", "Half-Elf", 0, 0, 0, 0, 0, 2, "Darkvision, Fey Ancestry, Skill Versatility"));
        listOfRaces.add(new Race("PHB", "Halfling", 0, 2, 0, 0 , 0, 0, "Lucky, Brave, Halfling Nimbleness"));
        listOfRaces.add(new Race("PHB", "Half-Orc", 2, 0, 1, 0, 0, 0, "Darkvision, Menacing, Relentless Endurance, Savage Attacks"));
        listOfRaces.add(new Race("VGtM", "Hobgoblin", 0, 0, 2, 1, 0, 0, "Darkvision, Martial Training, Saving Face"));
        listOfRaces.add(new Race("PHB", "Human", 1, 1, 1, 1, 1, 1, "Extra Language"));
        listOfRaces.add(new Race("ERftLW", "Kalashtar", 0, 0, 0, 0, 2, 1, "Dual Mind, Mental Discipline, Mind Link, Severed from Dreams"));
        listOfRaces.add(new Race("VGtM", "Kenku", 0, 2, 0, 0, 0, 0, "Expert Forging, Kenku Training, Mimicry"));
        listOfRaces.add(new Race("VGtM", "Kobold", 0, 2, 0, 0, 0, 0, "Darkvision, Pack Tactics, Sunlight Sensitivity, Grovel, Cower, and Beg"));
        listOfRaces.add(new Race("MOoT", "Leonin", 1, 0, 2, 0, 0, 0, "Darkvision, Claws, Hunter's Instincts, Daunting Roar"));
        listOfRaces.add(new Race("VGtM", "Lizardfolk", 0, 0, 2, 0, 1, 0, "Bite, Cunning Artisan, Hold Breath, Hunter's Lore, Natural Armor, Hungry Jaws"));
        listOfRaces.add(new Race("LR", "Locathah", 2, 1, 0, 0, 0, 0, "Natural Armor, Observant & Athletic, Leviathan Will, Limited Amphibiousness"));
        listOfRaces.add(new Race("GGtR", "Loxodon", 0, 0, 2, 0, 1, 0, "Powerful Build, Loxodon Serenity, Natural Armor, Trunk, Keen Smell"));
        listOfRaces.add(new Race("GGtR", "Minotaur", 2, 0, 1, 0, 0, 0, "Horns, Goring Rush, Hammering Horns, Imposing Presence"));
        listOfRaces.add(new Race("VGtM", "Orc", 2, 0, 1, 0, 0, 0, "Darkvision, Aggressive, Primal Intuition, Powerful Build"));
        listOfRaces.add(new Race("ERftLW", "Orc Of Eberron", 2, 0, 1, 0, 0, 0, "Darkvision, Aggressive, Powerful Build, Primal Intuition"));
        listOfRaces.add(new Race("EGtW", "Orc Of Exandria", 2, 0, 1, 0, 0, 0, "Darkvision, Aggressive, Powerful Build, Primal Intuition"));
        listOfRaces.add(new Race("MOoT", "Satyr", 0, 1, 0, 0, 0, 2, "Fey, Ram, Magic Resistance, Mirthful Leaps, Reveler"));
        listOfRaces.add(new Race("ERftLW", "Shifter", 0, 0, 0, 0, 0, 0, "Darkvision, Shifting"));
        listOfRaces.add(new Race("GGtR", "Simic Hybrid", 0, 0, 2, 0, 0, 0, "Darkvision, Animal Enhancement"));
        listOfRaces.add(new Race("VGtM", "Tabaxi", 0, 2, 0, 0, 0, 1, "Darkvision, Feline Agility, Cat's Claws, Cat's Talent"));
        listOfRaces.add(new Race("PHB", "Tiefling", 0, 0, 0, 1, 0, 2, "Darkvision, Hellish Resistance, Infernal Legacy"));
        listOfRaces.add(new Race("VGtM", "Triton", 1, 0, 1, 0, 0, 1,"Amphibious, Control Air and Water, Emissary of the Sea, Guardian of the Depths"));
        listOfRaces.add(new Race("TTP", "Tortle", 2, 0, 0, 0, 1, 0, "Claws, Hold Breath, Natural Armor, Shell Defense, Survival Instinct"));
        listOfRaces.add(new Race("GGtR", "Vedalken", 0, 0, 0, 2, 1, 0, "Vedalken Dispassion, Tireless Precision, Partially Amphibious"));
        listOfRaces.add(new Race("AI", "Verdan", 0, 0, 1, 0, 0, 2, "Black Blood Healing, Limited Telepathy, Persuasive, Telepathic Insight"));
        listOfRaces.add(new Race("ERftLW", "Warforged", 0, 0, 2, 0, 0, 0, "Constructed Resilience, Sentry's Rest, Integrated Protection, Specialized Design"));
        listOfRaces.add(new Race("VGtM", "Yuan-Ti Pureblood", 0, 0, 0, 1, 0, 2, "Dakvision, Innate Spellcasting, Magic Resistance, Poison Immunity"));

        raceNames = new String[listOfRaces.size()];
        for (int i = 0; i < raceNames.length; i++) {
            raceNames[i] = listOfRaces.get(i).name;
        }

        listOfClasses.add(new CharacterClass("Artificer"));
        listOfClasses.add(new CharacterClass("Barbarian"));
        listOfClasses.add(new CharacterClass("Bard"));
        listOfClasses.add(new CharacterClass("Blood Hunter"));
        listOfClasses.add(new CharacterClass("Cleric"));
        listOfClasses.add(new CharacterClass("Druid"));
        listOfClasses.add(new CharacterClass("Fighter"));
        listOfClasses.add(new CharacterClass("Monk"));
        listOfClasses.add(new CharacterClass("Paladin"));
        listOfClasses.add(new CharacterClass("Ranger"));
        listOfClasses.add(new CharacterClass("Rogue"));
        listOfClasses.add(new CharacterClass("Sorcerer"));
        listOfClasses.add(new CharacterClass("Warlock"));
        listOfClasses.add(new CharacterClass("Wizard"));

        classNames = new String[listOfClasses.size()];
        for (int i = 0; i < classNames.length; i++) {
            classNames[i] = listOfClasses.get(i).name;
        }
    }

    public static void marryStatToSheet(int stat, int selection) {
        switch (selection) {
            case 1:
                workingSheet.strength = stat;
                break;
            case 2:
                workingSheet.dexterity = stat;
                break;
            case 3:
                workingSheet.constitution = stat;
                break;
            case 4:
                workingSheet.intelligence = stat;
                break;
            case 5:
                workingSheet.wisdom = stat;
                break;
            case 6:
                workingSheet.charisma = stat;
                break;
        }
    }

    public static int getStatByNumber(int selection) {
        switch (selection) {
            case 0:
                return workingSheet.strength;
            case 1:
                return workingSheet.dexterity;
            case 2:
                return workingSheet.constitution;
            case 3:
                return workingSheet.intelligence;
            case 4:
                return workingSheet.wisdom;
            case 5:
                return workingSheet.charisma;
            default: 
                return -1;
        }
    }

    public static boolean uniqueHashEntry(int[] ht, int i, int value) {
        int hash = i % 6;
        if (ht[hash] != 0) {
            return false;
        } else {
            ht[hash] = value;
            return true;
        }
    }

    public static void quickSort(int[] arr) {
        final int MAX_LEVELS = 300;
        int piv;
        int[] beg = new int[MAX_LEVELS];
        int[] end = new int[MAX_LEVELS];
        int i = 0;
        int left;
        int right;
        int swap;
        beg[0] = 0;
        end[0] = arr.length;
        while (i >= 0)
        {
            left = beg[i];
            right = end[i] - 1;
            if (left < right)
            {
                piv = arr[left];
                while (left < right)
                {
                    while (arr[right] >= piv && left < right)
                    {
                        right--;
                    }
                    if (left < right)
                    {
                        arr[left++] = arr[right];
                    }
                    while (arr[left] <= piv && left < right)
                    {
                        left++;
                    }
                    if (left < right)
                    {
                        arr[right--] = arr[left];
                    }
                }
                arr[left] = piv;
                beg[i + 1] = left + 1;
                end[i + 1] = end[i];
                end[i++] = left;
                if (end[i] - beg[i] > end[i - 1] - beg[i - 1])
                {
                    swap = beg[i];
                    beg[i] = beg[i - 1];
                    beg[i - 1] = swap;
                    swap = end[i];
                    end[i] = end[i - 1];
                    end[i - 1] = swap;
                }
            }
            else
            {
                i--;
            }
        }
    }

    public static int statRoller() {
        int[] myArray = new int[4];
        int sum = 0;
        for(int i = 0; i < 4; ++i) {
            myArray[i] = (int) (Math.random() * 6) + 1;
        }
        quickSort(myArray);
        for(int i = 3; i > 0; --i) {
            sum += myArray[i];
        }
        return sum;
    }
}
