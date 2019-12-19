f = open("dane.txt")
dane = f.read().splitlines()
f.close()

f = open("cennik.txt")
cennik = f.read().replace(',', '.').splitlines()
f.close

ceny = {}
for l in cennik:
  ws = l.split()
  ceny[ws[0]] = float(ws[1])

przych = 0

for l in dane:
  ws = l.split()
  rok = ws[0][:4]
  przych += ceny[rok] * float(ws[2])
print(przych)
