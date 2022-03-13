package me.shooyudev.Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.API.API;
import me.shooyudev.API.KitAPI;
import me.shooyudev.API.StatsManager;
��o;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Admin implements CommandExecutor, Listener {
	public static ArrayList<Player> emAdmin;
	public static HashMap<String, ItemStack[]> salvarinv;
	public static HashMap<String, ItemStack[]> salrvararmor;
	public static HashMap<String, ItemStack[]> salvarinventarioautosoup;
	public static ArrayList<String> aotestarautosoup;

	public static ArrayList<String> hacks = new ArrayList<>();

	static {
		Admin.emAdmin = new ArrayList<Player>();
		Admin.salvarinv = new HashMap<String, ItemStack[]>();
		Admin.salrvararmor = new HashMap<String, ItemStack[]>();
		Admin.salvarinventarioautosoup = new HashMap<String, ItemStack[]>();
		Admin.aotestarautosoup = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("admin")) {
			if (p.hasPermission("cover.admin")) {
				if (!Admin.emAdmin.contains(p)) {
					Admin.emAdmin.add(p);
					Admin.salvarinv.put(p.getName(), p.getInventory().getContents());
					Admin.salrvararmor.put(p.getName(), p.getInventory().getArmorContents());
					Prote��o.setImortalidade(p, true);
					p.getInventory().clear();
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce entrou no modo admin");
					p.setHealth(20.0);
					p.setFireTicks(0);
					p.setGameMode(GameMode.CREATIVE);
					API.darItem(p, Material.MAGMA_CREAM, 1, ChatColor.YELLOW + "" + ChatColor.BOLD + "Trocar - "
							+ ChatColor.GRAY + "(Clique para Sair/Voltar)", 1);
					API.darItem(p, Material.PAPER, 1, ChatColor.YELLOW + "" + ChatColor.BOLD + "Informa�oes - "
							+ ChatColor.GRAY + "(Clique para checar)", 5);
					API.darItem(p, Material.FEATHER, 1, ChatColor.YELLOW + "" + ChatColor.BOLD + "Nofall - "
							+ ChatColor.GRAY + "(Clique para testar nofall)", 3);
					API.darItemEnchant(
							p, Material.STICK, 1, ChatColor.YELLOW + "" + ChatColor.BOLD + "KnockBack - "
									+ ChatColor.GRAY + "(Clique para testar knockback)",
							7, Enchantment.KNOCKBACK, 17, true);
					API.darItem(p, Material.BEDROCK, 1, ChatColor.YELLOW + "" + ChatColor.BOLD + "Cage - "
							+ ChatColor.GRAY + "(Clique para prender o Player)", 4);
					p.updateInventory();
					Player[] onlinePlayers;
					if (p.hasPermission("cover.admin")) {
						for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
							final Player todos = onlinePlayers[i];
							todos.hidePlayer(p);
						}
					}
				} else {
					Admin.emAdmin.remove(p);
					p.getInventory().clear();
					p.getInventory().setContents((ItemStack[]) Admin.salvarinv.get(p.getName()));
					p.getInventory().setArmorContents((ItemStack[]) Admin.salrvararmor.get(p.getName()));
					p.updateInventory();
					p.setHealth(20.0);
					p.setFireTicks(0);
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce saiu do modo admin");
					Player[] onlinePlayers2;
					for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
						final Player todos = onlinePlayers2[j];
						todos.showPlayer(p);
					}
				}
			} else {
				p.sendMessage(Strings.permissaocomando);
			}
		}
		return false;
	}

	@EventHandler
	public void Sair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Admin.emAdmin.contains(p)) {
			Admin.emAdmin.remove(p);
		}
	}

	@EventHandler
	public void InfoPlayer(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player t = (Player) e.getRightClicked();
		if (Admin.emAdmin.contains(p) && p.getInventory().getItemInHand().getType() == Material.PAPER) {
			final Damageable hp = (Damageable) t;
			p.sendMessage(" ");
			p.sendMessage("         " + ChatColor.GOLD + ChatColor.BOLD + "�6�  " + ChatColor.RED + ChatColor.BOLD
					+ "CHECANDO" + ChatColor.GOLD + ChatColor.BOLD + " �6�          ");
			p.sendMessage(" ");
			p.sendMessage(ChatColor.WHITE + "- " + "�7NickName: �6" + t.getDisplayName());
			p.sendMessage(ChatColor.WHITE + "- " + "�7Vida: �6" + (int) hp.getHealth());
			p.sendMessage(ChatColor.WHITE + "- " + "�7Kit: �6" + KitAPI.getKit(t));
			p.sendMessage(ChatColor.WHITE + "- " + "�7Rank: �6" + Manager.RankAndPrefix(t));
			p.sendMessage(ChatColor.WHITE + "- " + "�7Matou: �6" + StatsManager.getKills(t));
			p.sendMessage(ChatColor.WHITE + "- " + "�7Morreu: �6" + StatsManager.getDeaths(t));
			p.sendMessage(ChatColor.WHITE + "- " + "�7Xp: �6" + StatsManager.getXp(t));
			p.sendMessage(ChatColor.WHITE + "- " + "�7Coins: �6" + StatsManager.getCoins(t));
			p.sendMessage(ChatColor.WHITE + "- " + "�7IP: �6" + t.getAddress().getHostString());
			p.sendMessage(" ");
		}
	}

	@EventHandler
	public void Trocar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Admin.emAdmin.contains(p)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.MAGMA_CREAM) {
			e.setCancelled(true);
			final BukkitScheduler scheduler = Bukkit.getScheduler();
			scheduler.scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.chat("/admin");
				}
			}, 0L);
			scheduler.scheduleSyncDelayedTask(CoverPvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.chat("/admin");
				}
			}, 15L);
		}
	}

	@EventHandler
	public void Nofall(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player t = (Player) e.getRightClicked();
		if (Admin.emAdmin.contains(p)) {
			if (p.getInventory().getItemInHand().getType() == Material.FEATHER) {
				t.setVelocity(new Vector(0, 2, 0));
			}
			if (p.getInventory().getItemInHand().getType() == Material.AIR) {
				p.openInventory((Inventory) t.getInventory());
			}
		}
	}

	@EventHandler
	public void Sair(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Admin.emAdmin.contains(p)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.REDSTONE) {
			p.chat("/admin");
		}
	}

	@EventHandler
	public void Cage(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player t = (Player) e.getRightClicked();

		if (Admin.emAdmin.contains(p) && p.getItemInHand().getType() == Material.BEDROCK) {
			t.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.teleport(t.getLocation().add(0.0, 11.0, -0.07));
			p.teleport(t.getLocation().add(3.0, 0.0, 0.05));

		}
	}

}
