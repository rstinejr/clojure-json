(ns sparky.core-test
  (:require [clojure.core.async :as async] 
            [clojure.test       :refer :all]
            [sparky.core        :refer :all]))

(def json-src-file "resources/sample.json")

(deftest file-tests
  (testing "Open, close json file parser"
    (let [jp (open-parser (file-to-stream json-src-file))]
      (close-parser jp)
      (is true)))
  (testing "missing file test"
    (is (thrown? Exception (file-to-stream "no-such-file.lala")))))

(deftest token-tests
  (testing "smoke test: get channel"
    (let [token-ch (start-parser (file-to-stream json-src-file))]
      (loop [token (async/<!! token-ch)]
        (if token
          (recur (async/<!! token-ch))))
      (is true))))
