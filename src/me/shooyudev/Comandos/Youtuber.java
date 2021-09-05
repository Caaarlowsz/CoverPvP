package me.shooyudev.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Youtuber extends Manager{

	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player)sender;

		
		if (command.getName().equalsIgnoreCase("youtuber")) {
			if (argumentos.length == 0) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /youtuber <YT , YT+ , SEMIYT>");
				return;
			}
			if (argumentos.length == 1) {
			   if (argumentos[0].equalsIgnoreCase("yt")) {
				   p.sendMessage(" ");
				   p.sendMessage(ChatColor.GRAY + "Para se tornar um " + ChatColor.AQUA + ChatColor.BOLD + "YOUTUBER" + ChatColor.GRAY + " do servidor .");
				   p.sendMessage(ChatColor.GRAY + "Você precisa ter pelo menos 500 Subs !");
				   p.sendMessage(ChatColor.GRAY + "E Tambem ter 50 likes em nosso video !");
				   p.sendMessage(" ");
				   p.sendMessage(ChatColor.GRAY + "INFO: " + ChatColor.GRAY + "Mande seu video para um cargo superior que " + ChatColor.DARK_PURPLE + "MOD" + ChatColor.GRAY + "!");
				   p.sendMessage(" ");
				   return;
			   }
			   if (argumentos[0].equalsIgnoreCase("yt+")) {
				   p.sendMessage(" ");
				   p.sendMessage(ChatColor.GRAY + "Para se tornar um " + ChatColor.DARK_AQUA + ChatColor.BOLD + "YOUTUBER+" + ChatColor.GRAY + " do servidor .");
				   p.sendMessage(ChatColor.GRAY + "Você precisa ter pelo menos 1k Subs !");
				   p.sendMessage(ChatColor.GRAY + "E Tambem ter 80 likes em nosso video !");
				   p.sendMessage(" ");
				   p.sendMessage(ChatColor.GRAY + "INFO: " + ChatColor.GRAY + "Mande seu video para um cargo superior que " + ChatColor.DARK_PURPLE + "MOD" + ChatColor.GRAY + "!");
				   p.sendMessage(" ");
				   return;
			   }
			   if (argumentos[0].equalsIgnoreCase("semiyt")) {
				   p.sendMessage(" ");
				   p.sendMessage(ChatColor.GRAY + "Para se tornar um " + ChatColor.GOLD + ChatColor.BOLD + "SEMI-YT" + ChatColor.GRAY + " do servidor .");
				   p.sendMessage(ChatColor.GRAY + "Você precisa ter pelo menos 300 Subs !");
				   p.sendMessage(ChatColor.GRAY + "E Tambem ter 35 likes em seu video !");
				   p.sendMessage(" ");
				   p.sendMessage(ChatColor.GRAY + "INFO: " + ChatColor.GRAY + "Mande seu video para um cargo superior que " + ChatColor.DARK_PURPLE + "MOD" + ChatColor.GRAY + "!");
				   p.sendMessage(" ");
				   return;
			   }
			}
		}
	}

}
