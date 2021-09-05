package me.shooyudev.AuthMe;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.shooyudev.Main;
import me.shooyudev.API.API;
import me.shooyudev.Comandos.Evento;
import me.shooyudev.Configs.AuthConfig;
import me.shooyudev.Utills.Strings;
import me.shooyudev.scoreboarding.Updater;


@SuppressWarnings("unused")
public class Register implements CommandExecutor{
	
	
  public boolean onCommand(CommandSender sender, Command command, String arg2, String[] arg3){
    Player p = (Player)sender;
    if (command.getName().equalsIgnoreCase("register")){
      if (AuthConfig.getConfig().config().contains("Login." + p.getName().toLowerCase() + ".senha")){
        p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Essa conta ja esta registrada em nosso banco de dados.");
        p.playSound(p.getLocation(), Sound.EXPLODE, 5.0F, 5.0F);
        return true;
      }
      if (arg3.length == 0){
        p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Para se autenticar digite " + ChatColor.YELLOW + "/register <senha>");
        return true;
      }
      if (arg3[0].length() <= 3){
        p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "A Senha deve ter conter no minimo , 3 caracteristicas !");
        return true;
      }
      if (arg3.length == 1){
        String senha = arg3[0];
        AuthConfig.getConfig().config().set("Login." + p.getName().toLowerCase() + ".senha", senha);
        p.sendMessage(Strings.servidormensagem + ChatColor.GRAY + "Voce se registrou com sucesso , Sua senha foi encaminhada para o nosso banco de dados !");
        Main.login.remove(p.getName());
        AuthConfig.getConfig().saveConfigs();
		for(int i = 1; i < 100; i++) {
			p.sendMessage(" ");
		}
		p.sendMessage(ChatColor.GREEN + "Bem-vindo ao servidor " + ChatColor.YELLOW + p.getName());
		p.sendMessage(ChatColor.GREEN + "O servidor se encontra em fase Beta ,");
		p.sendMessage(ChatColor.GREEN + "Se Ocorrer um Bug , Caso vc ache bugs Reporte ,");
		p.sendMessage(ChatColor.GREEN + "Aproveite o servidor !" + ChatColor.YELLOW + p.getName());
		p.sendMessage("");
		API.itensSpawn(p);
        return true;
      }
    }
    return false;
  }
}
