/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Dados.Consulta;
import Funcionarios.Secretaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author home
 */
public class AtualizaConsulta extends javax.swing.JFrame {
    Secretaria sec;
    EntityManager em;
    /**
     * Creates new form AtualizaConsulta
     * @param sec
     * @param em
     */
    public AtualizaConsulta(Secretaria sec, EntityManager em) {
        initComponents();
        this.sec = sec;
        this.em = em;
        //Fatores estéticos da janela (tamanho, posição e cor)
        setSize(480, 280);
        setLocationRelativeTo(null);
        getContentPane().setBackground(java.awt.Color.white);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        hora = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        identificaConsulta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clinica Medica");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(165, 107, 255));
        jLabel1.setText("ATUALIZAÇÃO - DATA E HORA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel2.setText("Nova Data:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        jLabel3.setText("Novo Horário:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, 20));
        getContentPane().add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 120, -1));
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 130, -1));

        jButton1.setBackground(new java.awt.Color(224, 188, 255));
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarDados(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel4.setText("Insira a data, o horário e o CRM do médico da consulta (sem espaços):");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));
        getContentPane().add(identificaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarDados(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarDados
        /*
        Atualiza a data e a hora da consulta escolhida.
        */
        em.getTransaction().begin();
        //BUSCA DA CONSULTA  CORRETA A PARTIR DO IDENTIFICADOR
        Query query = em.createQuery(("select c FROM Consulta c WHERE c.identificador LIKE \'" + identificaConsulta.getText() + "\'"));
        List<Consulta> consultas = query.getResultList();
        
        sec.atualizarConsultaDataHora(consultas.get(0), data.getText(), hora.getText()); // SECRETARIA ATUALIZA A CONSULTA
        
        em.getTransaction().commit();
        dispose();
    }//GEN-LAST:event_atualizarDados

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        /*
        Cancela a ação.
        */
        dispose();
    }//GEN-LAST:event_cancelar

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField data;
    private javax.swing.JTextField hora;
    private javax.swing.JTextField identificaConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
