package me.shooyudev.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuMenus {
	
	@SuppressWarnings("deprecation")
	public static void inventory(Player p){
			
			
			Inventory menu = Bukkit.createInventory(p, 54, "§7Menu");
			
			ItemStack kits = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta kkits = kits.getItemMeta();
			kkits.setDisplayName("§fKits");
			kits.setItemMeta(kkits);		
			
			ItemStack Warps = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta kWarps = Warps.getItemMeta();
			kWarps.setDisplayName("§fWarps");
			Warps.setItemMeta(kWarps);	
			
			ItemStack Menu = new ItemStack(Material.getMaterial(351), 1, (short)10);
			ItemMeta kMenu = Menu.getItemMeta();
			kMenu.setDisplayName("§eMenu");
			Menu.setItemMeta(kMenu);	
			
			ItemStack menus = new ItemStack(Material.MINECART);
			ItemMeta kmenus = menus.getItemMeta();
			kmenus.setDisplayName("§eMenus");
			menus.setItemMeta(kmenus);	
			
			
			//MENU
			ItemStack Minigames = new ItemStack(Material.NAME_TAG);
			ItemMeta kMinigames = Minigames.getItemMeta();
			kMinigames.setDisplayName("§eMinigames");
			Minigames.setItemMeta(kMinigames);	
			
			ItemStack info = new ItemStack(Material.PAPER);
			ItemMeta kinfo = info.getItemMeta();
			kinfo.setDisplayName("§eInformaçoes");
			info.setItemMeta(kinfo);	
			
			ItemStack vidro = new ItemStack(Material.getMaterial(160), 1, (short)0);
			ItemMeta kvidro = vidro.getItemMeta();
			kvidro.setDisplayName("§7 ");
			vidro.setItemMeta(kvidro);	
			
			ItemStack loja = new ItemStack(Material.DIAMOND);
			ItemMeta kloja = loja.getItemMeta();
			kloja.setDisplayName("§eLojas");
			loja.setItemMeta(kloja);	
			
			menu.setItem(0, vidro);
			menu.setItem(1, vidro);
			menu.setItem(2, vidro);
			menu.setItem(3, vidro);
			menu.setItem(4, vidro);
			menu.setItem(5, vidro);
			menu.setItem(6, vidro);
			menu.setItem(7, vidro);
			menu.setItem(8, vidro);
			menu.setItem(46, vidro);
			menu.setItem(45, vidro);
			menu.setItem(46, vidro);
			menu.setItem(47, vidro);
			menu.setItem(51, vidro);
			menu.setItem(52, vidro);
			menu.setItem(53, vidro);
			
			
			
			menu.setItem(24, loja);
			menu.setItem(22, info);
			menu.setItem(20, Minigames);
			
			menu.setItem(49, kits);
			menu.setItem(48, Warps);
			menu.setItem(50, Menu);
			
			p.openInventory(menu);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		}

}
