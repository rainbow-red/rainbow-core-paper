package de.remadisson.core.rainbowcorepaper;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    public static main plugin;

    @Override
    public void onEnable() {
        plugin = this;

        System.out.println(files.console + "§aRainbow-Core is now starting..");
        files.init();

        registerListeners();
        registerExecutors();

        System.out.println(files.console + "§2Rainow-Core has successfully been started!");
    }

    @Override
    public void onDisable() {
        System.out.println(files.console + "§cRainbow-Core is now disabling..");
        System.out.println(files.console + "§4Rainbow-Core is now disabled!");
    }


    public void registerListeners(){

    }

    public void registerExecutors(){
        
    }

    public static main getInstance(){
        return plugin;
    }
}
