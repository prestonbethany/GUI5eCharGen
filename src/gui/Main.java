package gui;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGBA;
import org.eclipse.swt.widgets.Display;

public class Main {
    /*default*/ static boolean running = true;
    /*default*/ static RollScreen rollScreen;
    /*default*/ static int[] rollScreenState = new int[6];
    /*default*/ static RaceScreen raceScreen;
    /*default*/ static String title = "Cain's Character Generator";
    /*default*/ static Color comboColor = new Color(new RGBA(255, 255, 255, 255));
    public static void main(String[] args) {
        Display display = new Display();
        rollScreen = new RollScreen(display);
        rollScreen.open();
        rollScreen.rollButton.setFocus();

        while (running) {
            if (running && !display.readAndDispatch()) {
                display.sleep();
            }
        }
        // disposes all associated windows and their components
        display.dispose();
    }
}