package me.shooyudev.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.shooyudev.Main;
import me.shooyudev.API.API;
import me.shooyudev.API.KitAPI;
import me.shooyudev.API.WarpsAPI;
import me.shooyudev.Comandos.Evento;

public class Respawn implements Listener{
	
	@EventHandler
	public void respawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		p.getInventory().clear();
		API.itensSpawn(p);
		KitAPI.TirarKit(p);
		WarpsAPI.Ir(p, "Spawn");
		API.setWarp(p, "Spawn");
		p.teleport(p.getWorld().getSpawnLocation());
		p.getInventory().setArmorContents(null);
		Evento.participantes.remove(p.getName());
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				p.spigot().respawn();
			}
		  }, 1L);
	}

}
