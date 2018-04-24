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

```
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

### reference
json-generator.com


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

* TF/IDF Relevance
* TF - Term Frequency - How often does the term appear in the field
* IDF - Inverse Document frequency - How often does the term appear in the index
* Field length norm - How long is the field which was searched.

===========================

*Field Datatypes*
text keyword date long double boolean ip

hierarchical  
object, nested  

specialized     
geo_point, geo_shape, completion  

* Dynamic Mapping - ES will guess the type when no right type given. 

__Mapping__ - how data is stored and hence impacts search performance.

String Fields - 
* full text search. individual tokens in string are searchable.
* keyword search - whole string values are searchable. 

5.0 onwards - all strings are indexed by default.


To see mappings in an index, use _mapping

Caution - Mappings can be updated only at the time of index creationg.  
And can't be edited later on.  

```

http://localhost:9200/products/_mapping

```     


*Edit Mapping* i.e. adding new field. Editing existing fields is not allowed.    

http://localhost:9200/customers/_mapping/personal
{
    "properties": {
        "customerSince": {
            "type": "integer"
        }
    }
}

*Dynamic field mapping*  

* don't put integers in quotes
    set numeric detection to true for the index
```
http://localhost:9200/customers
{
    "mappings" : {
        "my_type" : {
            "numeric_detection": true
        }
    }
}
```
* date - standard format - yyyy/MM/dd HH:mm:ss  
    set date_detection:true
    if set to false, standard format will not work. 

* explicit mapping for index  
set up settings also
```
PUT http://localhost:9200/books  
{
    "settings" : {
        "number_of_shards" : 1, -- only at index creation.
        "number_of_replicas" : 0
    },
    "dynamic":"strict", -- new fields are accepted when true. false means no new fields can be accepted. strict means exception thrown.
    "mappings":{
        "fiction":{
            "properties":{
                "title":{"type":"text"},
                "author":{"type":"text"},
                "available":{"type":"boolean"},
                "pages":{"type":"integer"},
                "cost":{"type":"float"},
                "published":{"type":"date","format":"YYYY-MM-DD"}
            }
        }
    }
}
```

-- **_all** = all fields are concatenated and kept in one place.   
This helps in searching all fields without worrying about which field has that data.
```
http://localhost:9200/movies  
{
    "mappings":{
        "fiction":{
            "_source":{
                "enabled":false
            },
            "_all": {
                "enabled": false
            },
            "properties":{
                "title":{"type":"text"},
                "director":{"type":"text"},
                "actors":{"type":"object"},
                "released":{
                    "type":"date",
                    "format":"YYYY-MM-DD"
                }
            }
        }
    }
}
```

**match_mapping_type**
use this for defining mapping templates

example, below we are telling ES that numbers should be integers ( not long )  
and strings should be "text" ( not both text and keyword )  

PUT localhost:9200/index_one  
```json
{
  "mappings":{
    "type_one":{
      "dynamic_templates":[
        {
          "integers":{
          "match_mapping_type":"long",
          "mapping": { "type":"integer"}
          }
        },
        {
          "strings":{
                    "match_mapping_type":"string",
                    "mapping": { "type":"text"}
          }
        }
      ],
      "properties": {
        "full_name":{
          "type":"text",
          "fields": {"keyword":{"type":"keyword","ignore_above":256}}
        },
        "name":{
          "properties":{
            "first":{"type":"text", "copy_to":["full_name "]},
            "last":{"type":"text", "copy_to":["full_name "]},
            "middle":{"type":"text"},"fields":{"keyword":{"type":"keyword","ignore_above":256}}
          }
        }
      }
    }
  }
}
```
 
**copy field**  
refer full name above  


=================================================================
**CLuster status**  

Yellow - some replicates may not be available.  
Red - some shards not available. cluster not fully functional. need attn. asap.

**Commands**

PUT - Create and Update - Idempotent   
POST - only Update   - Not Idempotent  

http://localhost:9200/_cat/indices?v&pretty  
http://localhost:9200/_cat/nodes?v&pretty  
http://localhost:9200/_cat/health?v&pretty  

** Create index:**    
PUT 
http://localhost:9200/products?&pretty  
http://localhost:9200/customers?&pretty  
http://localhost:9200/orders?&pretty    

Add Objects
PUT 
http://localhost:9200/products/mobiles/1?&pretty
http://localhost:9200/products/laptops/1
http://localhost:9200/products/shoes/1
{ json product1 }  

Get Objects  
GET http://localhost:9200/products/mobiles/1  

Object existence without details.  
GET http://localhost:9200/products/mobiles/1?_source=false
OUTPUT:  
```json
{
    "_index": "products",
    "_type": "mobiles",
    "_id": "1",
    "_version": 4,
    "found": true
}
```

Object with limited details.  
GET http://localhost:9200/products/mobiles/1?_source=name,reviews
OUTPUT:  
```json
{
    "_index": "products",
    "_type": "mobiles",
    "_id": "1",
    "_version": 4,
    "found": true
}
```

Updates  
Whole document - just PUT again with whole doc. _version will be updated to next number  

Use POST for partial update

POST 
http://localhost:9200/products/mobiles/1/_update
```json
{
    "doc" : {
      "color": "black"
    }
}
```

Update for integer using *script*  

POST
http://localhost:9200/products/shoes/1/_update
{
    "script": "ctx._source.size += 2"
}

*Deleting Documents/Index*  
Use DELETE requests  

Deleting object:  
DELETE  
http://localhost:9200/products/shoes/1  

http://localhost:9200/products/shoes  

**Multiple documents**

*_mget*  
POST http://localhost:9200/_mget  
<query multiple docs>

or move common components to parameters
http://localhost:9200/_mget?index=products&type=laptops
```
{   "docs": [     
    {      "_id" : "1"     }, 
    {      "_id" : "2"    }
  ]
}
```


*_bulk*
POST http://localhost:9200/_bulk
<bulk insert documents>

**BULK INDEXING**  

<buld indexing doc> -- ids will be auto generated  

## Query DSL

PUT http://localhost:9200/customers/personal/_bulk 
generated.json

*SEARCH*  
http://localhost:9200/customers/personal/_search?q=wyoming  
http://localhost:9200/customers/personal/_search?q=wyoming&sort=age:desc  
http://localhost:9200/customers/personal/_search?q=state:wyoming&from=5&size=2
http://localhost:9200/customers/personal/_search?q=state:wyoming&from=5&size=2&explain

*SEARCH USING BODY*  
```
http://localhost:9200/customers/personal/_search
{
    "query": { "match_all" : {} } 
} 

