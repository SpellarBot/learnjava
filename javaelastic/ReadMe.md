##########################################################################################
# General Notes
##########################################################################################   

## ES - System Level Information
### Key Points
* Underlying engine is Lucene.  
* Distributed - scales to thousands of nodes
* High AVailability - Multiple copies of data
* Restful api
* Powerful Query DSL - complex queries expressed simply
* Schemaless - Index data without an explicit schema

* Basic element - Document  
* Documents are part of Index  
* Index are kept in Shards  
* Shards are kept in nodes/servers aka cluster  
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
* ES is easy to scale horizontally.  
* ES allows more clusters to the servers for better load balancing. 

_Case 1 node:_   
Node1: Sh1 Sh2 Sh3 Sh4

_Case 2 nodes:_   
Node1: Sh1 Sh2  
Node2: Sh3 Sh4


**System Commands**

PUT - Create and Update - Idempotent   
POST - only Update   - Not Idempotent  

http://localhost:9200/_cat/indices?v&pretty  
http://localhost:9200/_cat/nodes?v&pretty  
http://localhost:9200/_cat/health?v&pretty  
http://localhost:9200/_cluster/state?v&pretty

    CLuster status:  
    Yellow - some replicates may not be available.  
    Red - some shards not available. cluster not fully functional. need attn. asap.


## ES - Data leve basics  
* tokenize text into words  
* remove punctuation  
* note frequency of each word  
* inverted index is then made that tells each document containing the word  
    ```text
        example:  
        Winter - 1 - Doc1  
        is - 2 - Doc1, Doc2  
        coming - 1 - Doc1  
        ours - 1 - Doc2  
        the - 1 - Doc2  
        ...and so on..  
    ```
This inverted index is called postings list in **technical terms**.  

more complicated searches like find words ending with _ing_   
in this case you can reverse the words and save in the inverted index..   
then search with words that have _gni_ i.e. reverse of search string _ing_..    

For sub-string searches, break each word in n-grams and save in the inverted index.    

Yours will be saved with yo, you, our, ours, urs, etc..  
and then use for substring matches..

geo-hashes from longitude and latitude are used for geographical search  
metaphone for phonetic matching  
"Did you mean?" searches use a Levenshtein automation.  

### reference
json-generator.com

* TF/IDF Relevance
* TF - Term Frequency - How often does the term appear in the field
* IDF - Inverse Document frequency - How often does the term appear in the index
* Field length norm - How long is the field which was searched.

##########################################################################################
# FIELDS and MAPPINGS
##########################################################################################
**Field Datatypes**  
Regular Data Types: Text, keyword, date, long, double, boolean, ip
Hierarchical: object, nested    
Specialized: geo_point, geo_shape, completion    

**Search Notes**  
* **full text search** - individual tokens in string are searchable.
* **keyword search** - whole string values are searchable. 
* 5.0 onwards - all strings are indexed by default.
* Caution - Mappings can be updated only at the time of index creating. And can't be edited later on.
* **Edit Mapping**  - can be done while adding new field. Editing existing fields is not allowed.    
* To see mappings in an index, use **_mapping**

### Sample : Adding integer data type to index  

http://localhost:9200/customers/_mapping/personal
```json
{
    "properties": {
        "customerSince": {
            "type": "integer"
        }
    }
}

```

**Dynamic Mapping** - ES will guess the type when no right type given. 
Mapping - how data is stored and hence impacts search performance.  

By default, when a previously unseen field is found in a document, Elasticsearch will add the new field to the type mapping. 
This behaviour can be disabled, both at the document and at the object level, by setting the dynamic parameter to **false** 
(to ignore new fields) or to **strict** (to throw an exception if an unknown field is encountered).

Sample : Adding integer data type using **Dynamic field mapping**  
-> Don't put integers in quotes. Set numeric detection to true for the index

### Sample : For index - department, doctype departmentage, turn on numeric_detection 
PUT http://localhost:9200/department
```json
{
    "mappings" : {
        "departmentage" : {
            "numeric_detection": true
        }
    }
}
```
### Sample : Explicit mapping of field data types for an index   
Here setting up index - books, doctype - fiction and specifying type of data that will be posted for the object.  

PUT http://localhost:9200/books
```
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

### Sample : Explicit mapping for searching all fields in an index - doctype.
Mapping name -  _all    
This helps in searching all fields without worrying about which field has that data.

PUT http://localhost:9200/movies
```json
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

