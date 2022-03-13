package me.shooyudev.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.API.API;
import me.shooyudev.API.KitAPI;
import me.shooyudev.API.WarpsAPI;
��o;
import me.shooyudev.Utills.Strings;
import me.shooyudev.menus.WarpsMenus;
import me.shooyudev.scoreboarding.Updater;

public class Warp implements CommandExecutor, Listener {

	public static ArrayList<Player> noExecut = new ArrayList<>();

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;

		if (Cmd.getName().equalsIgnoreCase("warp")) {

			if (Args.length == 0) {
				WarpsMenus.inventory(p);
				return true;
			}
			if (Args[0].equalsIgnoreCase("fps1")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 99999));

				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� est� sendo enviado para a warp"
						+ ChatColor.YELLOW + ChatColor.GOLD + " FPS Sem Armadura" + ChatColor.WHITE + "!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);

						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						WarpsAPI.Ir(p, "Fps1");
						API.setWarp(p, "Fps1");
						KitAPI.setKit(p, "FpsComArmadura");
						Updater.UpdateScore(p);
						WarpsAPI.iniciarFPS();

						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; i++) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}
						Prote��o.setImortalidade(p, true);

						p.getInventory().setItem(13,
								API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(14,
								API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short) 0));

						ItemStack Espada = new ItemStack(Material.STONE_SWORD);
						Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
						ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("");
						Espada.setItemMeta(kEspada);

						p.getInventory().setItem(0, Espada);
					}
				}, 3 * 20);
			}
			if (Args[0].equalsIgnoreCase("fps2")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 99999));

				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� est� sendo enviado para a warp"
						+ ChatColor.YELLOW + ChatColor.GOLD + " FPS Com Armadura" + ChatColor.WHITE + "!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
					public void run() {

						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);

						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						WarpsAPI.iniciarFPS();
						WarpsAPI.Ir(p, "Fps2");
						API.setWarp(p, "Fps2");
						KitAPI.setKit(p, "FpsSemArmadura");
						Updater.UpdateScore(p);

						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; i++) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}
						Prote��o.setImortalidade(p, true);

						p.getInventory().setItem(13,
								API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(14,
								API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short) 0));

						ItemStack Espada = new ItemStack(Material.STONE_SWORD);
						Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
						ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("");
						Espada.setItemMeta(kEspada);

						p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setItem(0, Espada);
					}
				}, 3 * 20);
			}
			if (Args[0].equalsIgnoreCase("challenge")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� est� sendo enviado para a warp "
						+ ChatColor.YELLOW + ChatColor.BOLD + " LAVACHALLENGE " + ChatColor.WHITE + "!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 99999));

				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);

				Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
					public void run() {
						Updater.UpdateScore(p);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);

						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						WarpsAPI.removerFPS();
						Prote��o.setImortalidade(p, true);

						WarpsAPI.Ir(p, "Challenge");
						API.setWarp(p, "Challenge");
						KitAPI.setKit(p, "Challenge");
						Updater.UpdateScore(p);

						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; i++) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}
						p.getInventory().setItem(13,
								API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(14,
								API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short) 0));

					}
				}, 3 * 20);
			}
			if (Args[0].equalsIgnoreCase("knockback")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� est� sendo enviado para a warp "
						+ ChatColor.YELLOW + ChatColor.BOLD + " KNOCKBACK " + ChatColor.WHITE + "!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 99999));

				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);

				Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
					public void run() {
						Updater.UpdateScore(p);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);

						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						WarpsAPI.removerFPS();
						Prote��o.setImortalidade(p, true);

						WarpsAPI.Ir(p, "Knockback");
						API.setWarp(p, "Knockback");
						KitAPI.setKit(p, "Knockback");
						Updater.UpdateScore(p);

						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; i++) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}

						ItemStack Espada = new ItemStack(Material.STICK);
						ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("�eKnockBack");
						kEspada.addEnchant(Enchantment.KNOCKBACK, 5, true);
						Espada.setItemMeta(kEspada);

						p.getInventory().setItem(0, Espada);
						p.getInventory().setItem(13,
								API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(14,
								API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short) 0));

					}
				}, 3 * 20);
			}
			if (Args[0].equalsIgnoreCase("fisherman")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� est� sendo enviado para a warp "
						+ ChatColor.YELLOW + ChatColor.BOLD + " KNOCKBACK " + ChatColor.WHITE + "!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 99999));

				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);

				Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
					public void run() {
						Updater.UpdateScore(p);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);

						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						WarpsAPI.removerFPS();
						Prote��o.setImortalidade(p, true);

						WarpsAPI.Ir(p, "Fisherman");
						API.setWarp(p, "Fisherman");
						KitAPI.setKit(p, "Fisherman");
						Updater.UpdateScore(p);

						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; i++) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}

						ItemStack Espada = new ItemStack(Material.FISHING_ROD);
						ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("�eFisherman");
						Espada.setItemMeta(kEspada);

						p.getInventory().setItem(0, Espada);
						p.getInventory().setItem(13,
								API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(14,
								API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short) 0));

					}
				}, 3 * 20);
			}
			if (Args[0].equalsIgnoreCase("textura")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� est� sendo enviado para a warp "
						+ ChatColor.YELLOW + ChatColor.BOLD + " TEXTURA " + ChatColor.WHITE + "!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 99999));

				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);

				Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
					public void run() {
						Updater.UpdateScore(p);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);

						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						WarpsAPI.removerFPS();
						Prote��o.setImortalidade(p, true);

						WarpsAPI.Ir(p, "Textura");
						API.setWarp(p, "Textura");
						KitAPI.setKit(p, "Textura");
						Updater.UpdateScore(p);

						ItemStack Espada = new ItemStack(Material.STONE_SWORD);
						ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("�eEspada");
						Espada.setItemMeta(kEspada);

						ItemStack Espada1 = new ItemStack(Material.WOOD_SWORD);
						ItemMeta kEspada1 = Espada1.getItemMeta();
						kEspada1.setDisplayName("�eEspada1");
						Espada1.setItemMeta(kEspada1);

						ItemStack Espada2 = new ItemStack(Material.GOLD_SWORD);
						ItemMeta kEspada2 = Espada2.getItemMeta();
						kEspada2.setDisplayName("�eEspada2");
						Espada2.setItemMeta(kEspada2);

						ItemStack Espada3 = new ItemStack(Material.IRON_SWORD);
						ItemMeta kEspada3 = Espada3.getItemMeta();
						kEspada3.setDisplayName("�eEspada3");
						Espada3.setItemMeta(kEspada3);

						ItemStack Espada4 = new ItemStack(Material.DIAMOND_SWORD);
						ItemMeta kEspada4 = Espada4.getItemMeta();
						kEspada4.setDisplayName("�eEspada4");
						Espada4.setItemMeta(kEspada4);

						ItemStack Fisherman = new ItemStack(Material.FISHING_ROD);
						ItemMeta kFisherman = Fisherman.getItemMeta();
						kFisherman.setDisplayName("�eFisherman");
						Fisherman.setItemMeta(kFisherman);

						ItemStack Kangaroo = new ItemStack(Material.FIREWORK);
						ItemMeta kKangaroo = Kangaroo.getItemMeta();
						kKangaroo.setDisplayName("�eKangaroo");
						Kangaroo.setItemMeta(kKangaroo);

						p.getInventory().setItem(0, Espada);
						p.getInventory().setItem(1, Espada1);
						p.getInventory().setItem(2, Espada2);
						p.getInventory().setItem(3, Espada3);
						p.getInventory().setItem(4, Espada4);
						p.getInventory().setItem(13,
								API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 1, (short) 0));
						p.getInventory().setItem(14,
								API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 1, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "", new String[] {}, 1, (short) 0));

					}
				}, 3 * 20);
			}
			if (Args[0].equalsIgnoreCase("voidchallenge")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� est� sendo enviado para a warp "
						+ ChatColor.YELLOW + ChatColor.BOLD + " VOIDCHALLENGE " + ChatColor.WHITE + "!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999, 99999));

				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);

				Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
					public void run() {
						Updater.UpdateScore(p);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);

						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						WarpsAPI.removerFPS();
						Prote��o.setImortalidade(p, true);

						WarpsAPI.Ir(p, "VoidChallenge");
						API.setWarp(p, "VoidChallenge");
						KitAPI.setKit(p, "VoidChallenge");
						Updater.UpdateScore(p);

						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; i++) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}
						p.getInventory().setItem(13,
								API.criarItem(p, Material.RED_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(14,
								API.criarItem(p, Material.BROWN_MUSHROOM, "", new String[] {}, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "", new String[] {}, 64, (short) 0));

					}
				}, 3 * 20);
			}

		}
		return false;

	}
}
