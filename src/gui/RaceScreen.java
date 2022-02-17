package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

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


        Button prevButton = new Button(raceBG, SWT.NONE);
        prevButton.setText("Previous");
        prevButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
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