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
public class GroupVip implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("groupvip")) {
			if (!(sender.hasPermission("cover.groupvip"))) {
				sender.sendMessage(Strings.permissaocomando);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /groupvip <player> <vip>");
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
				if (vipgroup.equalsIgnoreCase("vip")) {
					p.sendMessage("");
					p.sendMessage(ChatColor.YELLOW + "O Vip " + ChatColor.GRAY + "[ " + ChatColor.GREEN + ChatColor.BOLD + "VIP" + ChatColor.GRAY + " ] " + ChatColor.YELLOW + "Foi dado ao Jogador " + jogador.getName() + ChatColor.YELLOW +"[" + jogador.getUniqueId() + "]");
					p.sendMessage("");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Vip");
					jogador.setDisplayName("§a§lVIP §a" + jogador.getName());
					NametagAPI.setPrefix(jogador.getName(), "§a§lVIP §a");
					NametagAPI.setSuffix(jogador.getName(), "§7 " + ChatColor.GRAY +"[" + Manager.prefix(jogador) + ChatColor.GRAY + "]");
					Updater.UpdateScore(p);
					return true;
				}
				if (vipgroup.equalsIgnoreCase("pro")) {
					p.sendMessage("");
					p.sendMessage(ChatColor.YELLOW + "O Vip " + ChatColor.GRAY + "[ " + ChatColor.GOLD + ChatColor.BOLD + "PRO" + ChatColor.GRAY + " ] " + ChatColor.YELLOW + "Foi dado ao Jogador " + jogador.getName() + ChatColor.YELLOW +"[" + jogador.getUniqueId() + "]");
					p.sendMessage("");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Pro");
					jogador.setDisplayName("§6§lPRO §6" + jogador.getName());
					NametagAPI.setPrefix(jogador.getName(), "§6§lPRO §6");
					NametagAPI.setSuffix(jogador.getName(), "§7 " + ChatColor.GRAY +"[" + Manager.prefix(jogador) + ChatColor.GRAY + "]");
					Updater.UpdateScore(p);
					return true;
				}
				if (vipgroup.equalsIgnoreCase("mvp")) {
					p.sendMessage("");
					p.sendMessage(ChatColor.YELLOW + "O Vip " + ChatColor.GRAY + "[ " + ChatColor.BLUE + ChatColor.BOLD +  "MVP" + ChatColor.GRAY + " ] " + ChatColor.YELLOW + "Foi dado ao Jogador " + jogador.getName() + ChatColor.YELLOW +"[" + jogador.getUniqueId() + "]");
					p.sendMessage("");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Mvp");
					jogador.setDisplayName("§9§lMVP §9" + jogador.getName());
					NametagAPI.setPrefix(jogador.getName(), "§9§lMVP §9");
					NametagAPI.setSuffix(jogador.getName(), "§7 " + ChatColor.GRAY +"[" + Manager.prefix(jogador) + ChatColor.GRAY + "]");
					Updater.UpdateScore(p);
					return true;
				}
			}
		}
		
		return false;
	}
	

}
