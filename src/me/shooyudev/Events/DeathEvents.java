package me.shooyudev.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.API.API;
import me.shooyudev.API.KitAPI;
import me.shooyudev.API.StatsManager;
import me.shooyudev.API.WarpsAPI;
import me.shooyudev.Utills.Strings;
import me.shooyudev.scoreboarding.Updater;

public class DeathEvents implements Listener {

	@EventHandler
	public void death(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player d = e.getEntity().getKiller();
		WarpsAPI.Ir(p, "Spawn");
		API.setWarp(p, "Spawn");
		Prote��o.setImortalidade(p, true);
		Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
			public void run() {
				p.spigot().respawn();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
			public void run() {
				WarpsAPI.Ir(p, "Spawn");
				API.setWarp(p, "Spawn");
				API.itensSpawn(p);
				Prote��o.setImortalidade(p, true);
			}
		}, 2L);

		if (KitAPI.getKit(p) != "1v1") {
			WarpsAPI.Ir(p, "Spawn");
			API.setWarp(p, "Spawn");
			KitAPI.TirarKit(p);

			if (d != null) {

				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� morreu para o Jogador: "
						+ ChatColor.GREEN + ChatColor.BOLD + d.getName());
				p.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Coins: " + ChatColor.GRAY + "-4");

				d.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� matou o Jogador: " + ChatColor.RED
						+ ChatColor.BOLD + p.getName());
				d.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "XP's: " + ChatColor.GRAY + "+1");
				d.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Coins: " + ChatColor.GRAY + "+20");

				StatsManager.setKills(d);
				StatsManager.setDeaths(p);
				StatsManager.setCoins(d, 20);
				StatsManager.setXp(d, 1);
				StatsManager.RemoverKS(p);

				Updater.UpdateScore(p);
				Updater.UpdateScore(d);

				e.setDeathMessage(null);
				e.getDrops().clear();

				if (StatsManager.getKillStreak(d) == 5) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l5");
				}
				if (StatsManager.getKillStreak(d) == 10) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l10");
				}
				if (StatsManager.getKillStreak(d) == 15) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l15");
				}
				if (StatsManager.getKillStreak(d) == 20) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l20");
				}
				if (StatsManager.getKillStreak(d) == 25) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l25");
				}
				if (StatsManager.getKillStreak(d) == 30) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l30");
				}
				if (StatsManager.getKillStreak(d) == 35) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l35");
				}
				if (StatsManager.getKillStreak(d) == 40) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l40");
				}
				if (StatsManager.getKillStreak(d) == 45) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l45");
				}
				if (StatsManager.getKillStreak(d) == 50) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l50");
				}
				if (StatsManager.getKillStreak(d) == 55) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l55");
				}
				if (StatsManager.getKillStreak(d) == 60) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l60");
				}
				if (StatsManager.getKillStreak(d) == 65) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l65");
				}
				if (StatsManager.getKillStreak(d) == 70) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l70");
				}
				if (StatsManager.getKillStreak(d) == 75) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l75");
				}
				if (StatsManager.getKillStreak(d) == 80) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l80");
				}
				if (StatsManager.getKillStreak(d) == 85) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l85");
				}
				if (StatsManager.getKillStreak(d) == 90) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l90");
				}
				if (StatsManager.getKillStreak(d) == 95) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l95");
				}
				if (StatsManager.getKillStreak(d) == 100) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l100");
				}
				if (StatsManager.getKillStreak(d) == 105) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l105");
				}
				if (StatsManager.getKillStreak(d) == 110) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l110");
				}
				if (StatsManager.getKillStreak(d) == 115) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l115");
				}
				if (StatsManager.getKillStreak(d) == 120) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l120");
				}
				if (StatsManager.getKillStreak(d) == 125) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l125");
				}
				if (StatsManager.getKillStreak(d) == 130) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l130");
				}
				if (StatsManager.getKillStreak(d) == 135) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l135");
				}
				if (StatsManager.getKillStreak(d) == 140) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l140");
				}
				if (StatsManager.getKillStreak(d) == 145) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l145");
				}
				if (StatsManager.getKillStreak(d) == 150) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l150");
				}
				if (StatsManager.getKillStreak(d) == 155) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l155");
				}
				if (StatsManager.getKillStreak(d) == 160) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l160");
				}
				if (StatsManager.getKillStreak(d) == 165) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l165");
				}
				if (StatsManager.getKillStreak(d) == 170) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l170");
				}
				if (StatsManager.getKillStreak(d) == 175) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l175");
				}
				if (StatsManager.getKillStreak(d) == 180) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l180");
				}
				if (StatsManager.getKillStreak(d) == 185) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l185");
				}
				if (StatsManager.getKillStreak(d) == 190) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l190");
				}
				if (StatsManager.getKillStreak(d) == 195) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l195");
				}
				if (StatsManager.getKillStreak(d) == 200) {
					Bukkit.broadcastMessage("�e�l" + d.getName() + " �7est� com um killstreak de �a�l200");
				}
			} else {
				e.setDeathMessage(null);
				e.getDrops().clear();
			}
		}
	}
}
