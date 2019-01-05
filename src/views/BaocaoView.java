/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.BaoCaoNhanVien;
import dao.NhanvienDAO;
import dao.PhongbanDAO;
import model.CoutNamTuyenDung;
import model.NhanvienPhongban;
import model.Phongban;
import model.PhuCapDTO;

/**
 *
 * @author Huy Le
 */
public class BaocaoView extends JPanel {

    //JPanel
    JPanel pnlBaoCao = new JPanel();
    JPanel pnlTop = new JPanel();
    JPanel pnlTopT = new JPanel();
    JPanel pnlTopH = new JPanel();
    JPanel pnlTopM = new JPanel();
    JPanel pnlMid = new JPanel();
    JPanel pnlMidH = new JPanel();
    JPanel pnlMidM = new JPanel();
    JPanel pnlBottom = new JPanel();
    JPanel pnlBottomH = new JPanel();
    JPanel pnlBottomM = new JPanel();

    //JLable
    JLabel lblTieuDe = new JLabel("Báo cáo");
    JLabel lblBc1 = new JLabel("Thống kê số lượng nhân viên theo năm tuyển dụng");
    JLabel lblBc2 = new JLabel("Thống kê số lượng nhân viên theo phòng ban");
    JLabel lblBc3 = new JLabel("Liệt kê danh sách nhân viên có phụ cấp chức vụ");

    //JTable
    JTable tbBc1 = new JTable();
    JTable tbBc2 = new JTable();
    JTable tbBc3 = new JTable();

    //------------------------------------------
    private String header[] = {"STT", "Năm tuyển dụng","Số lượng nhân viên"};
	private String header1[] = {"STT", "Phòng ban","Số lượng nhân viên"};
	private String header2[] = {"STT","Mã nhân viên","Họ tên","Chuyên môn","Tên chức vụ","Học vị","Hệ số phụ cấp"};
    //------------------------------------------
    private DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    private DefaultTableModel tblModel1 = new DefaultTableModel(header1, 0);
    private DefaultTableModel tblModel2 = new DefaultTableModel(header2, 0);
    private PhongbanDAO pbdao= new PhongbanDAO();
    private NhanvienDAO nvdao= new NhanvienDAO();
    private Phongban pb= new Phongban();
    private BaoCaoNhanVien bcnv=new BaoCaoNhanVien();
    //------------------------------------------
//    ArrayList<BCTCL> ListBCTCL = null;
    List<CoutNamTuyenDung> ListBCTCL=null;
    ArrayList<NhanvienPhongban> ListBCNVPB = null;
    List<PhuCapDTO> ListBCTHH = null;
    //------------------------------------------
 
    //------------------------------------------

