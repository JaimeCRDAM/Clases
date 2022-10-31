from abc import *
from math import *
from Models.Enum import EstatusSocial


class ADinos(ABC):
    def __init__(self):
        self._energia = None
        self._posicion = None
        self._velocidad = 0
        self._EstatusSocial: EstatusSocial = EstatusSocial.Nada

    @property
    def energia(self) -> int:
        return self._energia

    @property
    def velocidad(self) -> int:
        return self._velocidad

    @velocidad.setter
    def velocidad(self, velocidad: int):
        self._velocidad = velocidad

    def comer(self):
        self.energia += 100

    @energia.setter
    def energia(self, value):
        self._energia += value

    @property
    def posicion(self) -> tuple[int, int]:
        return self._posicion

    @posicion.setter
    def posicion(self, pos: tuple[int, int]):
        self._posicion = pos

    @property
    def EstatusSocial(self) -> EstatusSocial:
        return self._EstatusSocial

    @EstatusSocial.setter
    def EstatusSocial(self, estatus: EstatusSocial):
        self._EstatusSocial = estatus

    def Distancia(self, posicion: tuple):
        mx, my = self.posicion
        hx, hy = posicion
        return sqrt(pow(hx - mx, 2) + pow(hy - my, 2))
