package br.com.devmedia.components.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.devmedia.components.entity.EntidadeTeste;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class EntidadeTesteServiceTest {

	@Autowired
	private EntidadeTesteService service;

	@Test
	public void testaSalvarNovo() {
		EntidadeTeste entidade = new EntidadeTeste();
		entidade.setNome("Criado pelo JUnit");

		service.save(entidade);
		assertNotNull(entidade.getId());
	}

	@Test
	public void testaBuscarPeloId() {
		EntidadeTeste entidade = service.getById(new Long(2));
		assertEquals(entidade.getId(), new Long(2));
	}

	@Test
	public void testaExcluir() {
		service.delete(new Long(1));

		EntidadeTeste entidade = null;
		try {
			entidade = service.getById(new Long(1));
			fail("Não lançou EntityNotFoundException");
		} catch (EntityNotFoundException e) {
			assertTrue(entidade == null);
		}
	}

	@Test
	public void testaBuscarTudo() {
		List<EntidadeTeste> entidades = service.findAll();

		assertFalse(entidades.isEmpty());
		assertEquals(entidades.size(), 6);
	}

	@Test
	public void testaBuscarPeloAtributoNome() {
		Map<String, Object> fields = new HashMap<String, Object>();
		fields.put("nome", "Entidade Dois");

		List<EntidadeTeste> entidades = service.findByFields(fields, true, 0,
				null);

		assertFalse(entidades.isEmpty());
		assertEquals(entidades.size(), 1);
	}

	@Test
	public void testaBuscarPeloAtributoNomeComLike() {
		Map<String, Object> fields = new HashMap<String, Object>();
		fields.put("nome", "like '%tr%'");

		List<EntidadeTeste> entidades = service.findByFields(fields, true, 0,
				null);

		assertFalse(entidades.isEmpty());
		assertEquals(entidades.size(), 2);
	}

	@Test
	public void testaBuscarPeloAtributoNomeComLikeEId() {
		Map<String, Object> fields = new HashMap<String, Object>();
		fields.put("nome", "like '%tr%'");
		fields.put("id", new Long(3));

		List<EntidadeTeste> entidades = service.findByFields(fields, true, 0,
				null);

		assertFalse(entidades.isEmpty());
		assertEquals(entidades.size(), 1);
	}
}
