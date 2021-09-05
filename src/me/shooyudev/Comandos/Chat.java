package me.shooyudev.Comandos;

import org.bukkit.event.*;
import org.bukkit.event.player.*;

import me.shooyudev.Utills.Strings;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Chat implements Listener, CommandExecutor
{
    public static boolean onoff;
    
    static {
        Chat.onoff = true;
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent e) {
        if (!e.getPlayer().hasPermission("cover.falarchat") && !Chat.onoff) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O Chat esta desativado !");
        }
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayeronoff(final PlayerChatEvent e) {
        if (!e.getPlayer().hasPermission("cover.falarchat") && !Chat.onoff) {
            e.setCancelled(true);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("chat")) {
        if (sender.hasPermission("cover.falarchat")) {
        	if (args.length == 0) {
        		p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /chat <on , off , clear>");
        	}
            if (args.length > 0) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("off")) {
                        Chat.onoff = false;
                        Bukkit.broadcastMessage(Strings.servidormensagem + ChatColor.GRAY + "O Chat foi " + ChatColor.RED + ChatColor.BOLD + "Desativado" + ChatColor.GRAY + " !");
                    }
                    else if (args[0].equalsIgnoreCase("on")) {
                        Chat.onoff = true;
                        Bukkit.broadcastMessage(Strings.servidormensagem + ChatColor.GRAY + "O Chat foi " + ChatColor.GREEN + ChatColor.BOLD + "Ativado" + ChatColor.GRAY + " !");
                    }
                    if (args[0].equalsIgnoreCase("clear")) {
                    	for(int i = 1; i < 100; i++) {
                			Bukkit.broadcastMessage(" ");
                		}
                    	p.sendMessage(ChatColor.GREEN + "Chat foi limpo com sucesso !");
                    }
                }
            }
        } else {
        	sender.sendMessage(Strings.permissaocomando);
        }
        } else {
        	sender.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /chat <on , off>");
        }
        return true;
    }
}
