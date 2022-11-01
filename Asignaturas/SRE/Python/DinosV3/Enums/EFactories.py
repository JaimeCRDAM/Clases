from enum import *


class DinosFactory(Enum):
    from Factories.Factories import SpinoFactory
    from Factories.Factories import TyraFactory
    from Factories.Factories import TriceFactory
    Spino = SpinoFactory
    Trice = TriceFactory
    Tyra = TyraFactory
