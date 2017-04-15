package postest7;

import java.awt.Color; // ini merupakan javak warna 
import java.sql.*; // //Mengimpor Class untuk mendukung akses dan pengolahan data dalam database
import javax.swing.JOptionPane; // ini merupakan memuculkan pesan
import javax.swing.table.DefaultTableModel; 


public class tugas7 extends javax.swing.JFrame {
    private DefaultTableModel model; //untuk membuat model pada data
    private Connection con = koneksi.getConnection();//untuk mengambil koneksi 
    private Statement stt; //untuk eksekusi query database
    private ResultSet rss; // untuk penampung dari database
    private int baris;  // mendeklrasikan suatu baris
    private boolean data=true; //membuat pilihan saat validasi data
  
    public tugas7() {
        initComponents();
        
    }
       private void InitTable(){ // membuat table secara manual  
        model = new DefaultTableModel(); //class model dari DefaultTableModel
        model.addColumn("ID"); // membuat kolom id dalam class model
        model.addColumn("JUDUL"); // membuat kolom judul dalam class model
        model.addColumn("PENULIS"); // membuat kolom penulis dalam class model
        model.addColumn("HARGA"); // membuat kolom harga dalam class model
        
        jTable1.setModel(model); // //mengeset instance of class model ke table
    }
    
    private void tampilData(){ // method untuk menampilkan data dari database
        try{
            String sql = "SELECT * FROM buku"; // ini merupakan query dari database untuk melihat tabel buku
            stt = con.createStatement();
            rss = stt.executeQuery(sql); 
            while(rss.next()){
                Object[] o = new Object[4];//membuat suatu Objek
                o[0] = rss.getString("id"); //objek 0 ini untuk menampung data id
                o[1] = rss.getString("judul");//objek 1 ini untuk menampung data judul
                o[2] = rss.getString("penulis");//objek 2 ini untuk menampung data penulis
                o[3] = rss.getInt("harga");//objek 3 ini untuk menampung data harga
                model.addRow(o);//baris pada suatu model
            }
        }catch(SQLException e){ //menampilkan kesalahan pada program
            System.out.println(e.getMessage());
        }
    }
                
    private void TambahData(String judul, String penulis, String harga){ // method untuk menambah data ke dalam database
        try{
            String sql =
                    "INSERT INTO buku VALUES (NULL, '"+judul+"','"+penulis+"',"+harga+")"; //query ini untuk menambah tabel buku dan menambah kolom judul,penulis dan harga
            stt = con.createStatement();
            stt.executeUpdate(sql);
           
        }catch(SQLException e){//menampilkan kesalahan pada program
            System.out.println(e.getMessage());
        }
    }
    
   private boolean UbahData( String id, String judul, String penulis, String harga){ // method untuk mengubah data ke dalam database
        try{
            String sql = "UPDATE buku SET judul='"+judul+"',"+"penulis='"+penulis+"',harga='"+harga+"'where id='"+id+"'";//query ini untuk mengganti suatu di dalam tabel buku pada kolom nya tersebut
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){//menampilkan kesalahan pada program
            System.out.println(e.getMessage());
            return false;
        }
    }
   
     private boolean HapusData( String id){ // method untuk mengahapus data di dalam database
        try{
            String sql = "DELETE from buku where id='"+id+"'";//query ini untuk menghapus yang ada di dalam tabel buku dan memilih kolom yang terdapat pada isinya apa yang mau di hapus
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }catch(SQLException e){//menampilkan kesalahan pada program
            System.out.println(e.getMessage());
            return false;
        }
    }
     
