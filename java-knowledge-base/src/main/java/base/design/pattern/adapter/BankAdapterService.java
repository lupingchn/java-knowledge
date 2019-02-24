package base.design.pattern.adapter;

import java.math.BigDecimal;

/**
 * @author root on 2019/2/24.
 */
public interface BankAdapterService {

    /**
     * 查询利率，返回小数（未百分比）
     * @return
     */
    double queryBorrowRate();

}
