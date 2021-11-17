package formationSpring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Saxophoniste implements Musicien {
	@Autowired
	@Qualifier("saxophone")
	private Instrument instrument;

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le saxophoniste joue");
		//throw new IllegalArgumentException();
	}

}
