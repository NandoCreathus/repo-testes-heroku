package br.org.creathus.psi40.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.org.creathus.psi40.model.Defect;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DefectRepositoryTest {
	
	EntityManager entityManager;
	
	/* TESTES A SEREM EXECUTADOS
	 * 1. DEFECT NAO EXISTE
	 * 2. DEFECT EXISTE
	 * 3. PERSISTENCIA DO DB AO SALVAR DEFECT*/
	
//	@InjectMocks
//	DefectService service;
//	----no implements
	
//	@Mock
//	DefectRepository defectrepository;
	
	@Autowired
	private DefectRepository repository;
	
	public Defect createDefect() {

		Defect defect = new Defect();
		
		return defect;

	}
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@DisplayName("Persistencia do DB para salvar Defect") 
	@Test
	public void persistDB() { 
		Defect defect = new Defect();
		Defect defectSaved = repository.save(defect);
		
		Assertions.assertNotNull(defectSaved);
	}
	
	@DisplayName("Procurar se Existe Defect - findAll()")
	@Test
	public void searchIfDefectExists() {
		//cenário
		Defect defect = createDefect();
//		entityManager.persist(defect);
		
		//ação/execução
		List<Defect> result = repository.findAll();
		
		//verificação
		Assertions.assertNotNull(result);
	}
	
	@DisplayName("Retorna Vazio de Defeito nao existe")
	@Test
	public void returnEmptyNotExistsDefect() {
		
		List<Defect> result = repository.findAll();
		
		Assertions.assertTrue(result.isEmpty());
	}

}
