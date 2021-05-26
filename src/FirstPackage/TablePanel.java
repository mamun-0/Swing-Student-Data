package FirstPackage;

import SecondPackage.BSMRSTU_CSE_DEPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablePanel extends JPanel {

    private JTable jTable;
    private StudentTableModel tableModel;
    private JPopupMenu popupMenu;
    private StudentListener studentListener;

    public TablePanel() {
        tableModel = new StudentTableModel();
        jTable = new JTable(tableModel);
        popupMenu = new JPopupMenu();
        JMenuItem removeRow = new JMenuItem("Delete");
        popupMenu.add(removeRow);
        setLayout(new BorderLayout());
        add(new JScrollPane(jTable), BorderLayout.CENTER);



        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = jTable.rowAtPoint(e.getPoint());
                System.out.println(row);
                if (e.getButton() == MouseEvent.BUTTON3)
                    popupMenu.show(jTable, e.getX(),e.getY());
            }
        });
        removeRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTable.getSelectedRow();
                if (studentListener!=null){
                    studentListener.deletedRow(row);
                    tableModel.fireTableRowsDeleted(row,row);
                }
            }
        });
    }

    public void setData(List<BSMRSTU_CSE_DEPT> student) {
        tableModel.setData(student);
    }
    public void refresh(){
        tableModel.fireTableDataChanged();
    }

    public void setListener(StudentListener studentListener) {
        this.studentListener = studentListener;
    }
}
