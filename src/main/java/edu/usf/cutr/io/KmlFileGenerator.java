package edu.usf.cutr.io;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Jennysanchez on 5/26/2016.
 */
public class KmlFileGenerator {

    private int i = 1;
    private int j = 1;

    public KmlFileGenerator(PrintWriter kmlFile) {
        init(kmlFile);
    }

    private void init(PrintWriter writer) {

        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.write("\n<kml xmlns=\"http://earth.google.com/kml/2.1\">");
        writer.write("\n<Document>");
        writer.write("\n<Style id=\"lastStopHighlight\">");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n<IconStyle>");
        writer.write("\n<scale>1.18182</scale>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/shapes/bus.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n</Style>");
        writer.write("\n<Style id=\"lastStopNormal\">");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>1</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n<IconStyle>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/shapes/bus.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n</Style>");
        writer.write("\n<StyleMap id=\"lastStopStyleMap\">");
        writer.write("\n<Pair>");
        writer.write("\n<key>normal</key>");
        writer.write("\n<styleUrl>#lastStopNormal</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n<Pair>");
        writer.write("\n<key>highlight</key>");
        writer.write("\n<styleUrl>#lastStopHighlight</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n</StyleMap>");

        writer.write("\n<Style id=\"ArrowHighlight\">");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n<IconStyle>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/paddle/wht-blank.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n</Style>");
        writer.write("\n<Style id=\"ArrowNormal\">");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n<IconStyle>");
        writer.write("\n<scale>0.5</scale>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/paddle/wht-blank.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n</Style>");
        writer.write("\n<StyleMap id=\"ArrowStyleMap\">");
        writer.write("\n<Pair>");
        writer.write("\n<key>normal</key>");
        writer.write("\n<styleUrl>#ArrowNormal</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n<Pair>");
        writer.write("\n<key>highlight</key>");
        writer.write("\n<styleUrl>#ArrowHighlight</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n</StyleMap>");

        writer.write("\n<Style id=\"GreenPinHighlight\">");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n<IconStyle>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/paddle/grn-stars.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n</Style>");
        writer.write("\n<Style id=\"GreenPinNormal\">");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n<IconStyle>");
        writer.write("\n<scale>1.18182</scale>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/paddle/grn-stars.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n</Style>");
        writer.write("\n<StyleMap id=\"GreenPinStyleMap\">");
        writer.write("\n<Pair>");
        writer.write("\n<key>normal</key>");
        writer.write("\n<styleUrl>#GreenPinNormal</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n<Pair>");
        writer.write("\n<key>highlight</key>");
        writer.write("\n<styleUrl>#GreenPinHighlight</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n</StyleMap>");

        writer.write("\n<Style id=\"RedPinHighlight\">");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n<IconStyle>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/paddle/red-stars.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n</Style>");
        writer.write("\n<Style id=\"RedPinNormal\">");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n<IconStyle>");
        writer.write("\n<scale>1.18182</scale>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/paddle/red-stars.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n</Style>");
        writer.write("\n<StyleMap id=\"RedPinStyleMap\">");
        writer.write("\n<Pair>");
        writer.write("\n<key>normal</key>");
        writer.write("\n<styleUrl>#RedPinNormal</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n<Pair>");
        writer.write("\n<key>highlight</key>");
        writer.write("\n<styleUrl>#RedPinHighlight</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n</StyleMap>");
        writer.write("\n<Style id=\"purpleLine\">");
        writer.write("\n<LineStyle>");
        writer.write("\n<color>501400FF</color>");
        writer.write("\n<width>10</width>");
        writer.write("\n</LineStyle>");
        writer.write("\n<PolyStyle>");
        writer.write("\n<color>501400FF</color>");
        writer.write("\n</PolyStyle>");
        writer.write("\n</Style>");
    }

    public void appendStartLineCoordinates(PrintWriter writer) {

        writer.write("<Placemark>");
        writer.write("\n<name>Calculated Path</name>");
        writer.write("\n<description>Path Calculated by using Critical Points</description>");
        writer.write("\n<styleUrl>#purpleLine</styleUrl>");
        writer.write("\n<LineString>");
        writer.write("\n<extrude>0</extrude>");
        writer.write("\n<tessellate>1</tessellate>");
        writer.write("\n<altitudeMode>clampToGround</altitudeMode>");
        writer.write("\n<coordinates><![CDATA[");
    }

    public void appendLineCoordinates(String[] attributes, PrintWriter writer) {
        writer.write(attributes[6] + "," + attributes[5] + " ");
        System.out.println("longitude is: " + attributes[5] + " latitude is: " + attributes[6]);
    }

    public void appendEndLineCoordinates(String[] attributes, PrintWriter writer) {
        writer.write(attributes[3] + "," + attributes[2] + " " + "]]></coordinates>" +
                "\n</LineString></Placemark>");
        System.out.println("longitude is: " + attributes[3] + " latitude is: " + attributes[2]);
    }

