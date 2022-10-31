# Week 5- Lab 3 (Researching Commands)

The commmand that I chose to research is the grep command. At its simplest, grep takes a string and a file, and prints out all the lines in that file that match the string. 
___
## Alternate option 1: grep -i

Since grep commands are case sensitive, the -i operator makes the command ignore upper or lower case and just focus on the character itself. 

**Example 1:**

![grep-i1](grep(-i)1.png)

The command that I used here was:

```
grep -i "website" find-results.txt
```
As can be seen in the screenshot of the input command and the output, when I ran the first command without the -i, nothing was returned because the word "Website" that was used in the file was written in upper case, whereas when I wrote it on the grep command it was in lower case. However when I ran the command again with the -i, I got an output because the command was able to ignore the case. 

**Example 2:**
![grep-i2](grep(-i)2.png)

Before running the command I switched directories into technical, then into 911reports so that I can reduce the amount of words in the command. The commands I used here were:
```
cd technical
cd 911reports
grep -i "FLIGHTS" chapter-1.txt
```
As can be seen here, the word "flights" appears multiple times in this file but with different cases. In some cases its in all caps, and on otyer cases its all in lower case and in some its a mix of both. After running this command, the output included all instances of "flight" with all different cases.

**Example 3:**
![grep-i3](grep(-i)3.png)

Before running the command I switched directories into technical, then into 911reports so that I can reduce the amount of words in the command. The commands I used here were:

```
cd technical
cd 911reports
grep -i "oMaRi" chapter-1.txt
```

The word "omari" appears multiple times in this file but with different cases. In some cases its in all caps, and on otyer cases its all in lower case and in some its a mix of both. Here I tried mixing lower and upper case letters to see what would happen. As expected, the output was all instaces of the word, no matter what the case was. 

___

## Alternate option 2: grep -v

grep commands print out the lines that include a specific word. The -v operator, also known as the inverter, prints the lines that DON'T include the given word. 

**Example 1:**

![grep-v1](grep(-v)1.png)

Instead of using the cd command to change the working directory to Media, I decided t just write the root path of the file in the command. The command that I used was: 

```
grep -v "EDWARD" ./technical/government/Media/5_Legal_Groups.txt
```
Since grep is acse sensitive I write the word "EDWARD" in all caps because thats how it is in the file. After running the command, every line in the file was printed except for the first line that included the word "EDWARD".

**Example 2:**

![grep-v2](grep(-v)2.png)

In this example I used the same command as the last example except I chnaged the word from "EDWARD", which exists in the file, to "AYMAN" which doesnt exist in the file. The command I wrote was: 

```
grep -v "AYMAN" ./technical/government/Media/5_Legal_Groups.txt
```
In a normal grep command you would expect nothing to print out because the word is not present in the file, but since this is an inverse command, the whole file was printed out into the terminal. 

**Example 3:**

![grep-v3](grep(-v)3.png)

In this example I wanted to verify if the inverse operation is case sensitive by pickimg a file that included the same word many times with different cases. The command I used was: 

```
grep -v "PREFACE" ./technical/911report/preface.txt
```

After running this command  was able to verify that -v operation is case sensitive as in the output we can see that the first line was not printed out since it included the word "PREFACE" in all caps, but later the line is printed when it is spelled with all lower case letters. 

___
## Alternate option 3: grep -c
grep commands print out the entire line that include a specific word. If the word occurs in many isntances in the file, it is very difficult to be able to see all the data that printed out in the terminal. The -c operator tells us the count of lines where it finds a match for the word. 

**Example 1:**

![grep-c1](grep(-c)1.png)

In this example I wanted to see if I can include a whole sentence or phrase into the grep commmand with the -c operator. I used the command:

```
grep -c "We present the narrative of this report" ./technical/911report/preface.txt
```
After running this command I got an output of 1, which is as I expected because there is only 1 line in the whole file that included the exact phrase "We present the narrative of this report". 

**Example 2:**

![grep-c2](grep(-c)2.png)

 In this example I wanted to see if this command and operator would work for short words as well. The command that I used was: 

```
grep -c "We" ./technical/911report/preface.txt
```

The output that I got was 31, which is as expected. 

**Example 3:**

![grep-c3](grep(-c)3.png)

In this example I wanted to see if this command and operator were case sensitive when it came to counting the amount of times a word would apppear. I ran two command in a row to test this out: 

```
grep -c "WE" ./technical/911report/preface.txt
grep -c "we" ./technical/911report/preface.txt
```

I got a different output for the first and second command. For the first command I got 0 because there were no instances at all all when "WE" is written in all caps. This was also an interesting output because usually when grep is called and there are no instances of the word or phrase, nothing is outputted on the terminal. But in ths case we can see that we get an output of 0 to signify that there are no instances of the word. For the second command I got an output of 29, which is as expected because the word "we" in lower case appears 29 times within the file. 


