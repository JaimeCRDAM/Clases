from Enums.EInterfaces import IDinos


class Triceratops(IDinos.IDino.value):
    def __init__(self, lista_dinos, lista_localizaciones):
        IDinos.IDino.value.__init__(self, lista_dinos, lista_localizaciones)

    @property
    def probabilidad(self) -> int:
        return 0


    
