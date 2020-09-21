package de.remadisson.core.rainbowcorepaper.events;

import de.remadisson.core.rainbowcorepaper.user.instances.User;
import de.remadisson.core.rainbowcorepaper.user.instances.UserSettings;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserSettingsUpdateEvent extends Event {

    User user;
    UserSettings settings;

    public UserSettingsUpdateEvent(User user, UserSettings settings){
        this.user = user;
        this.settings = settings;
    }

    public User getUser(){
        return user;
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(user.getUUID());
    }

    public OfflinePlayer getOfflinePlayer(){
        return Bukkit.getOfflinePlayer(user.getUUID());
    }

    public UserSettings getNewSettings(){
        return settings;
    }

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
