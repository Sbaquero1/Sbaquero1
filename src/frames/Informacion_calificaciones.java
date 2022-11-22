/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import clases.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stiven Baquero
 */
public class Informacion_calificaciones extends javax.swing.JFrame {

    
    int idalumno=0;
    int idcalifa=0;
    String nombre_alumno="";
    
    
    
    
    
    
    /**
     * Creates new form Informacion_calificaciones
     */
    public Informacion_calificaciones() {
        initComponents();
        
        
        this.setLocationRelativeTo(null);
        
        txtnombre.setEditable(false);
        
        idcalifa=informacion_alumnos.idcalificacion;
        idalumno=Gestion_alumnos.idalumno;
        
        try {
          
            PreparedStatement ps=cn.prepareStatement("SELECT  nombre FROM alumnos WHERE id_alumno='"+idalumno+"'");
            ResultSet rs=ps.executeQuery();
            
            
            if(rs.next()){
            
            
            nombre_alumno=rs.getString("nombre");
            
            
            
            
            }
            
            
                    
                    
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al consultar nombre alumno");
        }
        
        
        //////////////////////////////////////////////
        try {
            
            
             PreparedStatement ps=cn.prepareStatement("SELECT tarea,calificacion FROM NOTAS WHERE  id_nota='"+idcalifa+"'");
            
                   ResultSet rs=ps.executeQuery(); 
                    
                    
                   if(rs.next()){
                   
                   
                   txttarea.setText(rs.getString("tarea"));
                   txtcalificacion.setText(rs.getString("Calificacion"));
                   
                   }
                   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "eRROR AL CONSULTAR INFORMACION DE CALIFAICACIONES");
        }
        
        txtnombre.setText(nombre_alumno);
        
        ///////////////////////////////////////////////
        
        DefaultTableModel modelo=new DefaultTableModel();
        
        
        modelo.addColumn("Id_nota");
        modelo.addColumn("Tarea");
        modelo.addColumn("Calificacion");
        
        tabla_informacion_calificacion.setModel(modelo);
        
        String sql="SELECT id_nota,tarea,calificacion FROM  notas WHERE id_alumno_nota='"+idalumno+"'";
        
        String datos[]=new String[3];
        
        
        Statement st;
        
        try {
            
               st=cn.createStatement();
                    
                   ResultSet rs=st.executeQuery(sql);
                    
                   
               while(rs.next()){
               
               
               datos[0]=rs.getString("id_nota");
               datos[1]=rs.getString("tarea");
               datos[2]=rs.getString("calificacion");
               
               }    
                   
                  tabla_informacion_calificacion.setModel(modelo);
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error llenar tabla de calificaciones");
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttarea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcalificacion = new javax.swing.JTextField();
        btnactualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_informacion_calificacion = new javax.swing.JTable();
        btnvolver = new javax.swing.JButton();

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Informacion de Calificacion");

        jLabel2.setText("Alumno");

        jLabel3.setText("Tarea");

        jLabel4.setText("Calificacion");

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        tabla_informacion_calificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_informacion_calificacion.setComponentPopupMenu(jPopupMenu2);
        jScrollPane1.setViewportView(tabla_informacion_calificacion);

        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txttarea, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtcalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnvolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnactualizar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtcalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnvolver)
                            .addComponent(btnactualizar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        
        
        
        try {
            if(txttarea.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "No puede dejar el campo tarea en blanco");
            
            
            
            
            }
            else if (txtcalificacion.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null, "No puede dejar el campo calificacion en blanco");
                    
            }
                    
            else{
            
                PreparedStatement ps=cn.prepareStatement("UPDATE notas SET tarea='"+txttarea.getText()+"',calificacion='"+txtcalificacion.getText()+"'"
                        + "WHERE id_nota='"+idcalifa+"'");
            
            int respuesta=ps.executeUpdate();
            
            if(respuesta>0){
            
            JOptionPane.showMessageDialog(null,"Datos actualizados");
            
            
            
            }
            
            }
            
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Error al actulizar datos de calificacion");
        }
        
        
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            
                    
               PreparedStatement ps=cn.prepareStatement("DELETE FROM nota WHERE id_nota='"+idcalifa+"'");
                    
                int respuesta=ps.executeUpdate();
                
                if(respuesta>0){
                
                
                JOptionPane.showMessageDialog(null, "dATOS BORRADOS");
                
                
                }
                else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado fila");
                
                }
                
                    
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        informacion_alumnos Informacion_alumnos=new informacion_alumnos();
        Informacion_alumnos.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_calificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_informacion_calificacion;
    private javax.swing.JTextField txtcalificacion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttarea;
    // End of variables declaration//GEN-END:variables

conectar con=new conectar();
Connection cn=con.conexion();

}
