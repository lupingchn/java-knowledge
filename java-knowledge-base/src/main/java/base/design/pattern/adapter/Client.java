package base.design.pattern.adapter;

import base.design.pattern.util.XMLUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author root on 2019/2/24.
 */
@Slf4j
public class Client {

    public static double queryBorrowRateByBank(String bankServiceName){
        BankAdapterService bankAdapterService = (BankAdapterService) XMLUtil.getBean(bankServiceName);
        return bankAdapterService.queryBorrowRate();
    }

    public static void main(String[] args){
        double cmbcBorrowRate = queryBorrowRateByBank("cmbcBankAdapter");
        log.info("cmbcBorrowRate = {}", cmbcBorrowRate);

        double cebBorrowRate = queryBorrowRateByBank("cebBankAdapter");
        log.info("cebBorrowRate = {}", cebBorrowRate);
    }

}
