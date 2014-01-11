/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.gui;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ucuenca.edu.optii.ecu911.dao.EcuDB;
import ucuenca.edu.optii.ecu911.dao.PermisoDB;
import ucuenca.edu.optii.ecu911.negocio.Cliente;
import ucuenca.edu.optii.ecu911.negocio.EntidadBomberos;
import ucuenca.edu.optii.ecu911.negocio.EntidadCNT;
import ucuenca.edu.optii.ecu911.negocio.EntidadCooperativa;
import ucuenca.edu.optii.ecu911.negocio.EntidadCruzRoja;
import ucuenca.edu.optii.ecu911.negocio.EntidadFuerzasArmadas;
import ucuenca.edu.optii.ecu911.negocio.EntidadPolicia;
import ucuenca.edu.optii.ecu911.negocio.Login;
import ucuenca.edu.optii.ecu911.negocio.OperadorEcu;
import ucuenca.edu.optii.ecu911.negocio.Permiso;
import ucuenca.edu.optii.ecu911.negocio.Registro_LLamadas;
import ucuenca.edu.optii.ecu911.negocio.Rol;
import ucuenca.edu.optii.ecu911.negocio.Rol_Permiso;
import ucuenca.edu.optii.ecu911.negocio.Llamar;
import ucuenca.edu.optii.ecu911.negocio.Telefono;
import ucuenca.edu.optii.ecu911.negocio.TipoIncidente;
import ucuenca.edu.optii.ecu911.negocio.Ubicacion_Incidente;
import ucuenca.edu.optii.ecu911.negocio.VectoresObj;
import ucuenca.edu.optii.ecu911.negocio.Visitor;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ExcepcionVerificarAtenderIncidente;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ExcepcionVerificarDireccionIncidente;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ExcepcionVerificarPersonaAfectada;
import ucuenca.edu.optii.ecu911.negocio.excepciones.SeleccionarTablaExcepcion;
import ucuenca.edu.optii.ecu911.negocio.excepciones.TelefonoVerificacionException;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ValidaDatoInexistenteExcepcion;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ValidaTextoExcepcion;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ValidacionCamposTextoExcepcion;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ValidacionGrabacionDatos;
import ucuenca.edu.optii.ecu911.negocio.excepciones.ValidacionPermisosAsignados_RolExcepcion;
import ucuenca.edu.optii.ecu911.negocio.validaciones;

/**
 *
 * @author May
 */
public class MenuAdm extends javax.swing.JFrame {

    EntidadCooperativa mienti = new EntidadCooperativa() {

        @Override
        public String aceptar(Visitor visitor) {
            return "";
        }
    };
    Cliente uncliente = new Cliente();
    Permiso unpermiso = new Permiso();
    Rol unrol = new Rol();
    Telefono untelefono = new Telefono();
    TipoIncidente untipoI = new TipoIncidente();
    Ubicacion_Incidente unaubicac = new Ubicacion_Incidente();
    OperadorEcu unopE = new OperadorEcu();
    EntidadCooperativa unaent;
    Rol_Permiso rolP = new Rol_Permiso();
    VectoresObj unv = new VectoresObj();
    List permisosAgregados = new ArrayList();
    List listCentroNacional = new ArrayList();
    List listCentroZonal = new ArrayList();
    List listCentroLocal = new ArrayList();
    String ClienteQueLlama = new String();
    EcuDB miEcu = new EcuDB();

    /**
     * Creates new form MenuAdm
     */
    public MenuAdm() {
        initComponents();
        actualizaTodo();
        jTabbedPane1.setEnabledAt(7, false);

    }

    public MenuAdm(String cedCLiente) {
        initComponents();
        ClienteQueLlama = cedCLiente;
        actualizaTodo();
        ocultarPanelesPAraOPeradorEcu();
        panelAlarmas.setVisible(true);
        txtCedulaAlarma.setText(ClienteQueLlama);
        //jTabbedPane1.setEnabledAt(4, false);
    }

    public MenuAdm(int opcionUsuario) {
        initComponents();
    }

    public void ocultarPanelesPAraOPeradorEcu() {
        jTabbedPane1.removeTabAt(0);
        jTabbedPane1.removeTabAt(1);
        jTabbedPane1.removeTabAt(2);
        jTabbedPane1.removeTabAt(3);
        jTabbedPane1.repaint();
        jTabbedPane1.removeTabAt(1);
        jTabbedPane1.removeTabAt(0);
    }

    public void actualizaTodo() {
        //actualizando tablas
        actualizaroles();
        actualizapermisos();
        actualizatiposInc();
        actualizatelefonos();
        actualizaEntidades();
        actualizaOperadoresEcu();
        actualizaclientes();
        actualizaRegistroLlamadas();
        actualizaSesiones();
        //actualizando combos
        actualizaComboPermisos();
        actualizaComboTelefonos();
        actualizaComboRoles();
        actualizaComboEntidades();

        //actualizares
        agregarProvincias();
    }

