package gui;
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

import engine.Engine;

public class RollScreen extends Shell {

    public Button rollButton;

    public RollScreen(Display display) {
        super(display);
        this.setText(gui.Main.title);
        this.setSize(500, 700);
        this.setLayout(new GridLayout(1, true));
        this.addListener(SWT.Close, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                gui.Main.running = false;
            }
        });
        Composite rollBG = new Composite(this, SWT.NONE);
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

        rollButton = new Button(rollBG, SWT.NONE);
        rollButton.setText("Roll");
        rollButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                int[] stats = new int[6];
                for (int i = 0; i < stats.length; ++i) {
                    stats[i] = Engine.statRoller();
                } 
                Engine.quickSort(stats);
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
                Main.raceScreen = new RaceScreen(display);
                Main.raceScreen.setLocation(Main.rollScreen.getLocation());
                Main.rollScreen.dispose();
                Main.raceScreen.open();
            }
        });
    }

    @Override
    protected void checkSubclass() {
        //Allow subclasses
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
}