/*
 * Copyright 2016 University of South Florida
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
package edu.usf.cutr.io;

import java.io.*;
import java.util.ArrayList;


public class CsvToKmlConverter {

    private File mOutputFile;
    private File convertedFile = null;

    public CsvToKmlConverter(PrintWriter mOutputFile) {
        mOutputFile = mOutputFile;
    }

    public File convertCsvToKml(File csv, PrintWriter kml) {

        BufferedReader reader = null;
        String line = "";
        String csvSeparator = ",";
        KmlFileGenerator kmlFileGenerator = new KmlFileGenerator(kml);
        int n = 1;

        try {
            int i = 1;
            reader = new BufferedReader(new FileReader(csv));
            String[] attribute = null;
            ArrayList<String[]> coordinates = new ArrayList<String[]>();

            while ((line = reader.readLine()) != null) {

                attribute = line.split(csvSeparator);

                if (attribute.length < 9) {
                    kmlFileGenerator.appendResult(attribute, kml);
                    coordinates.add(attribute);
                } else if (i == 2) {
                    kmlFileGenerator.appendStart(attribute, kml);
                    coordinates.add(attribute);
                } else {
                    kmlFileGenerator.appendResult3(attribute, kml);
                    coordinates.add(attribute);
                }
                i++;
            }
            kmlFileGenerator.appendStartLineCoordinates(kml);

            for (String[] lineCoordinates : coordinates) {
                kmlFileGenerator.appendLineCoordinates(lineCoordinates, kml);

            }


            kmlFileGenerator.appendFinal(kml);

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
        kmlFileGenerator.close(kml);
        return convertedFile;
    }

}
