/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import clases.conectar;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static frames.Gestion_alumnos.idalumno;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;
import javax.imageio.IIOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stiven Baquero
 */
public class informacion_alumnos extends javax.swing.JFrame {
    
    DefaultTableModel modelo=new DefaultTableModel();
    int idalumno=0;
    public static int idcalificacion=0;
    

    /**
     * Creates new form informacion_alumnos
     */
    public informacion_alumnos() {
        initComponents();
        
        
        this.setLocationRelativeTo(null);
        
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txttelefono.setEditable(false);
        txtcalificacion.setEditable(false);
        lblaprobado.setEditable(false);
        cmbgrado.setEditable(false);
        idalumno=Gestion_alumnos.idalumno;
        
        try {
                
            Connection cn=con.conexion();
            
            PreparedStatement ps=cn.prepareStatement("SELECT * FROM  alumnos WHERE id_alumno='"+idalumno+"'");
            
            ResultSet rs=ps.executeQuery();
            
            
            if(rs.next()){
            
                setTitle("Informacion del alumno"+rs.getString("nombre"));
                lblinfo_alumno.setText("Informacion del alumno"+rs.getString("nombre"));
                
                txtnombre.setText(rs.getString("nombre"));
                txtapellido.setText(rs.getString("apellido"));
                cmbgrado.setSelectedItem(rs.getString("grado"));
                txttelefono.setText(rs.getString("telefono"));
                
                
            
            }
            
            
            
        } catch (SQLException e) {
            System.err.println(e);
            
            JOptionPane.showMessageDialog(null,"Error al cargar alumno.. Comunicarse con el administrador");
            
        }
        
        /////////////////////////////////////////////////////////////////////////////
        
        try {
            
            PreparedStatement ps=cn.prepareStatement(         
            "SELECT id_nota,tarea,calificacion FROM notas WHERE id_alumno_nota='"+idalumno+"'");
            
            ResultSet rs=ps.executeQuery();
            
            tabla_calificaciones=new JTable(modelo);
            jScrollPane1.setViewportView(tabla_calificaciones);
            
            modelo.addColumn("Id nota");
            modelo.addColumn("Tarea");
            modelo.addColumn("Calificacion");
            
            
            while(rs.next()){
            
            
            Object[] fila=new Object[3];
                    
            for (int i =0;i<3;i++){
            
            fila[i]=rs.getObject(i+1);
            
            }
            modelo.addRow(fila);
            
            ////////////////////////////////////////////////////////////
            
            int filax=0;
            int total=0;
            
            for (int i =0;i<tabla_calificaciones.getRowCount();i++){
                
                filax=Integer.parseInt(tabla_calificaciones.getValueAt(i,2).toString());
            total+=filax;
            
               txtcalificacion.setText(""+total); 
                
            }
            
            int califa=Integer.parseInt(txtcalificacion.getText());
            
            if(califa>=80){
            
            lblaprobado.setText(String.valueOf("Aprobado"));
            txtcalificacion.setBackground(Color.green);
            
            
            
            }
            else{
            
            lblaprobado.setBackground(Color.red);
            
            
            }
            
            
            
            
            
            }
            
            
            
        } catch (Exception e) {
            System.err.println("Error diligenciando la tabla calificaciones");
            
        }
        
        tabla_calificaciones.addMouseListener(new MouseAdapter(){
        
        @Override
        
        public void mouseClicked(MouseEvent e){
        
        int fila_point=tabla_calificaciones.rowAtPoint(e.getPoint());
        int columna_point=0;
        
        if(fila_point>-1){
        
        idcalificacion=(int)modelo.getValueAt(fila_point, columna_point);
       Informacion_calificaciones informacion_calificaciones=new Informacion_calificaciones();
       informacion_calificaciones.setVisible(true);
       dispose();
        }
        
        }
   });
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblinfo_alumno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbgrado = new javax.swing.JComboBox<>();
        txttelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_calificaciones = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblaprobado = new javax.swing.JTextField();
        btnimprimir = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        btnregistrar_alumno = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtcalificacion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblinfo_alumno.setText("Informacion Alumno");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Grado");

        cmbgrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel5.setText("Telefono");

        tabla_calificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_calificaciones);

