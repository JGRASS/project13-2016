package teretana.clan.sistemske_operacije;

import java.util.List;

import teretana.clan.Clan;

public class SOIzmeniClanaPoIndeksu {
	
	public static void izvrsi(List<Clan> clanovi, int index, String brojTelefona, String adresa, double tezina, double visina, String sifra,
			String clanarinaPlacenaDo) throws Exception {
		Clan c = clanovi.get(index);
		c.setBrojTelefona(brojTelefona);
		c.setAdresa(adresa);
		c.setTezina(tezina);
		c.setVisina(visina);
		c.setSifra(sifra);
		c.setPlacenaClanarina(clanarinaPlacenaDo);

	}

}
