package me.shooyudev.Events;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.shooyudev.Main;

public class DropEvents implements Listener {

	@EventHandler
	public void sumir(ItemSpawnEvent e) {
		if (e.getEntity().getItemStack().getType() == Material.STONE_SWORD
				&& e.getEntity().getItemStack().getType() == Material.DIAMOND_SWORD
				&& e.getEntity().getItemStack().getType() == Material.IRON_CHESTPLATE) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				@Override
				public void run() {
					e.getEntity().remove();

				}
			}, 1L);
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			@Override
			public void run() {
				e.getEntity().remove();
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);

			}
		}, 50L);
	}

	@EventHandler
	public void CalcelarDrops(PlayerDropItemEvent e) {
		Material T = e.getItemDrop().getItemStack().getType();
		if ((T.equals(Material.CHEST)) || (T.equals(Material.ENCHANTED_BOOK)) || (T.equals(Material.BLAZE_ROD)) || (T
				.equals(Material.LADDER)) || (T.equals(Material.EMERALD)) || (T.equals(Material.STONE_SWORD))
				|| (T.equals(Material.FIREWORK)) || (T.equals(Material.DIAMOND_SWORD)) || (T.equals(Material.WOOD_HOE))
				|| (T.equals(Material.FISHING_ROD)) || (T.equals(Material.STONE_AXE)) || (T.equals(Material.EMERALD))
				|| (T.equals(Material.QUARTZ) || (T.equals(Material.STONE_HOE) || (T.equals(Material.REDSTONE_BLOCK)
						|| (T.equals(Material.EMERALD_BLOCK) || (T.equals(Material.IRON_FENCE) || (T.equals(
								Material.DIAMOND_BLOCK)
								|| (T.equals(Material.LAPIS_BLOCK) || (T.equals(Material.ENCHANTED_BOOK) || (T.equals(
										Material.BEDROCK)
										|| (T.equals(Material.REDSTONE) || (T.equals(Material.GOLD_AXE) || (T.equals(
												Material.WATCH)
												|| (T.equals(Material.FEATHER) || (T.equals(Material.DIAMOND) || (T
														.equals(Material.NAME_TAG)
														|| (T.equals(Material.SLIME_BALL) || (T
																.equals(Material.MAGMA_CREAM)
																|| (T.equals(Material.CHEST) || (T
																		.equals(Material.EMERALD)
																		|| (T.equals(Material.BONE) || (T
																				.equals(Material.PAPER)
																				|| (T.equals(Material.COMPASS) || (T
																						.equals(Material.FEATHER)
																						|| (T.equals(
																								Material.ENDER_PEARL)
																								|| (T.equals(
																										Material.STICK)
																										|| (T.equals(
																												Material.SNOW_BALL)
																												|| (T.equals(
																														Material.VINE)
																														|| (T.equals(
																																Material.MINECART)
																																|| (T.equals(
																																		Material.WRITTEN_BOOK)
																																		|| (T.equals(
																																				Material.IRON_AXE))))))))))))))))))))))))))))))))

		{
			e.setCancelled(true);
		} else {
		}
	}
}
