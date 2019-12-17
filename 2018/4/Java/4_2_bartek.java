ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2018\\Dane_PR2\\sygnaly.txt"));
		
int ilosc = 0;
String slowo = "";

for (int i = 0; i < linie.size(); i++) {
  int powtorzenia = 0;
  String slowoOld = linie.get(i);

  for (int j = 0; j < linie.get(i).length(); j++) {
    for (int j2 = j+1; j2 < linie.get(i).length(); j2++) {

      if(j!=j2 && j2+1 <= linie.get(i).length()) {
        if(linie.get(i).substring(j,j+1).equals(linie.get(i).substring(j2,j2+1)) && !linie.get(i).substring(j,j+1).equals("*")) {
          powtorzenia++;
          char[] slowoChar = linie.get(i).toCharArray();
          slowoChar[j2] = '*';
          linie.set(i, String.valueOf(slowoChar));
        }
      }
    }
  }
  if(ilosc < linie.get(i).length() - powtorzenia) {
    ilosc = linie.get(i).length() - powtorzenia;
    slowo = slowoOld;
  }
}

System.out.println(ilosc);
System.out.println(slowo);
