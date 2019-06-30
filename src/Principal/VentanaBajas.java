/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import ModeloTablas.ModeloAutobuses;
import ModeloTablas.ModeloTrabajador;
import ModeloTablas.ModeloCliente;
import ModeloTablas.ModeloRuta;
import ModeloTablas.ModeloFactura;

import java.awt.Image;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author NEWASUSOJO2
 */
public class VentanaBajas extends javax.swing.JFrame {

    GestoraEmpresa laGestora = new GestoraEmpresa();

    /**
     * Creates new form VentanaBajas
     */
    public VentanaBajas() {
        initComponents();
        try {
            Image icono = new ImageIcon("src/Imagenes/favicon.png").getImage();
            setIconImage(icono);
        } catch (NullPointerException errorIcono) {

        }
        mostrarBotonCerrarVentana(false);
    }

    public void mostrarBotonCerrarVentana(boolean caso) {
        b_cerrarVentana.setVisible(caso);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_principal = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        p_trabajador = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_trabajador = new javax.swing.JTable();
        b_bajaTrabajador = new javax.swing.JButton();
        p_autobus = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_autobus = new javax.swing.JTable();
        b_bajaAutobus = new javax.swing.JButton();
        cb_fabricanteCarroceria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        b_filtrarBuses = new javax.swing.JButton();
        p_cliente = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_cliente = new javax.swing.JTable();
        p_ruta = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_ruta = new javax.swing.JTable();
        p_factura = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        t_factura = new javax.swing.JTable();
        b_menu = new javax.swing.JButton();
        b_salir = new javax.swing.JButton();
        b_cerrarVentana = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Informaci�n � GESTI�N DE EMPRESA �");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        p_principal.setPreferredSize(new java.awt.Dimension(540, 399));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("SELECCIONE UNA PESTA�A PARA MOSTRAR LA INFORMACI�N");

        t_trabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(t_trabajador);

        b_bajaTrabajador.setText("DAR DE BAJA TRABAJADORES SELECCIONADOS");

        javax.swing.GroupLayout p_trabajadorLayout = new javax.swing.GroupLayout(p_trabajador);
        p_trabajador.setLayout(p_trabajadorLayout);
        p_trabajadorLayout.setHorizontalGroup(
            p_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
            .addGroup(p_trabajadorLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(b_bajaTrabajador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_trabajadorLayout.setVerticalGroup(
            p_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_trabajadorLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(b_bajaTrabajador)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("-- TRABAJADOR --", p_trabajador);

        t_autobus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(t_autobus);

        b_bajaAutobus.setText("DAR DE BAJA AUTOBUSES SELECCIONADOS");

        cb_fabricanteCarroceria.setModel(new DefaultComboBoxModel(laGestora.getLosFabricantes()));

        jLabel1.setText("FABRICANTE (CARROCER�A): ");

        b_filtrarBuses.setText("FILTRAR");
        b_filtrarBuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_filtrarBusesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_autobusLayout = new javax.swing.GroupLayout(p_autobus);
        p_autobus.setLayout(p_autobusLayout);
        p_autobusLayout.setHorizontalGroup(
            p_autobusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(p_autobusLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cb_fabricanteCarroceria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_filtrarBuses)
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_autobusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_bajaAutobus)
                .addGap(173, 173, 173))
        );
        p_autobusLayout.setVerticalGroup(
            p_autobusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_autobusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_autobusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_fabricanteCarroceria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(b_filtrarBuses))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(b_bajaAutobus)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("-- AUTOB�S --", p_autobus);

        t_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(t_cliente);

        javax.swing.GroupLayout p_clienteLayout = new javax.swing.GroupLayout(p_cliente);
        p_cliente.setLayout(p_clienteLayout);
        p_clienteLayout.setHorizontalGroup(
            p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );
        p_clienteLayout.setVerticalGroup(
            p_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("-- CLIENTE --", p_cliente);

        t_ruta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(t_ruta);

        javax.swing.GroupLayout p_rutaLayout = new javax.swing.GroupLayout(p_ruta);
        p_ruta.setLayout(p_rutaLayout);
        p_rutaLayout.setHorizontalGroup(
            p_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );
        p_rutaLayout.setVerticalGroup(
            p_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("-- RUTA --", p_ruta);

        t_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(t_factura);

        javax.swing.GroupLayout p_facturaLayout = new javax.swing.GroupLayout(p_factura);
        p_factura.setLayout(p_facturaLayout);
        p_facturaLayout.setHorizontalGroup(
            p_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );
        p_facturaLayout.setVerticalGroup(
            p_facturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("-- FACTURA --", p_factura);

        b_menu.setText("<-- VOLVER A MEN�");
        b_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_menuActionPerformed(evt);
            }
        });

        b_salir.setText("SALIR DEL PROGRAMA");
        b_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salirActionPerformed(evt);
            }
        });

