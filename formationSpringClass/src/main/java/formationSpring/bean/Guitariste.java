package formationSpring.bean;

import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Guitariste implements Musicien {

	private Instrument instrument;

	public Guitariste() {

	}

	public Instrument getInstrument() {
		// throw new IllegalArgumentException();
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le guitariste joue");

	}

}
