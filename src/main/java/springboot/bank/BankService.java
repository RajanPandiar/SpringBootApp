package springboot.bank;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    private List<Bank> bankList;

    public BankService() {
        bankList = new ArrayList<>();
        initializeTestData();
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public Bank getBankDetails(String bankName) {

       for (int i = 0;i<bankList.size();i++) {
           if (bankList.get(i).getBankName().equalsIgnoreCase(bankName)) {

               return bankList.get(i);
           }
       }
       return null;
    }

    public void addBank(Bank bank){
        bankList.add(bank);
    }

    public void updateBank(Bank bank,String bankName) {
        for(int i= 0;i<bankList.size();i++) {
            Bank currentBank = bankList.get(i);
            if(currentBank.getBankName().equalsIgnoreCase(bankName)) {
                bankList.set(i,bank);
                return;
            }
        }
    }

    public void deleteBank(String bankName) {
        for(int i= 0;i<bankList.size();i++) {
            if(bankList.get(i).getBankName().equalsIgnoreCase(bankName)) {
                bankList.remove(bankList.get(i));
                return;
            }
        }
    }

    public void initializeTestData() {

        Bank SBIBANK = new Bank("SBI","H79SK");
        Bank ICICIBANK = new Bank("ICICI","ID78L");
        Bank HDFC = new Bank ("HDFC","HDNFS");
        Bank PNB = new Bank ("PNB","PNBDS");

        ArrayList<Branch> sbiBranches =new ArrayList<>();
        sbiBranches.add(new Branch("KK NAGAR",512212));
        sbiBranches.add(new Branch("T NAGAR",399280));
        sbiBranches.add(new Branch("Anna NAGAR",399280));
        SBIBANK.setBranches(sbiBranches);

        ArrayList<Branch> iciciBranches =new ArrayList<>();
        iciciBranches.add(new Branch("Velachery",878978));
        iciciBranches.add(new Branch("Siruseri",624515));
        iciciBranches.add(new Branch("Thoraipakkam",541515));
        ICICIBANK.setBranches(iciciBranches);

        ArrayList<Branch> hdfcBranches = new ArrayList<>();
        hdfcBranches.add(new Branch("Tambaram",525265));
        hdfcBranches.add(new Branch("pallavaram",876786));
        hdfcBranches.add(new Branch("Guindy",9787833));
        HDFC.setBranches(hdfcBranches);

        ArrayList<Branch> pnbBranches = new ArrayList<>();
        pnbBranches.add(new Branch("tamabaram",8768687));
        pnbBranches.add(new Branch("Guindy",8768687));

        this.bankList.add(SBIBANK);
        this.bankList.add(ICICIBANK);
        this.bankList.add(HDFC);
        this.bankList.add(PNB);

    }

}
