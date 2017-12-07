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
package edu.usf.cutr;

import edu.usf.cutr.io.CsvToKmlConverter;
import edu.usf.cutr.io.FileHelper;
import edu.usf.cutr.utils.CommandLineUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Main {

  public static void main(String[] args) {
      String inputFilePath;


    try {

        inputFilePath = CommandLineUtils.getInputFilePath(args);

    } catch (Exception e) {
      System.err.println("input io cannot be empty - " + e);
      return;
    }

    List<File> csvFiles = FileHelper.getAllFilesByExtension(inputFilePath, "csv");

      PrintWriter writer = null;
      int n = 1;
    for (File file: csvFiles) {

        try {
            writer = new PrintWriter("test" + n++ + ".kml", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        CsvToKmlConverter csvToKmlConverter = new CsvToKmlConverter(writer);
        File kml = csvToKmlConverter.convertCsvToKml(file, writer);
    }

  }
}
