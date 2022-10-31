import random
from Models.Enum import Dinos
from Interfaces.IDino import IDino

listaDinos: list[IDino] = []


def iniciarLocalizaciones(localizacion: list[list[IDino | None]]):
    for i in list(Dinos):
        for j in range(10):
            x = random.randint(0, 9)
            y = random.randint(0, 9)
            if localizacion[x][y] is None:
                localizacion[x][y] = i
                localizacion[x][y].posicion = (x, y)
                listaDinos.append(i)
            else:
                while localizacion[x][y] is not None:
                    x = random.randint(0, 9)
                    y = random.randint(0, 9)
                localizacion[x][y] = i
                localizacion[x][y].posicion = (x, y)
                listaDinos.append(i)


def dinoMueve(localizacion: list[list[IDino | None]]):
    dino_a_mover = listaDinos[random.randint(0, len(listaDinos))]
    x = random.randint(0, 9)
    y = random.randint(0, 9)
    while localizacion[x][y] is not None:
        x = random.randint(0, 9)
        y = random.randint(0, 9)
        dino_a_mover.mover((x, y), localizacion)
        return
    dino_a_mover.mover((x, y), localizacion)


def dinoCome():
    dino_a_comer = listaDinos[random.randint(0, len(listaDinos))]
    dino_a_comer.comer()

def dinoAtaca():
    dino_a_atacar = listaDinos[random.randint(0, len(listaDinos))]


def main():
    localizacion: list[list[IDino | None]] = [[None] * 10 for i in [1] * 10]
    iniciarLocalizaciones(localizacion)
    print(localizacion)


if __name__ == '__main__':
    main()
