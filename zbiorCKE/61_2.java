ArrayList<String> lista = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\61\\ciagi.txt"));


for (int i = 1; i < lista.size(); i+=2) {
  String[] liczby = lista.get(i).split(" ");
  int najwieksza = 0;
  for (int j = 0; j < liczby.length; j++) {
    if(Math.cbrt(Double.parseDouble(liczby[j]))%1==0) {
      najwieksza = Integer.parseInt(liczby[j]);
    }
  }
  if(najwieksza > 0) {
    System.out.println(najwieksza);
  }

}
