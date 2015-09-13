# clojure-json
## Practice Clojure interop with the Jackson JSON reader

To kick the tires: clone this project, then run ```lein test```

One of the test routines parses file  [sample.jason](https://github.com/rstinejr/clojure-json/blob/master/resources/sample.json)

At this point, expected output is:
```
lein test json-reader.core-test
token: START_OBJECT
token: FIELD_NAME
token: START_OBJECT
token: FIELD_NAME
token: VALUE_STRING
token: FIELD_NAME
token: VALUE_STRING
token: FIELD_NAME
token: VALUE_NUMBER_INT
token: FIELD_NAME
token: START_OBJECT
token: FIELD_NAME
token: VALUE_STRING
token: FIELD_NAME
token: VALUE_STRING
token: FIELD_NAME
token: VALUE_STRING
token: FIELD_NAME
token: VALUE_STRING
token: END_OBJECT
token: FIELD_NAME
token: START_ARRAY
token: START_OBJECT
token: FIELD_NAME
token: VALUE_STRING
token: FIELD_NAME
token: VALUE_STRING
token: END_OBJECT
token: START_OBJECT
token: FIELD_NAME
token: VALUE_STRING
token: FIELD_NAME
token: VALUE_STRING
token: END_OBJECT
token: END_ARRAY
token: FIELD_NAME
token: START_OBJECT
token: FIELD_NAME
token: VALUE_STRING
token: END_OBJECT
token: END_OBJECT
token: END_OBJECT

Ran 2 tests containing 3 assertions.
0 failures, 0 errors.
```
