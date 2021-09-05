package me.shooyudev.Habilites;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import me.shooyudev.Main;
import me.shooyudev.API.CooldownAPI;
import me.shooyudev.API.KitAPI;
import me.shooyudev.Utills.Strings;

public class Ajnin implements Listener{
	
	  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static HashMap<Player, Player> a = new HashMap();
	  public static ArrayList<Player> noExecut = new ArrayList<>();

  @EventHandler
  public void a(EntityDamageByEntityEvent e) {
    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player))){
      final Player hitou = (Player)e.getDamager();
      Player hitado = (Player)e.getEntity();
      if (KitAPI.getKit(hitou) == "Ajnin" && !a.containsKey(hitou)){
        a.put(hitou, hitado);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				a.remove(hitou);
				a.remove(hitado);
			}
		}, 11*20);
      }
    }
  }

  @EventHandler
  public void a(PlayerToggleSneakEvent e) {
    Player hitou = e.getPlayer();
    if ((e.isSneaking()) && (KitAPI.getKit(hitou) == "Ajnin") && (CooldownAPI.Cooldown.containsKey(hitou.getName()))){
    	hitou.sendMessage(ChatColor.GRAY + "O Cooldown do " + ChatColor.YELLOW + ChatColor.BOLD + "Ajnin" + ChatColor.GRAY + " acaba em: " + ChatColor.YELLOW + ChatColor.BOLD + CooldownAPI.Cooldown(hitou) + "s");
    	return;
    }
    
    if ((e.isSneaking()) && (KitAPI.getKit(hitou) == "Ajnin") && (a.containsKey(hitou))){
      Player hitado = (Player)a.get(hitou);
     
      if ((hitado != null)){
    	  if(noExecut.contains(hitado)){
    		  hitou.sendMessage("§cEste jogador está em um pvp nas alturas!");
    		  return;
    	  }
    	  if(noExecut.contains(hitou)){
    		  hitou.sendMessage("§cVocê não pode utilizar o kit Ajnin durante um pvp no Gladiator!");
    		  return;
    	  }
          if (hitou.getLocation().distance(hitado.getLocation()) < 40.0D){
        	  
            hitado.teleport(hitou.getLocation());
            CooldownAPI.addCooldown(hitou, 20);
          }else{
            hitou.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Esse player sumiu de sua vista!");
          }
        }
    }
  }
}