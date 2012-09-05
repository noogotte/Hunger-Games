package fr.noogotte.hunger_games.game;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class Game {

    private World world;
    private Set<Player> players;

    public Game(World world) {
        this.world = world;
        players = new HashSet<Player>();
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

    public void sendMessages(String message) {
        for (Player player : players) {
            player.sendMessage(message);
        }
    }
}
