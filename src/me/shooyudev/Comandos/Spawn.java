package me.shooyudev.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.covermc.kitpvp.CoverPvP;
import me.shooyudev.API.API;
import me.shooyudev.API.KitAPI;
import me.shooyudev.API.WarpsAPI;
��o;
import me.shooyudev.Utills.Strings;
import me.shooyudev.scoreboarding.Updater;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {

		Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("spawn")) {

			p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� est� sendo " + ChatColor.YELLOW
					+ ChatColor.BOLD + "TELEPORTADO" + ChatColor.GRAY + " para o Spawn!");
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999, 9999));
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9999, 9999));
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999, 99999));

			Bukkit.getScheduler().scheduleSyncDelayedTask(CoverPvP.getPlugin(), new Runnable() {
				public void run() {
					for (Player players : Bukkit.getOnlinePlayers()) {
						Updater.UpdateScore(players);
					}
					API.tirarEfeitos(p);
					API.tirarArmadura(p);

					p.getInventory().clear();
					Prote��o.setImortalidade(p, true);
					WarpsAPI.Ir(p, "Spawn");
					API.setWarp(p, "Spawn");
					WarpsAPI.removerFPS();
					p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voc� foi " + ChatColor.YELLOW
							+ ChatColor.BOLD + "TELEPORTADO" + ChatColor.GRAY + " com sucesso!");
					API.itensSpawn(p);
					KitAPI.TirarKit(p);
					Updater.UpdateScore(p);

					p.removePotionEffect(PotionEffectType.SLOW);
					p.removePotionEffect(PotionEffectType.BLINDNESS);
					p.removePotionEffect(PotionEffectType.CONFUSION);

					p.setHealth(20.0D);
					p.setMaxHealth(20.0D);

				}
			}, 3 * 20);
		}
		return false;
	}

}
