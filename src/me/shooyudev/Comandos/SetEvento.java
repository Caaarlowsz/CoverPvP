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
import me.shooyudev.Configs.EventoConfig;
import me.shooyudev.Utills.Strings;

public class SetEvento implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if ((p.hasPermission("cover.evento")) && (label.equalsIgnoreCase("setevento"))) {
			EventoConfig.getConfig();
			p.sendMessage(Strings.servidormensagem + ChatColor.GREEN + "Evento setado com sucesso !");
			API.setWarp(p, "Evento");
			EventoConfig.getConfig().config().set("evento.x", Double.valueOf(p.getLocation().getX()));
			EventoConfig.getConfig().config().set("evento.y", Double.valueOf(p.getLocation().getY()));
			EventoConfig.getConfig().config().set("evento.z", Double.valueOf(p.getLocation().getZ()));
			p.getWorld();
			EventoConfig.getConfig().config().set("evento.pitch", Float.valueOf(p.getLocation().getPitch()));
			EventoConfig.getConfig().config().set("evento.yam", Float.valueOf(p.getLocation().getYaw()));
			EventoConfig.getConfig().config().set("evento.world", p.getLocation().getWorld().getName());
			EventoConfig.getConfig().saveConfigs();
		}
		return false;
	}

	public static void Evento(Player p) {
		Random dice = new Random();

		int number = dice.nextInt(4);
		switch (number) {
		case 0:
			World w = Bukkit.getServer().getWorld(EventoConfig.getConfig().config().getString("evento.world"));
			double x = EventoConfig.getConfig().config().getDouble("evento.x");
			double y = EventoConfig.getConfig().config().getDouble("evento.y");
			double z = EventoConfig.getConfig().config().getDouble("evento.z");
			Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) EventoConfig.getConfig().config().getDouble("evento.pitch"));
			lobby.setYaw((float) EventoConfig.getConfig().config().getDouble("evento.yaw"));

			p.teleport(lobby);
		}
	}
}
