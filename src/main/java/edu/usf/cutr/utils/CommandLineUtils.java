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
package edu.usf.cutr.utils;

import org.apache.commons.cli.*;

import java.io.FileNotFoundException;

public class CommandLineUtils {

  public static String getInputFilePath(String args[]) throws Exception {
    Options options = new Options();
    options.addOption("i", true, "Input io path");

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);
    return getInputPath(cmd);
  }

  private static String getInputPath(CommandLine cmd) throws FileNotFoundException {
    String filePath;
    if (cmd.hasOption("i")) {
      filePath = cmd.getOptionValue("i");
    } else {
      throw new FileNotFoundException("Agency mapping io not found.");
    }
    return filePath;
  }
}
