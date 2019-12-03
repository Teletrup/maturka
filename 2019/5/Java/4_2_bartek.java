ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2019\\Dane_PR2\\liczby.txt"));

		for (int i = 0; i < linie.size(); i++) {
			int sum = 0;
			for (int j = 0; j < linie.get(i).length(); j++) {
				sum = sum + silnia(Integer.parseInt((linie.get(i).substring(j,j+1))));
			}
			if(Integer.parseInt(linie.get(i)) == sum) {
				System.out.println(linie.get(i));
			}
		}
