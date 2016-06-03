package edu.usf.cutr.io;

import java.io.PrintWriter;

/**
 * Created by Jennysanchez on 5/26/2016.
 */
public class KmlFileGenerator {

    public KmlFileGenerator(PrintWriter kmlFile) {
        init(kmlFile);
    }

    private void init(PrintWriter writer) {

        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.write("\n<kml xmlns=\"http://earth.google.com/kml/2.1\">");
        writer.write("\n<Document>");
        writer.write("\n<Style id=\"sn_target\">");
        writer.write("\n<IconStyle>");
        writer.write("\n<color>ff0000ff</color>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/shapes/target.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n<ListStyle>");
        writer.write("\n</ListStyle>");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n</Style>");
        writer.write("\n<StyleMap id=\"msn_target\">");
        writer.write("\n<Pair>");
        writer.write("\n<key>normal</key>");
        writer.write("\n<styleUrl>#sn_target</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n<Pair>");
        writer.write("\n<key>highlight</key>");
        writer.write("\n<styleUrl>#sh_target</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n</StyleMap>");
        writer.write("\n<StyleMap id=\"msn_triangle\">");
        writer.write("\n<Pair>");
        writer.write("\n<key>normal</key>");
        writer.write("\n<styleUrl>#sn_triangle</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n<Pair>");
        writer.write("\n<key>highlight</key>");
        writer.write("\n<styleUrl>#sh_triangle</styleUrl>");
        writer.write("\n</Pair>");
        writer.write("\n</StyleMap>");
        writer.write("\n<Style id=\"sn_triangle\">");
        writer.write("\n<IconStyle>");
        writer.write("\n<color>ff00aa00</color>");
        writer.write("\n<Icon>");
        writer.write("\n<href>http://maps.google.com/mapfiles/kml/shapes/triangle.png</href>");
        writer.write("\n</Icon>");
        writer.write("\n</IconStyle>");
        writer.write("\n<ListStyle>");
        writer.write("\n</ListStyle>");
        writer.write("\n<LabelStyle>");
        writer.write("\n<scale>0</scale>");
        writer.write("\n</LabelStyle>");
        writer.write("\n</Style>");
        writer.write("\n<Style id=\"purpleLine\">");
        writer.write("\n<LineStyle>");
        writer.write("\n<color>7fcf0064</color>");
        writer.write("\n<width>8</width>");
        writer.write("\n</LineStyle>");
        writer.write("\n<PolyStyle>");
        writer.write("\n<color>7f00ff00</color>");
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
        writer.write(attributes[3] + "," + attributes[2] + " ");

    }

    public void appendEndLineCoordinates(String[] attributes, PrintWriter writer) {
        writer.write(attributes[6] + "," + attributes[5] + " " + attributes[3] + "," + attributes[2] + "]]></coordinates>" +
                "\n</LineString></Placemark>");
    }

    public void appendResult(String[] attributes, PrintWriter writer) {

        writer.write("\n<Placemark>");
        writer.write("<name>End</name>");
        writer.write("\n<description>");
        writer.write("<![CDATA[<br/><strong> Trip ID: </strong>" + attributes[0]);
        writer.write("\n<br /><strong> Destination Stop ID:</strong>" + attributes[1] + "]]>");
        writer.write("\n</description>");
        writer.write("<styleUrl>#msn_target</styleUrl><Point><coordinates><![CDATA[" + attributes[3] + " , " + attributes[2] + "]]></coordinates>");
        writer.write("\n</Point>");
        writer.write("\n</Placemark>");
        writer.write("\n<Placemark>");
        writer.write("<name>Previous stop</name>");
        writer.write("\n<description>");
        writer.write("<![CDATA[<br/><strong> ID Previous Stop </strong>" + attributes[4] + "]]>");
        writer.write("\n</description>");
        writer.write("\n<styleUrl>#msn_triangle</styleUrl><Point><coordinates><![CDATA[" + attributes[6] + " , " + attributes[5] + "]]></coordinates>");
        writer.write("\n</Point>");
        writer.write("\n</Placemark>");

    }

    public void appendStart(String[] attributes, PrintWriter writer) {

        writer.write("\n<Placemark>");
        writer.write("<name>Start</name>");
        writer.write("\n<description>");
        writer.write("<![CDATA[<strong> Time(ns):</strong> " + attributes[0]);
        writer.write("\n<br /><strong> Time(UTC):</strong> " + attributes[1]);
        writer.write("\n<br /><strong> Altitude:</strong> " + attributes[4]);
        writer.write("\n<br /><strong> Speed:</strong> " + attributes[5]);
        writer.write("\n<br /><strong> Bearing:</strong> " + attributes[6]);
        writer.write("\n<br /><strong> Accuracy:</strong> " + attributes[7]);
        writer.write("\n<br /><strong> Satellites:</strong> " + attributes[8]);
        writer.write("\n<br /><strong> Provider:</strong> " + attributes[9] + "]]>");
        writer.write("\n</description>");
        writer.write("<styleUrl>#msn_triangle</styleUrl>");
        writer.write("\n<Point>");
        writer.write("\n<coordinates>");
        writer.write(attributes[3] + " , " + attributes[2] + "</coordinates>");
        writer.write("\n</Point>");
        writer.write("\n</Placemark>");

    }

    public void appendResult3(String[] attributes, PrintWriter writer) {

        writer.write("\n<Placemark>");
        writer.write("\n<description>");
        writer.write("<![CDATA[<strong> Time(ns):</strong> " + attributes[0]);
        writer.write("\n<br /><strong> Time(UTC):</strong> " + attributes[1]);
        writer.write("\n<br /><strong> Altitude:</strong> " + attributes[4]);
        writer.write("\n<br /><strong> Speed:</strong> " + attributes[5]);
        writer.write("\n<br /><strong> Bearing:</strong> " + attributes[6]);
        writer.write("\n<br /><strong> Accuracy:</strong> " + attributes[7]);
        writer.write("\n<br /><strong> Satellites:</strong> " + attributes[8]);
        writer.write("\n<br /><strong> Provider:</strong> " + attributes[9] + "]]>");
        writer.write("\n</description>");
        writer.write("\n<Point>");
        writer.write("\n<coordinates>");
        writer.write(attributes[3] + " , " + attributes[2] + "</coordinates>");
        writer.write("\n</Point>");
        writer.write("\n</Placemark>");

    }

    public void appendFinal(PrintWriter writer) {
        writer.write("]]></coordinates>" + "\n</LineString></Placemark>");
        writer.write("\n</Document>");
        writer.write("\n</kml>");
    }

    public void close(PrintWriter writer) {
        writer.close();
    }
}
