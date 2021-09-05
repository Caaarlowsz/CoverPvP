package me.shooyudev.API;

import net.minecraft.server.v1_7_R4.ChatClickable;
import net.minecraft.server.v1_7_R4.ChatHoverable;
import net.minecraft.server.v1_7_R4.ChatMessage;
import net.minecraft.server.v1_7_R4.ChatModifier;
import net.minecraft.server.v1_7_R4.EnumClickAction;
import net.minecraft.server.v1_7_R4.EnumHoverAction;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.MinecraftServer;
import net.minecraft.server.v1_7_R4.PlayerList;

public class InteractiveChat {

	public static void command(String player, String messageOnChat, String commandOnClick, String onHover) {
		IChatBaseComponent iChatBaseComponent = new ChatMessage(messageOnChat, new Object[0]);
		iChatBaseComponent.setChatModifier(new ChatModifier());
		iChatBaseComponent.getChatModifier()
				.setChatClickable(new ChatClickable(EnumClickAction.RUN_COMMAND, commandOnClick));
		iChatBaseComponent.getChatModifier()
				.a(new ChatHoverable(EnumHoverAction.SHOW_TEXT, new ChatMessage(onHover, new Object[0])));
		PlayerList playerList = MinecraftServer.getServer().getPlayerList();
		playerList.getPlayer(player).sendMessage(iChatBaseComponent);
	}

	public static void link(String player, String messageOnChat, String linkOnClick, String onHover) {
		IChatBaseComponent iChatBaseComponent = new ChatMessage(messageOnChat, new Object[0]);
		iChatBaseComponent.setChatModifier(new ChatModifier());
		iChatBaseComponent.getChatModifier().setChatClickable(new ChatClickable(EnumClickAction.OPEN_URL, linkOnClick));
		iChatBaseComponent.getChatModifier()
				.a(new ChatHoverable(EnumHoverAction.SHOW_TEXT, new ChatMessage(onHover, new Object[0])));
		PlayerList playerList = MinecraftServer.getServer().getPlayerList();
		playerList.getPlayer(player).sendMessage(iChatBaseComponent);
	}

}