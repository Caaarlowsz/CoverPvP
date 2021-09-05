package me.shooyudev.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DanoEvents implements Listener{

	@EventHandler
	  public void DanoDasEspadas(EntityDamageByEntityEvent e) {
	    if (((e.getDamager() instanceof Player)) && (((Player)e.getDamager() instanceof Player))){
	      Player p = (Player)e.getDamager();
	      if (((e.getEntity() instanceof Player)) && (p.getItemInHand().getType() == Material.STONE_SWORD)){
	        e.setDamage(e.getDamage() * 0.6D);
	         return;
	          }
	      if(p.getItemInHand().getType() == Material.WOOD_SWORD){
	        e.setDamage(e.getDamage() * 0.5D);
	         return;
              }
	      if(p.getItemInHand().getType() == Material.DIAMOND_SWORD){
	        e.setDamage(e.getDamage() * 0.7D);
	         return;
	      }
	    }
	  }
	
}
