package siplapro;
/**
 *
 * @author reyes
 */
import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class inicio extends javax.swing.JFrame {
public static final Color BackColor = new Color(204,224,255);

    public inicio() {
        initComponents();
        this.setBackground(BackColor);
        this.setSize(1100, 620);
        this.setLocationRelativeTo(null);
        CrearModelo();
    }
    
    run Runner = new run();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTllegada = new javax.swing.JTextField();
        txtRafaga1 = new javax.swing.JTextField();
        txtEs = new javax.swing.JTextField();
        txtRafaga2 = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboCola2 = new javax.swing.JComboBox<>();
        btnEjecutar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnRand = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtQuan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre proceso:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 52, -1, -1));

        jLabel2.setText("Tiempo llegada:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 52, -1, -1));

        jLabel3.setText("Rafaga CPU:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 52, -1, -1));

        jLabel4.setText("E/S:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 52, -1, -1));

        jLabel5.setText("Rafaga CPU:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 52, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 86, 102, -1));
        getContentPane().add(txtTllegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 86, 93, -1));
        getContentPane().add(txtRafaga1, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 86, 72, -1));
        getContentPane().add(txtEs, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 86, 60, -1));
        getContentPane().add(txtRafaga2, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 86, 72, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 165, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 165, -1, -1));

        jLabel7.setText("Cola 1:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 498, -1, -1));

        jLabel8.setText("Cola 2:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 540, -1, -1));

        comboCola2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "SJN", "HRN" }));
        getContentPane().add(comboCola2, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 534, 119, -1));

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEjecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 120, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("SIMULADOR DE PLANIFICACION DE PROCESOS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabla);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 213, 934, 269));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel10.setText("quantum:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, -1, -1));

        btnRand.setText("Random");
        btnRand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandActionPerformed(evt);
            }
        });
        getContentPane().add(btnRand, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 165, -1, -1));

        jLabel6.setText("RR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 498, -1, -1));
        getContentPane().add(txtQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 493, 51, -1));

        jLabel12.setText("Penalizacion cola 1: acabar quantum o acabar rafaga.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, -1, -1));

        jLabel13.setText("Recompensa cola 2: acabar rafaga.");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, -1, -1));

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 8)); // NOI18N
        jLabel14.setText("Reyngs");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siplapro/blue.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int i = 0;
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if((txtNombre.getText().equals("")) || (txtTllegada.getText().equals("")) || (txtRafaga1.getText().equals("")) || (txtEs.getText().equals("")) || (txtRafaga2.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "Llena todos los campos para agregar el proceso");
        }
        
        int vNombre = 0;

        for(int i=0; i<modelo.getRowCount(); i++){
            if(txtNombre.getText().equals(tabla.getValueAt(i, 0).toString())){
                vNombre++;
            }
        }
        if(vNombre > 0){
            JOptionPane.showMessageDialog(null, "Ingresa un nombre diferente al proceso");
        }else {
            try{
                Object o[]=null;
                modelo.addRow(o);
                modelo.setValueAt(txtNombre.getText(), i, 0);
                modelo.setValueAt(txtTllegada.getText(), i, 1);
                modelo.setValueAt(txtRafaga1.getText(), i, 2);
                modelo.setValueAt(txtEs.getText(), i, 3);
                modelo.setValueAt(txtRafaga2.getText(), i, 4);
                i++;
                txtNombre.setText("");
                txtTllegada.setText("");
                txtRafaga1.setText("");
                txtEs.setText("");
                txtRafaga2.setText(""); 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try{
            if(tabla.getSelectedRow() >= 0 ){
                modelo.removeRow(tabla.getSelectedRow());
                i--;
            }else{
                JOptionPane.showMessageDialog(null, "Debes seleccionar un proceso de la tabla");
            } 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        if(modelo.getRowCount() > 0){
            if(txtQuan.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Introduce un dato en el quantum");
            }else{
                procesos [] iProcesos = new procesos[(modelo.getRowCount())];
                procesos [] oProcesos = new procesos[(modelo.getRowCount())];
                for(int i=0; i < modelo.getRowCount(); i++){
                    iProcesos[i] = new procesos(modelo.getValueAt(i, 0).toString(), Integer.parseInt(modelo.getValueAt(i, 1).toString()), 
                            Integer.parseInt(modelo.getValueAt(i, 2).toString()), Integer.parseInt(modelo.getValueAt(i, 3).toString()), 
                            Integer.parseInt(modelo.getValueAt(i, 4).toString()));
                    oProcesos[i] = new procesos(modelo.getValueAt(i, 0).toString(), Integer.parseInt(modelo.getValueAt(i, 1).toString()), 
                            Integer.parseInt(modelo.getValueAt(i, 2).toString()), Integer.parseInt(modelo.getValueAt(i, 3).toString()), 
                            Integer.parseInt(modelo.getValueAt(i, 4).toString()));
                }
                Runner.planner(iProcesos, oProcesos, Integer.parseInt(txtQuan.getText()), comboCola2.getSelectedItem().toString());
                this.setVisible(false);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Introduce al menos un proceso");
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    int randcheck = 0;
    private void btnRandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandActionPerformed
        Random rnd = new Random();
        Object o[]=null;
      /*  modelo.addRow(o);
        modelo.setValueAt("P0", 0, 0);
            modelo.setValueAt(0, 0, 1);
            modelo.setValueAt(3, 0, 2);
            modelo.setValueAt(2,0, 3);
            modelo.setValueAt(2,0, 4);
        modelo.addRow(o);
        modelo.setValueAt("P1", 1, 0);
            modelo.setValueAt(1, 1, 1);
            modelo.setValueAt(2, 1, 2);
            modelo.setValueAt(2,1, 3);
            modelo.setValueAt(1,1, 4);
        modelo.addRow(o);
        modelo.setValueAt("P2", 2, 0);
            modelo.setValueAt(3, 2, 1);
            modelo.setValueAt(3, 2, 2);
            modelo.setValueAt(3,2, 3);
            modelo.setValueAt(1,2, 4);
            txtQuan.setText("2"); */
        for(int i=0; i<10; i++){
            if(randcheck != 10){
                modelo.addRow(o);
                randcheck++;
            }
            String A = "";
            A += "P";
            //A += (char)(rnd.nextInt(24)+65); Para letra random
            A += i;
            modelo.setValueAt(A, i, 0);
            modelo.setValueAt(rnd.nextInt(5), i, 1);
            modelo.setValueAt(rnd.nextInt(4)+1, i, 2);
            modelo.setValueAt(rnd.nextInt(4)+1, i, 3);
            modelo.setValueAt(rnd.nextInt(4)+1, i, 4);
        }
        txtQuan.setText(Integer.toString(rnd.nextInt(4)+1)); 
    }//GEN-LAST:event_btnRandActionPerformed

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
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }
    
    DefaultTableModel modelo;
    private void CrearModelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Proceso", "T. Llegada", "Refaga CPU",
                        "E/S", "Refaga CPU"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error");
            System.out.println("Problema con el modelo de tabla");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRand;
    private javax.swing.JComboBox<String> comboCola2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtEs;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtQuan;
    private javax.swing.JTextField txtRafaga1;
    private javax.swing.JTextField txtRafaga2;
    private javax.swing.JTextField txtTllegada;
    // End of variables declaration//GEN-END:variables
}
