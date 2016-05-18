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

import java.io.File;

public class CsvToKmlConverter {

  private File mOutputFile;

  public CsvToKmlConverter(File mOutputFile) {
    mOutputFile = mOutputFile;
  }

  public File convertCsvToKml (File csv) {
    File convertedFile = null;
    // TODO: do conversion

    return convertedFile;
  }

  public void appendToFile(File file) {
    // TODO: append the created kml file to output
  }
}
