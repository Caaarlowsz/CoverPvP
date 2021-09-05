package me.shooyudev.Events;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFloodEvents implements Listener {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<Player, Long> chat = new HashMap();

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	public void aAntiSpam(AsyncPlayerChatEvent e) {

		Player p = e.getPlayer();
		if (!chat.containsKey(p)) {
			int zeitconfig = 2000;
			long time = System.currentTimeMillis() + zeitconfig;
			if (p.hasPermission("cover.floodchat")) {
				return;
			}
			chat.put(p, Long.valueOf(time));
		} else if (((Long) chat.get(p)).longValue() <= System.currentTimeMillis()) {

			if (p.hasPermission("cover.floodchat")) {
				return;
			}
			int zeitconfig = 2000;
			long time = System.currentTimeMillis() + zeitconfig;
			chat.put(p, Long.valueOf(time));
		} else {

			if ((((Long) chat.get(p)).longValue() < System.currentTimeMillis())
					|| (p.hasPermission("cover.floodchat"))) {
				return;
			}
			p.sendMessage(ChatColor.RED + "Aguarde um pouco para escrever !");
			e.setCancelled(true);
		}
	}
}