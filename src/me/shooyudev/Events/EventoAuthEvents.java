package me.shooyudev.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;

public class EventoAuthEvents implements Listener {

	@EventHandler
	public void Mover(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			p.teleport(p);
		}
	}

	@EventHandler
	public void onPickUp(PlayerPickupItemEvent event) {
		Player p = event.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onClickInventorySpec(InventoryClickEvent event) {

		Player p = (Player) event.getWhoClicked();
		if (CoverPvP.login.contains(p.getName())) {
			event.setCancelled(true);
			p.updateInventory();
		}
	}

	@EventHandler
	public void onOpenInventorySpec(InventoryOpenEvent event) {
		Player p = (Player) event.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player p = event.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onChat(PlayerChatEvent event) {
		Player p = event.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player p = (Player) event.getEntity();
			if (CoverPvP.login.contains(p.getName())) {
				event.setCancelled(true);
			}
		}
		if ((event.getDamager() instanceof Player)) {
			Player p = (Player) event.getDamager();
			if (CoverPvP.login.contains(p.getName())) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void Mover(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (CoverPvP.login.contains(p.getName())) {
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void aoCMD(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String cmd = e.getMessage();
		if (CoverPvP.login.contains(p.getName())) {
			if ((cmd.startsWith("/login")) || (cmd.startsWith("/register"))) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
		}
	}
}
