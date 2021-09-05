package me.shooyudev.Bans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Bans.Events.API;
import me.shooyudev.Bans.Events.Config;
import me.shooyudev.Utills.Strings;

public class Unban implements CommandExecutor {

	private static String ip(OfflinePlayer vitima) {
		return (String) Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId() + ".IP do Jogador");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("unban")) {
			if (!jogador.hasPermission("cover.bans")) {
				API.sendMsg(jogador, Strings.permissaocomando);
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador,
						Strings.servidormensagem + ChatColor.GRAY + "/unban <Ban , Ipban , Mute , > [jogador]");
				return true;
			}
			if (args[0].equalsIgnoreCase("ban")) {
				if (args.length == 1) {
					API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/unban <Ban> [jogador]");
					return true;
				}
				OfflinePlayer vitima = Bukkit.getOfflinePlayer(args[1]);
				if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador,
							Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW + ChatColor.BOLD
									+ vitima.getName() + ChatColor.GRAY + " não está " + ChatColor.YELLOW
									+ ChatColor.BOLD + "Banido §7.");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Player " + ChatColor.YELLOW
							+ ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + " Foi desbanido pelo: §6§lCONSOLE");
				} else {
					API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você desbaniu o jogador: "
							+ ChatColor.YELLOW + ChatColor.BOLD + vitima.getName());
					API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Staff " + ChatColor.YELLOW
							+ ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " desbaniu o jogador: "
							+ ChatColor.YELLOW + ChatColor.BOLD + vitima.getName());
				}
				double l = Config.getConfig().getBans().getDouble("Players Banidos");
				Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l - 1.0D));
				Config.getConfig().getBans().set("Bans." + vitima.getUniqueId(), null);
				Config.getConfig().saveBans();
				return true;
			}
			if (args[0].equalsIgnoreCase("ipban")) {
				if (args.length == 1) {
					API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/unban <ipBan> [jogador]");
					return true;
				}
				OfflinePlayer vitima = Bukkit.getOfflinePlayer(args[1]);
				if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador,
							Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW + ChatColor.BOLD
									+ vitima.getName() + ChatColor.GRAY + " não está " + ChatColor.YELLOW
									+ ChatColor.BOLD + "Banido (ip)§7.");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Player " + ChatColor.YELLOW
							+ ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + " Foi desbanido pelo: §6§lCONSOLE");
				} else {
					API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você desbaniu o jogador: "
							+ ChatColor.YELLOW + ChatColor.BOLD + vitima.getName());
					API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Staff " + ChatColor.YELLOW
							+ ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " desbaniu (ip) o jogador: "
							+ ChatColor.YELLOW + ChatColor.BOLD + vitima.getName());
				}
				Bukkit.unbanIP(ip(vitima));
				Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId(), null);
				Config.getConfig().saveIpBans();
				return true;
			}
			if (args[0].equalsIgnoreCase("mute")) {
				if (args.length == 1) {
					API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/unban <Mute> [jogador]");
					return true;
				}
				Player vitima = Bukkit.getPlayer(args[1]);
				if (vitima == null) {
					OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[1]);
					if (Config.getConfig().getMute().get("Mute." + vitimaoff.getUniqueId()) == null) {
						API.sendMsg(jogador,
								Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW
										+ ChatColor.BOLD + vitimaoff.getName() + ChatColor.GRAY + " não está "
										+ ChatColor.YELLOW + ChatColor.BOLD + "Mutado§7 .");
						return true;
					}
					if (!(sender instanceof Player)) {
						API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Console Desmutou o"
								+ ChatColor.YELLOW + ChatColor.BOLD + vitimaoff.getName());
					} else {
						API.sendMsg(jogador, "Você desmutou o jogador: " + vitimaoff.getName());
						API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Staff " + ChatColor.YELLOW
								+ ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " desmutou o jogador: "
								+ ChatColor.YELLOW + ChatColor.BOLD + vitimaoff.getName());
					}
					Config.getConfig().getMute().set("Mute." + vitimaoff.getUniqueId(), null);
					Config.getConfig().saveMute();
					return true;
				}
				if (Config.getConfig().getMute().get("Mute." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador,
							Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW + ChatColor.BOLD
									+ vitima.getName() + ChatColor.GRAY + " não está " + ChatColor.YELLOW
									+ ChatColor.BOLD + "Mutado§7 .");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Console Desmutou o" + ChatColor.YELLOW
							+ ChatColor.BOLD + vitima.getName());
				} else {
					API.sendMsg(jogador, "Você desmutou o jogador: " + vitima.getName());
					API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Staff " + ChatColor.YELLOW
							+ ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " desmutou o jogador: "
							+ ChatColor.YELLOW + ChatColor.BOLD + vitima.getName());
				}
				Config.getConfig().getMute().set("Mute." + vitima.getUniqueId(), null);
				Config.getConfig().saveMute();
				return true;
			}
			API.sendMsg(jogador,
					Strings.servidormensagem + ChatColor.GRAY + "/unban <Ban , Ipban , Mute , > [jogador]");
			return true;
		}
		return false;
	}
}
