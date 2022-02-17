package engine;

public class Engine {

    public static CharacterSheet workingSheet = new CharacterSheet();

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
