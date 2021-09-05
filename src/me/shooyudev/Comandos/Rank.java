package me.shooyudev.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Manager.Manager;

public class Rank extends Manager {

	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player) sender;

		if (command.getName().equalsIgnoreCase("rank")) {
			if (argumentos.length == 0) {
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "✶" + ChatColor.GRAY + "]" + ChatColor.AQUA
						+ " Legendary");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_RED + "✹" + ChatColor.GRAY + "]"
						+ ChatColor.DARK_RED + " Supreme");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "�?�" + ChatColor.GRAY + "]"
						+ ChatColor.LIGHT_PURPLE + " Safira");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "✸" + ChatColor.GRAY + "]"
						+ ChatColor.DARK_PURPLE + " Elite");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + "✠" + ChatColor.GRAY + "]"
						+ ChatColor.DARK_GREEN + " Emerald");
				p.sendMessage(
						ChatColor.GRAY + "[" + ChatColor.GOLD + "✶" + ChatColor.GRAY + "]" + ChatColor.GOLD + " Gold");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "�?�" + ChatColor.GRAY + "]" + ChatColor.BLUE
						+ " Experient");
				p.sendMessage(
						ChatColor.GRAY + "[" + ChatColor.RED + "✰" + ChatColor.GRAY + "]" + ChatColor.RED + " Ruby");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "☷" + ChatColor.GRAY + "]"
						+ ChatColor.DARK_AQUA + " Expert");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.YELLOW + "☴" + ChatColor.GRAY + "]" + ChatColor.YELLOW
						+ " Starter");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "☰" + ChatColor.GRAY + "]" + ChatColor.GREEN
						+ " Apprentice");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.WHITE + "�?" + ChatColor.GRAY + "]" + ChatColor.WHITE
						+ " Ranked");
				p.sendMessage(ChatColor.GRAY + "[" + ChatColor.WHITE + "⚊" + ChatColor.GRAY + "]" + ChatColor.WHITE
						+ " Unranked");
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GREEN
						+ "Esse é o nosso sistema de Rank , você upará com xps , para conseguir esses Xps voçês terao que matar os jogadores , boa sorte !");
				p.sendMessage(" ");
				p.sendMessage(ChatColor.YELLOW + "Rank atual: " + Manager.RankAndPrefix(p));
				p.sendMessage(Manager.ProximoRank(p));
				p.sendMessage(Manager.ProximoPorXp(p));
			}
		}

	}
}
