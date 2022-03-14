package com.github.caaarlowsz.covermc.kitpvp;

import java.util.ArrayList;

import com.github.caaarlowsz.kitpvpapi.KitPvP;
import com.github.caaarlowsz.kitpvpapi.KitPvPAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.shooyudev.API.API;
import me.shooyudev.API.StatsManager;
import me.shooyudev.API.TabAPI;
import me.shooyudev.API.WarpsAPI;
import me.shooyudev.AuthMe.Logar;
import me.shooyudev.AuthMe.Login;
import me.shooyudev.AuthMe.Register;
import me.shooyudev.Bans.Ban;
import me.shooyudev.Bans.IPBan;
import me.shooyudev.Bans.Kick;
import me.shooyudev.Bans.Mute;
import me.shooyudev.Bans.Unban;
import me.shooyudev.Bans.Events.Config;
import me.shooyudev.Bans.Events.Eventos;
import me.shooyudev.Comandos.Account;
import me.shooyudev.Comandos.Admin;
import me.shooyudev.Comandos.Aplicar;
import me.shooyudev.Comandos.Arena;
import me.shooyudev.Comandos.Bc;
import me.shooyudev.Comandos.Build;
import me.shooyudev.Comandos.Chat;
import me.shooyudev.Comandos.ClickTest;
import me.shooyudev.Comandos.Conectado;
import me.shooyudev.Comandos.Dano;
import me.shooyudev.Comandos.Desabilitar;
import me.shooyudev.Comandos.Evento;
import me.shooyudev.Comandos.Fake;
import me.shooyudev.Comandos.Gamemode;
import me.shooyudev.Comandos.GroupBuilder;
import me.shooyudev.Comandos.GroupSet;
import me.shooyudev.Comandos.GroupVip;
import me.shooyudev.Comandos.GroupYoutuber;
import me.shooyudev.Comandos.Habilitar;
import me.shooyudev.Comandos.Kit;
import me.shooyudev.Comandos.Manutençao;
import me.shooyudev.Comandos.Ping;
import me.shooyudev.Comandos.PvP;
import me.shooyudev.Comandos.Rank;
import me.shooyudev.Comandos.Report;
import me.shooyudev.Comandos.SKit;
import me.shooyudev.Comandos.Sc;
import me.shooyudev.Comandos.SetEvento;
import me.shooyudev.Comandos.SetRank;
import me.shooyudev.Comandos.SetWarp;
import me.shooyudev.Comandos.Spawn;
import me.shooyudev.Comandos.Tag;
import me.shooyudev.Comandos.Tell;
import me.shooyudev.Comandos.Tp;
import me.shooyudev.Comandos.Warp;
import me.shooyudev.Comandos.Youtuber;
import me.shooyudev.Configs.ArenaConfig;
import me.shooyudev.Configs.AuthConfig;
import me.shooyudev.Configs.EventoConfig;
import me.shooyudev.Configs.WarpsConfig;
import me.shooyudev.Events.ChatFloodEvents;
import me.shooyudev.Events.DanoEvents;
import me.shooyudev.Events.DeathEvents;
import me.shooyudev.Events.DropEvents;
import me.shooyudev.Events.Entrar;
import me.shooyudev.Events.EventoAuthEvents;
import me.shooyudev.Events.Principais;
import me.shooyudev.Events.Proteção;
import me.shooyudev.Events.Respawn;
import me.shooyudev.Events.Sair;
import me.shooyudev.Habilites.Ajnin;
import me.shooyudev.Habilites.Anchor;
import me.shooyudev.Habilites.Boxer;
import me.shooyudev.Habilites.Critical;
import me.shooyudev.Habilites.Fisherman;
import me.shooyudev.Habilites.Gladiator;
import me.shooyudev.Habilites.Grappler;
import me.shooyudev.Habilites.Hulk;
import me.shooyudev.Habilites.Kangaroo;
import me.shooyudev.Habilites.Madman;
import me.shooyudev.Habilites.Magma;
import me.shooyudev.Habilites.Monk;
import me.shooyudev.Habilites.Ninja;
import me.shooyudev.Habilites.Phantom;
import me.shooyudev.Habilites.Snail;
import me.shooyudev.Habilites.Specialist;
import me.shooyudev.Habilites.Stomper;
import me.shooyudev.Habilites.Strong;
import me.shooyudev.Habilites.Sumo;
import me.shooyudev.Habilites.Switcher;
import me.shooyudev.Habilites.Thor;
import me.shooyudev.Habilites.Viking;
import me.shooyudev.Habilites.Viper;
import me.shooyudev.Jump.Diamante;
import me.shooyudev.Jump.Esmeralda;
import me.shooyudev.Jump.Ferro;
import me.shooyudev.Jump.Redstone;
import me.shooyudev.ScoreAnimada.BlinkEffect;
import me.shooyudev.ScoreAnimada.Scroller;
import me.shooyudev.Utills.Challenge;
import me.shooyudev.Utills.FpsEnum;
import me.shooyudev.Utills.Recraft;
import me.shooyudev.Utills.Sopas;
import me.shooyudev.Utills.Strings;
import me.shooyudev.menus.IntercanbioMenus;
import me.shooyudev.menus.Menus;
import me.shooyudev.scoreboarding.Updater;

