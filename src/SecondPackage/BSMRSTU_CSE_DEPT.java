package SecondPackage;


import java.io.Serializable;

public class BSMRSTU_CSE_DEPT implements Serializable {

    private static final long serialVersionUID = 42L;

    private static int count = 1;
    private int ID;
    private String name;
    private String id;
    private String session;
    private String batch;
    private String mobile;
    private String district;


    public BSMRSTU_CSE_DEPT(String name, String id, String session, String batch, String mobile, String district) {
        this.ID = count++;
        this.name = name;
        this.id = id;
        this.session = session;
        this.batch = batch;
        this.mobile = mobile;
        this.district = district;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

}
