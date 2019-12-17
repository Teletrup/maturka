ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2018\\Dane_PR2\\woda.txt"));
		
int suma = 0;
String mies = "";
for (int i = 0; i < linie.size(); i++) {
  if(linie.get(i).split("-")[0].equals("2008")) {
    if(!mies.equals(linie.get(i).split("-")[1])) {
      System.out.println(mies+" "+suma);
      mies = linie.get(i).split("-")[1];
      suma = 0;
    }
    suma = suma + Integer.parseInt(linie.get(i).split("\t")[1]);
  }
  else {
    System.out.println(mies+" "+suma);
    break;
  }
}
