package me.shooyudev.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.shooyudev.Comandos.Habilitar;

public class KitsMenus {

	public static void menuentory(Player p) {

		Inventory menu = Bukkit.createInventory(p, 54, "§7Kits");

		ItemStack kits = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("§eKits");
		kits.setItemMeta(kkits);

		ItemStack Warps = new ItemStack(Material.getMaterial(351), 1, (short) 8);
		ItemMeta kWarps = Warps.getItemMeta();
		kWarps.setDisplayName("§fWarps");
		Warps.setItemMeta(kWarps);

		ItemStack loja = new ItemStack(Material.getMaterial(351), 1, (short) 8);
		ItemMeta kloja = loja.getItemMeta();
		kloja.setDisplayName("§fMenu");
		loja.setItemMeta(kloja);

		ItemStack vidro = new ItemStack(Material.getMaterial(160), 1, (short) 0);
		ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName(ChatColor.GRAY + "");
		vidro.setItemMeta(kvidro);

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

		menu.setItem(49, kits);
		menu.setItem(48, Warps);
		menu.setItem(50, loja);

		if (p.hasPermission("kit.pvp") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.STONE_SWORD);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§ePvP");
			desc.add("§7Treine seu pvp sem habilidade.");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.kangaroo") || Habilitar.fullkit || Habilitar.vip || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.FIREWORK);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eKangaroo");
			desc.add("§7Ganhe double jump.");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.specialist") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.ENCHANTED_BOOK);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eSpecialist");
			desc.add("§7Encante itens usando um livro.");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.stomper") || Habilitar.fullkit) {
			ItemStack pvp = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eStomper");
			desc.add("§7Pule de lugar altos e mate players ao seu redor.");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.gladiator") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.IRON_FENCE);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eGladiator");
			desc.add("§7Tire 1v1 nas alturas !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.viper") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.SPIDER_EYE);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eViper");
			desc.add("§7Evenenem seus inimigos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.snail") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.WEB);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eSnail");
			desc.add("§7Deixem seus inimigos lentos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.ninja") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.EMERALD);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eNinja");
			desc.add("§7Teleporte ate seus imigos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.anchor") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.ANVIL);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eAnchor");
			desc.add("§7Tire o Knockback de seus inimigos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.thor") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.GOLD_AXE);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eThor");
			desc.add("§7Taque raios em seus imigos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.switcher") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp) {
			ItemStack pvp = new ItemStack(Material.SNOW_BALL);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eSwitcher");
			desc.add("§7Troque de lugar com seus imigos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.fisherman") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.FISHING_ROD);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eFisherman");
			desc.add("§7Fisgue seus inimigos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.magma") || Habilitar.fullkit) {
			ItemStack pvp = new ItemStack(Material.MAGMA_CREAM);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eMagma");
			desc.add("§7Coloque fogos em seus inimigos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.critical") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.IRON_BLOCK);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eCritical");
			desc.add("§7Da golpes fatais em seus inimigos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.ajnin") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.NETHER_STAR);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eAjnin");
			desc.add("§7Nao deixem seus inimigos escaparem !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.boxer") || Habilitar.fullkit || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.QUARTZ);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eMadman");
			desc.add("§7De mais dano em seus imigos , e receba menos dano !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.monk") || Habilitar.fullkit || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.BLAZE_ROD);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eMonk");
			desc.add("§7Desarme seus inimigos");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.madman") || Habilitar.fullkit || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.FERMENTED_SPIDER_EYE);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eMadman");
			desc.add("§7Ganhem 2v1 facil");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.strong") || Habilitar.fullkit || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.WATCH);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eStrong");
			desc.add("§7Fique fulliron por 10 segundos !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.viking") || Habilitar.fullkit || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.IRON_AXE);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eViking");
			desc.add("§7De mais dano com esse machado !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.grappler") || Habilitar.fullkit) {
			ItemStack pvp = new ItemStack(Material.LEASH);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eGrappler");
			desc.add("§7De mais dano com esse machado !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.hulk") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.SADDLE);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eHulk");
			desc.add("§7Puxe seus inimigos para cima !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.phantom") || Habilitar.fullkit) {
			ItemStack pvp = new ItemStack(Material.FEATHER);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§ePhantom");
			desc.add("§7Utilize sua pena para voar como um pássaro !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}
		if (p.hasPermission("kit.sumo") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
			ItemStack pvp = new ItemStack(Material.APPLE);
			ItemMeta kpvp = pvp.getItemMeta();
			ArrayList<String> desc = new ArrayList<>();
			kpvp.setDisplayName("§eSumo");
			desc.add("§7Jogue seus inimigos para o alto utilizando seu peso !");
			kpvp.setLore(desc);
			pvp.setItemMeta(kpvp);
			menu.addItem(new ItemStack[] { pvp });
		}

		p.openInventory(menu);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	}

}
