package me.shooyudev.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ca.wacos.nametagedit.NametagAPI;
import me.shooyudev.API.InteractiveChat;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Tag implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player)sender;
		
		if (command.getName().equalsIgnoreCase("tag")) {
			if (args.length == 0) {
				if (p.hasPermission("tag.dono")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.DARK_RED + ChatColor.BOLD + "DONO", "/tag dono", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.DARK_RED + ChatColor.BOLD + "DONO");
				}
				if (p.hasPermission("tag.admin")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.RED + ChatColor.BOLD + "ADMIN", "/tag admin", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.RED + ChatColor.BOLD + "ADMIN+");
				}
				if (p.hasPermission("tag.gerente")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.RED + ChatColor.BOLD + "GERENTE", "/tag gerente", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.RED + ChatColor.BOLD + "GERENTE");
				}
				if (p.hasPermission("tag.mod+")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "MOD+", "/tag mod+", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "MOD+");
				}
				if (p.hasPermission("tag.mod")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "MOD", "/tag mod", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "MOD");
				}
				if (p.hasPermission("tag.trial")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "TRIAL", "/tag trial", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "TRIAL");
				}
				if (p.hasPermission("tag.helper")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.BLUE + ChatColor.BOLD + "HELPER", "/tag helper", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.BLUE + ChatColor.BOLD + "HELPER");
				}
				if (p.hasPermission("tag.builder+")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.YELLOW + ChatColor.BOLD + "BUILDER+", "/tag builder+", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.YELLOW + ChatColor.BOLD + "BUILDER+");
				}
				if (p.hasPermission("tag.builder")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.YELLOW + ChatColor.BOLD + "BUILDER", "/tag builder", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.YELLOW + ChatColor.BOLD + "BUILDER");
				}
				if (p.hasPermission("tag.youtuber+")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.DARK_AQUA + ChatColor.BOLD + "YOUTUBER+", "/tag youtuber+", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.DARK_AQUA + ChatColor.BOLD + "YOUTUBER+");
				}
				if (p.hasPermission("tag.semiyt")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.YELLOW + ChatColor.BOLD + "SEMIYT", "/tag semiyt", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.YELLOW + ChatColor.BOLD + "SEMI-YT");
				}
				if (p.hasPermission("tag.youtuber")) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.AQUA + ChatColor.BOLD + "YOUTUBER", "/tag youtuber", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.AQUA + ChatColor.BOLD + "YOUTUBER");
     			}
				if (p.hasPermission("tag.pro") || Habilitar.pro) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.GOLD + ChatColor.BOLD + "PRO", "/tag pro", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.GOLD + ChatColor.BOLD + "PRO");
				}
				if (p.hasPermission("tag.mvp") || Habilitar.mvp || Habilitar.pro) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.BLUE +  "" + ChatColor.BOLD + "MVP", "/tag mvp", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.BLUE + ChatColor.BOLD + "MVP");
				}
				if (p.hasPermission("tag.vip") || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.GREEN + ChatColor.BOLD + "VIP", "/tag vip", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.GREEN + ChatColor.BOLD + "VIP");
				}
				InteractiveChat.command(p.getName(), ChatColor.WHITE + "- " + ChatColor.GRAY + "" + ChatColor.BOLD + "NORMAL", "/tag normal", ChatColor.WHITE + "Clique para selecionar a tag " + ChatColor.WHITE + ChatColor.BOLD + "NORMAL");
			   p.sendMessage(" ");
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Para usar uma tag digite: " + ChatColor.YELLOW + "/tag <tag>");
				return true;
			}
			if (args[0].equalsIgnoreCase("normal")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.BOLD + "NORMAL");
				
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.GRAY + "", ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.GRAY + "" + p.getName());
				//
				return true;
			}
			if (args[0].equalsIgnoreCase("vip")) {
				if (p.hasPermission("tag.vip") || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.GREEN + ChatColor.BOLD + "VIP");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.GREEN + "" + ChatColor.BOLD + "VIP " + ChatColor.GREEN, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "VIP " + ChatColor.GREEN + p.getName());
				//
				return true;
				} else {
					p.sendMessage(Strings.permissaotag);
				}
				}
			if (args[0].equalsIgnoreCase("mvp")) {
				if (p.hasPermission("tag.mvp") || Habilitar.mvp || Habilitar.pro) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.BLUE + ChatColor.BOLD + "MVP");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.BLUE + "" + ChatColor.BOLD + "MVP " + ChatColor.BLUE, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "MVP " + ChatColor.BLUE + p.getName());
				//
				return true;
				} else {
					p.sendMessage(Strings.permissaotag);
				}
				}
			if (args[0].equalsIgnoreCase("pro")) {
				if (p.hasPermission("tag.pro") || Habilitar.pro) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.GOLD + ChatColor.BOLD + "PRO");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.GOLD + "" + ChatColor.BOLD + "PRO " + ChatColor.GOLD, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "PRO " + ChatColor.GOLD + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("semiyt")) {
				if (p.hasPermission("tag.semiyt")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.YELLOW + ChatColor.BOLD + "SEMI-YT");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.YELLOW + "" + ChatColor.BOLD + "SEMIYT " + ChatColor.YELLOW, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "SEMIYT " + ChatColor.YELLOW + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("tag.youtuber")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.AQUA + ChatColor.BOLD + "YOUTUBER");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.AQUA + "" + ChatColor.BOLD + "YT " + ChatColor.AQUA, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "YT " + ChatColor.AQUA + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("builder")) {
				if (p.hasPermission("tag.builder")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.YELLOW + ChatColor.BOLD + "BUILDER");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER " + ChatColor.YELLOW, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER " + ChatColor.YELLOW + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("builder+")) {
				if (p.hasPermission("tag.builder+")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.YELLOW + ChatColor.BOLD + "BUILDER+");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER+ " + ChatColor.YELLOW, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER+ " + ChatColor.YELLOW + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("youtuber+")) {
				if (p.hasPermission("tag.youtuber+")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.DARK_AQUA + ChatColor.BOLD + "YOUTUBER+");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "YT+ " + ChatColor.DARK_AQUA, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "YT+ " + ChatColor.DARK_AQUA + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("helper")) {
				if (p.hasPermission("tag.helper")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.BLUE + ChatColor.BOLD + "HELPER");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.BLUE + "" + ChatColor.BOLD + "HELPER " + ChatColor.BLUE, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "HELPER " + ChatColor.BLUE + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("tag.trial")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "TRIAL");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "TRIAL " + ChatColor.LIGHT_PURPLE, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.LIGHT_PURPLE+ "" + ChatColor.BOLD + "TRIAL " + ChatColor.LIGHT_PURPLE + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("tag.mod")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "MOD");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD " + ChatColor.DARK_PURPLE, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD " + ChatColor.DARK_PURPLE + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("mod+")) {
				if (p.hasPermission("tag.mod+")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "MOD+");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD+ " + ChatColor.DARK_PURPLE, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "MOD+ " + ChatColor.DARK_PURPLE + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("gerente")) {
				if (p.hasPermission("tag.gerente")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.RED + ChatColor.BOLD + "GERENTE");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.RED + "" + ChatColor.BOLD + "GERENTE " + ChatColor.RED, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "GERENTE " + ChatColor.RED + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("tag.admin")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.RED + ChatColor.BOLD + "ADMIN");
				//
				NametagAPI.setNametagHard(p.getName(), ChatColor.RED + "" + ChatColor.BOLD + "ADMIN " + ChatColor.RED, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "ADMIN " + ChatColor.RED + p.getName());
				//
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("dono")) {
				if (p.hasPermission("tag.dono")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.DARK_RED + ChatColor.BOLD + "DONO");
				NametagAPI.setNametagHard(p.getName(), ChatColor.DARK_RED + "" + ChatColor.BOLD + "DONO " + ChatColor.DARK_RED, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "DONO " + ChatColor.DARK_RED + p.getName());
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
			if (args[0].equalsIgnoreCase("gabrielandshooyu")) {
				if (p.hasPermission("tag.developer")) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Sua tag foi alterada para " + ChatColor.DARK_AQUA + ChatColor.BOLD + "DEVELOPER");
				NametagAPI.setNametagHard(p.getName(), ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "DEV " + ChatColor.DARK_AQUA, ChatColor.GRAY + " [" + Manager.prefix(p) + ChatColor.GRAY + "]");
				p.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "DEV " + ChatColor.DARK_AQUA + p.getName());
				return true;
			} else {
				p.sendMessage(Strings.permissaotag);
			}
			}
		}
		return false;
	}

}