   private void CariData(String By, String cari){ // method mencari id
        try{
            String sql = "SELECT*from buku where "+By+" LIKE  '%"+cari+"%'"; //query untuk melihat like dari database yang ada
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   // membuat suatu objeck
              o[0] = rss.getInt("id"); // objek 0 ini untuk menampung data id
              o[1] = rss.getString("judul");//objek 1 untuk menampung data judul
              o[2] = rss.getString("penulis");//objek 2 menampung data penulis
              o[3] = rss.getString("harga");//objek 3 menampung data harga
              model.addRow(o);//baris pada suatu model
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
   
  private void ValidasiData(String judul, String penulis, String harga){  //method untuk mencari id data
        try{
            String sql = "SELECT*from buku ";//query ini untuk melihat isi tabel buku di database
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[2];//membuat suatu Objek
              o[0] = rss.getString("judul").toLowerCase();//objek 0 ini untuk menampung data id
              o[1] = rss.getString("penulis").toLowerCase();//objek 1 ini untuk menampung data judul
              
              if(o[0].equals(judul.toLowerCase())&& o[1].equals(penulis.toLowerCase())){ //jika sudah ada data judul dan penulis
                  JOptionPane.showMessageDialog(null, "Data SUDAH ADA!!!!");//untuk tampilan bahwa data sudah ada
                  data = false ;                                                            
                  break;//proses berhenti
              }
            }
            if(data==true){//jika data belum ada
                TambahData(judul,penulis,harga); //memasukkan method TambahData untuk mengisi judul, penulis, dan harga
            }
        }catch(SQLException e){//menampilkan kesalahan pada program
            System.out.println(e.getMessage());
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

        button1 = new java.awt.Button();
        jp1 = new javax.swing.JPanel();
        jp2 = new javax.swing.JPanel();
        fdb = new javax.swing.JLabel();
        jp3 = new javax.swing.JPanel();
        jd = new javax.swing.JLabel();
        jd2 = new javax.swing.JTextField();
        p = new javax.swing.JLabel();
        jc = new javax.swing.JComboBox();
        h = new javax.swing.JLabel();
        h2 = new javax.swing.JTextField();
        scr = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        simp = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        sr = new javax.swing.JLabel();
        src = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        by = new javax.swing.JComboBox();
        cari = new javax.swing.JButton();

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jp1.setBackground(new java.awt.Color(153, 0, 0));

        jp2.setBackground(new java.awt.Color(51, 0, 0));

        fdb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fdb.setForeground(new java.awt.Color(255, 255, 255));
        fdb.setText("Form Data Buku Shinigami");

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp2Layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(fdb)
                .addGap(141, 141, 141))
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(fdb)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jp3.setBackground(new java.awt.Color(51, 0, 0));
        jp3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jp3ComponentShown(evt);
            }
        });

        jd.setForeground(new java.awt.Color(255, 255, 255));
        jd.setText("Judul");

        jd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jd2ActionPerformed(evt);
            }
        });

        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setText("Penulis");

        jc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ryuk", "Rem", "Abygl", "Toxic" }));

        h.setForeground(new java.awt.Color(255, 255, 255));
        h.setText("Harga");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "JUDUL", "PENULIS", "HARGA"
            }
        ));
        scr.setViewportView(jTable1);

        simp.setText("SIMPAN");
        simp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpMouseExited(evt);
            }
        });
        simp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpActionPerformed(evt);
            }
        });

        ubah.setText("UBAH");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        keluar.setText("KELUAR");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        sr.setForeground(new java.awt.Color(255, 255, 255));
        sr.setText("Search");

        src.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("By");

        by.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Judul", "Penulis", "Harga" }));
        by.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byActionPerformed(evt);
            }
        });

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jp3Layout);
        jp3Layout.setHorizontalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jp3Layout.createSequentialGroup()
                                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jd)
                                    .addComponent(p)
                                    .addComponent(h))
                                .addGap(104, 104, 104)
                                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jd2)
                                    .addComponent(h2, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                    .addComponent(jc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jp3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jp3Layout.createSequentialGroup()
                                        .addComponent(simp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ubah)
                                        .addGap(47, 47, 47)
                                        .addComponent(hapus)
                                        .addGap(43, 43, 43)
                                        .addComponent(keluar))))))
                    .addGroup(jp3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(sr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(by, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cari)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jp3Layout.setVerticalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jd)
                    .addComponent(jd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p)
                    .addComponent(jc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(h)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(simp)
                        .addComponent(ubah)
                        .addComponent(hapus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sr)
                    .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari))
                .addGap(18, 18, 18)
                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jd2ActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow(); // mengambil nilai bari yang sudah ditetapkan
      
        String id = jTable1.getValueAt(baris, 0).toString(); // untuk mengambil nilai baris yang sudah diubah
        String judul = jd2.getText();// untuk mengambil nilai baris yang sudah diubah
        String penulis = jc.getSelectedItem().toString();// untuk mengambil nilai baris yang sudah diubah
        String harga = h2.getText();// untuk mengambil nilai baris yang sudah diubah
        if(UbahData(id, judul, penulis, harga))
            JOptionPane.showMessageDialog(null, "Berhasil Ubah Data"); //pemberitahuan jika sudah mengubah data
        else
            JOptionPane.showMessageDialog(null, "Gagal Ubah Data"); //pemberitahuan jika data gagal diubah
       InitTable();
       tampilData();
       
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed

        int baris = jTable1.getSelectedRow(); // memilih baris yang diinginkan
        String id = jTable1.getValueAt(baris, 0).toString();
        if(HapusData(id))
            JOptionPane.showMessageDialog(null, "Berhasil Hapus Data"); //pemberitahuan jika sudah menghapus data
        else
            JOptionPane.showConfirmDialog(null, "Gagal Hapus Data"); //pemberitahuan jika data gagal dihapus
       InitTable();
       tampilData();    
    }//GEN-LAST:event_hapusActionPerformed

    private void jp3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jp3ComponentShown
       
    }//GEN-LAST:event_jp3ComponentShown

    private void simpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpActionPerformed

        if(jd2.getText().equals("")||h2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi Data ini Harus!!!!");
            jd2.requestFocus();
        }
        
        String judul = jd2.getText(); //untuk mengambil nilai yang ada di komponen jTextField1
        String penulis = jc.getSelectedItem().toString(); //untuk mengambil nilai yang ada di komponen jComboBox1
        String harga = h2.getText();//untuk mengambil nilai yang ada di komponen jTextField2
        ValidasiData(judul, penulis, harga); //pemanggilan method 
        InitTable();
        tampilData();
    }//GEN-LAST:event_simpActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        InitTable(); // sintax ini untuk memunculkan pada saat aplikasi dijalankan
        tampilData(); // sintax ini untuk memunculkan pada saat aplikasi dijalankan
    }//GEN-LAST:event_formComponentShown

    private void srcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        
        if(src.getText().equals("")){ //ini merupakan pencarian jika kosong
            JOptionPane.showMessageDialog(null,"Harus Diisi");
        }
            else{
            model.getDataVector().removeAllElements(); //menghapus elemen yang ada di jTable1
            model.fireTableDataChanged();
            CariData(by.getSelectedItem().toString(),src.getText());  
        }
    }//GEN-LAST:event_cariActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0); // ini merupakan sintax keluar dari program i
    }//GEN-LAST:event_keluarActionPerformed

    private void simpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpMouseEntered
        // TODO add your handling code here:
        simp.setBackground(Color.red); ////untuk menampilkan entered ketika mouse masuk akan berwarna merah
    }//GEN-LAST:event_simpMouseEntered

    private void simpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpMouseExited
        // TODO add your handling code here:
        simp.setBackground(Color.yellow); //untuk menampilkan exit ketika mouse keluar akan berwarna kuning
    }//GEN-LAST:event_simpMouseExited

    private void byActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_byActionPerformed

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
            java.util.logging.Logger.getLogger(tugas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tugas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tugas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tugas7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tugas7().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JComboBox by;
    private javax.swing.JButton cari;
    private javax.swing.JLabel fdb;
    private javax.swing.JLabel h;
    private javax.swing.JTextField h2;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox jc;
    private javax.swing.JLabel jd;
    private javax.swing.JTextField jd2;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JButton keluar;
    private javax.swing.JLabel p;
    private javax.swing.JScrollPane scr;
    private javax.swing.JButton simp;
    private javax.swing.JLabel sr;
    private javax.swing.JTextField src;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables

    }
