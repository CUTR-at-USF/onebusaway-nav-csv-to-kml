# tad-csv-to-kml
Converts a trip recorded using TAD from CSV format to KML, so it can be visualized using [Google Earth](https://www.google.com/earth/).

## CSV file format

When recording data using TAD, the log file is a CSV file written to the "TADLog" folder on your external storage root directory. The filename format is `<TestID>-<Date/time of test>.csv`. For example, `1-Thu, Aug 25 2016, 04:20 PM.csv`. 
  
The first line of the file includes the following information in the same order is going to be presented: The trip ID, the destination Stop ID, the latitude of the destination, the longitude of the destination, stop ID of the Stop before the final Stop,the latitude of the stop before the final stop, and the longitude of the stop before the last stop.
  
Starting from the second line, the first column contains the time in nanoseconds since the application started, the second column contains the time in UTC, the third column contains the latitude, the fourth column contains the longitude, the fifth column contains the altitude, the sixth column contains the speed, the seventh column contains the Bearing, the eight column contains the accuracy, the ninth column contains the satellites, the tenth column contains the provider.

For example:

~~~
Hillsborough Area Regional Transit_144477,Hillsborough Area Regional Transit_6497,28.066021,-82.429922,Hillsborough Area Regional Transit_3075,28.065622,-82.427307,,,,,,
0,FALSE,FALSE,1327025000000,1466618929014,28.050549,-82.416169,0,0,0,36,0,network
1,FALSE,FALSE,1327025000000,1466618929014,28.050549,-82.416169,0,0,0,36,0,network
2,FALSE,FALSE,1327025000000,1466618929014,28.050549,-82.416169,0,0,0,36,0,network
3,FALSE,FALSE,1340292932060,1466618943000,28.051408,-82.416176,11,13.25,0.4,19,11,gps
4,FALSE,FALSE,1340292932060,1466618943000,28.051408,-82.416176,11,13.25,0.4,19,11,gps
5,FALSE,FALSE,1341291856798,1466618944000,28.051546,-82.416175,2,14.25,359.899994,5,11,gps
...
~~~
