ArrayList<String> lista1 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy1.txt"));
ArrayList<String> lista2 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy2.txt"));
ArrayList<String> lista3 = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\58\\dane_systemy3.txt"));

int min = 999;
for (int i = 0; i < lista1.size(); i++) {
  if(min > Integer.parseInt(lista1.get(i).split(" ")[1],2)) {
    min = Integer.parseInt(lista1.get(i).split(" ")[1],2);
  }
}
if(min < 0) {

  System.out.println("-"+Integer.toBinaryString(min*-1));
}
else {
  System.out.println(Integer.toBinaryString(min));
}

min = 999;
for (int i = 0; i < lista2.size(); i++) {
  if(min > Integer.parseInt(lista2.get(i).split(" ")[1],4)) {
    min = Integer.parseInt(lista2.get(i).split(" ")[1],4);
  }
}
if(min < 0) {
  System.out.println("-"+Integer.toBinaryString(min*-1));
}
else {
  System.out.println(Integer.toBinaryString(min));
}
min = 999;
for (int i = 0; i < lista3.size(); i++) {
  if(min > Integer.parseInt(lista3.get(i).split(" ")[1],8)) {
    min = Integer.parseInt(lista3.get(i).split(" ")[1],8);
  }
}
if(min < 0) {
  System.out.println("-"+Integer.toBinaryString(min*-1));
}
else {
  System.out.println(Integer.toBinaryString(min));
}
