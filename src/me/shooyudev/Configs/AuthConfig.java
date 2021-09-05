package me.shooyudev.Configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class AuthConfig {

public class Auth {
}

	public static AuthConfig pasta = new AuthConfig();
	FileConfiguration Auth;
	File FileAuth;
	public static AuthConfig getConfig(){
		return pasta;
	}
	public void ConfigEnable(Plugin plugin){
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		FileAuth = new File(plugin.getDataFolder(), "Auth.yml");
		if(FileAuth.exists()){
			try{
				FileAuth.createNewFile();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		Auth = YamlConfiguration.loadConfiguration(FileAuth);
	}
	
	public static Plugin plugin;
	public static Plugin getPlugin() {
		return plugin;
	}
	
	public FileConfiguration config(){
		return Auth;
	}
	public void saveConfigs(){
		try{
			Auth.save(FileAuth);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
