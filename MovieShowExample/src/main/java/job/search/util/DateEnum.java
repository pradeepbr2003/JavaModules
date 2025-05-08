package job.search.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public enum DateEnum {

    SHOW_TIME(List.of("11:30 am", "2:30 pm", "5:30 pm", "8:30 pm"));

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

    private List<Date> show_time;

    DateEnum(List<String> time) {
        show_time = time.stream().map(t -> {
                    StringBuffer sbf = new StringBuffer();
                    String dateStr = sbf.append(sdf.format(new Date())).append(" ").append(t).toString();
                    return new Date(dateStr);
                }
        ).toList();
    }

    public List<Date> get() {
        return this.show_time;
    }
}
