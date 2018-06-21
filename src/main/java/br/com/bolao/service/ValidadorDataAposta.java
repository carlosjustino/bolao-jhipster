package br.com.bolao.service;

import java.time.ZonedDateTime;
import java.util.Objects;

import br.com.bolao.domain.Aposta;
import br.com.bolao.domain.Partida;
import br.com.bolao.web.rest.errors.ApostaAposInicioPartidaException;
import br.com.bolao.web.rest.errors.CustomParameterizedException;

public class ValidadorDataAposta {
	
	private Aposta aposta;
	private Partida partida;
	
	public ValidadorDataAposta(Aposta aposta, Partida partida) {
		 this.aposta = aposta;
		 this.partida = partida;
	}
	
	public void validar() {
		
		if (Objects.isNull(aposta)) {
			throw new CustomParameterizedException("Aposta inválida");
		}

		if (Objects.isNull(partida)) {
			throw new CustomParameterizedException("Aposta deve ser de uma partida");
		}
		
		ZonedDateTime dataAposta = aposta.getDataAposta();
		ZonedDateTime dataPartida = partida.getDataPartida();
		
		
		if (dataAposta.isAfter(dataPartida)) {
			throw new ApostaAposInicioPartidaException();
		}
		
		
	}

}
