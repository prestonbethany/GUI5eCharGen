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
import org.eclipse.swt.widgets.MessageBox;
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

        if (Engine.workingSheet.characterName != null) {
            nameBox.setText(Engine.workingSheet.characterName);
        }

        if (Engine.workingSheet.strength > 0) {
            selectionOne.select(Main.rollScreenState[0]);
            rollOne.setText(Integer.toString(Engine.getStatByNumber(Main.rollScreenState[0])));
        }

        if (Engine.workingSheet.dexterity > 0) {
            selectionTwo.select(Main.rollScreenState[1]);
            rollTwo.setText(Integer.toString(Engine.getStatByNumber(Main.rollScreenState[1])));
        }

        if (Engine.workingSheet.constitution > 0) {
            selectionThree.select(Main.rollScreenState[2]);
            rollThree.setText(Integer.toString(Engine.getStatByNumber(Main.rollScreenState[2])));
        }
        
        if (Engine.workingSheet.intelligence > 0) {
            selectionFour.select(Main.rollScreenState[3]);
            rollFour.setText(Integer.toString(Engine.getStatByNumber(Main.rollScreenState[3])));
        }
        
        if (Engine.workingSheet.wisdom > 0) {
            selectionFive.select(Main.rollScreenState[4]);
            rollFive.setText(Integer.toString(Engine.getStatByNumber(Main.rollScreenState[4])));
        }
        
        if (Engine.workingSheet.charisma > 0) {
            selectionSix.select(Main.rollScreenState[5]);
            rollSix.setText(Integer.toString(Engine.getStatByNumber(Main.rollScreenState[5])));
        }

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
                if (nameBox.getText().equals("")) {
                    MessageBox error = new MessageBox(gui.Main.rollScreen, SWT.ICON_ERROR | SWT.OK);
                    error.setText("Name Missing");
                    error.setMessage("You must have a name first.");
                    error.open();
                    return;
                }
                
                if (rollOne.getText().equals("")) {
                    MessageBox error = new MessageBox(gui.Main.rollScreen, SWT.ICON_ERROR | SWT.OK);
                    error.setText("Roll Data Missing");
                    error.setMessage("You must roll first.");
                    error.open();
                    return;
                }

                if (selectionOne.getSelectionIndex() == -1 
                        || selectionTwo.getSelectionIndex() == -1 
                        || selectionThree.getSelectionIndex() == -1 
                        || selectionFour.getSelectionIndex() == -1 
                        || selectionFive.getSelectionIndex() == -1 
                        || selectionSix.getSelectionIndex() == -1) {
                    MessageBox error = new MessageBox(gui.Main.rollScreen, SWT.ICON_ERROR | SWT.OK);
                    error.setText("Selection Missing");
                    error.setMessage("You must assign all stats.");
                    error.open();
                    return;
                }
                Main.rollScreenState[0] = selectionOne.getSelectionIndex();
                Main.rollScreenState[1] = selectionTwo.getSelectionIndex();
                Main.rollScreenState[2] = selectionThree.getSelectionIndex();
                Main.rollScreenState[3] = selectionFour.getSelectionIndex();
                Main.rollScreenState[4] = selectionFive.getSelectionIndex();
                Main.rollScreenState[5] = selectionSix.getSelectionIndex();

                int[] hashTable = new int[6];
                if (Engine.uniqueHashEntry(hashTable, Main.rollScreenState[0], 1) 
                        && Engine.uniqueHashEntry(hashTable, Main.rollScreenState[1], 2) 
                        && Engine.uniqueHashEntry(hashTable, Main.rollScreenState[2], 3)
                        && Engine.uniqueHashEntry(hashTable, Main.rollScreenState[3], 4)
                        && Engine.uniqueHashEntry(hashTable, Main.rollScreenState[4], 5)
                        && Engine.uniqueHashEntry(hashTable, Main.rollScreenState[5], 6)) {
                    
                    Engine.workingSheet.characterName = nameBox.getText();

                    Engine.marryStatToSheet(Integer.parseInt(rollOne.getText()), hashTable[0]);
                    Engine.marryStatToSheet(Integer.parseInt(rollTwo.getText()), hashTable[1]);
                    Engine.marryStatToSheet(Integer.parseInt(rollThree.getText()), hashTable[2]);
                    Engine.marryStatToSheet(Integer.parseInt(rollFour.getText()), hashTable[3]);
                    Engine.marryStatToSheet(Integer.parseInt(rollFive.getText()), hashTable[4]);
                    Engine.marryStatToSheet(Integer.parseInt(rollSix.getText()), hashTable[5]);

                    Main.raceScreen = new RaceScreen(display);
                    Main.raceScreen.setLocation(Main.rollScreen.getLocation());
                    Main.rollScreen.dispose();
                    Main.raceScreen.open();
                } else {
                    MessageBox error = new MessageBox(gui.Main.rollScreen, SWT.ICON_ERROR | SWT.OK);
                    error.setText("Selection Collision");
                    error.setMessage("All selections must be unique.");
                    error.open();
                }
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