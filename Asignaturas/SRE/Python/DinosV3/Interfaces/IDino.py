from abc import ABC
from Abstracts.ADinos import ADinos
import random
from Enums.EGeneral import Posibilidades, EstatusSocial


class IDino(ADinos, ABC):
    def __init__(self, lista_dinos: list, lista_localizaciones):
        super().__init__(lista_dinos, lista_localizaciones)
        self.lista_localizaciones = lista_localizaciones
        self.lista_dinos = lista_dinos

    def atacado(self) -> Posibilidades:
        if self.EstatusSocial == EstatusSocial.Manada:
            morir: bool = random.random() > 0.8
            if morir:
                return Posibilidades.Morir
            return Posibilidades.Sobrevivir
        if self.EstatusSocial == EstatusSocial.Solitario:
            morir: bool = random.random() > 0.5
            if morir:
                return Posibilidades.Morir
            return Posibilidades.Sobrevivir

    def calcenergia(self, newpos: tuple) -> int:
        return int(self.Distancia(newpos) * self.velocidad)

    def mover(self, pos: tuple, lista: list[list['IDino | None']]):
        nx, ny = pos
        ox, oy = self.posicion
        lista[ox][oy] = None
        lista[nx][ny] = self
        self.energia = -self.calcenergia(pos)

    def comer(self):
        self.energia = 100

    def moverse(self):
        x = random.randint(0, 9)
        y = random.randint(0, 9)
        while self.lista_localizaciones[x][y] is not None:
            x = random.randint(0, 9)
            y = random.randint(0, 9)
            self.mover((x, y), self.lista_localizaciones)
            return
        self.mover((x, y), self.lista_localizaciones)
