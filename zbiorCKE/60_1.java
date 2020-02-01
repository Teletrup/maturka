ArrayList<String> lista = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\60\\liczby.txt"));
		
int pierwsza = 0;
int druga = 0;
int count = 0;
for (int i = 0; i < lista.size(); i++) {
  if(Integer.parseInt(lista.get(i)) < 1000) {
    druga = pierwsza;
    pierwsza = Integer.parseInt(lista.get(i));
    count++;
  }
}
System.out.println(pierwsza);
System.out.println(druga);
System.out.println(count);
