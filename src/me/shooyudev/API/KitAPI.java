package me.shooyudev.API;

import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.shooyudev.Comandos.Arena;
import me.shooyudev.Events.Proteção;
import me.shooyudev.scoreboarding.Updater;

public class KitAPI {

	public static ItemStack sopa;
	public static ItemMeta sopam;
	public static ItemStack cogu1;
	public static ItemMeta cogu1m;
	public static ItemStack cogu2;
	public static ItemMeta cogu2m;
	public static ItemStack pote;
	public static ItemMeta potem;
	
public static HashMap<String, String> Kit = new HashMap<>();
	
	public static void setKit(Player p, String kit) {
		Kit.put(p.getName(), kit);
	}
	
	public static String getKit(Player p) {
		if (Kit.containsKey(p.getName())) {
			return Kit.get(p.getName());
		} else {
			return "Nenhum";
		}
	}
	
	public static void TirarKit(Player p) {
		Kit.remove(p.getName());
	}
	
	public static void DarSopa(Player p) {
	    sopa = new ItemStack(Material.MUSHROOM_SOUP);
	    sopam = sopa.getItemMeta();
	    sopam.setDisplayName("");
	    sopa.setItemMeta(sopam);
	    
	    pote = new ItemStack(Material.BOWL, 64);
	    potem = pote.getItemMeta();
	    potem.setDisplayName("");
	    pote.setItemMeta(potem);
	    
	    cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
	    cogu1m = cogu1.getItemMeta();
	    cogu1m.setDisplayName("");
	    cogu1.setItemMeta(cogu1m);
	    
	    cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
	    cogu2m = cogu2.getItemMeta();
	    cogu2m.setDisplayName("");
	    cogu2.setItemMeta(cogu2m);
	    
	    ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta kPeito = (LeatherArmorMeta)Peito.getItemMeta();
		kPeito.setDisplayName("§ePeitoral");
		kPeito.setColor(Color.YELLOW);
		Peito.setItemMeta(kPeito);
		p.getInventory().setChestplate(Peito);
	    
	    ItemStack bussula = new ItemStack(Material.COMPASS);
	    ItemMeta bussulameta = bussula.getItemMeta();
	    bussulameta.setDisplayName("§aBussula");
	    bussula.setItemMeta(bussulameta);
	    
	    p.getInventory().setItem(8, bussula);
	    
	    for (int i = 1; i < 35; i++) {
	    	p.getInventory().addItem(sopa);
	    	p.getInventory().setItem(13, pote);
	    	p.getInventory().setItem(14, cogu1);
	    	p.getInventory().setItem(15, cogu2);
	    }
	}
	
