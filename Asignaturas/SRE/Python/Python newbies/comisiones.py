texto: str = input("Dame un texto\n")
letras: list = []

for i in range(3):
    letra = input("Dame una letra\n")
    letras.append(letra)

for i in range(3):
    print("La letra " + letras[i] + " aparece " + str(texto.count(letras[i])) + " veces")

print("Cantidad de palabras " + str(len(texto.split(" "))))

print("La primera palabra es" + texto.split(" ")[0])

print("La ultima palabra es" + texto.split(" ")[-1])

print("El texto en inverso es " + texto[::-1])

dictionario: dict = {"Python": texto.find("Python") > 0}

print("Aparece la palabra Python? " + str(dictionario))
