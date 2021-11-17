package formationSpring.bean;

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
		System.out.println("set done");
		this.instrument = instrument;
		System.out.println("instrument:" + this.instrument);
	}

}
