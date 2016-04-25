package teretana.clan;

import java.util.LinkedList;
import java.util.List;

import teretana.clan.interfejs.ListaClanovaInterfejs;

public class ListaClanova implements ListaClanovaInterfejs {

	private List<Clan> clanovi;
	
	
	public ListaClanova() {
		if(clanovi == null){
			
			clanovi = new LinkedList<>();
		}
	}

	public List<Clan> getListaClanova() {
		if (clanovi == null) {
			return new LinkedList<>();
		} else {
			return clanovi;
		}
	}

	@Override
	public void dodajClana(Clan c) throws Exception {
		if (c == null) {
			throw new Exception("Greska. Nije prosledjen clan.");
		}
		
		clanovi.add(c);
	}
	
	private void izbrisiClana(Clan c) throws Exception {
		if (clanovi.contains(c))
			clanovi.remove(c);
		else
			throw new Exception("Izabrana osoba nije clan teretane.");
	}
	
	@Override
	public void izbrisiClana(String id) throws Exception {
		if (id == null) {
			throw new Exception("Izabrana osoba nije clan teretane.");
		}
		
		for (int i = 0; i < clanovi.size(); i++) {
			if (clanovi.get(i).getBrojClanskeKarte().equals(id)) {
				izbrisiClana(clanovi.get(i));
			}
		}
	}

	@Override
	public void izmeniClana(Clan c, String brojTelefona, String adresa, double tezina, double visina, String sifra) throws Exception {
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
				
				break;
			}
		}
		
	}

}
