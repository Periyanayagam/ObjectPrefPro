# ObjectPrefPro
  Why to go with Local database to save lists? Here is the simplified approach of using SharedPrefences to save Lists and Objects.  


   # Usage
  
  ### Save List to Pref
   ```
    SharedPref.setSharedList("userList", userList); 
   ```
  ### Save Object to Pref
   ```
   SharedPref.getInstance().setSharedValue("User", user);
   ```
  ### Get List from Pref
 ```
   List<User> mList = SharedPref.getSharedList(User[].class, "userList");
 ```
    
 ### Get Object from Pref
  ```  
     User mUser = (User) SharedPref.getObject("User", User.class);
  ```
   
  
 
  [![Watch the video](https://github.com/Periyanayagam/ObjectPrefPro/blob/master/Object.gif)](https://github.com/Periyanayagam/ObjectPrefPro/blob/master/Object.gif)
  
