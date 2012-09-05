package fr.noogotte.hunger_games;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.aumgn.bukkitutils.gson.GsonLoadException;
import fr.aumgn.bukkitutils.gson.GsonLoader;
import fr.aumgn.bukkitutils.gson.typeadapter.DirectionTypeAdapterFactory;

public class HungerGamePlugin extends JavaPlugin {

    private HungerGameConfig hungerConfig;

    @Override
    public void onEnable() {
        hungerConfig = loadHungerGameConfig();
    }

    @Override
    public void onDisable() {
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
