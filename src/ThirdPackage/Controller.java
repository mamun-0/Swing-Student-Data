package ThirdPackage;

import FirstPackage.FormEvent;
import SecondPackage.BSMRSTU_CSE_DEPT;
import SecondPackage.StoreData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    StoreData storeData = new StoreData();
    public void addStudent(FormEvent event) {
        String name = event.getName();
        String id = event.getId();
        String session = event.getSession();
        String batch = event.getBatch();
        String mobile = event.getMobile();
        String district = event.getDistrict();

        BSMRSTU_CSE_DEPT bsmrstuCseDept = new BSMRSTU_CSE_DEPT(name,id,session,batch,mobile,district);
        storeData.addStudent(bsmrstuCseDept);
    }
    public List<BSMRSTU_CSE_DEPT> getStudent(){
        return storeData.getStudent();
    }
    public void saveFile(File file) throws IOException {
        storeData.saveFile(file);
    }
    public void loadFile(File file) throws IOException {
        storeData.loadFile(file);
    }

    public void removeStudent(int row) {
        storeData.removeStudent(row);
    }
}