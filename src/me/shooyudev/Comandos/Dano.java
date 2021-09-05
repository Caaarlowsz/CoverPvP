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
import org.bukkit.event.entity.EntityDamageEvent;

import me.shooyudev.Utills.Strings;

public class Dano implements CommandExecutor, Listener {

	public static boolean Dano = false;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] argumentos) {
		Player p = (Player) sender;

		if (p.hasPermission("cover.dano")) {
			if (command.getName().equalsIgnoreCase("dano")) {
				if (argumentos.length == 0) {
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /dano <ON , OFF>");
					return true;
				}
				if (argumentos[0].equalsIgnoreCase("on")) {
					if ((Dano)) {
						p.sendMessage(ChatColor.GREEN + "O Dano ja esta ativado !");
						return true;
					}
					Dano = true;
					p.sendMessage(ChatColor.GREEN + "Você ativou o dano !");
					Bukkit.broadcastMessage(ChatColor.GREEN + "O Dano do servidor Foi desativado !");
					return true;
				}
				if (argumentos[0].equalsIgnoreCase("off")) {
					if (!(Dano)) {
						p.sendMessage(ChatColor.RED + "O Dano ja esta desativado !");
					}
					Dano = false;
					p.sendMessage(ChatColor.RED + "Você desativou o dano !");
					Bukkit.broadcastMessage(ChatColor.RED + "O Dano do servidor Foi desativado !");
					return true;
				}
			}
		} else {
			p.sendMessage(Strings.permissaocomando);
			return true;
		}
		return false;
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			if (!(Dano)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void aoDano(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			if (!(Dano)) {
				e.setCancelled(true);
			}
		}
	}
}
