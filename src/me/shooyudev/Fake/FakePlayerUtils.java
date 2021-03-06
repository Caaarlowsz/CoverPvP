package me.shooyudev.Fake;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import ca.wacos.nametagedit.NametagAPI;
import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.Manager.Manager;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.MathHelper;
import net.minecraft.server.v1_7_R4.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_7_R4.PacketPlayOutEntityHeadRotation;
import net.minecraft.server.v1_7_R4.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_7_R4.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_7_R4.PacketPlayOutPlayerInfo;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.properties.Property;

public class FakePlayerUtils {

	public static void changePlayerName(Player player, String name) {
		changePlayerName(player, name, true);
	}

	public static void changePlayerName(Player player, String name, boolean respawn) {
		Player[] players = CoverPvP.getPlugin(CoverPvP.class).getServer().getOnlinePlayers();
		EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
		GameProfile playerProfile = entityPlayer.getProfile();
		if (respawn) {
			removeFromTab(player, players);
		}
		try {
			Field field = playerProfile.getClass().getDeclaredField("name");
			field.setAccessible(true);
			field.set(playerProfile, name);
			field.setAccessible(false);
			entityPlayer.getClass().getDeclaredField("displayName").set(entityPlayer, name);
			entityPlayer.getClass().getDeclaredField("listName").set(entityPlayer, name);
		} catch (Exception e) {

		}
		if (respawn) {
			respawnPlayer(player, players);
		}
		NametagAPI.setPrefix(player.getName(), "�7");
		NametagAPI.setSuffix(player.getName(),
				" �7" + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
		player.setDisplayName("�7" + player.getName());
	}

	public static void removePlayerSkin(Player player) {
		removePlayerSkin(player, true);
	}

	public static void removePlayerSkin(Player player, boolean respawn) {
		EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
		GameProfile playerProfile = entityPlayer.getProfile();
		playerProfile.getProperties().clear();
		if (respawn) {
			respawnPlayer(player, CoverPvP.getPlugin(CoverPvP.class).getServer().getOnlinePlayers());
		}
	}

	public static void changePlayerSkin(Player player, String name, UUID uuid) {
		changePlayerSkin(player, name, uuid, true);
	}

	public static void changePlayerSkin(Player player, String name, UUID uuid, boolean respawn) {
		EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
		GameProfile playerProfile = entityPlayer.getProfile();
		playerProfile.getProperties().clear();
		try {
			playerProfile.getProperties().put("textures",
					(Property) CustomPlayerAPI.Textures.get(new GameProfile(uuid, name)));
		} catch (ExecutionException e) {

		}
		if (respawn) {
			respawnPlayer(player, CoverPvP.getPlugin(CoverPvP.class).getServer().getOnlinePlayers());
		}
	}

	public void addToTab(Player player, Collection<? extends Player> players) {
		PacketPlayOutPlayerInfo addPlayerInfo = PacketPlayOutPlayerInfo.addPlayer(((CraftPlayer) player).getHandle());
		PacketPlayOutPlayerInfo updatePlayerInfo = PacketPlayOutPlayerInfo
				.updateDisplayName(((CraftPlayer) player).getHandle());
		for (Player online : players) {
			if (online.canSee(player)) {
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(addPlayerInfo);
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(updatePlayerInfo);
				NametagAPI.setPrefix(player.getName(), "�7");
				NametagAPI.setSuffix(player.getName(),
						" �7" + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
				player.setDisplayName("�7" + player.getName());
			}
		}
	}

	public static void removeFromTab(Player player, Player[] players) {
		PacketPlayOutPlayerInfo removePlayerInfo = PacketPlayOutPlayerInfo
				.removePlayer(((CraftPlayer) player).getHandle());
		for (Player online : players) {
			if (online.canSee(player)) {
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(removePlayerInfo);
			}
		}
	}

	public static void respawnPlayer(Player player, Player[] players) {
		EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
		PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[] { entityPlayer.getId() });
		PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(entityPlayer);
		PacketPlayOutPlayerInfo addPlayerInfo = PacketPlayOutPlayerInfo.addPlayer(((CraftPlayer) player).getHandle());
		PacketPlayOutEntityMetadata metadata = new PacketPlayOutEntityMetadata(entityPlayer.getId(),
				entityPlayer.getDataWatcher(), true);
		PacketPlayOutEntityHeadRotation headRotation = new PacketPlayOutEntityHeadRotation(entityPlayer,
				(byte) MathHelper.d(entityPlayer.getHeadRotation() * 256.0F / 360.0F));
		PacketPlayOutPlayerInfo removePlayerInfo = PacketPlayOutPlayerInfo
				.removePlayer(((CraftPlayer) player).getHandle());
		for (Player online : players) {
			if (online.canSee(player)) {
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(removePlayerInfo);
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(addPlayerInfo);
				if (online.getUniqueId() != player.getUniqueId()) {
					((CraftPlayer) online).getHandle().playerConnection.sendPacket(destroy);
					((CraftPlayer) online).getHandle().playerConnection.sendPacket(spawn);
					((CraftPlayer) online).getHandle().playerConnection.sendPacket(metadata);
					((CraftPlayer) online).getHandle().playerConnection.sendPacket(headRotation);
					NametagAPI.setPrefix(player.getName(), "�7");
					NametagAPI.setSuffix(player.getName(),
							" �7" + ChatColor.GRAY + "[" + Manager.prefix(player) + ChatColor.GRAY + "]");
					player.setDisplayName("�7" + player.getName());
				}
			}
		}
	}

	public static boolean validateName(String username) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,16}");
		Matcher matcher = pattern.matcher(username);
		return matcher.matches();

	}
}