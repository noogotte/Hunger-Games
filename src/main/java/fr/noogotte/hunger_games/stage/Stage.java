package fr.noogotte.hunger_games.stage;

import java.util.ArrayList;

import org.bukkit.event.Listener;

import fr.aumgn.bukkitutils.timer.Timer;
import fr.noogotte.hunger_games.HungerGame;


public abstract class Stage {

    protected HungerGame game;
    protected Timer gameTimer = null;

    public Stage(HungerGame game) {
        this.game = game;
    }

    public HungerGame getGame() {
        return game;
    }

    public abstract ArrayList<Listener> getListeners();

    public abstract void start();

    public abstract void stop();
}