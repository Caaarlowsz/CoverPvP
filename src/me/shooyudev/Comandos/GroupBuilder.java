package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ca.wacos.nametagedit.NametagAPI;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;
import me.shooyudev.scoreboarding.Updater;
public class GroupBuilder implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player p = (Player)sender;
		if(sender instanceof Player){
		if(cmd.getName().equalsIgnoreCase("groupbuilder")) {
			if (!(sender.hasPermission("cover.groupbuilder"))) {
				sender.sendMessage(Strings.permissaocomando);
				return true;
			}
			if(args.length == 1) {
				
			}
			if(args.length == 2) {
				Player playe = Bukkit.getPlayer(args[0]);
				if (playe == null) {
					p.sendMessage(Strings.playeroffiline);
					return true;
				}
				String grupo = args[1];
				Player player = Bukkit.getPlayer(args[0]);
				if(grupo.equalsIgnoreCase("false")) {
					p.sendMessage("§cVocê Tirou o Builder do Jogador: " + ChatColor.YELLOW + player.getName());
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Default");
					player.setDisplayName("§7" + player.getName());
					NametagAPI.setPrefix(player.getName(), "§7");
					NametagAPI.setSuffix(player.getName(), "§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
					Updater.UpdateScore(player);
					return true;
				}
				if(grupo.equalsIgnoreCase("true")) {
					p.sendMessage("§aVocê Ativou o Builder do Jogador: " + ChatColor.YELLOW + player.getName());
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Builder");
					player.setDisplayName("§e§lBUILDER §e" + player.getName());
					NametagAPI.setPrefix(player.getName(), "§e§lBUILDER §e");
					NametagAPI.setSuffix(player.getName(), "§7 " + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
					return true;
				}
			} else {
				p.sendMessage(Strings.servidormensagem+"§7Use /groupset <nick> <TRUE , FALSE> §7!");
			}
		} 
   }
		return false;
	}
}
