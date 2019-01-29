package com.packt.bank.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Operazione implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idOperazione;
	private String luogo;
	private String tipo;
	private double importo;
	private Date data;
	private Time ora;
	private int idCarta;
	
	public int getIdOperazione() {
		return idOperazione;
	}
	public void setIdOperazione(int idOperazione) {
		this.idOperazione = idOperazione;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getOra() {
		return ora;
	}
	public void setOra(Time ora) {
		this.ora = ora;
	}
	public int getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}
	@Override
	public String toString() {
		return "Operazione [idOperazione=" + idOperazione + ", luogo=" + luogo + ", tipo=" + tipo + ", importo="
				+ importo + ", idCarta=" + idCarta + "]";
	}

}
