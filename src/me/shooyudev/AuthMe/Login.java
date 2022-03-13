package me.shooyudev.AuthMe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.Configs.AuthConfig;
import me.shooyudev.Utills.Strings;

public class Login implements Listener {
	public static boolean premium(String nome) {
		try {
			URL url = new URL("https://minecraft.net/haspaid.jsp?user=" + nome);

			String prem = new BufferedReader(new InputStreamReader(url.openStream())).readLine().toUpperCase();

			boolean premium = Boolean.valueOf(prem).booleanValue();
			if (premium) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@EventHandler
	public void aoLogin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		CoverPvP.login.add(p.getName());
		if (AuthConfig.getConfig().config().contains("Login." + p.getName().toLowerCase() + ".senha")) {
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(CoverPvP.plugin, new Runnable() {
				public void run() {
					if (CoverPvP.login.contains(p.getName())) {
						for (int i = 1; i < 100; i++) {
							p.sendMessage(" ");
						}
						p.sendMessage(Strings.servidormensagem + ChatColor.GREEN + "Para se Logar Use "
								+ ChatColor.YELLOW + "/login <senha>");
					}
				}
			}, 0L, 100L);
		}
		if (!AuthConfig.getConfig().config().contains("Login." + p.getName().toLowerCase() + ".senha")) {
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(CoverPvP.plugin, new Runnable() {
				public void run() {
					if (CoverPvP.login.contains(p.getName())) {
						for (int i = 1; i < 100; i++) {
							p.sendMessage(" ");
						}
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Para se Registrar "
								+ ChatColor.YELLOW + "/register <senha>");
					}
				}
			}, 0L, 100L);
		}
	}
}
