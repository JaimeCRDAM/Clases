from abc import *
from Interfaces.IDino import IDino
from Interfaces.ICarnivoro import ICarnivoros


class Tyranosaurus(IDino, ICarnivoros):
    def __init__(self, lista_dinos, lista_localizaciones):
        IDino.__init__(self, lista_dinos, lista_localizaciones)
        ICarnivoros.__init__(self, lista_dinos, lista_localizaciones)


