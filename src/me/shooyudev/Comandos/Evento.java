package me.shooyudev.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.shooyudev.Main;
import me.shooyudev.Events.Proteção;
import me.shooyudev.Utills.Strings;

public class Evento implements CommandExecutor{

	public boolean comecou = false;
	public static ArrayList<String> participantes = new ArrayList<>();
	public boolean evento = false;
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		 if (p.hasPermission("cover.evento")){
		if (cmd.getName().equalsIgnoreCase("evento")){
				if (evento == false){
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "O Evento esta fechado ou não esta ocorrendo.");
					return true;
				}
				if (participantes.contains(p.getName())){
					p.sendMessage("§7Você ja esta no evento.");
					return true;
				}
				if (evento == true){
					Proteção.setImortalidade(p, true);
					p.sendMessage("§7Você entrou no evento.");
					Evento.participantes.add(p.getName());
					return true;
				}
			   }
		  }
			if (args[0].equalsIgnoreCase("iniciar")){
				evento = true;
				Bukkit.broadcastMessage("     " + Strings.servidor);
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Evento aberto.");
				Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Quer participar? Dê /evento");
				Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Prêmio: " + ChatColor.GREEN + "Receberá no final do evento.");
				Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Iniciando em: "+ ChatColor.GREEN + "3 minutos.");
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					@Override
					public void run() {
						Bukkit.broadcastMessage("     " + Strings.servidor);
						Bukkit.broadcastMessage(" ");
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Evento aberto.");
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Quer participar? Dê /evento");
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Participantes: "+ ChatColor.GREEN + participantes.size());
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Prêmio: " + ChatColor.GREEN + "Receberá no final do evento.");
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Iniciando em: "+ ChatColor.GREEN + "2 minutos.");
						
					}
				}, 60*20L);
				
Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					
					@Override
					public void run() {
						Bukkit.broadcastMessage("     " + Strings.servidor);
						Bukkit.broadcastMessage(" ");
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Evento aberto.");
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Quer participar? Dê /evento");
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Participantes: "+ ChatColor.GREEN + participantes.size());
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Prêmio: " + ChatColor.GREEN + "Receberá no final do evento.");
						Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Iniciando em: "+ ChatColor.GREEN + "1 minutos.");
						
					}
				}, 120*20L);

Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	
	@Override
	public void run() {
		Bukkit.broadcastMessage("     " + Strings.servidor);
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Evento aberto.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Quer participar? Dê /evento");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Participantes: "+ ChatColor.GREEN + participantes.size());
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Prêmio: " + ChatColor.GREEN + "Receberá no final do evento.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Iniciando em: "+ ChatColor.GREEN + "30 segundos.");
		
	}
}, 150*20L);

Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	
	@Override
	public void run() {
		Bukkit.broadcastMessage("     " + Strings.servidor);
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Evento aberto.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Quer participar? Dê /evento");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Participantes: "+ ChatColor.GREEN + participantes.size());
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Prêmio: " + ChatColor.GREEN + "Receberá no final do evento.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Iniciando em: "+ ChatColor.GREEN + "20 segundos.");
		
	}
}, 160*20L);

Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	
	@Override
	public void run() {
		Bukkit.broadcastMessage("     " + Strings.servidor);
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Evento aberto.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Quer participar? Dê /evento");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Participantes: "+ ChatColor.GREEN + participantes.size());
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Prêmio: " + ChatColor.GREEN + "Receberá no final do evento.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Iniciando em: "+ ChatColor.GREEN + "10 segundos.");
		
	}
}, 170*20L);

Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	
	@Override
	public void run() {
		Bukkit.broadcastMessage("     " + Strings.servidor);
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Evento aberto.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Quer participar? Dê /evento");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Participantes: "+ ChatColor.GREEN + participantes.size());
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Prêmio: " + ChatColor.GREEN + "Receberá no final do evento.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Iniciando em: "+ ChatColor.GREEN + "5 segundos.");
		
	}
}, 175*20L);

Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	
	@Override
	public void run() {
		if (participantes.size() >= 2){
		Bukkit.broadcastMessage("     " + Strings.servidor);
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Evento Iniciado.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Boa sorte aos participantes.");
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Participantes: "+ ChatColor.GREEN + participantes.size());
		Bukkit.broadcastMessage(" " + ChatColor.YELLOW + "Prêmio: " + ChatColor.GREEN + "Receberá no final do evento.");
		Proteção.setImortalidade(p, false);
		evento = false;
		comecou = true;
	} else {
		Bukkit.broadcastMessage("§cEvento fechado.");
		Bukkit.broadcastMessage("§cMotivo: §eFalta de jogadores.");
		evento = false;
		comecou = false;
	}
  }
}, 180*20L);
		}
		return false;
	}
	
	

}
