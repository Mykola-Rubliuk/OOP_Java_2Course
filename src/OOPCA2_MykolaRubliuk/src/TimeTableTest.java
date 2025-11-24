package OOPCA2_MykolaRubliuk.src;

import javax.swing.*;

public class TimeTableTest {
    public static void main(String[] args) {
        Module OOP = new Module("Object Oriented Programming", 10, 2, 6, new String[]{"KCOMP_B_2S", "KCOMP_B_2G", "KCOMP_D_2S", "KCOMP_D_2G", "KCPGD_B", "KCPGD_D", "KCPSD_B", "KCPSD_D"}, new String[]{"John Brosnan"});
        Module routing = new Module("Routing Concepts & Protocols", 5, 2, 2, new String[]{"KCOMP_B_2S", "KCOMP_B_2G", "KCOMP_D_2S", "KCOMP_D_2G", "KCPGD_B", "KCPGD_D", "KCPSD_B", "KCPSD_D"}, new String[]{"Fergus McLysaght"});
        Module clientSide = new Module("Client Side Scripting", 5, 0, 4, new String[]{"TL_KCOMP_B_2S", "TL_KCOMP_D_2S", "TL_KCPSD_B", "TL_KCPSD_D"}, new String[]{"Anne O' Brien"});
        Module DBProgramming = new Module("Database Programming", 5, 2, 2, new String[]{"TL_KCOMP_B_2S", "TL_KCOMP_B_2G", "TL_KCOMP_D_2S", "TL_KCOMP_D_2G", "TL_KCPGD_B", "TL_KCPGD_D", "TL_KCPSD_B", "TL_KCPSD_D"}, new String[]{"Peter Given"});
        Module requirementsEng = new Module("Requirements Engineering", 5, 2, 2, new String[]{"TL_KCOMP_B_2S", "TL_KCOMP_B_2G", "TL_KCOMP_D_2S", "TL_KCOMP_D_2G", "TL_KCPGD_B", "TL_KCPGD_D", "TL_KCPSD_B", "TL_KCPSD_D"}, new String[]{"Catherine Woods"});

        Class OOPClass = new Class(OOP, "R302", "John Brosnan", "Lab");
        Class routingClass = new Class(routing, "T106", "Fergus McLysaght", "Lecture");
        Class webClass = new Class(clientSide, "S304", "Anne O' Brien", "Lab");
        Class DBProgrammingClass = new Class(DBProgramming, "S302", "Peter Given", "Lab");
        Class requirementsClass = new Class(requirementsEng, "T118", "Catherine Woods", "Lecture");

        TimeTable timeTable = new TimeTable("KCOMP_B_2S", 10);
        timeTable.displayTimeTable();
        timeTable.addClass("Wednesday",11,1, OOPClass);
        timeTable.addClass("Monday",2,4,routingClass);
        timeTable.addClass("Wednesday",9,11,webClass);
        timeTable.addClass("Friday",11,1,DBProgrammingClass);
        timeTable.addClass("Tuesday",9,11,requirementsClass);

        timeTable.displayTimeTable();

        JOptionPane.showMessageDialog(null, "The total number of timetabled hours per week for this group is " + timeTable.getWeeklyHours());
    }
}
