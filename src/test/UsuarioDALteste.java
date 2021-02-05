package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DAL.UsuarioDAL;
import Model.Usuario;

class UsuarioDALteste {
	private UsuarioDAL ud;
	
	private Usuario u;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ud = new UsuarioDAL();
		u = new Usuario();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUsuarioDAL() {
		// fail("Not yet implemented");
	}

	@Test
	void testInsert() {
		u.setId(1);
		u.setNome("testando25/05");
		u.setEmail("testandodasilva@gmail.com");
		u.setSenha("123456");
		u.setTipo("visitante");
		u.setAtivo(true);
		ud.insert(u);
		
	}

	@Test
	void testUpdate() {
		u.setNome("testando25");
		u.setEmail("testandodasilva@gmail.com");
		u.setSenha("123456");
		u.setTipo("visitante");
		u.setAtivo(true);
		u.setId(1);
		ud.update(u); 
	}

	@Test
	void testDelete() {
		int a = 1;
		ud.delete(a);
	}

	@Test
	void testListAll() {
	//	fail("Not yet implemented");
	}

	@Test
	void testAutenticacao() {
	//	fail("Not yet implemented");
	}

	@Test
	void testGet() {
	//	fail("Not yet implemented");
	}

}
