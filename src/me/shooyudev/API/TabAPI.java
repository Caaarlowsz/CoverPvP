package me.shooyudev.API;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import me.shooyudev.Main;
import me.shooyudev.Manager.Manager;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class TabAPI implements Listener{
  private static int VERSION = 47;

  @EventHandler
  void TabDoServidor(PlayerJoinEvent evento) { final Player player = evento.getPlayer();
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
      public void run() {
    	  
        PlayerConnection connect = ((CraftPlayer)player).getHandle().playerConnection;
        @SuppressWarnings("deprecation")
		IChatBaseComponent top = ChatSerializer.a("{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '§c§lArkuz§f§lMC§7 \n             \n§eKills: §7" + StatsManager.getKills(player) + " §8| §eDeaths: §7" + StatsManager.getDeaths(player) + " §8| §eKillStreak: §7" + StatsManager.getKillStreak(player) + "\n§eKit: §7" + KitAPI.getKit(player) + " §8| §ePing: §7" + ((CraftPlayer)player).getHandle().ping + " §8| §ePlayers: §7" + Bukkit.getOnlinePlayers().length + "§3/§7" + Bukkit.getMaxPlayers() + "\n'}");

		IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': '', 'underline': 'true'}], 'color': 'gold', 'text': '\n§eNick: §7" + player.getName() + " §8| §eRank: " + Manager.RankAndPrefix(player) + " §8| §e XP: §7" + StatsManager.getXp(player) + " §8| §eCoins: §7" + StatsManager.getCoins(player) + "\n§eAcesse nosso site para mais informações: §7www.loja-arkuzmc.buycraft.net'}");
        if (((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() < TabAPI.VERSION) {
          return;
        }
        connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
      }
    }
    , 1L, 20L);
  }
}