package me.shooyudev.Utills;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Sopas implements Listener {

	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("sopas")) {
			e.setLine(0, "");
			e.setLine(1, "§c➜ §7Sopas");
			e.setLine(2, "§c➜ §7Sopas");
			e.setLine(3, "");
		}

	}

	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if (e.getClickedBlock() != null)
				if (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| (e.getClickedBlock().getType() == Material.SIGN_POST)) {
					Sign s = (Sign) e.getClickedBlock().getState();
					String[] lines = s.getLines();
					if ((lines.length > 0) && (lines[0].equals("")) && (lines.length > 1)
							&& (lines[1].equals("§c➜ §7Sopas")) && (lines.length > 2)
							&& (lines[2].equals("§c➜ §7Sopas")) && (lines.length > 3) && (lines[3].equals(""))) {
						Inventory inv = Bukkit.createInventory(p, 54, "§3§lSopas");

						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);

						for (int i = 0; i != 54; i++) {
							inv.setItem(i, sopa);
						}
						p.openInventory(inv);

					}
				}

	}
}