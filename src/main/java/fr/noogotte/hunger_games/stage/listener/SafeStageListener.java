package fr.noogotte.hunger_games.stage.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.noogotte.hunger_games.HungerGame;

public class SafeStageListener implements Listener {

    private HungerGame game;

    public SafeStageListener(HungerGame game) {
        this.game = game;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDamage(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();

        if (!game.getGame().isInGame(player)) {
            return;
        }

        event.setCancelled(true);
    }
}
