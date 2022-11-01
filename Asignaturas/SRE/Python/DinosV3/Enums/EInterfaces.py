from enum import *


class IDinos(Enum):
    from Interfaces.IDino import IDino
    from Interfaces.ICarnivoro import ICarnivoros
    Normal = IDino
    Carnivoro = ICarnivoros
