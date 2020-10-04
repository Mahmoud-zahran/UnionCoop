# UnionCoop
The goal of this task is to build a simple single screen app which shows the current trending Github repositories fetched from a public API. 
The design and business specifications have been provided below. We expect you to follow it as closely as possible.
We have deliberately kept the app simple enough for you to attempt it, but we are keen to see the approach you take to solve it.
You have the freedom to give your best into it and demonstrate your skills for us to evaluate you better.

---------------------------------------------------------------------------------------
I used the following technologies to make that task
# MVVM, Hilt, RXjava3, Retrofit, ViewModel, LiveData, Room, ConstraintLayout, Glide, gson, custom ToolBar, and Solid principles.
#ANDROID DEVELOPER CHALLENGE
------------------------------------------------------------------------------

## Requirements
* The app should preferably support minimum Android API level 21.
* The app should fetch the trending repositories from the provided public API and display it
to the users.
* While the data is being fetched, the app should show a loading state. (Shimmer
animation is optional).
* If the app is not able to fetch the data, then it should show an error state to the user
with an option to retry again.
* All the items in the list should be in their collapsed state by default and can be
expanded on being tapped.
* Tapping any item will expand it to show more details and collapse any other
expanded item. Tapping the same item in an expanded state should collapse it.
* The app should give a pull-to-refresh option to the user to force fetch data from remote.
## API Details
The complete API docs are available - [Here](https://githubtrendingapi.docs.apiary.io/#%23)
. You need to fetch the data from [/repositories](https://githubtrendingapi.docs.apiary.io/#%23reference/0/repositories/list-trending-repositories) endpoint. 
The ​“language” a​ nd “​ since” ​are optional parameters and are not needed in this case.
You will get a list of the trending repositories as a response from this API.
## Git Repositories:

<img src="https://github.com/Mahmoud-zahran/UnionCoop/blob/main/Screen%20Shot%202020-10-04%20at%203.42.10%20AM.png" width="20%"></img></br></br>  
<img src="https://github.com/Mahmoud-zahran/UnionCoop/blob/main/Screen%20Shot%202020-10-04%20at%203.42.40%20AM.png" width="20%"></img></br></br>                       
<img src="https://github.com/Mahmoud-zahran/UnionCoop/blob/main/Screen%20Shot%202020-10-04%20at%203.42.51%20AM.png" width="20%"></img></br></br>  
<img src="https://github.com/Mahmoud-zahran/UnionCoop/blob/main/Screen%20Shot%202020-10-04%20at%203.43.28%20AM.png" width="20%"></img></br></br>                       

## Libraries Used:
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [RxJava3](https://github.com/ReactiveX/RxJava)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
- [Retrofit](https://square.github.io/retrofit/#:~:text=Retrofit%20Configuration,are%20turned%20into%20callable%20objects.)
- [Room](https://developer.android.com/training/data-storage/room)
