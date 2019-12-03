ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2019\\Dane_PR2\\pogoda.txt"));
		
		ArrayList<String> rodzaje = new ArrayList<String>();
		rodzaje.add("C1");
		rodzaje.add("C2");
		rodzaje.add("C3");
		rodzaje.add("C4");
		rodzaje.add("C5");
		rodzaje.add("S1");
		rodzaje.add("S2");
		rodzaje.add("S3");
		rodzaje.add("S4");
		rodzaje.add("S5");
		
		for (int i = 0; i < rodzaje.size(); i++) {
			
			float suma = 0;
			float ilosc = 0;
			
			for (int j = 1; j < 301; j++) {
				
				String typ = linie.get(j).split(";")[3];
				String poziom = linie.get(j).split(";")[4];
				
				if((typ+poziom).equals(rodzaje.get(i))) {
					suma = suma + Float.parseFloat(linie.get(j).split(";")[2]);
					ilosc++;
				}
				
			}
			
			float a = Math.round(suma/ilosc*100);
			a = a / 100;
			System.out.println(rodzaje.get(i)+" "+a);
