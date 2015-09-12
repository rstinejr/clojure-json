(ns json-reader.core
  (:require [clojure.core.async :as async]
            [clojure.java.io]))

(defn open-reader
  "given a file name, return a reader."
  [json-src]
  (let [file (clojure.java.io/file json-src)]
    (when (not (.isFile file))
      (throw (ex-info (str "JSON source file '" json-src "' not found.") {:causes #{:file-not-found}})))
    (let [factory (com.fasterxml.jackson.core.JsonFactory.)]
      (.createParser factory file))))

(defn close-reader
  [json-rdr]
  (.close json-rdr))

(defn start-parser
  "Kick off a go-block to parses a JSON file."
  [json-src]
  (let [rdr        (open-reader json-src)
        token-chan (async/chan)]
    (async/go-loop [token (.nextToken rdr)]
       (async/close! token-chan)
       (close-reader rdr))

    token-chan))
