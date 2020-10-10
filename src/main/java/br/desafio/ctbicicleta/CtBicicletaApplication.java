package br.desafio.ctbicicleta;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.desafio.ctbicicleta.domain.model.aggregates.BikePesquisa;
import br.desafio.ctbicicleta.domain.model.entities.Acessorios;
import br.desafio.ctbicicleta.domain.model.entities.KmAcessorios;
import br.desafio.ctbicicleta.repositories.AcessoriosRepository;
import br.desafio.ctbicicleta.repositories.BikePesquisaRepository;
import br.desafio.ctbicicleta.repositories.KmAcessoriosRepository;
import br.desafio.ctbicicleta.util.enumeration.CategoriaEnum;
import br.desafio.ctbicicleta.util.enumeration.TipoEnum;

@SpringBootApplication
public class CtBicicletaApplication implements CommandLineRunner{
	
	/*@Autowired
	private BikePesquisaRepository bikePesquisaRepository;
	
	@Autowired
	private KmAcessoriosRepository kmAcessoriosRepository;
	
	@Autowired
	private AcessoriosRepository acessoriosRepository;*/
	        
	public static void main(String[] args) {
		SpringApplication.run(CtBicicletaApplication.class, args);
	}
	
	 @Override
	public void run(String... args) throws Exception {	
		
		/*bikePesquisaRepository.save(new BikePesquisa(null, 20000.0, "desc 1", "Nome bike 1 MP", TipoEnum.MOUTAIN, CategoriaEnum.PROFISSIONAL));
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
		
		bikePesquisaRepository.findFirst10ByTipoOrderByPrecoDesc(TipoEnum.URBANA);
		
		
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
				new Acessorios(8L, "Kit de reparos", "link"),
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
		
		
		Optional<KmAcessorios> ax =  kmAcessoriosRepository.findById(5);
	    if (ax.isPresent()) {
	    	System.out.println(ax.get().getKm());
	    	System.out.println(ax.get().getAcessorios());
	    }*/
	}	
}
