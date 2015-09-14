(ns sparky.core-test
  (:require [clojure.core.async :as async] 
            [clojure.test       :refer :all]
            [sparky.core        :refer :all]))

(def json-src-file "resources/sample.json")

(deftest missing-file-test
  (testing "missing file test"
    (is (thrown? Exception (file-to-stream "no-such-file.lala")))))

(deftest token-tests
  (testing "smoke test: get channel"
    (let [token-ch (start-parser (file-to-stream json-src-file))]
      (loop [token (async/<!! token-ch)]
        (if token
          (recur (async/<!! token-ch))))
      (is true))))
