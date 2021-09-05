package me.shooyudev.Comandos;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.shooyudev.Utills.Strings;

public class Build implements CommandExecutor, Listener {

	public static ArrayList<String> embuild = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("build")) {
			if (p.hasPermission("cover.build"))
				if (!Build.embuild.contains(p.getName())) {
					Build.embuild.add(p.getName());
					p.sendMessage(Strings.servidormensagem + ChatColor.GREEN + "Você entrou no modo build.");
					return true;
				} else {
					Build.embuild.remove(p.getName());
					p.sendMessage(Strings.servidormensagem + ChatColor.RED + "Você saiu do modo build.");
					return true;
				}
		} else {
			p.sendMessage(Strings.permissaocomando);
		}
		return false;
	}

	@EventHandler
	public void onbloco(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (!Build.embuild.contains(p.getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onbloco(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (!Build.embuild.contains(p.getName())) {
			e.setCancelled(true);
		}
	}

}
