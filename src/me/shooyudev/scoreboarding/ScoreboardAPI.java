package me.shooyudev.scoreboarding;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardAPI {
	public Scoreboard Scoreboard;
	public String Titulo;
	public Map<String, Integer> Scores;
	public List<Team> Times;
	public Objective Objetivo;

	public ScoreboardAPI(String Titulo) {
		this.Scoreboard = org.bukkit.Bukkit.getScoreboardManager().getNewScoreboard();
		this.Titulo = Titulo;
		this.Scores = Maps.newLinkedHashMap();
		this.Times = com.google.common.collect.Lists.newArrayList();
	}

	public void adicionarLinha(String Mensagem, Integer Score) {
		Preconditions.checkArgument(Mensagem.length() < 500, "Não passe de 500 caracteres!");
		Mensagem = Substituir(Mensagem);
		this.Scores.put(Mensagem, Score);
	}

	public String Substituir(String Mensagem) {
		while (this.Scores.containsKey(Mensagem)) {
			Mensagem = Mensagem + "§r";
		}
		if (Mensagem.length() > 70)
			Mensagem = Mensagem.substring(0, 69);
		return Mensagem;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map.Entry<Team, String> criarTimes(String Mensagem) {
		String Resultado = "";
		if (Mensagem.length() <= 16) {
			return new AbstractMap.SimpleEntry(null, Mensagem);
		}
		Team Time = this.Scoreboard.registerNewTeam("text-" + this.Scoreboard.getTeams().size());
		Iterator MensagemSplit = Splitter.fixedLength(16).split(Mensagem).iterator();
		Time.setPrefix((String) MensagemSplit.next());
		Resultado = (String) MensagemSplit.next();

		if (Mensagem.length() > 32)
			Time.setSuffix((String) MensagemSplit.next());
		this.Times.add(Time);
		return new AbstractMap.SimpleEntry(Time, Resultado);
	}

	@SuppressWarnings("rawtypes")
	public void setarScoreboard() {
		this.Objetivo = this.Scoreboard.registerNewObjective("flation", "dummy");
		this.Objetivo.setDisplayName(Titulo);
		this.Objetivo.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);
		int index = this.Scores.size();
		for (Map.Entry Mensagem : this.Scores.entrySet()) {
			Map.Entry Time = criarTimes((String) Mensagem.getKey());
			Integer Score = Integer
					.valueOf(Mensagem.getValue() != null ? ((Integer) Mensagem.getValue()).intValue() : index);
			String Jogador = (String) Time.getValue();

			if (Time.getKey() != null)
				((Team) Time.getKey()).addEntry(Jogador);
			this.Objetivo.getScore(Jogador).setScore(Score.intValue());
			index--;
		}
	}

	public void resetarScoreboard() {
		if (this.Objetivo != null) {
			this.Objetivo.unregister();
		}
		this.Scores.clear();
		for (Team Times : this.Times)
			Times.unregister();
		this.Times.clear();
	}

	public Scoreboard pegarScoreboard() {
		return this.Scoreboard;
	}
}
