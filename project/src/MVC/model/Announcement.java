package MVC.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Announcement implements Comparable<Announcement>
{
    private String user;
    private String announcement;
    private LocalDate date;
    private String groupName;

    public Announcement(String announcement, String username){
        user = username;
        this.announcement = announcement;
        date = LocalDate.now();
    }

    public String getUser()
    {
        return user;
    }

    public String getAnnouncement()
    {
        return announcement;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    //ONLY USED FOR TESTING
    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String printForHub()
    {
        String output = "%s, %s\n%-20s\n\n";
        return String.format(output, user, date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), announcement);

        //return user + "\t\t" + date + "\n" + announcement + "\n\n";
    }

    public String printForDashboard()
    {
        String output = ", %s\n%-20s\n\n";
        return String.format(output, date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), announcement);
    }

    @Override
    public String toString()
    {
        return user + ", " + date + ", " + announcement;
    }

    @Override
    public int compareTo(Announcement o){
        return getDate().compareTo(o.getDate());
    }
}
