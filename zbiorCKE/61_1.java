ArrayList<String> lista = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\61\\ciagi.txt"));

int roznicaCiagu = 0;
int roznicaWyrazow = 0;
int count = 0;
for (int i = 1; i < lista.size(); i+=2) {
  String[] liczby = lista.get(i).split(" ");
  int roznica = Integer.parseInt(liczby[1]) - Integer.parseInt(liczby[0]);
  boolean test = true;
  for (int j = 1; j < liczby.length-1; j++) {
    if(Integer.parseInt(liczby[j+1])-Integer.parseInt(liczby[j]) != roznica) {
      test = false;
    }
  }
  if(test) {
    count++;
    if(roznicaWyrazow < Integer.parseInt(liczby[liczby.length-1])-Integer.parseInt(liczby[0])) {
      roznicaWyrazow = Integer.parseInt(liczby[liczby.length-1])-Integer.parseInt(liczby[0]);
      roznicaCiagu = roznica;
    }
  }
}
System.out.println(count);
System.out.println(roznicaCiagu);
