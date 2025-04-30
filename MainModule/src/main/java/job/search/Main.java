package job.search;

import job.search.business.logic.ExecuteJar;
import job.search.business.logic.IMain;

public class Main implements IMain {

    public static void main(String[] args) {
        jarList.forEach(ExecuteJar::run);
    }

}
