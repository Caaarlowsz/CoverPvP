package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import me.shooyudev.Utills.Strings;

public class Manutençao implements Listener, CommandExecutor {

	public static boolean manutencao = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("manutencao")) {
			if (!sender.hasPermission("cover.manute�ao")) {
				p.sendMessage(Strings.permissaocomando);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "/manutencao <on , off>");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					if ((manutencao)) {
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O Servidor ja esta em manutencao !");
						return true;
					} else {
						Bukkit.broadcastMessage(
								Strings.servidormensagem + ChatColor.GRAY + "O Servidor esta entrando em "
										+ ChatColor.YELLOW + ChatColor.BOLD + "manutencao" + ChatColor.GRAY + "!");
						manutencao = true;
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "manutencao esta sendo ativada ..");
						p.sendMessage(
								Strings.servidormensagem + ChatColor.GRAY + "A Manute�ao foi ativada com sucesso !");
						for (Player todos : Bukkit.getOnlinePlayers()) {
							if (!(sender.hasPermission("cover.manutencao"))) {
								todos.kickPlayer(Strings.servidor + "\n" + "\n"
										+ "   �7O servidor acabou de entrar em manutencao" + "\n"
										+ "Assim que poss�vel, n�s estaremos de volta!");
								return true;
							}
						}
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("on")) {
					if (manutencao) {
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O Servidor ja esta em manutencao !");
						return true;
					} else {
						Bukkit.broadcastMessage(
								Strings.servidormensagem + ChatColor.GRAY + "O Servidor esta entrando em "
										+ ChatColor.YELLOW + ChatColor.BOLD + "manutencao" + ChatColor.GRAY + "!");
						manutencao = true;
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "manutencao esta sendo ativada ..");
						p.sendMessage(
								Strings.servidormensagem + ChatColor.GRAY + "A Manute�ao foi ativada com sucesso !");
						for (Player todos : Bukkit.getOnlinePlayers()) {
							if (!sender.hasPermission("cover.manutencao")) {
								todos.kickPlayer(Strings.servidormensagem + "\n" + "\n"
										+ "   �7O servidor acabou de entrar em manutencao" + "\n"
										+ "Assim que poss�vel, n�s estaremos de volta!" + "\n" + "\n"
										+ "�7Atenciosamente, " + Strings.servidormensagem);
								return true;
							}
						}
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("off")) {
					if (!(manutencao)) {
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O Servidor N�o Est� em manutencao!");
						return true;
					} else {
						manutencao = false;
						p.sendMessage("Manuten��o Desativada!");
						p.sendMessage("Voce desativou a Manuten��o!");
						return true;
					}
				}
			}
		}
		return false;
	}

	@EventHandler
	public void aoEntrarManutencao(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if ((manutencao) && (!(p.hasPermission("cover.entrarmanute�ao")))) {
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					Strings.servidor + "\n" + "\n" + "   �7O servidor acabou de entrar em manutencao" + "\n"
							+ "Assim que poss�vel, n�s estaremos de volta!" + "\n" + "\n" + "�7Atenciosamente, "
							+ Strings.servidormensagem);
		}
	}

}
