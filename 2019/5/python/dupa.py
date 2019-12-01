f = open("pogoda.txt", "r")
lines = f.read().replace(",", ".").splitlines()
dni = []
for l in lines:
	dni.append(l.split(';'))
f.close()

odp = ''

odp += "5.1:\n"
l_dni = 0
for d in dni[1:]:
	if float(d[1]) >= 20 and int(d[2]) <= 5:
		l_dni += 1
odp += str(l_dni) + "\n\n"

odp += "5.2:\n"
first = 0
first_best = 0
last_best = 0
dlug_best = 0
inseries = False
for i in range(2, len(dni)):
	if float(dni[i][1]) > float(dni[i - 1][1]):
		if not inseries:
			inseries = True
			first = i
	elif inseries:
		inseries = False
		last = i - 1
		dlug = last - first + 1
		if dlug > dlug_best:
			dlug_best = dlug
			first_best = first
			last_best = last
odp += str(first_best) + " " + str(last_best) + "\n\n"

odp += "5.3:\n"
sumy_kat = {
"C1":0, "C2":0, "C3":0, "C4":0, "C5":0,
"S1":0, "S2":0, "S3":0, "S4":0, "S5":0
}
l_dni_kat = {
"C1":0, "C2":0, "C3":0, "C4":0, "C5":0,
"S1":0, "S2":0, "S3":0, "S4":0, "S5":0
}
for d in dni[1:301]:
	chmury = d[3] + d[4]
	if chmury != "00":
		sumy_kat[chmury] += int(d[2])
		l_dni_kat[chmury] += 1
for key in sorted(sumy_kat):
	odp += str(key) + " " +  str(round(sumy_kat[key] / l_dni_kat[key], 2)) + "\n"
odp += "\n"

odp += "5.3:\n"
l_dni_wiel = (0, 0, 0, 0, 0, 0)
for d in dni
	print(l_dni_wiel)


f = open("wyniki5.txt", "w")
f.write(odp)
f.close()
	