http://localhost:9200/customers/personal/_search
{
    "query": { "match_all" : {} },
    "size": 3 
} 

http://localhost:9200/customers/personal/_search
{
    "query": { "match_all" : {} },
    "sort": { "age" : { "order" : "desc" } },
    "size": 3 
} 


http://localhost:9200/customers/personal/_search
{
    "query": { "term" : { "name": "gates"} }
} 
```
__term__ - search requires exact match for**   

*SEARCH USING SCORE*

Use boolean clause  
```
http://localhost:9200/customers/personal/_search
{
    "query" : {
        "bool" : {
            "must": { "match_all": {} },
            "filter" : {
                "range" : {
                    "age" : {
                        "gte":20,
                        "lte":30
                    }
                }
            }
        }
    }
}

http://localhost:9200/customers/personal/_search
{
    "query" : {
        "bool" : {
            "must": {  "match":  { "state": "alabama" } },
            "filter" : [
                { "term" : { "gender" : "female" } },
                { "range" : {  "age": { "gte" : "50" } } }
            ]
        }
    }
}
```
**AGGREGATIONS**

Metrics  
Bucketing  
Matrix - Experimental - confirm before use  
Pipeline Pipeline     
    
```
http://localhost:9200/customers/personal/_search
{
    "size" : 0, 
    "aggs" : {
        "avg_age" : {
            "avg" : {  
                "field": "age"
            }
        }
    }
}
```
-- size 0 means no docs are required. just the average.

metrics with filter:  
```
http://localhost:9200/customers/personal/_search
{
    "size" : 0,
    "query" : {
        "bool" : {
            "filter" : {
                "match" : { "state" : "minnesota" }
            }
        }
    }, 
    "aggs" : {
        "avg_age" : {
            "avg" : {  
                "field": "age"
            }
        }
    }
}
```
*More Statistics*  
```
http://localhost:9200/customers/personal/_search
{
    "size" : 0,
    "aggs" : {
        "age_stats" : {
            "stats" : {
                "field" : "age"
            }
        }
    }
}
```

*Cardinality*
```
http://localhost:9200/customers/personal/_search  
{
    "size": 100,
    "aggs": {
        "age_count" : {
            "cardinality" : {
                "field" : "state"
            }
        }
    }
}
```

**SEARCH vs AGGREGATION**

Search - inverted index of the terms present in documents  
the terms themselves can be hashed and stored in index  
question - which doc contains the string  

Aggregation - actual values of terms are needed. hash values donot suffice  
question - what is the value of the field in the documents  

Important - **fielddata**  
fielddata is build on demand when a field is used for aggregations, sorting etc.

ES constructs fielddata in lazy fashion.
Default - disbled for text fields.  

ENABLE fielddata 
note this is running for "personal" under customers index

```  
http://localhost:9200/customers/_mapping/personal    
{
    "size": 0,
    "aggs": {
        "gender_count" : {
            "cardinality" : {
                "field" : "gender"
            }
        }
    }
}
```

-- returns 2 as value in response  

BUCKETING - IS - GROUP BY CLAUSE  

gender bucket example

```  
http://localhost:9200/customers/_mapping/personal    
{
    "size": 0,
    "aggs": {
        "gender_bucket" : {
            "terms" : {
                "field" : "gender"
            }
        }
    }
}
```

Range based bucketing..
```  
http://localhost:9200/customers/_mapping/personal    
{
    "size": 0,
    "aggs": {
        "age_ranges" : {
            "range" : {
                "field" : "age",
                "ranges": [
                       {"to" : 30 },
                       {"from" : 30, "to" : 40 },
                       {"from" : 40, "to" : 55 },
                       {"from" : 55 }
                ]
            }
        }
    }
}
```


Use *keyed* in above query to get map response instead of Array  
```
http://localhost:9200/customers/_mapping/personal
{
    "size": 0,
    "aggs": {
        "age_ranges" : {
            "range" : {
                "field" : "age",
                "keyed" : true,
                "ranges": [
                       { "key": "young", "to" : 30 },
                       { "key": "qtr-aged", "from" : 30, "to" : 40 },
                       { "key": "middle-aged", "from" : 40, "to" : 55 },
                       { "key": "senior", "from" : 55 }
                ]
            }
        }
    }
}
```

*Bucketing and Aggregation*  
here - query for male/female average age

```    
http://localhost:9200/customers/_mapping/personal
{
    "size": 0,
    "aggs": {
        "gender_bucket" : {
                "terms" : { "field" : "gender" },
                "aggs" : { "average_age" : { "avg" : {"field":"age"} } }
        }
    }
}
```


bucket on gender, then age, and then find average age

```  
http://localhost:9200/customers/_mapping/personal
{
	"size": 0,
	"aggs": {
    	"gender_bucket" : {
        	"terms" : { 
        		"field" : "gender" 
        	},
        	"aggs" : {
            	"age_ranges": {
            		"range":{
            			"field":"age",
            			"keyed":true, 
            			"ranges": [
            				{"key":"Young","to" : 30 },
            				{"key":"Old","from" : 30 }
            			]
            		}, 
            		"aggs":{
            			"average_age" : { 
            				"avg" : {
            					"field":"age"
            				} 
            			} 
            		}
            	}
        	}
		}
	}
}
```

MULTIPLE FILTERS
```
http://localhost:9200/customers/_mapping/personal
{
	"size": 0,
	"aggs": {
    	"states" : {
        	"filters" : {
        	    "filters" : {
        	        "w" : {"match" :{"state":"washington"}},
        	        "n" : {"match" :{"state":"north carolina"}},
        	        "s" : {"match" :{"state":"south carolina"}}
        	    }
        	}
		}
	}
}
```
