package me.shooyudev.Bans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.API.HorarioAPI;
import me.shooyudev.Bans.Events.API;
import me.shooyudev.Bans.Events.Config;
import me.shooyudev.Utills.Strings;

public class Ban implements CommandExecutor {

	@SuppressWarnings({ "deprecation" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player)sender;	
		if (cmd.getName().equalsIgnoreCase("ban")) {
			if (!jogador.hasPermission("cover.bans")) {
			API.sendMsg(jogador, Strings.permissaocomando);
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/ban <jogador> <motivo>");
                
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[0]);
				if (vitimaoff.getName() == jogador.getName()) {
					API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Voce nao pode usar esse comando em vc mesmo !");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (vitimaoff.getName().equals("TranquilliYT")) {
					API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você esta bloqueado de banir o " + ChatColor.DARK_RED + ChatColor.BOLD + "DONO" + ChatColor.DARK_RED + " TranquilliYT");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getBans().get("Bans." + vitimaoff.getUniqueId()) != null)  {
					 API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitimaoff.getName() + ChatColor.GRAY + " Já está " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " Banido !");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
				}
				if (Config.getConfig().getIpBans().get("IPBans." + vitimaoff.getUniqueId()) != null)  {
					API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitimaoff.getName() + ChatColor.GRAY + " Já está " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " Banido pelo seu IP!");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
				}
				String Motivo = "";
				for (int i = 1; i < args.length; i++) {
					Motivo = Motivo + args[i] + " ";
				}
				double l = Config.getConfig().getBans().getDouble("Players Banidos");
				API.sendBC(ChatColor.GRAY + "O Staff " + ChatColor.YELLOW + ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " baniu " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " O jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitimaoff.getName() + ChatColor.GRAY + ". Motivo: " + ChatColor.GOLD + ChatColor.BOLD + Motivo);
				API.sendMsg(jogador, ChatColor.GRAY + "Você baniu o jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitimaoff.getName() + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " .");
				API.sendStaff(ChatColor.GRAY + "O Staff " + ChatColor.YELLOW + ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " baniu o jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitimaoff.getName() + ChatColor.GRAY + ". Motivo: " + ChatColor.YELLOW + ChatColor.BOLD + Motivo);
				
				Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l + 1.0D));
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Nome", vitimaoff.getName());
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Motivo", Motivo);
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				Config.getConfig().saveBans();
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Voce nao pode usar esse comando em vc mesmo !");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + " Já está " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " Banido !");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null)  {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + " Já está " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " Banido pelo seu IP!");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (vitima.getName().equals("TranquilliYT")) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você esta bloqueado de banir o " + ChatColor.DARK_RED + ChatColor.BOLD + "DONO" + ChatColor.DARK_RED + " TranquilliYT");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args.length == 1) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/ban <jogador> <motivo>");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			double l = Config.getConfig().getBans().getDouble("Players Banidos");
			API.sendMsg(jogador, ChatColor.GRAY + "Você baniu o jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitima.getName() + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " .");
			API.sendBC(ChatColor.GRAY + "O Staff " + ChatColor.YELLOW + ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " baniu " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " O jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + ". Motivo: " + ChatColor.YELLOW + ChatColor.BOLD + Motivo);
			API.sendStaff(ChatColor.GRAY + "O Staff " + ChatColor.YELLOW + ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " baniu o jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + ". Motivo: " + ChatColor.YELLOW + ChatColor.BOLD + Motivo);
			vitima.kickPlayer("§7Você foi §4§lPERMANENTEMENTE §7banido do servidor!" + "\n" + "\n" + "§7Username banido: §6§l" + vitima.getName() + "\n" + "§7Banido por: §6§l" + jogador.getName() + "\n" + "§7Motivo: §6§l" + Motivo + "\n" + "§7Vencimento : §6§lNUNCA" + "\n" + "§7Data do banimento: §6§l" + HorarioAPI.getHorario() + "\n" + "§7Compre seu §6§lUNBAN §7em nossa loja: §6§nloja-arkuzmc.buycraft.net");
			
			Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l + 1.0D));
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Nome", vitima.getName());
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Motivo", Motivo);
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
			Config.getConfig().saveBans();
			return true;							 
 		}
		return false;
	}
}
