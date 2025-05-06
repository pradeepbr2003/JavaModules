package job.search;

import job.search.common.AccountHolderEnum;
import job.search.helper.ATMHelper;

import java.util.Arrays;

public class ATMExample {
    public static void main(String[] args) {
        Arrays.stream(AccountHolderEnum.values()).map(ATMHelper::getAccount).limit(10)
                .forEach(ATMHelper::transaction);
    }
}