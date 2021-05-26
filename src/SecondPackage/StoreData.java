package SecondPackage;

import java.io.*;
import java.util.*;

public class StoreData {
    private List<BSMRSTU_CSE_DEPT> bsmrstu_cse_depts;

    public StoreData(){
        bsmrstu_cse_depts = new LinkedList<>();
    }

    public void addStudent(BSMRSTU_CSE_DEPT bsmrstuCseDept){
        bsmrstu_cse_depts.add(bsmrstuCseDept);

    }
    public List<BSMRSTU_CSE_DEPT> getStudent(){
        return Collections.unmodifiableList(bsmrstu_cse_depts);
    }
    public void saveFile(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        BSMRSTU_CSE_DEPT[] students = bsmrstu_cse_depts.toArray(new BSMRSTU_CSE_DEPT[bsmrstu_cse_depts.size()]);
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
    }
    public void loadFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            BSMRSTU_CSE_DEPT[] students = (BSMRSTU_CSE_DEPT[]) objectInputStream.readObject();
            bsmrstu_cse_depts.clear();
            bsmrstu_cse_depts.addAll(Arrays.asList(students));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        objectInputStream.close();
    }

    public void removeStudent(int row) {
        bsmrstu_cse_depts.remove(row);
    }
}
