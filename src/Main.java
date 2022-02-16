import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGBA;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Main {

    private static void quickSort(int[] arr) {
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

    private static int statRoller() {
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

    private static void createRollerWidgetGData(Control rollWidget) {
        GridData gData = new GridData(SWT.LEFT, SWT.TOP, true, false);
        gData.horizontalAlignment = GridData.FILL;
        rollWidget.setLayoutData(gData);
    }

    private static void populateDropDown(Combo combo) {
        String[] arr = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        combo.setItems(arr);
        combo.setBackground(new Color(new RGBA(255, 255, 255, 255)));
    }
    public static void main(String[] args) {
        Display display = new Display();
        Shell rollScreen = new Shell(display);
        rollScreen.setSize(500, 700);
        rollScreen.setLayout(new GridLayout(1, true));
        Composite rollBG = new Composite(rollScreen, SWT.NONE);
        Composite raceBG = new Composite(rollScreen, SWT.NONE);
        raceBG.setVisible(false);
        GridData gData = new GridData(GridData.FILL_BOTH);
        rollBG.setLayoutData(gData);
        rollBG.setLayout(new GridLayout(2, true));
        Text nameBox = new Text(rollBG, SWT.BORDER | SWT.CENTER | SWT.SEARCH | SWT.SINGLE);
        gData = new GridData(SWT.LEFT, SWT.TOP, true, false);
        gData.horizontalAlignment = GridData.FILL;
        gData.horizontalSpan = 2;
        nameBox.setLayoutData(gData);
        nameBox.setMessage("Character Name");
        nameBox.setToolTipText("Character Name");
        Composite rollerPanel = new Composite(rollBG, SWT.NONE);
        gData = new GridData(SWT.LEFT, SWT.TOP, true, false);
        gData.horizontalAlignment = GridData.FILL;
        gData.horizontalSpan = 2;
        rollerPanel.setLayoutData(gData);
        rollerPanel.setLayout(new GridLayout(2, true));
        
        Label rollOne = new Label(rollerPanel, SWT.BORDER | SWT.CENTER);
        createRollerWidgetGData(rollOne);
        Combo selectionOne = new Combo(rollerPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
        createRollerWidgetGData(selectionOne);
        populateDropDown(selectionOne);
        
        Label rollTwo = new Label(rollerPanel, SWT.BORDER | SWT.CENTER);
        createRollerWidgetGData(rollTwo);
        Combo selectionTwo = new Combo(rollerPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
        createRollerWidgetGData(selectionTwo);
        populateDropDown(selectionTwo);

        Label rollThree = new Label(rollerPanel, SWT.BORDER | SWT.CENTER);
        createRollerWidgetGData(rollThree);
        Combo selectionThree = new Combo(rollerPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
        createRollerWidgetGData(selectionThree);
        populateDropDown(selectionThree);

        Label rollFour = new Label(rollerPanel, SWT.BORDER | SWT.CENTER);
        createRollerWidgetGData(rollFour);
        Combo selectionFour = new Combo(rollerPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
        createRollerWidgetGData(selectionFour);
        populateDropDown(selectionFour);

        Label rollFive = new Label(rollerPanel, SWT.BORDER | SWT.CENTER);
        createRollerWidgetGData(rollFive);
        Combo selectionFive = new Combo(rollerPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
        createRollerWidgetGData(selectionFive);
        populateDropDown(selectionFive);

        Label rollSix = new Label(rollerPanel, SWT.BORDER | SWT.CENTER);
        createRollerWidgetGData(rollSix);
        Combo selectionSix = new Combo(rollerPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
        createRollerWidgetGData(selectionSix);
        populateDropDown(selectionSix);

        Button rollButton = new Button(rollBG, SWT.NONE);
        rollButton.setText("Roll");
        rollButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                int[] stats = new int[6];
                for (int i = 0; i < stats.length; ++i) {
                    stats[i] = statRoller();
                } 
                quickSort(stats);
                rollOne.setText(Integer.toString(stats[5]));
                rollTwo.setText(Integer.toString(stats[4]));
                rollThree.setText(Integer.toString(stats[3]));
                rollFour.setText(Integer.toString(stats[2]));
                rollFive.setText(Integer.toString(stats[1]));
                rollSix.setText(Integer.toString(stats[0]));
            }
        });

        Button nextButton = new Button(rollBG, SWT.NONE);
        nextButton.setText("Next");
        nextButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                rollBG.setVisible(false);
                raceBG.setVisible(true);
            }
        });

        Button prevButton = new Button(raceBG, SWT.NONE);
        prevButton.setText("Previous");
        prevButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                raceBG.setVisible(false);
                rollBG.setVisible(true);
            }
        });

        rollScreen.open();
        rollButton.setFocus();

        while (!rollScreen.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        // disposes all associated windows and their components
        display.dispose();
    }
}