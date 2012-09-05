package fr.noogotte.hunger_games.commands;

import fr.aumgn.bukkitutils.command.Commands;
import fr.noogotte.hunger_games.HungerGame;
import fr.noogotte.hunger_games.HungerGameConfig;

public abstract class HungerGameCommands implements Commands {

    private HungerGame game;

    public HungerGameCommands(HungerGame game) {
        this.game = game;
    }

    public HungerGameConfig getConfig() {
        return game.getConfig();
    }

    protected String msg(String key) {
        return game.getCmdMessages().get(key);
    }

    protected String msg(String key, Object... arguments) {
        return game.getCmdMessages().get(key, arguments);
    }
}
