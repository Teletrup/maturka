ArrayList<String> lista = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\maturaZbior\\dane\\59\\liczby.txt"));


int min = -1;
int max = -1;
int[] moce = {0,0,0,0,0,0,0,0};

for (int i = 0; i < lista.size(); i++) {

int moc = 0;
String liczba = lista.get(i);
while(liczba.length() > 1) {
  int nowaLiczba = 1;
  for (int j = 0; j < liczba.length(); j++) {
    nowaLiczba *= Integer.parseInt(liczba.substring(j,j+1));
  }
  liczba = String.valueOf(nowaLiczba);
  moc++;
  if(moc > 8) {
    liczba = " ";
  }
}
moce[moc-1]++;
if(moc == 1) {
  if(min == -1 || min > Integer.parseInt(lista.get(i))) {
    min = Integer.parseInt(lista.get(i));
  }
  if(max == -1 || max < Integer.parseInt(lista.get(i))) {
    max = Integer.parseInt(lista.get(i));
  }
}		
}
System.out.println(moce[0]);
System.out.println(moce[1]);
System.out.println(moce[2]);
System.out.println(moce[3]);
System.out.println(moce[4]);
System.out.println(moce[5]);
System.out.println(moce[6]);
System.out.println(moce[7]);
System.out.println("min:"+min+" max:"+max);
