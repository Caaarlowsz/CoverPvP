package me.shooyudev.Bans.Events;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.spigotmc.ProtocolInjector;
import org.spigotmc.event.entity.EntityMountEvent;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.EnumClientCommand;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayInClientCommand;
import net.minecraft.server.v1_7_R4.PlayerConnection;

@SuppressWarnings({ "unused", "deprecation" })
public class Eventos implements Listener {

	@EventHandler
	void chatevent(PlayerChatEvent evento) {
		
		Player jogador = evento.getPlayer();
		
		if (Config.getConfig().getMute().get("Mute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, ChatColor.GRAY + "Você está " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " Mutado.");
			
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
		else if (Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, ChatColor.GRAY + "Você está " + ChatColor.DARK_RED + ChatColor.BOLD + "TEMPORARIAMENTE" + ChatColor.GRAY + " Mutado.");
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
	}
	@EventHandler
	public void loginEvent(PlayerLoginEvent evento) {
		
		Player jogador = evento.getPlayer();
		if (Config.getConfig().getBans().get("Bans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY + "§7Você foi §4§lPERMANENTEMENTE §7banido do servidor!" + "\n" + "\n" + "§7Username banido: §6§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Nome") + "\n" + "§7Banido por: §6§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Banido por") + "\n" + "§7Motivo: §6§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Motivo") + "\n" + "§7Vencimento : §6§lNUNCA" + "\n" + "§7Data do banimento: §6§l" + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Data do banimento") + "\n" + "§7Compre seu §6§lUNBAN §7em nossa loja: §6§nloja-arkuzmc.buycraft.net");
		}
		else if (Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY + "§7Você foi §4§lPERMANENTEMENTE §7ip banido do servidor!" + "\n" + "\n" + "§7Username banido: §6§l" + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Nome") + "\n" + "§7IP banido: §6§l" + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".IP do Jogador") + "\n" + "§7Banido por: §6§l" + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Banido por") + "\n" + "§7Motivo: §6§l" + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Motivo") + "\n" + "§7Vencimento : §6§lNUNCA" + "\n" + "§7Data do banimento: §6§l" + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Data do banimento") + "\n" + "§7Compre seu §6§lUNBAN §7em nossa loja: §6§nloja-arkuzmc.buycraft.net");
		}
		else if (evento.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			evento.setKickMessage("§c§lWHITELIST ATIVADA..." + "\n" + "§7Estamos em manutenção!"); 
 		}
	}
}