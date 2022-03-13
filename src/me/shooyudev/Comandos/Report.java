package me.shooyudev.Comandos;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.API.KitAPI;
import me.shooyudev.Utills.Strings;

public class Report implements CommandExecutor {

	public ArrayList<String> reported;
	private CoverPvP plugin;

	public Report(final CoverPvP plugin) {
		this.reported = new ArrayList<String>();
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("�cVoce nao pode usar isso no console");
			return false;
		}
		if (commandLabel.equalsIgnoreCase("report")) {
			if (args.length >= 2) {
				final Player target = p.getServer().getPlayer(args[0]);
				if (target != null) {
					if (this.reported.contains(p.getName())) {
						p.sendMessage("�7Voce ja efetuou um report, por favor aguarde!");
						return true;
					}
					final String reportMsg = StringUtils.join((Object[]) Arrays.copyOfRange(args, 1, args.length), " ");
					this.reported.add(p.getName());
					p.sendMessage("�aSeu report sobre �6" + target.getName() + " foi enviado com sucesso. Pelo motivo"
							+ reportMsg + " ");
					Player[] arrayOfPlayer;
					for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
						final Player s = arrayOfPlayer[i];
						if (s.hasPermission("cover.report")) {
							s.playSound(s.getLocation(), Sound.LEVEL_UP, 15.0f, 1.0f);
							s.sendMessage("�c");
							s.sendMessage("�c�m--->-----------------------------<---");
							s.sendMessage("�c");
							s.sendMessage("�c             �e�lNOVO REPORT!�e              ");
							s.sendMessage("�c");
							s.sendMessage("   �eAcusado: �c" + target.getName());
							s.sendMessage("    �eReport de: �a" + p.getName());
							s.sendMessage("     �eMotivo: �e" + reportMsg);
							s.sendMessage("      �eKit: �a" + KitAPI.getKit(target));
							s.sendMessage("�c");
							s.sendMessage("�c�m--->-----------------------------<---");
							s.sendMessage("�c");
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
									(Runnable) new Runnable() {
										@Override
										public void run() {
											Report.this.reported.remove(p.getName());
										}
									}, 300L);
						}
					}
				} else {
					p.sendMessage("�cEste jogador nao esta conectado!");
				}
			} else {
				p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Use /report <nick> <motivo>");
			}
		}
		return false;
	}
}
