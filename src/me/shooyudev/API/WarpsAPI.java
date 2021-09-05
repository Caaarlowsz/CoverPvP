package me.shooyudev.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.shooyudev.Main;
import me.shooyudev.Configs.WarpsConfig;
import me.shooyudev.Utills.FpsEnum;
import me.shooyudev.Utills.Strings;

public class WarpsAPI implements Listener{
	
	public static void iniciarFPS(){
		Main.estado=FpsEnum.FPS1;
		
	}
	
	public static void removerFPS(){
		Main.estado=FpsEnum.NORMAL;
		
	}
	
	public static void Set(Player p,String Warp){
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".X", p.getLocation().getX());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Y", p.getLocation().getY());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Z", p.getLocation().getZ());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Pitch", p.getLocation().getPitch());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Yaw", p.getLocation().getYaw());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".World", p.getLocation().getWorld().getName());
		WarpsConfig.getConfig().saveConfigs();
		p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
	}
	public static void Ir(Player p,String Warp){
		
		if(WarpsConfig.getConfig().config().contains("Warps." + Warp)){
			
			double x = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".X");
			double y = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Y");
			double z = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Z");
			float Pitch = (float)WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Pitch");
			float Yaw = (float)WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Yaw");
			World world = Bukkit.getWorld(WarpsConfig.getConfig().config().getString("Warps." + Warp + ".World"));
			Location loc = new Location(world, x, y, z, Yaw, Pitch);
			
			p.teleport(loc);
		}else{
			p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Essa " + ChatColor.YELLOW + ChatColor.BOLD + "WARP" + ChatColor.GRAY + " ainda nao foi setada!");
		}
	}

}
