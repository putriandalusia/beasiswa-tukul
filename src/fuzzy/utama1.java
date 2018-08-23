/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy;
import fuzzy.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author ACER
 */
public class utama1 extends javax.swing.JFrame {
Connection koneksi;
    Statement stm;
    ResultSet RsBrg;
    DefaultTableModel tabModel;
    boolean ada=false;
    boolean edit=false;
    private Object[][]dataTable=null;
    Object[]header={"NO","NAMA LENGKAP","NIM","JURUSAN","GAJI ORANG TUA","TANGGUNGAN ORANG TUA","IPK TERAKHIR"};
    /**
     * Creates new form utama1
     */
    public utama1() {
        initComponents();
                this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/fuzzy/toga2.png")));
    this.setTitle("SISTEM PENYELEKSIAN PENERIMAAN BEASISWA");
        openDB();
        tampil();
        aktif(false);
        setTombol(true);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int x=(dim.width-getWidth())/2;
        int y=(dim.height-getHeight())/2;
        setLocation(x,y);

    }

       private void setField(){
        int row=tbl_data.getSelectedRow();
        txt_id.setText((String)tbl_data.getValueAt(row, 0));
        txt_nama.setText((String)tbl_data.getValueAt(row,1));
        txt_nim.setText((String)tbl_data.getValueAt(row,2));
        txt_jurusan.setSelectedItem((String)tbl_data.getValueAt(row,3));
        txt_gaji.setText((String)tbl_data.getValueAt(row,4));
        txt_kk.setText((String)tbl_data.getValueAt(row,5));
        txt_ipk.setText((String)tbl_data.getValueAt(row,6));
    }
        
        public void openDB(){
        try{
        koneksi kon=new koneksi();
        koneksi=kon.getConnection();
        System.out.println("berhasil");
        }catch(Exception err){
            System.out.println(err);
        }
    }
        
        private void autonomor(){
        String sql="select max(id)from d_mahasiswa";
        try{
            stm=koneksi.createStatement();
            RsBrg=stm.executeQuery(sql);
            while(RsBrg.next()){
                int a=RsBrg.getInt(1);
                txt_id.setText(""+Integer.toString(a+1));    
            }
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
    }
      
    void tampil(){
        tabModel=new DefaultTableModel(null,header);
        try{
            stm=koneksi.createStatement();
            RsBrg=stm.executeQuery("select*from d_mahasiswa");
            while(RsBrg.next()){
            String[]data={
                
        RsBrg.getString("id"),RsBrg.getString("nama"),RsBrg.getString("nim"),RsBrg.getString("jurusan"),RsBrg.getString("gaji"),RsBrg.getString("kk"),RsBrg.getString("ipk")};     
        tabModel.addRow(data);
            }
            tbl_data.setModel(tabModel);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e+"Data Gagal Tampil.");
                System.out.println("err:"+e);
        }}

        private void kosong(){
          txt_id.setText("");
          txt_nama.setText("");
          txt_nim.setText("");
          txt_jurusan.setSelectedItem("-PILIH-");
          txt_gaji.setText("");
          txt_kk.setText("");
          txt_ipk.setText("");
        }    
        
        private void aktif(boolean x){
          txt_id.setEditable(x);
          txt_nama.setEditable(x);
          txt_nim.setEditable(x);
          txt_jurusan.setEditable(x);
          txt_gaji.setEditable(x);
          txt_kk.setEditable(x);
          txt_ipk.setEditable(x);
        }
        
