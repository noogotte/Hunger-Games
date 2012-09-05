package fr.noogotte.hunger_games.stage;

import java.util.ArrayList;

import org.bukkit.event.Listener;

import fr.noogotte.hunger_games.HungerGame;

public class JoinStage extends Stage {

    private ArrayList<Listener> listeners;

    public JoinStage(HungerGame game) {
        super(game);
        listeners = new ArrayList<Listener>(); 
    }

    @Override
    public ArrayList<Listener> getListeners() {
        return listeners;
    }

    @Override
    public void start() {
        game.getGame().sendMessages(game.getMessages().get("joinStage.start"));
    }

    @Override
    public void stop() {
    }

    @Override
    public String getName() {
        return "JoinsStage";
    }

}
