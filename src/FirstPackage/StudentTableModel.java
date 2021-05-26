package FirstPackage;

import SecondPackage.BSMRSTU_CSE_DEPT;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {

    private List<BSMRSTU_CSE_DEPT> person;
    final String[] columnName = {"Serial","Name","ID","Session","Batch","Mobile","District"};
    public StudentTableModel() {
    }

    public void setData(List<BSMRSTU_CSE_DEPT> person) {
        this.person = person;
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public int getRowCount() {
        return person.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BSMRSTU_CSE_DEPT bsmrstuCseDept = person.get(rowIndex);
        switch (columnIndex){
            case 0:
                return bsmrstuCseDept.getID();
            case 1:
                return bsmrstuCseDept.getName();
            case 2:
                return bsmrstuCseDept.getId();
            case 3:
                return bsmrstuCseDept.getSession();
            case 4:
                return bsmrstuCseDept.getBatch();
            case 5:
                return bsmrstuCseDept.getMobile();
            case 6:
                return bsmrstuCseDept.getDistrict();
        }
        return null;
    }
}