        private void setTombol(boolean t){
            bplus.setEnabled(t);
            bdaftar.setEnabled(!t);
       }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel21 = new fuzzy.panel2();
        clGlossyPanel1 = new GlossyPanel.ClGlossyPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        clPanelTransparan1 = new PanelTransparan.ClPanelTransparan();
        clRoundTransButton1 = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton2 = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton3 = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton4 = new RoundedTransparanButton.ClRoundTransButton();
        clRoundTransButton5 = new RoundedTransparanButton.ClRoundTransButton();
        clPanelTransparan2 = new PanelTransparan.ClPanelTransparan();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bplus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_jurusan = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_nama = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_nim = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_gaji = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_kk = new RoundedTransparanTextField.ClRoundTransTxt();
        txt_ipk = new RoundedTransparanTextField.ClRoundTransTxt();
        bdaftar = new RoundedTransparanButton.ClRoundTransButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        txt_id = new RoundedTransparanTextField.ClRoundTransTxt();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1365, 720));
        setSize(new java.awt.Dimension(1365, 730));

        panel21.setPreferredSize(new java.awt.Dimension(1385, 716));

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SPK Penyeleksian Penerimaan Beasiswa Dengan Methode Fuzzy Logic");

        jLabel31.setFont(new java.awt.Font("Aharoni", 1, 23)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("_");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Aharoni", 1, 23)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("X");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout clGlossyPanel1Layout = new javax.swing.GroupLayout(clGlossyPanel1);
        clGlossyPanel1.setLayout(clGlossyPanel1Layout);
        clGlossyPanel1Layout.setHorizontalGroup(
            clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addGap(30, 30, 30))
        );
        clGlossyPanel1Layout.setVerticalGroup(
            clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jLabel31))
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        clPanelTransparan1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        clRoundTransButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/proses.png"))); // NOI18N
        clRoundTransButton1.setText("Proses Fuzzy");
        clRoundTransButton1.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton1ActionPerformed(evt);
            }
        });

        clRoundTransButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/home.png"))); // NOI18N
        clRoundTransButton2.setText("Home");
        clRoundTransButton2.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton2ActionPerformed(evt);
            }
        });

        clRoundTransButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/report.png"))); // NOI18N
        clRoundTransButton3.setText("Report");
        clRoundTransButton3.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton3ActionPerformed(evt);
            }
        });

        clRoundTransButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/plus.png"))); // NOI18N
        clRoundTransButton4.setText("Data\nMahasiswa");
        clRoundTransButton4.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton4ActionPerformed(evt);
            }
        });

        clRoundTransButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/logout.png"))); // NOI18N
        clRoundTransButton5.setText("Logout");
        clRoundTransButton5.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        clRoundTransButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clRoundTransButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clRoundTransButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clRoundTransButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clPanelTransparan1Layout = new javax.swing.GroupLayout(clPanelTransparan1);
        clPanelTransparan1.setLayout(clPanelTransparan1Layout);
        clPanelTransparan1Layout.setHorizontalGroup(
            clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(clRoundTransButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clRoundTransButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(clRoundTransButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(clRoundTransButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(clRoundTransButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        clPanelTransparan1Layout.setVerticalGroup(
            clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clPanelTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clRoundTransButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clRoundTransButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clRoundTransButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clRoundTransButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clRoundTransButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        clPanelTransparan2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel2.setText(" Data Mahasiswa");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel7.setText("Pengaju Beasiswa");

        bplus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/Create.png"))); // NOI18N
        bplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bplusActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel3.setText("Nama Mahasiswa");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel4.setText("Nomor Induk Mahasiswa");

        jLabel8.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel8.setText("Jurusan");

        txt_jurusan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-PILIH-", "Teknik Informatika", "Akutansi", "Teknik Sipil", "Teknik Industri" }));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel5.setText("Gaji Orang Tua");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel6.setText("Tanggungan Orang Tua");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel9.setText("IPK Terakhir");

        bdaftar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzy/simpan.png"))); // NOI18N
        bdaftar.setText("Simpan");
        bdaftar.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        bdaftar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bdaftar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bdaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdaftarActionPerformed(evt);
            }
        });

        tbl_data.setBackground(new java.awt.Color(240, 240, 240));
        tbl_data.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data.setGridColor(new java.awt.Color(255, 204, 51));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_data);

        javax.swing.GroupLayout clPanelTransparan2Layout = new javax.swing.GroupLayout(clPanelTransparan2);
        clPanelTransparan2.setLayout(clPanelTransparan2Layout);
        clPanelTransparan2Layout.setHorizontalGroup(
            clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_nim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_jurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(31, 31, 31)
                            .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_kk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_gaji, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ipk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                            .addGap(164, 164, 164)
                            .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bplus, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(bdaftar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(669, Short.MAX_VALUE))
            .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                    .addGap(524, 524, 524)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        clPanelTransparan2Layout.setVerticalGroup(
            clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bplus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(58, 58, 58)
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel9))
                    .addGroup(clPanelTransparan2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_gaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ipk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(bdaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(clPanelTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clPanelTransparan2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(92, 92, 92)))
        );

        javax.swing.GroupLayout panel21Layout = new javax.swing.GroupLayout(panel21);
        panel21.setLayout(panel21Layout);
        panel21Layout.setHorizontalGroup(
            panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clGlossyPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel21Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(clPanelTransparan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel21Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(clPanelTransparan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        panel21Layout.setVerticalGroup(
            panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel21Layout.createSequentialGroup()
                .addComponent(clGlossyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(clPanelTransparan2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clPanelTransparan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel21Layout.createSequentialGroup()
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel21, javax.swing.GroupLayout.DEFAULT_SIZE, 1368, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel21, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clRoundTransButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton2ActionPerformed
        new home().setVisible(true);
        dispose();
    }//GEN-LAST:event_clRoundTransButton2ActionPerformed

    private void clRoundTransButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton4ActionPerformed
 new utama1().setVisible(true);
 dispose(); 
    }//GEN-LAST:event_clRoundTransButton4ActionPerformed

    private void clRoundTransButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton5ActionPerformed
 new login().setVisible(true);
 dispose();
    }//GEN-LAST:event_clRoundTransButton5ActionPerformed

    private void bplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bplusActionPerformed
        edit = false;
        aktif(true);
        setTombol(false);
        kosong();
        autonomor();
        txt_nama.requestFocus();
    }//GEN-LAST:event_bplusActionPerformed

    private void bdaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdaftarActionPerformed
String t1 = txt_id.getText();
        String t2 = txt_nama.getText();
        String t3 = txt_nim.getText();
        Object t4 = txt_jurusan.getSelectedItem();
        String t5 = txt_gaji.getText();
        String t6 = txt_kk.getText();
        String t7 = txt_ipk.getText();
        try {
            if (edit == true) {
                stm.executeUpdate("update d_mahasiswa set id='" + t1 + "',nama='" + t2 + "',nim='" + t3 + "',jurusan='" + t4 + "',gaji='" + t5 + "',kk='" + t6 + "',ipk='" + t7 +  "'where id='" + t1 + "'");
            } else {
                stm.executeUpdate("INSERT into d_mahasiswa VALUES('" + t1 + "','" + t2 + "','" + t3 +  "','" + t4 +  "','" + t5 +  "','" + t6 +  "','" + t7 +  "')");
            }
            tbl_data.setModel(new DefaultTableModel(dataTable, header));
            tampil();
            aktif(false);
            setTombol(true);
            kosong();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            new login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_bdaftarActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        setField();
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void clRoundTransButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton1ActionPerformed
 new fuzifikasi().setVisible(true);
 dispose(); 
    }//GEN-LAST:event_clRoundTransButton1ActionPerformed

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel32MouseClicked

    private void clRoundTransButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clRoundTransButton3ActionPerformed
        new report().setVisible(true);
        dispose();
    }//GEN-LAST:event_clRoundTransButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(utama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(utama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(utama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(utama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new utama1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RoundedTransparanButton.ClRoundTransButton bdaftar;
    private javax.swing.JButton bplus;
    private GlossyPanel.ClGlossyPanel clGlossyPanel1;
    private PanelTransparan.ClPanelTransparan clPanelTransparan1;
    private PanelTransparan.ClPanelTransparan clPanelTransparan2;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton1;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton2;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton3;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton4;
    private RoundedTransparanButton.ClRoundTransButton clRoundTransButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private fuzzy.panel2 panel21;
    private javax.swing.JTable tbl_data;
    private RoundedTransparanTextField.ClRoundTransTxt txt_gaji;
    private RoundedTransparanTextField.ClRoundTransTxt txt_id;
    private RoundedTransparanTextField.ClRoundTransTxt txt_ipk;
    private javax.swing.JComboBox txt_jurusan;
    private RoundedTransparanTextField.ClRoundTransTxt txt_kk;
    private RoundedTransparanTextField.ClRoundTransTxt txt_nama;
    private RoundedTransparanTextField.ClRoundTransTxt txt_nim;
    // End of variables declaration//GEN-END:variables
}
