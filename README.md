# clojure-json
## Implement a Clojure wrapper around the Jackson JSON Streaming Parser

To kick the tires: clone this project, then run ```lein test```

One of the test routines parses file  [sample.jason](https://github.com/rstinejr/clojure-json/blob/master/resources/sample.json)

At this point, expected output is:
```
lein test sparky.core-test
item: {:token :START_OBJECT, :name nil, :value nil}
item: {:token :FIELD_NAME, :name "toplevel", :value nil}
item: {:token :START_OBJECT, :name "toplevel", :value nil}
item: {:token :FIELD_NAME, :name "firstName", :value nil}
item: {:token :VALUE_STRING, :name "firstName", :value "John"}
item: {:token :FIELD_NAME, :name "lastName", :value nil}
item: {:token :VALUE_STRING, :name "lastName", :value "Smith"}
item: {:token :FIELD_NAME, :name "age", :value nil}
item: {:token :VALUE_NUMBER_INT, :name "age", :value 25}
item: {:token :FIELD_NAME, :name "reliability", :value nil}
item: {:token :VALUE_NUMBER_FLOAT, :name "reliability", :value 0.87}
item: {:token :FIELD_NAME, :name "military", :value nil}
item: {:token :VALUE_FALSE, :name "military", :value false}
item: {:token :FIELD_NAME, :name "dangerous", :value nil}
item: {:token :VALUE_TRUE, :name "dangerous", :value true}
item: {:token :FIELD_NAME, :name "longValue", :value nil}
item: {:token :VALUE_NUMBER_INT, :name "longValue", :value 2999999999}
item: {:token :FIELD_NAME, :name "doubleValue", :value nil}
item: {:token :VALUE_NUMBER_FLOAT, :name "doubleValue", :value 1.2345567781234567E9}
item: {:token :FIELD_NAME, :name "address", :value nil}
item: {:token :START_OBJECT, :name "address", :value nil}
item: {:token :FIELD_NAME, :name "streetAddress", :value nil}
item: {:token :VALUE_STRING, :name "streetAddress", :value "21 2nd Street"}
item: {:token :FIELD_NAME, :name "city", :value nil}
item: {:token :VALUE_STRING, :name "city", :value "New York"}
item: {:token :FIELD_NAME, :name "state", :value nil}
item: {:token :VALUE_STRING, :name "state", :value "NY"}
item: {:token :FIELD_NAME, :name "postalCode", :value nil}
item: {:token :VALUE_STRING, :name "postalCode", :value "10021"}
item: {:token :END_OBJECT, :name "address", :value nil}
item: {:token :FIELD_NAME, :name "phoneNumber", :value nil}
item: {:token :START_ARRAY, :name "phoneNumber", :value nil}
item: {:token :START_OBJECT, :name nil, :value nil}
item: {:token :FIELD_NAME, :name "type", :value nil}
item: {:token :VALUE_STRING, :name "type", :value "home"}
item: {:token :FIELD_NAME, :name "number", :value nil}
item: {:token :VALUE_STRING, :name "number", :value "212 555-1234"}
item: {:token :END_OBJECT, :name nil, :value nil}
item: {:token :START_OBJECT, :name nil, :value nil}
item: {:token :FIELD_NAME, :name "type", :value nil}
item: {:token :VALUE_STRING, :name "type", :value "fax"}
item: {:token :FIELD_NAME, :name "number", :value nil}
item: {:token :VALUE_STRING, :name "number", :value "646 555-4567"}
item: {:token :END_OBJECT, :name nil, :value nil}
item: {:token :END_ARRAY, :name "phoneNumber", :value nil}
item: {:token :FIELD_NAME, :name "gender", :value nil}
item: {:token :START_OBJECT, :name "gender", :value nil}
item: {:token :FIELD_NAME, :name "type", :value nil}
item: {:token :VALUE_STRING, :name "type", :value "male"}
item: {:token :END_OBJECT, :name "gender", :value nil}
item: {:token :END_OBJECT, :name "toplevel", :value nil}

Ran 2 tests containing 2 assertions.
0 failures, 0 errors.
```
