/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kitchenscreen;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.mulcam.ai.web.vo.OrderVO;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author 484342
 */
public class Ui extends javax.swing.JFrame {
    String columnNames[];
    ObjectOutputStream out;
    JComboBox comboBox;
    JFrame qrFrame;
    JLabel qr;
    Object order_group_no;

    /**
     * Creates new form Ui
     */
    public Ui() {
        initComponents();
        serverConnect();
        columnNames=new String[]{"order_group_no","prodname","quantity","ordermethod","orderdate","상황"};
        
        qrFrame = new JFrame();
        qr = new JLabel();
        qrFrame.getContentPane().add(qr);
        qrFrame.setLocation(300,400);
        
        tableEvent();
    }
    private void tableEvent(){
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
            ListSelectionModel data = jTable1.getSelectionModel();
            data.addListSelectionListener((e)->{
                if(e.getValueIsAdjusting()) {
                    try {
//                  System.out.println(jTable1.getSelectedRow());
                    order_group_no = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
                    System.out.println(order_group_no);
                    }catch (Exception ex) {
                    }            
                }
            });
//        jTable1.getSelectionModel().addListSelectionListener((e)->{
//            if(e.getValueIsAdjusting()){                    
//                int row = jTable1.getSelectedRow();
//               // int col2 = jTable1.getSelectedColumn();
//                Object order_group_no=jTable1.getModel().getValueAt(row, 0 );
//                Object status=jTable1.getModel().getValueAt(row, 5 );
//           }            
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("주문 출고 현황", jPanel1);

        jButton1.setText("새로고침");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // 새로고침 버튼 처리
            out.writeObject("ordersSelect");
            System.out.println("새로고침요청");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void serverConnect() {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("config.properties"));
            String ip = (String) prop.get("server.ip");
            String port=(String) prop.get("server.port");
            System.out.println(ip+":"+port);
            Socket s=new Socket(ip,Integer.parseInt(port));
            out=new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(s.getInputStream());     
            new Thread(()->{
                while(true){
                    try {
                        List<OrderVO> list=(List<OrderVO>) in.readObject();
                        System.out.println(list);
                        Object [][]data=new Object[list.size()][6];
                        int i=0;
                        for(OrderVO vo:list){
                            data[i][0]=vo.getOrder_group_no();                           
                            data[i][1]=vo.getProduct_name();
                            data[i][2]=vo.getQuantity();
                            data[i][3]=vo.getOrdermethod();
                            data[i][4]=vo.getOrderdate();
                            data[i++][5]="준비";                               
                        }
                        jTable1.setModel(new DefaultTableModel(data, columnNames));
                        comboBox = new JComboBox(); 
                        comboBox.addItem("준비"); 
                        comboBox.addItem("완료"); 
                        TableColumn col=jTable1.getColumn("상황");
                        col.setCellEditor(new DefaultCellEditor(comboBox));
                        jTable1.repaint();
                        comboBoxEvent();

                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
                System.out.println("서버 연결 완료");
        } catch (IOException ex) {
            Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void comboBoxEvent() {
        System.out.println("comboBoxEvent() 호출됨");
        comboBox.addActionListener((e)->{
            String status=comboBox.getSelectedItem().toString();
            System.out.println("콤보 박스 눌림" + status);
            if(status.equals("완료")){
                System.out.println("QR생성");                
                
                try {
                    Properties prop = new Properties();
                    prop.load(new FileReader("config.properties"));
                    String ip = (String)prop.get("server.ip");
                    URL url = new URL("http://api.qrserver.com/v1/create-qr-code/?size=150x150&data=http://"+ip+":8090/output.jes?order_group_no="+order_group_no);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    System.out.println("응답메세지 : " + con.getResponseMessage());
                    
                    // QR 받기 [응답 내용(BODY) 구하기]
                    try (InputStream in = con.getInputStream()) {
                            byte[] buf_in = new byte[1024 * 8];
                            int length = 0;
                            while ((length = in.read(buf_in)) != -1) {
                            }                            
                            
                            qr.setIcon(new ImageIcon(buf_in));
                            qrFrame.pack();
                            qrFrame.setVisible(true);
                                      
                    }
                    // 접속 해제
                    con.disconnect();


                } catch (Exception ex) {
                    
                }
                

            }
        });
    }

}