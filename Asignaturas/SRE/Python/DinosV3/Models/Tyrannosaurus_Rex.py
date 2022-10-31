from abc import *
from Interfaces.IDino import IDino
from Interfaces.ICarnivoro import ICarnivoros


class Tyranosaurus(IDino, ICarnivoros, ABC):
    def __init__(self):
        super(Tyranosaurus, self).__init__()
        self.velocidad = 1
        self.probabilidad = 60

