package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.shooyudev.Manager.Manager;

public class Ping extends Manager{
	
	
	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		if(command.getName().equalsIgnoreCase("ping")) {
			Player p = (Player)sender;
			if((sender instanceof Player)) {
				int ping = ((CraftPlayer)p).getHandle().ping;
				if(argumentos.length == 0) {
					p.sendMessage(ChatColor.GREEN + "Seu ping atual é: " + ping + " ms");
					return;
				}
				if(argumentos.length == 1) {
					Player k = Bukkit.getPlayer(argumentos[0]);
					if(k == null) {
						p.sendMessage(ChatColor.RED + "Esse jogador se encontra Offiline !");
						return;
					}
					int ping2 = ((CraftPlayer)k).getHandle().ping;
					p.sendMessage(ChatColor.GREEN + "Ping atual de " + k.getName() + " é: " + ping2 + " ms");
					return;
				}
			}
		}
	}
}
