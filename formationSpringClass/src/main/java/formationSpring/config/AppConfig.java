package formationSpring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import formationSpring.bean.Guitare;
import formationSpring.bean.Guitariste;
import formationSpring.bean.Instrument;
import formationSpring.bean.Musicien;

@Configuration
@ComponentScan({ "formationSpring.bean" })
public class AppConfig {

	@Bean("fender")
	public Instrument guitare() {
		return new Guitare();
	}

	@Bean
	public Musicien guitariste(@Qualifier("fender") Instrument instrument) {
		Guitariste guitariste = new Guitariste();
		guitariste.setInstrument(instrument);
		return guitariste;
	}
}
