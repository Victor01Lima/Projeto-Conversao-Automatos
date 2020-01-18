/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.tc;

//AQUI ESTA FALTANDO FAZER CORRREÇOES
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.print.DocFlavor;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author VICTOR LIMA
 */
public class Inicial extends javax.swing.JFrame {
    private final CarregarXML _readXml = new CarregarXML();
    private Automato automato_afn = new Automato();

    private Automato auto_afd = new Automato();
    private List<Estado> estados_afd = new ArrayList<>();
    private List<Transicao> transicoes_afd = new ArrayList<>();
    private List<EstadoFinal> estadosFinaisAFD = new ArrayList<>();
    private List<EstadoInicial> estadosInicialAFD = new ArrayList<>();
    private String Alfabeto_afd = automato_afn.getAlfabeto();
    private String alfabeto[];
    private int proximaLinhaAFD;
    private int qtdLinhasAFND;
    private int qtdLinhasAFD;
    private String arqName;
    /**
     * Creates new form Iniciala
     */
    public Inicial() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldEntrada = new javax.swing.JButton();
        buttonConverterActionPerformed = new javax.swing.JButton();
        jTextAreaResultados = new javax.swing.JTextField();
        jTextFieldEstadosFinais = new javax.swing.JTextField();
        jButton2ActionPerformed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldEntrada.setText("Selecionar Arquivo");
        jTextFieldEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEntradaActionPerformed(evt);
            }
        });

        buttonConverterActionPerformed.setText("Converter");
        buttonConverterActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConverterActionPerformedActionPerformed(evt);
            }
        });

        jTextAreaResultados.setText("jTextField1");
        jTextAreaResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAreaResultadosActionPerformed(evt);
            }
        });

        jTextFieldEstadosFinais.setText("jTextField1");

        jButton2ActionPerformed.setText("Gerar XML");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jTextAreaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jTextFieldEntrada)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jTextFieldEstadosFinais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2ActionPerformed)
                            .addComponent(buttonConverterActionPerformed))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jTextFieldEntrada)
                        .addGap(52, 52, 52)
                        .addComponent(buttonConverterActionPerformed))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jTextAreaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton2ActionPerformed)
                .addGap(42, 42, 42)
                .addComponent(jTextFieldEstadosFinais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEntradaActionPerformed
        try {
            String current = new java.io.File(".").getCanonicalPath();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(current + "\\Arquivo_In"));
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                arqName = selectedFile.getName();
                automato_afn = _readXml.readXml(selectedFile.getAbsolutePath());
            }
        } catch (IOException ex) {
            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldEntradaActionPerformed

    private void buttonConverterActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConverterActionPerformedActionPerformed
        int i;
        // Algumas inicializações
        qtdLinhasAFND = 0;
        proximaLinhaAFD = 0;
        // Limpa tabelaTransicaoAFD

        // Conta a quantidade de linhas efetivamente utilizadas
       // for (i = 0; (i < tabelaTransicaoAFND.getRowCount() && tabelaTransicaoAFND.getValueAt(i, 0) != null); i++) {
       //     if (!tabelaTransicaoAFND.getValueAt(i, 0).toString().isEmpty()) {
       //         qtdLinhasAFND++;
       //     } else {
       //         break;
       //     }
       // }
        constroiEstados(automato_afn.getEstadoincial().getNome());
        jTextFieldEntrada.setEnabled(true);
    }//GEN-LAST:event_buttonConverterActionPerformedActionPerformed
    private void constroiEstados(String estado) {
        int i, j, k;
        String novoEstado, estadoFinal;
        String estados[];
        List<Transicao> transicoesAFND = automato_afn.getTransicao();

        // Percorre uma vez para cada símbolo do alfabeto
        for (j = 0; j < alfabeto.length; j++) {
            novoEstado = "";
            estados = estado.split(",");

            // Percorre os estados recebidos como parâmetro para encontrar o novo estado
            for (k = 0; k < estados.length; k++) {
                // Percorre a tabela de transições do AFND
                for (i = 0; i < transicoesAFND.size(); i++) {
                    // Encontra a linha onde o estado de origem é o estado que está sendo testado
                    if (localizarTransicao(transicoesAFND.get(i).getFrom(), automato_afn).equals(estados[k]) && transicoesAFND.get(i).getRead().equals(alfabeto[j])) {
                        // Somente inclui em novoEstado se novoEstado não contém o estado
                        if (!contemEstado(novoEstado, localizarTransicao(transicoesAFND.get(i).getTo(), automato_afn))) {
                            if (novoEstado != "") {
                                novoEstado += ",";
                            }
                            novoEstado += localizarTransicao(transicoesAFND.get(i).getTo(), automato_afn);
                        }
                    }
                }
            }

            // Se não encontrou novoEstado então vai para a próxima iteração
            if (novoEstado == "") {
                continue;
            }
            //Ordena estado 
            novoEstado = ordenarEstado(novoEstado);

            boolean verifica = false;
            // Verifica se novoEstado já foi incluído na tabela AFD
            for (i = 0; i < transicoes_afd.size(); i++) {
                //if (tabelaTransicaoAFD.getValueAt(i,0).toString().equals(novoEstado))
                if (transicoes_afd.get(i).getFrom() == retornaIdEstado(estado)
                        && transicoes_afd.get(i).getRead().equals(alfabeto[j])
                        && transicoes_afd.get(i).getTo() == retornaIdEstado(novoEstado)) {
                    verifica = true;
                    break;
                }
            }
            // Se novoEstado ainda não foi incluído no AFD, então inclui e constrói novos estados
            if (!verifica) {
                Estado newEstado = new Estado();
                Transicao newTransicao = new Transicao();
                EstadoFinal newEstadoFinal = new EstadoFinal();
                newEstado.setId(estados_afd.size());
                newEstado.setNome(estado);
                newEstado = adicionarEstado(newEstado);

                String aux = newEstado.getNome().replaceAll("q", "");

                newEstado = new Estado();
                newEstado.setId(estados_afd.size());
                newEstado.setNome(novoEstado);
                newEstado = adicionarEstado(newEstado);

                aux = newEstado.getNome().replaceAll("q", "");

                newTransicao.setFrom(retornaIdEstado(estado));
                newTransicao.setTo(retornaIdEstado(novoEstado));
                newTransicao.setRead(alfabeto[j]);
                transicoes_afd.add(newTransicao);
                estadoFinal = estadoFinalAFND(novoEstado);

                if (estadoFinal.equals("*")) {
                    if (!verficaEstadoFinalExiste(novoEstado)) {
                        newEstadoFinal.setId(retornaIdEstado(novoEstado));
                        newEstadoFinal.setNome(novoEstado);
                        estadosFinaisAFD.add(newEstadoFinal);
                    }
                }
                proximaLinhaAFD++;               
                constroiEstados(novoEstado);
            }
        }
        auto_afd.setAlfabeto(Alfabeto_afd);
        auto_afd.setEstado(estados_afd);
        auto_afd.setEstadofinal(estadosFinaisAFD);
        auto_afd.setTransicao(transicoes_afd);
        auto_afd.setEstadoincial(automato_afn.getEstadoincial());

    }
    private void jTextAreaResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAreaResultadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaResultadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            GerarXML gera = new GerarXML();
            gera.gerar(auto_afd, arqName, true);
            JOptionPane.showMessageDialog(null, "O arquivo AFD_" + arqName + " foi gerado com sucesso!");
        } catch (IOException ex) {
            Logger.getLogger(Inicial.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void buttonExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecutarActionPerformed
        GerarXML gera = new GerarXML();
        try {
            gera.gerar(auto_afd, arqName, true);

        } catch (IOException ex) {
            Logger.getLogger(Inicial.class
                .getName()).log(Level.SEVERE, null, ex);
        }
        int i, j;
        jTextAreaResultados.setText("");    // Limpa os resultados
        // Algumas inicializações
        qtdLinhasAFD = transicoes_afd.size();
        // Autômato executando
        String p = auto_afd.getEstadoincial().getNome();    // Seleciona o estado inicial                   // Imprime o estado inicial
        for (i = 0; i < jTextFieldEntrada.getText().length(); i++) {
            // Encontra o próximo estado
            p = proximoEstado(p, jTextFieldEntrada.getText().substring(i, i + 1));  
        }      
        // Fim da execução do autômato
    }//GEN-LAST:event_buttonExecutarActionPerformed
private String Imprimir_Estados(List<Estado> e) {
        String texto = "";
        for (int i = 0; i < e.size(); i++) {
            if (i < (e.size() - 1)) {
                texto += e.get(i).getNome() + ",";
            } else {
                texto += e.get(i).getNome();
            }
        }
        return texto;
    }

    private String Imprimir_Estados_Final(List<EstadoFinal> e) {
        String texto = "";
        for (int i = 0; i < e.size(); i++) {
            if (i < (e.size() - 1)) {
                texto += e.get(i).getNome() + ",";
            } else {
                texto += e.get(i).getNome();
            }
        }
        return texto;
    }

    private String localizarTransicao(int id, Automato auto) {
        List<Estado> e = auto.getEstado();
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).getId() == id) {
                return e.get(i).getNome();
            }
        }
        return "";
    }

    private String Imprimir_Transicoes_AFN(List<Transicao> t) {
        String texto = "";
        for (int i = 0; i < t.size(); i++) {
            if (i < (t.size() - 1)) {
                texto += "{" + (localizarTransicao(t.get(i).getFrom(), automato_afn)) + ","
                        + (t.get(i).getRead()) + "," + (localizarTransicao(t.get(i).getTo(), automato_afn)) + "},";
            }
        }
        return texto;
    }

    private boolean verficaEstadoFinalExiste(String nome) {
        boolean verifica = false;
        for (int i = 0; i < estadosFinaisAFD.size(); i++) {
            if ((nome.equals(estadosFinaisAFD.get(i).getNome()))) {
                verifica = true;
            }
        }
        return verifica;
    }

    private int retornaIdEstado(String nome) {
        int id = -1;
        for (int i = 0; i < estados_afd.size(); i++) {
            if ((nome.equals(estados_afd.get(i).getNome()))) {
                id = estados_afd.get(i).getId();
            }
        }
        return id;
    }

    private Estado adicionarEstado(Estado e) {
        boolean verifica = false;
        for (int i = 0; i < estados_afd.size(); i++) {
            if ((e.getNome().equals(estados_afd.get(i).getNome()))) {
                e = estados_afd.get(i);
                return e;
            }
        }
        if (!verifica) {
            estados_afd.add(e);
        }
        return e;
    }

    private boolean contemEstado(String estado1, String estado2) {
        int i;
        String estados[] = estado1.split(",");
        for (i = 0; i < estados.length; i++) {
            if (estados[i].equals(estado2)) {
                break;
            }
        }
        if (i < estados.length) {
            return true;
        } else {
            return false;
        }
    }

    private String ordenarEstado(String estado) {
        String tiraVirgula[] = estado.split(",");
        String tiraVirgula2 = "";
        for (int i = 0; i < tiraVirgula.length; i++) {
            tiraVirgula2 += tiraVirgula[i];
        }
        String tiraQ[] = tiraVirgula2.split("q");
        Arrays.sort(tiraQ, 0, tiraQ.length);
        String addVirgula = "";

        for (int i = 0; i < tiraQ.length; i++) {
            if (!tiraQ[i].equals("")) {
                if (i != (tiraQ.length - 1)) {
                    addVirgula += "q" + tiraQ[i] + ",";
                } else {
                    addVirgula += "q" + tiraQ[i];
                }
            }
        }
        return addVirgula;
    }

    private String estadoFinalAFND(String s) {
        int i, j;
        String estadosFinais[] = jTextFieldEstadosFinais.getText().split(",");
        String estadosAux[] = s.split(",");
        // Verifica se o estado final é um dos estados finais do autômato
        for (i = 0; i < estadosFinais.length; i++) {
            for (j = 0; j < estadosAux.length; j++) {
                if (estadosFinais[i].equals(estadosAux[j])) {
                    return "*";
                }
            }
        }
        return "";
    }

    private String proximoEstado(String p1, String p2) {
        int i;
        String s = null;
        // Encontra uma entrada na tabela de transição de estados
        for (i = 0; i < transicoes_afd.size(); i++) {
            if (transicoes_afd.get(i).getFrom() == (retornaIdEstado(p1))
                    && transicoes_afd.get(i).getRead().equals(p2)) {
                s = localizarTransicao(transicoes_afd.get(i).getTo(), auto_afd);
                break;
            }
        }
        return s;
    }

    private boolean estadoFinalAFD(String s) {
        int i;
        for (i = 0; i < estadosFinaisAFD.size(); i++) {
            if (estadosFinaisAFD.get(i).getId() == retornaIdEstado(s)) {
                return true;
            }
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConverterActionPerformed;
    private javax.swing.JButton jButton2ActionPerformed;
    private javax.swing.JTextField jTextAreaResultados;
    private javax.swing.JButton jTextFieldEntrada;
    private javax.swing.JTextField jTextFieldEstadosFinais;
    // End of variables declaration//GEN-END:variables
}
