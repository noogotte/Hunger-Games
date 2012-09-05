package fr.noogotte.hunger_games.commands;

import org.bukkit.entity.Player;

import fr.aumgn.bukkitutils.command.Command;
import fr.aumgn.bukkitutils.command.NestedCommands;
import fr.aumgn.bukkitutils.command.args.CommandArgs;
import fr.aumgn.bukkitutils.command.exception.CommandError;
import fr.noogotte.hunger_games.HungerGame;
import fr.noogotte.hunger_games.game.Game;
import fr.noogotte.hunger_games.stage.JoinStage;

@NestedCommands("hungergame")
public class GameCommands extends HungerGameCommands {

    public GameCommands(HungerGame game) {
        super(game);
    }

    @Command(name = "init")
    public void init(Player sender, CommandArgs args) {
        if (game.isRunning()) {
            throw new CommandError(msg("game.isAlreadyInitialize"));
        }

        game.init(new Game(sender.getWorld()), new JoinStage(game));
    }
}
