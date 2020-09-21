package de.remadisson.core.rainbowcorepaper.api;

import de.remadisson.core.rainbowcorepaper.mojang.JsonUtils;
import de.remadisson.core.rainbowcorepaper.mojang.PlayerProfile;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.UUID;

public class MojangAPI {

    @Nullable
    public static PlayerProfile getPlayerProfile(String name){
        HashMap<String, String> values = JsonUtils.getPlayerInJson(name);
        try {
            return new PlayerProfile(values.get("name"), UUID.fromString(values.get("id")));
        }catch(NullPointerException e){
            return null;
        }
    }

    @Nullable
    public static PlayerProfile getPlayerProfile(UUID uuid){
        HashMap<String, String> values = JsonUtils.getPlayerInJson(uuid);

        try{
            return new PlayerProfile(values.get("id"), uuid);
        }catch(NullPointerException ex){
            return null;
        }
    }
}