public class CoverPvP extends JavaPlugin implements KitPvP {
	
	@Override
	public void onEnable() {
		super.onEnable();
		KitPvPAPI.setInstance(this);
		
		// TODO: Remover quando melhorar a classe principal
		this.enable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		KitPvPAPI.setInstance(null);
		
		// TODO: Remover quando melhorar a classe principal
		this.disable();
	}

	public static ArrayList<String> login = new ArrayList<>();

	public static FpsEnum estado;
	public static Scroller sc;
	public static Updater up = new Updater();
	public static BlinkEffect bk = new BlinkEffect();

	public static CoverPvP instance;

	public static CoverPvP getInstance() {
		return instance;
	}

	public static Plugin plugin;

	public static Plugin getPlugin() {
		return plugin;
	}

	public void enable() {
		instance = this;
		plugin = this;
		saveDefaultConfig();
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "O Servidor foi iniciado corretamente !");
		Eventos();
		Comandos();
		EventosKits();
		LoadEventosExtras();
		up.run();
		PvP.pvp = true;
		Dano.Dano = true;
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.kickPlayer(ChatColor.DARK_RED + "" + ChatColor.BOLD + "REINCIANDO" + "\n" + "\n" + ChatColor.GRAY
					+ "            Estamos reiniciando para melhorar sua jogabilidade" + "\n" + ChatColor.GRAY
					+ "O Servidor se encontra em Beta " + "\n"
					+ "Bugs? PorFavor nos informen pelo Twitter: �b�l@ArkuzMCOFICIAL" + "\n" + ChatColor.GRAY
					+ "Mais informa�oes em nosso site: �nConstrução...");
		}
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				String[] msg = { Strings.servidormensagem + API.mensagem1, Strings.servidormensagem + API.mensagem2,
						Strings.servidormensagem + API.mensagem3, Strings.servidormensagem + API.mensagem4,
						Strings.servidormensagem + API.mensagem5 };

				Bukkit.getServer().broadcastMessage(msg[new java.util.Random().nextInt(msg.length)]);
			}
		}, 40L, 1900L);
		for (World world : Bukkit.getServer().getWorlds()) {
			world.setGameRuleValue("doDaylightCycle", "false");
		}
	}

	public void disable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "O Servidor foi desligado corretamente !");
	}

	void Eventos() {
		Bukkit.getPluginManager().registerEvents(new Challenge(), this);
		Bukkit.getPluginManager().registerEvents(new TabAPI(), this);
		Bukkit.getPluginManager().registerEvents(new SKit(), this);
		Bukkit.getPluginManager().registerEvents(new PvP(), this);
		Bukkit.getPluginManager().registerEvents(new Dano(), this);
		Bukkit.getPluginManager().registerEvents(new Login(), this);
		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
		Bukkit.getPluginManager().registerEvents(new EventoAuthEvents(), this);
		Bukkit.getPluginManager().registerEvents(new SetEvento(), this);
		Bukkit.getPluginManager().registerEvents(new Arena(), this);
		Bukkit.getPluginManager().registerEvents(new Admin(), this);
		Bukkit.getPluginManager().registerEvents(new IntercanbioMenus(), this);
		Bukkit.getPluginManager().registerEvents(new Menus(), this);
		Bukkit.getPluginManager().registerEvents(new Entrar(), this);
		Bukkit.getPluginManager().registerEvents(new Sair(), this);
		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
		Bukkit.getPluginManager().registerEvents(new Build(), this);
		Bukkit.getPluginManager().registerEvents(new WarpsAPI(), this);
		Bukkit.getPluginManager().registerEvents(new Warp(), this);
		Bukkit.getPluginManager().registerEvents(new DeathEvents(), this);
		Bukkit.getPluginManager().registerEvents(new Respawn(), this);
		Bukkit.getPluginManager().registerEvents(new Proteção(), this);
		Bukkit.getPluginManager().registerEvents(new Principais(), this);
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
		Bukkit.getPluginManager().registerEvents(new Sopas(), this);
		Bukkit.getPluginManager().registerEvents(new Recraft(), this);
		Bukkit.getPluginManager().registerEvents(new DropEvents(), this);
		Bukkit.getPluginManager().registerEvents(new DanoEvents(), this);
		Bukkit.getPluginManager().registerEvents(new ChatFloodEvents(), this);
		Bukkit.getPluginManager().registerEvents(new ClickTest(), this);
		Bukkit.getPluginManager().registerEvents(new Sc(), this);
		Bukkit.getPluginManager().registerEvents(new Diamante(this), this);
		Bukkit.getPluginManager().registerEvents(new Esmeralda(this), this);
		Bukkit.getPluginManager().registerEvents(new Ferro(this), this);
		Bukkit.getPluginManager().registerEvents(new Redstone(this), this);
		Bukkit.getPluginManager().registerEvents(new Manutençao(), this);
	}

	void EventosKits() {
		Bukkit.getPluginManager().registerEvents(new Grappler(), this);
		Bukkit.getPluginManager().registerEvents(new Hulk(), this);
		Bukkit.getPluginManager().registerEvents(new Phantom(), this);
		Bukkit.getPluginManager().registerEvents(new Sumo(), this);
		Bukkit.getPluginManager().registerEvents(new Ajnin(), this);
		Bukkit.getPluginManager().registerEvents(new Boxer(), this);
		Bukkit.getPluginManager().registerEvents(new Madman(), this);
		Bukkit.getPluginManager().registerEvents(new Monk(), this);
		Bukkit.getPluginManager().registerEvents(new Strong(), this);
		Bukkit.getPluginManager().registerEvents(new Viking(), this);
		Bukkit.getPluginManager().registerEvents(new Critical(), this);
		Bukkit.getPluginManager().registerEvents(new Magma(), this);
		Bukkit.getPluginManager().registerEvents(new Thor(), this);
		Bukkit.getPluginManager().registerEvents(new Switcher(), this);
		Bukkit.getPluginManager().registerEvents(new Thor(), this);
		Bukkit.getPluginManager().registerEvents(new Fisherman(), this);
		Bukkit.getPluginManager().registerEvents(new Anchor(), this);
		Bukkit.getPluginManager().registerEvents(new Ninja(), this);
		Bukkit.getPluginManager().registerEvents(new Gladiator(), this);
		Bukkit.getPluginManager().registerEvents(new Kangaroo(), this);
		Bukkit.getPluginManager().registerEvents(new Specialist(), this);
		Bukkit.getPluginManager().registerEvents(new Stomper(), this);
		Bukkit.getPluginManager().registerEvents(new Snail(), this);
		Bukkit.getPluginManager().registerEvents(new Viper(), this);
	}

	void Comandos() {
		getCommand("desabilitar").setExecutor(new Desabilitar());
		getCommand("habilitar").setExecutor(new Habilitar());
		getCommand("groupyoutuber").setExecutor(new GroupYoutuber());
		getCommand("cps").setExecutor(new ClickTest());
		getCommand("report").setExecutor(new Report(this));
		getCommand("sc").setExecutor(new Sc());
		getCommand("acc").setExecutor(new Account());
		getCommand("account").setExecutor(new Account());
		getCommand("ping").setExecutor(new Ping());
		getCommand("tell").setExecutor(new Tell());
		getCommand("groupvip").setExecutor(new GroupVip());
		getCommand("groupset").setExecutor(new GroupSet());
		getCommand("groupbuilder").setExecutor(new GroupBuilder());
		getCommand("fake").setExecutor(new Fake());
		getCommand("skit").setExecutor(new SKit());
		getCommand("pvp").setExecutor(new PvP());
		getCommand("dano").setExecutor(new Dano());
		getCommand("register").setExecutor(new Register());
		getCommand("login").setExecutor(new Logar());
		getCommand("ip").setExecutor(new Conectado());
		getCommand("aplicar").setExecutor(new Aplicar());
		getCommand("setevento").setExecutor(new SetEvento());
		getCommand("setarena").setExecutor(new Arena());
		getCommand("admin").setExecutor(new Admin());
		getCommand("setrank").setExecutor(new SetRank());
		getCommand("rank").setExecutor(new Rank());
		getCommand("manutencao").setExecutor(new Manutençao());
		getCommand("groupset").setExecutor(new GroupSet());
		getCommand("chat").setExecutor(new Chat());
		getCommand("broadcast").setExecutor(new Bc());
		getCommand("bc").setExecutor(new Bc());
		getCommand("kit").setExecutor(new Kit());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("set").setExecutor(new SetWarp());
		getCommand("warp").setExecutor(new Warp());
		getCommand("youtuber").setExecutor(new Youtuber());
		getCommand("tag").setExecutor(new Tag());
		getCommand("ban").setExecutor(new Ban());
		getCommand("ipban").setExecutor(new IPBan());
		getCommand("kick").setExecutor(new Kick());
		getCommand("mute").setExecutor(new Mute());
		getCommand("unban").setExecutor(new Unban());
		getCommand("build").setExecutor(new Build());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("tp").setExecutor(new Tp());
		getCommand("tphere").setExecutor(new Tp());
		getCommand("tpall").setExecutor(new Tp());
		getCommand("evento").setExecutor(new Evento());

	}

	void LoadEventosExtras() {
		EventoConfig.getConfig().ConfigEnable(this);
		AuthConfig.getConfig().ConfigEnable(this);
		ArenaConfig.getConfig().ConfigEnable(this);
		WarpsConfig.getConfig().ConfigEnable(this);
		Config.getConfig().setupConfig(this);
		new StatsManager();
	}
}
