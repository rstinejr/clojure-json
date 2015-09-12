(ns json-reader.core
  (:require [clojure.java.io]))

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
