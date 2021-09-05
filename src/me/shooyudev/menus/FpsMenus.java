package me.shooyudev.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FpsMenus {

	public static void inventory(Player p) {

		Inventory menu = Bukkit.createInventory(p, 9, "§7Warps");

		ItemStack kits = new ItemStack(Material.getMaterial(35), 1, (short) 14);
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("§e§lFPS - §7(Sem armadura)");
		kits.setItemMeta(kkits);

		ItemStack Warps = new ItemStack(Material.getMaterial(35), 1, (short) 5);
		ItemMeta kWarps = Warps.getItemMeta();
		kWarps.setDisplayName("§e§lFPS - §7(Com armadura)");
		Warps.setItemMeta(kWarps);

		menu.setItem(3, kits);
		menu.setItem(5, Warps);

		p.openInventory(menu);
	}

}
