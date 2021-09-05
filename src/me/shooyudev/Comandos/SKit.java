package me.shooyudev.Comandos;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import me.shooyudev.Utills.Strings;

public class SKit implements Listener, CommandExecutor {
	
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, ItemStack[]> kit = new HashMap();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, ItemStack[]> armadura = new HashMap();
	  
	  public boolean isInt(String s)
	  {
	    try
	    {
	      Integer.parseInt(s);
	      return true;
	    } catch (NumberFormatException localNumberFormatException) {
	    }
	    return false;
	  }
	
	  @SuppressWarnings({ })
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
	    Player p = (Player)sender;
	    if ((cmd.getName().equalsIgnoreCase("skit")) && (p.hasPermission("cover.skit"))){
	      if (args.length == 0){
		        p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /skit <Criar> <aplicar> <nome> <distancia>");
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("criar")){
	        if (args.length == 1){
	          p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /skit criar <nome> ");
	          return true;
	        }
	        String name = args[1];
	       kit.put(name, p.getInventory().getContents());
	       armadura.put(name, p.getInventory().getArmorContents());
	        p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O kit " + args[1] + " foi criado com Sucesso!");
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("aplicar")){
	        if (args.length <= 2){
	          p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /skit aplicar <kit> <distancia>");
	          return true;
	        }
	        String name = args[1];
	        if ((!this.kit.containsKey(name)) && (!this.armadura.containsKey(name))){
	          p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O kit " + name + " se encontra inexistente no sistema!");
	          return true;
	        }
	        if (isInt(args[2])){
	          int numero = Integer.parseInt(args[2]);
	          for (Entity ent : p.getNearbyEntities(numero, numero, numero)) {
	            if (!(ent instanceof Player))
	              continue;
	            Player plr = (Player)ent;
	            plr.getInventory().setArmorContents((ItemStack[])this.armadura.get(name));
	            plr.getInventory().setContents((ItemStack[])this.kit.get(name));
	          }
	          p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O kit " + ChatColor.YELLOW + ChatColor.BOLD + args[1] + ChatColor.GRAY + " foi aplicado para todos !");
	          return true;
	        }
	      }
	    }
		return true;
	  }
}