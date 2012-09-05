package fr.noogotte.hunger_games;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.aumgn.bukkitutils.command.CommandsRegistration;
import fr.aumgn.bukkitutils.gson.GsonLoadException;
import fr.aumgn.bukkitutils.gson.GsonLoader;
import fr.aumgn.bukkitutils.gson.typeadapter.DirectionTypeAdapterFactory;
import fr.noogotte.hunger_games.commands.GameCommands;

public class HungerGamePlugin extends JavaPlugin implements Listener {

    private HungerGameConfig hungerConfig;
    private HungerGame game;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        this.game = new HungerGame(this);
        hungerConfig = loadHungerGameConfig();
        CommandsRegistration registration = new CommandsRegistration(this, 
                this.getHungerConfig().getLocale());
        registration.register(new GameCommands(game));
    }

    @Override
    public void onDisable() {
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDisable(PluginDisableEvent event) {
        if (event.getPlugin().equals(this)
                && game.isRunning()) {
            game.getCurrentStage().stop();
        }
    }

    public HungerGameConfig loadHungerGameConfig() {
        GsonLoader loader = getGsonLoader();
        try {
            return loader.loadOrCreate("config.json", HungerGameConfig.class);
        } catch (GsonLoadException exc) {
            getLogger().severe(
                    "Unable to load config.json. Using default values");
            return new HungerGameConfig();
        }
    }

    public GsonLoader getGsonLoader() {
        Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new DirectionTypeAdapterFactory())
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
            .setPrettyPrinting().create();
        return new GsonLoader(gson, this);
    }    

    public HungerGameConfig getHungerConfig() {
        return hungerConfig;
    }
}
