package me.shooyudev.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WarpsMenus {

	@SuppressWarnings("deprecation")
	public static void inventory(Player p){
			
			
			Inventory menu = Bukkit.createInventory(p, 54, "§7Warps");
			
			ItemStack kits = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta kkits = kits.getItemMeta();
			kkits.setDisplayName("§fKits");
			kits.setItemMeta(kkits);		
			
			ItemStack Warps = new ItemStack(Material.getMaterial(351), 1, (short)10);
			ItemMeta kWarps = Warps.getItemMeta();
			kWarps.setDisplayName("§eWarps");
			Warps.setItemMeta(kWarps);	
			
			ItemStack loja = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta kloja = loja.getItemMeta();
			kloja.setDisplayName("§fMenu");
			loja.setItemMeta(kloja);	
			
			ItemStack vidro = new ItemStack(Material.getMaterial(160), 1, (short)0);
			ItemMeta kvidro = vidro.getItemMeta();
			kvidro.setDisplayName("§7 ");
			vidro.setItemMeta(kvidro);	
			
			ItemStack fps = new ItemStack(Material.GLASS, 1, (short)0);
			ItemMeta kfps = fps.getItemMeta();
			kfps.setDisplayName("§e§lFPS");
			fps.setItemMeta(kfps);
			
			ItemStack challenge = new ItemStack(Material.LAVA_BUCKET, 1, (short)0);
			ItemMeta kchallenge = challenge.getItemMeta();
			kchallenge.setDisplayName("§e§lCHALLENGE");
			challenge.setItemMeta(kchallenge);
			
			ItemStack knock = new ItemStack(Material.STICK);
			ItemMeta kknock = knock.getItemMeta();
			kknock.setDisplayName("§e§lKNOCKBACK");
			knock.setItemMeta(kknock);
			
			ItemStack fish = new ItemStack(Material.FISHING_ROD);
			ItemMeta kfish = fish.getItemMeta();
			kfish.setDisplayName("§e§lFISHERMAN");
			fish.setItemMeta(kfish);
			
			ItemStack txt = new ItemStack(Material.MAGMA_CREAM);
			ItemMeta ktxt = txt.getItemMeta();
			ktxt.setDisplayName("§e§lTEXTURAS");
			txt.setItemMeta(ktxt);
			
			ItemStack umvum = new ItemStack(Material.BLAZE_ROD);
			ItemMeta kumvum = umvum.getItemMeta();
			kumvum.setDisplayName("§e§l1V1");
			umvum.setItemMeta(kumvum);
			
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
			
			menu.setItem(21, fps);
			menu.setItem(22, challenge);
			menu.setItem(23, umvum);
			menu.setItem(24, knock);
			menu.setItem(31, fish);
			menu.setItem(32, txt);
			
			menu.setItem(49, kits);
			menu.setItem(48, Warps);
			menu.setItem(50, loja);
			
			p.openInventory(menu);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		}
	
}
