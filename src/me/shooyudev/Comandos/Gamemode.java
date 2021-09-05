package me.shooyudev.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Gamemode extends Manager{
	
	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player)sender;
		
		if (p.hasPermission("cover.gamemode")) {
			if (argumentos.length == 0) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /gm <1 , 0> ou /gamemode <1 , 0>");
				return;
			   }
				if (command.getName().equalsIgnoreCase("gm")) {
				if (argumentos[0].equalsIgnoreCase("1")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(ChatColor.GREEN + "O Seu gamemode foi alterado para Creative");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("0")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(ChatColor.RED + "O Seu gamemode foi alterado para Survival");
					return;
				}
			}
			} else {
				p.sendMessage(Strings.permissaocomando);
			}
		}
		
	}
