(ns json-reader.core
  (:require [clojure.java.io])
  (:gen-class))

(defn open-reader
  "given a file name, return a reader."
  [json-src]
  (let [file (clojure.java.io/file json-src)]
    (when (not (.isFile file))
      (throw (ex-info (str "JSON source file '" json-src "' not found.") {:causes #{:file-not-found}})))
    file))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