    public BaocaoView()  {
        init();
        try {
			loadBCCL();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			loadBCNVPB();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			loadBCHH();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.setVisible(true);
    }

    public void init() {
    	this.setSize(1200,600);
        //SetColor
        Color color = new Color(46, 139, 87);
        lblBc1.setForeground(color);
        lblBc2.setForeground(color);
        lblBc3.setForeground(color);

        //SetLayout    
        pnlBaoCao.setLayout(new BorderLayout());
        pnlTop.setLayout(new BorderLayout());
        pnlTopT.setLayout(new BorderLayout());
        pnlTopH.setLayout(new BorderLayout());
        pnlTopM.setLayout(new BorderLayout());
        pnlMid.setLayout(new BorderLayout());
        pnlMidH.setLayout(new BorderLayout());
        pnlMidM.setLayout(new BorderLayout());
        pnlBottom.setLayout(new BorderLayout());
        pnlBottomH.setLayout(new BorderLayout());
        pnlBottomM.setLayout(new BorderLayout());
        //------------------------------------------

        pnlTopT.add(lblTieuDe, BorderLayout.LINE_START);

        pnlTopH.add(lblBc1);
        pnlMidH.add(lblBc2);
        pnlBottomH.add(lblBc3);
        //------------------------------------------

        lblTieuDe.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        lblBc1.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        lblBc2.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        lblBc3.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        pnlTopT.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        pnlTopM.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        pnlMidM.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        pnlBottomM.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        pnlTopT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.darkGray));
        pnlTopH.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, color));
        pnlMidH.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, color));
        pnlBottomH.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, color));

        //------------------------------------------
        pnlTopM.add(tbBc1, BorderLayout.NORTH);
        pnlMidM.add(tbBc2, BorderLayout.NORTH);
        pnlBottomM.add(tbBc3, BorderLayout.NORTH);

        pnlTop.add(pnlTopT, BorderLayout.NORTH);
        pnlTop.add(pnlTopH, BorderLayout.CENTER);
        pnlTop.add(pnlTopM, BorderLayout.SOUTH);

        pnlMid.add(pnlMidH, BorderLayout.NORTH);
        pnlMid.add(pnlMidM, BorderLayout.CENTER);

        pnlBottom.add(pnlBottomH, BorderLayout.NORTH);
        pnlBottom.add(pnlBottomM, BorderLayout.CENTER);

        pnlBaoCao.add(pnlTop, BorderLayout.NORTH);
        pnlBaoCao.add(pnlMid, BorderLayout.CENTER);
        pnlBaoCao.add(pnlBottom, BorderLayout.SOUTH);
        //------------------------------------------

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        Object[][] data = {};
        tbBc1.setModel(new DefaultTableModel(data, header));
        tbBc1.setPreferredScrollableViewportSize(new Dimension(1190, 110));
        tbBc1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbBc1.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tbBc1);
        pnlTopM.add(scrollPane);
        tbBc1.setFillsViewportHeight(true);
        TableColumn column = null;
        tbBc1.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbBc1.getColumnModel().getColumn(1).setPreferredWidth(570);
        tbBc1.getColumnModel().getColumn(2).setPreferredWidth(570);
     
        
        tbBc1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbBc1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbBc1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbBc1.setDefaultEditor(Object.class, null);
        pnlTopM.add(scrollPane);

        Object[][] data1 = {};
        tbBc2.setModel(new DefaultTableModel(data1, header1));
        tbBc2.setPreferredScrollableViewportSize(new Dimension(1190, 110));
        tbBc2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbBc2.setFillsViewportHeight(true);
        JScrollPane scrollPane11 = new JScrollPane(tbBc2);
        pnlMidM.add(scrollPane11);
        tbBc2.setFillsViewportHeight(true);
        TableColumn column1 = null;
        tbBc2.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbBc2.getColumnModel().getColumn(1).setPreferredWidth(570);
        tbBc2.getColumnModel().getColumn(2).setPreferredWidth(570);

        
        tbBc2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbBc2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbBc2.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbBc2.setDefaultEditor(Object.class, null);
        pnlMidM.add(scrollPane11);

        Object[][] data2 = {};
        tbBc3.setModel(new DefaultTableModel(data2, header2));
        tbBc3.setPreferredScrollableViewportSize(new Dimension(1190, 110));
        tbBc3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbBc3.setFillsViewportHeight(true);
        JScrollPane scrollPane2 = new JScrollPane(tbBc3);
        pnlBottomM.add(scrollPane2);
        tbBc3.setFillsViewportHeight(true);
        TableColumn column2 = null;
        tbBc3.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbBc3.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbBc3.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbBc3.getColumnModel().getColumn(3).setPreferredWidth(300);
        tbBc3.getColumnModel().getColumn(4).setPreferredWidth(200);
        tbBc3.getColumnModel().getColumn(5).setPreferredWidth(200);
        tbBc3.getColumnModel().getColumn(6).setPreferredWidth(140);
       
          
        tbBc3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbBc3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbBc3.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tbBc3.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tbBc3.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tbBc3.setDefaultEditor(Object.class, null);
        pnlBottomM.add(scrollPane2);
        this.add(pnlBaoCao);
    }

    private void loadBCCL() throws DBException {
        tblModel = (DefaultTableModel) tbBc1.getModel();
        tblModel.setRowCount(0);
        try {
            ListBCTCL =bcnv.CountNvByNamTuyenDung();
            int num = 0;
            for (CoutNamTuyenDung b : ListBCTCL) {
                
                Object row[] = new Object[]{++num, b.getNam(), b.getSoLuong()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBCNVPB() throws DBException {
        tblModel1 = (DefaultTableModel) tbBc2.getModel();
        tblModel1.setRowCount(0);
        try {
        	ListBCNVPB = new NhanvienDAO().getAllNhanvienPhongban();
            int num = 0;
            for (NhanvienPhongban b : ListBCNVPB) {
               
            	 Object row[] = new Object[]{++num,  pbdao.find(b.getMaphongban()).getTenphongban(), b.getSonhanvien()};
                tblModel1.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBCHH() throws DBException {
        tblModel2 = (DefaultTableModel) tbBc3.getModel();
        tblModel2.setRowCount(0);
        try {
            ListBCTHH = nvdao.getAllNhanVienByPhuCap();
            int num = 0;
            for (PhuCapDTO b : ListBCTHH) {
                Object row[] = new Object[]{++num,b.getMaNv(),b.getTenNv(),b.getChuyenMon(),b.getChucVu(),b.getHocVi(),b.getHeSoPC() };
                tblModel2.addRow(row);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws DBException {
    	JFrame frame= new JFrame();
    	frame.setVisible(true);
    	
    	BaocaoView bc= new BaocaoView();
    	bc.setVisible(true);
    	frame.getContentPane().add(bc);
    }
}
