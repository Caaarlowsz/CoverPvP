package me.shooyudev.Configs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ArenaConfig {

public class Arenas {
}
public static ArrayList<String> login = new ArrayList<>();

	public static ArenaConfig pasta = new ArenaConfig();
	FileConfiguration Arenas;
	File FileArenas;
	public static ArenaConfig getConfig(){
		return pasta;
	}
	public void ConfigEnable(Plugin plugin){
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		FileArenas = new File(plugin.getDataFolder(), "Arenas.yml");
		if(FileArenas.exists()){
			try{
				FileArenas.createNewFile();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		Arenas = YamlConfiguration.loadConfiguration(FileArenas);
	}
	public FileConfiguration config(){
		return Arenas;
	}
	public void saveConfigs(){
		try{
			Arenas.save(FileArenas);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
