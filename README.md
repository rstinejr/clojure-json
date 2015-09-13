# clojure-json
## Practice Clojure interop with the Jackson JSON reader

To kick the tires: clone this project, then run ```lein test```

One of the test routines parses file  [sample.jason](https://github.com/rstinejr/clojure-json/blob/master/resources/sample.json)

At this point, expected output is:
```
D:\dev\clojure\clojure-json>lein test

lein test json-reader.core-test
item: {:token "START_OBJECT", :name nil}
item: {:token "FIELD_NAME", :name "toplevel"}
item: {:token "START_OBJECT", :name "toplevel"}
item: {:token "FIELD_NAME", :name "firstName"}
item: {:token "VALUE_STRING", :name "firstName"}
item: {:token "FIELD_NAME", :name "lastName"}
item: {:token "VALUE_STRING", :name "lastName"}
item: {:token "FIELD_NAME", :name "age"}
item: {:token "VALUE_NUMBER_INT", :name "age"}
item: {:token "FIELD_NAME", :name "address"}
item: {:token "START_OBJECT", :name "address"}
item: {:token "FIELD_NAME", :name "streetAddress"}
item: {:token "VALUE_STRING", :name "streetAddress"}
item: {:token "FIELD_NAME", :name "city"}
item: {:token "VALUE_STRING", :name "city"}
item: {:token "FIELD_NAME", :name "state"}
item: {:token "VALUE_STRING", :name "state"}
item: {:token "FIELD_NAME", :name "postalCode"}
item: {:token "VALUE_STRING", :name "postalCode"}
item: {:token "END_OBJECT", :name "address"}
item: {:token "FIELD_NAME", :name "phoneNumber"}
item: {:token "START_ARRAY", :name "phoneNumber"}
item: {:token "START_OBJECT", :name nil}
item: {:token "FIELD_NAME", :name "type"}
item: {:token "VALUE_STRING", :name "type"}
item: {:token "FIELD_NAME", :name "number"}
item: {:token "VALUE_STRING", :name "number"}
item: {:token "END_OBJECT", :name nil}
item: {:token "START_OBJECT", :name nil}
item: {:token "FIELD_NAME", :name "type"}
item: {:token "VALUE_STRING", :name "type"}
item: {:token "FIELD_NAME", :name "number"}
item: {:token "VALUE_STRING", :name "number"}
item: {:token "END_OBJECT", :name nil}
item: {:token "END_ARRAY", :name "phoneNumber"}
item: {:token "FIELD_NAME", :name "gender"}
item: {:token "START_OBJECT", :name "gender"}
item: {:token "FIELD_NAME", :name "type"}
item: {:token "VALUE_STRING", :name "type"}
item: {:token "END_OBJECT", :name "gender"}
item: {:token "END_OBJECT", :name "toplevel"}
item: {:token "END_OBJECT", :name nil}

Ran 2 tests containing 3 assertions.
0 failures, 0 errors.
```
