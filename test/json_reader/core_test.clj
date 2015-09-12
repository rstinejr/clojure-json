(ns json-reader.core-test
  (:require [clojure.test :refer :all]
            [json-reader.core :refer :all]))

(def json-src-file "resources/sample.json")

(deftest file-tests
  (testing "Open, close json file reader"
    (let [rdr (open-reader json-src-file)]
      (close-reader rdr)
      (is true)))
  (testing "missing file test"
    (is (thrown? Exception (open-reader "no-such-file.lala")))))
