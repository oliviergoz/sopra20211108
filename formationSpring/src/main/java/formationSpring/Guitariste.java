package formationSpring;

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

}
