package siplapro;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reyes
 */
public class inicio extends javax.swing.JFrame {

    /**
     * Creates new form inicio
     */
    public inicio() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre proceso:");

        jLabel2.setText("Tiempo llegada:");

        jLabel3.setText("Rafaga CPU:");

        jLabel4.setText("E/S:");

        jLabel5.setText("Rafaga CPU:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel7.setText("Cola 1:");

        jLabel8.setText("Cola 2:");

        comboCola2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "SJN", "HRN" }));

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("SIPLAPRO");

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

        jLabel10.setText("quantum:");

        btnRand.setText("Random");
        btnRand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandActionPerformed(evt);
            }
        });

        jLabel6.setText("RR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnAgregar)
                        .addGap(82, 82, 82)
                        .addComponent(btnRand)
                        .addGap(66, 66, 66)
                        .addComponent(btnEliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(jLabel1))
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTllegada, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRafaga1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(107, 107, 107)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(txtEs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRafaga2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(146, 146, 146))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(comboCola2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(268, 268, 268)
                                            .addComponent(btnEjecutar))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel10)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 36, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRafaga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRafaga2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRand))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboCola2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEjecutar)))
                    .addComponent(jLabel10))
                .addContainerGap())
        );

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
                for(int i=0; i < modelo.getRowCount(); i++){
                    iProcesos[i] = new procesos(modelo.getValueAt(i, 0).toString(), Integer.parseInt(modelo.getValueAt(i, 1).toString()), 
                            Integer.parseInt(modelo.getValueAt(i, 2).toString()), Integer.parseInt(modelo.getValueAt(i, 3).toString()), 
                            Integer.parseInt(modelo.getValueAt(i, 4).toString()));
                }
                int a = iProcesos.length;
                Runner.planner(iProcesos, Integer.parseInt(txtQuan.getText()));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Introduce al menos un proceso");
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    int randcheck = 0;
    private void btnRandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandActionPerformed
        Random rnd = new Random();
        Object o[]=null;
        modelo.addRow(o);
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
            txtQuan.setText("2");
       /* for(int i=0; i<3; i++){
            if(randcheck != 3){
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
        txtQuan.setText(Integer.toString(rnd.nextInt(4)+1)); */
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
