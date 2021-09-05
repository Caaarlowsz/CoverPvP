package me.shooyudev.Habilites;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.shooyudev.API.KitAPI;

public class Critical implements Listener {
	@EventHandler
	public void dano(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if (KitAPI.getKit(d) == "Critical") {
				Random r = new Random();
				int c = r.nextInt(100);
				if (c <= 30) {
					e.setDamage(e.getDamage() + 4.0D);
					p.getWorld().playEffect(p.getLocation(), org.bukkit.Effect.STEP_SOUND, Material.LAVA, 100);
				}
			}
		}
	}
}