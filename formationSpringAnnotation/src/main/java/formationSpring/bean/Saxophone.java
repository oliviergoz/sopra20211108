package formationSpring.bean;

import org.springframework.stereotype.Component;

@Component
public class Saxophone implements Instrument {

	@Override
	public String getMarque() {
		return "une marque de saxo";
	}

}