        b_cerrarVentana.setText("CERRAR LA VENTANA");
        b_cerrarVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cerrarVentanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_principalLayout = new javax.swing.GroupLayout(p_principal);
        p_principal.setLayout(p_principalLayout);
        p_principalLayout.setHorizontalGroup(
            p_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_principalLayout.createSequentialGroup()
                .addGroup(p_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_principalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(p_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextArea1)
                            .addGroup(p_principalLayout.createSequentialGroup()
                                .addComponent(b_menu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_cerrarVentana)
                                .addGap(87, 87, 87)
                                .addComponent(b_salir))))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        p_principalLayout.setVerticalGroup(
            p_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(p_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_menu)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_salir)
                        .addComponent(b_cerrarVentana)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salirActionPerformed
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "GRACIAS. HASTA PRONTO.", "GESTI�N DE EMPRESA �", 1);
        System.exit(0);
    }//GEN-LAST:event_b_salirActionPerformed

    private void b_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_menuActionPerformed
        VentanaMenu elMenu = new VentanaMenu();
        this.setVisible(false);
        elMenu.setVisible(true);
    }//GEN-LAST:event_b_menuActionPerformed

    private void b_cerrarVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cerrarVentanaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_b_cerrarVentanaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //TABLA TRABAJADOR
        ModeloTrabajador moTrab = new ModeloTrabajador(laGestora.getLosTrabajadores());
        t_trabajador.setModel(moTrab);
        TableRowSorter<ModeloTrabajador> ordenarTrabajadores = new TableRowSorter<ModeloTrabajador>(moTrab);
        t_trabajador.setRowSorter(ordenarTrabajadores);
        //TABLA AUTOBUSES
        ModeloAutobuses moAuto = new ModeloAutobuses(laGestora.getLosAutobuses(null));
        t_autobus.setModel(moAuto);
        TableRowSorter<ModeloAutobuses> ordenarBuses= new TableRowSorter<ModeloAutobuses>(moAuto);
        t_autobus.setRowSorter(ordenarBuses);
        //TABLA CLIENTES
        ModeloCliente moCli = new ModeloCliente(laGestora.getLosClientes());
        t_cliente.setModel(moCli);
                    //falta rowSorter pa ke kede m�s shulo
        //TABLA RUTAS
        ModeloRuta moRut = new ModeloRuta(laGestora.getLasRutas());
        t_ruta.setModel(moRut);
                    //falta rowSorter pa ke kede m�s shulo
        //TABLA FACTURAS
        ModeloFactura moFac = new ModeloFactura(laGestora.getLasFacturas());
        t_factura.setModel(moFac);
                    //falta rowSorter pa ke kede m�s shulo
    }//GEN-LAST:event_formWindowOpened

    private void b_filtrarBusesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_filtrarBusesActionPerformed
        String fabricante = cb_fabricanteCarroceria.getItemAt(cb_fabricanteCarroceria.getSelectedIndex());
        ModeloAutobuses moAuto = new ModeloAutobuses(laGestora.getLosAutobuses(fabricante));
        t_autobus.setModel(moAuto);
    }//GEN-LAST:event_b_filtrarBusesActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBajas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_bajaAutobus;
    private javax.swing.JButton b_bajaTrabajador;
    private javax.swing.JButton b_cerrarVentana;
    private javax.swing.JButton b_filtrarBuses;
    private javax.swing.JButton b_menu;
    private javax.swing.JButton b_salir;
    private javax.swing.JComboBox<String> cb_fabricanteCarroceria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel p_autobus;
    private javax.swing.JPanel p_cliente;
    private javax.swing.JPanel p_factura;
    private javax.swing.JPanel p_principal;
    private javax.swing.JPanel p_ruta;
    private javax.swing.JPanel p_trabajador;
    private javax.swing.JTable t_autobus;
    private javax.swing.JTable t_cliente;
    private javax.swing.JTable t_factura;
    private javax.swing.JTable t_ruta;
    private javax.swing.JTable t_trabajador;
    // End of variables declaration//GEN-END:variables
}
