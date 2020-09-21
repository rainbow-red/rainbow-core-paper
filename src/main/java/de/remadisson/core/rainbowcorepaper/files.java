package de.remadisson.core.rainbowcorepaper;

import de.remadisson.core.rainbowcorepaper.api.FileAPI;
import de.remadisson.core.rainbowcorepaper.file.VariableEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class files {

        public static final String prefix = "§8» §r";
        public static final String console = "§7[§e" + main.getInstance().getDescription().getName() + "§7] " + prefix;
        public static final String debug = "§7[§dDEBUG§7] " + console;

        public static HashMap<VariableEnum, Object> configVariables = new HashMap<>();

        public static Executor pool = Executors.newCachedThreadPool();

        public static FileAPI configFile;

        public static void init(){
                configFile = new FileAPI("config.yml", "./plugins/RainbowCore");
                initVariables();
        }

        public static void initVariables(){
                Arrays.stream(VariableEnum.values())
                        .forEach(variable -> {
                                configFile.addDefault(variable.name(), variable.getValue());
                                if(configFile.getValue(variable.name()) != null){
                                        configVariables.put(variable, configFile.getValue(variable.name()));
                                } else {
                                        configVariables.put(variable, variable.getValue());
                                }
                        });
                configFile.save();
        }

}
