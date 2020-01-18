///*
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.tc;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author VICTOR LIMA
 */
public class Automato {
    private List<Transicao> transicao = new ArrayList();
    private List<Estado> estado = new ArrayList();
    private List<EstadoFinal> estadofinal = new ArrayList();
    private EstadoInicial estadoincial = new EstadoInicial();
    private String alfabeto;
    
    public List<Transicao> getTransicao() {
        return transicao;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public List<Estado> getEstado() {
        return estado;
    }

    public List<EstadoFinal> getEstadofinal() {
        return estadofinal;
    }

    public EstadoInicial getEstadoincial() {
        return estadoincial;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    public void setEstadofinal(List<EstadoFinal> estadofinal) {
        this.estadofinal = estadofinal;
    }

    public void setEstadoincial(EstadoInicial estadoincial) {
        this.estadoincial = estadoincial;
    }

    public void setTransicao(List<Transicao> transicao) {
        this.transicao = transicao;
    }
    
    
}
