package me.shooyudev.Habilites;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.shooyudev.Main;
import me.shooyudev.API.CooldownAPI;
import me.shooyudev.API.KitAPI;
import me.shooyudev.Utills.Strings;

public class Strong implements Listener {

	public static HashMap<Player, ItemStack[]> salvarArmadura = new HashMap<Player, ItemStack[]>();
	public static HashMap<Player, ItemStack[]> salvarInventario = new HashMap<Player, ItemStack[]>();

	public static ArrayList<Player> fulliron = new ArrayList<>();

	@EventHandler
	public void interagir(PlayerInteractEvent e) {

		final Player p = e.getPlayer();
		if ((KitAPI.getKit(p) == "Strong") && (CooldownAPI.Cooldown.containsKey(p.getName()))
				&& (p.getItemInHand().getType() == Material.WATCH)) {
			e.setCancelled(true);
			p.sendMessage(
					ChatColor.GRAY + "O Cooldown do " + ChatColor.YELLOW + ChatColor.BOLD + "Strong" + ChatColor.GRAY
							+ " acaba em: " + ChatColor.YELLOW + ChatColor.BOLD + CooldownAPI.Cooldown(p) + "s");
		} else {
			if ((KitAPI.getKit(p) == "Strong") && (!CooldownAPI.Cooldown.containsKey(p.getName())
					&& (p.getItemInHand().getType() == Material.WATCH))) {
				salvarInventario.put(p, p.getInventory().getContents());
				salvarArmadura.put(p, p.getInventory().getArmorContents());

				p.getInventory().setArmorContents(null);
				ItemStack Peito = new ItemStack(Material.IRON_CHESTPLATE);

				ItemStack Calça = new ItemStack(Material.IRON_LEGGINGS);

				ItemStack Bota = new ItemStack(Material.IRON_BOOTS);

				ItemStack Capacete = new ItemStack(Material.IRON_HELMET);

				p.getInventory().setChestplate(Peito);
				p.getInventory().setLeggings(Calça);
				p.getInventory().setHelmet(Capacete);
				p.getInventory().setBoots(Bota);
				p.updateInventory();
				CooldownAPI.addCooldown(p, 40);

				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você está " + ChatColor.YELLOW
						+ ChatColor.BOLD + "Fulliron" + ChatColor.GRAY + " por 10 segundos.");
				fulliron.add(p);

				if (fulliron.contains(p)) {
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {

							if (fulliron.contains(p)) {
								p.sendMessage("§aA Sua armadura foi retirada!");
								p.getInventory().setArmorContents(null);

								p.closeInventory();
								p.getInventory().remove(Material.IRON_CHESTPLATE);
								p.getInventory().remove(Material.IRON_LEGGINGS);
								p.getInventory().remove(Material.IRON_BOOTS);
								p.getInventory().remove(Material.IRON_HELMET);
								p.getInventory().remove(Material.IRON_SWORD);

								p.getInventory().setArmorContents(salvarArmadura.get(p));
							}

						}
					}, 10 * 20);

				} else {
				}
			}
		}
	}
}
