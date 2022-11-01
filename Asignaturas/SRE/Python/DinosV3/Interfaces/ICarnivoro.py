from abc import ABC
from Abstracts.ADinos import ADinos
from Enums.EGeneral import Posibilidades
from Interfaces.IDino import IDino
import random


class ICarnivoros(ADinos, ABC):
    def __init__(self, lista_dinos: list, lista_localizaciones):
        super().__init__(lista_dinos, lista_localizaciones)
        self.lista_localizaciones = lista_localizaciones
        self.lista_dinos = lista_dinos

    def atacar(self, dino: IDino) -> Posibilidades:
        if self.energia < 20:
            return Posibilidades.Nada
        if self.energia < (20 + self.Distancia(dino.posicion) * self.velocidad):
            return Posibilidades.Nada
        resultado_ataque = dino.atacado()
        match resultado_ataque:
            case Posibilidades.Morir:
                self.remove_dino(dino)
            case Posibilidades.Sobrevivir:
                self.remove_dino(self)

    def ataque(self):
        dino_que_ataca = self
        dino_a_atacar = self.lista_dinos[random.randint(0, len(self.lista_dinos) - 1)]
        while dino_que_ataca == dino_a_atacar:
            dino_a_atacar = self.lista_dinos[random.randint(0, len(self.lista_dinos) - 1)]
        dino_que_ataca.atacar(dino_a_atacar)

    def remove_dino(self, dino: 'IDino | ICarnivoros'):
        self.lista_dinos.remove(dino)
        x, y = dino.posicion
        self.lista_localizaciones[x][y] = None
