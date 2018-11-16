
public class HumanReadableDurationFormat {
    
    public static String formatDuration(int seconds) {
        // your code goes here
        
        if (seconds == 0) return "now";
        
        final int year   = 60*60*24*365;
        final int day    = 60*60*24;
        final int hour   = 60*60;
        final int minute = 60;
        
        int secRemaining = seconds;
        int y = (seconds/year); secRemaining = (seconds%year);
        int d = (secRemaining/day); secRemaining = (seconds%day);
        int h = (secRemaining/hour); secRemaining = (seconds%hour);
        int m = (secRemaining/minute); secRemaining = (seconds%minute);
        
        StringBuilder out = new StringBuilder();
        
        out.append((y>0)? y + " year" + (y>1? "s":"") : "");
        if (((h + m + secRemaining) == 0) && (d!=0) && (y>0))     out.append(" and "); else out.append(((d!=0)&&(y>0))? ", ": "");
        
        out.append((d>0)? d + " day"  + (d>1? "s":"") : "");
        if (((m + secRemaining) == 0) && (h!=0) && (d>0))     out.append(" and "); else out.append(((h!=0)&&(d>0))? ", ": "");
        
        out.append((h>0)? h + " hour" + (h>1? "s":"") : "");
        if (((secRemaining) == 0) && (m!=0) && (h>0))     out.append(" and "); else out.append(((m!=0)&&(h>0))? ", ": "");
        
        out.append((m>0)? m + " minute"  + (m>1? "s":"") : "");
        if ((secRemaining != 0)&& (m>0))     out.append(" and "); 

        out.append((secRemaining>0)? secRemaining+ " second" + (secRemaining>1? "s":"") : "");
        
        return out.toString();
    }
}
