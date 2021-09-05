package me.shooyudev.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class IntercanbioMenus implements Listener {

	@EventHandler
	public void CliclarLojas(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Lojas") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§l<")) {
				e.setCancelled(true);
				MenuMenus.inventory(p);
				return;
			}
		}
	}

	@EventHandler
	public void CliclarMinigames(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Minigames") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§l<")) {
				e.setCancelled(true);
				MenuMenus.inventory(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.NAME_TAG) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/cps");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp voidchallenge");
				return;
			}
		}
	}

	@EventHandler
	public void CliclarKits(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Kits") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fWarps")) {
				e.setCancelled(true);
				WarpsMenus.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fMenu")) {
				e.setCancelled(true);
				MenuMenus.inventory(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pvp");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit kangaroo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit specialist");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gladiator");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WEB) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit snail");
				return;
			}
			if (e.getCurrentItem().getType() == Material.EMERALD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ninja");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit anchor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit switcher");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit magma");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ajnin");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit critical");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit madman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATCH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit strong");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viking");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit monk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEASH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit grappler");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SADDLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hulk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
				return;
			}
			if (e.getCurrentItem().getType() == Material.APPLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit sumo");
				return;
			}
		}
	}

	@EventHandler
	public void CliclarInformaçoes(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Informaçoes") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fKits")) {
				e.setCancelled(true);
				KitsMenus.menuentory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§l<")) {
				e.setCancelled(true);
				MenuMenus.inventory(p);
				return;
			}
		}
	}

	@EventHandler
	public void CliclarMenu(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Menu") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fKits")) {
				e.setCancelled(true);
				KitsMenus.menuentory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fWarps")) {
				e.setCancelled(true);
				WarpsMenus.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eLojas")) {
				e.setCancelled(true);
				LojasMenus.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eMinigames")) {
				e.setCancelled(true);
				MinigamesMenus.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eInformaçoes")) {
				e.setCancelled(true);
				InformaçoesMenus.inventory(p);
				return;
			}
		}
	}

	@EventHandler
	public void CliclarWarps(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Warps") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fKits")) {
				e.setCancelled(true);
				KitsMenus.menuentory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fMenu")) {
				e.setCancelled(true);
				MenuMenus.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lFPS")) {
				e.setCancelled(true);
				FpsMenus.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lCHALLENGE")) {
				e.setCancelled(true);
				p.chat("/warp challenge");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lKNOCKBACK")) {
				e.setCancelled(true);
				p.chat("/warp knockback");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lFISHERMAN")) {
				e.setCancelled(true);
				p.chat("/warp fisherman");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lTEXTURAS")) {
				e.setCancelled(true);
				p.chat("/warp textura");
				return;
			}
		}
	}

	@EventHandler
	public void ClicarFps(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§7Warps") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lFPS - §7(Sem armadura)")) {
				e.setCancelled(true);
				p.chat("/warp fps1");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lFPS - §7(Com armadura)")) {
				e.setCancelled(true);
				p.chat("/warp fps2");
				return;
			}
		}
	}

}
