package de.kronthto.keypresser;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

public class Program {
    private static Robot robot;
    private static final ArrayList<KeyLoop> loops = new ArrayList<>();

    public static void main(String args[]) {
        int argc = args.length;
        if (argc < 1) {
            System.out.println("No parameters given");
            usage();
            System.exit(1);
        }
        if ((argc % 2) != 0) {
            System.out.println("Illegal parameter count");
            usage();
            System.exit(2);
        }
        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.out.println("Failed to create Robot: " + e.getMessage());
            System.exit(3);
        }
        for (int i = 0; i < argc; i = (i + 2)) {
            char key = 'c';
            if (args[i].length() == 1) {
                key = args[i].charAt(0);
            } else {
                System.out.println("Parameter " + i + " not valid (Char)");
                System.exit(4);
            }
            int interv = -1;
            try {
                interv = Integer.parseInt(args[i + 1]);
            } catch (NumberFormatException e) {
                System.out.println("Parameter " + (i + 1) + " not valid (Integer)");
                System.exit(4);
            }
            if (interv < 1) {
                System.out.println("Parameter " + (i + 1) + " not valid (>= 1)");
                System.exit(5);
            }
            loops.add(new KeyLoop(key, interv));
        }
        System.out.println("KeyLoops loaded:");
        loops.forEach(System.out::println);
    }

    private static void usage() {
        System.out.println("Usage: KeyPresser <key-1> <seconds-1> ... <key-n> <seconds-n>");
    }

    public static synchronized void pressKey(char key) {
        robot.keyPress(key);
        robot.delay(60);
        robot.keyRelease(key);
    }
}
