from Interfaces import IDino
from abc import *


class Triceratops(IDino.IDino, ABC):
    def __init__(self):
        super().__init__()
        self.velocidad = 5
    
