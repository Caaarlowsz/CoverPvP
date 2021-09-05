package me.shooyudev.ScoreAnimada;

public class BlinkEffect {
	
	private int i = 1;
	private String texto = "§c§lArkuz§f§lMC";
	public BlinkEffect(){
		
	}
	
	public void next(){
		if (i == 1){
			texto = "§c§lA" + "r"+  "k" + "u" + "z" + "§f§lM" + "§f§lC";
		}
		if (i == 2){
			texto = "§c§lA" + "r" + "§f§lk" + "§e§lu" + "z" + "§f§lM" + "C";
		}
		if (i == 3){
			texto = "§c§lA" + "r" + "§f§lk" + "§e§lu" + "z" + "§f§lM" + "C";
		}
		if (i == 4){
			texto = "§c§lA" + "r" + "§f§lk" + "§e§lu" + "r" + "§f§lz" + "M" + "C";
		}
		if (i == 5){
			texto = "§c§lA" + "r" + "§f§lk" + "§e§lu" + "§f§lz" + "M" + "C";
		}
		if (i == 6){
			texto = "§c§lA" + "r" + "k" + "u" + "§f§lz" + "§f§lM" + "C";
		}
		if (i == 7){
			texto = "§c§lA" + "r" + "k" + "u" + "z" + "§f§lM" + "§e§lC";
		}
		if (i == 8){
			texto = "§c§lA" + "r" + "k" + "u" + "z" + "§f§lM" + "§e§lC";
		}
		if (i == 9){
			texto = "§c§lA" + "r" + "k" + "u" + "z" + "§f§lM" + "§e§lC";
		}
		if (i == 10) {
			texto = "§c§lA" + "r" + "k" + "u" + "z"  + "§f§lM" + "§e§lC";
		}
		if (i == 11) {
			texto = "§c§lA" + "r" + "k" + "u" + "z"  + "§f§lM" + "§e§lC";
		}
		if (i == 12) {
			texto = "§c§lA" + "r" + "k" + "u" + "z"  + "§f§lM" + "§e§lC";
		}
		if (i == 13) {
			texto = "§c§lA" + "r" + "k" + "u" + "z" + "§f§lM"  + "§e§lC";
		}
		if (i == 14) {
			texto = "§c§lA" + "r" + "k" + "§f§lu" + "§e§lz"  + "§f§lM" + "§f§lC";
		}
		if (i == 15) {
			texto = "§c§lA" + "r" + "§f§lk" + "§e§lu" + "z"  + "§f§lM" + "§e§lC";
		}
		if (i == 16) {
			texto = "§c§lA" + "§f§lr" + "§e§lk" + "u" + "z"  + "§f§lM" + "§e§lC";
		}
		if (i == 17) {
			texto = "§f§lA" + "§e§lr" + "k" + "u" + "z"  + "§f§lM" + "§e§lC";
		}
		if (i == 18) {
			texto = "§c§l§kArkuz§f§lMC";
		}
		if (i == 18) {
			texto = "§e§lArkuz§f§l§kMC";
		}
		if (i == 19){
			texto = "§e§l§kArkuz§f§lMC";
			i = 0;
		}
		i++;
		
		
	}
	public String getText(){
		return texto;
	}

}
