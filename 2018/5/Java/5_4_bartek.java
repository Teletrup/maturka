ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2018\\Dane_PR2\\woda.txt"));
		
int count = 0;
int zbiornik = 500000;
int nwzi = 0;
int zbiornikInfinite = 500000;
for (int i = 0; i < linie.size(); i++) {
  System.out.println(linie.get(i).split("\t")[0]+" "+zbiornik);
  if(zbiornik >= 800000) {//zliczanie dni z minimum 800 000 m2 w zbiorniku
    count++;
  }

  if(zbiornikInfinite > nwzi) {//sprawdzanie najwiekszej wartosci zbiornika infinite
    nwzi = zbiornikInfinite;
  }


  if(zbiornik > 1000000) { //przepelnienie zbiornika
    zbiornik = 1000000;
    System.out.println("/\\ Przepelnienie /\\");
  }

  zbiornik = zbiornik - (int)Math.ceil(zbiornik*0.02f); //spuszczanie 2%
  zbiornikInfinite = zbiornikInfinite - (int)Math.ceil(zbiornikInfinite*0.02f); //spuszczanie 2% (dla zbiornika infinite)

  zbiornik = zbiornik + Integer.parseInt(linie.get(i).split("\t")[1]); //dodanie dziennego wplywu
  zbiornikInfinite = zbiornikInfinite + Integer.parseInt(linie.get(i).split("\t")[1]); //dodanie dziennego wplywu (dla zbiornika infinite)

}

System.out.println("min. 800 000 m2 przez: "+count+" dni");
System.out.println("najwieksza wartosc zbiornika infinite: "+nwzi);
