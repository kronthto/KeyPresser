package de.kronthto.keypresser;

import java.util.Timer;
import java.util.TimerTask;

class KeyLoop {
    private final char key;
    private final int interval;

    public KeyLoop(char key, int interval) {
        this.key = Character.toUpperCase(key);
        this.interval = interval;
        loop();
    }

    private void loop() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Program.pressKey(key);
            }
        }, interval * 1000, interval * 1000);
    }

    @Override
    public String toString() {
        return "KeyLoop for key '" + key + "' all " + interval + " seconds";
    }
}
