import random
from Models.Enum import Dinos
from Interfaces.IDino import IDino
from Interfaces.ICarnivoro import ICarnivoros

listaDinos: list[IDino | ICarnivoros] = []
localizacion: list[list[IDino | None]] = [[None] * 10 for i in [1] * 10]


def iniciarLocalizaciones(localizacion: list[list[IDino | None]]):
    for i in [Dinos.SpinoFactory, Dinos.TriceFactory, Dinos.TyraFactory]:
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


def dinoMueve(localizacion: list[list[IDino | None]]):
    dino_a_mover = listaDinos[random.randint(0, len(listaDinos) - 1)]
    x = random.randint(0, 9)
    y = random.randint(0, 9)
    while localizacion[x][y] is not None:
        x = random.randint(0, 9)
        y = random.randint(0, 9)
        dino_a_mover.mover((x, y), localizacion)
        return
    dino_a_mover.mover((x, y), localizacion)


def dinoCome():
    dino_a_comer = listaDinos[random.randint(0, len(listaDinos) - 1)]
    dino_a_comer.comer()


def dinoAtaca():
    dino_que_ataca = listaDinos[random.randint(0, len(listaDinos) - 1)]
    dino_a_atacar = listaDinos[random.randint(0, len(listaDinos) - 1)]
    hereda = type(dino_que_ataca).mro()

    while ICarnivoros not in hereda:
        dino_que_ataca = listaDinos[random.randint(0, len(listaDinos) - 1)]
        hereda = type(dino_que_ataca).mro()
    while dino_que_ataca == dino_a_atacar:
        dino_a_atacar = listaDinos[random.randint(0, len(listaDinos) - 1)]
    dino_que_ataca.atacar(dino_a_atacar)


def main():
    iniciarLocalizaciones(localizacion)
    dinoAtaca()


if __name__ == '__main__':
    main()
