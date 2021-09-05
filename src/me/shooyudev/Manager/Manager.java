 package me.shooyudev.Manager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.shooyudev.API.StatsManager;
import me.shooyudev.Comandos.Habilitar;

public abstract class Manager implements Listener , CommandExecutor {
	
	 public static String Rank(Player p) {
			double rank = StatsManager.getXp(p);
			if (rank <= 70) {
				return ChatColor.WHITE + "Unranked";
			}
			if (rank <= 120) {
				return ChatColor.WHITE + "Ranked";
			}
			if (rank <= 190) {

				return ChatColor.GREEN + "Apprentice";
			}
			if (rank <= 240) {

				return ChatColor.YELLOW +  "Starter";
			}
			if (rank <= 400) {

				return ChatColor.DARK_AQUA +  "Expert";
			}
			if (rank <= 540) {

				return ChatColor.RED +  "Ruby";
			}
			if (rank <= 670) {

				return ChatColor.BLUE +  "Experient";
			}
			if (rank <= 730) {

				return ChatColor.GOLD + "Gold";
			}
			if (rank <= 900) {

				return ChatColor.DARK_GREEN + "Emerald";
			}
			if (rank <= 1200) {

				return ChatColor.DARK_PURPLE + "Elite";
			}
			if (rank <= 1500) {

				return ChatColor.LIGHT_PURPLE + "Safira";
			}
			if (rank <= 1700) {

				return ChatColor.DARK_RED + "Supreme";
			}
			if (rank <= 2000) {

				return ChatColor.AQUA + "Legendary";
			}
			return ChatColor.AQUA + "Legendary";
	 }
	 public static String prefix(Player p) {
		 double prefix = StatsManager.getXp(p);
		 if (prefix <= 70) {

				return ChatColor.WHITE + "⚊";
			}
			if (prefix <= 120) {

				return ChatColor.WHITE + "�?";
			}
			if (prefix <= 190) {

				return ChatColor.GREEN + "☰";
			}
			if (prefix <= 240) {

				return ChatColor.YELLOW +  "☴";
			}
			if (prefix <= 400) {

				return ChatColor.DARK_AQUA +  "☷";
			}
			if (prefix <= 540) {

				return ChatColor.RED +  "✰";
			}
			if (prefix <= 670) {

				return ChatColor.BLUE +  "�?�";
			}
			if (prefix <= 730) {

				return ChatColor.GOLD + "✶";
			}
			if (prefix <= 900) {

				return ChatColor.DARK_GREEN + "✠";
			}
			if (prefix <= 1200) {

				return ChatColor.DARK_PURPLE + "✸";
			}
			if (prefix <= 1500) {

				return ChatColor.LIGHT_PURPLE + "�?�";
			}
			if (prefix <= 1700) {

				return ChatColor.DARK_RED + "✹";
			}
			if (prefix <= 2000) {

				return ChatColor.AQUA + "✶";
			}
			return ChatColor.AQUA + "✶";
	 }
	 
	 
	public static String RankAndPrefix(Player p) {
		double rankandprefix = StatsManager.getXp(p);
		if (rankandprefix <= 70) {

			return ChatColor.WHITE + "⚊ Unranked";
		}
		if (rankandprefix <= 120) {

			return ChatColor.WHITE + "�? Ranked";
		}
		if (rankandprefix <= 190) {

			return ChatColor.GREEN + "☰  Apprentice";
		}
		if (rankandprefix <= 240) {

			return ChatColor.YELLOW +  "☴  Starter";
		}
		if (rankandprefix <= 400) {

			return ChatColor.DARK_AQUA +  "☷ Expert";
		}
		if (rankandprefix <= 540) {

			return ChatColor.RED +  "✰ Ruby";
		}
		if (rankandprefix <= 670) {

			return ChatColor.BLUE +  "�?� Experient";
		}
		if (rankandprefix <= 730) {

			return ChatColor.GOLD + "✶ Gold";
		}
		if (rankandprefix <= 900) {

			return ChatColor.DARK_GREEN + "✠ Emerald";
		}
		if (rankandprefix <= 1200) {

			return ChatColor.DARK_PURPLE + "✸ Elite";
		}
		if (rankandprefix <= 1500) {

			return ChatColor.LIGHT_PURPLE + "�?� Safira";
		}
		if (rankandprefix <= 1700) {

			return ChatColor.DARK_RED + "✹ Supreme";
		}
		if (rankandprefix <= 2000) {

			return ChatColor.AQUA + "✶ Legendary";
		}
		return ChatColor.AQUA + "✶ Legendary";
	}
	public static String GrupoJoin(Player p) {
		if (p.hasPermission("join.dono")) {
			return ChatColor.DARK_RED + "" + ChatColor.BOLD + "DONO";
		}
		if (p.hasPermission("join.admin")) {
			return ChatColor.RED + "" + ChatColor.BOLD + "ADMIN";
		}
		if (p.hasPermission("join.gerente")) {
			return ChatColor.RED + "" + ChatColor.BOLD + "GERENTE";
		}
		if (p.hasPermission("join.developer")) {
			return ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "DEVELOPER";
		}
		if (p.hasPermission("join.mod+")) {
			return ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD+";
		}
		if (p.hasPermission("join.mod")) {
			return ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD";
		}
		if (p.hasPermission("join.trial")) {
			return ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "TRIAL";
		}
		if (p.hasPermission("join.helper")) {
			return ChatColor.BLUE + "" + ChatColor.BOLD + "HELPER";
		}
		if (p.hasPermission("join.builder+")) {
			return ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER+";
		}
		if (p.hasPermission("join.builder")) {
			return ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER";
		}
		if (p.hasPermission("join.youtuber+")) {
			return ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "YOUTUBER+";
		}
		if (p.hasPermission("join.youtuber")) {
			return ChatColor.AQUA + "" + ChatColor.BOLD + "YOUTUBER";
		}
		if (p.hasPermission("join.mvp") || Habilitar.mvp) {
			return ChatColor.BLUE + "" + ChatColor.BOLD + "MVP";
		}
		if (p.hasPermission("join.pro") || Habilitar.pro) {
			return ChatColor.GOLD + "" + ChatColor.BOLD + "PRO";
		}
		if (p.hasPermission("join.vip") || Habilitar.vip) {
			return ChatColor.GREEN + "" + ChatColor.BOLD + "VIP";
		}
		if (p.hasPermission("join.normal")) {
			return ChatColor.GRAY + "" + ChatColor.BOLD + "NORMAL";
		}
		return ChatColor.GRAY + "" + ChatColor.BOLD + "NORMAL";
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Comando(sender, cmd, args);
		return false;
	}
	
