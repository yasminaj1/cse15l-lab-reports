# Week 3- Lab 2 (Search Engine and Debugging)

## Part 1: Simplest Seach Engine
___
My code for creating the simplest search engine is:

```

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    public String handleRequest(URI url) {
        ArrayList<String> searchRequests = new ArrayList<String>();
        searchRequests.add("apple");
        if (url.getPath().equals("/")) {
            return String.format("items in list:", searchRequests);
        } else if (url.getPath().equals("/addapple")) {
            searchRequests.add("apple");
            return String.format("apple added to list!");
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("list")) {
                    searchRequests.add(parameters[1]);
                    return String.format("item added. list is now:", parameters[1], searchRequests);
                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
} 

```


This allowed me to create a simple search engine that allowed me to add items to the array searchRequests and eventually print them out. Below is a screenshot of the website page as soon as you put in the URL for the local host. 

![firstthingonwebsite](firstwebsite.png)

For this to appear, the part of my code that is used is:
``` 
if (url.getPath().equals("/")) {
            return String.format("items in list:", searchRequests); 
```
This is because there is nothing else in the URL except for the root path which is just "/".

Another example of what you could do is the addapple part of the method. For this, you would write "/addapple" in the URL and it would add apple to the list of items and say "apple added to list!". This can be seen in the screenshot below. 

![addapple](addapple.png)

For this to appear, the part of the code that was called is: 
 ```
else if (url.getPath().equals("/addapple")) {
            searchRequests.add("apple");
            return String.format("apple added to list!");

 ```

 Here, the "/" refers to the root path and if you add the words "addapple" after the "/", it will add the item apple to the searchRequests array and and print out "apple added to the list". Nothing changes on the screen when you keep adding apple, but the item apple keeps gettting added to the searchRequests array. This is not seen by the user until the user writes a query into the URL. Below is a screenshot of the Query request. 

 ![printedlist](printedList.png)

 The part of the code that is called her is:

 ```
else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("list")) {
                    searchRequests.add(parameters[1]);
                    return String.format("item added. list is now:", parameters[1], searchRequests);
                }
            }
            return "404 Not Found!";
        }


 ``` 

 Here, the value of the list is changing every time an item is added and it will print out the list of all the items that were added to the list previously (including with the addapple).



## Part 2: Debugging
___

**Bug 1: ArrayMethods reverse**

The first method that I decided to debug was the reversed array in the arrayExamples file. When I first opened the file and ran the initial that were pre written, they all passed. Since I knew for a fact that all the methods in the arrayEamples file have at east 1 bug, I knew that the pre written tests are not good enough to identify the given bug. Below is a screenshot of the initial unedited file and after I ran the two prewritten tests. 

![uneditedtestpass](uneditedfilespassedtest.png)

After these tests passed, I realized taht I would need to write more tests in order to be able to find the symptom and identify the bug. I wrote two different tests, reverseTest1 and reverseTest2, both of which failed and returned as the method kept returning a 0 value instead of the arrays in reverse. For reverseTest1, I made the input array {1,2,3,4}, and expected to get an output of {4,3,2,1}, but I actually got a result of 0. For reverseTest2 I creted an input array with the values {100,300,500,700} and expected to get an output of {700, 500, 300 ,100} but I also got a result of 0. Therefore I considered these 2 input arrays to be the failure inducing input and the symptom of both was that the method returned a result of 0. Below is a screenshot of the tests and the expected outputs in comparison to the actual output. 

![secondmethodreturns0](method2returning0.png)

After looking back at the code I realized that there must be an issue in that no items were being added to the array or that the return value is incorrect. Sure enough I was able to identify that a bug taht i assumed to be the symptom. That bug was that the return statement was returning the original arr array rather than the newArray. I fixed this bug and tried to run the tests but the tests kept failing. Below is a screenshot of this. 

![secondmethodstillfails](changedtonewArrreturn.png)

This made me realize that there must be another bug that is preventing the items from being added to the newArray. After looking at the code further I realized that there is also a bug in line 21 in which it says arr[i]=newArray[arr.length-i-1]. This is a bug because it is changing the value of arr to be the value of newArray instead of assigning the value from arr to NewArray. I fixed this bug by replacing line 21 with newArray[arr.length-i-1] = arr[i]. This caused the new array to take the values of 0 and didnt allow anything to be added to the newArray, which is why we I kept gettting an output of 0 rather than the reversed arrray. After I changed this and ran the tests again they all passsed. Below is a screenshot of the fixed code and the passed tests. 

![secondmethodworksnow](worksnowmethod2.png)

**Bug 2: List reverse**

The second method that I tried to debug is the filter method in the ListExamples file. This method is meant to return a new list that has all the elements of the input list for which the StringChecker returns true, and not the elements that return false, in the same order they appeared in the input list. Before being able to test this, I needed to implement the StringChecker method by creating a new class called StingChecker2 that implements the StringChecker interface. I needed to do this because I needed to create a string checker object and you cannot create objects from interfaces. After creatig the class, I created the implementation for the string checker which selects the strings that have "ed" in them. Below is a screenshot of this implementation and the test that I created to try and identify the bug. 

![implementationStringChecker](stringcheckerTest.png)

After running the test I found got the following results. 

![testfailedstringchecker](failedTestforStringChecker.png)

Instead of giving me the results in the same order as they were but filtered ([plated, edward, fasted]), it gave me the results in reverse ([plated, edward, fasted]). Therefore the failure inducing inout was the array [plated, edward, hands, fasted, places] and the symptom was the properly filtered, but reversed list ([plated, edward, fasted]). This made me realize that the bug does have anything to do with the stringChecker method, but rather has something ti do with the way in which the items are added to the new results array. After looking at it further realized that the bug was in line 15, where it was adding the item in idex 0, meaning that the item that was added first ended up shifting down the array because the other items were being added to index 0 after. I fixed this bug by removing the 0, and leaving it as (s). I then ran the test and it passed. Below is a screenshot of the test passing and the fixed bug. 


![finalfixedmethod](fixedmethod2final.png)




