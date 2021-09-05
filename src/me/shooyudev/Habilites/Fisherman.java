package me.shooyudev.Habilites;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.shooyudev.API.KitAPI;

public class Fisherman implements Listener {
	
	@EventHandler
    public void NaoQuebrarOFisherman(PlayerInteractEvent e){
  	  
  	  Player p = e.getPlayer();
  	  
  	  if(p.getItemInHand().getType() == Material.FISHING_ROD ){
  		  if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
  			  p.getItemInHand().setDurability((short)0);
  			  p.updateInventory();
  		  }
  	  }
    }
	
	@EventHandler
	public void Pescar(PlayerFishEvent e) {
		Player p = e.getPlayer();
		if (e.getCaught() instanceof Player && KitAPI.getKit(p) == "Fisherman") {
			Player t = (Player)e.getCaught();
			t.teleport(p);
		}
		
	}

}