### Sample : Explicit mapping to specify what data types to use for numbers, text
keyword : **match_mapping_type**

index - index_one  
doctype - type_one  

Below we are telling ES that numbers should be integers ( not long )  
and strings should be "text" ( not both text and keyword )  

PUT localhost:9200/index_one  
```json
{
  "mappings":{
    "type_one":{
      "dynamic_templates":[
        {"integers":{ "match_mapping_type":"long","mapping": { "type":"integer"} } },
        { "strings":{ "match_mapping_type":"string", "mapping": { "type":"text"} }}
      ],
      "properties": {
        "full_name":{ "type":"text", 
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

### Sample : mapping to create a field from other fields. 
**copy field**  
refer full name above which is getting its values from name field  

##########################################################################################
# ADD DATA 
##########################################################################################

### Sample : create index    
PUT http://localhost:9200/products?&pretty  
PUT http://localhost:9200/customers?&pretty  
PUT http://localhost:9200/orders?&pretty    

### Sample : Add Object
PUT http://localhost:9200/products/mobiles/1?&pretty
PUT http://localhost:9200/products/laptops/1
PUT http://localhost:9200/products/shoes/1
```json
{
  "name": "Macbook Pro",
  "storage": "500GB",
  "RAM" : "8GB",
  "display": "5inch",
  "os": "El Capitan",
  "reviews": ["bulky but great", "large storage cap is great"]
}
```  

### Sample : Bulk insert data using _bulk
POST http://localhost:9200/_bulk
```json
{  "index": {    "_index": "products",    "_type": "laptops",    "_id": "1"  }}
{  "name": "Macbook Pro",  "storage": "500GB",  "RAM": "8GB",  "display": "5inch",  "os": "El Capitan",  "reviews": [    "bulky but great",    "large storage cap is great"  ]}
{  "index": {    "_index": "products",    "_type": "laptops",    "_id": "2"  }}
{  "name": "Dell",  "storage": "1TB",  "RAM": "8GB",  "display": "14inch",  "os": "Win10",  "reviews": [    "Good for its price",    "Great processing power"  ]}
{  "index": {    "_index": "products",    "_type": "mobiles",    "_id": "1"  }}
{  "name": "iPhone SE",  "camera": "12MP",  "storage": "32GB",  "display": "5inch",  "battery": "1960mAh",  "reviews": ["great phone", "good even in 2018"]}
{  "index": {    "_index": "products",    "_type": "mobiles",    "_id": "2"  }}
{  "name": "Samsung Galaxy",  "camera": "8MP",  "storage": "64GB",  "display": "5.2inch",  "battery": "1500mAh",  "reviews": ["Best Android Phone", "Loving it"]}
{  "index": {    "_index": "products",    "_type": "mobiles",    "_id": "3"  }}
{  "name": "Xaomi Note",  "camera": "10MP",  "storage": "128GB",  "display": "5.5inch",  "battery": "1500mAh",  "reviews": ["Too large", "Battery life issues", "Economical Android phone"]}
{  "index": {    "_index": "products",    "_type": "shoes",    "_id": "1"  }}
{  "name": "Nike",  "size": 8,  "color": "white"}
{  "index": {    "_index": "products",    "_type": "shoes",    "_id": "2"  }}
{  "name": "Adidas",  "size": 9,  "color": "black"}
```

### Sample - bulk insert data using _bulk command
PUT http://localhost:9200/customers/personal/_bulk 
Refere file - generated.json

### Sample - adding objects using nested posting
Example - post a blog, along with user information. Here user information is repeated for each blog 
but thats what ES recommends to keep search and selection fast.

PUT http://localhost:9200/index_posts/blogs/1
```json
{
  "title":"FacFictions",
  "date":"2016-04-18",
  "user":{
    "id":"1",
    "name": "James"
  }
}
```


##########################################################################################
# EDIT DATA 
##########################################################################################

### Sample : Use POST with _update for partial update
note the "doc" keyword   
POST http://localhost:9200/products/mobiles/1/_update
```json
{
    "doc" : {
      "color": "black"
    }
}
```

### Sample :  Update integer values using run time calculations/scripts  
POST http://localhost:9200/products/shoes/1/_update
```json
{
    "script": "ctx._source.size += 2"
}
```

##########################################################################################
# DELETE DATA 
##########################################################################################

### Sample : Deleting object using object id  
DELETE http://localhost:9200/products/shoes/1  



##########################################################################################
# GET DATA USING IDs - This is not search. you know what you are fetching
##########################################################################################

### Sample : Basic select . Get any Object using id  
    GET http://localhost:9200/products/mobiles/1  
 
### Sanple - Object existence without getting details by using _source=false in the GET call   
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

### Sample - Getting Object with limited details by using _source in GET call  
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

### Sample : query multiple documents using *_mget*  

POST http://localhost:9200/_mget
```json
{
  "docs": [
    {
      "_index": "products",
      "_type" : "laptops",
      "_id" : "1"
    },
    {
      "_index": "products",
      "_type" : "laptops",
      "_id" : "2"
    }
  ]
}
```
  
Note - keep common components to parameters or move them to json. here index and doc type is part of URL  
POST http://localhost:9200/_mget?index=products&type=laptops
```json
{   "docs": [     
    {      "_id" : "1"     }, 
    {      "_id" : "2"    }
  ]
}
```


##########################################################################################
# SEARCH (not GET) - Using various searching functionalities provided by ES
##########################################################################################


### Sample : Basic Search by passing parameters in URL
* search using query parameter 
http://localhost:9200/customers/personal/_search?q=wyoming   
* search using query parameter and give sort order for result set
http://localhost:9200/customers/personal/_search?q=wyoming&sort=age:desc  
* pagination - search using query parameter and ask to return only specific number of objects from certain location 
http://localhost:9200/customers/personal/_search?q=state:wyoming&from=5&size=2
* pagination - same as above - but explore internal logic - Only for Deep understanding of ES
http://localhost:9200/customers/personal/_search?q=state:wyoming&from=5&size=2&explain

### Sample : Basic Search by passing query parameters in body
* basic search for getting all docs
http://localhost:9200/customers/personal/_search   
```json
{
    "query": { "match_all" : {} } 
} 
```
* basic search for getting limited result set size
http://localhost:9200/customers/personal/_search   
```json
{
    "query": { "match_all" : {} },
    "size": 3 
} 
```
* basic search - limited size, output is sorted.
http://localhost:9200/customers/personal/_search   
```json
{
    "query": { "match_all" : {} },
    "sort": { "age" : { "order" : "desc" } },
    "size": 3 
} 
```

### Sample - select data using field 
POST http://localhost:9200/index_posts/blogs/_search
```json
{
	"query":{
		"match": {"user.name":"James"}
	}
}
```

### Sample : Search using "_term". ie. exact string match for give property.
Search objects where name contains gates.
POST http://localhost:9200/customers/personal/_search
```json
{
    "query": { "term" : { "name": "gates"} }
} 
```

### Sample : Use boolean clause
bool - uses must, filter, should, must_not  
* must - match is mandatory
* filter - applies criteria on output
* should - if must is present, should does not matter but influences the score. if no must clause, then should is used.
* must_not - result set data is filtered out using this

POST someurl   
```json
{
  "query": {
    "bool" : {
      "must" : {
        "term" : { "user" : "kimchy" }
      },
      "filter": {
        "term" : { "tag" : "tech" }
      },
      "must_not" : {
        "range" : {
          "age" : { "gte" : 10, "lte" : 20 }
        }
      },
      "should" : [
        { "term" : { "tag" : "wow" } },
        { "term" : { "tag" : "elasticsearch" } }
      ],
      "minimum_should_match" : 1,
      "boost" : 1.0
    }
  }
}
```

More examples:   

POST http://localhost:9200/customers/personal/_search
```json
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
```

POST http://localhost:9200/customers/personal/_search
```json
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


