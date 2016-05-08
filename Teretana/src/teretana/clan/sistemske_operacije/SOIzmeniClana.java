package teretana.clan.sistemske_operacije;

import java.util.List;

import teretana.clan.Clan;

public class SOIzmeniClana {
	
	public static void izvrsi(List<Clan> clanovi, Clan c, String brojTelefona, String adresa, double tezina, double visina, String sifra, String clanarinaPlacenaDo)
			throws Exception {
		if (!clanovi.contains(c)) {
			throw new Exception("Izabrana osoba nije clan teretane.");
		}

		for (int i = 0; i < clanovi.size(); i++) {
			Clan temp = clanovi.get(i);

			if (temp.equals(c)) {

				temp.setBrojTelefona(brojTelefona);
				temp.setAdresa(adresa);
				temp.setTezina(tezina);
				temp.setVisina(visina);
				temp.setSifra(sifra);
				temp.setPlacenaClanarina(clanarinaPlacenaDo);

				break;
			}
		}

	}

}
