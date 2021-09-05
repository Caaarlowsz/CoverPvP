package me.shooyudev.Habilites;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.shooyudev.API.CooldownAPI;
import me.shooyudev.API.KitAPI;
import me.shooyudev.Utills.Strings;

public class Monk implements Listener {

	@EventHandler
	public void monkHabilidade(PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();

		if ((e.getRightClicked() instanceof Player)) {
			Player jogadorClicado = (Player) e.getRightClicked();

			if ((p.getItemInHand().getType() == Material.BLAZE_ROD) && (KitAPI.getKit(p) == "Monk")
					&& (CooldownAPI.Cooldown.containsKey(p.getName()))) {
				e.setCancelled(true);
				p.sendMessage(
						ChatColor.GRAY + "O Cooldown do " + ChatColor.YELLOW + ChatColor.BOLD + "Monk" + ChatColor.GRAY
								+ " acaba em: " + ChatColor.YELLOW + ChatColor.BOLD + CooldownAPI.Cooldown(p) + "s");
				return;
			}
			if ((p.getItemInHand().getType() == Material.BLAZE_ROD) && (KitAPI.getKit(p) == "Monk")
					&& (!CooldownAPI.Cooldown.containsKey(p.getName()))) {

				int random = new Random().nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);

				ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
				ItemStack ItemMudado = jogadorClicado.getItemInHand();

				jogadorClicado.setItemInHand(ItemSelecionado);
				jogadorClicado.getInventory().setItem(random, ItemMudado);
				jogadorClicado.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Você foi monkado !");

				CooldownAPI.addCooldown(p, 15);
			}
			return;
		}
	}
}
