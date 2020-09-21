package de.remadisson.core.rainbowcorepaper.user.instances;

import de.remadisson.core.rainbowcorepaper.api.MojangAPI;
import de.remadisson.core.rainbowcorepaper.user.enums.UserTablist;

import java.util.Objects;
import java.util.UUID;

public class User {

    private String username;
    private UUID uuid;
    private UserSettings userSettings;

    public User(String username) throws NullPointerException {
        this.username = username;
        this.uuid = Objects.requireNonNull(MojangAPI.getPlayerProfile(username)).getUUID();
    }

    public User(UUID uuid) throws NullPointerException {
        this.uuid = uuid;
        this.username = Objects.requireNonNull(MojangAPI.getPlayerProfile(uuid).getName());
    }

    public UUID getUUID(){
        return uuid;
    }

    public String getUsername(){
        return username;
    }

    public UserSettings getUserSettings(){
        if(userSettings == null){
            // TODO LOAD userSettings
        }

        return userSettings;
    }

    public UserTablist getUserTablist(){
        return userSettings.getTablist();
    }
}
