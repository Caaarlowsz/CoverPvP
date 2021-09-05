package me.shooyudev.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Conectado extends Manager{
	
	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player)sender;
		
		if (command.getName().equalsIgnoreCase("ip")) {
			p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce esta conectado no ip: " + ChatColor.YELLOW + "" + ChatColor.BOLD + "arkuzmc.mcbr.com.br");
			return;
		}
	}

}
