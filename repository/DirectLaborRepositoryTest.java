package br.org.creathus.psi40.repository;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.org.creathus.psi40.model.DirectLabor;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DirectLaborRepositoryTest {
	
	/*TESTES A SEREM EXECUTADOS
	 * 1. PERSINTENCIA DO DB
	 * 2. BUSCAR DADO COM ID OK
	 * 3. BUSCAR LISTA DE DIRECTLABOR ONDE ACTIVE IS TRUE
	 * 4. BUSCAR LISTA DE DIRECTLABOR ONDE ACTIVE IS FALSE
	 */
	
	@Autowired
	private DirectLaborRepository repository;
	
	public DirectLabor createDL() {
		DirectLabor dl = new DirectLabor(); //"Role1", 12.00
		
		return dl;
	}
	
	@Test
	public void persistDB() {
		DirectLabor dl = createDL();
		
		DirectLabor dlsaved = repository.save(dl);
		System.out.print(dlsaved);
		
		assertNotNull(dlsaved);
	}
	
	
	@Test
	public void findById_And_DirectLaborIsActive_Success() {
		DirectLabor dl = new DirectLabor();
	
		Optional<DirectLabor> result = repository.findById(1l);
		
		assertNotNull(result);
	}
	
	@Test
	public void findAll_WhereDirectLaborActive_Success() {
		DirectLabor dl = new DirectLabor();
	
		List<DirectLabor> result = repository.findAll();
		
		assertNotNull(result);
	}
	
	@Test
	public void findBy_WhereDirectLaborNotActive() {
		DirectLabor dl1 = new DirectLabor();
		DirectLabor dl2 = new DirectLabor();
		dl1.setEntityId(1l);
		dl1.setActive(false);
		
		dl2.setEntityId(2l);
		dl2.setActive(true);
	
		Optional<DirectLabor> result1 = repository.findById(1l);
		Optional<DirectLabor> result2 = repository.findById(2l);
		
		assertNotNull(result1.isEmpty());
		assertNotNull(result2.isEmpty());
	}
	
}