    public void appendResult(String[] attributes, PrintWriter writer) {

        writer.write("\n<Placemark>");
        writer.write("<name>End</name>");
        writer.write("\n<description>");
        writer.write("<![CDATA[<br/><strong> Trip ID: </strong>" + attributes[0]);
        writer.write("\n<br /><strong> Destination Stop ID:</strong>" + attributes[1] + "]]>");
        writer.write("\n</description>");
        writer.write("<styleUrl>#lastStopStyleMap</styleUrl><Point><coordinates><![CDATA[" + attributes[3] + " , " + attributes[2] + "]]></coordinates>");
        writer.write("\n</Point>");
        writer.write("\n</Placemark>");
        writer.write("\n<Placemark>");
        writer.write("<name>Previous stop</name>");
        writer.write("\n<description>");
        writer.write("<![CDATA[<br/><strong> ID Previous Stop </strong>" + attributes[4] + "]]>");
        writer.write("\n</description>");
        writer.write("\n<styleUrl>#lastStopStyleMap</styleUrl><Point><coordinates><![CDATA[" + attributes[6] + " , " + attributes[5] + "]]></coordinates>");
        writer.write("\n</Point>");
        writer.write("\n</Placemark>");

    }

    public void appendStart(String[] attributes, PrintWriter writer) {

        writer.write("\n<Placemark>");
        writer.write("<name>" + attributes[0] + "</name>");
        writer.write("\n<description>");
        writer.write("<![CDATA[<strong> Get Ready Notification:</strong> " + attributes[1]);
        writer.write("\n<br /><strong> Pull The Cord Notification:</strong> " + attributes[2]);
        writer.write("\n<br /><strong> Time(ns):</strong> " + attributes[3]);
        writer.write("\n<br /><strong> Speed:</strong> " + attributes[8]);
        writer.write("\n<br /><strong> Bearing:</strong> " + attributes[9]);
        writer.write("\n<br /><strong> Accuracy:</strong> " + attributes[10]);
        writer.write("\n<br /><strong> Satellites:</strong> " + attributes[11]);
        writer.write("\n<br /><strong> Provider:</strong> " + attributes[12] + "]]>");
        writer.write("\n</description>");
        writer.write("<styleUrl>#ArrowStyleMap</styleUrl>");
        writer.write("\n<Point>");
        writer.write("\n<coordinates>");
        writer.write(attributes[6] + " , " + attributes[5] + " , " + attributes[7] + "</coordinates>");
        writer.write("\n</Point>");
        writer.write("\n<TimeStamp><when>" + convertMilliToUTC(attributes[4]) + "</when></TimeStamp>");
        writer.write("\n</Placemark>");

    }

    private String convertMilliToUTC(String milli) {
        String timeUTC;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.'Z'S-hh:mm");
        Calendar calendar = Calendar.getInstance();
        long milliSeconds = Long.parseLong(milli);
        calendar.setTimeInMillis(milliSeconds);
        timeUTC = formatter.format(calendar.getTime());

        return timeUTC;
    }


    public void appendResult3(String[] attributes, PrintWriter writer) {

        writer.write("\n<Placemark>");
        writer.write("\n<name>" + attributes[0] + "</name>");
        writer.write("\n<description>");
        writer.write("<![CDATA[<strong> Get Ready Notification:</strong> " + attributes[1]);
        writer.write("\n<br /><strong> Pull the Cord Notification:</strong> " + attributes[2]);
        writer.write("\n<br /><strong> Time(ns):</strong> " + attributes[3]);
        writer.write("\n<br /><strong> Speed:</strong> " + attributes[8]);
        writer.write("\n<br /><strong> Bearing:</strong> " + attributes[9]);
        writer.write("\n<br /><strong> Accuracy:</strong> " + attributes[10]);
        writer.write("\n<br /><strong> Satellites:</strong> " + attributes[11]);
        writer.write("\n<br /><strong> Provider:</strong> " + attributes[12] + "]]>");
        writer.write("\n</description>");

        if (attributes[1].equals("true") && i == 1) {
            writer.write("\n<styleUrl>#RedPinStyleMap</styleUrl>");
            i++;
        } else if (attributes[2].equals("true") && j == 1) {
            writer.write("\n<styleUrl>#GreenPinStyleMap</styleUrl>");
            j++;
        } else
            writer.write("\n<styleUrl>#ArrowStyleMap</styleUrl>");


        writer.write("\n<Point>");
        writer.write("\n<coordinates>");
        writer.write(attributes[6] + " , " + attributes[5] + " , " + attributes[7] + "</coordinates>");
        writer.write("\n</Point>");
        writer.write("\n<TimeStamp><when>" + convertMilliToUTC(attributes[4]) + "</when></TimeStamp>");
        writer.write("\n</Placemark>");

    }

    public void appendFinal(PrintWriter writer) {

        writer.write("\n</Document>");
        writer.write("\n</kml>");
    }

    public void close(PrintWriter writer) {
        writer.close();
    }
}
