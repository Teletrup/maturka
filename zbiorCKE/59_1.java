ArrayList<String> lista = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\59\\liczby.txt"));

int count = 0;
ArrayList<Integer> czynniki = new ArrayList<Integer>(); 

for (int i = 0; i < lista.size(); i++) {
  czynniki.clear();
  int liczba = Integer.parseInt(lista.get(i));

  //pominiecie parzystych liczb
  if(liczba % 2 == 0) continue;

  //algorytm zaczyna od 3 bo szukamy nieparzystych
  for (int j = 3; liczba != 1;) {
    if(liczba % j == 0) {
      if(!czynniki.contains(j)) {
        czynniki.add(j);
        if(czynniki.size() > 3) break;
      }
      liczba = liczba / j;
    }
    else j+=2;
  }
  if(czynniki.size() == 3) count++;
}
System.out.println(count);
