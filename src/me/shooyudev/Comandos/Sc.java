package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Sc implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Voce precisa ser um player !");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("sc")) {
			if (args.length == 0) {
				sender.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /sc <mensagem>");
			}
			if (args.length > 0) {
				Player p = (Player) sender;
				StringBuilder string = new StringBuilder();
				for (int i = 0; i < args.length; i++) {
					string.append(args[i] + " ");
				}
				String mensagem = string.toString();
				Player[] arrayOfPlayer;
				int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
				for (int i = 0; i < j; i++) {
					Player staff = arrayOfPlayer[i];
					if (!sender.hasPermission("cover.staffchat")) {
						sender.sendMessage(Strings.permissaocomando);
						return true;
					}
					if (staff.hasPermission("cover.staffchat")) {
						staff.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + ChatColor.BOLD + "StaffChat"
								+ ChatColor.GRAY + "] " + p.getDisplayName() + ChatColor.GRAY + " ("
								+ Manager.prefix(staff) + ChatColor.GRAY + ")" + ChatColor.WHITE + " » §7" + mensagem);
					}
				}
			}
		}
		return false;
	}
}
