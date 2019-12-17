ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2018\\Dane_PR2\\sygnaly.txt"));
		
String dm = "";
  for (int i = 39; i < linie.size(); i+= 40) {
    dm = dm + linie.get(i).substring(9,10);
  }

System.out.println(dm);
