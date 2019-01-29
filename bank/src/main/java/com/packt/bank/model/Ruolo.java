package com.packt.bank.model;

public class Ruolo {
	
	private int id_ruolo;
	private String username;
	private String ruolo;
	public int getId_ruolo() {
		return id_ruolo;
	}
	public void setId_ruolo(int id_ruolo) {
		this.id_ruolo = id_ruolo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	@Override
	public String toString() {
		return "Ruolo [id_ruolo=" + id_ruolo + ", username=" + username + ", ruolo=" + ruolo + "]";
	}
	
}
