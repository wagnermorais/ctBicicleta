package br.desafio.ctbicicleta.interfaces.endpoint;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.desafio.ctbicicleta.domain.model.aggregates.BikePesquisa;
import br.desafio.ctbicicleta.domain.model.entities.Acessorios;
import br.desafio.ctbicicleta.domain.model.entities.KmAcessorios;
import br.desafio.ctbicicleta.repositories.AcessoriosRepository;
import br.desafio.ctbicicleta.repositories.BikePesquisaRepository;
import br.desafio.ctbicicleta.repositories.KmAcessoriosRepository;
import br.desafio.ctbicicleta.util.enumeration.CategoriaEnum;
import br.desafio.ctbicicleta.util.enumeration.TipoEnum;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PesquisaBikeRestControllerTest {

	private final String REQUEST_MAPPING = "/pesquisabike";



	@Autowired
	public WebApplicationContext context;
	
	@Autowired
	private BikePesquisaRepository bikePesquisaRepository;
	
	@Autowired
	private KmAcessoriosRepository kmAcessoriosRepository;
	
	@Autowired
	private AcessoriosRepository acessoriosRepository;
	
	
 
	private MockMvc mvc;
	
	

	@BeforeAll
	public void setup() {
		// mock do serviço
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		
		bikePesquisaRepository.save(new BikePesquisa(null, 20000.0, "desc 1", "Nome bike 1 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 30000.0, "desc 2", "Nome bike 2 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 25000.0, "desc 3", "Nome bike 3 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 27000.0, "desc 4", "Nome bike 4 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 20000.0, "desc 5", "Nome bike 5 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 33000.0, "desc 6", "Nome bike 6 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 22000.0, "desc 7", "Nome bike 7 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 21000.0, "desc 8", "Nome bike 8 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 33000.0, "desc 9", "Nome bike 9 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 26000.0, "desc 10", "Nome bike 10 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 23000.0, "desc 11", "Nome bike 11 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
		

		bikePesquisaRepository.save(new BikePesquisa(null, 10000.0, "desc 1", "Nome bike 1 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 11000.0, "desc 2", "Nome bike 2 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 12000.0, "desc 3", "Nome bike 3 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 12500.0, "desc 4", "Nome bike 4 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 12000.0, "desc 5", "Nome bike 5 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 9000.0, "desc 6", "Nome bike 6 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 9500.0, "desc 7", "Nome bike 7 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 9300.0, "desc 8", "Nome bike 8 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 8000.0, "desc 9", "Nome bike 9 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 7000.0, "desc 10", "Nome bike 10 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 6000.0, "desc 11", "Nome bike 11 MI", TipoEnum.MOUTAIN, CategoriaEnum.INTERMEDIARIA));
		
		bikePesquisaRepository.save(new BikePesquisa(null, 10000.0, "desc 1", "Nome bike 1 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 11000.0, "desc 2", "Nome bike 2 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 12000.0, "desc 3", "Nome bike 3 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 12500.0, "desc 4", "Nome bike 4 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 12000.0, "desc 5", "Nome bike 5 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 9000.0, "desc 6", "Nome bike 6 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 9500.0, "desc 7", "Nome bike 7 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 9300.0, "desc 8", "Nome bike 8 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 8000.0, "desc 9", "Nome bike 9 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 7000.0, "desc 10", "Nome bike 10 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 6000.0, "desc 11", "Nome bike 11 MS", TipoEnum.MOUTAIN, CategoriaEnum.SIMPLES));
		
		
		
		
		
		bikePesquisaRepository.save(new BikePesquisa(null, 20000.0, "desc 1", "Nome bike 1 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 30000.0, "desc 2", "Nome bike 2 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 25000.0, "desc 3", "Nome bike 3 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 27000.0, "desc 4", "Nome bike 4 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 20000.0, "desc 5", "Nome bike 5 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 33000.0, "desc 6", "Nome bike 6 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 22000.0, "desc 7", "Nome bike 7 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 21000.0, "desc 8", "Nome bike 8 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 33000.0, "desc 9", "Nome bike 9 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 26000.0, "desc 10", "Nome bike 10 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 23000.0, "desc 11", "Nome bike 11 SP", TipoEnum.SPEED, CategoriaEnum.PROFISSIONAL));
		

		bikePesquisaRepository.save(new BikePesquisa(null, 10000.0, "desc 1", "Nome bike 1 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 11000.0, "desc 2", "Nome bike 2 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 12000.0, "desc 3", "Nome bike 3 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 12500.0, "desc 4", "Nome bike 4 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 12000.0, "desc 5", "Nome bike 5 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 9000.0, "desc 6", "Nome bike 6 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 9500.0, "desc 7", "Nome bike 7 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 9300.0, "desc 8", "Nome bike 8 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 8000.0, "desc 9", "Nome bike 9 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 7000.0, "desc 10", "Nome bike 10 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 6000.0, "desc 11", "Nome bike 11 SI", TipoEnum.SPEED, CategoriaEnum.INTERMEDIARIA));
		
		bikePesquisaRepository.save(new BikePesquisa(null, 10000.0, "desc 1", "Nome bike 1 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 11000.0, "desc 2", "Nome bike 2 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 12000.0, "desc 3", "Nome bike 3 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 12500.0, "desc 4", "Nome bike 4 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 12000.0, "desc 5", "Nome bike 5 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 9000.0, "desc 6", "Nome bike 6 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 9500.0, "desc 7", "Nome bike 7 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 9300.0, "desc 8", "Nome bike 8 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 8000.0, "desc 9", "Nome bike 9 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 7000.0, "desc 10", "Nome bike 10 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 6000.0, "desc 11", "Nome bike 11 SS", TipoEnum.SPEED, CategoriaEnum.SIMPLES));
		
		
		
		
		bikePesquisaRepository.save(new BikePesquisa(null, 10000.0, "desc 1", "Nome bike 1 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 9300.0, "desc 2", "Nome bike 2 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 9500.0, "desc 3", "Nome bike 3 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 8000.0, "desc 4", "Nome bike 4 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 7000.0, "desc 5", "Nome bike 5 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 6000.0, "desc 6", "Nome bike 6 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 6500.0, "desc 7", "Nome bike 7 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 6700.0, "desc 8", "Nome bike 8 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 6800.0, "desc 9", "Nome bike 9 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 7100.0, "desc 10", "Nome bike 10 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		bikePesquisaRepository.save(new BikePesquisa(null, 7200.0, "desc 11", "Nome bike 11 UP", TipoEnum.URBANA, CategoriaEnum.PROFISSIONAL));
		

		bikePesquisaRepository.save(new BikePesquisa(null, 5000.0, "desc 1", "Nome bike 1 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 5200.0, "desc 2", "Nome bike 2 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 5300.0, "desc 3", "Nome bike 3 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 5500.0, "desc 4", "Nome bike 4 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 5800.0, "desc 5", "Nome bike 5 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 5900.0, "desc 6", "Nome bike 6 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 6000.0, "desc 7", "Nome bike 7 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 4800.0, "desc 8", "Nome bike 8 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 4900.0, "desc 9", "Nome bike 9 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 6540.0, "desc 10", "Nome bike 10 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		bikePesquisaRepository.save(new BikePesquisa(null, 6331.0, "desc 11", "Nome bike 11 UI", TipoEnum.URBANA, CategoriaEnum.INTERMEDIARIA));
		
		bikePesquisaRepository.save(new BikePesquisa(null, 1000.0, "desc 1", "Nome bike 1 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 1200.0, "desc 2", "Nome bike 2 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 1500.0, "desc 3", "Nome bike 3 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 1400.0, "desc 4", "Nome bike 4 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 1700.0, "desc 5", "Nome bike 5 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 1800.0, "desc 6", "Nome bike 6 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 2000.0, "desc 7", "Nome bike 7 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 2100.0, "desc 8", "Nome bike 8 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 2200.0, "desc 9", "Nome bike 9 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 2300.0, "desc 10", "Nome bike 10 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		bikePesquisaRepository.save(new BikePesquisa(null, 2400.0, "desc 11", "Nome bike 11 US", TipoEnum.URBANA, CategoriaEnum.SIMPLES));
		
	
		
		acessoriosRepository.save(new Acessorios(1L, "Capacete", "link"));
		acessoriosRepository.save(new Acessorios(2L, "Luzes de Sinalização", "link"));
		acessoriosRepository.save(new Acessorios(3L, "Bermuda", "link"));
		acessoriosRepository.save(new Acessorios(4L, "Garrafa de água", "link"));
		acessoriosRepository.save(new Acessorios(5L, "Bomba para encher pneu", "link"));
		acessoriosRepository.save(new Acessorios(6L, "Espátula para trocar a Camera", "link"));
		acessoriosRepository.save(new Acessorios(7L, "Camera Revesrva", "link"));
		acessoriosRepository.save(new Acessorios(8L, "Kit de reparos", "link"));
		acessoriosRepository.save(new Acessorios(9L, "Camisa com porta objets", "link"));
		acessoriosRepository.save(new Acessorios(10L, "Alimentação", "link"));
		acessoriosRepository.save(new Acessorios(11L, "Luva", "link"));
		acessoriosRepository.save(new Acessorios(12L, "Kit Chaves", "link"));
		acessoriosRepository.save(new Acessorios(13L, "Reparo Corrente", "link"));
		acessoriosRepository.save(new Acessorios(14L, "Conhecimento basico de mecanica", "link"));
		
		
		List<Acessorios> ACESSORIOS = Arrays.asList(new Acessorios(1L, "Capacete", "link"), new Acessorios(2L, "Luzes de Sinalização", "link"),  
				new Acessorios(3L, "Bermuda", "link"),new Acessorios(4L, "Garrafa de água", "link"),new Acessorios(5L, "Bomba para encher pneu", "link"),
				new Acessorios(6L, "Espátula para trocar a Camera", "link"),
				new Acessorios(7L, "Camera Revesrva", "link"),
				new Acessorios(8L, "Kit de reSparos", "link"),
				new Acessorios(9L, "Camisa com porta objets", "link"),
				new Acessorios(10L, "Alimentação", "link"),
				new Acessorios(11L, "Luva", "link"),
				new Acessorios(12L, "Kit Chaves", "link"),	
				new Acessorios(13L, "Reparo Corrente", "link"),
				new Acessorios(14L, "Conhecimento basico de mecanica", "link")
		) ;
	
		
		
		kmAcessoriosRepository.save(new KmAcessorios(5, ACESSORIOS.stream().limit(2).collect(Collectors.toList()))) ;
		kmAcessoriosRepository.save(new KmAcessorios(10, ACESSORIOS.stream().limit(4).collect(Collectors.toList()))) ;
		kmAcessoriosRepository.save(new KmAcessorios(20, ACESSORIOS.stream().limit(5).collect(Collectors.toList()))) ;
		kmAcessoriosRepository.save(new KmAcessorios(40, ACESSORIOS.stream().limit(7).collect(Collectors.toList()))) ;
		kmAcessoriosRepository.save(new KmAcessorios(80, ACESSORIOS.stream().limit(10).collect(Collectors.toList()))) ;
		kmAcessoriosRepository.save(new KmAcessorios(130, ACESSORIOS)) ;
		
		
		
		
	}
	
	@Test
	@DisplayName("Pesquisar Resgistro 412")
	@Order(1)
	public void pesquisar_412() throws Exception {		

		this.mvc.perform(
				get("http://localhost:8090/pesquisabike/600/montanhasss")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isPreconditionFailed());		
	}
	
	@Test
	@DisplayName("Pesquisar Resgistro 200")
	@Order(2)
	public void pesquisar200() throws Exception {		

		this.mvc.perform(
				get("http://localhost:8090/pesquisabike/200/asfalto}")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
		
		
	}
	
	/*@AfterAll
	void findTest() {
		usuarioInternoQueryService.deletar(usu);;		
	}	


	@Test
	@DisplayName("Inserir Registro com Sucesso")
	@Order(0)
	public void saveExtracaoLoteria_Sucesso() throws Exception {		
		
		String json = UsuarioInternoConverter.usuarioInternoDTOtoJson(DTOMapper.convert(usu, UsuarioInternoDTO.class));
		this.mvc.perform(
				post(REQUEST_MAPPING)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());		
	}
	
	@Test
	@DisplayName("Alterar Registro com Sucesso")
	@Order(1)
	public void updateExtracaoLoteria_Sucesso() throws Exception {		
		
		String json = UsuarioInternoConverter.usuarioInternoDTOtoJson(DTOMapper.convert(usu, UsuarioInternoDTO.class));
		this.mvc.perform(
				put(REQUEST_MAPPING)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
	}
	
	@Test
	@DisplayName("Alterar com Erro 404")
	@Order(2)
	public void updateExtracaoLoteria_Erro_404() throws Exception {		
		
		UUID uuid = UUID.randomUUID();
		UsuarioInternoDTO dto = new UsuarioInternoDTO(uuid.toString().substring(0, 14), false);
		
		String json = UsuarioInternoConverter.usuarioInternoDTOtoJson(dto);
		
		
		this.mvc.perform(
				put(REQUEST_MAPPING)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());		
	}
	
	
	@Test
	@DisplayName("Pesquisar Todos Registros")
	@Order(4)
	public void pesquisarTodosRegistros() throws Exception {		
		
		
		this.mvc.perform(
				get(REQUEST_MAPPING)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
	}
	
	
	@Test
	@DisplayName("Pesquisar Resgistro por ID")
	@Order(5)
	public void pesquisarRegistroPoID() throws Exception {		

		this.mvc.perform(
				get(REQUEST_MAPPING + usu.getLoginRede())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
	}
	
	
	@Test
	@DisplayName("Apagar Resgistro com Sucesso")
	@Order(6)
	public void apagarRegistro_Sucesso() throws Exception {		
		
		this.mvc.perform(
				delete(REQUEST_MAPPING + usu.getLoginRede())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
	}*/
	

}
