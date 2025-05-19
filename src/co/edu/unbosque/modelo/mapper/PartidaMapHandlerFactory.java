package co.edu.unbosque.modelo.mapper;

public class PartidaMapHandlerFactory {

	public static PartidaMapHandlerI getHandler(String tipoPartida) {
		switch (tipoPartida) {
			case "PartidaCarrera":
				return new PartidaMapHandlerCarrera();
			case "PartidaFifa":
				return new PartidaMapHandlerFIFA();
			case "PartidaRocketLeague":
				return new PartidaMapHandlerRocketLeague();
			default:
				return null;
		}
	}
}
