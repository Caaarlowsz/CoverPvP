package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.API.StatsManager;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;
import me.shooyudev.scoreboarding.Updater;

public class SetRank extends Manager {

	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player) sender;

		if (p.hasPermission("cover.setrank")) {
			if (command.getName().equalsIgnoreCase("setrank")) {
				if (argumentos.length == 0) {
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY
							+ "Use /setrank <player> <unraked , ranked , apprentice , starter , expert , ruby , experient , gold , emerald , elite , safira , supreme , legendary>");
					return;
				}
				if (argumentos.length == 1) {

				}
				if (argumentos.length == 2) {
					String darxp = argumentos[1];
					Player player = Bukkit.getPlayer(argumentos[0]);
					if (darxp.equalsIgnoreCase("unranked")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Unranked "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Unranked");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("ranked")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 71);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Ranked "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Ranked");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("apprentice")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 121);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Apprentice "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Apprentice");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("starter")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 191);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Starter "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Starter");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("expert")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 241);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Expert "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Expert");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("ruby")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 401);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Ruby "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Ruby");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("experient")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 541);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Experient "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Experient");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("gold")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 671);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Gold "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Gold");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("emerald")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 731);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Emerald "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Emerald");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("elite")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 901);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Elite "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Elite");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("safira")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 1201);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Safira "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.WHITE + " Safira");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("supreme")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 1501);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Supreme "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.DARK_RED + " Supreme");
						Updater.UpdateScore(player);
						return;
					}
					if (darxp.equalsIgnoreCase("legendary")) {
						StatsManager.RemoveXp(player, StatsManager.getXp(player));
						StatsManager.setXp(player, 1701);
						p.sendMessage(ChatColor.GREEN + "Você setou o rank" + ChatColor.WHITE + " Legendary "
								+ "Para o player: " + ChatColor.YELLOW + player.getName());
						player.sendMessage(
								ChatColor.GREEN + "Seu rank foi promovido para " + ChatColor.DARK_AQUA + " Lengendary");
						Updater.UpdateScore(player);
						return;
					}
				}
			}
		}
	}

}
