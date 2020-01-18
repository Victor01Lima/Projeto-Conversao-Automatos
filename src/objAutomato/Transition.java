package objAutomato;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cid
 */
public class Transition {

    private int from;
    private int to;
    private String read;

    /**
     * @return the from
     */
    public int getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(int from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public int getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(int to) {
        this.to = to;
    }

    /**
     * @return the read
     */
    public String getRead() {
        return read;
    }

    /**
     * @param read the read to set
     */
    public void setRead(String read) {
        this.read = read;
    }

}
