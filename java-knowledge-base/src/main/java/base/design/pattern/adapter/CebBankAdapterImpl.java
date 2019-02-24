package base.design.pattern.adapter;

/**
 * @author root on 2019/2/24.
 */
public class CebBankAdapterImpl implements BankAdapterService {

    private CebBankServiceImpl cebBankService = new CebBankServiceImpl();

    @Override
    public double queryBorrowRate() {
        return cebBankService.queryBorrowRateWithPercent()/100;
    }
}
