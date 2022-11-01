from enum import *


class Dinos(Enum):
    from Models.Triceratops import Triceratops
    from Models.Tyrannosaurus_Rex import Tyranosaurus
    from Models.Spinosaurus import Spinosaurus
    Trice = Triceratops
    Tyra = Tyranosaurus
    Spino = Spinosaurus
