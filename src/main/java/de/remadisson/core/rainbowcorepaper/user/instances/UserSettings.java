package de.remadisson.core.rainbowcorepaper.user.instances;

import de.remadisson.core.rainbowcorepaper.user.enums.UserTablist;

import java.util.HashMap;

public class UserSettings {

    private UserTablist tablist;
    private String lastOnline;
    private HashMap<String, Object> additionalSetting;

    public UserSettings(UserTablist tablist, String lastOnline){
        this.tablist = tablist;
        this.lastOnline = lastOnline;
    }

    public UserSettings setTablist(UserTablist tablist){
        this.tablist = tablist;
        return this;
    }

    public UserTablist getTablist(){
        return tablist;
    }

    public String getLastOnline(){
        return lastOnline;
    }
}
