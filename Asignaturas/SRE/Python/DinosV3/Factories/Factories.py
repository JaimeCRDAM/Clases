from Models.Spinosaurus import Spinosaurus
from Models.Triceratops import Triceratops
from Models.Tyrannosaurus_Rex import Tyranosaurus
from Models.Enum import EstatusSocial


def SpinoFactory(lista_dinos, lista_localizaciones) -> Spinosaurus:
    dino = Spinosaurus(lista_dinos, lista_localizaciones)
    dino.velocidad = 2
    dino.EstatusSocial = EstatusSocial.Solitario
    return dino


def TriceFactory(lista_dinos, lista_localizaciones) -> Triceratops:
    dino = Triceratops(lista_dinos, lista_localizaciones)
    dino.velocidad = 5
    dino.EstatusSocial = EstatusSocial.Manada
    return dino


def TyraFactory(lista_dinos, lista_localizaciones) -> Tyranosaurus:
    dino = Tyranosaurus(lista_dinos, lista_localizaciones)
    dino.velocidad = 1
    dino.EstatusSocial = EstatusSocial.Solitario
    return dino
