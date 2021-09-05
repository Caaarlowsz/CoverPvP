package me.shooyudev.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;

import me.shooyudev.Main;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.FpsEnum;
import me.shooyudev.Utills.Strings;

public class Principais implements Listener {

	@EventHandler
	public void fome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}

	@EventHandler
	public void chuva(WeatherChangeEvent e) {
		if (e.toWeatherState()) {
			e.setCancelled(true);
		}
	}

	public static String motd;
	public static String motd2;

	static {
		motd = Main.getInstance().getConfig().getString("Motd").replace("&", "§");
		motd2 = Main.getInstance().getConfig().getString("Motd2").replace("&", "§");
	}

	@EventHandler
	public void motdDoservidor(ServerListPingEvent event) {
		event.setMotd(motd + "\n" + motd2);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		event.setFormat(player.getDisplayName() + ChatColor.GRAY + ChatColor.GRAY + " [" + Manager.prefix(player)
				+ ChatColor.GRAY + "] " + ": " + "" + ChatColor.WHITE + event.getMessage().replace("%", "Porcento(s)"));
		if (player.hasPermission("cover.falarcolorido")) {
			event.setFormat(event.getFormat().replace("&", "§"));
		}
	}

	@EventHandler
	public void Bread(PlayerMoveEvent e) {
		if (Main.estado == FpsEnum.FPS1
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.GLASS)) {
			Proteção.setImortalidade(e.getPlayer(), false);
		}
	}

	@EventHandler
	public void Plugin(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().toLowerCase().startsWith("/pl") || e.getMessage().toLowerCase().startsWith("/plugins")
				|| e.getMessage().toLowerCase().startsWith("//calc")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:pl")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:plugins")
				|| e.getMessage().toLowerCase().startsWith("/about") || e.getMessage().toLowerCase().startsWith("/ver")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:about")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:ver")
				|| e.getMessage().toLowerCase().startsWith("/help") || e.getMessage().toLowerCase().startsWith("/?")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:?")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:help")) {
			p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Este comando não existe!");
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void ComandoNaoExiste(PlayerCommandPreprocessEvent e) {
		if (e.isCancelled()) {
			return;
		}
		Player p = e.getPlayer();
		String msg = e.getMessage().split(" ")[0];
		HelpTopic t = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		if (t == null) {
			e.setCancelled(true);
			p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Este comando não existe!");
		}
	}

	@EventHandler
	public void Soup(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Damageable hp = p;
		if (hp.getHealth() != 20.0D) {
			int sopa = 7;
			if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
					&& (p.getItemInHand().getTypeId() == 282)) {
				p.setHealth(hp.getHealth() + sopa > hp.getMaxHealth() ? hp.getMaxHealth() : hp.getHealth() + sopa);
				p.getItemInHand().setType(Material.BOWL);
			}
		}
	}

	@EventHandler
	public void onCheio(final PlayerLoginEvent event) {
		final Player p = event.getPlayer();
		if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			if (p.hasPermission("cover.entrarcheio")) {
				event.setResult(PlayerLoginEvent.Result.ALLOWED);
			} else {
				event.setKickMessage(Strings.servidormensagem + "\n" + "\n" + "   §7O servidor esta lotado " + "\n"
						+ "Voce deu seu lugar a um vip " + "\n" + "Voce quer ter essa permissao ?" + "\n" + "\n"
						+ "Compre vip em nosso Site : §n§owww.cover.com.br");
			}
		} else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			if (p.hasPermission("cover.entrarmanutençao")) {
				event.setKickMessage(
						Strings.servidormensagem + "\n" + "\n" + "   §7O servidor acabou de entrar em manutençao" + "\n"
								+ "Assim que possível, nós estaremos de volta!" + "\n" + "\n" + "§7Atenciosamente, "
								+ Strings.servidor);
			}
		}
	}

	@EventHandler
	public void onMe(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().toLowerCase().startsWith("/me")) {
			e.setCancelled(true);
			p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Este comando não existe!");
		}
	}

	@EventHandler
	public void aoEscrever(SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", "§"));
		}
		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", "§"));
		}
		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", "§"));
		}
		if (e.getLine(3).contains("&")) {
			e.setLine(3, e.getLine(3).replace("&", "§"));
		}

	}

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if ((e.getDamager() instanceof Player)) {
			Player d = (Player) e.getDamager();
			if ((d.getItemInHand().getType() == Material.DIAMOND_SWORD)
					|| (d.getItemInHand().getType() == Material.STONE_SWORD)
					|| (d.getItemInHand().getType() == Material.WOOD_SWORD)
					|| (d.getItemInHand().getType() == Material.STONE_SWORD)
					|| (d.getItemInHand().getType() == Material.IRON_SWORD)
					|| (d.getItemInHand().getType() == Material.GOLD_SWORD)
					|| (d.getItemInHand().getType() == Material.FISHING_ROD)
					|| (d.getItemInHand().getType() == Material.DIAMOND_AXE)
					|| (d.getItemInHand().getType() == Material.GOLD_AXE)
					|| (d.getItemInHand().getType() == Material.STONE_AXE)
					|| (d.getItemInHand().getType() == Material.WOOD_AXE)
					|| (d.getItemInHand().getType() == Material.IRON_AXE)) {
				d.getItemInHand().setDurability((short) 0);
				d.updateInventory();
			}
		}
	}

	@EventHandler
	public void noBreaking(PlayerInteractEvent e) {

		Player p = e.getPlayer();

		if (p.getItemInHand().getType() == Material.FISHING_ROD) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				p.getItemInHand().setDurability((short) 0);
				p.updateInventory();
			}
		}
	}

	@EventHandler
	public void clicarBussola(PlayerInteractEvent e) {

		boolean parar = false;
		if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {

			for (Entity entidades : e.getPlayer().getNearbyEntities(100, 150, 100)) {

				if ((entidades instanceof Player)
						&& e.getPlayer().getLocation().distance(entidades.getLocation()) >= 9) {

					if (entidades.getLocation().getY() > 170) {
						return;
					}
					parar = true;
					e.getPlayer().setCompassTarget(entidades.getLocation());
					e.getPlayer()
							.sendMessage("§7A Bússula apontou para o jogador: §e" + ((Player) entidades).getName());
					return;
				}
			}
			if (!parar) {
				e.getPlayer().sendMessage("§7A Bússula nao encontrou nenhum jogador");
				e.getPlayer().setCompassTarget(new Location(e.getPlayer().getWorld(), 0, 100, 0));
				return;
			}
		}
	}
}
