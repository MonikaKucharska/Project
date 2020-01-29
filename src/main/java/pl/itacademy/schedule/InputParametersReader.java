package pl.itacademy.schedule;

import org.apache.commons.cli.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InputParametersReader {
    public LessonParameters readParameters(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("n",true,"number of required hours");
        options.addOption("f",true,"file name");
        options.addOption("h", false, "show help");
        options.addOption("d", true, "lesson days");
        options.addOption("b",true,"lesson begin time");
        options.addOption("e",true,"lesson end time");
        options.addOption("s",true,"start date");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);

        int numberOfHours = 0;
        if(cmd.hasOption("n")){
            String value = cmd.getOptionValue("n");
            numberOfHours =Integer.parseInt(value);
        }

        String fileName = "";
        if(cmd.hasOption("f")){
            fileName=cmd.getOptionValue("f");
        }

        boolean showHelp = cmd.hasOption("h");

        Set<DayOfWeek> lessonDays = new HashSet<>();
        if (cmd.hasOption("d")) {
            String value = cmd.getOptionValue("d").toUpperCase();
            DayOfWeek[] dayOfWeek = DayOfWeek.values();
            for (DayOfWeek day:dayOfWeek) {
                if(value.contains(day.name())){
                    lessonDays.add(day);
                }
            }
        }

        LocalTime beginTime = LocalTime.now();
        if(cmd.hasOption("b")){
            String value = cmd.getOptionValue("b");
            beginTime = LocalTime.parse(value);
        }

        LocalTime endTime = LocalTime.now();
        if(cmd.hasOption("e")){
            String value = cmd.getOptionValue("e");
            endTime = LocalTime.parse(value);
        }

        LocalDate startDate = LocalDate.now();
        if(cmd.hasOption("s")){
            String value = cmd.getOptionValue("s");
            startDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("d.M.yyyy"));
        }

        return new LessonParameters.Builder(beginTime, endTime, numberOfHours, lessonDays, startDate).fileName(fileName).
                showHelp(showHelp).build();
    }
}