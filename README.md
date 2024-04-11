launchy
===========

A way to launch native apps on Google Glass.

- Build and deploy Launchy to your Glass device
- Scroll over to settings in GlassHome and select that. You should get a typical Android dialog that gives you the option of picking GlassHome or Launchy for this action. Select Launchy and check the box to always use Launchy.
- Edit: removed in XE12, due to the selection dialog breaking. Now whenever you go to Settings in GlassHome, Launchy will pop up. If you actually need to get to Glass settings, Launchy provides a permanent link for that.
- Say "Run an App" at the OK, Glass screen to run Launchy

**Building**
    Updated to AndroidStudio 2023.2.1.25
Be sure to install Kitkat 4.4 SDK and Glass preview addon (uncheck Hide obsolete packages, and check Show package details in SDK Manager).
It is somewhat wonky with building, I tried setting compileSdkVersion to "Google Inc.:Glass Development Kit Preview:19" but it doesn't always work right, and does not find GLASS APIs. And when it does AndroidStudio refuses to deploy APK to device because it thinks these APIs are not available on device.
So in my experience the best solution was to set compileSdk=19, and add glass developer kit (gdk.jar) to project dependencies. This in turn needs absolute path or implementation(files(android.sdkDirectory.toString() + "/add-ons/addon-google_gdk-google-19/libs/gdk.jar"))
which seems to work, for compiling but deploying is grayed out. So you probably want to manually edit it and adjust to absolute path of gdk.jar. Classy. ;-)
Make sure to add local.properties with
sdk.dir=/home/$yourusername/Android/Sdk
or whatever is appropriate for your system, if AndroidStudio did not create it automagically.


So why do we need this app?
Glass provides no way to launch native apps. If you deploy and run an app, as soon as the screen goes off GlassHome takes over and you can not run your app again.

How'd you do that? GlassHome has a handful of local Activities that are launched, but many of these are launched by Package and Class name, however we lucked out because settings was simply launched with an action that I can intercept and decide to have Launchy take over from there.

Who is Mike DiGiovanni? Emerging technology lead at Roundarch Isobar (http://www.roundarchisobar.com) Mike has interests in all areas of mobile development and wearable computing. As a long time Android developer, he is looking forward to working with Google Glass.

Copyright 2013 Michael DiGiovanni glass@mikedg.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
