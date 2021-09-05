package me.shooyudev.Configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class EventoConfig {

public class Evento {
}
	public static EventoConfig pasta = new EventoConfig();
	FileConfiguration Evento;
	File FileEvento;
	public static EventoConfig getConfig(){
		return pasta;
	}
	public void ConfigEnable(Plugin plugin){
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		FileEvento = new File(plugin.getDataFolder(), "Evento.yml");
		if(FileEvento.exists()){
			try{
				FileEvento.createNewFile();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		Evento = YamlConfiguration.loadConfiguration(FileEvento);
	}
	public FileConfiguration config(){
		return Evento;
	}
	public void saveConfigs(){
		try{
			Evento.save(FileEvento);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
