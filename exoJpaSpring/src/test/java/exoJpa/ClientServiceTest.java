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
import exoJpa.services.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;

	@Test
	public void removeTest() {
		Client c = new Client();
		c.setId(5L);
		clientService.delete(c);
	}

}
