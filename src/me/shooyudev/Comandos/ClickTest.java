package me.shooyudev.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;

public class ClickTest implements CommandExecutor, Listener {
	public static ArrayList<String> emcps;
	public static ArrayList<String> fazendocps;

	static {
		ClickTest.emcps = new ArrayList<String>();
		ClickTest.fazendocps = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			p.sendMessage(ChatColor.RED + "Voc� precisa ser um player !");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("cps")) {
			if (ClickTest.fazendocps.contains(p.getName())) {
				p.sendMessage(ChatColor.GRAY + "Voc� ja esta fazendo ClickTest !");
				return true;
			}
			ClickTest.fazendocps.add(p.getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Iniciando Seu CPS em: " + ChatColor.YELLOW + "5" + ChatColor.GREEN
							+ " segundos.");
				}
			}, 0L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Iniciando Seu CPS em: " + ChatColor.YELLOW + "4" + ChatColor.GREEN
							+ " segundos.");
				}
			}, 20L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Iniciando Seu CPS em: " + ChatColor.YELLOW + "3" + ChatColor.GREEN
							+ " segundos.");
				}
			}, 40L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Iniciando Seu CPS em: " + ChatColor.YELLOW + "2" + ChatColor.GREEN
							+ " segundos.");
				}
			}, 60L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Iniciando Seu CPS em: " + ChatColor.YELLOW + "1" + ChatColor.GREEN
							+ " segundos.");
				}
			}, 80L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(ChatColor.GREEN + "CPS Iniciado .");
					ClickTest.emcps.add(p.getName());
				}
			}, 100L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					if (p.getLevel() >= 200) {
						Bukkit.broadcast(
								ChatColor.GRAY + "O Jogador " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN
										+ " �7Esta usando Macro/AutoClicker/Progamas de clicks, CPS: " + p.getLevel(),
								"covercpsmacro");
						ClickTest.emcps.remove(p.getName());
						ClickTest.fazendocps.remove(p.getName());
					}
					p.sendMessage(ChatColor.GREEN + "Seu CPS acabou !");
					p.sendMessage(ChatColor.GREEN + "Voc� fez " + ChatColor.YELLOW + p.getLevel() + ChatColor.GREEN
							+ " Em 7 segundos !");
					ClickTest.emcps.remove(p.getName());
					ClickTest.fazendocps.remove(p.getName());
					p.setLevel(0);
				}
			}, 250L);
		}
		return false;
	}

	@EventHandler
	public void comandos(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (ClickTest.emcps.contains(p.getName()) && e.getMessage().startsWith("/")) {
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "Voc� nao pode digitar em quando estiver fazendo CPS.");
		}
	}

	@EventHandler
	public void click(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (ClickTest.emcps.contains(p.getName()) && e.getAction() == Action.LEFT_CLICK_AIR) {
			p.setLevel(p.getLevel() + 1);
		}
	}
}
