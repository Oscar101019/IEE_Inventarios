/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
        mostrartabla2();
        mostrarcomboarea();
        mostrarcombopuesto();
        tipoUsuario();

        jTable1.setVisible(false);
        jTabbedPane2.setEnabledAt(2,false);
        jTabbedPane3.setEnabledAt(1,false);
        jTabbedPane4.setEnabledAt(1,false);
       
    
    }
    
    public int obtenerIdPer(JTextField txtcurp/**/){
    int resultado=0;
    String valor= txtcurp.getText();
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerId = statement.executeQuery("SELECT idPersona FROM Persona WHERE Curp_Per='"+valor+"'");
            while (obtenerId.next()) {
                resultado=obtenerId.getInt(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
} 
    
    public int obtenerIdPuesto(JComboBox cmbpuesto/**/){
    int resultado=0;
    String valor= cmbpuesto.getSelectedItem().toString();
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerId = statement.executeQuery("SELECT idPuesto FROM Puestos WHERE Nom_Pues='"+valor+"'");
            while (obtenerId.next()) {
                resultado=obtenerId.getInt(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
    public int obtenerIdTusuario(JComboBox cmbtusuario/**/){
    int resultado=0;
    String valor= cmbtusuario.getSelectedItem().toString();
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerId = statement.executeQuery("SELECT idTipo_Usr FROM tipo_usr WHERE Nombre_TipoUsr='"+valor+"'");
            while (obtenerId.next()) {
                resultado=obtenerId.getInt(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
     
    
    public void insertarPersona(JTextField Nombre,JTextField Paterno,JTextField Materno,JTextField CURP,JTextField Calle,JTextField Colonia,JTextField CP,JTextField Telefono,JTextField NoLic,JTextField Cred){
    String nombre= Nombre.getText();
    String paterno = Paterno.getText();
    String materno = Materno.getText();
    String curp = CURP.getText();
    String calle = Calle.getText();
    String colonia = Colonia.getText();
    String cp = CP.getText();
    String tel = Telefono.getText();
    String lic = NoLic.getText();
    String cred = Cred.getText();
   
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("INSERT INTO Persona(Nombre_Per,Ape_Pat_Per,Ape_Mat_Per,Curp_Per,Calle_Per,Colonia_Per,CP_Per,Tel_Per,NoLic_Per,NoCred_Per) VALUES ('"+nombre+"','"+paterno+"','"+materno+"','"+curp+"','"+calle+"','"+colonia+"',"+cp+","+tel+","+lic+","+cred+")");            
    
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}
    public void actualizarPersona(JTextField Nombre,JTextField Paterno,JTextField Materno,JTextField CURP,JTextField Calle,JTextField Colonia,JTextField CP,JTextField Telefono,JTextField NoLic,JTextField Cred){
    String nombre= Nombre.getText();
    String paterno = Paterno.getText();
    String materno = Materno.getText();
    String curp = CURP.getText();
    String calle = Calle.getText();
    String colonia = Colonia.getText();
    String cp = CP.getText();
    String tel = Telefono.getText();
    String lic = NoLic.getText();
    String cred = Cred.getText();
   int idd =obtenerIdPer(txtcurp2);
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("UPDATE Persona SET Nombre_Per='"+nombre+"',Ape_Pat_Per='"+paterno+"',Ape_Mat_Per='"+materno+"',Curp_Per='"+curp+"',Calle_Per='"+calle+"',Colonia_Per='"+colonia+"',CP_Per='"+cp+"',Tel_Per='"+tel+"',NoLic_Per='"+lic+"',NoCred_Per='"+cred+"'\n" +
"WHERE idPersona='"+idd+"'");            
    
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

 public void eliminarPersona(){
    int idd =obtenerIdPer(txtcurp2);
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("DELETE FROM Persona WHERE idPersona='"+idd+"'");            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}
    
public void insertarEmpleado(JTextField RFC,JTextField Sueldo){
    String rfc=RFC.getText();
    String sueldo = Sueldo.getText();
    int idper=obtenerIdPer(txtcurp);
    int idpues = obtenerIdPuesto(cmbpuesto);
    
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("INSERT INTO Empleado(RFC_Emp,sueldo_Emp,Puestos_idPuesto,Persona_idPersona) VALUES ('"+rfc+"',"+sueldo+","+idpues+","+idper+")");            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void actualizarEmpleado(JTextField RFC,JTextField Sueldo){
    String rfc=RFC.getText();
    String sueldo = Sueldo.getText();
   int idpues = obtenerIdPuesto(cmbpuesto2);
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("UPDATE Empleado SET sueldo_Emp='"+sueldo+"',Puestos_idPuesto='"+idpues+"'\n" +
"WHERE RFC_Emp='"+rfc+"'");            
    
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void eliminarEmpleado(JTextField RFC){
    String rfc=RFC.getText();
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("DELETE FROM Empleado WHERE RFC_Emp='"+rfc+"'");            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void insertarUsuario(JTextField RFC,JTextField Contraseña){
    String usuario=RFC.getText();
    String contraseña = Contraseña.getText();
    int idtusuario = obtenerIdTusuario(cmbtusuario);
    
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("INSERT INTO Usuario(Password_Usr,Empleado_RFC_Emp,Tipo_Usr_idTipo_Usr) VALUES ('"+contraseña+"','"+usuario+"',"+idtusuario+")");            

    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void actualizarUsuario(JTextField RFC,JTextField Contraseña){
    String usuario=RFC.getText();
    String contraseña = Contraseña.getText();
    int idtusuario = obtenerIdTusuario(cmbtusuario2);
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("UPDATE Usuario SET Password_Usr='"+contraseña+"',Tipo_Usr_idTipo_Usr='"+idtusuario+"'\n" +
"WHERE Empleado_RFC_Emp='"+usuario+"'");            
    
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void eliminarUsuario(JTextField RFC){
    String usuario=RFC.getText();
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("DELETE FROM Usuario WHERE Empleado_RFC_Emp='"+usuario+"'");            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

    void mostrartabla(){
       
            DefaultTableModel modelo= new DefaultTableModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Usuario");
            modelo.addColumn("Tipo-Usuario");
            
            tabladatos.setModel(modelo);
            
            String sql="SELECT CONCAT(persona.Nombre_Per,' ',persona.Ape_Pat_Per, ' ',persona.Ape_Mat_Per) as Nombre , usuario.Empleado_RFC_Emp, tipo_usr.Nombre_TipoUsr FROM usuario\n" +
"INNER JOIN tipo_usr ON tipo_usr.idTipo_Usr=usuario.Tipo_Usr_idTipo_Usr\n" +
"INNER JOIN empleado ON empleado.RFC_Emp=usuario.Empleado_RFC_Emp\n" +
"INNER JOIN persona ON persona.idPersona=empleado.Persona_idPersona";
            
            
            String datos[] = new String [3];
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos [0]=rs.getString(1);
                 datos [1]=rs.getString(2);
                 datos [2]=rs.getString(3);
                 
            modelo.addRow(datos);
            }
            tabladatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
    
      void mostrarPersona(int valor){
       
           
            
            String sql="SELECT * FROM Persona WHERE idPersona="+valor+"";
            
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
               txtnombre2.setText(rs.getString(2));
               txtpaterno2.setText(rs.getString(3));
               txtmaterno2.setText(rs.getString(4));
               txtcurp2.setText(rs.getString(5));
               txtcalle2.setText(rs.getString(7));
               txtcolonia2.setText(rs.getString(8));
               txtcp2.setText(rs.getString(9));
               txttelefono2.setText(rs.getString(10));
               txtnolic2.setText(rs.getString(11));
               txtcred2.setText(rs.getString(12));
                       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
      
      void mostrarEmpleado(String RFC){
       
           
            
            String sql="SELECT * FROM Empleado WHERE RFC_Emp='"+RFC+"'";
            
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            int idp=0;
            int idpu=0;
            int idu=0;
            while(rs.next()){
               txtrfc2.setText(rs.getString(1));
               txtsueldo2.setText(rs.getString(2));
               idp=Integer.parseInt(rs.getString(5));
               idpu=Integer.parseInt(rs.getString(4));
               mostrarPersona(idp);
               mostrartusuario(RFC);
                       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
         void mostrartusuario(String id){
       
            String sql="SELECT * FROM Usuario WHERE Empleado_RFC_Emp='"+id+"'";
            
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            int idu=0;
            while(rs.next()){
              idu=Integer.parseInt(rs.getString(4));  
              txtcontraseña2.setText(rs.getString(2));
            }
            cmbtusuario2.setSelectedIndex(idu);
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    void mostrartabla2(){
       
            DefaultTableModel modelo= new DefaultTableModel();
            modelo.addColumn("idPersona");
            modelo.addColumn("Nombre");
            
            jTable1.setModel(modelo);
            
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
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
    
    
     
     
     
    void mostrarcomboarea(){
       
           
    
    
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           
            cmbarea.setModel(modelo);
             cmbarea2.setModel(modelo);
           
           String sql="SELECT Area_Pues FROM Puestos GROUP BY Area_Pues       ";
            
            
            ArrayList datos[] = new ArrayList [1];
           modelo.addElement("Seleccione un Area");
            cmbarea.setModel(modelo);
            cmbarea2.setModel(modelo);
            try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                modelo.addElement(rs.getObject("Area_Pues"));
                cmbarea.setModel(modelo);
                cmbarea2.setModel(modelo);
                 
            
            }
            cmbarea.setModel(modelo);
            cmbarea2.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     
    
void mostrarcombopuesto(){
       
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            
             String a = cmbarea.getSelectedItem().toString();
            cmbpuesto.setModel(modelo2);
            cmbpuesto2.setModel(modelo2);
            
            
            String sql="SELECT Nom_Pues FROM Puestos  where Area_Pues = '"+ a+"'   " ;
            
            ArrayList datos2[] = new ArrayList [1];
           modelo2.addElement("Seleccione un Puesto");
            cmbpuesto.setModel(modelo2);
            cmbpuesto2.setModel(modelo2);
            
            try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                modelo2.addElement(rs.getObject("Nom_Pues"));
                cmbpuesto.setModel(modelo2);
                cmbpuesto2.setModel(modelo2);
                 
            
            }
            cmbpuesto.setModel(modelo2);
            cmbpuesto2.setModel(modelo2);
        } catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
    

void tipoUsuario(){
        try {
            Statement statement = cn.createStatement();
            ResultSet usuario = statement.executeQuery("SELECT Nombre_TipoUsr FROM Tipo_Usr");
            while (usuario.next()) {
                cmbtusuario.addItem(usuario.getString(1));
                cmbtusuario2.addItem(usuario.getString(1));
            }//FIN WHILE
        }catch (SQLException ex) {
            Logger.getLogger(Privilegios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
void limpiar(){
txtnombre.setText("");
txtpaterno.setText("");
txtmaterno.setText("");
txtcurp.setText("");
txtcalle.setText("");
txtcolonia.setText("");
txtcp.setText("");
txttelefono.setText("");
txtnolic.setText("");
txtcred.setText(""); 
txtrfc.setText("");
txtsueldo.setText("");
txtcontraseña.setText("");
cmbarea.setSelectedIndex(0);
cmbpuesto.setSelectedIndex(0);
cmbtusuario.setSelectedIndex(0);
txtnombre2.setText("");
txtpaterno2.setText("");
txtmaterno2.setText("");
txtcurp2.setText("");
txtcalle2.setText("");
txtcolonia2.setText("");
txtcp2.setText("");
txttelefono2.setText("");
txtnolic2.setText("");
txtcred2.setText(""); 
txtrfc2.setText("");
txtsueldo2.setText("");
txtcontraseña2.setText("");
cmbarea2.setSelectedIndex(0);
cmbpuesto2.setSelectedIndex(0);
cmbtusuario2.setSelectedIndex(0);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtpaterno = new javax.swing.JTextField();
        txtmaterno = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtcalle = new javax.swing.JTextField();
        txtcolonia = new javax.swing.JTextField();
        txtcp = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtcurp = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtnolic = new javax.swing.JTextField();
        txtcred = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        btnSiguiente1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtrfc = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cmbarea = new javax.swing.JComboBox<String>();
        cmbpuesto = new javax.swing.JComboBox<String>();
        jLabel39 = new javax.swing.JLabel();
        cmbtusuario = new javax.swing.JComboBox<String>();
        btnAgregar1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtnombre2 = new javax.swing.JTextField();
        txtpaterno2 = new javax.swing.JTextField();
        txtmaterno2 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtcalle2 = new javax.swing.JTextField();
        txtcolonia2 = new javax.swing.JTextField();
        txtcp2 = new javax.swing.JTextField();
        btnLimpiar2 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtcurp2 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txttelefono2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtnolic2 = new javax.swing.JTextField();
        txtcred2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        btnSiguiente2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        txtcontraseña2 = new javax.swing.JTextField();
        txtsueldo2 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtrfc2 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        cmbarea2 = new javax.swing.JComboBox<String>();
        cmbpuesto2 = new javax.swing.JComboBox<String>();
        jLabel57 = new javax.swing.JLabel();
        cmbtusuario2 = new javax.swing.JComboBox<String>();
        btnAgregar2 = new javax.swing.JButton();

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
        tabladatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabladatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabladatos);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(82, 82, 82)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jButton1)
                        .addComponent(btnModificar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Usuarios", jPanel2);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));

        jLabel21.setText("Nombre");

        jLabel22.setText("Ap. Paterno");

        jLabel24.setText("Ap. Materno");

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

        jSeparator3.setToolTipText("Direccion");

        jLabel25.setText("Calle");

        jLabel26.setText("Colonia");

        jLabel27.setText("CP");

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

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("TODOS LOS CAMPOS OBLIGATORIOS");

        jLabel28.setText("CURP");

        txtcurp.setToolTipText("");

        jLabel29.setText("Telefono");

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

        jLabel30.setText("NoLic");

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

        jLabel31.setText("# Credencial");

        jSeparator6.setToolTipText("Direccion");

        btnSiguiente1.setText("Siguiente");
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnSiguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnolic, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                            .addComponent(txtcred)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcalle, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                            .addComponent(txtcp)
                            .addComponent(txtcolonia)
                            .addComponent(txttelefono)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcurp, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnombre)
                                .addComponent(txtpaterno)
                                .addComponent(txtmaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtpaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtmaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtcurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtnolic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtcred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSiguiente1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Persona", jPanel6);

        jLabel32.setText("Contraseña");

        txtcontraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontraseñaFocusLost(evt);
            }
        });

        jLabel33.setText("Sueldo");

        txtrfc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrfcFocusLost(evt);
            }
        });

        jLabel34.setText("RFC");

        jLabel35.setText("Area");

        jLabel38.setText("Puesto");

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

        jLabel39.setText("Tipo de Usuario");

        cmbtusuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Tipo" }));
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

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(103, 103, 103)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtrfc, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtcontraseña)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbarea, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtrfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(cmbarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(cmbpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(btnAgregar1)
                .addGap(0, 134, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Empleado", jPanel7);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jTabbedPane3)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jTabbedPane3)
                    .addContainerGap()))
        );

        jTabbedPane2.addTab("Nuevo", jPanel4);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));

        jLabel41.setText("Nombre");

        jLabel42.setText("Ap. Paterno");

        jLabel43.setText("Ap. Materno");

        txtnombre2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombre2FocusLost(evt);
            }
        });

        txtpaterno2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpaterno2FocusLost(evt);
            }
        });

        txtmaterno2.setToolTipText("");

        jSeparator8.setToolTipText("Direccion");

        jLabel44.setText("Calle");

        jLabel45.setText("Colonia");

        jLabel46.setText("CP");

        txtcalle2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcalle2FocusLost(evt);
            }
        });
        txtcalle2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcalle2KeyReleased(evt);
            }
        });

        txtcolonia2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcolonia2FocusLost(evt);
            }
        });

        txtcp2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcp2FocusLost(evt);
            }
        });
        txtcp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcp2KeyPressed(evt);
            }
        });

        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        jLabel47.setForeground(new java.awt.Color(255, 0, 0));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("TODOS LOS CAMPOS OBLIGATORIOS");

        jLabel48.setText("CURP");

        txtcurp2.setToolTipText("");

        jLabel49.setText("Telefono");

        txttelefono2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttelefono2FocusLost(evt);
            }
        });
        txttelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefono2KeyPressed(evt);
            }
        });

        jLabel50.setText("NoLic");

        txtnolic2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnolic2FocusLost(evt);
            }
        });
        txtnolic2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnolic2KeyPressed(evt);
            }
        });

        txtcred2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcred2FocusLost(evt);
            }
        });
        txtcred2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcred2KeyPressed(evt);
            }
        });

        jLabel51.setText("# Credencial");

        jSeparator9.setToolTipText("Direccion");

        btnSiguiente2.setText("Siguiente");
        btnSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente2ActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnSiguiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnolic2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                            .addComponent(txtcred2)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcalle2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                            .addComponent(txtcp2)
                            .addComponent(txtcolonia2)
                            .addComponent(txttelefono2)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcurp2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnombre2)
                                .addComponent(txtpaterno2)
                                .addComponent(txtmaterno2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtpaterno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtmaterno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtcurp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcalle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtcolonia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtcp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtnolic2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtcred2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar2)
                    .addComponent(btnSiguiente2)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Persona", jPanel13);

        jLabel52.setText("Contraseña");

        txtcontraseña2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontraseña2FocusLost(evt);
            }
        });

        jLabel53.setText("Sueldo");

        txtrfc2.setEditable(false);
        txtrfc2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrfc2FocusLost(evt);
            }
        });

        jLabel54.setText("RFC");

        jLabel55.setText("Area");

        jLabel56.setText("Puesto");

        cmbarea2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbarea2ItemStateChanged(evt);
            }
        });
        cmbarea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbarea2FocusLost(evt);
            }
        });
        cmbarea2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbarea2ActionPerformed(evt);
            }
        });

        cmbpuesto2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbpuesto2ItemStateChanged(evt);
            }
        });
        cmbpuesto2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbpuesto2FocusLost(evt);
            }
        });
        cmbpuesto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbpuesto2MouseClicked(evt);
            }
        });
        cmbpuesto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpuesto2ActionPerformed(evt);
            }
        });

        jLabel57.setText("Tipo de Usuario");

        cmbtusuario2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Tipo" }));
        cmbtusuario2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtusuario2ItemStateChanged(evt);
            }
        });
        cmbtusuario2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbtusuario2FocusLost(evt);
            }
        });
        cmbtusuario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbtusuario2MouseClicked(evt);
            }
        });
        cmbtusuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtusuario2ActionPerformed(evt);
            }
        });

        btnAgregar2.setText("Actualizar");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsueldo2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addGap(103, 103, 103)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbpuesto2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtrfc2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtcontraseña2)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbtusuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbarea2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtrfc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(cmbarea2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(cmbpuesto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(txtsueldo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtusuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtcontraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(btnAgregar2)
                .addGap(0, 134, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Empleado", jPanel15);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(jTabbedPane4)
                    .addContainerGap()))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(jTabbedPane4)
                    .addContainerGap()))
        );

        jTabbedPane2.addTab("Modificar", jPanel11);

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        insertarPersona(txtnombre,txtpaterno,txtmaterno,txtcurp,txtcalle,txtcolonia,txtcp,txttelefono,txtnolic,txtcred);   
        insertarEmpleado(txtrfc,txtsueldo);
        insertarUsuario(txtrfc,txtcontraseña);
