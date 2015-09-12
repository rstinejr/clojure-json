(ns json-reader.core-test
  (:require [clojure.test :refer :all]
            [json-reader.core :refer :all]))

(def json-src-file "resources/sample.json")

(deftest file-tests
  (testing "found file test"
    (let [f (open-reader json-src-file)]
      (is true)))
  (testing "missing file test"
    (is (thrown? Exception (open-reader "no-such-file.lala")))))
