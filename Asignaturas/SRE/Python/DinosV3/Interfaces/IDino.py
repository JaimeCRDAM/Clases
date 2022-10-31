from abc import ABC
from Abstracts.ADinos import ADinos
from Models import Enum
from random import random


class IDino(ADinos, ABC):
    def __init__(self):
        super().__init__()

    def atacado(self) -> Enum.Posibilidades:
        if self.EstatusSocial == Enum.EstatusSocial.Manada:
            morir: bool = random() > 0.8
            if morir:
                return Enum.Posibilidades.Morir
            return Enum.Posibilidades.Sobrevivir
        if self.EstatusSocial == Enum.EstatusSocial.Solitario:
            morir: bool = random() > 0.5
            if morir:
                return Enum.Posibilidades.Morir
            return Enum.Posibilidades.Sobrevivir

    def calcenergia(self, newpos: tuple) -> int:
        return int(self.Distancia(newpos) * self.velocidad)

    def mover(self, pos: tuple, lista: list[list['IDino | None']]):
        nx, ny = pos
        ox, oy = self.posicion
        lista[ox][oy] = None
        lista[nx][ny] = self
        self.energia -= self.calcenergia(pos)
