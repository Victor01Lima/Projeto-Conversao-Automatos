/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.tc;

/**
 *
 * @author VICTOR LIMA
 */
public class Transicao {
    private int to;
    private int from;
    private String read;

    public void setFrom(int from) {
        this.from = from;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public int getFrom() {
        return from;
    }

    public String getRead() {
        return read;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
//    
}
