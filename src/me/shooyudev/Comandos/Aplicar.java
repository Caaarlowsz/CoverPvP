package me.shooyudev.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;

public class Aplicar extends Manager {

	public static String builder;
	public static String helper;
	public static String trial;
	public static String detector;

	static {
		builder = CoverPvP.getInstance().getConfig().getString("Builder").replace("&", "�");
		helper = CoverPvP.getInstance().getConfig().getString("Helper").replace("&", "�");
		trial = CoverPvP.getInstance().getConfig().getString("Trial").replace("&", "�");
		detector = CoverPvP.getInstance().getConfig().getString("GcDetector").replace("&", "�");
	}

	@Override
	public void Comando(CommandSender sender, Command command, String[] argumentos) {
		Player p = (Player) sender;

		if (command.getName().equalsIgnoreCase("aplicar")) {
			if (argumentos.length == 0) {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + ChatColor.GRAY
						+ "/aplicar <BUILDER , HELPER , TRIAL , GCDETECTOR>");
				return;
			}
			if (argumentos[0].equalsIgnoreCase("builder")) {
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "Formulario: " + builder);
				p.sendMessage(ChatColor.GRAY + "Espere nossa resposta em seu Email ou Skype !");
				p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "INFO: " + ChatColor.GRAY
						+ "Nao fassa + de uma vez o Formulario !");
				p.sendMessage(" ");
				return;
			}
			if (argumentos[0].equalsIgnoreCase("helper")) {
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "Formulario: " + helper);
				p.sendMessage(ChatColor.GRAY + "Espere nossa resposta em seu Email ou Skype !");
				p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "INFO: " + ChatColor.GRAY
						+ "Nao fassa + de uma vez o Formulario !");
				p.sendMessage(" ");
				return;
			}
			if (argumentos[0].equalsIgnoreCase("trial")) {
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "Formulario: " + trial);
				p.sendMessage(ChatColor.GRAY + "Espere nossa resposta em seu Email ou Skype !");
				p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "INFO: " + ChatColor.GRAY
						+ "Nao fassa + de uma vez o Formulario !");
				p.sendMessage(" ");
				return;
			}
			if (argumentos[0].equalsIgnoreCase("gcdetector")) {
				p.sendMessage(" ");
				p.sendMessage(ChatColor.GRAY + "Formulario: " + detector);
				p.sendMessage(ChatColor.GRAY + "Espere nossa resposta em seu Email ou Skype !");
				p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "INFO: " + ChatColor.GRAY
						+ "Nao fassa + de uma vez o Formulario !");
				p.sendMessage(" ");
				return;
			}
		}

	}

}
