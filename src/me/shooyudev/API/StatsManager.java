package me.shooyudev.API;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.shooyudev.Main;
import me.shooyudev.scoreboarding.Updater;

public class StatsManager {
	
	public static File file;
	public static FileConfiguration cfile;
	
	public StatsManager() {
		Plugin plugin = Main.getPlugin();
		
		if (plugin.getDataFolder().exists() == false) {
			plugin.getDataFolder().mkdir();
		}
		file = new File(plugin.getDataFolder(), "playersstatus.yml");
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		cfile = YamlConfiguration.loadConfiguration(file);
	}
	
	public static void FirstJoin(Player jogador) {
		if (cfile.getString(jogador.getName() + ".UUID") == null) {
			cfile.set(jogador.getName() + ".Kills", 0);
			cfile.set(jogador.getName() + ".Deaths", 0);
			cfile.set(jogador.getName() + ".Xp", 0);
			cfile.set(jogador.getName() + ".Coins", 0);
			Save();
		}
	}
	
	public static void setKills(Player p) {
        cfile.set(p.getName() + ".Kills", getKills(p) + 1);
        cfile.set(p.getName() + ".Ks", getKillStreak(p) + 1);
        Save();
    }
	public static void addKills(Player p, int tanto) {
        cfile.set(p.getName() + ".Kills", getKills(p) + tanto);
        Save();
    }
	public static void setKillsCmd(Player p, String valor) {
        cfile.set(p.getName() + ".Kills", valor);
        Save();
    }
	
	public static int getKills(Player p) {
        return cfile.getInt(p.getName() + ".Kills");
    }
	
	public static int getKillsOff(OfflinePlayer off) {
		return cfile.getInt(off.getName() + ".Kills");
	}
	
	public static int getKillStreak(Player p) {
        return cfile.getInt(p.getName() + ".Ks");
    }
	
	
    public static void setDeaths(Player p) {
        cfile.set(p.getName() + ".Deaths", getDeaths(p) + 1);
        Save();
    }
    public static void addDeaths(Player p, double valor) {
        cfile.set(p.getName() + ".Deaths", valor);
        Save();
    }
    public static void setDeathsCmd(Player p, double valor) {
        cfile.set(p.getName() + ".Deaths", getDeaths(p) + valor);
        Save();
    }
    public static void addKillStreak(Player p, double valor) {
        cfile.set(p.getName() + ".Ks", valor);
        Save();
    }
    public static void addKillStreakCmd(Player p, double valor) {
        cfile.set(p.getName() + ".Ks", getDeaths(p) + valor);
        Save();
    }
    
    public static int getDeaths(Player p) {
        return cfile.getInt(p.getName() + ".Deaths");
    }
   
    public static void setXp(Player p, int Xp) {
        cfile.set(p.getName() + ".Xp", getXp(p) + Xp);
        Save();
    }
    public static void addXp(Player p, double Xp) {
        cfile.set(p.getName() + ".Xp", getXp(p) + Xp);
        Save();
    }
    public static void setXpCmd(Player p, double Xp) {
        cfile.set(p.getName() + ".Xp", getXp(p) + Xp);
        Save();
    }
   
    public static void RemoveXp(Player p, int Xp) {
        if (getXp(p) <= 0) {
            return;
        }
        cfile.set(p.getName() + ".Xp", getXp(p) - Xp);
        Save();
    }
    public static void setCoins(Player p, int Coins) {
        cfile.set(p.getName() + ".Coins", getCoins(p) + Coins);
        Save();
    }
    public static void addCoins(Player p, double Coins) {
        cfile.set(p.getName() + ".Coins", getCoins(p) + Coins);
        Save();
    }
    public static void setCoinsCmd(Player p, double Coins) {
        cfile.set(p.getName() + ".Coins", getCoins(p) + Coins);
        Save();
    }
   
    public static void RemoveCoins(Player p, int Coins) {
        if (getCoins(p) <= 0) {
            return;
        }
        cfile.set(p.getName() + ".Coins", getXp(p) - Coins);
        Save();
    }
	public static int getCoins(Player p) {
        return cfile.getInt(p.getName() + ".Coins");
    }
    
    
    @SuppressWarnings("deprecation")
	public static void RemoverKS(Player p) {
        cfile.set(p.getName() + ".Ks", getKillStreak(p) - getKillStreak(p));
        
    	for (Player players : Bukkit.getOnlinePlayers()) {
    		Updater.UpdateScore(players);
    	}
        Save();
    }
   
    public static int getXp(Player p) {
        return cfile.getInt(p.getName() + ".Xp");
    }
    
    public static void Save() {
        try {
            cfile.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
