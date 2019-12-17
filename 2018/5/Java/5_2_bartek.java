ArrayList<String> linie = (ArrayList<String>)Files.readAllLines(Paths.get("C:\\Users\\czorek\\Desktop\\matura 2018\\Dane_PR2\\woda.txt"));
		
int okresNaj = 0;
String dataStart = "";
String dataEnd = "";
int okres = 0;
for (int i = 0; i < linie.size(); i++) {
  if(Integer.parseInt(linie.get(i).split("\t")[1])>=10000) {
    okres++;
  }
  else {
    if(okres > okresNaj) {
      okresNaj = okres;
      dataEnd = linie.get(i-1);
      dataStart = linie.get(i-okresNaj);
    }
    okres = 0;
  }
}

System.out.println(dataStart.split("\t")[0]);
System.out.println(dataEnd.split("\t")[0]);
