package me.shooyudev.Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Utills.Strings;

public class Tell implements CommandExecutor{
    public static HashMap<Player, Player> gettell;
    static ArrayList<Player> telloff;
    
    static {
        Tell.gettell = new HashMap<Player, Player>();
        Tell.telloff = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("tell")) {
            if (args.length == 0) {
                p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /tell <");
                return true;
            }
            final Player target = Bukkit.getPlayer(args[0]);
            if (args[0].toLowerCase().equalsIgnoreCase("on")) {
                Tell.telloff.remove(p);
                p.sendMessage(ChatColor.GREEN + "Você ativou o seu tell");
            }
            else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
                Tell.telloff.add(p);
                p.sendMessage(ChatColor.RED + "Você desativou o seu tell");
            }
            if (args.length > 1) {
                if (target == null) {
                    p.sendMessage(ChatColor.RED + "Voce precisa ser um player");
                    return true;
                }
                if (Tell.telloff.contains(target)) {
                    p.sendMessage("O tell desse player esta off");
                    return true;
                }
                final StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }
                final String allArgs = sb.toString().trim();
                p.sendMessage("§7[" + "Você -> " + target.getName() + "§7) " + allArgs);
                target.sendMessage("§7(" + "" + p.getName() + " §7-> " + "Você§7) " + allArgs);
                Tell.gettell.put(p, target);
                Tell.gettell.put(target, p);
            }
        }
        else if (label.equalsIgnoreCase("off")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Fale com o player no chat normal");
                return true;
            }
            if (!Tell.gettell.containsKey(p)) {
                p.sendMessage(ChatColor.RED + "Você não tem ninguem para responder");
                return true;
            }
            final Player deslogo = Tell.gettell.get(p);
            if (deslogo == null) {
                p.sendMessage(ChatColor.RED + "Voce precisa ser um player");
                return true;
            }
            if (Tell.telloff.contains(deslogo)) {
                p.sendMessage(ChatColor.RED + "O Tell desse jogador esta off !");
                return true;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; ++i) {
                sb.append(args[i]).append(" ");
            }
            final String allArgs = sb.toString().trim();
            p.sendMessage("§7[" + "§eVocê -> " + deslogo.getName() + "§7) " + allArgs);
            deslogo.sendMessage("§7(" + "" + p.getName() + " §7-> " + "§eVocê§7) " + allArgs);
            
        }
        return false;
    }
}

