package me.shooyudev.Habilites;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.shooyudev.Main;
import me.shooyudev.API.KitAPI;

public class Stomper implements Listener{
	
	public static ArrayList<String> delay = new ArrayList<>();
	
	@EventHandler
	public void clicar(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if ((KitAPI.getKit(p) == "Stomper")){
			if ((p.getItemInHand().getType() == Material.EMERALD) && (e.getAction() == Action.RIGHT_CLICK_AIR)){
				if (delay.contains(p.getName())){
					p.sendMessage("§cVocê esta em cooldown.");
					return;
				}
				p.setVelocity(new Vector(0, 3, 0).setY(3));
				delay.add(p.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					
					@Override
					public void run() {
						if (delay.contains(p.getName())){
							delay.remove(p.getName());
						if (KitAPI.getKit(p) == "Stomper"){
							p.sendMessage("§bVocê saiu do cooldown. Pode usar o kit novamente.");
				  }
				 }
				}
			}, 40 * 20L);
		}
	}
  }
	
	@EventHandler
	  public void stompar(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getEntity();
	    if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
	    	if ((KitAPI.getKit(p) == "Stomper")){
	        for (@SuppressWarnings("rawtypes")
			Iterator localIterator = p.getNearbyEntities(4.0D, 1.5D, 4.0D).iterator(); localIterator.hasNext();)
	        {
	          Entity entidade;
	          if (((entidade = (Entity)localIterator.next()) instanceof Player))
	          {
	            Player stompado = (Player)entidade;
	            if (e.getDamage() <= 4.0D)
	            {
	              e.setCancelled(true);
	              return;
	            }
	            if (stompado.isSneaking()){
	              stompado.damage(6.0D, p);
	              stompado.sendMessage("§cVoce foi stompado por: " + p.getDisplayName());
	            }
	            else{
	              stompado.damage(e.getDamage(), p);
	            }
	          }
	        }
	        e.setDamage(4.0D);
	      }
	    }
	  }
}
