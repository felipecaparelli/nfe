package com.fincatto.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.nota.NFNotaInfoReboque;

public class NFNotaInfoReboqueTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPlacaVeiculoInvalido() {
        try {
            new NFNotaInfoReboque().setPlacaVeiculo("");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoReboque().setPlacaVeiculo("MKZY0123");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUFNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
        reboque.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPlacaNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");
        reboque.toString();
    }

    @Test
    public void devePermitirRegistroNacionaltransportadorCargaNulo() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComRNTC() {
        final NFNotaInfoReboque reboque = new NFNotaInfoReboque();
        reboque.setPlacaVeiculo("MKZ4891");
        reboque.setUf(NFUnidadeFederativa.SC);
        reboque.setRegistroNacionalTransportadorCarga("8fFAKefiBQIDTkCCSQk3");

        final String xmlEsperado = "<NFNotaInfoReboque><placa>MKZ4891</placa><UF>SC</UF><RNTC>8fFAKefiBQIDTkCCSQk3</RNTC></NFNotaInfoReboque>";
        Assert.assertEquals(xmlEsperado, reboque.toString());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecidoComVagao() {
        final String xmlEsperado = "<NFNotaInfoReboque><placa>MKZ4891</placa><UF>SC</UF></NFNotaInfoReboque>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoReboque().toString());
    }
}