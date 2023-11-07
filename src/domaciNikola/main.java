package domaciNikola;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		System.out.println("Pozdrav, unesite Vaš JMBG");
		
		Scanner scanner = new Scanner(System.in);
		String jmbg = scanner.next();
		if(jmbg.length() != 13) {
			System.out.println("Niste uneli validan jmbg, proverite duzinu.");
			return;
		}
		
		int dan = Integer.parseInt(jmbg.substring(0, 2));
		int mesec = Integer.parseInt(jmbg.substring(2,4));
		int godina = Integer.parseInt(jmbg.substring(4,7));
		int polRegija = Integer.parseInt(jmbg.substring(7,9));
		String politickaRegija;
		int pol = Integer.parseInt(jmbg.substring(9, 12));
		int kontrolnaCifra = Integer.parseInt(jmbg.substring(12, 13));
		String polOsobe;
		int L;
		
		//provera za dan
		if(dan < 1 || dan > 31) {
			System.out.println("Neispravan jmbg, loša vrednost za prve dve cifre.");
			return;
		}
		//provera za mesec rodjenja
		switch (mesec) {
			case 2:
			case 4:
			case 6:
			case 9:
			case 10: {
				if(dan == 31) {
					System.out.println("Neispravan jmbg, nemoguc datum 31 u ovom mesecu.");
					return;
				}
			}
		}
		//provera za godinu
		if(!(godina % 400 == 0 || (godina % 100 != 0 && godina % 4 == 0))
				&& ((dan > 28) && mesec == 2)) {
			//ako nije prestupna godina a dan je veci od 28 u februaru
			System.out.println("Neispravan jmbg, nemoguc ovaj datum u ovom mesecu.");
			return;
		}
		//odredjivanje politicke regije
		if(polRegija < 9) {
			politickaRegija = "stranci bez drzavljanstva bivse SFRJ i njenih naslednica";
		}
		else if (polRegija < 20) {
			politickaRegija = "Bosna i Hercegovina";
		}
		else if (polRegija < 30) {
			politickaRegija = "Crna Gora";
		}
		else if (polRegija < 40) {
			politickaRegija = "Hrvatska";
		}
		else if (polRegija < 50) {
			politickaRegija = "Makedonija";
		}
		else if (polRegija < 60) {
			politickaRegija = "Slovenija";
		}
		else if (polRegija < 70) {
			politickaRegija = "nije korisceno";
		}
		else if (polRegija < 80) {
			politickaRegija = "Centralna Srbija";
		}
		else if (polRegija < 90) {
			politickaRegija = "Autonomna Pokrajina Vojvodina";
		}
		else {
			politickaRegija = "Autonomna Pokrajina Kosovo i Metohija";
		}
		//odredjivanje pola osobe
		if(pol < 500) polOsobe = "muskog pola";
		else polOsobe = "zenskog pola";
		//odredjivanje kontrolne cifre
		int  a = Integer.parseInt(jmbg.substring(0, 1));
		int  b = Integer.parseInt(jmbg.substring(1, 2));
		int  c = Integer.parseInt(jmbg.substring(2, 3));
		int  d = Integer.parseInt(jmbg.substring(3, 4));
		int  e = Integer.parseInt(jmbg.substring(4, 5));
		int  f = Integer.parseInt(jmbg.substring(5, 6));
		int  g = Integer.parseInt(jmbg.substring(6, 7));
		int  h = Integer.parseInt(jmbg.substring(7, 8));
		int  i = Integer.parseInt(jmbg.substring(8, 9));
		int  j = Integer.parseInt(jmbg.substring(9, 10));
		int  l = Integer.parseInt(jmbg.substring(10, 11));
		int  m = Integer.parseInt(jmbg.substring(11, 12));
		
		int control = 11 - ( (7*(a+g)+6*(b+h)+5*(c+i)+4*(d+j)+3*(e+l)+2*(f+m)) %11);
		
		if(control>9) { 
			control = 0;
		}
		
		if(control!=kontrolnaCifra) {
			System.out.println("Niste uneli validan jmbg, proverite duzinu.");
			return;
		}
		
		
		//ispis podataka
		System.out.println("JMBG je validan.");
		System.out.println("===Podaci o korisniku===");
		System.out.println("Datum rodjenja: " + dan + '.' + mesec + '.'
				+ (godina < 10 ? ("200" + godina) : ("1" + godina)) + '.');
		System.out.println("Osoba je " + polOsobe);
		System.out.println("Politicka regija osobe je " + politickaRegija);
		
	}

}
