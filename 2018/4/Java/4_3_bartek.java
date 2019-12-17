ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2018\\Dane_PR2\\sygnaly.txt"));
		
for (int i = 0; i < linie.size(); i++) {
  int char1 = 1000;
  for (int j = 0; j < linie.get(i).length(); j++) {
    int char0 = (int)linie.get(i).substring(j,j+1).toCharArray()[0];
    if(char0 < char1) {
      char1 = char0;
    }
  }
  boolean blad = false;
   for (int j = 1; j < linie.get(i).length(); j++) {
     int char2 = (int)linie.get(i).substring(j,j+1).toCharArray()[0];
    if(Math.abs(char1-char2)>10) {
      blad = true;
    }
  }
  if(!blad) {
    System.out.println(linie.get(i));
  }
}
