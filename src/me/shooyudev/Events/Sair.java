package me.shooyudev.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Sair implements Listener {
	
	@EventHandler
	public static void SairDoServidor(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		
	}

}
