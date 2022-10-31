def pos_letra(letrap):
    return palabraAdivinar.find(letrap)


def nuevo_string(palabraAdivinar, letra, palabraSecreta):
    palabra_nueva = ''
    for i, character in enumerate(palabraAdivinar):
        if character == letra:
            palabra_nueva += letra
        elif palabraSecreta[i] != '-':
            palabra_nueva += palabraSecreta[i]
        else:
            palabra_nueva += '-'
    return palabra_nueva


palabraAdivinar = "patata"
palabraSecreta = ''
vidas = 6
for i in range(len(palabraAdivinar)):
    palabraSecreta += '-'

while '-' in palabraSecreta and vidas > 0:
    print(palabraSecreta)
    letra = input("Dime una letra: ")
    if pos_letra(letra) != -1:
        palabraSecreta = nuevo_string(palabraAdivinar, letra, palabraSecreta)

if '-' not in palabraSecreta and vidas > 0:
    print("Ganaste!")
else:
    print("Perdiste")
