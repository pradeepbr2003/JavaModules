package job.search.helper;

import job.search.dto.Theatre;

import java.util.Date;
import java.util.List;

import static job.search.util.DateEnum.SHOW_TIME;

public enum MovieShowEnum {

    MOVIE_SHOW(SHOW_TIME.get());

    private MoveShowHelper helper;

    MovieShowEnum(List<Date> time) {
        helper = () -> MoveShowHelper.bookShow(new Theatre("Narthaki"), time);
    }

    public MoveShowHelper get() {
        return this.helper;
    }

}