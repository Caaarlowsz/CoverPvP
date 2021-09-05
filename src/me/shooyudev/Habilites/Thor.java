package me.shooyudev.Habilites;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.shooyudev.API.CooldownAPI;
import me.shooyudev.API.KitAPI;

public class Thor implements Listener{
	
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void ThorKit(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((p.getItemInHand().getType() == Material.GOLD_AXE) && (e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	      (KitAPI.getKit(p) == "Thor")) {
	      if (CooldownAPI.Cooldown.containsKey(p.getName())) {
	    		p.sendMessage(ChatColor.GRAY + "O Cooldown do " + ChatColor.GOLD + ChatColor.BOLD + "Thor" + ChatColor.GRAY + " acaba em: " + ChatColor.YELLOW + ChatColor.BOLD + CooldownAPI.Cooldown(p) + "s");
	        return;
	      }

	     CooldownAPI.addCooldown(p, 6);
	      Location loc = p.getTargetBlock(null, 25).getLocation();
	      p.getWorld().strikeLightning(loc);
	      e.setCancelled(true);
	      p.damage(0.0D);
	    }
	  }

}
