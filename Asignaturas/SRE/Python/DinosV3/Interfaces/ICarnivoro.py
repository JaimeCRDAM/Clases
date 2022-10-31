from abc import ABC
from Abstracts.ADinos import ADinos
from Models.Enum import Posibilidades
from Interfaces.IDino import IDino
from random import random


class ICarnivoros(ADinos, ABC):
    def __init__(self, lista_dinos: list, lista_localizaciones):
        super().__init__(lista_dinos, lista_localizaciones)
        self.lista_localizaciones = lista_localizaciones
        self.lista_dinos = lista_dinos
        self.probabilidad = 0

    def atacar(self, dino: IDino) -> Posibilidades:

        if self.energia < 20:
            return Posibilidades.Nada
        if self.energia < (20 + self.Distancia(dino.posicion) * self.velocidad):
            return Posibilidades.Nada
        resultado_ataque = dino.atacado()
        match resultado_ataque:
            case Posibilidades.Morir:
                pass
            case Posibilidades.Sobrevivir:
                self.lista_dinos.remove(self)
                x, y = self.posicion
                self.lista_localizaciones[x][y] = None

