

img = []

#fname = "../Dane_PR2/przyklad.txt"
fname = "../Dane_PR2/dane.txt"
f = open(fname)
for l in f.read().splitlines():
	intmap = map(int, l.split())
	img.append(list(intmap))

pxmin = 255
pxmax = 0
for row in img:
	for px in row:
		pxmin = min(pxmin, px)
		pxmax = max(pxmax, px)
print("6.1:")
print("pxmin", pxmin)
print("pxmax", pxmax)

do_usuniecia = 0
for row in img:
	for i in range(320//2):
		if row[i] != row[-(i+1)]:
			do_usuniecia += 1
			break #zapomniałeś 
print("6.2:")
print(do_usuniecia)

l_kont = 0
for i in range(len(img)):
	for j in range(len(img[i])):
		if i > 0 and abs(img[i-1][j] - img[i][j]) > 128:
			l_kont += 1
			continue
		if i < len(img) - 1 and abs(img[i+1][j] - img[i][j]) > 128:
			l_kont += 1
			continue
		if j > 0 and abs(img[i][j-1] - img[i][j]) > 128:
			l_kont += 1
			continue
		if j < len(img[i]) - 1 and abs(img[i][j+1] - img[i][j]) > 128:
			l_kont += 1
			continue
print("6.3:")
print(l_kont)

mslen = 0
for i in range(len(img[0])):
	slen = 1
	for j in range(1, len(img)):
		if img[j][i] == img[j-1][i]:
			slen += 1
		else:
			mslen = max(mslen, slen)
			slen = 1
	mslen = max(mslen, slen)
print("6.4:")
print(mslen)
				

