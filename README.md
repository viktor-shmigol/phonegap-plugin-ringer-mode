# phonegap-plugin-ringer-mode

This plugin lets you set and get the ringer mode on Android platform

## Installation
```` phonegap plugin install phonegap-plugin-ringer-mode ````

## Usage
##### Get
```` 
RingerMode.get(function(ringerMode){
  //do something with the ringer mode
}); 
````


##### Set
```` 
RingerMode.set(ringerMode, function(){
  //this callback gets called when the ringer mode is successfully set
}); 
````

##### Enum
In both of the methods above ringerMode will be either of the following

```` 
RingerMode.VIBRATE 
````
````
RingerMode.SILENT 
````
````
RingerMode.NORMAL 
````

these ringer modes are provided by the native android AudioManager class, you can read more about [here](https://developer.android.com/reference/android/media/AudioManager.html)
