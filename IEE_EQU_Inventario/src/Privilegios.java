/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franciscoemanuelcardenasramos
 */
public class Privilegios extends javax.swing.JFrame {

    conectar cc = new conectar();
    Connection cn = cc.conexion();
    
    /**
     * Creates new form Privilegios
     */
    public Privilegios() {
        initComponents();
        setLocationRelativeTo(null);
        mostrartabla();
        mostrarcomboarea();
        mostrarcombopuesto();

        
    }

    void mostrartabla(){
       
            DefaultTableModel modelo= new DefaultTableModel();
            modelo.addColumn("idPersona");
            modelo.addColumn("Nombre");
            
            tabladatos.setModel(modelo);
            
            String sql="SELECT idPersona,Nombre_Per FROM Persona";
            
            String datos[] = new String [2];
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos [0]=rs.getString(1);
                 datos [1]=rs.getString(2);
                 
            modelo.addRow(datos);
            }
            tabladatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
    
    
     
     
     
    void mostrarcomboarea(){
       
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           
            cmbarea.setModel(modelo);
            String p = cmbpuesto.getSelectedItem().toString();
           String sql="SELECT Area_Pues FROM Puestos WHERE Nom_Pues = '"+p+ "'        ";
            //String sql = "SELECT Area_Pues FROM personas GROPU BY Area_Pues"   ;
            
            ArrayList datos[] = new ArrayList [1];
           modelo.addElement("Seleccione un Area");
            cmbarea.setModel(modelo);
            
            try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                modelo.addElement(rs.getObject("Area_Pues"));
                cmbarea.setModel(modelo);
                 
            
            }
            cmbarea.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
     
    
void mostrarcombopuesto(){
       
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            
             String a = cmbarea.getSelectedItem().toString();
            cmbpuesto.setModel(modelo2);
            
            
            String sql="SELECT Nom_Pues FROM Puestos GROUP BY Nom_Pues" ;
            
            ArrayList datos2[] = new ArrayList [1];
           modelo2.addElement("Seleccione un Puesto");
            cmbpuesto.setModel(modelo2);
            
            try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                modelo2.addElement(rs.getObject("Nom_Pues"));
                cmbpuesto.setModel(modelo2);
                 
            
            }
            cmbpuesto.setModel(modelo2);
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtpaterno = new javax.swing.JTextField();
        txtmaterno = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtcalle = new javax.swing.JTextField();
        txtcolonia = new javax.swing.JTextField();
        txtcp = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtmaterno1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtnolic = new javax.swing.JTextField();
        txtcred = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtrfc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbarea = new javax.swing.JComboBox<String>();
        cmbpuesto = new javax.swing.JComboBox<String>();
        jLabel20 = new javax.swing.JLabel();
        cmbtusuario = new javax.swing.JComboBox<String>();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner.png"))); // NOI18N

