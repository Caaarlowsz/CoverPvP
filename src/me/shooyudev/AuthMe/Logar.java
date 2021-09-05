package me.shooyudev.AuthMe;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Main;
import me.shooyudev.API.API;
import me.shooyudev.Configs.AuthConfig;
import me.shooyudev.Utills.Strings;

public class Logar implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		if (cmd.getName().equalsIgnoreCase("login")) {
			Player p = (Player) sender;
			if (arg3.length == 1) {
				if (arg3[0].equalsIgnoreCase((String) AuthConfig.getConfig().config()
						.get("Login." + p.getName().toLowerCase() + ".senha"))) {
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você foi logado !");
					Main.login.remove(p.getName());
					for (int i = 1; i < 100; i++) {
						p.sendMessage(" ");
					}
					p.sendMessage(ChatColor.GREEN + "Bem-vindo ao servidor " + ChatColor.YELLOW + p.getName());
					p.sendMessage(ChatColor.GREEN + "O servidor se encontra em fase Beta ,");
					p.sendMessage(ChatColor.GREEN + "Se Ocorrer um Bug , Caso vc ache bugs Reporte ,");
					p.sendMessage(ChatColor.GREEN + "Aproveite o servidor ! " + ChatColor.YELLOW + p.getName());
					API.itensSpawn(p);
					return true;
				}
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY
						+ "Essa senha nao foi encontrada , em nosso banco de dados .");
			}
		}
		return false;
	}
}
