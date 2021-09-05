package me.shooyudev.Utills;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.shooyudev.API.API;
import me.shooyudev.API.KitAPI;
import me.shooyudev.API.StatsManager;
import me.shooyudev.API.WarpsAPI;
import me.shooyudev.scoreboarding.Updater;

public class Challenge implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("lavafacil")) {
			e.setLine(0, "");
			e.setLine(1, "§e§lCHALLENGE");
			e.setLine(2, "§7(Fácil)");
			e.setLine(3, "");
		}
		
		if(e.getLine(0).equalsIgnoreCase("lavamedio")) {
			e.setLine(0, "");
			e.setLine(1, "§e§lCHALLENGE");
			e.setLine(2, "§7(Difícil)");
			e.setLine(3, "");
		}
		
		if(e.getLine(0).equalsIgnoreCase("lavadificil")) {
			e.setLine(0, "");
			e.setLine(1, "§e§lCHALLENGE");
			e.setLine(2, "§7(Difícil)");
			e.setLine(3, "");
		}
		if(e.getLine(0).equalsIgnoreCase("lavaextremo")) {
			e.setLine(0, "");
			e.setLine(1, "§e§lCHALLENGE");
			e.setLine(2, "§7(Extremo)");
			e.setLine(3, "");
		}
		
	}
	
	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if(e.getClickedBlock() != null)
			   if (e.getClickedBlock().getType() == Material.WALL_SIGN || (e.getClickedBlock().getType() == Material.SIGN_POST)) {
			Sign s = (Sign)e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§e§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("§7(Fácil)")) &&
					(lines.length > 3) && (lines[3].equals("") &&  	
							API.getWarp(p) == "Challenge")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você completou o §e§lLavaChallenge " + ChatColor.YELLOW + ChatColor.BOLD + "Facil.");
				StatsManager.setCoins(p, 3);
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				KitAPI.TirarKit(p);
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKit(p, "Challenge");
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short)0));
				Updater.UpdateScore(p);
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você ganhou 3 Coins");
				
		}
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§e§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("§7(Médio)")) &&
					(lines.length > 3) && (lines[3].equals("") &&
							API.getWarp(p) == "Challenge")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você completou o §e§lLavaChallenge " + ChatColor.YELLOW + ChatColor.BOLD + "Medio.");
				StatsManager.setCoins(p, 8);
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				KitAPI.TirarKit(p);
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKit(p, "Challenge");
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short)0));
				Updater.UpdateScore(p);
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você ganhou 8 Coins");
		}
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§e§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("§7(Difícil)")) &&
					(lines.length > 3) && (lines[3].equals("") &&
							API.getWarp(p) == "Challenge")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você completou o §e§lLavaChallenge " + ChatColor.YELLOW + ChatColor.BOLD + "Dificil.");
				StatsManager.setCoins(p, 13);
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				KitAPI.TirarKit(p);
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKit(p, "Challenge");
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short)0));
				Updater.UpdateScore(p);
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você ganhou 13 Coins");
		}
			if ((lines.length > 0) && (lines[0].equals("")) && 
					(lines.length > 1) && (lines[1].equals("§e§lCHALLENGE"))&&
					(lines.length > 2) && (lines[2].equals("§7(Extremo)")) &&
					(lines.length > 3) && (lines[3].equals("") &&
							API.getWarp(p) == "Challenge")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você completou o §e§lLavaChallenge §7difícil!");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(ChatColor.GRAY + "O Player " + ChatColor.YELLOW + ChatColor.BOLD + p.getName() + ChatColor.GRAY + " zerou o " + ChatColor.GOLD + ChatColor.BOLD + "LavaChallenge" + ChatColor.YELLOW + ChatColor.BOLD + " Extremo" + ChatColor.GRAY + " Parabens !");
				Bukkit.broadcastMessage(" ");
				StatsManager.setCoins(p, 20);
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				KitAPI.TirarKit(p);
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKit(p, "Challenge");
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short)0));
				Updater.UpdateScore(p);
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você ganhou 20 Coins");
		}
			}

	    }
}
