import static org.junit.jupiter.api.Assertions.*;

import org.example.model.entity.Aposta;
import org.example.service.LoteriaService;
import org.junit.jupiter.api.Test;

import java.util.*;

class LoteriaTest {
    LoteriaService service = new LoteriaService();
    Set<Integer> sorteioFixo = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50, 60));

    @Test
    void devePagarSena_CemPorCento() {
        Aposta aposta = new Aposta(new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50, 60)), 1000.0);
        assertEquals(1000.0, service.calcularPremio(aposta, sorteioFixo));
    }

    @Test
    void devePagarQuina_VintePorCento() {
        Aposta aposta = new Aposta(new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50, 1)), 1000.0);
        assertEquals(200.0, service.calcularPremio(aposta, sorteioFixo));
    }

    @Test
    void devePagarQuadra_CincoPorCento() {
        Aposta aposta = new Aposta(new TreeSet<>(Arrays.asList(10, 20, 30, 40, 01, 02)), 1000.0);
        assertEquals(50.0, service.calcularPremio(aposta, sorteioFixo));
    }

    @Test
    void deveFiltrarNumerosInvalidos() {
        List<Integer> sujos = Arrays.asList(-5, 0, 1, 60, 61, 1);
        Set<Integer> limpos = service.filtrarNumerosValidos(sujos);

        assertEquals(2, limpos.size());
        assertTrue(limpos.contains(1) && limpos.contains(60));
    }

    @Test
    void deveGerarSorteioComSeisNumerosUnicos() {
        Set<Integer> sorteio = service.realizarSorteio();

        assertEquals(6, sorteio.size());
        assertTrue(sorteio.stream().allMatch(n -> n >= 1 && n <= 60));
    }
}