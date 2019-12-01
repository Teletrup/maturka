ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2019\\Dane_PR2\\pogoda.txt")); //pobranie pliku i zaladowanie od tablicy

		//deklaracje zmiennych
		int najdluzszy = 0;
		int aktualny = 1;
		int pierwszy = 0;
		int ostatni  = 0;
		
		
		for (int i = 2; i < linie.size(); i++) { //petla przez caly plik (zaczynam od drugiej linii)
			
			float tempNew = Float.parseFloat(linie.get(i).split(";")[1].replace(',', '.')); //wyciagniecie temperatury z linijki aktualnej
			float tempOld = Float.parseFloat(linie.get(i - 1).split(";")[1].replace(',', '.')); //wyciagniecie temperatury z linijki poprzedniej
			System.out.println(i+"|"+tempOld+" "+tempNew);
			if(tempOld < tempNew) { //jesli temperatura z aktualnej linijki jest wieksza od poprzedniej
				aktualny++; //dolicz do aktualnego ciagu +1
			}
			else { //jesli temperatura jest nizsza od poprzedniej (koniec rosnocego ciagu)
				
				if(aktualny > najdluzszy) { //sprawdz czy to byl najdluzszy ciag
					
					najdluzszy = aktualny; //jesli tak to ustaw go jako najdluzszy
					ostatni = i; //odstatnia linijka (powinno być -1 ale liczy od 0 wiec jest git)
					pierwszy = ostatni - najdluzszy + 1; //+1 bo wlacznie
				}
				aktualny = 1; //reset akualnego ciagu (1 bo sprawdza od drugiego wyrazu ciagu)
			}
		}
		
		System.out.println(pierwszy);
		System.out.println(ostatni);
		System.out.println(najdluzszy);
