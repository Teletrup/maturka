ArrayList<String> lista = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\60\\liczby.txt"));


for (int i = 0; i < lista.size(); i++) {
  ArrayList<Integer> dzielniki = new ArrayList<Integer>();
  int liczba = Integer.parseInt(lista.get(i));
  for (int j = 2; j < (liczba+100)/2; j++) {
    if(liczba%j==0) {
      dzielniki.add(j);
    }
    if(dzielniki.size() > 16) {
      break;
    }
  }
  if(dzielniki.size() == 16) {
    System.out.println(liczba);
    String outString = "1,";
    for (int j = 0; j < dzielniki.size(); j++) {
      outString += dzielniki.get(j) + ",";
    }
    System.out.println(outString);
  }
}
