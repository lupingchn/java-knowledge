package base.design.pattern.adapter;

/**
 * @author root on 2019/2/24.
 */
public class CmbcBankAdapterImpl implements BankAdapterService {

    private CmbcBankServiceImpl cmbcBankService = new CmbcBankServiceImpl();

    @Override
    public double queryBorrowRate() {
        return new Double(cmbcBankService.queryBorrowRateWithString());
    }
}
