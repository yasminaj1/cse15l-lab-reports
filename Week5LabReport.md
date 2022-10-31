# Week 5- Lab 3 (Researching Commands)

The commmand that I chose to research is the grep command. At its simplest, grep takes a string and a file, and prints out all the lines in that file that match the string. 

## Alternate option 1: grep -i

Since grep commands are case sensitive, the -i coperator makes teh command ignore upper or lower case and just focus on the character itself. 

**Example 1:**

![grep-i1](grep(-i)#1.png)

The command that I used here was:

```
grep -i "website" find-results.txt
```
As can be seen in the screenshot of the input command and the output, when I ran the first command without the -i, nothing was returned because teh word "Website" that was used in the file was written in upper case, whereas when I wrote it on the grep command it was in lower case. However when I ran the command again with the -i, I got an output because the command was able to ignore the case. 