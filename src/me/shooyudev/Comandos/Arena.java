package me.shooyudev.Comandos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.shooyudev.API.API;
import me.shooyudev.Configs.ArenaConfig;
import me.shooyudev.Utills.Strings;

public class Arena implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((p.hasPermission("cover.setarena")) && (label.equalsIgnoreCase("setarena"))) {
			if (args.length == 0) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /setarena <1 até 5>");
				return true;
			}
			if (args[0].equalsIgnoreCase("1")) {
				ArenaConfig.getConfig();
				API.setWarp(p, "Arena");
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Arena " + ChatColor.YELLOW + "1" + ChatColor.GRAY + " Setada com Sucesso!");
				ArenaConfig.getConfig().config().set("arena1.x", Double.valueOf(p.getLocation().getX()));
				ArenaConfig.getConfig().config().set("arena1.y", Double.valueOf(p.getLocation().getY()));
				ArenaConfig.getConfig().config().set("arena1.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				ArenaConfig.getConfig().config().set("arena1.pitch", Float.valueOf(p.getLocation().getPitch()));
				ArenaConfig.getConfig().config().set("arena1.yaw", Float.valueOf(p.getLocation().getYaw()));
				ArenaConfig.getConfig().config().set("arena1.world", p.getLocation().getWorld().getName());
				ArenaConfig.getConfig().saveConfigs();
			}
			if (args[0].equalsIgnoreCase("2")) {
				ArenaConfig.getConfig();
				API.setWarp(p, "Arena");
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Arena " + ChatColor.YELLOW + "2" + ChatColor.GRAY + " Setada com Sucesso!");
				ArenaConfig.getConfig().config().set("arena2.x", Double.valueOf(p.getLocation().getX()));
				ArenaConfig.getConfig().config().set("arena2.y", Double.valueOf(p.getLocation().getY()));
				ArenaConfig.getConfig().config().set("arena2.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				ArenaConfig.getConfig().config().set("arena2.pitch", Float.valueOf(p.getLocation().getPitch()));
				ArenaConfig.getConfig().config().set("arena2.yaw", Float.valueOf(p.getLocation().getYaw()));
				ArenaConfig.getConfig().config().set("arena2.world", p.getLocation().getWorld().getName());
				ArenaConfig.getConfig().saveConfigs();
			}
			if (args[0].equalsIgnoreCase("3")) {
				ArenaConfig.getConfig();
				API.setWarp(p, "Arena");
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Arena " + ChatColor.YELLOW + "3" + ChatColor.GRAY + " Setada com Sucesso!");
				ArenaConfig.getConfig().config().set("arena3.x", Double.valueOf(p.getLocation().getX()));
				ArenaConfig.getConfig().config().set("arena3.y", Double.valueOf(p.getLocation().getY()));
				ArenaConfig.getConfig().config().set("arena3.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				ArenaConfig.getConfig().config().set("arena3.pitch", Float.valueOf(p.getLocation().getPitch()));
				ArenaConfig.getConfig().config().set("arena3.yaw", Float.valueOf(p.getLocation().getYaw()));
				ArenaConfig.getConfig().config().set("arena3.world", p.getLocation().getWorld().getName());
				ArenaConfig.getConfig().saveConfigs();
			}
			if (args[0].equalsIgnoreCase("4")) {
				ArenaConfig.getConfig();
				API.setWarp(p, "Arena");
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Arena " + ChatColor.YELLOW + "4" + ChatColor.GRAY + " Setada com Sucesso!");
				ArenaConfig.getConfig().config().set("arena4.x", Double.valueOf(p.getLocation().getX()));
				ArenaConfig.getConfig().config().set("arena4.y", Double.valueOf(p.getLocation().getY()));
				ArenaConfig.getConfig().config().set("arena4.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				ArenaConfig.getConfig().config().set("arena4.pitch", Float.valueOf(p.getLocation().getPitch()));
				ArenaConfig.getConfig().config().set("arena4.yaw", Float.valueOf(p.getLocation().getYaw()));
				ArenaConfig.getConfig().config().set("arena4.world", p.getLocation().getWorld().getName());
				ArenaConfig.getConfig().saveConfigs();
			}
			if (args[0].equalsIgnoreCase("5")) {
				ArenaConfig.getConfig();
				API.setWarp(p, "Arena");
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Arena " + ChatColor.YELLOW + "5" + ChatColor.GRAY + " Setada com Sucesso!");
				ArenaConfig.getConfig().config().set("arena5.x", Double.valueOf(p.getLocation().getX()));
				ArenaConfig.getConfig().config().set("arena5.y", Double.valueOf(p.getLocation().getY()));
				ArenaConfig.getConfig().config().set("arena5.z", Double.valueOf(p.getLocation().getZ()));
				p.getWorld();
				ArenaConfig.getConfig().config().set("arena5.pitch", Float.valueOf(p.getLocation().getPitch()));
				ArenaConfig.getConfig().config().set("arena5.yaw", Float.valueOf(p.getLocation().getYaw()));
				ArenaConfig.getConfig().config().set("arena5.world", p.getLocation().getWorld().getName());
				ArenaConfig.getConfig().saveConfigs();
			}
		} else {
			p.sendMessage(Strings.permissaocomando);
		}
		return false;
	}

	public static void ArenaRandom(Player p) {
		Random dice = new Random();

		int number = dice.nextInt(4);
		switch (number) {
		case 0:
			World w = Bukkit.getServer().getWorld(ArenaConfig.getConfig().config().getString("arena1.world"));
			double x = ArenaConfig.getConfig().config().getDouble("arena1.x");
			double y = ArenaConfig.getConfig().config().getDouble("arena1.y");
			double z = ArenaConfig.getConfig().config().getDouble("arena1.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) ArenaConfig.getConfig().config().getDouble("arena1.pitch"));
			lobby.setYaw((float) ArenaConfig.getConfig().config().getDouble("arena1.yaw"));

			p.teleport(lobby);

			break;
		case 1:
			World w2 = Bukkit.getServer().getWorld(ArenaConfig.getConfig().config().getString("arena2.world"));
			double x2 = ArenaConfig.getConfig().config().getDouble("arena2.x");
			double y2 = ArenaConfig.getConfig().config().getDouble("arena2.y");
			double z2 = ArenaConfig.getConfig().config().getDouble("arena2.z");
			Location lobby2 = new Location(w2, x2, y2, z2);
			lobby2.setPitch((float) ArenaConfig.getConfig().config().getDouble("arena2.pitch"));
			lobby2.setYaw((float) ArenaConfig.getConfig().config().getDouble("arena2.yaw"));

			p.teleport(lobby2);

			break;
		case 2:
			World w3 = Bukkit.getServer().getWorld(ArenaConfig.getConfig().config().getString("arena3.world"));
			double x3 = ArenaConfig.getConfig().config().getDouble("arena3.x");
			double y3 = ArenaConfig.getConfig().config().getDouble("arena3.y");
			double z3 = ArenaConfig.getConfig().config().getDouble("arena3.z");
			Location lobby3 = new Location(w3, x3, y3, z3);
			lobby3.setPitch((float) ArenaConfig.getConfig().config().getDouble("arena3.pitch"));
			lobby3.setYaw((float) ArenaConfig.getConfig().config().getDouble("arena3.yaw"));

			p.teleport(lobby3);

			break;
		case 3:
			World w4 = Bukkit.getServer().getWorld(ArenaConfig.getConfig().config().getString("arena4.world"));
			double x4 = ArenaConfig.getConfig().config().getDouble("arena4.x");
			double y4 = ArenaConfig.getConfig().config().getDouble("arena4.y");
			double z4 = ArenaConfig.getConfig().config().getDouble("arena4.z");
			Location lobby4 = new Location(w4, x4, y4, z4);
			lobby4.setPitch((float) ArenaConfig.getConfig().config().getDouble("arena4.pitch"));
			lobby4.setYaw((float) ArenaConfig.getConfig().config().getDouble("arena4.yaw"));

			p.teleport(lobby4);

			break;
		case 4:
			World w5 = Bukkit.getServer().getWorld(ArenaConfig.getConfig().config().getString("arena5.world"));
			double x5 = ArenaConfig.getConfig().config().getDouble("arena5.x");
			double y5 = ArenaConfig.getConfig().config().getDouble("arena5.y");
			double z5 = ArenaConfig.getConfig().config().getDouble("arena5.z");
			Location lobby5 = new Location(w5, x5, y5, z5);
			lobby5.setPitch((float) ArenaConfig.getConfig().config().getDouble("arena5.pitch"));
			lobby5.setYaw((float) ArenaConfig.getConfig().config().getDouble("arena5.yaw"));
			p.teleport(lobby5);
		}
	}
}
