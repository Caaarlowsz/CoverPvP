package me.shooyudev.Events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ca.wacos.nametagedit.NametagAPI;
import me.shooyudev.API.KitAPI;
import me.shooyudev.API.StatsManager;
import me.shooyudev.API.WarpsAPI;
import me.shooyudev.Comandos.Evento;
import me.shooyudev.Comandos.Habilitar;
import me.shooyudev.Manager.Manager;
import me.shooyudev.scoreboarding.Updater;

public class Entrar implements Listener {

	@EventHandler
	public static void EntrarNoServidor(PlayerJoinEvent event) {
		event.setJoinMessage(null);
		Player p = event.getPlayer();
		p.getInventory().clear();
		WarpsAPI.Ir(p, "Spawn");
		Proteção.setImortalidade(p, true);
		KitAPI.TirarKit(p);
		Updater.UpdateScore(p);
		TagNoServidor(p);
		Evento.participantes.remove(p.getName());
		p.getInventory().setArmorContents(null);
		p.setFoodLevel(20);
		p.setGameMode(GameMode.SURVIVAL);
		StatsManager.RemoverKS(p);

	}

	public static void TagNoServidor(Player p) {
		if (p.hasPermission("cover.join.dono")) {
			NametagAPI.setNametagHard(p.getName(),
					ChatColor.DARK_RED + "" + ChatColor.BOLD + "DONO " + ChatColor.DARK_RED,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "DONO " + ChatColor.DARK_RED + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.admin+")) {
			NametagAPI.setNametagHard(p.getName(), ChatColor.RED + "" + ChatColor.BOLD + "ADMIN+ " + ChatColor.RED,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ADMIN+" + ChatColor.RED + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.admin")) {
			NametagAPI.setNametagHard(p.getName(), ChatColor.RED + "" + ChatColor.BOLD + "ADMIN " + ChatColor.RED,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ADMIN " + ChatColor.RED + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.gerente")) {
			NametagAPI.setNametagHard(p.getName(), ChatColor.RED + "" + ChatColor.BOLD + "GERENTE " + ChatColor.RED,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "GERENTE " + ChatColor.RED + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.mod+")) {
			NametagAPI.setNametagHard(p.getName(),
					ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD+ " + ChatColor.DARK_PURPLE,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(
					ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD+ " + ChatColor.DARK_PURPLE + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.mod")) {
			NametagAPI.setNametagHard(p.getName(),
					ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD " + ChatColor.DARK_PURPLE,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(
					ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD " + ChatColor.DARK_PURPLE + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.trial")) {
			NametagAPI.setNametagHard(p.getName(),
					ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "TRIAL " + ChatColor.LIGHT_PURPLE,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(
					ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "TRIAL " + ChatColor.LIGHT_PURPLE + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.youtuber+")) {
			NametagAPI.setNametagHard(p.getName(),
					ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "YT+ " + ChatColor.DARK_AQUA,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "YT+ " + ChatColor.DARK_AQUA + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.helper")) {
			NametagAPI.setNametagHard(p.getName(), ChatColor.BLUE + "" + ChatColor.BOLD + "HELPER " + ChatColor.BLUE,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "HELPER " + ChatColor.BLUE + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.builder")) {
			NametagAPI.setNametagHard(p.getName(),
					ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER " + ChatColor.YELLOW,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER " + ChatColor.YELLOW + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.builder+")) {
			NametagAPI.setNametagHard(p.getName(),
					ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER+ " + ChatColor.YELLOW,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER+ " + ChatColor.YELLOW + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.youtuber")) {
			NametagAPI.setNametagHard(p.getName(), ChatColor.AQUA + "YT" + ChatColor.BOLD + "YT " + ChatColor.AQUA,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "YT " + ChatColor.AQUA + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.pro") || Habilitar.pro) {
			NametagAPI.setNametagHard(p.getName(), ChatColor.GOLD + "" + ChatColor.BOLD + "PRO " + ChatColor.GOLD,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "PRO " + ChatColor.GOLD + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.mvp") || Habilitar.mvp) {
			NametagAPI.setNametagHard(p.getName(), ChatColor.BLUE + "" + ChatColor.BOLD + "MVP " + ChatColor.BLUE,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "MVP " + ChatColor.BLUE + p.getName());
			return;
		}
		if (p.hasPermission("cover.join.vip") || Habilitar.vip) {
			NametagAPI.setNametagHard(p.getName(), ChatColor.GREEN + "" + ChatColor.BOLD + "VIP " + ChatColor.GREEN,
					ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
			p.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "VIP " + ChatColor.GREEN + p.getName());
			return;
		}
		NametagAPI.setNametagHard(p.getName(), ChatColor.GRAY + "",
				ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
		p.setDisplayName(ChatColor.GRAY + "" + p.getName());
		return;
	}
}