	public abstract void Comando(CommandSender sender, Command command ,String[] argumentos);

	
	public static String Verde(Player p) {
		double rankandprefix = StatsManager.getXp(p);
		if (rankandprefix <= 70) {

			return ChatColor.GREEN + "*" + ChatColor.WHITE + "⚊ Unranked";
		}
		if (rankandprefix <= 120) {

			return ChatColor.GREEN + "*" + ChatColor.WHITE + "�? Ranked";
		}
		if (rankandprefix <= 190) {

			return ChatColor.GREEN + "*" + ChatColor.GREEN + "☰  Apprentice";
		}
		if (rankandprefix <= 240) {

			return ChatColor.GREEN + "*" + ChatColor.YELLOW +  "☴  Starter";
		}
		if (rankandprefix <= 400) {

			return ChatColor.GREEN + "*" + ChatColor.DARK_AQUA +  "☷ Expert";
		}
		if (rankandprefix <= 540) {

			return ChatColor.GREEN + "*" + ChatColor.RED +  "✰ Ruby";
		}
		if (rankandprefix <= 670) {

			return ChatColor.GREEN + "*" + ChatColor.BLUE +  "�?� Experient";
		}
		if (rankandprefix <= 730) {

			return ChatColor.GREEN + "*" + ChatColor.GOLD + "✶ Gold";
		}
		if (rankandprefix <= 900) {

			return ChatColor.GREEN + "*" + ChatColor.DARK_GREEN + "✠ Emerald";
		}
		if (rankandprefix <= 1200) {

			return ChatColor.GREEN + "*" + ChatColor.DARK_PURPLE + "✸ Elite";
		}
		if (rankandprefix <= 1500) {

			return ChatColor.GREEN + "*" + ChatColor.LIGHT_PURPLE + "�?� Safira";
		}
		if (rankandprefix <= 1700) {

			return ChatColor.GREEN + "*" + ChatColor.DARK_RED + "✹ Supreme";
		}
		if (rankandprefix <= 2000) {

			return ChatColor.GREEN + "*" + ChatColor.AQUA + "✶ Legendary";
		}
		return ChatColor.GREEN + "*" + ChatColor.AQUA + "✶ Legendary";
	}
	
