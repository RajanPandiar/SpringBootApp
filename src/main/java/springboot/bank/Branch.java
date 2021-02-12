package springboot.bank;

public class Branch {
    private String name;
    private int pinCode;

    public Branch(String name,int pinCode) {
        this.name = name;
        this.pinCode = pinCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
