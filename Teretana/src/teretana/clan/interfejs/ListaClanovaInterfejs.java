package teretana.clan.interfejs;

import teretana.clan.Clan;

public interface ListaClanovaInterfejs {
	
	public void dodajClana(Clan c) throws Exception;
	public void izbrisiClana(String id) throws Exception;
	public void izmeniClana(Clan c, String brojTelefona, String adresa, double tezina, double visina, String sifra) throws Exception;

}
