ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2018\\Dane_PR2\\woda.txt"));
		
String rokNaj = "";
int sumaNaj = 0;

String rok = "";
int suma = 0;
for (int i = 0; i < linie.size(); i++) {
  if(!linie.get(i).substring(0,4).equals(rok)) {
    if(suma > sumaNaj) {
      sumaNaj = suma;
      rokNaj = rok;
    }
    rok = linie.get(i).substring(0,4);
    suma = 0;
  }
  suma = suma + Integer.parseInt(linie.get(i).split("\t")[1]);

}
System.out.println(rokNaj+" "+sumaNaj);
