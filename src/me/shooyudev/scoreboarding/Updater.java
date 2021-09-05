package me.shooyudev.scoreboarding;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import me.shooyudev.Main;
import me.shooyudev.API.KitAPI;
import me.shooyudev.API.StatsManager;
import me.shooyudev.Manager.Manager;

public class Updater{
	
	public Updater() {
		
	}

	public void run(){
		new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				Main.bk.next();
				for (Player p : Bukkit.getOnlinePlayers()){
					update(p.getScoreboard());
				}
				
			}
		}.runTaskTimer(Main.instance, 0, 3);
	}
	
	public static void UpdateScore(Player p){
		
	    ScoreboardAPI score = new ScoreboardAPI("§c§lArkuz§f§lMC");
	    score.adicionarLinha("§c    loja-arkuzmc.buycraft.net", Integer.valueOf(13));
	    score.adicionarLinha("§1", Integer.valueOf(12));
	    score.adicionarLinha("§7 Cargo: " + Manager.GrupoJoin(p), Integer.valueOf(11));
	    score.adicionarLinha("§1", Integer.valueOf(10));
	    score.adicionarLinha("§7 Kit: §a" + KitAPI.getKit(p), Integer.valueOf(9));
	    score.adicionarLinha("§7 Rank: " + Manager.RankAndPrefix(p), Integer.valueOf(8));
	    score.adicionarLinha("§7 Xp: §a" + StatsManager.getXp(p), Integer.valueOf(7));
	    score.adicionarLinha("§7 Coins: §a" + StatsManager.getCoins(p), Integer.valueOf(6));
	    score.adicionarLinha("§1", Integer.valueOf(5));
	    score.adicionarLinha("§7 Kills: §a" + StatsManager.getKills(p), Integer.valueOf(4));
	    score.adicionarLinha("§7 Deaths: §c" + StatsManager.getDeaths(p), Integer.valueOf(3));
	    score.adicionarLinha("§7 Streak: §e" + StatsManager.getKillStreak(p), Integer.valueOf(2));
	    score.adicionarLinha("§2", Integer.valueOf(1));
	    score.setarScoreboard();
		
		p.setScoreboard(score.pegarScoreboard());
		
	}
	
	public void update(final Scoreboard score){
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Objective obj = score.getObjective("flation");
				obj.setDisplayName(Main.bk.getText());
				
			}
		});
		th.start();
	}
}
