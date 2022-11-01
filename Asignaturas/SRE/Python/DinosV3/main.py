import random
import time

from Enums.EInterfaces import IDinos
from Enums.EFactories import DinosFactory
import threading

listaDinos: list[IDinos.IDino.value | IDinos.ICarnivoros.value] = []
localizacion: list[list[IDinos.IDino.value | None]] = [[None] * 10 for i in [1] * 10]


def iniciarLocalizaciones(localizacion: list[list[IDinos.IDino.value | None]]):
    for i in [DinosFactory.Spino, DinosFactory.TriceFactory, DinosFactory.TyraFactory]:
        for j in range(10):
            x = random.randint(0, 9)
            y = random.randint(0, 9)
            if localizacion[x][y] is None:
                localizacion[x][y] = i(listaDinos, localizacion)
                localizacion[x][y].posicion = (x, y)
                listaDinos.append(localizacion[x][y])
            else:
                while localizacion[x][y] is not None:
                    x = random.randint(0, 9)
                    y = random.randint(0, 9)
                localizacion[x][y] = i(listaDinos, localizacion)
                localizacion[x][y].posicion = (x, y)
                listaDinos.append(localizacion[x][y])


def main():
    iniciarLocalizaciones(localizacion)
    counter = len(listaDinos) * (2 / 3)
    while counter > 0:
        for dino in listaDinos:
            probablidad = dino.probabilidad
            resto_probabilidad = (100 - probablidad) / 2
            aleatorio = random.randint(0, 100)
            if aleatorio < resto_probabilidad:
                dino.comer()
            if resto_probabilidad > aleatorio < resto_probabilidad * 2:
                dino.moverse()
            if aleatorio > resto_probabilidad * 2:
                dino.ataque()
        for dino in listaDinos:
            parents = type(dino).mro()
            if IDinos.ICarnivoros.value in parents:
                counter -= 1
        time.sleep(1000)


if __name__ == '__main__':
    main()
