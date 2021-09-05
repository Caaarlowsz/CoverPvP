package me.shooyudev.Bans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Bans.Events.API;
import me.shooyudev.Utills.Strings;

public class Kick implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (!jogador.hasPermission("cover.bans")) {
				API.sendMsg(jogador, Strings.permissaocomando);
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/kick <jogador> <motivo>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, Strings.playeroffiline);
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName().equals("TranquilliYT")) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você esta bloqueado de Kickar o "
						+ ChatColor.DARK_RED + ChatColor.BOLD + "DONO" + ChatColor.DARK_RED + " TranquilliYT");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName().equals("TranquilliYT")) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você esta bloqueado de Kickar o "
						+ ChatColor.DARK_RED + ChatColor.BOLD + "DONO" + ChatColor.DARK_RED + " TranquilliYT");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§cVocê não pode kikar a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args.length == 1) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/kick <jogador> <motivo>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			API.sendMsg(jogador, ChatColor.GRAY + "Você kickou o jogador " + ChatColor.YELLOW + ChatColor.BOLD
					+ vitima.getName() + "§f.");
			API.sendStaff(ChatColor.GRAY + "O Staff " + ChatColor.YELLOW + ChatColor.BOLD + jogador.getName()
					+ ChatColor.GRAY + " kickou o jogador " + ChatColor.GOLD + ChatColor.BOLD + vitima.getName()
					+ ". Motivo: " + ChatColor.GOLD + ChatColor.BOLD + Motivo);
			vitima.kickPlayer("§7Você foi Kickado do servidor!" + "\n" + "\n" + "§7kickado: " + ChatColor.GOLD
					+ ChatColor.BOLD + vitima.getName() + "\n" + "§7Staff: " + ChatColor.GOLD + ChatColor.BOLD
					+ jogador.getName() + "\n" + "§7Motivo: " + ChatColor.GOLD + ChatColor.BOLD + Motivo);
			return true;
		}
		return false;
	}
}
