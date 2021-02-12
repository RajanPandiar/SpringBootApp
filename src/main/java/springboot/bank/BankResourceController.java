package springboot.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankResourceController {

    @Autowired
    BankService bankService;

    @RequestMapping("/banks")
    public List getBankData() {
       return bankService.getBankList();
    }

    @RequestMapping("/banks/{bankName}")
    public Bank getBank(@PathVariable String bankName) {
        return bankService.getBankDetails(bankName);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/banks")
    public void addBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/banks/{bankName}")
    public void updateBank(@RequestBody Bank bank,@PathVariable String bankName) {
        bankService.updateBank(bank,bankName);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/banks/{bankName}")
    public void deleteBank(@PathVariable String bankName) {
        bankService.deleteBank(bankName);
    }
}
