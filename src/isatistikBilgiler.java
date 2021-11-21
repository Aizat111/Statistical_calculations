
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.ui.RefineryUtilities;


public class isatistikBilgiler extends javax.swing.JFrame {

DefaultTableModel myTable;
        ArrayList<Double>kyrgyzstan=new ArrayList<Double>();//double tipinde list olusturmak
        ArrayList<Double>japan=new ArrayList<Double>();
        ArrayList<Double>china=new ArrayList<Double>();
        ArrayList<Double>gun=new ArrayList<Double>();
        ArrayList<Double>tutucu1=new ArrayList<Double>();
        ArrayList<Double>tutucu2=new ArrayList<Double>();
        ArrayList<Double>tutucu3=new ArrayList<Double>();
        boolean on_off=false;
 
    public isatistikBilgiler()  {
        initComponents();
        
        myTable=(DefaultTableModel)jTable1.getModel();//modeli tabloya baglamak
        txt1.setEnabled(false);
        txt2.setEnabled(false);
        txt3.setEnabled(false);

         for(int i=0;i<myTable.getRowCount();i++)//tablodaki verileri liste aktariyoruz
         {
             kyrgyzstan.add((double)myTable.getValueAt(i,1));
             japan.add((double)myTable.getValueAt(i,2));
             china.add((double)myTable.getValueAt(i,3));
             tutucu1.add(kyrgyzstan.get(i));//siralama yapildiginda list tablodaki gorunumu kaybeder ve silme isleminde karismamasi icin yeni liste aktarip siralamada kullanacagiz
             tutucu2.add(japan.get(i));
             tutucu3.add(china.get(i));
       }
        
           
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_ekle = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        btn_artor = new javax.swing.JButton();
        btn_medyan = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();
        btn_degisaralık = new javax.swing.JButton();
        btn_oms = new javax.swing.JButton();
        btn_varyans = new javax.swing.JButton();
        btn_std = new javax.swing.JButton();
        btn_dkat = new javax.swing.JButton();
        btn_ceyac = new javax.swing.JButton();
        lbl_tittle = new javax.swing.JLabel();
        lbl_msg1 = new javax.swing.JLabel();
        lbl_msg2 = new javax.swing.JLabel();
        lbl_msg3 = new javax.swing.JLabel();
        txt2 = new javax.swing.JFormattedTextField();
        txt1 = new javax.swing.JFormattedTextField();
        txt3 = new javax.swing.JFormattedTextField();
        btn_ok = new javax.swing.JButton();
        btn_boxplot = new javax.swing.JButton();
        btn_dosya = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Double(1.0),  new Double(0.0),  new Double(2014.0),  new Double(91.0)},
                { new Double(2.0),  new Double(335.0),  new Double(2456.0),  new Double(120.0)},
                { new Double(3.0),  new Double(420.0),  new Double(2506.0),  new Double(108.0)},
                { new Double(4.0),  new Double(440.0),  new Double(2449.0),  new Double(127.0)},
                { new Double(5.0),  new Double(401.0),  new Double(2483.0),  new Double(119.0)},
                { new Double(6.0),  new Double(621.0),  new Double(2047.0),  new Double(110.0)},
                { new Double(7.0),  new Double(0.0),  new Double(1517.0),  new Double(93.0)},
                { new Double(8.0),  new Double(295.0),  new Double(2158.0),  new Double(112.0)},
                { new Double(9.0),  new Double(322.0),  new Double(2837.0),  new Double(116.0)},
                { new Double(10.0),  new Double(379.0),  new Double(2977.0),  new Double(127.0)},
                { new Double(11.0),  new Double(668.0),  new Double(2904.0),  new Double(99.0)},
                { new Double(12.0),  new Double(0.0),  new Double(2962.0),  new Double(93.0)},
                { new Double(13.0),  new Double(297.0),  new Double(2367.0),  new Double(111.0)},
                { new Double(14.0),  new Double(318.0),  new Double(1672.0),  new Double(99.0)},
                { new Double(15.0),  new Double(477.0),  new Double(2441.0),  new Double(110.0)},
                { new Double(16.0),  new Double(0.0),  new Double(2999.0),  new Double(89.0)},
                { new Double(17.0),  new Double(264.0),  new Double(3199.0),  new Double(108.0)},
                { new Double(18.0),  new Double(264.0),  new Double(2803.0),  new Double(87.0)},
                { new Double(19.0),  new Double(232.0),  new Double(3062.0),  new Double(132.0)},
                { new Double(20.0),  new Double(343.0),  new Double(2455.0),  new Double(97.0)},
                { new Double(21.0),  new Double(0.0),  new Double(1804.0),  new Double(100.0)},
                { new Double(22.0),  new Double(175.0),  new Double(2658.0),  new Double(78.0)},
                { new Double(23.0),  new Double(230.0),  new Double(3275.0),  new Double(70.0)},
                { new Double(24.0),  new Double(186.0),  new Double(3762.0),  new Double(85.0)},
                { new Double(25.0),  new Double(180.0),  new Double(3806.0),  new Double(77.0)},
                { new Double(26.0),  new Double(157.0),  new Double(3892.0),  new Double(81.0)},
                { new Double(27.0),  new Double(191.0),  new Double(2945.0),  new Double(91.0)},
                { new Double(28.0),  new Double(162.0),  new Double(2374.0),  new Double(88.0)},
                { new Double(29.0),  new Double(119.0),  new Double(3629.0),  new Double(77.0)},
                { new Double(30.0),  new Double(189.0),  new Double(3856.0),  new Double(79.0)},
                { new Double(31.0),  new Double(191.0),  new Double(4540.0),  new Double(87.0)},
                { new Double(32.0),  new Double(122.0),  new Double(3257.0),  new Double(60.0)},
                { new Double(33.0),  new Double(58.0),  new Double(3029.0),  new Double(63.0)},
                { new Double(34.0),  new Double(174.0),  new Double(3196.0),  new Double(74.0)},
                { new Double(35.0),  new Double(0.0),  new Double(3332.0),  new Double(86.0)},
                { new Double(36.0),  new Double(124.0),  new Double(4946.0),  new Double(64.0)},
                { new Double(37.0),  new Double(144.0),  new Double(5950.0),  new Double(88.0)},
                { new Double(38.0),  new Double(170.0),  new Double(7563.0),  new Double(86.0)},
                { new Double(39.0),  new Double(165.0),  new Double(7863.0),  new Double(78.0)},
                { new Double(40.0),  new Double(147.0),  new Double(7790.0),  new Double(128.0)},
                { new Double(41.0),  new Double(135.0),  new Double(6081.0),  new Double(134.0)},
                { new Double(42.0),  new Double(107.0),  new Double(4928.0),  new Double(96.0)},
                { new Double(43.0),  new Double(207.0),  new Double(4575.0),  new Double(175.0)},
                { new Double(44.0),  new Double(0.0),  new Double(5819.0),  new Double(180.0)},
                { new Double(45.0),  new Double(136.0),  new Double(6594.0),  new Double(173.0)},
                { new Double(46.0),  new Double(263.0),  new Double(7137.0),  new Double(168.0)},
                { new Double(47.0),  new Double(123.0),  new Double(7071.0),  new Double(159.0)},
                { new Double(48.0),  new Double(69.0),  new Double(5773.0),  new Double(164.0)},
                { new Double(49.0),  new Double(0.0),  new Double(4890.0),  new Double(225.0)},
                { new Double(50.0),  new Double(252.0),  new Double(5384.0),  new Double(159.0)},
                { new Double(51.0),  new Double(0.0),  new Double(5519.0),  new Double(221.0)},
                { new Double(52.0),  new Double(155.0),  new Double(5621.0),  new Double(242.0)},
                { new Double(53.0),  new Double(211.0),  new Double(5045.0),  new Double(100.0)},
                { new Double(54.0),  new Double(0.0),  new Double(4754.0),  new Double(161.0)},
                { new Double(55.0),  new Double(104.0),  new Double(3971.0),  new Double(200.0)},
                { new Double(56.0),  new Double(168.0),  new Double(2785.0),  new Double(155.0)},
                { new Double(57.0),  new Double(107.0),  new Double(3861.0),  new Double(139.0)},
                { new Double(58.0),  new Double(128.0),  new Double(3937.0),  new Double(114.0)},
                { new Double(59.0),  new Double(0.0),  new Double(4162.0),  new Double(91.0)},
                { new Double(60.0),  new Double(74.0),  new Double(3536.0),  new Double(102.0)},
                { new Double(61.0),  new Double(152.0),  new Double(3319.0),  new Double(120.0)},
                { new Double(62.0),  new Double(59.0),  new Double(2667.0),  new Double(95.0)},
                { new Double(63.0),  new Double(0.0),  new Double(1790.0),  new Double(64.0)},
                { new Double(64.0),  new Double(58.0),  new Double(2313.0),  new Double(50.0)},
                { new Double(65.0),  new Double(186.0),  new Double(2631.0),  new Double(49.0)},
                { new Double(66.0),  new Double(88.0),  new Double(2592.0),  new Double(42.0)},
                { new Double(67.0),  new Double(0.0),  new Double(2366.0),  new Double(50.0)},
                { new Double(68.0),  new Double(72.0),  new Double(2270.0),  new Double(30.0)},
                { new Double(69.0),  new Double(79.0),  new Double(1637.0),  new Double(41.0)},
                { new Double(70.0),  new Double(42.0),  new Double(1227.0),  new Double(46.0)},
                { new Double(71.0),  new Double(58.0),  new Double(1558.0),  new Double(40.0)},
                { new Double(72.0),  new Double(82.0),  new Double(1884.0),  new Double(19.0)},
                { new Double(73.0),  new Double(75.0),  new Double(1691.0),  new Double(33.0)},
                { new Double(74.0),  new Double(70.0),  new Double(1316.0),  new Double(32.0)},
                { new Double(75.0),  new Double(43.0),  new Double(1362.0),  new Double(19.0)},
                { new Double(76.0),  new Double(34.0),  new Double(1351.0),  new Double(21.0)},
                { new Double(77.0),  new Double(41.0),  new Double(973.0),  new Double(25.0)},
                { new Double(78.0),  new Double(48.0),  new Double(1308.0),  new Double(15.0)},
                { new Double(79.0),  new Double(125.0),  new Double(1461.0),  new Double(27.0)},
                { new Double(80.0),  new Double(0.0),  new Double(1525.0),  new Double(18.0)},
                { new Double(81.0),  new Double(142.0),  new Double(1297.0),  new Double(21.0)},
                { new Double(82.0),  new Double(0.0),  new Double(1234.0),  new Double(22.0)},
                { new Double(83.0),  new Double(98.0),  new Double(1036.0),  new Double(31.0)},
                { new Double(84.0),  new Double(0.0),  new Double(737.0),  new Double(26.0)},
                { new Double(85.0),  new Double(72.0),  new Double(1103.0),  new Double(23.0)},
                { new Double(86.0),  new Double(24.0),  new Double(904.0),  new Double(25.0)},
                { new Double(87.0),  new Double(66.0),  new Double(1084.0),  new Double(19.0)},
                { new Double(88.0),  new Double(51.0),  new Double(1057.0),  new Double(34.0)},
                { new Double(89.0),  new Double(43.0),  new Double(1220.0),  new Double(39.0)},
                { new Double(90.0),  new Double(66.0),  new Double(997.0),  new Double(41.0)},
                { new Double(91.0),  new Double(57.0),  new Double(688.0),  new Double(25.0)},
                { new Double(92.0),  new Double(48.0),  new Double(922.0),  new Double(23.0)},
                { new Double(93.0),  new Double(54.0),  new Double(1244.0),  new Double(24.0)},
                { new Double(94.0),  new Double(0.0),  new Double(1149.0),  new Double(18.0)},
                { new Double(95.0),  new Double(41.0),  new Double(1129.0),  new Double(19.0)},
                { new Double(96.0),  new Double(55.0),  new Double(412.0),  new Double(23.0)},
                { new Double(97.0),  new Double(44.0),  new Double(1722.0),  new Double(35.0)},
                { new Double(98.0),  new Double(33.0),  new Double(621.0),  new Double(17.0)},
                { new Double(99.0),  new Double(57.0),  new Double(1175.0),  new Double(26.0)},
                { new Double(100.0),  new Double(0.0),  new Double(1259.0),  new Double(19.0)},
                { new Double(101.0),  new Double(115.0),  new Double(1303.0),  new Double(31.0)},
                { new Double(102.0),  new Double(63.0),  new Double(1263.0),  new Double(67.0)},
                { new Double(103.0),  new Double(0.0),  new Double(1335.0),  new Double(57.0)},
                { new Double(104.0),  new Double(32.0),  new Double(975.0),  new Double(29.0)},
                { new Double(105.0),  new Double(67.0),  new Double(713.0),  new Double(43.0)},
                { new Double(106.0),  new Double(128.0),  new Double(1142.0),  new Double(22.0)},
                { new Double(107.0),  new Double(98.0),  new Double(1545.0),  new Double(17.0)},
                { new Double(108.0),  new Double(0.0),  new Double(1460.0),  new Double(21.0)},
                { new Double(109.0),  new Double(96.0),  new Double(1469.0),  new Double(17.0)},
                { new Double(110.0),  new Double(150.0),  new Double(1596.0),  new Double(20.0)},
                { new Double(111.0),  new Double(0.0),  new Double(1106.0),  new Double(15.0)},
                { new Double(112.0),  new Double(73.0),  new Double(786.0),  new Double(27.0)},
                { new Double(113.0),  new Double(190.0),  new Double(1517.0),  new Double(22.0)},
                { new Double(114.0),  new Double(106.0),  new Double(1974.0),  new Double(21.0)},
                { new Double(115.0),  new Double(0.0),  new Double(1911.0),  new Double(20.0)},
                { new Double(116.0),  new Double(100.0),  new Double(1977.0),  new Double(23.0)},
                { new Double(117.0),  new Double(88.0),  new Double(2080.0),  new Double(17.0)},
                { new Double(118.0),  new Double(146.0),  new Double(1783.0),  new Double(12.0)},
                { new Double(119.0),  new Double(71.0),  new Double(1290.0),  new Double(17.0)},
                { new Double(120.0),  new Double(113.0),  new Double(2141.0),  new Double(18.0)}
            },
            new String [] {
                "GÜNLER", "Kyrgyzstan", "Japan", "China"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btn_ekle.setText("TABLOYA VERİ EKLE");
        btn_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ekleActionPerformed(evt);
            }
        });

        btn_sil.setText("TABLODAN VERİ SİL");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        btn_artor.setText("Aritmetik Ortalama");
        btn_artor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_artorActionPerformed(evt);
            }
        });

        btn_medyan.setText("Ortanca(medyan)");
        btn_medyan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_medyanActionPerformed(evt);
            }
        });

        btn_mod.setText("Tepe değer(mod)");
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        btn_degisaralık.setText("Değişim Aralığı");
        btn_degisaralık.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_degisaralıkActionPerformed(evt);
            }
        });

        btn_oms.setText("Ortalama Mutlak Sapma");
        btn_oms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_omsActionPerformed(evt);
            }
        });

        btn_varyans.setText("Varyans");
        btn_varyans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_varyansActionPerformed(evt);
            }
        });

        btn_std.setText("Standart Sapma");
        btn_std.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stdActionPerformed(evt);
            }
        });

        btn_dkat.setText("Değişim Katsayısı");
        btn_dkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dkatActionPerformed(evt);
            }
        });

        btn_ceyac.setText("Çeyrek Açıklığı");
        btn_ceyac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ceyacActionPerformed(evt);
            }
        });

        lbl_tittle.setText("Kyrgyzstan,Japonya ve Çin'in 12/01/2020-31/03/2021 tarihleri arasindaki vaka sayısı tablosu");

        txt2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));

        txt1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));

        txt3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));
        txt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt3ActionPerformed(evt);
            }
        });

        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        btn_boxplot.setText("BOXPLOT");
        btn_boxplot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_boxplotActionPerformed(evt);
            }
        });

        btn_dosya.setText("Verileri Dosyaya Aktar");
        btn_dosya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dosyaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btn_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(42, 42, 42))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lbl_msg1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_msg2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_msg3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(168, 168, 168)
                                    .addComponent(btn_ok)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_artor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_medyan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_mod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_degisaralık, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_oms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_varyans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_std, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_dkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ceyac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_boxplot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_dosya, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_tittle)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_msg1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(lbl_msg2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_msg3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_artor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btn_medyan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_degisaralık, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_oms, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_varyans, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_std, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dkat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ceyac, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dosya, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ok)
                    .addComponent(btn_boxplot, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void Aktarma(ArrayList<Double>kon,ArrayList<Double>sam, ArrayList<Double>sir)
{//her yeni veri eklendiginde ya da veri silindiginde bastan tekrar aktarma islemi olacak
        tutucu1.removeAll(tutucu1);//listte eski degerleri de oldugu icin devamina eklenmesin diye listi tamamen temizleyecez
        tutucu2.removeAll(tutucu2);
        tutucu3.removeAll(tutucu3);
    for(int i=0;i<myTable.getRowCount();i++)
        {
            tutucu1.add(kon.get(i));
            tutucu2.add(sam.get(i));
            tutucu3.add(sir.get(i));
        }
}
private double AritmetikOrtalama(ArrayList<Double> list)
{
        myTable=(DefaultTableModel)jTable1.getModel();
        int i;
        double toplam =0;
        for(i=0;i<list.size();i++)
        {
            toplam=toplam+list.get(i);
        }
        double ortalama;
        ortalama = toplam/i;
        return ortalama;
}
private double Medyan(ArrayList<Double>list)
{

        Collections.sort(list);//medyani bulmadan once listeki degerleri kucuktern buyuge siralayacaz
        int i,a;
        for(i=0;i<list.size();i++);
        if(i%2==0)
        {
            a=i/2;
            double sonuc=list.get(a-1)+list.get(a);//eger listeki verilerin sayisi ciftse ortadaki ikisinin aritmetik ortalamasi alinir
            sonuc=sonuc/2;
            return sonuc;
        }
        else
        {
            a=(i+1)/2;
            return list.get(a-1);
        }
}
private ArrayList TepeDeger(ArrayList<Double>list)
{//dizide en cok tekrarlanan deger
    //eger dizide butun sayilar esit sekilde tekrarlanmissa mod yoktur
        ArrayList<Integer>temper_mod=new ArrayList<>();//birden fazla mod varsa tutturmak icin list olusturuyoruz
        int sayac=0,temp=0;
        for(int i=0;i<list.size();i++)
        {//listedeki sayilari sirayla listede kac kere gecmis kontrol ediyoruz
            for(int j=0;j<list.size();j++)
            {
                if(list.get(j).equals(list.get(i)))
                {
                    sayac++;
                }
            }//vaka sayisinda tepe deger hep integer olacagindan we convert double type to integer type
            int converter=(int)Math.round(list.get(i));
            if(sayac==temp&&sayac!=1)
            {
                int say1=0;
                for(int k=0;k<temper_mod.size();k++)//eskiden eklenmis sayiyi tepe deger listine tekrar eklememek icin onceden liste olup olmadigini kontrol ediyoruz
                {
                    if(temper_mod.get(k).equals(converter))
                    {
                        say1++;
                    }
                }
                if(say1==0)
                {
                   temper_mod.add(converter);//yoksa listeye ekliyoruz
                }
            }
            else if(sayac>temp&&sayac!=1)
            {
                temp=sayac;
                temper_mod.removeAll(temper_mod);//eger listede tuttugumuz degerden daha cok kez tekrarlanmis baska deger varsa listeyi tamamen temizliyoruz
                temper_mod.add(converter);
            }
            sayac=0;
        }
        return temper_mod;
}

private int DegisimAraligi(ArrayList<Double>list)
{//max-min
        Collections.sort(list);
        int a,b;
        a=(int)Math.round(list.get(list.size()-1));//listtedki en buyuk sayiyinin tipini integere ceviriyoruz
        b=(int)Math.round(list.get(0));
        int d_aralik=a-b;
        return d_aralik;
}
private double AltCeyrek(ArrayList<Double>list)
{
    int sonuc,divider,a;
        if(list.size()%2==0)
        {
            divider=list.size()/2;
            if(divider%2==0)
            {
            a=divider/2;
            double son=list.get(a-1)+list.get(a);//eger listeki verilerin sayisi ciftse ortadaki ikisinin aritmetik ortalamasi alinir
            son=son/2;
            return son;
            }
            else
            {
            a=(divider+1)/2;
            return list.get(a-1);
            }
        }
        else
        {
            sonuc=(list.size()+1)/4;
            return list.get(sonuc-1);
        }
}
        
private double Ustceyrek(ArrayList<Double>list)
{
        int sonuc,divider,a;
        if(list.size()%2==0)
        {
            divider=list.size()/2;
            if(divider%2==0)
            {
            sonuc=((list.size()+1)*3)/4;
            double son=(list.get(sonuc-1)+list.get(sonuc))/2;
            return son;
            }
            else
            {
            sonuc=((list.size()+1)*3)/4;
            return list.get(sonuc-1);
            } 
        }
        else
        {
            sonuc=((list.size()+1)*3)/4;
            return list.get(sonuc-1);
        }
}
private double OrtalamaMutlakSapma(ArrayList<Double>list)
{
        double arort=AritmetikOrtalama(list);
        int i;
        double toplam=0;
        for(i=0;i<list.size();i++)
        {
           toplam+=Math.abs(list.get(i)-arort);//mutlak deger
        }
        double oms=toplam/i;
        return oms;
}
private double VaryansHesapla(ArrayList<Double>list)
{
        double arort=AritmetikOrtalama(list);
        int i;
        double toplam=0;
        for(i=0;i<list.size();i++)
        {
           toplam+=Math.pow(list.get(i)-arort,2);//kare
        }
        double varyans=toplam/(i);
        return varyans;
}
private double StandartSapma(ArrayList<Double>list)
{
        double sonuc=VaryansHesapla(list);
        sonuc=Math.sqrt(sonuc);//karekok
        return sonuc;
}
private double DegisimKatsayisi(ArrayList<Double>list)
{
        return StandartSapma(list)/AritmetikOrtalama(list);
}
private double CeyrekAcikligi(ArrayList<Double>list)
{
        Collections.sort(list);
        double cey_acikligi=Ustceyrek(list)-AltCeyrek(list);
        //System.out.println("ust->"+Ustceyrek(list));
        //System.out.println("alt->"+AltCeyrek(list));
        return cey_acikligi;
}
    private void btn_artorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_artorActionPerformed
        lbl_msg1.setText("Kyrgyzstan->>"+AritmetikOrtalama(kyrgyzstan));
        lbl_msg2.setText("Japan->>"+AritmetikOrtalama(japan));
        lbl_msg3.setText("China->>"+AritmetikOrtalama(china));
    }//GEN-LAST:event_btn_artorActionPerformed

    private void btn_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ekleActionPerformed
        lbl_msg1.setText("Kyrgyzstan:");
        lbl_msg2.setText("Japan:");
        lbl_msg3.setText("China:");
        txt1.setEnabled(true);
        txt2.setEnabled(true);
        txt3.setEnabled(true);
        on_off=true;
    }//GEN-LAST:event_btn_ekleActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        myTable=(DefaultTableModel)jTable1.getModel();
        if(txt1.isEnabled()&&on_off==true)
        {
        Double []data=new Double[4];//yeni girilen degerleri alip tabloya eklemek icin tutucu dizi
        data[0]=(double)myTable.getRowCount()+1;
        data[1]=Double.valueOf(txt1.getText());
        data[2]=Double.valueOf(txt2.getText());
        data[3]=Double.valueOf(txt3.getText());
        myTable.addRow(data);
        //tabloya yeni eklenmis sayilari liste de ekliyoruz
        kyrgyzstan.add(data[1]);
        japan.add(data[2]);
        china.add(data[3]);
        //tutucu listlerimize de aktariyoruz
        Aktarma(kyrgyzstan,japan,china);
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        lbl_msg1.setText("");
        lbl_msg2.setText("");
        lbl_msg3.setText("");
        txt1.setEnabled(false);
        txt2.setEnabled(false);
        txt3.setEnabled(false);
        on_off=false;
         myTable=(DefaultTableModel)jTable1.getModel();
        }
        else if(on_off==true)
        {
        int temp=jTable1.getSelectedRow();
        myTable.removeRow(temp);
        int i;
        for( i=temp;i<myTable.getRowCount();i++)
            myTable.setValueAt(i+1, i,0);
        //secilmis satirdaki verileri listten de siliyoruz
            kyrgyzstan.remove(temp);
            japan.remove(temp);
            china.remove(temp);
        //tutucu listleri de yeniliyoruz
            Aktarma(kyrgyzstan,japan,china);
            on_off=false;
             myTable=(DefaultTableModel)jTable1.getModel();
        }
        else
        {
            lbl_msg1.setText("!!! ilk ekleme ya da");
            lbl_msg2.setText("sil butonlarından birini seçiniz");
            lbl_msg3.setText("");
        }
    }//GEN-LAST:event_btn_okActionPerformed

    private void txt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt3ActionPerformed

    }//GEN-LAST:event_txt3ActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
        lbl_msg1.setText("Tablodan silmek istediginiz ");
        lbl_msg2.setText("satiri seciniz...");
        lbl_msg3.setText("Sonra <ok> butonuna tiklayiniz");
        on_off=true;
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_medyanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_medyanActionPerformed
        lbl_msg1.setText("Kyrgyzstan->>"+Medyan(tutucu1));
        lbl_msg2.setText("Japan->>"+Medyan(tutucu2));
        lbl_msg3.setText("China->>"+Medyan(tutucu3));
    }//GEN-LAST:event_btn_medyanActionPerformed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        lbl_msg1.setText("Kyrgyzstan->>"+TepeDeger(kyrgyzstan));
        lbl_msg2.setText("Japan->>"+TepeDeger(japan));
        lbl_msg3.setText("China->>"+TepeDeger(china));
    }//GEN-LAST:event_btn_modActionPerformed

    private void btn_ceyacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ceyacActionPerformed

        lbl_msg1.setText("Kyrgyzstan->>"+CeyrekAcikligi(kyrgyzstan));
        lbl_msg2.setText("Japan->>"+CeyrekAcikligi(japan));
        lbl_msg3.setText("China->>"+CeyrekAcikligi(china));
    }//GEN-LAST:event_btn_ceyacActionPerformed

    private void btn_boxplotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_boxplotActionPerformed
        myTable=(DefaultTableModel)jTable1.getModel();
        double[] dizi1 = new double[myTable.getRowCount()];
        double[] dizi2 =new double[myTable.getRowCount()];
        double[] dizi3= new double[myTable.getRowCount()];
        for(int i=0;i<myTable.getRowCount();i++)
        {
          dizi1[i]=kyrgyzstan.get(i);
          dizi2[i]=japan.get(i);
          dizi3[i]=china.get(i);
        }
        
        final BoxPlot demo = new BoxPlot("BoxPlot Graphic",dizi1,dizi2,dizi3,myTable.getRowCount()); // creating the MyBoxPlot object  called demo
        demo.pack();      // call the method pack() in it
        RefineryUtilities.centerFrameOnScreen(demo);  // center it in the screen
        demo.setVisible(true);
    }//GEN-LAST:event_btn_boxplotActionPerformed

    private void btn_degisaralıkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_degisaralıkActionPerformed
        lbl_msg1.setText("Kyrgyzstan->>"+DegisimAraligi(kyrgyzstan));
        lbl_msg2.setText("Japan->>"+DegisimAraligi(japan));
        lbl_msg3.setText("China->>"+DegisimAraligi(china));
    }//GEN-LAST:event_btn_degisaralıkActionPerformed

    private void btn_omsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_omsActionPerformed
        lbl_msg1.setText("Kyrgyzstan->>"+OrtalamaMutlakSapma(kyrgyzstan));
        lbl_msg2.setText("Japan->>"+OrtalamaMutlakSapma(japan));
        lbl_msg3.setText("China->>"+OrtalamaMutlakSapma(china));
    }//GEN-LAST:event_btn_omsActionPerformed

    private void btn_varyansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_varyansActionPerformed
        lbl_msg1.setText("Kyrgyzstan->>"+VaryansHesapla(kyrgyzstan));
        lbl_msg2.setText("Japan->>"+VaryansHesapla(japan));
        lbl_msg3.setText("China->>"+VaryansHesapla(china));
    }//GEN-LAST:event_btn_varyansActionPerformed

    private void btn_stdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stdActionPerformed
        lbl_msg1.setText("Kyrgyzstan->>"+StandartSapma(kyrgyzstan));
        lbl_msg2.setText("Japan->>"+StandartSapma(japan));
        lbl_msg3.setText("China->>"+StandartSapma(china));
    }//GEN-LAST:event_btn_stdActionPerformed

    private void btn_dkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dkatActionPerformed
        lbl_msg1.setText("Kyrgyzstan->>"+DegisimKatsayisi(kyrgyzstan));
        lbl_msg2.setText("Japan->>"+DegisimKatsayisi(japan));
        lbl_msg3.setText("China->>"+DegisimKatsayisi(china));
    }//GEN-LAST:event_btn_dkatActionPerformed

    private void btn_dosyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dosyaActionPerformed

        File file = new File("veriler.txt");
        if (!file.exists()) 
        { try {
                file.createNewFile();
              } catch (IOException ex) {
                Logger.getLogger(isatistikBilgiler.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        FileWriter fileWriter = null;
          try {
                fileWriter = new FileWriter(file, false);
              } catch (IOException ex) {
                Logger.getLogger(isatistikBilgiler.class.getName()).log(Level.SEVERE, null, ex);
                }
        PrintWriter pw=new PrintWriter(fileWriter);
        pw.println("\t\tKyrgyzstan:");
        pw.println("Aritmetik ortalama: "+AritmetikOrtalama(kyrgyzstan));
        pw.println("Medyan: "+Medyan(kyrgyzstan));
        pw.println("Tepedeger: "+TepeDeger(kyrgyzstan));
        pw.println("Değişim aralığı: "+DegisimAraligi(kyrgyzstan));
        pw.println("Ortalama Mutlak Sapma: "+OrtalamaMutlakSapma(kyrgyzstan));
        pw.println("Varyans: "+VaryansHesapla(kyrgyzstan));
        pw.println("Değişim Katsayısı: "+DegisimKatsayisi(kyrgyzstan));
        pw.println("Çeyrek Açıklığı: "+CeyrekAcikligi(kyrgyzstan));
//*************************************************
        pw.println("\t\tJapan:");
        pw.println("Aritmetik ortalama: "+AritmetikOrtalama(japan));
        pw.println("Medyan: "+Medyan(japan));
        pw.println("Tepedeger: "+TepeDeger(japan));
        pw.println("Değişim aralığı: "+DegisimAraligi(japan));
        pw.println("Ortalama Mutlak Sapma: "+OrtalamaMutlakSapma(japan));
        pw.println("Varyans: "+VaryansHesapla(japan));
        pw.println("Değişim Katsayısı: "+DegisimKatsayisi(japan));
        pw.println("Çeyrek Açıklığı: "+CeyrekAcikligi(japan));
//***************************************************
        pw.println("\t\tChina:");
        pw.println("Aritmetik ortalama: "+AritmetikOrtalama(china));
        pw.println("Medyan: "+Medyan(china));
        pw.println("Tepedeger: "+TepeDeger(china));
        pw.println("Değişim aralığı: "+DegisimAraligi(china));
        pw.println("Ortalama Mutlak Sapma: "+OrtalamaMutlakSapma(china));
        pw.println("Varyans: "+VaryansHesapla(china));
        pw.println("Değişim Katsayısı: "+DegisimKatsayisi(china));
        pw.println("Çeyrek Açıklığı: "+CeyrekAcikligi(china));
//****************************************************
        pw.close();
        lbl_msg1.setText("verileriniz basariyla");
        lbl_msg2.setText("<veriler> isimli");
        lbl_msg3.setText("dosyaya aktarilmistir:)");
    }//GEN-LAST:event_btn_dosyaActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(isatistikBilgiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(isatistikBilgiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(isatistikBilgiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(isatistikBilgiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    new isatistikBilgiler().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_artor;
    private javax.swing.JButton btn_boxplot;
    private javax.swing.JButton btn_ceyac;
    private javax.swing.JButton btn_degisaralık;
    private javax.swing.JButton btn_dkat;
    private javax.swing.JButton btn_dosya;
    private javax.swing.JButton btn_ekle;
    private javax.swing.JButton btn_medyan;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_oms;
    private javax.swing.JButton btn_sil;
    private javax.swing.JButton btn_std;
    private javax.swing.JButton btn_varyans;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_msg1;
    private javax.swing.JLabel lbl_msg2;
    private javax.swing.JLabel lbl_msg3;
    private javax.swing.JLabel lbl_tittle;
    private javax.swing.JFormattedTextField txt1;
    private javax.swing.JFormattedTextField txt2;
    private javax.swing.JFormattedTextField txt3;
    // End of variables declaration//GEN-END:variables

}
