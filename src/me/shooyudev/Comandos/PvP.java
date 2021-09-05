package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.shooyudev.Events.Proteção;
import me.shooyudev.Utills.Strings;

public class PvP implements CommandExecutor, Listener {

	public static boolean pvp = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp")) {
			if (p.hasPermission("cover.pvp")) {
				if (args.length == 0) {
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /pvp <ON , OFF>");
					return true;
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("on")) {
						if ((pvp)) {
							p.sendMessage(ChatColor.GREEN + "O pvp já está ativado!");
							return true;
						}
						pvp = true;
						p.sendMessage(ChatColor.GREEN + "Você ativou o pvp!");
						Bukkit.broadcastMessage(ChatColor.GREEN + "O PvP global foi Ativado !");
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("off")) {
					if (!(pvp)) {
						p.sendMessage(ChatColor.RED + "O PvP já está desativado!");
						return true;
					}
					pvp = false;
					Proteção.setImortalidade(p, false);
					p.sendMessage(ChatColor.RED + "Você desativou o pvp!");
					Bukkit.broadcastMessage(ChatColor.RED + "O PvP global foi Desativado !");
					return true;
				}
			} else {
				p.sendMessage(Strings.permissaocomando);
			}
		}
		return false;
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			if (!(pvp)) {
				e.setCancelled(true);
			}
		}
	}
}
