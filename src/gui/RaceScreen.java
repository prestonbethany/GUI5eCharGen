package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import engine.Engine;

public class RaceScreen extends Shell {
    public RaceScreen(Display display) {
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
        Composite raceBG = new Composite(this, SWT.NONE);
        GridData gData = new GridData(GridData.FILL_BOTH);
        raceBG.setLayoutData(gData);
        raceBG.setLayout(new GridLayout(2, true));
        
        gData = new GridData(SWT.LEFT, SWT.TOP, true, false);
        gData.horizontalAlignment = GridData.FILL;
        gData.horizontalSpan = 2;
        Label charName = new Label(raceBG, SWT.CENTER);
        charName.setLayoutData(gData);
        charName.setText(Engine.workingSheet.characterName);
        charName.setAlignment(SWT.CENTER);

        Composite dropDownPanel = new Composite(raceBG, SWT.NONE);
        gData = new GridData(SWT.LEFT, SWT.TOP, false, false);
        gData.horizontalAlignment = GridData.CENTER;
        gData.horizontalSpan = 1;
        dropDownPanel.setLayoutData(gData);
        dropDownPanel.setLayout(new GridLayout(1, true));
        Combo raceBox = new Combo(dropDownPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
        raceBox.setItems(Engine.raceNames);
        raceBox.setBackground(Main.comboColor);    
        if (Engine.workingSheet.race != null) {
            for (int i = 0; i < Engine.raceNames.length; i++) {
                if (Engine.raceNames[i].equals(Engine.workingSheet.race.name)) {
                    raceBox.select(i);
                    break;
                }
            }
        }

        Combo classBox = new Combo (dropDownPanel, SWT.DROP_DOWN | SWT.READ_ONLY);
        classBox.setItems(Engine.classNames);
        classBox.setBackground(Main.comboColor);
        if (Engine.workingSheet.characterClass != null) {
            for (int i = 0; i < Engine.classNames.length; i++) {
                if (Engine.classNames[i].equals(Engine.workingSheet.characterClass.name)) {
                    classBox.select(i);
                    break;
                }
            }
        }

        Button prevButton = new Button(raceBG, SWT.NONE);
        prevButton.setText("Previous");
        prevButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                Engine.workingSheet.race = Engine.listOfRaces.get(raceBox.getSelectionIndex());
                Engine.workingSheet.characterClass = Engine.listOfClasses.get(classBox.getSelectionIndex());
                Main.rollScreen = new RollScreen(display);
                Main.rollScreen.setLocation(Main.raceScreen.getLocation());
                Main.raceScreen.dispose();
                Main.rollScreen.open();
            }
        });
    }

    @Override
    protected void checkSubclass() {
        //Allow subclasses
    }
}