	public static void PvP(Player p) {
		setKit(p, "PvP");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);

	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
		espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	   
	}
	
	public static void Kangaroo(Player p) {
		setKit(p, "Kangaroo");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    ItemStack kan = new ItemStack(Material.FIREWORK);
	    ItemMeta kanm = kan.getItemMeta();
	    kanm.setDisplayName("§eKangaroo");
	    kan.setItemMeta(kanm);
	    
    	p.getInventory().setItem(0, espada);
    	p.getInventory().setItem(1, kan);
	   
	}
	
	public static void Specialist(Player p) {
		setKit(p, "Specialist");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    ItemStack kan = new ItemStack(Material.ENCHANTED_BOOK);
	    ItemMeta kanm = kan.getItemMeta();
	    kanm.setDisplayName("§eSpecialist");
	    kan.setItemMeta(kanm);
	    
    	p.getInventory().setItem(0, espada);
    	p.getInventory().setItem(1, kan);
	   
	}
	
	public static void Stomper(Player p) {
		setKit(p, "Stomper");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    ItemStack kan = new ItemStack(Material.EMERALD);
	    ItemMeta kanm = kan.getItemMeta();
	    kanm.setDisplayName("§eStomper");
	    kan.setItemMeta(kanm);
	    
    	p.getInventory().setItem(0, espada);
    	p.getInventory().setItem(1, kan);
	   
	}
	public static void Gladiator(Player p) {
		setKit(p, "Gladiator");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    ItemStack kan = new ItemStack(Material.IRON_FENCE);
	    ItemMeta kanm = kan.getItemMeta();
	    kanm.setDisplayName("§eGladiator");
	    kan.setItemMeta(kanm);
	    
	    
	    
    	p.getInventory().setItem(0, espada);
    	p.getInventory().setItem(1, kan);
	   
	}
	public static void Snail(Player p) {
		setKit(p, "Snail");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Viper(Player p) {
		setKit(p, "Viper");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Ninja(Player p) {
		setKit(p, "Ninja");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Fisherman(Player p) {
		setKit(p, "Fisherman");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    ItemStack kan = new ItemStack(Material.FISHING_ROD);
	    ItemMeta kanm = kan.getItemMeta();
	    kanm.setDisplayName("§eFisherman");
	    kan.setItemMeta(kanm);
	    
	    
	    
    	p.getInventory().setItem(0, espada);
    	p.getInventory().setItem(1, kan);
	   
	}
	public static void Switcher(Player p) {
		setKit(p, "Switcher");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    ItemStack kan = new ItemStack(Material.SNOW_BALL, 64);
	    ItemMeta kanm = kan.getItemMeta();
	    kanm.setDisplayName("§eSwitcher");
	    kan.setItemMeta(kanm);
	    
    	p.getInventory().setItem(0, espada);
    	p.getInventory().setItem(1, kan);
	}
	public static void Thor(Player p) {
		setKit(p, "Thor");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
	    ItemStack kan = new ItemStack(Material.GOLD_AXE);
	    ItemMeta kanm = kan.getItemMeta();
	    kanm.setDisplayName("§eThor");
	    kan.setItemMeta(kanm);
	    
    	p.getInventory().setItem(0, espada);
    	p.getInventory().setItem(1, kan);
	}
	public static void Anchor(Player p) {
		setKit(p, "Anchor");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Magma(Player p) {
		setKit(p, "Magma");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Critical(Player p) {
		setKit(p, "Critical");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Ajnin(Player p) {
		setKit(p, "Ajnin");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Boxer(Player p) {
		setKit(p, "Boxer");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.QUARTZ);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aBoxer");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Madman(Player p) {
		setKit(p, "Madman");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Monk(Player p) {
		setKit(p, "Monk");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack monk = new ItemStack(Material.BLAZE_ROD);
	    ItemMeta monkm = monk.getItemMeta();
	    monkm.setDisplayName("§aMonk");
	    monk.setItemMeta(monkm);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(1, monk);
    	p.getInventory().setItem(0, espada);
	}
	public static void Strong(Player p) {
		setKit(p, "Strong");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack monk = new ItemStack(Material.WATCH);
	    ItemMeta monkm = monk.getItemMeta();
	    monkm.setDisplayName("§aStrong");
	    monk.setItemMeta(monkm);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(1, monk);
    	p.getInventory().setItem(0, espada);
	}
	public static void Viking(Player p) {
		setKit(p, "Viking");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.IRON_AXE);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aViking");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Grappler(Player p) {
		setKit(p, "Grappler");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack grappler = new ItemStack(Material.LEASH);
	    ItemMeta grapplerm = grappler.getItemMeta();
	    grapplerm.setDisplayName("§aGrappler");
	    grappler.setItemMeta(grapplerm);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(1, grappler);
    	p.getInventory().setItem(0, espada);
	}
	public static void Hulk(Player p) {
		setKit(p, "Hulk");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
	public static void Phantom(Player p) {
		setKit(p, 	"Phantom");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack phantom = new ItemStack(Material.FEATHER);
	    ItemMeta phantomm = phantom.getItemMeta();
	    phantomm.setDisplayName("§aPhantom");
	    phantom.setItemMeta(phantomm);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(1, phantom);
    	p.getInventory().setItem(0, espada);
	}
	public static void Sumo(Player p) {
		setKit(p, "Sumo");
	    Updater.UpdateScore(p);
		p.getInventory().clear();
		DarSopa(p);
		Arena.ArenaRandom(p);
		Proteção.setImortalidade(p, false);
		p.setAllowFlight(false);
		
	    ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadam = espada.getItemMeta();
	    espadam.setDisplayName("§aEspada");
	    espada.setItemMeta(espadam);
	    
    	p.getInventory().setItem(0, espada);
	}
}