mostrartabla();

JOptionPane.showMessageDialog(rootPane,"Se Agrego Correctamente");

jTabbedPane2.setEnabledAt(2,false);
jTabbedPane3.setEnabledAt(1,false);
jTabbedPane3.setSelectedIndex(0);
jTabbedPane4.setEnabledAt(1,false);
jTabbedPane2.setSelectedIndex(0);
limpiar();
// TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void cmbtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioActionPerformed

    private void cmbtusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtusuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioMouseClicked

    private void cmbtusuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbtusuarioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioFocusLost

    private void cmbtusuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtusuarioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioItemStateChanged

    private void cmbpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpuestoActionPerformed
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
mostrarcombopuesto();        // TODO add your handling code here:
    }//GEN-LAST:event_cmbareaActionPerformed

    private void cmbareaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbareaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbareaFocusLost

    private void cmbareaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbareaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbareaItemStateChanged

    private void txtrfcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrfcFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrfcFocusLost

    private void txtcontraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontraseñaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaFocusLost

    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed
jTabbedPane3.setEnabledAt(1,true);  
jTabbedPane3.setSelectedIndex(1);// TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    private void txtcredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcredKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcredKeyPressed

    private void txtcredFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcredFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcredFocusLost

    private void txtnolicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnolicKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnolicKeyPressed

    private void txtnolicFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnolicFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnolicFocusLost

    private void txttelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoKeyPressed

    private void txttelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefonoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoFocusLost

    private void txtcpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcpKeyPressed

    private void txtcpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcpFocusLost

    private void txtcoloniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcoloniaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoloniaFocusLost

    private void txtcalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcalleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalleKeyReleased

    private void txtcalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcalleFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalleFocusLost

    private void txtpaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpaternoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaternoFocusLost

    private void txtnombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreFocusLost

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnombre2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombre2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre2FocusLost

    private void txtpaterno2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpaterno2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaterno2FocusLost

    private void txtcalle2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcalle2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalle2FocusLost

    private void txtcalle2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcalle2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalle2KeyReleased

    private void txtcolonia2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcolonia2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcolonia2FocusLost

    private void txtcp2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcp2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcp2FocusLost

    private void txtcp2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcp2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcp2KeyPressed

    private void txttelefono2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefono2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefono2FocusLost

    private void txttelefono2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefono2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefono2KeyPressed

    private void txtnolic2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnolic2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnolic2FocusLost

    private void txtnolic2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnolic2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnolic2KeyPressed

    private void txtcred2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcred2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcred2FocusLost

    private void txtcred2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcred2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcred2KeyPressed

    private void btnSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente2ActionPerformed