############## END #######################
##########################################################################################
# AGGREGATIONS
##########################################################################################

**SEARCH vs AGGREGATION**

Search - inverted index of the terms present in documents  
the terms themselves can be hashed and stored in index  
question - which doc contains the string  

Aggregation - actual values of terms are needed. hash values donot suffice  
question - what is the value of the field in the documents  

Important - **fielddata**  
fielddata is build on demand when a field is used for aggregations, sorting etc.

ES constructs fielddata in lazy fashion.
Default - disabled for text fields.  

AGGREGATIONS: 
* Metrics. 
* Bucketing  
* Matrix - Experimental - confirm before use  
* Pipeline Pipeline     

### Sample : get average for a field on complete index
POST http://localhost:9200/customers/personal/_search     
```json
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
_Note - size 0 means no docs are required. just the average._

### Sample : get average for a field for any result set using a filter
  
POST http://localhost:9200/customers/personal/_search
```json
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

### Sample : Getting complete set of Statistics  
http://localhost:9200/customers/personal/_search
```json
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

### Sample : Cardinality : A single-value metrics aggregation that calculates an approximate count of distinct values.
POST http://localhost:9200/customers/personal/_search  
```json
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
_note - this only retuns gender_count value as 2 ( male and female ), and not actual values of gender._  


