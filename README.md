## Activity Lifecycle (part 1)
### Diagram: http://developer.android.com/images/training/basics/basic-lifecycle.png
### onResume() and onPause()... safe to acquire resources in onResume, release in onPause. 

### Since all activities in life cycle run on UI thread, they are blocking.  onPause is called prior to a new view loading / displaying.  onStop is called on the previous activity AFTER the new one has loaded. For this reason (and since all methods are blocking), you should perform intensive activities in the onStop (activities that you need to run as a view is moving to the background, being replaced, etc…. but not being destroyed)
