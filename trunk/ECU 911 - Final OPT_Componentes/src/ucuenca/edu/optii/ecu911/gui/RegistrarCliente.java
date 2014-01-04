/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ucuenca.edu.optii.ecu911.negocio.Cliente;
import ucuenca.edu.optii.ecu911.negocio.Telefono;
import ucuenca.edu.optii.ecu911.negocio.VectoresObj;

/**
 *
 * @author May
 */
public class RegistrarCliente extends javax.swing.JPanel {
Cliente uncliente=new Cliente();
VectoresObj unv=new VectoresObj();
    /**
     * Creates new form RegistrarCliente
     */
    public RegistrarCliente() {
        initComponents();
         actualizaComboTelefonos();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtceduClientes = new javax.swing.JTextField();
        txtnameClientes = new javax.swing.JTextField();
        comboTelefonoCli = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        ponFonoCli = new javax.swing.JLabel();
        addCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();

        jLabel15.setText("Nombres");

        jLabel16.setText("Cedula");

        txtceduClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtceduClientesActionPerformed(evt);
            }
        });

        comboTelefonoCli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTelefonoCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTelefonoCliMouseClicked(evt);
            }
        });

        jLabel17.setText("Telefono");

        ponFonoCli.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        addCliente.setText("registrar");
        addCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Direccion");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(28, 28, 28)
                                .addComponent(txtceduClientes))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtnameClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(addCliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ponFonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTelefonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtdireccion)
                                .addGap(46, 46, 46)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtceduClientes)
                    .addComponent(addCliente))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnameClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboTelefonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addComponent(ponFonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtceduClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtceduClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtceduClientesActionPerformed
  public void actualizaComboTelefonos() {
        List telfs = new ArrayList();

        unv.listarTelefonosDisponibles();
        telfs = unv.getTelfsDisponibles();
        comboTelefonoCli.removeAllItems();
        comboTelefonoCli.addItem("");
        for (int i = 0; i < telfs.size(); i++) {
            Telefono otroTipo = new Telefono();
            otroTipo = (Telefono) telfs.get(i);
            comboTelefonoCli.addItem(otroTipo.getId() + ", " + otroTipo.getNumero());
        }
    }
 
    private void addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClienteActionPerformed
        if (txtceduClientes.getText().equals("") || txtnameClientes.getText().equals("") || ponFonoCli.getText().equals("")|| txtdireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar los campos de texto");
        } else {
            Telefono unt = new Telefono();
            unt.setId(Integer.valueOf(ponFonoCli.getText()));

            uncliente.setMifono(unt);
            if (uncliente.buscar())//busca telefonos en tabla clientes para validar q exista uno x cliente
            {
                JOptionPane.showMessageDialog(null, "Telefono ya existente en el cliente " + uncliente.getNombres() + " ingrese otro numero");
            } else {
                uncliente.setMifono(unt);
                uncliente.setCedula(txtceduClientes.getText());
                uncliente.setNombres(txtnameClientes.getText());
                uncliente.setDireccion(txtdireccion.getText());
                boolean r = uncliente.grabar();
                if (r == true) {
                    JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
                } else if (r == false) {
                    JOptionPane.showMessageDialog(null, "Error al Grabar datos");
                }
            }
          regresarParaLlamar(uncliente.getCedula());
            actualizaComboTelefonos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addClienteActionPerformed

    public void regresarParaLlamar(String cedula){
    GestionLlamadasEmergencia v=new GestionLlamadasEmergencia(cedula);
      JFrame k = new JFrame();
            k.add(v);
            k.setSize(500, 350);
            k.setVisible(true);
    }
    private void comboTelefonoCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTelefonoCliMouseClicked
        StringTokenizer tokens = new StringTokenizer((String) comboTelefonoCli.getSelectedItem(), ",");
        try {
            ponFonoCli.setText(tokens.nextToken());
        } catch (NoSuchElementException e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTelefonoCliMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCliente;
    private javax.swing.JComboBox comboTelefonoCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel ponFonoCli;
    private javax.swing.JTextField txtceduClientes;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnameClientes;
    // End of variables declaration//GEN-END:variables
}