	public static String ProximoPorXp(Player p) {
		double rankandprefix = StatsManager.getXp(p);
		if (rankandprefix <= 70) {

			return "§eXP para o Proximo rank: " + ChatColor.WHITE + "§f 120 XP's";
		}
		if (rankandprefix <= 120) {

			return "§eXP para o Proximo rank: " + ChatColor.WHITE + "§f 190 XP's";
		}
		if (rankandprefix <= 190) {

			return "§eXP para o Proximo rank: " + ChatColor.GREEN + "§f 240 XP's";
		}
		if (rankandprefix <= 240) {

			return "§eXP para o Proximo rank: " + ChatColor.YELLOW +  "§f 400 XP's";
		}
		if (rankandprefix <= 400) {

			return "§eXP para o Proximo rank: " + ChatColor.DARK_AQUA +  "§f 540 XP's";
		}
		if (rankandprefix <= 540) {

			return "§eXP para o Proximo rank: " + ChatColor.RED +  "§f 670 XP's";
		}
		if (rankandprefix <= 670) {

			return "§eXP para o Proximo rank: " + ChatColor.BLUE +  "§f 730 XP's";
		}
		if (rankandprefix <= 730) {

			return "§eXP para o Proximo rank: " + ChatColor.GOLD + "§f 900 XP's";
		}
		if (rankandprefix <= 900) {

			return "§eXP para o Proximo rank: " + ChatColor.DARK_GREEN + "§f 1200 XP's";
		}
		if (rankandprefix <= 1200) {

			return "§eXP para o Proximo rank: " + ChatColor.DARK_PURPLE + "§f 1500 XP's";
		}
		if (rankandprefix <= 1500) {

			return "§eXP para o Proximo rank: " + ChatColor.LIGHT_PURPLE + "§f 1700 XP's";
		}
		if (rankandprefix <= 1700) {

			return "§eXP para o Proximo rank: " + ChatColor.DARK_RED + "§f 2000 XP's";
		}
		if (rankandprefix <= 2000) {

			return "§fParabens Você zerou todos seus ranks !";
		}
		return "§fParabens Você zerou todos seus ranks !";
	}
	
	public static String ProximoRank(Player p) {
		double rankandprefix = StatsManager.getXp(p);
		if (rankandprefix <= 70) {

			return "§eProximo rank: " + ChatColor.WHITE + "�? Ranked";
		}
		if (rankandprefix <= 120) {

			return "§eProximo rank: " + ChatColor.WHITE + "☰  Apprentice";
		}
		if (rankandprefix <= 190) {

			return "§eProximo rank: " + ChatColor.GREEN + "☴  Starter";
		}
		if (rankandprefix <= 240) {

			return "§eProximo rank: " + ChatColor.YELLOW +  "☷ Expert";
		}
		if (rankandprefix <= 400) {

			return "§eProximo rank: " + ChatColor.DARK_AQUA +  "✰ Ruby";
		}
		if (rankandprefix <= 540) {

			return "§eProximo rank: " + ChatColor.RED +  "�?� Experient";
		}
		if (rankandprefix <= 670) {

			return "§eProximo rank: " + ChatColor.BLUE +  "✶ Gold";
		}
		if (rankandprefix <= 730) {

			return "§eProximo rank: " + ChatColor.GOLD + "✠ Emerald";
		}
		if (rankandprefix <= 900) {

			return "§eProximo rank: " + ChatColor.DARK_GREEN + "✸ Elite";
		}
		if (rankandprefix <= 1200) {

			return "§eProximo rank: " + ChatColor.DARK_PURPLE + "�?� Safira";
		}
		if (rankandprefix <= 1500) {

			return "§eProximo rank: " + ChatColor.LIGHT_PURPLE + "✹ Supreme";
		}
		if (rankandprefix <= 1700) {

			return "§eProximo rank: " + ChatColor.DARK_RED + "✶ Legendary";
		}
		if (rankandprefix <= 2000) {

			return " ";
		}
		return " ";
	}
}
