package me.shooyudev.Comandos;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Events.Proteção;
import me.shooyudev.Utills.Strings;

public class Tp implements CommandExecutor{

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if (p.hasPermission("cover.tp")){
		 if (cmd.getName().equalsIgnoreCase("tp")){
			if (args.length == 0){
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY +"Use /tp (jogador)");
				return true;
			}
			Player alvo = Bukkit.getPlayer(args[0]);
			p.teleport(alvo);
			p.sendMessage(Strings.servidormensagem + "§7Você foi teleportado para: §e§l" + alvo.getName());
			if (alvo == null){
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Este jogador esta offline.");
				return true;
			}
			return true;
		}
		 if (cmd.getName().equalsIgnoreCase("tphere")){
			 if (args.length == 0){
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /tphere (jogador)");
					return true;
				}
				Player alvo = Bukkit.getPlayer(args[0]);
				alvo.teleport(p);
				p.sendMessage(Strings.servidormensagem + "§7Você puxou: §e§l" + alvo.getName());
				alvo.sendMessage(Strings.servidormensagem + "§7Você foi puxado por: §e§l" + p.getName());
				if (alvo == null){
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Este jogador esta offline.");
					return true;
				}
				return true;
		 }
		 Player[] arrayOfPlayer;
	     int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
		 if ((cmd.getName().equalsIgnoreCase("tpall"))) {
	         s.teleport(p);
	         Proteção.setImortalidade(s, false);
	         s.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O Jogador " + ChatColor.YELLOW + ChatColor.BOLD + p.getName() + ChatColor.GRAY + " Puxou todos os jogadores para esse Local !");
	       } else {
	         p.sendMessage(Strings.permissaocomando);
		}
	     }
		}
		return false;
	}

}