    public void agregarProvincias() {
        listCentroNacional.add("Samborondón");
        listCentroNacional.add("Quito");
        listCentroNacional.add("Guayas");
        listCentroNacional.add("Santa Elena");
        listCentroNacional.add("Pichincha");
        listCentroNacional.add("Napo");
        listCentroNacional.add("Orellana");

        listCentroZonal.add("Ambato");
        listCentroZonal.add("Cañar");
        listCentroZonal.add("Azuay");
        listCentroZonal.add("Tungurahua");
        listCentroZonal.add("Pastaza");
        listCentroZonal.add("Cotopaxi");
        listCentroZonal.add("Machala");
        listCentroZonal.add("Portoviejo");
        listCentroZonal.add("El Oro");
        listCentroZonal.add("Manabí");

        listCentroLocal.add("Santo Domingo");
        listCentroLocal.add("Esmeraldas");
        listCentroLocal.add("Santo Domingo de los Tsáchilas");

        cboProvincias.removeAllItems();
        for (int i = 0; i < listCentroNacional.size(); i++) {
            cboProvincias.addItem(listCentroNacional.get(i));
        }
        for (int i = 0; i < listCentroZonal.size(); i++) {
            cboProvincias.addItem(listCentroZonal.get(i));
        }
        for (int i = 0; i < listCentroLocal.size(); i++) {
            cboProvincias.addItem(listCentroLocal.get(i));
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

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelTelefonos = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtIdTelefono = new javax.swing.JTextField();
        txtnumTelefono = new javax.swing.JTextField();
        txtTipoTelf = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        t_telf = new javax.swing.JTable();
        panelClientes = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        t_listado_clientes = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtceduClientes = new javax.swing.JTextField();
        txtnameClientes = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        addCliente = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        comboTelefonoCli = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        ponFonoCli = new javax.swing.JLabel();
        panelPermisos = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtIdPermisos = new javax.swing.JTextField();
        txtnamePermisos = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        agregaPermisos = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_Permisos = new javax.swing.JTable();
        panelRoles = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_roles = new javax.swing.JTable();
        txtRolid = new javax.swing.JTextField();
        txtRolname = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_PermisosDRoles = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        comboPermisRoles = new javax.swing.JComboBox();
        AddEnArrayPermisos = new javax.swing.JButton();
        ponIdPermiso = new javax.swing.JLabel();
        panelOperadoresEcu911 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_operadoresEcu = new javax.swing.JTable();
        txtcedU = new javax.swing.JTextField();
        txtnameU = new javax.swing.JTextField();
        txtsueldoU = new javax.swing.JTextField();
        comboRolesU = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        addUser = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ponRolU = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtpassU = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        ponEntidadId = new javax.swing.JLabel();
        comboEntidades = new javax.swing.JComboBox();
        panelEntidadesCooperativas = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        addEntidad = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtidEntidad = new javax.swing.JTextField();
        txtciudadEntidad = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        comboTipoEnti = new javax.swing.JComboBox();
        ponEntidad = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        t_EntidadesCoop = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txtfonoEntidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        auxIdEnt = new javax.swing.JLabel();
        comboTelefonosParaEntidades = new javax.swing.JComboBox();
        jButton7 = new javax.swing.JButton();
        panelTipoIncidentes = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        addTipoI = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        t_TipoIncidente = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        nameTipoInc = new javax.swing.JTextField();
        idTipoInc = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        panelAlarmas = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtNombresAlarma = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedulaAlarma = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cboProvincias = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtDireccionAlarma = new javax.swing.JTextArea();
        jPanel18 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        cboIncentesAlarma = new javax.swing.JComboBox();
        btnAddIncidente = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtAtender = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtNotificacion = new javax.swing.JTextArea();
        btnAlertar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        t_llamadasRegistradas = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        t_sesiones = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel19.setText("Numero");

        jLabel20.setText("Tipo");

        jLabel21.setText("Id");

        txtIdTelefono.setEnabled(false);
        txtIdTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTelefonoActionPerformed(evt);
            }
        });

        txtnumTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumTelefonoActionPerformed(evt);
            }
        });

        txtTipoTelf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoTelfKeyTyped(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jButton15.setText("registrar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("modificar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("eliminar");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15)
                .addGap(8, 8, 8)
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        t_telf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Numero", "Tipo"
            }
        ));
        jScrollPane7.setViewportView(t_telf);

        javax.swing.GroupLayout panelTelefonosLayout = new javax.swing.GroupLayout(panelTelefonos);
        panelTelefonos.setLayout(panelTelefonosLayout);
        panelTelefonosLayout.setHorizontalGroup(
            panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTelefonosLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTelefonosLayout.createSequentialGroup()
                        .addGroup(panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelTelefonosLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(39, 39, 39)
                                .addComponent(txtIdTelefono))
                            .addGroup(panelTelefonosLayout.createSequentialGroup()
                                .addGroup(panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTipoTelf)
                                    .addComponent(txtnumTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(panelTelefonosLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelTelefonosLayout.setVerticalGroup(
            panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTelefonosLayout.createSequentialGroup()
                .addGroup(panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTelefonosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTelefonosLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtnumTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTipoTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Telefonos", panelTelefonos);

        t_listado_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "cedula", "nombres", "# incidentes", "telefono"
            }
        ));
        jScrollPane5.setViewportView(t_listado_clientes);

        jLabel15.setText("Nombres");

        jLabel16.setText("Cedula");

        txtceduClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtceduClientesActionPerformed(evt);
            }
        });
        txtceduClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtceduClientesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtceduClientesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtceduClientesKeyTyped(evt);
            }
        });

        txtnameClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameClientesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnameClientesKeyTyped(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        addCliente.setText("registrar");
        addCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClienteActionPerformed(evt);
            }
        });

        jButton12.setText("modificar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("eliminar");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCliente)
                .addGap(8, 8, 8)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboTelefonoCli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTelefonoCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTelefonoCliMouseClicked(evt);
            }
        });

        jLabel17.setText("Telefono");

        ponFonoCli.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClientesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelClientesLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ponFonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTelefonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelClientesLayout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(28, 28, 28)
                                    .addComponent(txtceduClientes))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelClientesLayout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtnameClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtceduClientes))
                        .addGap(9, 9, 9)
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnameClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTelefonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(ponFonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );

        jTabbedPane1.addTab("Clientes", panelClientes);

        jLabel12.setText("Id");

        jLabel13.setText("Nombre Permiso");

        txtIdPermisos.setEnabled(false);

        txtnamePermisos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnamePermisosKeyTyped(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        agregaPermisos.setText("registrar");
        agregaPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregaPermisosActionPerformed(evt);
            }
        });

        jButton9.setText("modificar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("eliminar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agregaPermisos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agregaPermisos)
                .addGap(8, 8, 8)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        t_Permisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Permiso"
            }
        ));
        jScrollPane4.setViewportView(t_Permisos);

        javax.swing.GroupLayout panelPermisosLayout = new javax.swing.GroupLayout(panelPermisos);
        panelPermisos.setLayout(panelPermisosLayout);
        panelPermisosLayout.setHorizontalGroup(
            panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPermisosLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnamePermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(panelPermisosLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        panelPermisosLayout.setVerticalGroup(
            panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPermisosLayout.createSequentialGroup()
                .addGroup(panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPermisosLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtIdPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtnamePermisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPermisosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Permisos", panelPermisos);

        jLabel7.setText("Nombre de Rol:");

        jLabel8.setText("Id");

        t_roles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nombre Rol"
            }
        ));
        t_roles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_rolesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(t_roles);

        txtRolid.setEnabled(false);

        txtRolname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRolnameKeyTyped(evt);
            }
        });

        t_PermisosDRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Rol", "Permiso"
            }
        ));
        jScrollPane3.setViewportView(t_PermisosDRoles);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jButton4.setText("registrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("eliminar");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(8, 8, 8)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Permisos");

        comboPermisRoles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPermisRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboPermisRolesMouseClicked(evt);
            }
        });

        AddEnArrayPermisos.setText("incluir");
        AddEnArrayPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEnArrayPermisosActionPerformed(evt);
            }
        });

        ponIdPermiso.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout panelRolesLayout = new javax.swing.GroupLayout(panelRoles);
        panelRoles.setLayout(panelRolesLayout);
        panelRolesLayout.setHorizontalGroup(
            panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRolesLayout.createSequentialGroup()
                .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRolesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addGroup(panelRolesLayout.createSequentialGroup()
                        .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRolesLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRolesLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRolesLayout.createSequentialGroup()
                                .addComponent(txtRolname, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AddEnArrayPermisos))
                            .addGroup(panelRolesLayout.createSequentialGroup()
                                .addComponent(txtRolid, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ponIdPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboPermisRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelRolesLayout.setVerticalGroup(
            panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRolesLayout.createSequentialGroup()
                .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRolesLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRolid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ponIdPermiso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboPermisRoles, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtRolname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(AddEnArrayPermisos)))
                    .addGroup(panelRolesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Roles", panelRoles);

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombres");

        jLabel4.setText("Sueldo");

        t_operadoresEcu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "cedula", "nombres", "sueldo", "nombre usuario"
            }
        ));
        jScrollPane1.setViewportView(t_operadoresEcu);

        txtcedU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedUActionPerformed(evt);
            }
        });

        txtnameU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnameUKeyTyped(evt);
            }
        });

        comboRolesU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboRolesU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboRolesUMouseClicked(evt);
            }
        });

        jLabel6.setText("Rol");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        addUser.setText("registrar");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        jButton2.setText("modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("eliminar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addUser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addUser)
                .addGap(8, 8, 8)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ponRolU.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel10.setText("Usuario");

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jLabel11.setText("Contraseña");

        txtpassU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassUActionPerformed(evt);
            }
        });

        jLabel14.setText("Entidad");

        ponEntidadId.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        comboEntidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEntidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboEntidadesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOperadoresEcu911Layout = new javax.swing.GroupLayout(panelOperadoresEcu911);
        panelOperadoresEcu911.setLayout(panelOperadoresEcu911Layout);
        panelOperadoresEcu911Layout.setHorizontalGroup(
            panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                        .addComponent(txtcedU)
                        .addGap(80, 80, 80))
                    .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                        .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtnameU, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpassU))
                        .addGap(75, 75, 75)))
                .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ponRolU, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ponEntidadId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboRolesU, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsueldoU, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOperadoresEcu911Layout.setVerticalGroup(
            panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                        .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtcedU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnameU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(txtpassU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelOperadoresEcu911Layout.createSequentialGroup()
                        .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ponRolU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboRolesU, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtsueldoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelOperadoresEcu911Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboEntidades)
                            .addComponent(jLabel14)
                            .addComponent(ponEntidadId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Operador_Ecu", panelOperadoresEcu911);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        addEntidad.setText("registrar");
        addEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntidadActionPerformed(evt);
            }
        });

        jButton19.setText("modificar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("eliminar");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addEntidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEntidad)
                .addGap(8, 8, 8)
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel22.setText("Id");

        jLabel23.setText("Provincia");

        txtidEntidad.setEnabled(false);

        txtciudadEntidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtciudadEntidadKeyTyped(evt);
            }
        });

        jLabel25.setText("Entidad Tipo:");

        comboTipoEnti.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bomberos", "Policia", "CNT", "Cruz Roja", "Fuerzas Armadas", "Gestion Riesgos" }));
        comboTipoEnti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTipoEntiMouseClicked(evt);
            }
        });

        ponEntidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        ponEntidad.setEnabled(false);

        t_EntidadesCoop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "ciudad", "entidad", "conmutador"
            }
        ));
        t_EntidadesCoop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_EntidadesCoopMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(t_EntidadesCoop);

        jLabel27.setText("Telf Conmutador");

        txtfonoEntidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        txtfonoEntidad.setEnabled(false);

        jButton1.setText("Agregar Incidentes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        auxIdEnt.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        comboTelefonosParaEntidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTelefonosParaEntidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTelefonosParaEntidadesMouseClicked(evt);
            }
        });

        jButton7.setText("gestionar personal");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEntidadesCooperativasLayout = new javax.swing.GroupLayout(panelEntidadesCooperativas);
        panelEntidadesCooperativas.setLayout(panelEntidadesCooperativasLayout);
        panelEntidadesCooperativasLayout.setHorizontalGroup(
            panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                        .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))
                        .addGap(26, 26, 26)
                        .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                                .addComponent(txtfonoEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(comboTelefonosParaEntidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                                .addComponent(ponEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(comboTipoEnti, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtciudadEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntidadesCooperativasLayout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntidadesCooperativasLayout.createSequentialGroup()
                                        .addComponent(auxIdEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntidadesCooperativasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        panelEntidadesCooperativasLayout.setVerticalGroup(
            panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                        .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel22)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel23)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntidadesCooperativasLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(txtidEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtciudadEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboTipoEnti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ponEntidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9)
                        .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtfonoEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTelefonosParaEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelEntidadesCooperativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEntidadesCooperativasLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(auxIdEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44)
                        .addComponent(jButton7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Entidades Cooperativas", panelEntidadesCooperativas);

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        addTipoI.setText("registrar");
        addTipoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTipoIActionPerformed(evt);
            }
        });

        jButton25.setText("modificar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("eliminar");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addTipoI, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addTipoI)
                .addGap(8, 8, 8)
                .addComponent(jButton25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        t_TipoIncidente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "descripcion"
            }
        ));
        jScrollPane10.setViewportView(t_TipoIncidente);

        jLabel31.setText("Descripcion");

        nameTipoInc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTipoIncKeyTyped(evt);
            }
        });

        idTipoInc.setEnabled(false);

        jLabel32.setText("Id");

        javax.swing.GroupLayout panelTipoIncidentesLayout = new javax.swing.GroupLayout(panelTipoIncidentes);
        panelTipoIncidentes.setLayout(panelTipoIncidentesLayout);
        panelTipoIncidentesLayout.setHorizontalGroup(
            panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoIncidentesLayout.createSequentialGroup()
                .addGroup(panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTipoIncidentesLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTipoInc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTipoInc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTipoIncidentesLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(243, Short.MAX_VALUE))
            .addGroup(panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTipoIncidentesLayout.createSequentialGroup()
                    .addContainerGap(449, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(95, Short.MAX_VALUE)))
        );
        panelTipoIncidentesLayout.setVerticalGroup(
            panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoIncidentesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(idTipoInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(nameTipoInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(panelTipoIncidentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTipoIncidentesLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(244, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("TIpoIncidente", panelTipoIncidentes);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente")));

        jLabel28.setText("Direccion ");

        txtNombresAlarma.setEditable(false);

        jLabel26.setText("Nombre:");

        jLabel3.setText("Cedula:");

        txtCedulaAlarma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaAlarmaKeyPressed(evt);
            }
        });

        jLabel18.setText("Provincia:");

        txtDireccionAlarma.setColumns(20);
        txtDireccionAlarma.setRows(5);
        jScrollPane9.setViewportView(txtDireccionAlarma);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtCedulaAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombresAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(71, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCedulaAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtNombresAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(117, Short.MAX_VALUE)))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Incidentes"));

        jLabel29.setText("Incidentes:");

        cboIncentesAlarma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddIncidente.setText("Add");
        btnAddIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIncidenteActionPerformed(evt);
            }
        });

        jLabel30.setText("Atender:");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane6.setViewportView(txtObservaciones);

        jLabel33.setText("Observaciones:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel33))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addGap(6, 6, 6)
                        .addComponent(cboIncentesAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddIncidente)
                        .addGap(37, 37, 37))
                    .addComponent(jScrollPane6)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cboIncentesAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddIncidente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtAtender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNotificacion.setEditable(false);
        txtNotificacion.setColumns(20);
        txtNotificacion.setRows(5);
        txtNotificacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Log Output"));
        jScrollPane11.setViewportView(txtNotificacion);

        btnAlertar.setText("Alertar");
        btnAlertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlertarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAlarmasLayout = new javax.swing.GroupLayout(panelAlarmas);
        panelAlarmas.setLayout(panelAlarmasLayout);
        panelAlarmasLayout.setHorizontalGroup(
            panelAlarmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlarmasLayout.createSequentialGroup()
                .addGroup(panelAlarmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelAlarmasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlertar))
                    .addGroup(panelAlarmasLayout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 112, Short.MAX_VALUE))
        );
        panelAlarmasLayout.setVerticalGroup(
            panelAlarmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlarmasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlarmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlarmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addGroup(panelAlarmasLayout.createSequentialGroup()
                        .addComponent(btnAlertar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lanzar Alarma", panelAlarmas);

        t_llamadasRegistradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "cedula", "cliente", "telefono", "tipo", "direccion", "fecha"
            }
        ));
        jScrollPane12.setViewportView(t_llamadasRegistradas);
        t_llamadasRegistradas.getColumnModel().getColumn(3).setHeaderValue("tipo");
        t_llamadasRegistradas.getColumnModel().getColumn(4).setHeaderValue("direccion");

        jLabel24.setText("Llamadas De Clientes Realizadas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Llamadas Registradas", jPanel1);

        t_sesiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Operador", "centro Ecu", "Fecha"
            }
        ));
        jScrollPane13.setViewportView(t_sesiones);

        jLabel34.setText("Registro deLogueos De Operadores Ecu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel34)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel34)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sesiones Registradas", jPanel2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Menu Administrador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcedUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedUActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void AddEnArrayPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEnArrayPermisosActionPerformed
        int codigo = Integer.parseInt(ponIdPermiso.getText());
        PermisoDB p = new PermisoDB();
        Permiso uno;
        try {
            uno = p.buscar(codigo);
            if (uno != null) {
                permisosAgregados.add(uno);
                JOptionPane.showMessageDialog(null, "agregado");

            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddEnArrayPermisosActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtceduClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtceduClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtceduClientesActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void txtnumTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumTelefonoActionPerformed

    private void txtIdTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTelefonoActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void agregaPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregaPermisosActionPerformed
        if (txtnamePermisos.getText().equals("")) {
           throw new ValidacionCamposTextoExcepcion(this, "Debe llenar los campos de textopara poder agregar los permisos");
        } else {
            unpermiso.setDescripcion(txtnamePermisos.getText());
            boolean r = unpermiso.grabar();
            if (r == true) {
                JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
            } else if (r == false) {
                throw new ValidacionGrabacionDatos(null, "Error al Grabar el Permiso");
            }
            actualizapermisos();
        }
    }//GEN-LAST:event_agregaPermisosActionPerformed

    private void addEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntidadActionPerformed
        if (txtfonoEntidad.getText().equals("") || txtciudadEntidad.getText().equals("") || ponEntidad.getText().equals("")) {
          throw new ValidacionCamposTextoExcepcion(this, "Debe llenar los campos de texto para proceder a guardar datos");
        } else {
            Telefono minum = new Telefono();
            minum.setNumero(txtfonoEntidad.getText());
            boolean v = false;
               try {          
                    v = minum.buscarNumero();
                  } 
               catch (TelefonoVerificacionException ex) {
                   Logger.getLogger(ex.getMessage());
                 }
            if (v == true) {
                throw new TelefonoVerificacionException("el numero de telefono ya esta asignado a alguna Entidad o Cliente");
            } else {
                minum.setTipo("casa");
                try {
                    minum.grabar();
                } catch (TelefonoVerificacionException ex) {
                    Logger.getLogger(ex.getMessage());
                } catch (SQLException ex) {
                    Logger.getLogger(ex.getMessage());
                }
                actualizatelefonos();
                actualizaComboTelefonos();

                if (ponEntidad.getText().equalsIgnoreCase("Bomberos")) {
                    unaent = new EntidadBomberos();
                } else if (ponEntidad.getText().equalsIgnoreCase("CNT")) {
                    unaent = new EntidadCNT();
                } else if (ponEntidad.getText().equalsIgnoreCase("Policia")) {
                    unaent = new EntidadPolicia();
                } else if (ponEntidad.getText().equalsIgnoreCase("Cruz Roja")) {
                    unaent = new EntidadCruzRoja();
                } else if (ponEntidad.getText().equalsIgnoreCase("Fuerzas Armadas")) {
                    unaent = new EntidadFuerzasArmadas();
                }
                unaent.setCiudad(txtciudadEntidad.getText());
                    try {
                      minum.buscarNumero();//para recuperar el id del telefono para guardar en la entidad Cooperativa
                     } catch (TelefonoVerificacionException ex) {
                    Logger.getLogger(ex.getMessage());
                      }
                unaent.setMifono(minum);

                boolean r = unaent.grabar(ponEntidad.getText());
                if (r == true) {
                    JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
                } else if (r == false) {
                    throw new ValidacionGrabacionDatos(null, "Error al Grabar datos de la Entidad Cooperativa");
                }
            }
            actualizaEntidades();
            actualizaComboTelefonos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addEntidadActionPerformed

    private void comboPermisRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboPermisRolesMouseClicked
        StringTokenizer tokens = new StringTokenizer((String) comboPermisRoles.getSelectedItem(), ",");
        try {
            ponIdPermiso.setText(tokens.nextToken());
        } catch (NoSuchElementException e) {
        }
    }//GEN-LAST:event_comboPermisRolesMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (txtRolname.getText().equals("") || ponIdPermiso.getText().equals("")) {
            throw  new ValidacionCamposTextoExcepcion(this, "Debe llenar los campos de texto para guardar");
        } else {
            unrol.setDescripcion(txtRolname.getText());
            if (permisosAgregados != null) {
                unrol.setMispermisos(permisosAgregados);
                boolean r = unrol.grabar();
                if (r == true) {
                    JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
                } else if (r == false) {
                   throw new ValidacionGrabacionDatos(null, "Error al Grabar los datos del Rol");
                }

                unrol.buscarIde();
                rolP.setRolid(unrol.getId());
                for (int i = 0; i < permisosAgregados.size(); i++) {
                    Permiso otrop = new Permiso();
                    otrop = (Permiso) permisosAgregados.get(i);
                    rolP.setPermisoId(otrop.getId());
                    rolP.grabar();
                }
            }
            actualizaroles();
            permisosAgregados = null;

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t_rolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_rolesMouseClicked
        String rolid = (t_roles.getValueAt(t_roles.getSelectedRow(), 0).toString());

        ArrayList<Integer> mispermisos = new ArrayList<Integer>();
        rolP.setRolid(Integer.valueOf(rolid));
        mispermisos = rolP.buscarPermisos();

        DefaultTableModel temp = (DefaultTableModel) t_PermisosDRoles.getModel();
        for (int i = t_PermisosDRoles.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }

        if (mispermisos != null) {
            for (Integer i : mispermisos) {
                Permiso unp = new Permiso();
                //  unp = (Permiso) mispermisos.get(i);
                unp.setId(i);
                unp.buscarDescripcion();
                Object nuevo[] = {unp.getId(), unp.getDescripcion()};
                temp.addRow(nuevo);
            }
            t_PermisosDRoles.setModel(temp);
        } else {
           throw new ValidacionPermisosAsignados_RolExcepcion(this, "Este Rol no tiene permisos asignados");
        }

    }//GEN-LAST:event_t_rolesMouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (txtnumTelefono.getText().equals("") || txtTipoTelf.getText().equals("")) {
          throw new ValidacionCamposTextoExcepcion(this, "Debe llenar campos de texto primero");
        } else {
            JOptionPane.showMessageDialog(null, txtnumTelefono.getText() + txtTipoTelf.getText());
            untelefono.setNumero(txtnumTelefono.getText());
            untelefono.setTipo(txtTipoTelf.getText());
            boolean r = false;
            try {
                r = untelefono.grabar();
                 JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
            } catch (TelefonoVerificacionException ex) {
                Logger.getLogger(ex.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(ex.getMessage());
            }
           /* if (r == true) {
                JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
            } else if (r == false) {
                JOptionPane.showMessageDialog(null, "Error al Grabar datos");
            }*/

            //misclientes.agregarCliente(unpermiso);
            actualizatelefonos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClienteActionPerformed
        if (txtceduClientes.getText().equals("") || txtnameClientes.getText().equals("") || ponFonoCli.getText().equals("")) {
            throw new ValidacionCamposTextoExcepcion(null, "Debe llenar los campos de texto");
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
                boolean r = uncliente.grabar();
                if (r == true) {
                    JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
                } else if (r == false) {
                    throw new ValidacionGrabacionDatos(this, "Error al Grabar datos de Cliente");
                }
            }
            actualizaclientes();
            actualizaComboTelefonos();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addClienteActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        if (txtcedU.getText().equals("") || txtnameU.getText().equals("") || txtpassU.getText().equals("") || txtsueldoU.getText().equals("")) {
          throw new ValidacionCamposTextoExcepcion(this, "Primero debe llenar los campos de texto primero");
        } else {
            unopE.setCedula(txtcedU.getText());
            unopE.setNombres(txtnameU.getText());
            unopE.setPassw(txtpassU.getText());
            unopE.setSueldo(Double.parseDouble(txtsueldoU.getText()));
            boolean r = unopE.grabar();
            if (r == true) {
                JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
            } else if (r == false) {
               throw new ValidacionGrabacionDatos(this, "Error al Grabar datos de Operador Ecu");
            }
            actualizaOperadoresEcu();
        }
    }//GEN-LAST:event_addUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!auxIdEnt.getText().equals("")) {
            GestionTipoIncident_Entidades m = new GestionTipoIncident_Entidades(auxIdEnt.getText());
            JFrame k = new JFrame();
            k.add(m);
            k.setSize(500, 350);
            k.setVisible(true);
        } else {
          throw new SeleccionarTablaExcepcion(this, "Debe seleccionar una Entidad en la tabla, para gestionar sus Incidentes Permitidos");    
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_EntidadesCoopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_EntidadesCoopMouseClicked
        String EntidadId = (t_EntidadesCoop.getValueAt(t_EntidadesCoop.getSelectedRow(), 0).toString());
        auxIdEnt.setText(EntidadId);
    }//GEN-LAST:event_t_EntidadesCoopMouseClicked

    private void comboTipoEntiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTipoEntiMouseClicked
        StringTokenizer tokens = new StringTokenizer((String) comboTipoEnti.getSelectedItem(), ",");
        try {
            ponEntidad.setText(tokens.nextToken());
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_comboTipoEntiMouseClicked

    private void comboTelefonoCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTelefonoCliMouseClicked
        StringTokenizer tokens = new StringTokenizer((String) comboTelefonoCli.getSelectedItem(), ",");
        try {
            ponFonoCli.setText(tokens.nextToken());
        } catch (NoSuchElementException e) {
        }
    }//GEN-LAST:event_comboTelefonoCliMouseClicked

    private void comboRolesUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboRolesUMouseClicked
        StringTokenizer tokens = new StringTokenizer((String) comboRolesU.getSelectedItem(), ",");
        try {
            ponRolU.setText(tokens.nextToken());
        } catch (NoSuchElementException e) {
        }
    }//GEN-LAST:event_comboRolesUMouseClicked

    private void comboEntidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboEntidadesMouseClicked
        StringTokenizer tokens = new StringTokenizer((String) comboEntidades.getSelectedItem(), ",");
        try {
            ponEntidadId.setText(tokens.nextToken());
        } catch (NoSuchElementException e) {
        }
    }//GEN-LAST:event_comboEntidadesMouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void addTipoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTipoIActionPerformed
        if (nameTipoInc.getText().equals("")) {
            throw new ValidacionCamposTextoExcepcion(this, "Debe llenar los campos de texto primero");
        } else {
            untipoI.setDescripcion(nameTipoInc.getText());
            boolean r = untipoI.grabar();
            if (r == true) {
                JOptionPane.showMessageDialog(null, "Datos Grabados Satisfactoriamente...");
            } else if (r == false) {
                throw new ValidacionGrabacionDatos(null, "Error al Grabar datos de Tipo Incidente");
            }
            actualizatiposInc();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addTipoIActionPerformed

    private void comboTelefonosParaEntidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTelefonosParaEntidadesMouseClicked
        StringTokenizer tokens = new StringTokenizer((String) comboTelefonosParaEntidades.getSelectedItem(), ",");
        try {
            txtfonoEntidad.setText(tokens.nextToken());
        } catch (NoSuchElementException e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTelefonosParaEntidadesMouseClicked

    private void txtpassUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassUActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        unv.listarTipoIncidentes();
        ArrayList incidentes;
        incidentes = unv.getTiposInc();

        cboIncentesAlarma.removeAllItems();
        cboIncentesAlarma.addItem("");
        for (int i = 0; i < incidentes.size(); i++) {
            TipoIncidente auxIncidente;
            auxIncidente = (TipoIncidente) incidentes.get(i);
            cboIncentesAlarma.addItem(auxIncidente.getId() + ", " + auxIncidente.getDescripcion());
            //System.out.println(auxIncidente.getId());
        }

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void txtCedulaAlarmaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaAlarmaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtCedulaAlarma.getText().replace(" ", "").equals("")) {
                throw new ValidacionCamposTextoExcepcion(this, "Debe llenar los campos de texto primero");
            } else {

                uncliente.setCedula(txtCedulaAlarma.getText());
                if (uncliente.buscarCedula()) {
                    txtNombresAlarma.setText(uncliente.getNombres());
                } else {
                    throw new ValidaDatoInexistenteExcepcion(this, "Registre primero el Cliente");
                }
                actualizaclientes();
                actualizaComboTelefonos();
            }
        }
    }//GEN-LAST:event_txtCedulaAlarmaKeyPressed

    private void btnAddIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddIncidenteActionPerformed
        // TODO add your handling code here:
        txtAtender.setText(cboIncentesAlarma.getSelectedItem().toString().split(",")[1].replaceFirst(" ", ""));

    }//GEN-LAST:event_btnAddIncidenteActionPerformed

    private void btnAlertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertarActionPerformed
        String texto = "";
        String mensaje;
        String incidente = txtAtender.getText();
        Llamar llamar = null;
        if (txtCedulaAlarma.getText().replace(" ", "").equals("")) {
            throw new ExcepcionVerificarPersonaAfectada(this);
        } else if (txtAtender.getText().equals("")) {
            throw new ExcepcionVerificarAtenderIncidente(this);
        } else if (txtDireccionAlarma.getText().replace(" ", "").equals("")) {
            throw new ExcepcionVerificarDireccionIncidente(this);
        } else {
            ArrayList lista = new TipoIncidente().listar(cboProvincias.getSelectedItem().toString(), txtAtender.getText());

            if (listCentroLocal.contains(cboProvincias.getSelectedItem())) {
                llamar = new Llamar(lista, "local");
            } else if (listCentroNacional.contains(cboProvincias.getSelectedItem())) {
                llamar = new Llamar(lista, "nacional");
            } else if (listCentroZonal.contains(cboProvincias.getSelectedItem())) {
                llamar = new Llamar(lista, "zonal");
            }
            ArrayList lentidades = llamar.alertar();

            mensaje = "Atencion para el Cliente: " + txtNombresAlarma.getText()
                    + "\nA la siguiente direccion: " + txtDireccionAlarma.getText()
                    + "\nCon la siguiete informacion brindada: " + txtObservaciones.getText() + "\n" + "En la Provincia de "
                    + cboProvincias.getSelectedItem() + "\n\nPor el " + txtAtender.getText() + "\nAtendido por ";

            for (Object object : lentidades) {
                mensaje += object.toString() + " de " + cboProvincias.getSelectedItem() + "\n";
            }
            mensaje += "Entidades en camino...";
            txtNotificacion.setText(mensaje);
            Ubicacion_Incidente ubicacionIncidente = new Ubicacion_Incidente(txtDireccionAlarma.getText(),
                    txtObservaciones.getText(), cboProvincias.getSelectedItem().toString(),
                    new TipoIncidente(Integer.parseInt(cboIncentesAlarma.getSelectedItem().toString().split(",")[0]), cboIncentesAlarma.getSelectedItem().toString().split(",")[1]));
            ubicacionIncidente.grabar();
            JOptionPane.showMessageDialog(this, "Alarma Lanzada", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlertarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        GestionOperadoresEntidad m = new GestionOperadoresEntidad();
        JFrame k = new JFrame();
        k.add(m);
        k.setSize(580, 420);
        k.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtnameClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameClientesKeyPressed
    // TODO add your handling code here:
    }//GEN-LAST:event_txtnameClientesKeyPressed

    private void txtnameClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameClientesKeyTyped
	validaciones v=new validaciones();
        v.validaTexto(evt, txtnameClientes);
    }//GEN-LAST:event_txtnameClientesKeyTyped

    private void txtTipoTelfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoTelfKeyTyped
      validaciones v=new validaciones();
      v.validaTexto(evt, txtTipoTelf);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoTelfKeyTyped

    private void txtnamePermisosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamePermisosKeyTyped
      validaciones v=new validaciones();
      v.validaTexto(evt, txtnamePermisos);
    }//GEN-LAST:event_txtnamePermisosKeyTyped

    private void txtRolnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRolnameKeyTyped
      validaciones v=new validaciones();
      v.validaTexto(evt, txtRolname);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRolnameKeyTyped

    private void txtnameUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameUKeyTyped
    validaciones v=new validaciones();
    v.validaTexto(evt, txtnameU);
    }//GEN-LAST:event_txtnameUKeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
    validaciones v=new validaciones();
    v.validaTexto(evt,  jTextField8);
    }//GEN-LAST:event_jTextField8KeyTyped

    private void txtciudadEntidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtciudadEntidadKeyTyped
    validaciones v=new validaciones();
    v.validaTexto(evt,  txtciudadEntidad);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtciudadEntidadKeyTyped

    private void nameTipoIncKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTipoIncKeyTyped
   validaciones v=new validaciones();
    v.validaTexto(evt,  nameTipoInc);
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTipoIncKeyTyped

    private void txtceduClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtceduClientesKeyTyped
   
        // TODO add your handling code here:
    }//GEN-LAST:event_txtceduClientesKeyTyped

    private void txtceduClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtceduClientesKeyReleased
      
    }//GEN-LAST:event_txtceduClientesKeyReleased

    private void txtceduClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtceduClientesKeyPressed
      
      validaciones v=new validaciones();
      if (txtceduClientes.getText().length()==10){
      v.validaCedula(txtceduClientes.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_txtceduClientesKeyPressed
   }
    
    public void simularLlamada() {

    }

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
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdm().setVisible(true);
            }
        });
    }

    public void actualizaComboEntidades() {
        unv.listarEntidades();
        List misentidades = new ArrayList();
        misentidades = unv.getEntidades();
        comboEntidades.removeAllItems();
        comboEntidades.addItem("");
        //JOptionPane.showMessageDialog(null, misentidades.size());
        for (int i = 0; i < misentidades.size(); i++) {
            EntidadCooperativa otroTipo = new EntidadCooperativa() {

                @Override
                public String aceptar(Visitor visitor) {
                    return "";
                }
            };
            otroTipo = (EntidadCooperativa) misentidades.get(i);
            comboEntidades.addItem(otroTipo.getId() + ", " + otroTipo.getTipo());
        }
    }

    public void actualizaComboTelefonos() {
        List telfs = new ArrayList();

        unv.listarTelefonosDisponibles();
        telfs = unv.getTelfsDisponibles();
        comboTelefonoCli.removeAllItems();
        comboTelefonosParaEntidades.removeAllItems();
        comboTelefonoCli.addItem("");
        comboTelefonosParaEntidades.addItem("");
        for (int i = 0; i < telfs.size(); i++) {
            Telefono otroTipo = new Telefono();
            otroTipo = (Telefono) telfs.get(i);
            comboTelefonoCli.addItem(otroTipo.getId() + ", " + otroTipo.getNumero());
            comboTelefonosParaEntidades.addItem(otroTipo.getId() + ", " + otroTipo.getNumero());
        }
    }

    public void actualizaComboPermisos() {
        List tipositems = new ArrayList();
        tipositems = unv.getPermisos();
        comboPermisRoles.removeAllItems();
        comboPermisRoles.addItem("");
        for (int i = 0; i < tipositems.size(); i++) {
            Permiso otroTipo = new Permiso();
            otroTipo = (Permiso) tipositems.get(i);
            comboPermisRoles.addItem(otroTipo.getId() + ", " + otroTipo.getDescripcion());
        }
    }

    public void actualizaComboRoles() {
        List telfs = new ArrayList();
        telfs = unv.getRoles();
        comboRolesU.removeAllItems();
        comboRolesU.addItem("");
        for (int i = 0; i < telfs.size(); i++) {
            Rol otroTipo = new Rol();
            otroTipo = (Rol) telfs.get(i);
            comboRolesU.addItem(otroTipo.getId() + ", " + otroTipo.getDescripcion());
        }
    }

    public void actualizaOperadoresEcu() {
        unv.listarOperadoresEcu();
        ArrayList operads = new ArrayList();
        operads = unv.getOpEcus();
        DefaultTableModel temp = (DefaultTableModel) t_operadoresEcu.getModel();
        for (int i = t_operadoresEcu.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < operads.size(); i++) {
            OperadorEcu otrop = new OperadorEcu();
            otrop = (OperadorEcu) operads.get(i);
            Object nuevo[] = {otrop.getCedula(), otrop.getNombres(), otrop.getSueldo(), otrop.getUsuario()}; //esto es por las tres columnas aunque puede variar
            temp.addRow(nuevo);
        }
        t_operadoresEcu.setModel(temp);
    }

    public void actualizapermisos() {
        unv.listarPermisos();
        ArrayList permisos = new ArrayList();
        permisos = unv.getPermisos();
        DefaultTableModel temp = (DefaultTableModel) t_Permisos.getModel();
        for (int i = t_Permisos.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < permisos.size(); i++) {
            Permiso otrop = new Permiso();

            otrop = (Permiso) permisos.get(i);
            Object nuevo[] = {otrop.getId(), otrop.getDescripcion()}; //esto es por las tres columnas aunque puede variar
            temp.addRow(nuevo);
        }
        t_Permisos.setModel(temp);
    }

    public void actualizaroles() {
        unv.listarRoles();
        ArrayList roles = new ArrayList();
        roles = unv.getRoles();
        DefaultTableModel temp = (DefaultTableModel) t_roles.getModel();
        for (int i = t_roles.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < roles.size(); i++) {
            Rol otrop = new Rol();
            otrop = (Rol) roles.get(i);
            Object nuevo[] = {otrop.getId(), otrop.getDescripcion()}; //esto es por las tres columnas aunque puede variar
            temp.addRow(nuevo);
        }
        t_roles.setModel(temp);
    }

    public void actualizaEntidades() {
        unv.listarEntidades();
        ArrayList tlfs = new ArrayList();
        tlfs = unv.getEntidades();
        DefaultTableModel temp = (DefaultTableModel) t_EntidadesCoop.getModel();
        for (int i = t_EntidadesCoop.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < tlfs.size(); i++) {
            EntidadCooperativa otrop = new EntidadCooperativa() {

                @Override
                public String aceptar(Visitor visitor) {
                    return "";
                }
            };
            otrop = (EntidadCooperativa) tlfs.get(i);
            Telefono t = new Telefono();
            t.setId(otrop.getMifono().getId());
            try {
                t.buscarNumeroSegunIde();
            } catch (TelefonoVerificacionException ex) {
                Logger.getLogger(ex.getMessage());
            }
            String tipoEntidad = otrop.buscarEntidadHijo();
            Object nuevo[] = {otrop.getId(), otrop.getCiudad(), tipoEntidad, t.getNumero()}; //esto es por las tres columnas aunque puede variar
            temp.addRow(nuevo);
        }
        t_EntidadesCoop.setModel(temp);
    }

    public void actualizatiposInc() {
        unv.listarTipoIncidentes();
        ArrayList tlfs = new ArrayList();
        tlfs = unv.getTiposInc();
        DefaultTableModel temp = (DefaultTableModel) t_TipoIncidente.getModel();
        for (int i = t_TipoIncidente.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < tlfs.size(); i++) {
            TipoIncidente otrop = new TipoIncidente();
            otrop = (TipoIncidente) tlfs.get(i);
            Object nuevo[] = {otrop.getId(), otrop.getDescripcion()};
            temp.addRow(nuevo);
        }
        t_TipoIncidente.setModel(temp);
    }

    public void actualizaSesiones() {
        unv.listarSesiones();
        ArrayList sesiones = new ArrayList();
        sesiones = unv.getSesiones();
        DefaultTableModel temp = (DefaultTableModel) t_sesiones.getModel();
        for (int i = t_sesiones.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < sesiones.size(); i++) {
            Login otrop = new Login();
            otrop = (Login) sesiones.get(i);
            OperadorEcu operador = new OperadorEcu();
            operador.setCedula(otrop.getUsu().getCedula());

            operador.buscarPorCedula();
            String centroEcu = "";
            try {
                centroEcu = miEcu.buscar(operador.getMicentro().getId());
            } catch (SQLException ex) {
                Logger.getLogger(MenuAdm.class.getName()).log(Level.SEVERE, null, ex);
            }

            Object nuevo[] = {otrop.getUsu().getCedula(), operador.getNombres(), centroEcu, otrop.getFecha_inicio()}; //esto es por las tres columnas aunque puede variar
            temp.addRow(nuevo);
        }
        t_sesiones.setModel(temp);
    }

    public void actualizatelefonos() {
        unv.listarTelefonos();
        ArrayList tlfs = new ArrayList();
        tlfs = unv.getTelefonos();
        DefaultTableModel temp = (DefaultTableModel) t_telf.getModel();
        for (int i = t_telf.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < tlfs.size(); i++) {
            Telefono otrop = new Telefono();
            otrop = (Telefono) tlfs.get(i);
            Object nuevo[] = {otrop.getId(), otrop.getNumero(), otrop.getTipo()}; //esto es por las tres columnas aunque puede variar
            temp.addRow(nuevo);
        }
        t_telf.setModel(temp);
    }

    public void actualizaRegistroLlamadas() {
        unv.listarRegistrosLlamadas();
        ArrayList regs = new ArrayList();
        regs = unv.getMisregistros();
        DefaultTableModel temp = (DefaultTableModel) t_llamadasRegistradas.getModel();
        for (int i = t_llamadasRegistradas.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < regs.size(); i++) {
            Registro_LLamadas otrop = new Registro_LLamadas();
            otrop = (Registro_LLamadas) regs.get(i);
            Cliente cli = new Cliente();
            cli.setCedula(otrop.getCedula());
            cli.buscarCedula();
            Telefono unt = new Telefono();
            unt.setNumero(otrop.getTelefono());
            try {
                unt.buscarNumero();
            } catch (TelefonoVerificacionException ex) {
                Logger.getLogger(ex.getMessage());
            }
            Object nuevo[] = {otrop.getCedula(), cli.getNombres(), unt.getNumero(), unt.getTipo(), cli.getDireccion(), otrop.getFecha()}; //esto es por las tres columnas aunque puede variar
            temp.addRow(nuevo);
        }
        t_llamadasRegistradas.setModel(temp);
    }

    public void actualizaclientes() {
        unv.listarClientes();
        ArrayList tlfs = new ArrayList();
        tlfs = unv.getClientes();
        DefaultTableModel temp = (DefaultTableModel) t_listado_clientes.getModel();
        for (int i = t_listado_clientes.getRowCount() - 1; i >= 0; i--) {
            temp.removeRow(i);
        }
        for (int i = 0; i < tlfs.size(); i++) {
            Cliente otrop = new Cliente();
            otrop = (Cliente) tlfs.get(i);
            Telefono t = new Telefono();
            t.setId(otrop.getMifono().getId());
            try {
                t.buscarNumeroSegunIde();
            } catch (TelefonoVerificacionException ex) {
                Logger.getLogger(ex.getMessage());
            }

            Object nuevo[] = {otrop.getCedula(), otrop.getNombres(), null, t.getNumero()/*otrop.getMifono().getId()*/}; //esto es por las tres columnas aunque puede variar
            temp.addRow(nuevo);
        }
        t_listado_clientes.setModel(temp);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddEnArrayPermisos;
    private javax.swing.JButton addCliente;
    private javax.swing.JButton addEntidad;
    private javax.swing.JButton addTipoI;
    private javax.swing.JButton addUser;
    private javax.swing.JButton agregaPermisos;
    private javax.swing.JLabel auxIdEnt;
    private javax.swing.JButton btnAddIncidente;
    private javax.swing.JButton btnAlertar;
    private javax.swing.JComboBox cboIncentesAlarma;
    private javax.swing.JComboBox cboProvincias;
    private javax.swing.JComboBox comboEntidades;
    private javax.swing.JComboBox comboPermisRoles;
    private javax.swing.JComboBox comboRolesU;
    private javax.swing.JComboBox comboTelefonoCli;
    private javax.swing.JComboBox comboTelefonosParaEntidades;
    private javax.swing.JComboBox comboTipoEnti;
    private javax.swing.JTextField idTipoInc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField nameTipoInc;
    private javax.swing.JPanel panelAlarmas;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelEntidadesCooperativas;
    private javax.swing.JPanel panelOperadoresEcu911;
    private javax.swing.JPanel panelPermisos;
    private javax.swing.JPanel panelRoles;
    private javax.swing.JPanel panelTelefonos;
    private javax.swing.JPanel panelTipoIncidentes;
    private javax.swing.JLabel ponEntidad;
    private javax.swing.JLabel ponEntidadId;
    private javax.swing.JLabel ponFonoCli;
    private javax.swing.JLabel ponIdPermiso;
    private javax.swing.JLabel ponRolU;
    private javax.swing.JTable t_EntidadesCoop;
    private javax.swing.JTable t_Permisos;
    private javax.swing.JTable t_PermisosDRoles;
    private javax.swing.JTable t_TipoIncidente;
    private javax.swing.JTable t_listado_clientes;
    private javax.swing.JTable t_llamadasRegistradas;
    private javax.swing.JTable t_operadoresEcu;
    private javax.swing.JTable t_roles;
    private javax.swing.JTable t_sesiones;
    private javax.swing.JTable t_telf;
    private javax.swing.JTextField txtAtender;
    private javax.swing.JTextField txtCedulaAlarma;
    private javax.swing.JTextArea txtDireccionAlarma;
    private javax.swing.JTextField txtIdPermisos;
    private javax.swing.JTextField txtIdTelefono;
    private javax.swing.JTextField txtNombresAlarma;
    private javax.swing.JTextArea txtNotificacion;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtRolid;
    private javax.swing.JTextField txtRolname;
    private javax.swing.JTextField txtTipoTelf;
    private javax.swing.JTextField txtcedU;
    private javax.swing.JTextField txtceduClientes;
    private javax.swing.JTextField txtciudadEntidad;
    private javax.swing.JTextField txtfonoEntidad;
    private javax.swing.JTextField txtidEntidad;
    private javax.swing.JTextField txtnameClientes;
    private javax.swing.JTextField txtnamePermisos;
    private javax.swing.JTextField txtnameU;
    private javax.swing.JTextField txtnumTelefono;
    private javax.swing.JPasswordField txtpassU;
    private javax.swing.JTextField txtsueldoU;
    // End of variables declaration//GEN-END:variables
}
