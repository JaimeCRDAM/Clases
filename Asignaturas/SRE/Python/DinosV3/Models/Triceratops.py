from Interfaces.IDino import IDino
from abc import *


class Triceratops(IDino):
    def __init__(self, lista_dinos, lista_localizaciones):
        IDino.__init__(self, lista_dinos, lista_localizaciones)


    
