package org.example.entities;

public enum UnidadeMedida {

    UNIDADE("UN"),
    QUILOGRAMA("KG"),
    GRAMA("G"),
    LITRO("L"),
    MILILITRO("ML"),
    METRO("M"),
    CENTIMETRO("CM"),
    MILIMETRO("MM"),
    METRO_QUADRADO("M2"),
    METRO_CUBICO("M3"),
    CAIXA("CX"),
    PACOTE("PCT"),
    FARDO("FD"),
    DUZIA("DZ"),
    PAR("PAR");

    private final String sigla;

    UnidadeMedida(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    public static UnidadeMedida getEnum(String sigla){
        UnidadeMedida[] enums = UnidadeMedida.values();

        UnidadeMedida enumEncontrada = null;

        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getSigla().equals(sigla)){
                enumEncontrada = enums[i];
            }
        }

        return enumEncontrada;
    }
}

