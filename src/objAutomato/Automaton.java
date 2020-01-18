package objAutomato;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cid
 */
public class Automaton {

    private List<Transition> transition = new ArrayList();
    private List<Estado> estado = new ArrayList();
    private List<EstadoFinal> estadofinal = new ArrayList();
    private EstadoInicial estadoincial = new EstadoInicial();
    private String alfabeto;


    /**
     * @return the transition
     */
    public List<Transition> getTransition() {
        return transition;
    }

    /**
     * @param transition the transition to set
     */
    public void setTransition(List<Transition> transition) {
        this.transition = transition;
    }

    /**
     * @return the estado
     */
    public List<Estado> getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    /**
     * @return the estadofinal
     */
    public List<EstadoFinal> getEstadofinal() {
        return estadofinal;
    }

    /**
     * @param estadofinal the estadofinal to set
     */
    public void setEstadofinal(List<EstadoFinal> estadofinal) {
        this.estadofinal = estadofinal;
    }

    /**
     * @return the estadoincial
     */
    public EstadoInicial getEstadoincial() {
        return estadoincial;
    }

    /**
     * @param estadoincial the estadoincial to set
     */
    public void setEstadoincial(EstadoInicial estadoincial) {
        this.estadoincial = estadoincial;
    }

    /**
     * @return the alfabeto
     */
    public String getAlfabeto() {
        return alfabeto;
    }

    /**
     * @param alfabeto the alfabeto to set
     */
    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }
}
