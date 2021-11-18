package exoJpa;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exoJpa.config.AppConfig;
import exoJpa.entity.Client;
import exoJpa.repositories.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;

	@Test
	public void clientRepoTestEnVrac() {
//		Client clientTest = new Client("valentin", "?");
//		clientRepository.save(clientTest);
//		Optional<Client> opt = clientRepository.findById(clientTest.getId());
//		assertTrue(opt.isPresent());
//		clientRepository.delete(opt.get());
//		System.out.println(clientRepository.findByPrenomContaining("i"));
//		System.out.println(clientRepository.findByPrenomContainingOrNomContaining("a", "o"));

		clientRepository.findByIdWithCommandes(2L);
		clientRepository.findAllWithCommandes();
	}

	// @Test
	public void sortTest() {
		System.out.println(clientRepository.findById(9999999L));
		Client c = clientRepository.findById(2L).orElse(null);
		System.out.println(c.getCommandes());
		// clientRepository.findById(9999999L).orElseThrow();
		System.out.println(clientRepository.findAll(Sort.by("prenom")));

		Pageable page1sur2 = PageRequest.of(0, 2, Sort.by("prenom"));
		Page<Client> page = clientRepository.findAll(page1sur2);
		System.out.println(page);
		System.out.println(page.getContent());

	}

}
