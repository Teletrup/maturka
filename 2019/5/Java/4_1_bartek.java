ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2019\\Dane_PR2\\liczby.txt"));
		
		int count = 0;
		
		for (int i = 0; i < linie.size(); i++) {
			if((Math.log10(Integer.parseInt(linie.get(i))) / Math.log10(3)) % 1 == 0) {
				count++;
			}
		}
		
		System.out.println(count);
