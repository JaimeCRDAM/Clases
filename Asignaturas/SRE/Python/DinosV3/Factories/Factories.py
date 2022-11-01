from Enums.EGeneral import EstatusSocial
from Enums.EDinos import Dinos


def SpinoFactory(lista_dinos, lista_localizaciones) -> Dinos.Spinosaurus:
    dino = Dinos.Spinosaurus.value(lista_dinos, lista_localizaciones)
    dino.velocidad = 2
    dino.EstatusSocial = EstatusSocial.Solitario
    return dino


def TriceFactory(lista_dinos, lista_localizaciones) -> Dinos.Triceratops:
    dino = Dinos.Triceratops.value(lista_dinos, lista_localizaciones)
    dino.velocidad = 5
    dino.EstatusSocial = EstatusSocial.Manada
    return dino


def TyraFactory(lista_dinos, lista_localizaciones) -> Dinos.Tyranosaurus:
    dino = Dinos.Tyranosaurus.value(lista_dinos, lista_localizaciones)
    dino.velocidad = 1
    dino.EstatusSocial = EstatusSocial.Solitario
    return dino
