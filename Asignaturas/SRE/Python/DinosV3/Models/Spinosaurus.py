from Enums.EInterfaces import IDinos


class Spinosaurus(IDinos.IDino.value, IDinos.ICarnivoros.value):
    def __init__(self, lista_dinos, lista_localizaciones):
        IDinos.IDino.value.__init__(self, lista_dinos, lista_localizaciones)
        IDinos.ICarnivoros.value.__init__(self, lista_dinos, lista_localizaciones)

    @property
    def probabilidad(self) -> int:
        return 30
