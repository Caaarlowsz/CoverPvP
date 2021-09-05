package me.shooyudev.Bans.Events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class Eventos implements Listener {

	@EventHandler
	void chatevent(PlayerChatEvent evento) {

		Player jogador = evento.getPlayer();

		if (Config.getConfig().getMute().get("Mute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, ChatColor.GRAY + "Você está " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE"
					+ ChatColor.GRAY + " Mutado.");

			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		} else if (Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, ChatColor.GRAY + "Você está " + ChatColor.DARK_RED + ChatColor.BOLD + "TEMPORARIAMENTE"
					+ ChatColor.GRAY + " Mutado.");
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
	}

	@EventHandler
	public void loginEvent(PlayerLoginEvent evento) {

		Player jogador = evento.getPlayer();
		if (Config.getConfig().getBans().get("Bans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY
					+ "§7Você foi §4§lPERMANENTEMENTE §7banido do servidor!" + "\n" + "\n" + "§7Username banido: §6§l"
					+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Nome") + "\n"
					+ "§7Banido por: §6§l"
					+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Banido por") + "\n"
					+ "§7Motivo: §6§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Motivo")
					+ "\n" + "§7Vencimento : §6§lNUNCA" + "\n" + "§7Data do banimento: §6§l"
					+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Data do banimento") + "\n"
					+ "§7Compre seu §6§lUNBAN §7em nossa loja: §6§nloja-arkuzmc.buycraft.net");
		} else if (Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					ChatColor.GRAY + "§7Você foi §4§lPERMANENTEMENTE §7ip banido do servidor!" + "\n" + "\n"
							+ "§7Username banido: §6§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Nome") + "\n"
							+ "§7IP banido: §6§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".IP do Jogador")
							+ "\n" + "§7Banido por: §6§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Banido por")
							+ "\n" + "§7Motivo: §6§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Motivo") + "\n"
							+ "§7Vencimento : §6§lNUNCA" + "\n" + "§7Data do banimento: §6§l"
							+ Config.getConfig().getIpBans()
									.get("IPBans." + jogador.getUniqueId() + ".Data do banimento")
							+ "\n" + "§7Compre seu §6§lUNBAN §7em nossa loja: §6§nloja-arkuzmc.buycraft.net");
		} else if (evento.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			evento.setKickMessage("§c§lWHITELIST ATIVADA..." + "\n" + "§7Estamos em manutenção!");
		}
	}
}