jTabbedPane4.setEnabledAt(1,true);  
jTabbedPane4.setSelectedIndex(1);         // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente2ActionPerformed

    private void txtcontraseña2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontraseña2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseña2FocusLost

    private void txtrfc2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrfc2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrfc2FocusLost

    private void cmbarea2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbarea2ItemStateChanged
mostrarcombopuesto();        // TODO add your handling code here:
    }//GEN-LAST:event_cmbarea2ItemStateChanged

    private void cmbarea2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbarea2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbarea2FocusLost

    private void cmbarea2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbarea2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbarea2ActionPerformed

    private void cmbpuesto2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbpuesto2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuesto2ItemStateChanged

    private void cmbpuesto2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbpuesto2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuesto2FocusLost

    private void cmbpuesto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbpuesto2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuesto2MouseClicked

    private void cmbpuesto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpuesto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuesto2ActionPerformed

    private void cmbtusuario2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtusuario2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuario2ItemStateChanged

    private void cmbtusuario2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbtusuario2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuario2FocusLost

    private void cmbtusuario2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtusuario2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuario2MouseClicked

    private void cmbtusuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtusuario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuario2ActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
actualizarPersona(txtnombre2,txtpaterno2,txtmaterno2,txtcurp2,txtcalle2,txtcolonia2,txtcp2,txttelefono2,txtnolic2,txtcred2);  
actualizarEmpleado(txtrfc2,txtsueldo2);
actualizarUsuario(txtrfc2,txtcontraseña2);
mostrartabla();
JOptionPane.showMessageDialog(rootPane,"Se Actualizo Correctamente");
jTabbedPane2.setSelectedIndex(0);
jTabbedPane2.setEnabledAt(2,false);
jTabbedPane3.setEnabledAt(1,false);
jTabbedPane4.setEnabledAt(1,false);
limpiar();
// TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    jTabbedPane2.setEnabledAt(2,true);  
    jTabbedPane2.setSelectedIndex(2);
    jTabbedPane4.setSelectedIndex(0);
// TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarKeyPressed

    private void tabladatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladatosMousePressed
     if (evt.getClickCount() > 0) {
        Point point = evt.getPoint();
        int row = tabladatos.rowAtPoint(point);
        int column = tabladatos.columnAtPoint(point);
        TableModel model = tabladatos.getModel();
        String a=model.getValueAt(row,1).toString();
                btnModificar.setEnabled(true);
                mostrarEmpleado(a);
    } 
     if (evt.getClickCount() > 1) {
        Point point = evt.getPoint();
        int row = tabladatos.rowAtPoint(point);
        int column = tabladatos.columnAtPoint(point);
        TableModel model = tabladatos.getModel();
        String a="Usario: "+model.getValueAt(row,1).toString();
        JOptionPane.showMessageDialog(this, a);
                btnModificar.setEnabled(true);
                mostrarEmpleado(a);
                jTabbedPane2.setEnabledAt(2,true);  
            jTabbedPane2.setSelectedIndex(2);
            jTabbedPane4.setSelectedIndex(0);
    } 
     // TODO add your handling code here:
    }//GEN-LAST:event_tabladatosMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
eliminarUsuario(txtrfc2);
eliminarEmpleado(txtrfc2);
eliminarPersona();
JOptionPane.showMessageDialog(rootPane,"Se Elimino Correctamente");
jTabbedPane2.setSelectedIndex(0);
jTabbedPane2.setEnabledAt(2,false);
jTabbedPane3.setEnabledAt(1,false);
jTabbedPane4.setEnabledAt(1,false);
mostrartabla();
// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
limpiar();// TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
limpiar();// TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

  
    
    
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
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JButton btnSiguiente2;
    private javax.swing.JComboBox<String> cmbarea;
    private javax.swing.JComboBox<String> cmbarea2;
    private javax.swing.JComboBox<String> cmbpuesto;
    private javax.swing.JComboBox<String> cmbpuesto2;
    private javax.swing.JComboBox<String> cmbtusuario;
    private javax.swing.JComboBox<String> cmbtusuario2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcalle;
    private javax.swing.JTextField txtcalle2;
    private javax.swing.JTextField txtcolonia;
    private javax.swing.JTextField txtcolonia2;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtcontraseña2;
    private javax.swing.JTextField txtcp;
    private javax.swing.JTextField txtcp2;
    private javax.swing.JTextField txtcred;
    private javax.swing.JTextField txtcred2;
    private javax.swing.JTextField txtcurp;
    private javax.swing.JTextField txtcurp2;
    private javax.swing.JTextField txtmaterno;
    private javax.swing.JTextField txtmaterno2;
    private javax.swing.JTextField txtnolic;
    private javax.swing.JTextField txtnolic2;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombre2;
    private javax.swing.JTextField txtpaterno;
    private javax.swing.JTextField txtpaterno2;
    private javax.swing.JTextField txtrfc;
    private javax.swing.JTextField txtrfc2;
    private javax.swing.JTextField txtsueldo;
    private javax.swing.JTextField txtsueldo2;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttelefono2;
    // End of variables declaration//GEN-END:variables
}