##########################################################################################
# BUCKETING - IS - GROUP BY CLAUSE - using terms, range
##########################################################################################

### Sample - gender bucket example

POST http://localhost:9200/customers/_mapping/personal    
```json
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
RESULT : values of genders along without counts  
```json
{ 
  "buckets": [
                {"key": "female","doc_count": 500},
                {"key": "male","doc_count": 499}
            ]
}
```

### Sample - Range based bucketing..
POST http://localhost:9200/customers/_mapping/personal    
```json
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
RESULT:  
```json
{"age_ranges": {
  "buckets": [  
    {"key": "*-30.0","to": 30,"doc_count": 227},
    {"key": "30.0-40.0","from": 30,"to": 40,"doc_count": 150},
    {"key": "40.0-55.0","from": 40,"to": 55,"doc_count": 209},
    {"key": "55.0-*","from": 55,"doc_count": 417} 
  ]
  }
}
```

### Sample - Range based bucketing with MAP response
Use *keyed* in above query to get map response instead of Array    
POST http://localhost:9200/customers/_mapping/personal
```json
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
RESULT:  
```json
{
"age_ranges": {
  "buckets": {
    "young": {"to": 30,"doc_count": 227},
    "qtr-aged": {"from": 30,"to": 40,"doc_count": 150},
    "middle-aged": {"from": 40,"to": 55,"doc_count": 209},
    "senior": {"from": 55,"doc_count": 417}
  }
}
}
```

### Sample - Bucketing and then Aggregation
Example - query for male/female average age
POST http://localhost:9200/customers/_mapping/personal
```json
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
RESULT:  
```json
{"buckets": [
                {"key": "female","doc_count": 500,"average_age": {"value": 48.54}},
                {"key": "male","doc_count": 499,"average_age": {"value": 47.44488977955912}}
]}
```

### Sample - Bucketing on gender, then bucket on age, and then Aggregate data to see average age

POST http://localhost:9200/customers/_mapping/personal
```json
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
RESULT:  
```json
{"buckets": [
 {"key": "female","doc_count": 500,
    "age_ranges": {
      "buckets": {
        "Young": {"to": 30,"doc_count": 119,"average_age": {"value": 22.3781512605042}},
        "Old": {"from": 30,"doc_count": 381,"average_age": {"value": 56.71128608923885}}
        }
      }
    },
  {"key": "male","doc_count": 499,
    "age_ranges": {
      "buckets": {
        "Young": {"to": 30,"doc_count": 106,"average_age": {"value": 22.264150943396228}},
        "Old": {"from": 30,"doc_count": 393,"average_age": {"value": 54.23664122137404}}
        }
      }
    }
    ]
}
```

### Sample - bucketing using aggs and filters.

http://localhost:9200/customers/_mapping/personal
```json
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
RESULT:  
```json
{"aggregations": {
        "states": {
            "buckets": {
                "n": {"doc_count": 53},
                "s": {"doc_count": 52},
                "w": {"doc_count": 18}
            }
        }
    }
}
```

=================

### Sample - Posting nested objects - incorrect and correctly

Caution - Nested Mapping - has to be enabled otherwise ES rearranges data and object information is lost.  

Wrong Way: here data will get messed up   
PUT http://localhost:9200/userfan/fans/1
```json
{
  "group" : "fans",
  "user" : [    
    {"first" : "John", "last" :  "Smith"},
    {"first" : "Alice","last" :  "White"}
  ]
}
```
will be stored with flattened array data:
```json
{
  "group" :        "fans",
  "user.first" : [ "alice", "john" ],
  "user.last" :  [ "smith", "white" ]
}
```

