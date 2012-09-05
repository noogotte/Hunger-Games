package fr.noogotte.hunger_games;

import java.util.Locale;

public class HungerGameConfig {

    private Locale locale = Locale.FRANCE;
    private int safeDuration = 60;
    private int maxGameDuration = 60;

    public Locale getLocale() {
        return locale;
    }

    public int getSafeDuration() {
        return safeDuration;
    }

    public int getMaxGameDuration() {
        return maxGameDuration;
    }
}
