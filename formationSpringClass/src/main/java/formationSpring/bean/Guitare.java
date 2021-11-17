package formationSpring.bean;

import org.springframework.stereotype.Component;

public class Guitare implements Instrument {
	private String marque;

	public Guitare() {

	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

}
