(ns json-reader.core-test
  (:require [clojure.core.async :as async] 
            [clojure.test       :refer :all]
            [json-reader.core   :refer :all]))

(def json-src-file "resources/sample.json")

(deftest file-tests
  (testing "Open, close json file reader"
    (let [rdr (open-reader json-src-file)]
      (close-reader rdr)
      (is true)))
  (testing "missing file test"
    (is (thrown? Exception (open-reader "no-such-file.lala")))))

(deftest token-tests
  (testing "smoke test: get channel"
    (let [token-ch (start-parser json-src-file)]
      (loop [token (async/<!! token-ch)]
        (if token
          (recur (async/<!! token-ch))))
      (is true))))
