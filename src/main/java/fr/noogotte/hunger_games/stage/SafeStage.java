package fr.noogotte.hunger_games.stage;

import java.util.ArrayList;

import org.bukkit.event.Listener;

import fr.noogotte.hunger_games.HungerGame;
import fr.noogotte.hunger_games.stage.listener.SafeStageListener;

public class SafeStage extends Stage implements Listener {

    private ArrayList<Listener> listeners;

    public SafeStage(HungerGame game) {
        super(game);
        listeners = new ArrayList<Listener>();
        listeners.add(new SafeStageListener(game));
    }

    @Override
    public ArrayList<Listener> getListeners() {
        return listeners;
    }

    @Override
    public void start() {
        game.getGame().sendMessages(game.getMessages().get("safeStage.start", 
                game.getConfig().getSafeDuration()));
    }

    @Override
    public void stop() {
        game.getGame().sendMessages(game.getMessages().get("safeStage.stop"));
    }

    @Override
    public String getName() {
        return "JoinStage";
    }
}
