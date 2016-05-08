package teretana.clan;

import java.io.Serializable;

/**
 * Klasa predstavlja clana teretane.
 * 
 * @author Filip Furtula, Edis Sarda, Marko Stanimirovic
 *
 */
public class Clan implements Serializable {

	/**
	 * Broj clanske karte clana.
	 */
	private String brojClanskeKarte;
	/**
	 * Atribut koji simbolizuje ime clana.
	 */
	private String ime;
	/**
	 * Prezime clana.
	 */
	private String prezime;
	/**
	 * Godina rodjenja clana.
	 */
	private int godiste;
	/**
	 * Pol clana (M - musko, Z-zensko).
	 */
	private char pol;

	/**
	 * Broj telefona clana.
	 */
	private String brojTelefona;
	/**
	 * Adresa clana
	 */
	private String adresa;
	/**
	 * Tezina clana
	 */
	private double tezina;
	/**
	 * Visina clana
	 */
	private double visina;
	/**
	 * Sifra clana, koja mu omogucava pristup svojim podacima.
	 */
	private String sifra;
	/**
	 * Mesec (i godina) do kog je clan platio clanarinu
	 */
	private String placenaClanarina;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clan other = (Clan) obj;
		if (brojClanskeKarte == null) {
			if (other.brojClanskeKarte != null)
				return false;
		} else if (!brojClanskeKarte.equals(other.brojClanskeKarte))
			return false;
		return true;
	}

	/**
	 * 
	 * @return broj clankse karte clana
	 */
	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}

	/**
	 * Postavlja broj clanske karte clana na zadatu vrednost
	 * 
	 * @param brojClanskeKarte
	 *            nova vrijednost clanske karte
	 */
	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}

	/**
	 * 
	 * @return ime clana
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime clana na zadatu vrijednost
	 * 
	 * @param ime
	 *            novo ime clana
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * 
	 * @return prezime clana
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime clana na zadatu vrijednost
	 * 
	 * @param prezime
	 *            novo prezime clana
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * 
	 * @return broj telefona clana
	 */
	public String getBrojTelefona() {
		return brojTelefona;
	}

	/**
	 * Postavlja broj telefona clana na zadatu vrijednost
	 * 
	 * @param brojTelefona
	 *            novi broj telefona clana
	 */
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	/**
	 * 
	 * @return adresa clana
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * Postavlja adresu clana na zadatu vrijednost
	 * 
	 * @param adresa
	 *            nova adresa clana
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	/**
	 * 
	 * @return godiste clana
	 */
	public int getGodiste() {
		return godiste;
	}

	/**
	 * Postavlja godiste clana na zadatu vrijednost
	 * 
	 * @param godiste
	 *            novo godiste clana
	 */
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	/**
	 * 
	 * @return pol clana
	 */
	public char getPol() {
		return pol;
	}

	/**
	 * Postavlja pol clana na zadatu vrijednost
	 * 
	 * @param pol
	 *            novi pol clana
	 */
	public void setPol(char pol) {
		this.pol = pol;
	}

	/**
	 * 
	 * @return tezina clana
	 */
	public double getTezina() {
		return tezina;
	}

	/**
	 * Postavlja tezinu clana na zadatu vrijednost
	 * 
	 * @param tezina
	 *            nova tezina clana
	 */
	public void setTezina(double tezina) {
		this.tezina = tezina;
	}

	/**
	 * 
	 * @return visina clana
	 */
	public double getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu clana na zadatu vrijednost
	 * 
	 * @param visina
	 *            nova visina clana
	 */
	public void setVisina(double visina) {
		this.visina = visina;
	}

	/**
	 * 
	 * @return sifra clana
	 */
	public String getSifra() {
		return sifra;
	}

	/**
	 * Postavlja sifru clana na zadatu vrijednost
	 * 
	 * @param sifra
	 */
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	/**
	 * 
	 * @return mesec (i godina) do kog je clan platio clanarinu
	 */
	public String getPlacenaClanarina() {
		return placenaClanarina;
	}

	/**
	 * Postavlja atribut placenaClanarina na zadatu vrednost
	 * 
	 * @param placenaClanarina
	 *            - mesec (i godina) do kog je clan platio clanarinu
	 */
	public void setPlacenaClanarina(String placenaClanarina) {
		this.placenaClanarina = placenaClanarina;
	}

}
