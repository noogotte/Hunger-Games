package fr.noogotte.hunger_games;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import fr.aumgn.bukkitutils.localization.Localization;
import fr.aumgn.bukkitutils.localization.PluginMessages;
import fr.noogotte.hunger_games.game.Game;
import fr.noogotte.hunger_games.stage.Stage;

public class HungerGame {

    private final HungerGamePlugin plugin;
    private HungerGameConfig config;
    private PluginMessages messages;
    private PluginMessages cmdMessages;
    private Stage stage;
    private Game game;

    public HungerGame(HungerGamePlugin plugin, Stage stage) {
        this.plugin = plugin;
        reloadConfig();
        this.stage = stage;
        this.game = null;
    }

    public void reloadConfig() {
        config = plugin.loadHungerGameConfig();
        Localization localization =
                new Localization(plugin, config.getLocale());
        cmdMessages = localization.get("commands");
        messages = localization.get("messages");
    }

    public HungerGamePlugin getPlugin() {
        return plugin;
    }

    public Game getGame() {
        return game;
        
    }

    public HungerGameConfig getConfig() {
        return config;
    }

    public Logger getLogger() {
        return plugin.getLogger();
    }

    public PluginMessages getCmdMessages() {
        return this.cmdMessages;
    }

    public PluginMessages getMessages() {
        return this.messages;
    }

    public Stage getCurrentStage() {
        return stage;
    }

    public void nextStage(Stage newStage) {
        if (newStage == null) {
            throw new IllegalArgumentException("New stage cannot be null");
        }
        if (stage != null) {
            unregisterStageListeners();
            Bukkit.getScheduler().cancelTasks(plugin);
            stage.stop();
        }
        stage = newStage;
        registerStageListeners();
        stage.start();
    }

    public boolean isRunning() {
        return game != null;
    }

    private void unregisterStageListeners() {
        for (Listener listener : stage.getListeners()) {
            HandlerList.unregisterAll(listener);
        }
    }

    private void registerStageListeners() {
        for (Listener listener : stage.getListeners()) {
            Bukkit.getPluginManager().registerEvents(listener, plugin);
        }
    }
}
