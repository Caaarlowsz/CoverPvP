package me.shooyudev.Habilites;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import me.shooyudev.Main;
import me.shooyudev.API.CooldownAPI;
import me.shooyudev.API.KitAPI;

public class Ninja implements Listener{
	  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static HashMap<Player, Player> a = new HashMap();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static HashMap<Player, Long> b = new HashMap();
  public static Main plugin;
  public static ArrayList<Player> noExecut = new ArrayList<>();




  @EventHandler
  public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player)) && ((paramEntityDamageByEntityEvent.getEntity() instanceof Player)))
    {
      final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
      Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
      if (KitAPI.getKit(localPlayer1) == "Ninja")
      {
        a.put(localPlayer1, localPlayer2);

      }
    }
  }

  @EventHandler
  public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
    Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
    if ((paramPlayerToggleSneakEvent.isSneaking()) && (KitAPI.getKit(localPlayer1) == "Ninja") && (CooldownAPI.Cooldown.containsKey(localPlayer1.getName()))){
    	localPlayer1.sendMessage(ChatColor.GRAY + "O Cooldown do " + ChatColor.YELLOW + ChatColor.BOLD + "Ninja" + ChatColor.GRAY + " acaba em: " + ChatColor.YELLOW + ChatColor.BOLD + CooldownAPI.Cooldown(localPlayer1) + "s");
    	return;
    }
    if ((paramPlayerToggleSneakEvent.isSneaking()) && (KitAPI.getKit(localPlayer1) == "Ninja") && (a.containsKey(localPlayer1))){
      Player localPlayer2 = (Player)a.get(localPlayer1);
      if ((localPlayer2 != null) && (!localPlayer2.isDead()))
      {
    	  if(noExecut.contains(localPlayer2)){
    		  localPlayer1.sendMessage("§cEste jogador está em um duelo nas alturas!");
    		  return;
    	  }
    	  if(noExecut.contains(localPlayer1)){
    		  localPlayer1.sendMessage("§cVocê não pode utilizar o kit Ninja durante um duelo no Gladiator!");
    		  return;
    	  }
        @SuppressWarnings("unused")
		String str = null;
        if (b.get(localPlayer1) != null)
        {
          long l = ((Long)b.get(localPlayer1)).longValue() - System.currentTimeMillis();
          DecimalFormat localDecimalFormat = new DecimalFormat("##");
          int i = (int)l / 1000;
          str = localDecimalFormat.format(i);
          }
        }
        if ((b.get(localPlayer1) == null) || (((Long)b.get(localPlayer1)).longValue() < System.currentTimeMillis())) {
          if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D){
            localPlayer1.teleport(localPlayer2.getLocation());
            CooldownAPI.addCooldown(localPlayer1, 5);
            b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
          }
          else{
            localPlayer1.sendMessage("§cO último jogador hitado está muito longe!");
          }
        }
    }
  }
}