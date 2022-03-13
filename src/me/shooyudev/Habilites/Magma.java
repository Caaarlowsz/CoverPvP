package me.shooyudev.Habilites;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.API.KitAPI;

public class Magma implements org.bukkit.event.Listener {
	public static CoverPvP plugin;

	public Magma(CoverPvP main) {
		plugin = main;
	}

	public Magma() {
	}

	@EventHandler
	public void viperEvent(EntityDamageByEntityEvent event) {
		if ((!(event.getEntity() instanceof Player)) || (!(event.getDamager() instanceof Player))) {
			return;
		}
		Player player = (Player) event.getDamager();
		Player player1 = (Player) event.getEntity();
		if (KitAPI.getKit(player) != "Magma") {
			return;
		}
		if ((Math.random() > 0.4D) && (Math.random() < 0.1D))
			player1.setFireTicks(100);
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event1) {
		Player player11 = event1.getPlayer();
		if ((KitAPI.getKit(player11) == "Magma'") && ((player11.getLocation().getBlock().getType() == Material.WATER)
				|| (player11.getLocation().getBlock().getType() == Material.STATIONARY_WATER))) {
			player11.addPotionEffect(
					new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.POISON, 65, 0));
			player11.addPotionEffect(
					new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.SLOW, 65, 0));
		}
	}

	@EventHandler
	public void damage(EntityDamageEvent e) {
		if ((e.getEntity() instanceof Player)) {
			Player p = (Player) e.getEntity();
			if ((KitAPI.getKit(p) == "Magma") && ((e.getCause() == EntityDamageEvent.DamageCause.LAVA)
					|| (e.getCause() == EntityDamageEvent.DamageCause.FIRE)
					|| (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK))) {
				e.setCancelled(true);
			}
		}
	}
}