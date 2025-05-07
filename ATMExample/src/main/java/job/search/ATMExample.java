package job.search;

import job.search.helper.ATMHelper;

import static job.search.helper.ATMHelper.accountList;

public class ATMExample {
    public static void main(String[] args) {
        accountList.forEach(ATMHelper::openAccount);
        accountList.forEach(ATMHelper::depositAmount);
        accountList.forEach(ATMHelper::withDrawAmount);
    }
}