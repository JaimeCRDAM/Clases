from enum import *


class EstatusSocial(Enum):
    Solitario = 1
    Manada = 2
    Nada = 3


class Posibilidades(Enum):
    Sobrevivir = 1
    Morir = 2
    Nada = 3


class Dinos(Enum):
    from Factories.Factories import SpinoFactory
    from Factories.Factories import TyraFactory
    from Factories.Factories import TriceFactory
    from Models.Spinosaurus import Spinosaurus
    from Models.Triceratops import Triceratops
    from Models.Tyrannosaurus_Rex import Tyranosaurus
    Spino: Spinosaurus = SpinoFactory
    Trice: TriceFactory = Triceratops
    Tyra: TyraFactory = Tyranosaurus
