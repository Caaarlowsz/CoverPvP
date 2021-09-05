package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.API.StatsManager;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Account extends Manager{
	
	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player)sender;
		
		if(command.getName().equalsIgnoreCase("account") || command.getName().equalsIgnoreCase("acc")) {
			if (argumentos.length == 0) {
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "UUID da sua conta: " + ChatColor.YELLOW + p.getUniqueId());
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "Nick: " + ChatColor.YELLOW + p.getName());
				p.sendMessage(ChatColor.GRAY + "Grupo: " + ChatColor.YELLOW + GrupoJoin(p));
				p.sendMessage(ChatColor.GRAY + "Rank:  " + ChatColor.YELLOW + RankAndPrefix(p));
				p.sendMessage(ChatColor.GRAY + "Xp:  " + ChatColor.YELLOW + StatsManager.getXp(p));
				p.sendMessage(ChatColor.GRAY + "Coins:  " + ChatColor.YELLOW + StatsManager.getCoins(p));
				p.sendMessage(" ");
			}
			if (argumentos.length == 1) {
				Player player = Bukkit.getPlayer(argumentos[0]);
				if (player == null) {
					p.sendMessage(Strings.playeroffiline);
					return;
				}
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "UUID da sua conta: " + ChatColor.YELLOW + player.getUniqueId());
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "Nick: " + ChatColor.YELLOW + player.getName());
				p.sendMessage(ChatColor.GRAY + "Grupo: " + ChatColor.YELLOW + GrupoJoin(player));
				p.sendMessage(ChatColor.GRAY + "Rank:  " + ChatColor.YELLOW + RankAndPrefix(player));
				p.sendMessage(ChatColor.GRAY + "Xp:  " + ChatColor.YELLOW + StatsManager.getXp(player));
				p.sendMessage(ChatColor.GRAY + "Coins:  " + ChatColor.YELLOW + StatsManager.getCoins(player));
				p.sendMessage(" ");
			}
		}
		
	}

}