Right Way: Using nested clause when index is created.
PUT http://localhost:9200/userfan 
```json
{
  "mappings":{
    "fans":{
      "properties":{
        "user":{
          "type":"nested"
        }
      }
    }
  }
}
```

POST DATA:  
PUT http://localhost:9200/userfan/fans/1
```json
{
  "group" : "fans",
  "user" : [
    {
      "first" : "John",
      "last" :  "Smith"
    },
    {
      "first" : "Alice",
      "last" :  "White"
    }
  ]
}
```

Try Searches - Alice Smith (no match) and Alice White ( rec matches):  
POST http://localhost:9200/userfan/_search
```json
{
  "query": {
    "nested": {
      "path": "user",
      "query": {
        "bool": {
          "must": [
            { "match": { "user.first": "Alice" }},
            { "match": { "user.last":  "Smith" }} 
          ]
        }
      }
    }
  }
}
```

### Note - parent child data in Elastic search - slow and not recommended.
Notes:    
* Parent can be updated without reindexing the children  
* children can be added, removed and changed without affecting the parent  
* Can query for the children of a particular parent.  
* Parent - child should be on same shard.
* ( index is split into shards. so docs live on different machines on the shards.)
* slow performance as compared to regular flat data.  
* one join per index
* one parent per child

keywords: **join**  , **has_parent**, **has_child**  

##########################################################################################
# DESIGNING FOR SCALE
##########################################################################################   

### Sample - Create index alias with routing param

POST http://localhost:9200/userfan/_alias/indiafans
```json
{
  "routing":"indiafans",
  "filter":{
    "term":{
      "fanregion":"india"
    }
  }
}
```

to post data - 
POST http://localhost:9200/indiafans/fan/1
...
Here based upon fanregion, data will be filtered and routing use.  
Routing value - generates hash - routes to particular shard.  
so all indiafans data will go to one shard. This will improve performance when searching data.  

### Managing replicas..
at time of creation:

PUT http://localhost:9200/books
```json
{
  "settings":{
    "number_of_shards":1,
    "number_of_replicas":0
  },
  "mappings":{
    // rest of the stuff
  }
}
```

change later:
PUT http://localhost:9200/books/_settings
```json
{
  "index":{
    "number_of_replicas":2
  }
}
```
Even better-   
PUT http://localhost:9200/books/_settings
```json
{
  "index":{
    "auto_expand_replicas":"0-all"
  }
}
```

### Split Brain scenario
When multiple nodes believe themselves to be the master is called split brain scenario.  
This can happen if due to some issue nodes lose connection to other nodes and thinks that it now needs to act as master.  

### ES COnfiguration
Documents in the index should split across multiple nodes/servers in a Cluster.
This is called Shard. 

By default ES creates 5 shards for any index.  

* Specifying number of shards - only at time of index creation
* Specifying number of replicas - dynamic. can be changed anytime.

For Every shard to lie on different node :  
num_nodes = num_shards * ( num_replicas + 1 )
so if you want 5 shards, each having 1 replica, then as per formula num_nodes = 10  

Sample create index:  
PUT localhost:9200/my_sample_index
```json
{
  "settings":{
    "number_of_shards": 2,
    "number_of_replicas": 0
  }
}
```


1 Shard would translate to 1 Lucene index.  

#### ES Config - Routing

You can route documents to a shard and restrict searches to hit certain shards.  

Example - add a document using routing:   
PUT localhost:9200/books_index/docs/1?routing=A
```json
{
  "name": "book-1"
}
```

Example - bulk insertion with routing:
PUT localhost:9200/books_index/docs/_bulk  
```json
{ "index": [ "_id" : "2", "_routing" : "A"] }
{ "name": "book-2" }
{ "index": [ "_id" : "3", "_routing" : "B"] }
{ "name": "book-3" }
{ "index": [ "_id" : "4", "_routing" : "A"] }
{ "name": "book-4" }
```

Example - search docs using routing:   
Here search will fetch all docs from only 1 shard ( route=A)  
POST localhost:9200/books_index/docs/_search?q=*&routing=A
```json
{
  "query": {
    "match_all":{}
  }
}
```

Example - set up routing based index  
Create aliases for routing. Here use these to add / search docs on index - alias1/2

POST localhost:9200/_aliases
```json
{
  "actions" : [
    { "add" : { "index" : "books_index", "alias" : "alias1", "routing" : "A" } },
    { "add" : { "index" : "books_index", "alias" : "alias2", "routing" : "B" } }
  ]
}
```

