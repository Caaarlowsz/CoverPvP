package me.shooyudev.Habilites;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.shooyudev.API.KitAPI;

public class Specialist implements Listener{
	
	@EventHandler
	public void onSpecialist(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if (KitAPI.getKit(p) == "Specialist" && p.getItemInHand().getType() == Material.ENCHANTED_BOOK){
			p.openEnchanting(p.getLocation(), true);
		}
	}

}
