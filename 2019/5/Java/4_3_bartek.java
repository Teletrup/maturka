int najdluzszy = 1;
		int aktualny = 0;
		String pierwsza = "";
		int nwdLast = 0;
		int nwdWlasciwy = 0;
		
		ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2019\\Dane_PR2\\liczby.txt"));
		
		for (int i = 0; i < linie.size()-1; i++) {
			
			int nwd = nwd(nwdLast , Integer.parseInt(linie.get(i+1)));
			
			if(nwd > 1) {
				nwdLast = nwd;
				aktualny++;
				
			}
			else {
				if(aktualny > najdluzszy) {
					najdluzszy = aktualny;
					pierwsza = linie.get(i-(najdluzszy));
					nwdWlasciwy = nwdLast;
				}
				aktualny = 0;
				nwd = nwd(Integer.parseInt(linie.get(i)), Integer.parseInt(linie.get(i+1)));
				if(nwd > 1) {
					aktualny++;
				}
				nwdLast = nwd;
			}
			System.out.println(linie.get(i)+"|"+aktualny);
		}
		
		System.out.println("dlugosc:"+(najdluzszy+1));
		System.out.println("poczatek:"+pierwsza);
		System.out.println("nwd:"+nwdWlasciwy);
