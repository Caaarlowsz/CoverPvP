package me.shooyudev.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.API.KitAPI;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Kit extends Manager {
	
	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player)sender;
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /kit (kit)");
			return;
		}
		if (argumentos.length == 0) {
			p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /kit (kit)");
			return;
		} else {
			if (argumentos[0].equalsIgnoreCase("pvp")) {
				if (p.hasPermission("kit.pvp") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.PvP(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lPvP");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("kangaroo")) {
				if (p.hasPermission("kit.kangaroo") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Kangaroo(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lKangaroo");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("specialist")) {
				if (p.hasPermission("kit.specialist") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Specialist(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lSpecialist");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("stomper")) {
				if (p.hasPermission("kit.stomper") || Habilitar.fullkit) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Stomper(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lStomper");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("gladiator")) {
				if (p.hasPermission("kit.gladiator") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Gladiator(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lGladiator");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("snail")) {
				if (p.hasPermission("kit.snail") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Snail(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lSnail");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("viper")) {
				if (p.hasPermission("kit.viper") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Viper(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lViper");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("ninja")) {
				if (p.hasPermission("kit.ninja") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Ninja(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lNinja");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("fisherman")) {
				if (p.hasPermission("kit.fisherman") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Fisherman(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lFisherman");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("switcher")) {
				if (p.hasPermission("kit.switcher") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Switcher(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lSwitcher");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("thor")) {
				if (p.hasPermission("kit.thor") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Thor(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lThor");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("anchor")) {
				if (p.hasPermission("kit.anchor") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Anchor(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lAnchor");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("magma")) {
				if (p.hasPermission("kit.magma") || Habilitar.fullkit) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Magma(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lMagma");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("critical")) {
				if (p.hasPermission("kit.critical") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Critical(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lCritical");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("ajnin")) {
				if (p.hasPermission("kit.ajnin") || Habilitar.fullkit || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Ajnin(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lAjnin");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("boxer")) {
				if (p.hasPermission("kit.boxer") || Habilitar.fullkit || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Boxer(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lBoxer");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("madman")) {
				if (p.hasPermission("kit.madman") || Habilitar.fullkit || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Madman(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lMadman");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("monk")) {
				if (p.hasPermission("kit.monk") || Habilitar.fullkit || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Monk(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lMonk");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("strong")) {
				if (p.hasPermission("kit.strong") || Habilitar.fullkit || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Strong(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lStrong");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("viking")) {
				if (p.hasPermission("kit.viking") || Habilitar.fullkit || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Viking(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lViking");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("grappler")) {
				if (p.hasPermission("kit.grappler") || Habilitar.fullkit) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Grappler(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lGrappler");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("hulk") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
				if (p.hasPermission("kit.hulk")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Hulk(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lHulk");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("phantom")) {
				if (p.hasPermission("kit.phantom") || Habilitar.fullkit) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Phantom(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lPhantom");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
			if (argumentos[0].equalsIgnoreCase("sumo") || Habilitar.fullkit) {
				if (p.hasPermission("kit.sumo") || Habilitar.fullkit || Habilitar.vip || Habilitar.mvp || Habilitar.pro) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Sumo(p);
						p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce selecionou o kit §e§lSumo");
						return;
					} else {
						p.sendMessage(Strings.pegoukit);
						return;
					}
				} else {
					p.sendMessage(Strings.permissaokit);
					return;
				}
			}
		   p.sendMessage(Strings.servidor + ChatColor.GRAY + "O Kit §e§l" + argumentos[0] + ChatColor.GRAY + " Nao existe!");
		}
		
	}

}
