package com.fincatto.nfe200.classes;

public enum NFNotaMotivoDesoneracaoICMS {
    TAXI("1"),
    DEFICIENTE_FISICO("2"),
    PRODUTOR_AGROPECUARIO("3"),
    FROTISTA_LOCADORA("4"),
    DIPLOMATICO_CONSULAR("5"),
    UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO("6"),
    SUFRAMA("7"),
    VENDA_ORGAOS_PUBLICOS("8"),
    OUTROS("9");

    private final String codigo;

    private NFNotaMotivoDesoneracaoICMS(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaMotivoDesoneracaoICMS valueOfCodigo(final String codigo) {
        for (final NFNotaMotivoDesoneracaoICMS motivoDesonaracao : NFNotaMotivoDesoneracaoICMS.values()) {
            if (motivoDesonaracao.getCodigo().equals(codigo)) {
                return motivoDesonaracao;
            }
        }
        return null;
    }
}