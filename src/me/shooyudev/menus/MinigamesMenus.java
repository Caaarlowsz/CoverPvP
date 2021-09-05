package me.shooyudev.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MinigamesMenus {

	@SuppressWarnings("deprecation")
	public static void inventory(Player p){
			
			
			Inventory menu = Bukkit.createInventory(p, 54, "§7Minigames");
			
			ItemStack kits = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta kkits = kits.getItemMeta();
			kkits.setDisplayName("§fKits");
			kits.setItemMeta(kkits);		
			
			ItemStack Warps = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta kWarps = Warps.getItemMeta();
			kWarps.setDisplayName("§fWarps");
			Warps.setItemMeta(kWarps);	
			
			ItemStack loja = new ItemStack(Material.getMaterial(351), 1, (short)10);
			ItemMeta kloja = loja.getItemMeta();
			kloja.setDisplayName("§eLojas");
			loja.setItemMeta(kloja);	
			
			ItemStack vidro = new ItemStack(Material.getMaterial(160), 1, (short)0);
			ItemMeta kvidro = vidro.getItemMeta();
			kvidro.setDisplayName("§7 ");
			vidro.setItemMeta(kvidro);	
			
			ItemStack test = new ItemStack(Material.NAME_TAG);
			ItemMeta ktest = test.getItemMeta();
			ktest.setDisplayName("§eCPS ");
			test.setItemMeta(ktest);	
			
			ItemStack voidl = new ItemStack(Material.ANVIL);
			ItemMeta kvoidl = voidl.getItemMeta();
			kvoidl.setDisplayName("§eVoidChallenge ");
			voidl.setItemMeta(kvoidl);	
		
			
			ItemStack Voltar = new ItemStack(Material.getMaterial(171), 1, (short)14);
			ItemMeta kVoltar = Voltar.getItemMeta();
			kVoltar.setDisplayName("§c§l<");
			Voltar.setItemMeta(kVoltar);
			
			menu.setItem(0, Voltar);
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
			
			menu.setItem(20, test);
			menu.setItem(24, voidl);
			
			menu.setItem(49, vidro);
			menu.setItem(48, vidro);
			menu.setItem(50, vidro);
			
			p.openInventory(menu);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		}
	
}
