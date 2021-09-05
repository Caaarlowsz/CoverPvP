package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Utills.Strings;

public class Habilitar implements CommandExecutor{

	public static boolean fullkit;
	public static boolean vip;
	public static boolean pro;
	public static boolean mvp;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] argumentos) {
			Player p = (Player)sender;
			
			if (command.getName().equalsIgnoreCase("habilitar")) {
				if (!p.hasPermission("cover.habilitar")) {
					p.sendMessage(Strings.permissaocomando);
					return true;
				}
				if (argumentos.length == 0) {
					p.sendMessage(ChatColor.GRAY + "Use /habilitar <VIP , PRO, MVP, FULLKIT>");
					return true;
				}
				if (argumentos[0].equalsIgnoreCase("fullkit")) {
					if (fullkit) {
						p.sendMessage(ChatColor.RED + "O FullKit ja esta habilitado");
						return true;
					} else {
						p.sendMessage(ChatColor.GREEN + "Você habilitou o FullKit para todos .");
						Bukkit.broadcastMessage(ChatColor.YELLOW + "O FullKit Foi habilitado para todos , Aproveitem ..");
						fullkit = true;
						return true;
					}
				}
				if (argumentos[0].equalsIgnoreCase("vip")) {
					if (vip) {
						p.sendMessage(ChatColor.RED + "O Vip ja esta habilitado.");
						return true;
					} else {
						p.sendMessage(ChatColor.GREEN + "Você habilitou o Vip para todos .");
						Bukkit.broadcastMessage(ChatColor.YELLOW + "O Vip Foi habilitado para todos , Aproveitem ..");
						vip = true;
						return true;
					}
				}
				if (argumentos[0].equalsIgnoreCase("pro")) {
					if (pro) {
						p.sendMessage(ChatColor.RED + "O Pro ja esta habilitado.");
						return true;
					} else {
						p.sendMessage(ChatColor.GREEN + "Você habilitou o FullKit para todos .");
						Bukkit.broadcastMessage(ChatColor.YELLOW + "O Pro Foi habilitado para todos , Aproveitem ..");
						pro = true;
						return true;
					}
				}
				if (argumentos[0].equalsIgnoreCase("mvp")) {
					if (mvp) {
						p.sendMessage(ChatColor.RED + "O Mvp ja esta habilitado.");
						return true;
					} else {
						p.sendMessage(ChatColor.GREEN + "Você habilitou o Mvp para todos .");
						Bukkit.broadcastMessage(ChatColor.YELLOW + "O Mvp Foi habilitado para todos , Aproveitem ..");
						mvp = true;
						return true;
					}
				}
				if (argumentos.length == 0) {
					p.sendMessage(ChatColor.GRAY + "Use /habilitar <VIP , PRO, MVP, FULLKIT>");
					return true;
			}
		}
		
		return false;
	}
}
