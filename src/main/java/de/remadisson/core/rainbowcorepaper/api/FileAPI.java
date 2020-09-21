package de.remadisson.core.rainbowcorepaper.api;

import de.remadisson.core.rainbowcorepaper.files;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileAPI {

    private final String filename;
    private final String path;
    private final File folder;
    private final File file;
    private YamlConfiguration configuration;

    public FileAPI(String filename, String path){
        this.filename = filename;
        this.path = path;

        folder = new File(path);
        file = new File(path, filename);

        if(!file.exists()){
            if(!folder.exists()){
                folder.mkdir();
                Bukkit.getConsoleSender().sendMessage(files.console + "§b" + folder.getName() + " §ehas been initiated!");
            }

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            configuration = YamlConfiguration.loadConfiguration(file);
    }

    public String getName(){
        return filename;
    }

    public String getPath(){
        return path;
    }

    public File getFolder(){
        return folder;
    }

    public File getFile(){
        return file;
    }

    public YamlConfiguration getConfiguration(){
        return configuration;
    }

    public FileAPI save(){
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public FileAPI delete(){
        file.delete();
        return this;
    }

    public FileAPI addDefault(String key, Object value){
        if(configuration.get(key) == null){
            configuration.set(key, value);
        }
        return this;
    }

    public Object getValue(String key){
        return configuration.get(key);
    }
}
