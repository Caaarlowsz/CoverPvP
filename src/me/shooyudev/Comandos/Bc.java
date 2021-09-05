package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Bc extends Manager {

	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player) sender;
		if (p.hasPermission("cover.bc")) {
			if (command.getName().equalsIgnoreCase("bc")
					|| (command.getName().equalsIgnoreCase("broadcast")) && (p.hasPermission("cover.bc"))) {
				if (argumentos.length >= 1) {
					String bcast = "";
					for (int x = 0; x < argumentos.length; x++) {
						bcast = bcast + argumentos[x] + " ";
					}
					bcast = ChatColor.translateAlternateColorCodes('§', bcast).replaceAll("&", "§");
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "BROADCAST " + ChatColor.WHITE
							+ "» " + ChatColor.GRAY + bcast);
				} else {
					sender.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /bc ou /broadcast <aviso>");
				}
			}
		} else {
			p.sendMessage(Strings.permissaocomando);
		}
	}

}
