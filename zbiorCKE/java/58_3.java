ArrayList<String> lista1 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy1.txt"));
ArrayList<String> lista2 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy2.txt"));
ArrayList<String> lista3 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy3.txt"));

int dniRekordowe = 0;
int s1R = 0;
int s2R = 0;
int s3R = 0;
for (int i = 0; i < lista1.size(); i++) {
  int l1 = Integer.parseInt(lista1.get(i).split(" ")[1],2);
  int l2 = Integer.parseInt(lista2.get(i).split(" ")[1],4);
  int l3 = Integer.parseInt(lista3.get(i).split(" ")[1],8);
  if(l1 > s1R || l2 > s2R || l3 > s3R) {
    dniRekordowe++;
    if(l1 > s1R) {
      s1R = l1;
    }
    if(l2 > s2R) {
      s2R = l2;
    }
    if(l3 > s3R) {
      s3R = l3;
    }
  }
}
System.out.println(dniRekordowe);
