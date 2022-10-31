from abc import *
from Interfaces.IDino import IDino
from Interfaces.ICarnivoro import ICarnivoros


class Spinosaurus(IDino, ICarnivoros, ABC):
    def __init__(self):
        super(Spinosaurus, self).__init__()
        self.velocidad = 2
        self.probabilidad = 30

