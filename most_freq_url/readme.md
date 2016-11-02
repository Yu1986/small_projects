#Most Frequent URL Pair

##Direcotry
- src\com\jy\MostFreqURL.java is the source code
- MostFreqURLTest.java is the unittest file, please run unittest first, it is the main function

##Method
- two hashMaps, 
- one hashMap is for <user, last_accessed_url>
- one hashMap is for <UrlPair, Set<user>>
- use max(int), to record most frequent url pair (max number of user set)
- provide two solutions, first solution use self defined UrlPair which overrides equal and hashcode func()
- secode solution Srting[] as pair, (string array also provide same compare function, which compare the length of array, and call euqal for each components in the array)
