from enum import *


class EstatusSocial(Enum):
    Solitario = 1
    Manada = 2
    Nada = 3


class Posibilidades(Enum):
    Sobrevivir = 1
    Morir = 2
    Nada = 3


from .Tyrannosaurus_Rex import Tyranosaurus
from .Spinosaurus import Spinosaurus
from .Triceratops import Triceratops


class Dinos(Enum):
    Spino: Spinosaurus = Spinosaurus()
    Trice: Triceratops = Triceratops()
    Tyra: Tyranosaurus = Tyranosaurus()
