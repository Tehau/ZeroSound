## Description :

My new pet project.
I want an app that allows me to use voice control to manage my playlist while longboarding, which I cannot do
with my hands because of the gloves.
The idea is to use Google Now as a voice recognition module, which is tricky since Google offers no API to do that.

I know apps like that already exist, but I have some special requirements :
- I don't want to have to root my phone
- I don't want to use a framework like Xposed, which requires root anyway
- I want to be able to use Poweramp instead of the stock music player


## Usage :

As I said, Google offers no API to allow us to work with Google Now, so I'm using an AccessibilityService
that reads the searches performed through GoogleNow.
For the app to work, you have to enable said service in Settings -> Accessibility -> zer0Sound


## Available commands :

I'm only getting started, so for now, I'm only able to control the volume.

```
set the volume to X / volume X (the number has to be in the last position)
```


## Build :

To generate android local configuration files :      
```
android update project -p <path to project>
```            
To upload the app to your device :      
```
ant debug && ant installd
```

