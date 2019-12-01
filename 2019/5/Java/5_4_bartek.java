ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2019\\Dane_PR2\\pogoda.txt"));

		int poziomChmurPoprawny = 1;
		int typChmurPoprawny = 1;
		
		int poziomChmur = 0;
		int dzienChmur = 0;
		String typChmur = "";
		
		ArrayList<Integer> dniChmur = new ArrayList<Integer>();
		dniChmur.add(0);
		dniChmur.add(0);
		dniChmur.add(0);
		dniChmur.add(0);
		dniChmur.add(0);
		dniChmur.add(0);
		
		
		
		for (int i = 1; i <= 499; i++) {
			
			String dzisiaj = linie.get(i);
			String jutro = linie.get(i + 1);
			
			Integer opadDzisiaj = Integer.parseInt(dzisiaj.split(";")[2]);
			float temperaturaJutro = Float.parseFloat(linie.get(i + 1).split(";")[1].replace(',', '.'));
			Integer poziomChmurDzisiaj = Integer.parseInt(dzisiaj.split(";")[4]);
			
			
			
			
			
			if(opadDzisiaj >= 20 && poziomChmur == 5) {
				typChmur = "0";
				poziomChmur = 0;
				dzienChmur = 0;
			}
			else if(opadDzisiaj == 0) {
				if(temperaturaJutro >= 10) {
					typChmur = "C";
				}
				else {
					typChmur = "S";
				}
				poziomChmur = 1;
			}
			else if (dzienChmur == 3 && poziomChmur != 5) {
				dzienChmur = 0;
				poziomChmur++;
			}
			
			if(poziomChmur != 0) {
				dzienChmur++;
			}
			
			dniChmur.set(poziomChmur, dniChmur.get(poziomChmur) + 1);
			
			if(i < 301) {
				Integer poziomChmurJutro = Integer.parseInt(jutro.split(";")[4]);
				if(poziomChmurJutro == poziomChmur) {
					poziomChmurPoprawny ++;
				}
				else {
					System.out.println("ZLA WIELKOSC");
				}
				
				String kategoriaChmurJutro = jutro.split(";")[3];
				if(kategoriaChmurJutro.equals(typChmur)) {
					typChmurPoprawny++;
				}
				else {
					System.out.println("ZLA KATEGORIA");
				}
			}
			
			System.out.println("dzien:"+(i+1));
			System.out.println("poziom:"+poziomChmur);
			System.out.println("dzien:"+dzienChmur);
			//System.out.println("opad:"+opadDzisiaj);
			System.out.println("typ:"+typChmur);
			System.out.println("------------------------");
		
			
			
		}
		
		System.out.println("suma wystepowania typow chmur:");
		System.out.println("0:"+dniChmur.get(0));
		System.out.println("1:"+dniChmur.get(1));
		System.out.println("2:"+dniChmur.get(2));
		System.out.println("3:"+dniChmur.get(3));
		System.out.println("4:"+dniChmur.get(4));
		System.out.println("5:"+dniChmur.get(5));
		System.out.println("------------------------");
		System.out.println("dni poprawne ze wzgledu na wielkosc:"+poziomChmurPoprawny);
		System.out.println("dni poprawne ze wzgledu na kategorie:"+typChmurPoprawny);