        jLabel1.setText("Buscar:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabladatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Usuarios", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));

        jLabel7.setText("Nombre");

        jLabel8.setText("Ap. Panterno");

        jLabel9.setText("Ap. Materno");

        txtnombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombreFocusLost(evt);
            }
        });

        txtpaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpaternoFocusLost(evt);
            }
        });

        txtmaterno.setToolTipText("");

        jSeparator2.setToolTipText("Direccion");

        jLabel10.setText("Calle");

        jLabel12.setText("Colonia");

        jLabel13.setText("CP");

        txtcalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcalleFocusLost(evt);
            }
        });
        txtcalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcalleKeyReleased(evt);
            }
        });

        txtcolonia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcoloniaFocusLost(evt);
            }
        });

        txtcp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcpFocusLost(evt);
            }
        });
        txtcp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcpKeyPressed(evt);
            }
        });

        jButton6.setText("Limpiar");

        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("TODOS LOS CAMPOS OBLIGATORIOS");

        jLabel11.setText("CURP");

        txtmaterno1.setToolTipText("");

        jLabel14.setText("Telefono");

        txttelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttelefonoFocusLost(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefonoKeyPressed(evt);
            }
        });

        jLabel16.setText("NoLic");

        txtnolic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnolicFocusLost(evt);
            }
        });
        txtnolic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnolicKeyPressed(evt);
            }
        });

        txtcred.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcredFocusLost(evt);
            }
        });
        txtcred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcredKeyPressed(evt);
            }
        });

        jLabel17.setText("# Credencial");

        jSeparator5.setToolTipText("Direccion");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnolic, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                            .addComponent(txtcred)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcalle, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                            .addComponent(txtcp)
                            .addComponent(txtcolonia)
                            .addComponent(txttelefono)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmaterno1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnombre)
                                .addComponent(txtpaterno)
                                .addComponent(txtmaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtpaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtmaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtmaterno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtnolic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtcred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Agregar", jPanel1);

        jLabel23.setText("Contraseña");

        txtcontraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontraseñaFocusLost(evt);
            }
        });

        jLabel4.setText("Sueldo");

        txtrfc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrfcFocusLost(evt);
            }
        });

        jLabel15.setText("RFC");

        jLabel18.setText("Area");

        jLabel19.setText("Puesto");

        cmbarea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escoja uno", "Direccion", "Informatica", "Administración" }));
        cmbarea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbareaItemStateChanged(evt);
            }
        });
        cmbarea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbareaFocusLost(evt);
            }
        });
        cmbarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbareaActionPerformed(evt);
            }
        });

        cmbpuesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar area" }));
        cmbpuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbpuestoItemStateChanged(evt);
            }
        });
        cmbpuesto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbpuestoFocusLost(evt);
            }
        });
        cmbpuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbpuestoMouseClicked(evt);
            }
        });
        cmbpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpuestoActionPerformed(evt);
            }
        });

        jLabel20.setText("Tipo de Usuario");

        cmbtusuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Comun", "Administrador" }));
        cmbtusuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtusuarioItemStateChanged(evt);
            }
        });
        cmbtusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbtusuarioFocusLost(evt);
            }
        });
        cmbtusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbtusuarioMouseClicked(evt);
            }
        });
        cmbtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtusuarioActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(103, 103, 103)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtrfc, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtcontraseña)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbarea, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtrfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cmbarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cmbpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(btnAgregar)
                .addGap(0, 140, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Empleado", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(372, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(160, 160, 160)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(435, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void txtcontraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontraseñaFocusLost
        // TODO add your handling code here:
        //esNulo(txtcontraseña.getText(),txtcontraseña);
    }//GEN-LAST:event_txtcontraseñaFocusLost

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String nombre,appat,apmat,calle,id,colonia,cp,usuario,contraseña,telefono,rfc,nolic,nocred,area,puesto,sueldo;
        String sql="",sql2="",sql3="",sql4="";

        nombre = txtnombre.getText();
        appat = txtpaterno.getText();
        apmat= txtmaterno.getText();
        calle=txtcalle.getText();
        colonia= txtcolonia.getText();
        cp=txtcp.getText();
        telefono=txttelefono.getText();
        nolic= txtnolic.getText();
        nocred= txtcred.getText();
        sueldo=txtsueldo.getText();
        contraseña= txtcontraseña.getText();
        usuario=cmbtusuario.getSelectedItem()+"";
        puesto=cmbarea.getSelectedIndex()+"";

        rfc=txtrfc.getText();

        
        int idpersona1;

        sql="INSERT INTO Persona (Nombre_Per,Ape_Pat_Per,Ape_Mat_Per,Calle_Per,Colonia_Per,CP_Per,Tel_Per,NoLic_Per,NoCred_Per) VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst= cn.prepareStatement(sql);

            pst.setString( 1,nombre );
            pst.setString( 2,appat);
            pst.setString( 3,apmat );
            pst.setString( 4,calle);
            pst.setString( 5,colonia );
            pst.setString( 6,cp);
            pst.setString( 7,telefono );
            pst.setString( 8,nolic);
            pst.setString( 9,nocred);

            int n=pst.executeUpdate();
            if(n>0){JOptionPane.showMessageDialog(null, "Se inserto en tabla:Persona");}

        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);

        }
         mostrartabla();
         
                 sql4="INSERT INTO Empleado (RFC_Emp,sueldo_Emp,Puestos_idPuesto,Persona_idPersona) VALUES(?,?,?,?)";

        try{
            //String idpersona ="SELECT idPersona FROM Persona WHERE Nombre_Per ='"+nombre+"' and Ape_Pat_Per = '"+appat+"' and Ape_Mat_Per = '"+apmat+"' ";
            // String idpuesto = "SELECT idPuesto FROM Puestos WHERE Nom_Pues ='"+p+"' and Area_Pues = '"+a+"' ";
           // String idpersona ="SELECT idPersona FROM Persona WHERE idPersona = (SELECT MAX(idPersona) from Persona)";
            String a = cmbarea.getSelectedItem().toString();
            String p = cmbpuesto.getSelectedItem().toString();
            String f;
            Statement statement = cn.createStatement();
            
int idpue1=tabladatos.getRowCount();
f=tabladatos.getValueAt(idpue1-1,0)+"";


            ResultSet idper = statement.executeQuery("SELECT idPersona FROM Persona WHERE idPersona = (SELECT MAX(idPersona) from Persona)");
            String idpersona=f;
            PreparedStatement pst= cn.prepareStatement(sql4);

            pst.setString( 1,rfc );
            pst.setString( 2,sueldo);
            pst.setString( 3,puesto);
            pst.setString( 4,idpersona );
            
            int n=pst.executeUpdate();
            if(n>0){JOptionPane.showMessageDialog(null, "Se inserto en tabla:Empleado");}
            
           // Statement statement = cn.createStatement();
/*
            ResultSet obteneridpue2 = statement.executeQuery("SELECT idPuesto FROM Puestos WHERE Nom_Pues ='"+p+"' and Area_Pues = '"+a+"' ");
            ResultSet obteneridpersona = statement.executeQuery("SELECT idPersona FROM Persona WHERE Nombre_Per ='"+nombre+"' and Ape_Pat_Per = '"+appat+"' and Ape_Mat_Per = '"+apmat+"' ");
            while (obteneridpersona.next() ) {
                idpersona1= obteneridpersona.getInt(1);

                ResultSet insertar = statement.executeQuery("INSERT INTO Empleado (RFC_Emp,sueldo_Emp,Persona_idPersona) VALUES('"+ rfc+"','"+sueldo+"','"+idpersona1+"')");

            }
            while (obteneridpue2.next() ) {
                idpue1= obteneridpersona.getInt(1);

                ResultSet insertar = statement.executeQuery("INSERT INTO Empleado (RFC_Emp,sueldo_Emp,Puestos_idPuesto) VALUES('"+ rfc+"','"+sueldo+"','"+ idpue1 +"')");

            }
*/
        }

        catch (NumberFormatException nfe) {

        }
        catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);

        }
