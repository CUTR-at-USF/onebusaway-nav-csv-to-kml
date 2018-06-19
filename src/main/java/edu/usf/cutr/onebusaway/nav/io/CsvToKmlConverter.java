/*
 * Copyright 2016-2018 University of South Florida
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.usf.cutr.onebusaway.nav.io;

import java.io.*;
import java.util.ArrayList;

/**
 * Converts a CSV file with the format described in the README to a KML file viewable in Google Earth
 */
public class CsvToKmlConverter {

    public CsvToKmlConverter() {
    }

    /**
     * Takes the provided CSV file and converts and writes it to a KML file using the provided PrintWriter
     *
     * @param csv         CSV file to convert to KML format
     * @param printWriter PrintWriter to be used to write the KML file
     */
    public void convertCsvToKml(File csv, PrintWriter printWriter) {
        BufferedReader reader = null;
        String line = "";
        String csvSeparator = ",";
        KmlFileGenerator kmlFileGenerator = new KmlFileGenerator(printWriter);
        int n = 1;
        int j = 1;

        try {
            int i = 1;
            reader = new BufferedReader(new FileReader(csv));
            String[] attribute = null;
            ArrayList<String[]> coordinates = new ArrayList<String[]>();

            while ((line = reader.readLine()) != null) {

                attribute = line.split(csvSeparator);

                if (attribute.length < 9) {
                    kmlFileGenerator.appendResult(attribute, printWriter);
                    coordinates.add(attribute);
                } else if (i == 2) {
                    kmlFileGenerator.appendStart(attribute, printWriter);
                    coordinates.add(attribute);
                } else {
                    kmlFileGenerator.appendResult3(attribute, printWriter);
                    coordinates.add(attribute);
                }
                i++;
            }
            kmlFileGenerator.appendStartLineCoordinates(printWriter);

            for (String[] lineCoordinates : coordinates) {
                if (n > 1) {
                    kmlFileGenerator.appendLineCoordinates(lineCoordinates, printWriter);
                }
                n++;
            }

            for (String[] lineCoordinates : coordinates) {
                if (j == 1) {
                    kmlFileGenerator.appendEndLineCoordinates(lineCoordinates, printWriter);
                }
                j++;
            }

            kmlFileGenerator.appendFinal(printWriter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Done");
        kmlFileGenerator.close(printWriter);
    }
}
