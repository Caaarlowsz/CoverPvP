package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ca.wacos.nametagedit.NametagAPI;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;
import me.shooyudev.scoreboarding.Updater;

public class GroupYoutuber implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("groupyoutuber")) {
			if (!(sender.hasPermission("cover.groupyoutuber"))) {
				sender.sendMessage(Strings.permissaocomando);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /groupyoutuber <player> <semiyt, youtuber, youtuber+>");
				return true;
			}
			if (args.length == 1) {
				
			}
			if (args.length == 2) {
				Player playe = Bukkit.getPlayer(args[0]);
				if (playe == null) {
					p.sendMessage(Strings.playeroffiline);
					return true;
				}

				String vipgroup = args[1];
				Player jogador = Bukkit.getPlayer(args[0]);
				if (vipgroup.equalsIgnoreCase("semiyt")) {
					p.sendMessage("");
					p.sendMessage(ChatColor.YELLOW + "Você setou " + ChatColor.GRAY + "[ " + ChatColor.YELLOW + ChatColor.BOLD +  "SEMIYT" + ChatColor.GRAY + " ] " + ChatColor.YELLOW + "Foi dado ao Jogador " + jogador.getName() + ChatColor.YELLOW + "[" + jogador.getUniqueId() + "]");
					p.sendMessage("");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Semiyt");
					jogador.setDisplayName("§e§lSEMIYT §e" + jogador.getName());
					NametagAPI.setPrefix(jogador.getName(), "§e§lSEMIYT §e");
					NametagAPI.setSuffix(jogador.getName(), "§7 " + ChatColor.GRAY +"[" + Manager.prefix(jogador) + ChatColor.GRAY + "]");
					Updater.UpdateScore(jogador);
					return true;
				}
				if (vipgroup.equalsIgnoreCase("youtuber")) {
					p.sendMessage("");
					p.sendMessage(ChatColor.YELLOW + "O Youtuber " + ChatColor.GRAY + "[ " + ChatColor.AQUA + ChatColor.BOLD +  "YOUTUBER" + ChatColor.GRAY + " ] " + ChatColor.YELLOW + "Foi dado ao Jogador " + jogador.getName() + ChatColor.YELLOW + "[" + jogador.getUniqueId() + "]");
					p.sendMessage("");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Youtuber");
					jogador.setDisplayName("§b§lYT §b" + jogador.getName());
					NametagAPI.setPrefix(jogador.getName(), "§b§lYT §b");
					NametagAPI.setSuffix(jogador.getName(), "§7 " + ChatColor.GRAY +"[" + Manager.prefix(jogador) + ChatColor.GRAY + "]");
					Updater.UpdateScore(jogador);
					return true;
				}
				if (vipgroup.equalsIgnoreCase("youtuber+")) {
					p.sendMessage("");
					p.sendMessage(ChatColor.YELLOW + "O Youtuber " + ChatColor.GRAY + "[ " + ChatColor.DARK_AQUA + ChatColor.BOLD +  "YOUTUBER+" + ChatColor.GRAY + " ] " + ChatColor.YELLOW + "Foi dado ao Jogador " + jogador.getName() + ChatColor.YELLOW + "[" + jogador.getUniqueId() + "]");
					p.sendMessage("");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Youtuber+");
					jogador.setDisplayName("§3§lYT+ §3" + jogador.getName());
					NametagAPI.setPrefix(jogador.getName(), "§3§lYT+ §3");
					NametagAPI.setSuffix(jogador.getName(), "§7 " + ChatColor.GRAY +"[" + Manager.prefix(jogador) + ChatColor.GRAY + "]");
					Updater.UpdateScore(jogador);
					return true;
				}
			}
		}
		
		return false;
	}

}