sql3="INSERT INTO Usuario (Password_Usr,Tipo_Usr,Empleado_RFC_Emp) VALUES(?,?,?)";
        try{
            PreparedStatement pst= cn.prepareStatement(sql3);

            pst.setString( 1,contraseña );
            pst.setString( 2,usuario);
            pst.setString( 3,rfc );
           

            int n=pst.executeUpdate();
            if(n>0){JOptionPane.showMessageDialog(null, "Se inserto en tabla:Usuario");}

        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);

        }
        mostrartabla();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpuestoActionPerformed
        mostrarcomboarea();

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuestoActionPerformed

    private void cmbpuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbpuestoMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuestoMouseClicked

    private void cmbpuestoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbpuestoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuestoFocusLost

    private void cmbpuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbpuestoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuestoItemStateChanged

    private void cmbareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbareaActionPerformed
    
    }//GEN-LAST:event_cmbareaActionPerformed

    private void cmbareaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbareaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbareaFocusLost

    private void cmbareaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbareaItemStateChanged
        // TODO add your handling code here:
        //cmbInit();
    }//GEN-LAST:event_cmbareaItemStateChanged

    private void txtcredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcredKeyPressed
        // TODO add your handling code here:
        //tieneNum(evt.getKeyChar(),txtcred);
    }//GEN-LAST:event_txtcredKeyPressed

    private void txtcredFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcredFocusLost
        // TODO add your handling code here:
        //esNulo(txtcred.getText(),txtcred);
    }//GEN-LAST:event_txtcredFocusLost

    private void txtrfcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrfcFocusLost
        //esNulo(txtrfc.getText(),txtrfc);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrfcFocusLost

    private void txtnolicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnolicKeyPressed
        // TODO add your handling code here:
        //tieneNum(evt.getKeyChar(),txtnolic);
    }//GEN-LAST:event_txtnolicKeyPressed

    private void txtnolicFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnolicFocusLost
        // TODO add your handling code here:
        //esNulo(txtnolic.getText(),txtnolic);
    }//GEN-LAST:event_txtnolicFocusLost

    private void txttelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyPressed
        // TODO add your handling code here:
        //tieneNum(evt.getKeyChar(),txttelefono);
    }//GEN-LAST:event_txttelefonoKeyPressed

    private void txttelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefonoFocusLost
        // TODO add your handling code here:
        //esNulo(txttelefono.getText(),txttelefono);
    }//GEN-LAST:event_txttelefonoFocusLost

    private void txtcpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpKeyPressed
        // TODO add your handling code here:
        //tieneNum(evt.getKeyChar(),txtcp);
    }//GEN-LAST:event_txtcpKeyPressed

    private void txtcpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcpFocusLost
        // TODO add your handling code here:
        //esNulo(txtcp.getText(),txtcp);
    }//GEN-LAST:event_txtcpFocusLost

    private void txtcoloniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcoloniaFocusLost
        // TODO add your handling code here:
        //esNulo(txtcolonia.getText(),txtcolonia);
    }//GEN-LAST:event_txtcoloniaFocusLost

    private void txtcalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcalleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalleKeyReleased

    private void txtcalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcalleFocusLost
        // TODO add your handling code here:
        //esNulo(txtcalle.getText(),txtcalle);
    }//GEN-LAST:event_txtcalleFocusLost

    private void txtpaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpaternoFocusLost
        // TODO add your handling code here:
        //esNulo(txtpaterno.getText(),txtpaterno);
    }//GEN-LAST:event_txtpaternoFocusLost

    private void txtnombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreFocusLost
        // TODO add your handling code here:
        //  esNulo(txtnombre.getText(),txtnombre);
    }//GEN-LAST:event_txtnombreFocusLost

    private void cmbtusuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtusuarioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioItemStateChanged

    private void cmbtusuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbtusuarioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioFocusLost

    private void cmbtusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtusuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioMouseClicked

    private void cmbtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioActionPerformed

  
    
    
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
            java.util.logging.Logger.getLogger(Privilegios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Privilegios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Privilegios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Privilegios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Privilegios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cmbarea;
    private javax.swing.JComboBox<String> cmbpuesto;
    private javax.swing.JComboBox<String> cmbtusuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcalle;
    private javax.swing.JTextField txtcolonia;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtcp;
    private javax.swing.JTextField txtcred;
    private javax.swing.JTextField txtmaterno;
    private javax.swing.JTextField txtmaterno1;
    private javax.swing.JTextField txtnolic;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpaterno;
    private javax.swing.JTextField txtrfc;
    private javax.swing.JTextField txtsueldo;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
