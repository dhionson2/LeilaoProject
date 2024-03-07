package leilao.service.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.service.EnviadorDeEmails;

public class EnviadorDeEmailsTest {

    @Mock
    private Leilao leilao;

    @Mock
    private Lance lance;

    @Mock
    private Usuario usuario;

    @Mock
    private EnviadorDeEmails enviadorDeEmails;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveEnviarEmailAoVencedorDoLeilao() {
        // Configuração do mock
        when(lance.getUsuario()).thenReturn(usuario);
        when(lance.getLeilao()).thenReturn(leilao);
        when(leilao.getNome()).thenReturn("Leilao de Teste");
        when(usuario.getNome()).thenReturn("Fulano");
        when(lance.getValor()).thenReturn(BigDecimal.valueOf(100.0));

        // Chamada do método a ser testado
        enviadorDeEmails.enviarEmailVencedorLeilao(lance);

        // Verificação se o método de envio de email foi chamado com os parâmetros esperados
        verify(enviadorDeEmails, times(1)).enviarEmailVencedorLeilao(lance);
    }
}
