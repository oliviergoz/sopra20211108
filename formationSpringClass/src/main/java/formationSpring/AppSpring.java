package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import formationSpring.bean.Musicien;

public class AppSpring {

	@Autowired
	@Qualifier("saxophinste")
	private Musicien musicien;

	public void run(String... args) {
		System.out.println(musicien);
	}
}