Example - routing - search and add  
POST localhost:9200/_aliases
```json
{
  "actions" : [
    { "add" : { "index" : "books_index", 
                "alias" : "alias3", 
                "search_routing" : "A",
                 "index_routing" : "B"
              } 
    }
  ]
}
```

Example - routing - remove command    
POST localhost:9200/_aliases
```json
{
  "actions" : [
    { "remove" : { "index" : "books_index", "alias" : "alias1", "routing" : "A" } },
    { "remove" : { "index" : "books_index", "alias" : "alias2", "routing" : "B" } },
    { "remove" : { "index" : "books_index", "alias" : "alias3", "routing" : "C" } }
  ]
}
```

Example - search preference for shard  

POST localhost:9200/randomindex/_search?preference=_shards:0
```json
{
  "query": {
    "match_all":{}
  }
}
```

Elastic search uses TF/IDF for search.  
**Term Frequency / Inverse Document Frequency**  

* Term Frequency - How often does the term appear in the field ?  
* Inverse Document Frequency - How often does the term appear in the index.  
* Field length norm - How long is the Field which was searched ?

Similarity MOdels for searches:  
* Okapi BM25 ( from ES 6 onwards )
* Classic TF/IDF ( before ES 6 )
* boolean   

Check Similarity model:  
PUT localhost:9200/index
```json
{
"settings" : {
  "index" : {
    "similarity" : {
      "default" : {
        "type" : "BM25"
      }
    }
  }
}
}
```


* similarity model can be per field.  

=================

Customize similarity models are possible using "similarity" option.
```json
{
  "settings":{
    "index":{
      "similarity": {
        //.....rest of the stuff.....
      }
    }
  }
}
```

Analyzer - pre processor of data .
synonym analyzer - add synonyms for specific terms for the data begin added.

discount_overlaps - what is this ?

Merging Segments:
when creating index, give option in index creation call - 
"index.merge.policy.expunge_deletes_allowed" : 1


To see segments:
GET localhost:9200/sample_index/_segments
shows lucene indexes

to see segments, another command to show high level information is :
GET localhost:9200/_cat/segments.
This shows generation information, that tells how old a segment is.
committed - false - means - not flushed to disk. 

 

Add analyzer for preprocessing of data. example - adding synonyms for a word while saving the document.  

 Force merging of segments :
 
 POST localhost:9200/sample_index/_forcemerge?max_num_segments=1
 {
     "only_expunge_deletes" : "false",
     "flush": "false"
 }
 flush=false means flush the index once the merge is done. flushing will get rid of caches associated with the index.
 max_num_segments=1 - number of segments per shard to merge to - set 1 to fully merge the index. default will check if merge is needed or not.
 only_expunge_deletes = false means - only merge those segments that have deleted documents.
 
========
Caching: turned off by default  

To turn on caching for certain queries - 

POST localhost:9200/_search?request_cache=true
```json
{
"query":{
  "match" : {"name":"John Smith"}
}
}
```

to see cache getting used  
GET localhost:9200/_stats/request_cache   
look for **memory_size** in result set showing cache size.  

TO Enable Cache for Index:   

PUT localhost:9200/index_one
```json
{
  "settings" :{
    "index.requests.cache.enable":"false"
  },
  "mappings":{
    "type_one":{
      "properties":{
        "status":{
          "type":"keyword"
        }
      }
    }
  }
}
```

**Check cache size**  
GET localhost:9200/_nodes/stats/indices/query_cache  

### Analyzers

Character filters:   
Clean up the strings. remove html. convert & etc.

Tokenizer:  
Split into individual terms , break  on white space, punctuation

Token Filters:  
change , add , remove terms. Lowercase all words. add synonym. Remove stopwords (a, the, in , on etc.). 


### TERM and MATCH QUERIES
TERM - 
* looks for exact term in inverted index.
* does not know the presence of the analyzer.
* great for keywords, numbers, dates, where exact matches are important.
* less likely to match irrelevant documents.     

MATCH - 
* queries are analyzed before looking up the inverted index.
* understands how the fields have been analyzed. 
* useful when searching full text fields with a large body of text. 
* more like to match irrelevant documents. 
* does not go through query parsing process, does not match wild cards, prefixes etc.
