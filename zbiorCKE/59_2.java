ArrayList<String> lista = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\59\\liczby.txt"));

int count = 0;

for (int i = 0; i < lista.size(); i++) {

  int liczba = Integer.parseInt(lista.get(i));
  String odwrocenie = "";
  for (int j = lista.get(i).length() - 1; j >= 0; j--) {
    odwrocenie = odwrocenie + lista.get(i).substring(j,j+1);
  }
  int palindrom = liczba + Integer.parseInt(odwrocenie);

  boolean pal = true;
  for (int j = 0; j < String.valueOf(palindrom).length()/2; j++) {
    if(!String.valueOf(palindrom).substring(j,j+1).equals(String.valueOf(palindrom).substring(String.valueOf(palindrom).length() - 1 - j,String.valueOf(palindrom).length() - j))) pal = false;
  }
  if(pal) count++;	
}
System.out.println(count);
