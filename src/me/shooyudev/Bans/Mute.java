package me.shooyudev.Bans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.API.HorarioAPI;
import me.shooyudev.Bans.Events.API;
import me.shooyudev.Bans.Events.Config;
import me.shooyudev.Utills.Strings;


public class Mute implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("mute")) {
			if (!jogador.hasPermission("cover.bans")) {
			API.sendMsg(jogador, Strings.permissaocomando);
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/mute <jogador> <motivo>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, Strings.playeroffiline);
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName().equals("TranquilliYT")) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você esta bloqueado de Mutar o " + ChatColor.DARK_RED + ChatColor.BOLD + "DONO" + ChatColor.DARK_RED + " TranquilliYT");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName().equals("TranquilliYT")) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você esta bloqueado de Mutar o " + ChatColor.DARK_RED + ChatColor.BOLD + "DONO" + ChatColor.DARK_RED + " TranquilliYT");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Voce nao pode usar esse comando em vc mesmo !");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Mute." + vitima.getUniqueId()) != null)  {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "O jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + " Já está " + ChatColor.DARK_RED + ChatColor.BOLD + "PERMANENTEMENTE" + ChatColor.GRAY + " Mutado !");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (args.length == 1) {
				API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "/mute <jogador> <motivo>");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			API.sendMsg(jogador, Strings.servidormensagem + ChatColor.GRAY + "Você mutou o jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + ".");
			API.sendStaff(Strings.servidormensagem + ChatColor.GRAY + "O Staff " + ChatColor.YELLOW + ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + " mutou o jogador " + ChatColor.YELLOW + ChatColor.BOLD + vitima.getName() + ChatColor.GRAY + ". Motivo: " + ChatColor.YELLOW + ChatColor.BOLD + Motivo);
			API.sendMsg(vitima, Strings.servidormensagem + ChatColor.GRAY + "Você foi Mutado por: " + ChatColor.YELLOW + ChatColor.BOLD + jogador.getName() + ChatColor.GRAY + ". Motivo: " + ChatColor.YELLOW + ChatColor.BOLD + Motivo);
									 
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Nome", vitima.getName());
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Motivo", Motivo);
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
			Config.getConfig().saveMute();
			return true;
		}
		return false;
		
	}
}
