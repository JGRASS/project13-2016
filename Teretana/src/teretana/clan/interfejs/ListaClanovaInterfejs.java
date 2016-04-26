package teretana.clan.interfejs;

import java.util.LinkedList;

import teretana.clan.Clan;

public interface ListaClanovaInterfejs {

	public void dodajClana(Clan c) throws Exception;

	public void izbrisiClana(String id) throws Exception;

	public void izmeniClana(Clan c, String brojTelefona, String adresa, double tezina, double visina, String sifra)
			throws Exception;

	public void izmeniClana(int index, String brojTelefona, String adresa, double tezina, double visina, String sifra)
			throws Exception;
	
	public Clan getClan(int index);
	
	public void dodajClanove(LinkedList<Clan> clanovi);
	
	public int size();

}
