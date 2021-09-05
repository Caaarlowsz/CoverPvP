package me.shooyudev.API;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import me.shooyudev.Main;
import me.shooyudev.Utills.Strings;

public class API {

	public static String mensagem1;
	public static String mensagem2;
	public static String mensagem3;
	public static String mensagem4;
	public static String mensagem5;

	static {
		mensagem1 = Main.getInstance().getConfig().getString("Mensagem1").replace("&", "§");
		mensagem2 = Main.getInstance().getConfig().getString("Mensagem2").replace("&", "§");
		mensagem3 = Main.getInstance().getConfig().getString("Mensagem3").replace("&", "§");
		mensagem4 = Main.getInstance().getConfig().getString("Mensagem4").replace("&", "§");
		mensagem5 = Main.getInstance().getConfig().getString("Mensagem5").replace("&", "§");
	}

	private static HashMap<Player, String> Warp = new HashMap<>();

	public static String getWarp(Player p) {

		if (Warp.containsKey(p)) {
			return Warp.get(p);
		} else {
			return "Spawn";
		}
	}

	public static void setWarp(Player p, String warp) {
		Warp.put(p, warp);

	}

	public static void itensSpawn(Player p) {
		ItemStack bau = new ItemStack(Material.CHEST);
		ItemMeta baum = bau.getItemMeta();
		baum.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Kits -" + ChatColor.GRAY + " (Clique)");
		bau.setItemMeta(baum);

		ItemStack warp = new ItemStack(Material.COMPASS);
		ItemMeta warpm = warp.getItemMeta();
		warpm.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Warps -" + ChatColor.GRAY + " (Clique)");
		warp.setItemMeta(warpm);

		ItemStack menu = new ItemStack(Material.MINECART);
		ItemMeta menum = menu.getItemMeta();
		menum.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Menu -" + ChatColor.GRAY + " (Clique)");
		menu.setItemMeta(menum);

		ItemStack servidor = new ItemStack(Material.VINE);
		ItemMeta servidorm = servidor.getItemMeta();
		servidorm.setDisplayName(Strings.servidor);
		servidor.setItemMeta(servidorm);

		p.getInventory().setItem(3, bau);
		p.getInventory().setItem(5, warp);
		p.getInventory().setItem(4, menu);

	}

	public static void addItemInvPlayer(Player p, Material material, String nome, int quantidade, int slot) {
		ItemStack bau = new ItemStack(material, quantidade);
		ItemMeta baum = bau.getItemMeta();
		baum.setDisplayName(nome);
		bau.setItemMeta(baum);

		p.getInventory().setItem(slot, bau);
	}

	public static void addItemInvPlayerEncantado(Player p, Material material, String nome, int quantidade, int slot,
			Enchantment encantamento, int nivel) {
		ItemStack bau = new ItemStack(material, quantidade);
		ItemMeta baum = bau.getItemMeta();
		baum.setDisplayName(nome);
		baum.addEnchant(encantamento, nivel, true);
		bau.setItemMeta(baum);

		p.getInventory().setItem(slot, bau);
	}

	public static ItemStack criarItem(Player p, Material material, String nome, String[] lore, int quantidade,
			short cor) {

		ItemStack item = new ItemStack(material, quantidade, cor);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(lore));
		item.setItemMeta(kitem);

		return item;
	}

	public static void tirarEfeitos(final Player p) {
		p.removePotionEffect(PotionEffectType.ABSORPTION);
		p.removePotionEffect(PotionEffectType.BLINDNESS);
		p.removePotionEffect(PotionEffectType.CONFUSION);
		p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.FAST_DIGGING);
		p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.HARM);
		p.removePotionEffect(PotionEffectType.HEAL);
		p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		p.removePotionEffect(PotionEffectType.HUNGER);
		p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.removePotionEffect(PotionEffectType.NIGHT_VISION);
		p.removePotionEffect(PotionEffectType.POISON);
		p.removePotionEffect(PotionEffectType.REGENERATION);
		p.removePotionEffect(PotionEffectType.SATURATION);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.WATER_BREATHING);
		p.removePotionEffect(PotionEffectType.WEAKNESS);
		p.removePotionEffect(PotionEffectType.WITHER);
	}

	public static void tirarArmadura(final Player p) {
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
	}

	public static void darItem(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static void darItemEnchant(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
		final ItemStack item = new ItemStack(mat, quantidade);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.addEnchant(enchant, level, trueorfalse);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

}