        jLabel6.setText("Estatus:");

        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        btnregistrar_alumno.setText("Registra calificacion");
        btnregistrar_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrar_alumnoActionPerformed(evt);
            }
        });

        jButton4.setText("Calificacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbgrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lblinfo_alumno)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblaprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnvolver)
                        .addGap(87, 87, 87)
                        .addComponent(btnregistrar_alumno)
                        .addGap(180, 180, 180)
                        .addComponent(txtcalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(btnimprimir)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblinfo_alumno)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblaprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbgrado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnvolver)
                    .addComponent(btnregistrar_alumno)
                    .addComponent(jButton4)
                    .addComponent(txtcalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
      
        Gestion_alumnos gestion_alumnos=new Gestion_alumnos();
        gestion_alumnos.setVisible(true);
        dispose();
        
        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnregistrar_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrar_alumnoActionPerformed
     
        
        Registrar_calificaciones registrar_calificaciones=new Registrar_calificaciones();
        registrar_calificaciones.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnregistrar_alumnoActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        
        Document documento=new Document();
        Calendar cal=Calendar.getInstance();
        Date fecha=new Date(cal.getTimeInMillis());
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        String verfecha=formato.format(fecha);
        
        try {
            
                String ruta=System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/desktop/"+txtnombre.getText()+".pdf"));
                 
                Paragraph parrafo=new Paragraph();
                
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Arial",20,BaseColor.BLACK));
                parrafo.add("informacion del alumno.\n \n");
                
                
                Paragraph poner_fecha=new Paragraph();
                poner_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
                poner_fecha.add("Fecha "+verfecha+"\n \n");
                
                documento.open();
                documento.add(parrafo);
                documento.add(poner_fecha);
                
                
                PdfPTable tablaalumno=new PdfPTable(4);
                
                tablaalumno.addCell("Nombre");
                tablaalumno.addCell("Apellido");
                tablaalumno.addCell("Grado");
                tablaalumno.addCell("Materia");
                
                try {
                
                     PreparedStatement  ps=cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno='"+idalumno+"'");
                        
                      ResultSet  rs=ps.executeQuery();
                      
                    if(rs.next()){
                    
                    do{
                    
                     tablaalumno.addCell(rs.getString(2));
                     tablaalumno.addCell(rs.getString(3));
                     tablaalumno.addCell(rs.getString(4));
                     tablaalumno.addCell(rs.getString(6));
                    
                    
                    
                    } while(rs.next());
                    {
                    
                    
                    documento.add(tablaalumno);
                    
                    
                    }
                    
                    
                    
                    }  
                      
                  Paragraph   parrafo2=new Paragraph();
                  parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                  parrafo2.setFont(FontFactory.getFont("Arial",20,BaseColor.BLACK));
                  parrafo2.add("\n \n Tareas registradas \n \n");
                  
                  
                  
                  documento.add(parrafo2);
                  
                  PdfPTable tablatareas=new PdfPTable(2);
                  
                  tablatareas.addCell("Tarea");
                  tablatareas.addCell("Calificacion");
                        
                  
                    try {
                         Connection cn2=con.conexion();  
                                
                                PreparedStatement ps2=cn2.prepareStatement("SELECT tarea,calificacion FROM notas WHERE in_alumno_nota='"+idalumno+"'");
                                
                                ResultSet rs2=ps2.executeQuery();
                                
                                
                       if(rs2.next()){
                       
                       do{
                       
                       tablatareas.addCell(rs2.getString(1));
                       tablatareas.addCell(rs2.getString(2));
                       
                       
                       
                       } while(rs2.next());{
                       
                       
                        documento.add(tablatareas);
                       
                       }
                       
                       
                       
                       }         
                                
                                
                                
                    } catch (SQLException e) {
                        System.err.println("Error carga de tareas"+e);
                    }
                  
                  //////////////////////////////////////////////////////////////////
            } catch (SQLException e) {
                
                System.err.println("Error OBTENER DATOS DEL ALUMNO"+e);
            }
                
                
                ///////////////////////////////////////////////////////////////
                
                documento.close();
                JOptionPane.showMessageDialog(null, "Documento creado con exito");
                
                    
        } catch (DocumentException | IOException e) {
            
            
            System.err.println("Error en el pdf o ruta"+e);
            
            JOptionPane.showMessageDialog(null,"Error al generar pdf.comunicar administardor");
        }
        
    }//GEN-LAST:event_btnimprimirActionPerformed

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
            java.util.logging.Logger.getLogger(informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacion_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnregistrar_alumno;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cmbgrado;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblaprobado;
    private javax.swing.JLabel lblinfo_alumno;
    private javax.swing.JTable tabla_calificaciones;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcalificacion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
conectar con=new conectar();
Connection cn=con.conexion();

    private Font FontFactory(String arial, int i, BaseColor BLACK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
