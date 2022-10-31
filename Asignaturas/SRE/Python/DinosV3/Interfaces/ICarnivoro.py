from abc import ABC
from Abstracts.ADinos import ADinos
from Models.Enum import Posibilidades, EstatusSocial
from random import random


class ICarnivoros(ADinos, ABC):
    def __init__(self):
        super().__init__()
        self.probabilidad = 0

    def atacar(self, dino: ADinos) -> Posibilidades:
        if self.energia < 20:
            return Posibilidades.Nada
        if self.energia < (20 + self.Distancia(dino.posicion)*self.velocidad):
            return Posibilidades.Nada
        if dino.EstatusSocial == EstatusSocial.Manada:
            morir: bool = random()<0.2
            if morir:
                return Posibilidades.Morir
            return Posibilidades.Sobrevivir
        if dino.EstatusSocial == EstatusSocial.Solitario:
            morir: bool = random()<0.5
            if morir:
                return Posibilidades.Morir
            return Posibilidades.Sobrevivir
