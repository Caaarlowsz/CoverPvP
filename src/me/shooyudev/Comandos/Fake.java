package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ca.wacos.nametagedit.NametagAPI;
import me.shooyudev.Fake.FakeManager;
import me.shooyudev.Fake.FakePlayerUtils;
import me.shooyudev.Manager.Manager;
import me.shooyudev.Utills.Strings;
import net.md_5.bungee.api.ChatColor;

public class Fake implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		if (commandSender instanceof Player) {
			Player player = (Player) commandSender;
			if (command.getName().equalsIgnoreCase("fake")) {
				if (player.hasPermission("cover.fake")) {
					if (args.length == 0) {
						player.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /fake <nick>");
						return false;
					}

					if (args.length == 1) {
						if (args[0].toLowerCase().equals("#")) {
							if (FakeManager.fake.containsKey(player)) {
								try {
									FakeManager.fakes.remove(FakeManager.fake.get(player));
									FakeManager.fake.remove(player);
									FakePlayerUtils.changePlayerName(player, FakeManager.realName.get(player));
									FakeManager.realName.remove(player);
									NametagAPI.setPrefix(player.getName(), "§7");
									NametagAPI.setSuffix(player.getName(), " §7" + ChatColor.GRAY + "["
											+ Manager.prefix(player) + ChatColor.GRAY + "]");
									player.setDisplayName("§7" + player.getName());
									player.sendMessage(ChatColor.GREEN + "Seu nickname foi resetado!");
									return true;
								} catch (Exception exception) {
									player.sendMessage(
											Strings.servidormensagem + ChatColor.GRAY + "Seu fake foi resetado!");
									return true;
								}
							} else {
								player.sendMessage(ChatColor.RED + "Você não está utilizando nenhum fake!");
							}
						} else {
							if (FakeManager.fake.containsKey(player)) {
								player.sendMessage(Strings.servidormensagem + ChatColor.GRAY
										+ "Você já está utilizando um fake! Remova-o com /fake #!");
								return true;
							}
							String nickname = args[0];
							if (!FakePlayerUtils.validateName(nickname)) {
								player.sendMessage(Strings.servidormensagem + ChatColor.GRAY
										+ "O nickname escolhido possui caractéres inválidos!");
								return true;
							}
							if (FakeManager.fakes.contains(nickname)) {
								player.sendMessage(
										Strings.servidormensagem + ChatColor.GRAY + "Este fake já está em uso!");
								return true;
							}
							try {
								FakeManager.fakes.add(nickname);
								FakeManager.fake.put(player, nickname);
								FakeManager.realName.put(player, player.getName());
								FakePlayerUtils.changePlayerName(player, nickname);
								FakePlayerUtils.changePlayerSkin(player, nickname,
										Bukkit.getOfflinePlayer(nickname).getUniqueId());
								player.sendMessage(
										ChatColor.GREEN + "Seu nickname foi alterado para " + nickname + "!");
							} catch (Exception exception) {
								player.sendMessage(
										Strings.servidormensagem + ChatColor.GRAY + "Seu nickname foi alterado para "
												+ ChatColor.YELLOW + ChatColor.BOLD + nickname + "!");
								return true;
							}
						}
					}
				} else {
					player.sendMessage(Strings.permissaocomando);
				}
			}

		}
		return false;
	}
}
