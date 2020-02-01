ArrayList<String> lista1 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy1.txt"));
ArrayList<String> lista2 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy2.txt"));
ArrayList<String> lista3 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy3.txt"));

int skok = 0;
for (int i = 0; i < lista1.size() - 1; i++) {
  for (int j = 1; j < lista1.size(); j++) {
    int a = Integer.parseInt(lista1.get(i).split(" ")[1],2);
    int b = Integer.parseInt(lista1.get(j).split(" ")[1],2);
    int c = (int) Math.ceil(Math.pow(Math.abs(a-b), 2)/Math.abs((i+1)-(j+1)));
    if(c > skok) {
      skok = c;
    }
  }
}
System.out.println(skok);
