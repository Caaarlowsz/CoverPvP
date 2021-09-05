package me.shooyudev.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.API.WarpsAPI;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class SetWarp extends Manager {

	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {

		Player player = (Player) sender;

		if (command.getName().equalsIgnoreCase("set")) {
			if (player.hasPermission("cover.set")) {
				if (argumentos.length == 0) {
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY
							+ "Use /set <fps1 , fps2, challenge, knockback, void, spawn>");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("fps1")) {
					WarpsAPI.Set(player, "Fps1");
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce setou a Warp "
							+ ChatColor.YELLOW + ChatColor.BOLD + "Fps1" + ChatColor.GRAY + " Com sucesso !");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("fps2")) {
					WarpsAPI.Set(player, "Fps2");
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce setou a Warp "
							+ ChatColor.YELLOW + ChatColor.BOLD + "Fps2" + ChatColor.GRAY + " Com sucesso !");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("challenge")) {
					WarpsAPI.Set(player, "Challenge");
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce setou a Warp "
							+ ChatColor.YELLOW + ChatColor.BOLD + "Challenge" + ChatColor.GRAY + " Com sucesso !");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("spawn")) {
					WarpsAPI.Set(player, "Spawn");
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce setou a Warp "
							+ ChatColor.YELLOW + ChatColor.BOLD + "Spawn" + ChatColor.GRAY + " Com sucesso !");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("knockback")) {
					WarpsAPI.Set(player, "Knockback");
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce setou a Warp "
							+ ChatColor.YELLOW + ChatColor.BOLD + "Spawn" + ChatColor.GRAY + " Com sucesso !");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("fisherman")) {
					WarpsAPI.Set(player, "Fisherman");
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce setou a Warp "
							+ ChatColor.YELLOW + ChatColor.BOLD + "Fisherman" + ChatColor.GRAY + " Com sucesso !");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("texturas")) {
					WarpsAPI.Set(player, "Texturas");
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce setou a Warp "
							+ ChatColor.YELLOW + ChatColor.BOLD + "Textura" + ChatColor.GRAY + " Com sucesso !");
					return;
				}
				if (argumentos[0].equalsIgnoreCase("void")) {
					WarpsAPI.Set(player, "VoidChallenge");
					player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce setou a Warp "
							+ ChatColor.YELLOW + ChatColor.BOLD + "VoidChallenge" + ChatColor.GRAY + " Com sucesso !");
					return;
				}
			}
		}
	}

}
