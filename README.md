Develop an application that will work on both phone and tablet devices 

o The application should be designed to best work on a mobile device and should scale up to work on a tablet.
o This application should have a minimum SDK version of API level 16 to support Android 4.1 and above.
o This application should of course use the core framework/libraries but feel free to use any open source framework/libraries as appropriate
o The application should look as visually exciting and creative as possible (to a reasonable limit with the timeframe for the test) and not look like it’s something that’s been “taken off the shelf”
o This application should not leak any memory

Start-up
o The application should on start-up read the contents of the JSON file at the following network location - http://www.konzeptual.es/sb/gamesDetail.json
o The JSON file describes some details for a list of games. Two of the details are URL’s to images (full image and icon). These images should be downloaded using the URL’s
o The application should use asynchronous URL connections for both the JSON and image requests

The main application thread should not block during download activities
o Both the JSON and image data should be persisted/cached so it’s not requested each time the application starts. The JSON file should be checked once every 24 hours and if the image URL’s have changed, then re-download new data

Main functionality
o Once the data has been downloaded, the list of games should be shown to the user using the full image and game name
o When the user clicks on the image, the user should then be shown details for that particular game – the game icon, game name, rating, description, etc
o The user should also have an ability to go back to the list of games

Bonus steps
o Display the content (game list and game details) in a different way depending on whether the user is viewing the device in portrait or landscape orientation
  Maybe different layout / UI components?
o Display a completely different user interface for the tablet version
  Maybe one screen instead of multiple?
