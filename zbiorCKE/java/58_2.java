ArrayList<String> lista1 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy1.txt"));
ArrayList<String> lista2 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy2.txt"));
ArrayList<String> lista3 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy3.txt"));

int errorCount = 0;
int godzina = 12;
for (int i = 0; i < lista1.size(); i++) {
  int l1 = Integer.parseInt(lista1.get(i).split(" ")[0],2);
  int l2 = Integer.parseInt(lista2.get(i).split(" ")[0],4);
  int l3 = Integer.parseInt(lista3.get(i).split(" ")[0],8);

  if(l1 != godzina && l2 != godzina && l3 != godzina) {
    errorCount++;
  }
  godzina += 24;
}
System.out.println(errorCount);
