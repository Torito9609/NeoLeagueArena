package co.edu.unbosque.modelo.entidad;

import java.time.LocalDate;
import java.util.Objects;

import co.edu.unbosque.modelo.enums.EstadoPartida;

public abstract class Partida <R extends Resultado>{
	private String id;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private LocalDate fecha;
	private EstadoPartida estado;

	public Partida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Partida(String id, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fecha) {
		super();
		this.id = id;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
		this.estado = EstadoPartida.PENDIENTE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public EstadoPartida getEstadoPartida() {
		return estado;
	}

	public void setEstadoPartida(EstadoPartida estadoPartida) {
		this.estado = estadoPartida;
	}
	
	 public boolean estaFinalizada() {
	        return estado == EstadoPartida.FINALIZADA;
	    }
	
    public void registrarResultado(R resultado) {
        if (estado != EstadoPartida.PENDIENTE) {
            throw new IllegalStateException("No se puede registrar resultado: partida " + estado);
        }
        aplicarResultado(resultado);
        this.estado = EstadoPartida.FINALIZADA;
    }
    
    protected abstract void aplicarResultado(R resultado);
    
    public abstract R getResultado();
    
    public abstract Equipo getGanador();
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partida)) return false;
        Partida<?> that = (Partida<?>) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Partida{" +
               "id='" + id + '\'' +
               ", local=" + (equipoLocal != null ? equipoLocal.getId() : "null") +
               ", visitante=" + (equipoVisitante != null ? equipoVisitante.getId() : "null") +
               ", fecha=" + fecha +
               ", estado=" + estado +
               '}';
    }

}
