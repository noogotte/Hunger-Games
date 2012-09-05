package fr.noogotte.hunger_games;

import java.util.Locale;

public class HungerGameConfig {

    private Locale locale = Locale.FRANCE;
    private int safeDuration = 60;

    public int getSafeDuration() {
        return safeDuration;
    }

    public Locale getLocale() {
        return locale;
    }
}
