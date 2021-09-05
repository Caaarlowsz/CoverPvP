package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Utills.Strings;

public class Desabilitar implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] argumentos) {
		Player p = (Player) sender;

		if (command.getName().equalsIgnoreCase("desabilitar")) {
			if (!p.hasPermission("cover.desabilitar")) {
				p.sendMessage(Strings.permissaocomando);
				return true;
			}
			if (argumentos.length == 0) {
				p.sendMessage(ChatColor.GRAY + "Use /desabilitar <VIP , PRO, MVP, FULLKIT>");
				return true;
			}
			if (argumentos[0].equalsIgnoreCase("fullkit")) {

				if (!Habilitar.fullkit) {
					p.sendMessage(ChatColor.RED + "O Fullkit nao esta Habilitado !");
				} else {
					p.sendMessage(ChatColor.GRAY + "Voce removeu o fullkit para todos !");
					Bukkit.broadcastMessage(ChatColor.GRAY + "O Beneficio " + ChatColor.GOLD + "[" + ChatColor.YELLOW
							+ ChatColor.BOLD + " FULLKIT " + ChatColor.GOLD + "]" + ChatColor.GRAY
							+ " foi removido para todos !");
					Habilitar.fullkit = false;
					return true;
				}
			}
			if (argumentos[0].equalsIgnoreCase("vip")) {
				if (!Habilitar.vip) {
					p.sendMessage(ChatColor.RED + "O Vip nao esta Habilitado");
					return true;
				} else {
					p.sendMessage(ChatColor.GREEN + "Você desabilitou o FullKit para todos .");
					Bukkit.broadcastMessage(ChatColor.YELLOW + "O Vip Foi desabilitado para todos !");
					Habilitar.vip = false;
					return true;
				}
			}
			if (argumentos[0].equalsIgnoreCase("pro")) {
				if (!Habilitar.pro) {
					p.sendMessage(ChatColor.RED + "O Pro nao esta Habilitado");
					return true;
				} else {
					p.sendMessage(ChatColor.GREEN + "Você desabilitou o FullKit para todos .");
					Bukkit.broadcastMessage(ChatColor.YELLOW + "O Pro Foi desabilitado para todos !");
					Habilitar.pro = false;
					return true;
				}
			}
			if (argumentos[0].equalsIgnoreCase("mvp")) {
				if (!Habilitar.mvp) {
					p.sendMessage(ChatColor.RED + "O Mvp nao esta Habilitado");
					return true;
				} else {
					p.sendMessage(ChatColor.GREEN + "Você desabilitou o Mvp para todos .");
					Bukkit.broadcastMessage(ChatColor.YELLOW + "O Mvp Foi desabilitado para todos !");
					Habilitar.mvp = false;
					return true;
				}
			}
			if (argumentos.length == 0) {
				p.sendMessage(ChatColor.GRAY + "Use /desabilitar <VIP , PRO, MVP, FULLKIT>");
				return true;
			}
		}

		return false;
	}
}
