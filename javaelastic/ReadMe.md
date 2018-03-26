**General Notes**   
Basic element - Document  
Documents are part of Index  
Index are kept in Shards  
Shards are kept in nodes/servers aka cluster  

ES is easy to scale horizontally.  
ES allows more clusters to the servers for better load balancing. 

_Case 1 node:_   
Node1: Sh1 Sh2 Sh3 Sh4

_Case 2 nodes:_   
Node1: Sh1 Sh2  
Node2: Sh3 Sh4

**ES Basics**  
tokenize text into words  
remove punctuation  
note frequency of each word  
inverted index is then made that tells each document containing the word  
So example:  

```concept
Winter - 1 - Doc1  
is - 2 - Doc1, Doc2  
coming - 1 - Doc1  
ours - 1 - Doc2  
the - 1 - Doc2  
...and so on..  
```
This inverted index is called postings list in **technical terms**.  

more complicated searchs like find words ending with _ing_  
in this case you can reverse the words and save in the inverted index.. then search with words that have _gni_ i.e. reverse of search string _ing_..  

for sub-string searches, break each word in n-grams and save in the inverted index.  

yours will be saved with yo, you, our, ours, urs, etc..  
and then use for substring matches..

geo-hashes from longitude and latitude are used for geographical search  
metaphone for phonetic matching  
"Did you mean?" searches use a Levenshtein automation.  


### Key Points
* Underlying engine is Lucene.  
* Distributed - scales to thousands of nodes
* High AVailability - Multiple copies of data
* Restful api
* Powerful Query DSL - complex queries expressed simply
* Schemaless - Index data without an explicit schema

* Cluster has nodes. nodes can be 1 to several thousands.
* Each node performs indexing of documents added to ES
* all nodes participates in search
* each node has unique id and name
* cluster all entire indexed data. has a unique name
* nodes join cluster using cluster name
* There can be categories of documents. 
* Different Document types make up an index
* index can be made up of one or more document types.
* index - collection of similar documents ( may not be exactly same )
* any number of indices in a cluster
* Document - basic unit of information to be indexed.
* Document - expresses in json
* Document - resides within index
* Document - has a type
* Index may not fit on one hard disk or one node
* Single node - too slow to serve all search requests
* Split index across nodes - this is called sharding
* Shards - split contents across nodes. each node contains one shard of the index.
* Shards - every node has only subset of data. Complete data needs all shards.
* Sharding allows - parallel search and improves performance.
* Replication - set replicas of index. every shard should have corresponding replica. for failures.


**CLuster status**  

Yellow - some replicates may not be available.  
Red - some shards not available. cluster not fully functional. need attn. asap.

   
