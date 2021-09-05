package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ca.wacos.nametagedit.NametagAPI;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;
import me.shooyudev.scoreboarding.Updater;

public class GroupSet implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("groupset")) {
				if (!(sender.hasPermission("cover.groupset"))) {
					sender.sendMessage(Strings.permissaocomando);
					return true;
				}
				if (args.length == 1) {

				}
				if (args.length == 2) {
					Player playe = Bukkit.getPlayer(args[0]);
					if (playe == null) {
						p.sendMessage(Strings.playeroffiline);
						return true;
					}
					String grupo = args[1];
					Player player = Bukkit.getPlayer(args[0]);
					if (grupo.equalsIgnoreCase("normal")) {
						p.sendMessage(
								"§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Normal");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Default");
						player.setDisplayName("§7" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§7");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("vip")) {
						p.sendMessage("§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Vip");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Vip");
						player.setDisplayName("§a§lVIP §a" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§a§lVIP §a");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("pro")) {
						p.sendMessage("§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Pro");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Pro");
						player.setDisplayName("§6§lPRO §6" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§6§lPRO §6");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("mvp")) {
						p.sendMessage("§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Mvp");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Mvp");
						player.setDisplayName("§9§lMVP §9" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§9§lMVP §9");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
					}
					if (grupo.equalsIgnoreCase("youtuber")) {
						p.sendMessage(
								"§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Youtuber");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Youtuber");
						player.setDisplayName("§b§lYT §b" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§b§lYT §b");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("youtuber+")) {
						p.sendMessage(
								"§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Youtuber+");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Youtuber+");
						player.setDisplayName("§3§lYT+ §3" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§3§lYT+ §3");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("builder")) {
						p.sendMessage(
								"§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Builder");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Builder");
						player.setDisplayName("§e§lBUILDER §e" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§e§lBUILDER §e");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("builder+")) {
						p.sendMessage(
								"§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Builder+");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Builder+");
						player.setDisplayName("§e§lBUILDER+ §e" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§e§lBUILDER+ §e");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("helper")) {
						p.sendMessage(
								"§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Helper");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Helper");
						player.setDisplayName("§9§lHELPER §9" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§9§lHELPER §9");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("trial")) {
						p.sendMessage("§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Trial");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Trial");
						player.setDisplayName("§5§lTRIAL §5" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§5§lTRIAL §5");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("mod")) {
						p.sendMessage("§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Mod");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Mod");
						player.setDisplayName("§5§lMOD §5" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§5§lMOD §5");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("mod+")) {
						p.sendMessage("§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Mod+");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Mod+");
						player.chat("/tag mod+");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("gerente")) {
						p.sendMessage(
								"§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Gerente");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Gerente");
						player.setDisplayName("§c§lGERENTE §c" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§c§lGERENTE §c");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("admin")) {
						p.sendMessage("§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Admin");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Admin");
						player.setDisplayName("§c§lADMIN §c" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§c§lADMIN §c");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
					if (grupo.equalsIgnoreCase("dono")) {
						p.sendMessage("§7§lO Player " + ChatColor.YELLOW + player.getName() + " §7Alterado para Dono");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"pex user " + player.getName() + " group set Dono");
						player.setDisplayName("§4§lDONO §4" + player.getName());
						NametagAPI.setPrefix(player.getName(), "§4§lDONO §4");
						NametagAPI.setSuffix(player.getName(),
								"§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
						Updater.UpdateScore(player);
						return true;
					}
				}
			} else {
				sender.sendMessage(Strings.servidormensagem + "§7Use /groupset <nick> <grupo> §7!");
				return true;
			}
		}
		return false;
	}
}
