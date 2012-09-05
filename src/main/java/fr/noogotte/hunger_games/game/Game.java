package fr.noogotte.hunger_games.game;

import org.bukkit.World;
import org.bukkit.entity.Player;

import fr.aumgn.bukkitutils.playerref.set.PlayersRefHashSet;

public class Game {

    private World world;
    private PlayersRefHashSet players;

    public Game(World world) {
        this.world = world;
        players = new PlayersRefHashSet();
    }

    public boolean isInGame(Player player) {
        return players.contains(player);
    }

    public World getWorld() {
        return world;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.add(player);
    }
}
