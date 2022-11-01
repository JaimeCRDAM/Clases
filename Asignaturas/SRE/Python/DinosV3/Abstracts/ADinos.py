from abc import *
from math import *
from Enums.EGeneral import EstatusSocial


class ADinos(ABC):
    def __init__(self, lista_dinos: list, lista_localizaciones):
        self._velocidad = None
        self._energia = 100
        self._posicion = None
        self._EstatusSocial: EstatusSocial = EstatusSocial.Nada

    @property
    def energia(self) -> int:
        return self._energia

    @property
    def velocidad(self):
        return self._velocidad

    @velocidad.setter
    def velocidad(self, velocidad: int):
        self._velocidad = velocidad

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

    @property
    @abstractmethod
    def probabilidad(self) -> int:
        pass

