package springboot.bank;

import java.util.ArrayList;

public class Bank {

    private String bankName;
    private String code;
    private ArrayList<Branch> branches;


    public Bank(String bankName, String code) {
        super();
        this.bankName = bankName;
        this.code = code;
        this.branches = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public String getCode() {
        return code;
    }


    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public boolean addBranch(String branchName,int pinCode) {
        //It returns true if the branch was added successfully or false otherwise.
        if( findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName, pinCode));
            return true;
        }
        return false;
    }

    public Branch findBranch(String branchName) {
        //Return the Branch if it exists or null otherwise.
        for(int i =0;i< branches.size();i++) {
            if (branches.get(i).getName().equalsIgnoreCase(branchName)){
                return branches.get(i);
            }
        }
        return null;
    }

}
